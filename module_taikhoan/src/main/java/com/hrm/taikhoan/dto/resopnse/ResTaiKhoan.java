package com.hrm.taikhoan.dto.resopnse;

import lombok.Builder;

import java.time.LocalDateTime;
import java.util.UUID;

@Builder
public record ResTaiKhoan(
        int id,
        String hoVaTen,
        String username,
        String email,
        UUID hoSoId,
        String role,
        boolean trangThai,
        LocalDateTime create_at,
        LocalDateTime update_at
) {
}
