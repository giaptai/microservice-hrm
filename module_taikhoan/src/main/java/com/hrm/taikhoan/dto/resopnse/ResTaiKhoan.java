package com.hrm.taikhoan.dto.resopnse;

import com.hrm.taikhoan.models.TaiKhoan;
import lombok.Builder;


import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Builder
public record ResTaiKhoan(
        int id,
        String hoVaten,
        String soCCCD,
        String username,
        String email,
        UUID hoSoId,
        String role,
        boolean trangThai,
        LocalDateTime create_at,
        LocalDateTime update_at
) {
    public static ResTaiKhoan mapToResTaiKhoan(TaiKhoan taiKhoan) {
        return new ResTaiKhoan(
                taiKhoan.getId(),
                taiKhoan.getHoVaTen(),
                taiKhoan.getSoCCCD(),
                taiKhoan.getUsername(),
                taiKhoan.getEmail(),
                Optional.of(taiKhoan).map(TaiKhoan::getHoSoId).orElse(null),
                taiKhoan.getRoleTaiKhoan().getName(),
                taiKhoan.isTrangThai(),
                taiKhoan.getCreate_at(),
                taiKhoan.getUpdate_at()
        );
    }
}
