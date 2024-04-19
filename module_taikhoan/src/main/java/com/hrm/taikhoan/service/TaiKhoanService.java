package com.hrm.taikhoan.service;

import com.hrm.taikhoan.client.auth_token.TokenClient;
import com.hrm.taikhoan.client.ho_so.HoSoClient;

import com.hrm.taikhoan.dto.mapper.MapperAuth;
import com.hrm.taikhoan.dto.mapper.MapperTaiKhoan;
import com.hrm.taikhoan.dto.request.ReqHoSo;
import com.hrm.taikhoan.dto.request.ReqTaiKhoan;
import com.hrm.taikhoan.dto.request.ReqTaiKhoanLogin;
import com.hrm.taikhoan.dto.resopnse.ResAuth;
import com.hrm.taikhoan.dto.resopnse.ResTaiKhoan;
import com.hrm.taikhoan.dto.resopnse.ResTaiKhoanLogin;

import com.hrm.taikhoan.enums.RoleTaiKhoan;

import com.hrm.taikhoan.jwt_token.JWTUtilities;
import com.hrm.taikhoan.kafka.HoSoProducer;
import com.hrm.taikhoan.models.TaiKhoan;

import com.hrm.taikhoan.repository.TaiKhoanRepository;
import com.hrm.taikhoan.response.ResEnum;

import jakarta.ws.rs.NotFoundException;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TaiKhoanService implements ITaiKhoanService {
    final JWTUtilities jwtUtilities;
    final TokenClient client;
    final TaiKhoanRepository taiKhoanRepository;
    final HoSoClient hoSoClient;
    //    final JavaMailSender javaMailSender;
//    final IAuthenticationFacade facade;
//    final KafkaProducers producers;
    //mappers
    final MapperAuth mapperAuth;
    final MapperTaiKhoan mapperTaiKhoan;
    final HoSoProducer hoSoProducer;

    /* ADMIN - ADMIN - ADMIN*/
    @Override
    public List<ResTaiKhoan> xemDanhSachTaiKhoan(String username, RoleTaiKhoan role, int pageNumber, int pageSize) {
        try {
            List<TaiKhoan> taiKhoans = new ArrayList<>();
            Pageable pageable = PageRequest.of(pageNumber, pageSize);
            taiKhoans = taiKhoanRepository.findAll(pageable).stream().toList();
            if (username != null && role == null) {
                taiKhoans = xemByUsername(username, pageable);
            }
            if (username == null && role != null) {
                taiKhoans = taiKhoanRepository.findAllByRoleTaiKhoan(role, pageable);
            }
            if(username !=null && role !=null){
                taiKhoans = taiKhoanRepository.findAllByRoleTaiKhoanAndUsername(role, username.toLowerCase(), pageable);
            }
            return taiKhoans.stream().map(mapperTaiKhoan::mapToResTaiKhoan).toList();
        } catch (RuntimeException e) {
            throw new RuntimeException(e.getCause());
        }
    }

    private List<TaiKhoan> xemByUsername(String number, Pageable pageable) {
        try {
            return taiKhoanRepository.findByUsernameContaining(number, pageable);
        } catch (RuntimeException e) {
            throw new RuntimeException(e.getCause());
        }
    }

    @Override
    public List<ResTaiKhoan> xemTheoUsername(String number, int pageNumber, int pageSize) {
        try {
            List<TaiKhoan> taiKhoans = taiKhoanRepository.findByUsernameContaining(number, PageRequest.of(pageNumber, pageSize));
            return taiKhoans.stream().map(mapperTaiKhoan::mapToResTaiKhoan).toList();
        } catch (RuntimeException e) {
            throw new RuntimeException(e.getCause());
        }
    }

    @Override
    public ResTaiKhoan xemTheoId(int id) {
        try {
            TaiKhoan taiKhoan = taiKhoanRepository.findById(id).orElseThrow(NotFoundException::new);
            return mapperTaiKhoan.mapToResTaiKhoan(taiKhoan);
        } catch (RuntimeException e) {
            throw new RuntimeException(e.getCause());
        }
    }

    @Override
    public ResTaiKhoan them(ReqTaiKhoan reqTaiKhoan) {
        TaiKhoan taiKhoan;
        UUID uuid = UUID.randomUUID();
        try {
            List<TaiKhoan> listUsername = taiKhoanRepository.findAll();
            //tạo username
            String hoVaTen = reqTaiKhoan.hoVaTen();
            String newUsername = ITaiKhoanService.createUsername(hoVaTen, listUsername);
            taiKhoan = TaiKhoan.builder()
                    .hoVaTen(reqTaiKhoan.hoVaTen())
                    .username(newUsername)
                    .password(reqTaiKhoan.soCCCD())
                    .email(reqTaiKhoan.email())
                    .roleTaiKhoan(RoleTaiKhoan.EMPLOYEE)
                    .trangThai(true)
                    .create_at(LocalDateTime.now())
                    .build();
            taiKhoanRepository.save(taiKhoan);
            ReqHoSo reqHoSo = new ReqHoSo(taiKhoan.getHoVaTen(), taiKhoan.getPassword(), taiKhoan.getId());
//            HoSoDTO hoSoDTO = hoSoClient.addHoSo(reqHoSo);
            // create the producer
            KafkaProducer<String, ReqHoSo> producer = new KafkaProducer<>(hoSoProducer.getProperties());
            // create a producer record
            ProducerRecord<String, ReqHoSo> producerRecord = new ProducerRecord<>("hoso_create", reqHoSo);
            // send data - asynchronous
            producer.send(producerRecord, new Callback() {
                @Override
                public void onCompletion(RecordMetadata metadata, Exception e) {
                    if (e == null) {
                        System.out.printf("""
                                        Received new metadata
                                        "Topic: %s
                                        Partition: %s
                                        Offset: %s
                                        Timestamp: %s
                                        """,
                                metadata.topic(),
                                metadata.partition(),
                                metadata.offset(),
                                metadata.timestamp());
                    }
                }
            });
            // flush data - synchronous
            producer.flush();
            // flush and close producer
            producer.close();
            return mapperTaiKhoan.mapToResTaiKhoan(taiKhoan);
//            if (hoSoDTO != null) {
//                taiKhoan.setHoSoId(hoSoDTO.id());
//                taiKhoanRepository.save(taiKhoan);
//                return mapperTaiKhoan.mapToResTaiKhoan(taiKhoan);
//            } else return null;
        } catch (RuntimeException e) {
            throw new RuntimeException(e.getCause());
        }
    }

    @Override
    public ResTaiKhoan xemTaiKhoanCaNhan(int id) {
        return xemTheoId(id);
    }

    @Override
    public boolean doiMatKhauTaiKhoanCaNhan(int id, String matkhau) {
        TaiKhoan taiKhoan = taiKhoanRepository.findById(id).orElseThrow(NotFoundException::new);
        if (!ITaiKhoanService.checkMatKhau(matkhau)) {
            throw new InputMismatchException("Sai mật khẩu");
        }
        taiKhoan.setPassword(matkhau);
        taiKhoan.setUpdate_at();
        taiKhoanRepository.save(taiKhoan);
        return true;
    }

    @Override
    public boolean doiEmailTaiKhoanCaNhan(int id, String email) {
        TaiKhoan taiKhoan = taiKhoanRepository.findById(id).orElseThrow(NotFoundException::new);
        taiKhoan.setEmail(email);
        taiKhoan.setUpdate_at();
        taiKhoanRepository.save(taiKhoan);
        return true;
    }

    @Override
    public ResTaiKhoanLogin dangNhap(ReqTaiKhoanLogin login) {
        TaiKhoan taiKhoan = taiKhoanRepository.findByUsernameAndPassword(login.username(), login.password());
        if (taiKhoan != null) {
            ResAuth auth = mapperAuth.mapToResAuth(taiKhoan);
            String token = jwtUtilities.generationToken(taiKhoan);
//            String token = client.taoToken(auth);
            return new ResTaiKhoanLogin(taiKhoan.getUsername(), taiKhoan.getRoleTaiKhoan().name(), token);
        }
        //không tạo refresh token ok
        throw new ResponseStatusException(ResEnum.SAI_TAI_KHOAN_HOAC_MAT_KHAU.getStatusCode(), ResEnum.SAI_TAI_KHOAN_HOAC_MAT_KHAU.name());
    }
}
