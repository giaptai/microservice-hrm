package com.hrm.authservice.service;

import com.hrm.authservice.model.ResTaiKhoan;
import com.hrm.authservice.util.JWTUtilities;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TokenService implements ITokenService {
    final JWTUtilities jwtUtilities;
    @Override
    public String taoToken(ResTaiKhoan resTaiKhoan) {
        return jwtUtilities.generationToken(resTaiKhoan);
    }

}
