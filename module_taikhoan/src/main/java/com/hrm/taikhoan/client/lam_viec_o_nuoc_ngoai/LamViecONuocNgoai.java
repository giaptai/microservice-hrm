package com.hrm.taikhoan.client.lam_viec_o_nuoc_ngoai;

import java.time.LocalDateTime;
import java.util.UUID;

public record LamViecONuocNgoai(
        int id,
        LocalDateTime batDau,
        LocalDateTime ketThuc,
        String toChucDiaChiCongViec,
        UUID hoSoId,
        LocalDateTime create_at,
        LocalDateTime update_at
) {
}
