package com.hrm.taikhoan.dto.client.lam_viec_o_nuoc_ngoai;

import java.time.LocalDateTime;

public record ReqLamViecONuocNgoai(
        LocalDateTime batDau,
        LocalDateTime ketThuc,
        String toChucDiaChiCongViec
) {
}
