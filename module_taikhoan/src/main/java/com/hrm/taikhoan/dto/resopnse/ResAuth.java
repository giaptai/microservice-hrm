package com.hrm.taikhoan.dto.resopnse;

import com.hrm.taikhoan.models.TaiKhoan;
import lombok.Builder;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Builder
public record ResAuth(
        int id,
        String username,
        String password,
        UUID hoSoId,
        String role
) {
    public static ResAuth mapToResAuth(TaiKhoan taiKhoan) {
        return new ResAuth(
                taiKhoan.getId(),
                taiKhoan.getUsername(),
                taiKhoan.getPassword(),
                Optional.of(taiKhoan).map(TaiKhoan::getHoSoId).orElse(null),
                taiKhoan.getRoleTaiKhoan().name()
        );
    }
}
