package com.hrm.taikhoan.service;

import com.hrm.taikhoan.client.auth_token.TokenClient;
import com.hrm.taikhoan.client.ho_so.HoSoClient;
import com.hrm.taikhoan.client.ho_so.HoSoDTO;

import com.hrm.taikhoan.dto.mapper.MapperAuth;
import com.hrm.taikhoan.dto.mapper.MapperTaiKhoan;
import com.hrm.taikhoan.dto.request.ReqHoSo;
import com.hrm.taikhoan.dto.request.ReqTaiKhoan;
import com.hrm.taikhoan.dto.request.ReqTaiKhoanLogin;
import com.hrm.taikhoan.dto.resopnse.ResAuth;
import com.hrm.taikhoan.dto.resopnse.ResTaiKhoan;
import com.hrm.taikhoan.dto.resopnse.ResTaiKhoanLogin;

import com.hrm.taikhoan.enums.RoleTaiKhoan;

import com.hrm.taikhoan.models.TaiKhoan;

import com.hrm.taikhoan.repository.TaiKhoanRepository;
import com.hrm.taikhoan.response.ResEnum;

import jakarta.ws.rs.NotFoundException;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

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
    final TokenClient client;
    final TaiKhoanRepository taiKhoanRepository;
    final HoSoClient hoSoClient;
    //    final JavaMailSender javaMailSender;
//    final IAuthenticationFacade facade;
//    final KafkaProducers producers;
    //mappers
    final MapperAuth mapperAuth;
    final MapperTaiKhoan mapperTaiKhoan;

    /* ADMIN - ADMIN - ADMIN*/
    @Override
    public List<ResTaiKhoan> xemDanhSachTaiKhoan() {
        try {
            List<TaiKhoan> taiKhoans = taiKhoanRepository.findAllByRoleTaiKhoan(RoleTaiKhoan.EMPLOYEE);
            return taiKhoans.stream().map(mapperTaiKhoan::mapToResTaiKhoan).toList();
        } catch (RuntimeException e) {
            throw new RuntimeException(e.getCause());
        }
    }

    @Override
    public List<ResTaiKhoan> xemTheoUsername(String number) {
        try {
            List<TaiKhoan> taiKhoans = taiKhoanRepository.findByUsernameContaining(number);
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
            HoSoDTO hoSoDTO = hoSoClient.addHoSo(new ReqHoSo(uuid, taiKhoan.getHoVaTen(), taiKhoan.getPassword(), taiKhoan.getId()));
            if (hoSoDTO != null) {
                taiKhoan.setHoSoId(hoSoDTO.id());
                taiKhoanRepository.save(taiKhoan);
                return mapperTaiKhoan.mapToResTaiKhoan(taiKhoan);
            } else return null;
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
            String token = client.taoToken(auth);
            return new ResTaiKhoanLogin(taiKhoan.getUsername(), taiKhoan.getRoleTaiKhoan().name(), token);
        }
        //không tạo refresh token ok
        throw new ResponseStatusException(ResEnum.SAI_TAI_KHOAN_HOAC_MAT_KHAU.getStatusCode(), ResEnum.SAI_TAI_KHOAN_HOAC_MAT_KHAU.name());
    }
}
