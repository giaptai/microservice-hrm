package com.hrm.taikhoan.client.qua_trinh_cong_tac;

import java.time.LocalDateTime;
import java.util.UUID;

public record QuaTrinhCongTac(
        int id,
        LocalDateTime batDau,
        LocalDateTime ketThuc,
        int donViCongTacId,
        String chucDanh,
        UUID hoSoId,
        LocalDateTime create_at,
        LocalDateTime update_at
) {
}
