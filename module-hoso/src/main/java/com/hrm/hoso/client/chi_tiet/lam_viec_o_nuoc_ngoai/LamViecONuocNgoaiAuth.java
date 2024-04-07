package com.hrm.hoso.client.chi_tiet.lam_viec_o_nuoc_ngoai;

import java.time.LocalDateTime;

public record LamViecONuocNgoaiAuth(
        int id,
        LocalDateTime batDau,
        LocalDateTime ketThuc,
        String toChucDiaChiCongViec,
        LocalDateTime create_at,
        LocalDateTime update_at
){
}
