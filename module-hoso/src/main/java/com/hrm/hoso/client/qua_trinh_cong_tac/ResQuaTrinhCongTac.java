package com.hrm.hoso.client.qua_trinh_cong_tac;

import java.time.LocalDateTime;
import java.util.UUID;

public record ResQuaTrinhCongTac(
        int id,
        LocalDateTime batDau,
        LocalDateTime ketThuc,
        int donViCongTacId,
        String donViCongTacName,
        String chucDanh,
        String xacNhan,
        UUID hoSoId,
        String hoVaTen,
        String soCCCD,
        LocalDateTime create_at,
        LocalDateTime update_at
) {
}
