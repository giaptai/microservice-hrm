package com.hrm.hoso.client.chi_tiet.lam_viec_o_nuoc_ngoai;

import java.time.LocalDateTime;
import java.util.UUID;

public record ResLamViecONuocNgoai(
        int id,
        LocalDateTime batDau,
        LocalDateTime ketThuc,
        String toChucDiaChiCongViec,
        UUID hoSoId,
        LocalDateTime create_at,
        LocalDateTime update_at
) {
}
