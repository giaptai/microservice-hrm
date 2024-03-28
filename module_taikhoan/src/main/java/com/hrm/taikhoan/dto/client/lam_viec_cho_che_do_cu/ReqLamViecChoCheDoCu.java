package com.hrm.taikhoan.dto.client.lam_viec_cho_che_do_cu;

import java.time.LocalDateTime;
import java.util.UUID;

public record ReqLamViecChoCheDoCu(
        LocalDateTime batDau,
        LocalDateTime ketThuc,
        String chucDanhDonViDiaDiem
) {
}
