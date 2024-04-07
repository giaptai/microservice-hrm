package com.hrm.hoso.client.chi_tiet.lam_viec_cho_che_do_cu;

import java.time.LocalDateTime;

public record ReqLamViecChoCheDoCu(
        LocalDateTime batDau,
        LocalDateTime ketThuc,
        String chucDanhDonViDiaDiem
) {
}
