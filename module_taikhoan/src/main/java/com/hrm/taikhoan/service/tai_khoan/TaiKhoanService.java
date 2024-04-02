package com.hrm.taikhoan.service.tai_khoan;

import com.hrm.taikhoan.dto.client.ho_so.HoSoClient;
import com.hrm.taikhoan.dto.client.ho_so.HoSoDTO;
import com.hrm.taikhoan.dto.request.ReqHoSo;
import com.hrm.taikhoan.dto.request.ReqTaiKhoan;
import com.hrm.taikhoan.dto.request.ReqTaiKhoanLogin;
import com.hrm.taikhoan.dto.resopnse.ResAuth;
import com.hrm.taikhoan.dto.resopnse.ResTaiKhoanLogin;
import com.hrm.taikhoan.enums.RoleTaiKhoan;
import com.hrm.taikhoan.models.TaiKhoan;
import com.hrm.taikhoan.repository.TaiKhoanRepository;
import com.hrm.taikhoan.response.ResEnum;
import com.hrm.taikhoan.security.IAuthenticationFacade;
import com.hrm.taikhoan.security.TaiKhoanUserDetailsService;
import com.hrm.taikhoan.security.jwt_utilities.JWTUtilities;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TaiKhoanService implements ITaiKhoanService {

    final TaiKhoanRepository taiKhoanRepository;
    final TaiKhoanUserDetailsService taiKhoanUserDetailsService;
    final HoSoClient hoSoClient;
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
//        System.out.println(facade.getTaiKhoan().getUsername());
        try {
            return taiKhoanRepository.findAllByRoleTaiKhoan(RoleTaiKhoan.EMPLOYEE);
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
        TaiKhoan taiKhoan;
        UUID uuid = UUID.randomUUID();
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
                    .trangThai(true)
                    .create_at(LocalDateTime.now())
                    .build();
            HoSoDTO hoSoDTO = hoSoClient.addHoSo(new ReqHoSo(uuid, taiKhoan.getHoVaTen(), taiKhoan.getSoCCCD(), taiKhoan.getId()));
            if (hoSoDTO != null) {
                taiKhoan.setHoSoId(hoSoDTO.id());
                taiKhoanRepository.save(taiKhoan);
                return taiKhoan;
            } else return null;
        } catch (RuntimeException e) {
            return null;
        }
    }

    @Override
    public ResTaiKhoanLogin dangNhap(ReqTaiKhoanLogin req) {
        try {
            UserDetails taiKhoanLogin = taiKhoanRepository.findByUsername(req.username());
            if (taiKhoanLogin != null) {
                Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(req.username(), req.password()));
                SecurityContextHolder.getContext().setAuthentication(authentication);
                System.out.printf("USER IS: %s\n", taiKhoanLogin.getUsername());
                return new ResTaiKhoanLogin(
                        taiKhoanLogin.getUsername(),
                        taiKhoanLogin.getAuthorities().stream().findFirst().map(GrantedAuthority::getAuthority).orElse(null),
                        jwtUtilities.generationToken(taiKhoanLogin)
                );
            }
            //không tạo refresh token ok
            throw new ResponseStatusException(ResEnum.SAI_TAI_KHOAN_HOAC_MAT_KHAU.getStatusCode(), ResEnum.SAI_TAI_KHOAN_HOAC_MAT_KHAU.name());
        } catch (AuthenticationException e) {
            return null;
        }
    }

    @Override
    public ResAuth dangNhap0(ReqTaiKhoanLogin login) {
        try {
            TaiKhoan taiKhoan = taiKhoanRepository.findByUsernameAndPassword(login.username(), login.password());
            if (taiKhoan != null) {
                return ResAuth.mapToResAuth(taiKhoan);
            }
            //không tạo refresh token ok
            throw new ResponseStatusException(ResEnum.SAI_TAI_KHOAN_HOAC_MAT_KHAU.getStatusCode(), ResEnum.SAI_TAI_KHOAN_HOAC_MAT_KHAU.name());
        } catch (AuthenticationException e) {
            return null;
        }
    }
}
