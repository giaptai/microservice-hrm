package com.hrm.taikhoan.service.tai_khoan;

import com.hrm.taikhoan.dto.request.ReqHoSo;
import com.hrm.taikhoan.dto.request.ReqTaiKhoan;
import com.hrm.taikhoan.dto.request.ReqTaiKhoanLogin;
import com.hrm.taikhoan.dto.resopnse.ResTaiKhoanLogin;
import com.hrm.taikhoan.enums.RoleTaiKhoan;
import com.hrm.taikhoan.models.TaiKhoan;
import com.hrm.taikhoan.repository.TaiKhoanRepository;
import com.hrm.taikhoan.response.ResEnum;
import com.hrm.taikhoan.security.IAuthenticationFacade;
import com.hrm.taikhoan.security.jwt_utilities.JWTUtilities;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import static com.hrm.taikhoan.dto.resopnse.ResTaiKhoan.mapToResTaiKhoan;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TaiKhoanService implements ITaiKhoanService {

    final TaiKhoanRepository taiKhoanRepository;

//    final JavaMailSender javaMailSender;

    final JWTUtilities jwtUtilities;

    final PasswordEncoder passwordEncoder;

    final AuthenticationManager authenticationManager;

    final IAuthenticationFacade facade;

    @Value("${moduleUrl.ho-so}")
    String hoSoUrl;
//    final KafkaProducers producers;
//
//    final KafkaConsumers consumers;

    @Override
    public TaiKhoan xemThongTin() {
        try {
            return facade.getTaiKhoan();
        } catch (RuntimeException e) {
            throw new RuntimeException(e.getCause());
        }
    }

    @Override
    public boolean doiMatKhau(String matkhau) {
        try {
            System.out.println(facade.getTaiKhoan().getUsername());
            TaiKhoan taiKhoan = facade.getTaiKhoan();
            if (taiKhoan != null) {
                taiKhoan.setPassword(matkhau);
                taiKhoan.setUpdate_at();
                taiKhoanRepository.save(taiKhoan);
                return true;
            } else return false;
        } catch (RuntimeException e) {
            throw new RuntimeException(e.getCause());
        }
    }

    @Override
    public boolean doiEmail(String email) {
        try {
            TaiKhoan taiKhoan = facade.getTaiKhoan();
            if (taiKhoan != null) {
                taiKhoan.setEmail(email);
                taiKhoan.setUpdate_at();
                taiKhoanRepository.save(taiKhoan);
                return true;
            } else return false;
        } catch (RuntimeException e) {
            throw new RuntimeException(e.getCause());
        }
    }

    /* ADMIN - ADMIN - ADMIN*/
    @Override
    public List<TaiKhoan> xemDanhSachTaiKhoan() {
        System.out.println(facade.getTaiKhoan().getUsername());
        try {
            return taiKhoanRepository.findAll().stream().filter(c->c.getRoleTaiKhoan().equals(RoleTaiKhoan.EMPLOYEE)).toList();
        } catch (RuntimeException e) {
            throw new RuntimeException(e.getCause());
        }
    }

    @Override
    public TaiKhoan xemTheoSoCCCDOrUsername(String number) {
        try {
            TaiKhoan taiKhoanSoCCCD = taiKhoanRepository.findBySoCCCD(number);
            TaiKhoan taiKhoanUsername = taiKhoanRepository.findByUsernameContaining(number);
            if (taiKhoanSoCCCD != null) {
                return taiKhoanSoCCCD;
            } else return taiKhoanUsername;
        } catch (RuntimeException e) {
            throw new RuntimeException(e.getCause());
        }
    }

    @Override
    public TaiKhoan xemTheoId(int id) {
        try {
            return taiKhoanRepository.findById(id).orElse(null);
        } catch (RuntimeException e) {
            throw new RuntimeException(e.getCause());
        }
    }

    @Override
    public TaiKhoan them(ReqTaiKhoan reqTaiKhoan) {
        TaiKhoan taiKhoan = null;
        UUID uuid = UUID.randomUUID();
        WebClient webClient = WebClient
                .builder()
                .baseUrl(hoSoUrl)
                .build();
        try {
            List<TaiKhoan> listUsername = taiKhoanRepository.findAll();
            //tạo username
            String hoVaTen = reqTaiKhoan.hoVaTen();
            String newUsername = ITaiKhoanService.createUsername(hoVaTen, listUsername);
            taiKhoan = TaiKhoan.builder()
                    .hoVaTen(reqTaiKhoan.hoVaTen())
                    .soCCCD(reqTaiKhoan.soCCCD())
                    .username(newUsername)
                    .password(reqTaiKhoan.soCCCD())
                    .email(reqTaiKhoan.email())
                    .roleTaiKhoan(RoleTaiKhoan.EMPLOYEE)
                    .hoSoId(uuid)
                    .trangThai(true)
                    .create_at(LocalDateTime.now())
                    .build();
            if (taiKhoan != null) {
                taiKhoanRepository.save(taiKhoan);
                webClient.post()
                        .bodyValue(new ReqHoSo(uuid, reqTaiKhoan.hoVaTen(), reqTaiKhoan.soCCCD(), taiKhoan.getId()))
                        .retrieve()
                        .bodyToMono(Object.class)
                        .onErrorResume(e -> Mono.empty())
                        .block();
                return taiKhoan;
            } else return null;
        } catch (RuntimeException e) {
            return null;
//            throw new ResponseStatusException(ResEnum.TRUNG_DU_LIEU.getStatusCode(), "Trùng dữ liệu hoặc lỗi gì đó");
        } finally {
//            if (taiKhoan != null) {
//                producers.sendMailProducer(reqTaiKhoan);
//            }
        }
    }

    @Override
    public ResTaiKhoanLogin dangNhap(ReqTaiKhoanLogin req) {
        try {
            TaiKhoan taiKhoanLogin = taiKhoanRepository.findByUsername(req.username());
            if (taiKhoanLogin != null) {
                authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(req.username(), req.password()));
                System.out.printf("USER IS: %s", taiKhoanLogin.getUsername());
                return new ResTaiKhoanLogin(
                        mapToResTaiKhoan(taiKhoanLogin),
                        jwtUtilities.generationToken(taiKhoanLogin)
                );
            }
            //không tạo refresh token ok
            throw new ResponseStatusException(ResEnum.SAI_TAI_KHOAN_HOAC_MAT_KHAU.getStatusCode(), ResEnum.SAI_TAI_KHOAN_HOAC_MAT_KHAU.name());
        } catch (AuthenticationException e) {
            return null;
        }
    }
}
