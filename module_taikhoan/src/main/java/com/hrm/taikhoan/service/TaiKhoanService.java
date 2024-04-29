package com.hrm.taikhoan.service;

import com.hrm.taikhoan.dto.mapper.MapperAuth;
import com.hrm.taikhoan.dto.mapper.MapperTaiKhoan;
import com.hrm.taikhoan.dto.request.ReqHoSo;
import com.hrm.taikhoan.dto.request.ReqTaiKhoan;
import com.hrm.taikhoan.dto.request.ReqTaiKhoanLogin;
import com.hrm.taikhoan.dto.resopnse.ResTheDTO;
import com.hrm.taikhoan.dto.resopnse.ResTaiKhoan;
import com.hrm.taikhoan.dto.resopnse.ResTaiKhoanLogin;

import com.hrm.taikhoan.enums.RoleTaiKhoan;

import com.hrm.taikhoan.jwt_token.JWTUtilities;
import com.hrm.taikhoan.kafka.HoSoProducer;
import com.hrm.taikhoan.models.TaiKhoan;

import com.hrm.taikhoan.repository.TaiKhoanRepository;
import com.hrm.taikhoan.response.ResEnum;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.InputMismatchException;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TaiKhoanService implements ITaiKhoanService {
    final JWTUtilities jwtUtilities;
    final TaiKhoanRepository taiKhoanRepository;
    //    final JavaMailSender javaMailSender;
//    final IAuthenticationFacade facade;
//    final KafkaProducers producers;
    //mappers
    final MapperAuth mapperAuth;
    final MapperTaiKhoan mapperTaiKhoan;
    final HoSoProducer hoSoProducer;

    /* ADMIN - ADMIN - ADMIN*/
    @Override
    public ResTheDTO xemDanhSachTaiKhoan(String byDate, String username, RoleTaiKhoan role, int pageNumber, int pageSize) {
        try {
            Page<TaiKhoan> taiKhoans = null;
            Sort sort = Sort.by(Sort.Direction.DESC, byDate);
            Pageable pageable = PageRequest.of(pageNumber, pageSize, sort);
            long totalRecord;
            int totalPage;
            if (username == null && role == null) {
                taiKhoans = taiKhoanRepository.findAll(pageable);
            }
            if (username != null && role == null) {
                taiKhoans = xemByUsername(username, pageable);
            }
            if (username == null && role != null) {
                taiKhoans = taiKhoanRepository.findAllByRoleTaiKhoan(role, pageable);
            }
            if (username != null && role != null) {
                taiKhoans = taiKhoanRepository.findAllByRoleTaiKhoanAndUsername(role, username.toLowerCase(), pageable);
            }
            totalRecord = taiKhoans.getTotalElements();
            totalPage = taiKhoans.getTotalPages();
            List<ResTaiKhoan> resTaiKhoans = taiKhoans.getContent().stream().map(mapperTaiKhoan::mapToResTaiKhoan).toList();
            return new ResTheDTO(resTaiKhoans, totalRecord, totalPage);
        } catch (RuntimeException e) {
            throw new RuntimeException(e.getCause());
        }
    }

    private Page<TaiKhoan> xemByUsername(String number, Pageable pageable) {
        try {
            return taiKhoanRepository.findByUsernameContaining(number, pageable);
        } catch (RuntimeException e) {
            throw new RuntimeException(e.getCause());
        }
    }

//    @Override
//    public Page<ResTaiKhoan> xemTheoUsername(String number, int pageNumber, int pageSize) {
//        try {
//            Page<TaiKhoan> taiKhoans = taiKhoanRepository.findByUsernameContaining(number, PageRequest.of(pageNumber, pageSize));
//            return taiKhoans.stream().map(mapperTaiKhoan::mapToResTaiKhoan).toList();
//        } catch (RuntimeException e) {
//            throw new RuntimeException(e.getCause());
//        }
//    }

    @Override
    public ResTaiKhoan xemTheoId(int id) {
        try {
            TaiKhoan taiKhoan = taiKhoanRepository.findById(id).orElseThrow(() -> new ResponseStatusException(ResEnum.HONG_TIM_THAY_TAI_KHOAN.getStatusCode()));
            return mapperTaiKhoan.mapToResTaiKhoan(taiKhoan);
        } catch (RuntimeException e) {
            System.err.println(e.getMessage());
            throw e;
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
                    .createAt(LocalDateTime.now())
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
            System.err.println(e.getMessage());
            throw e;
        }
    }

    @Override
    public ResTaiKhoan xemTaiKhoanCaNhan(int id) {
        return xemTheoId(id);
    }

    @Override
    public boolean doiMatKhauTaiKhoanCaNhan(int id, String matkhau) {
        TaiKhoan taiKhoan = taiKhoanRepository.findById(id).orElseThrow(() -> new ResponseStatusException(ResEnum.HONG_TIM_THAY_TAI_KHOAN.getStatusCode()));
        if (!ITaiKhoanService.checkMatKhau(matkhau)) {
            throw new InputMismatchException("Sai mật khẩu");
        }
        taiKhoan.setPassword(matkhau);
        taiKhoan.setUpdateAt();
        taiKhoanRepository.save(taiKhoan);
        return true;
    }

    @Override
    public boolean doiEmailTaiKhoanCaNhan(int id, String email) {
        TaiKhoan taiKhoan = taiKhoanRepository.findById(id).orElseThrow(() -> new ResponseStatusException(ResEnum.HONG_TIM_THAY_TAI_KHOAN.getStatusCode()));
        taiKhoan.setEmail(email);
        taiKhoan.setUpdateAt();
        taiKhoanRepository.save(taiKhoan);
        return true;
    }

    @Override
    public ResTaiKhoanLogin dangNhap(ReqTaiKhoanLogin login) {
        TaiKhoan taiKhoan = taiKhoanRepository.findByUsernameAndPassword(login.username(), login.password());
        if (taiKhoan != null) {
//            ResAuth auth = mapperAuth.mapToResAuth(taiKhoan);
            String token = jwtUtilities.generationToken(taiKhoan);
//            String token = client.taoToken(auth);
            return new ResTaiKhoanLogin(taiKhoan.getUsername(), taiKhoan.getRoleTaiKhoan().name(), token);
        }
        //không tạo refresh token ok
        throw new ResponseStatusException(ResEnum.SAI_TAI_KHOAN_HOAC_MAT_KHAU.getStatusCode(), ResEnum.SAI_TAI_KHOAN_HOAC_MAT_KHAU.name());
    }
}
