package com.hrm.authservice.service;

import com.hrm.authservice.client.TaiKhoanClient;
//import com.hrm.authservice.config.AuthPrinciple;
import com.hrm.authservice.dto.ReqAuthLogin;
import com.hrm.authservice.dto.ResAuthLogin;
import com.hrm.authservice.model.TaiKhoanDTO;
import com.hrm.authservice.util.JWTUtilities;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AuthService implements IAuthService {
    final TaiKhoanClient client;
    final JWTUtilities jwtUtilities;

    @Override
    public ResAuthLogin login(ReqAuthLogin login) {
        TaiKhoanDTO dto = client.dangNhap0(login);
//        AuthPrinciple principle = new AuthPrinciple();
//        principle.setTaiKhoanDTO(dto);
//        principle.setAuthorities(List.of(new SimpleGrantedAuthority(dto.getRole())));
        return new ResAuthLogin(dto.getUsername(), dto.getRole(), jwtUtilities.generationToken(dto));
    }

}
