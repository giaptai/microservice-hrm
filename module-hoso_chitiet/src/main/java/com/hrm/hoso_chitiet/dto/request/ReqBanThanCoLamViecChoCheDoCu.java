package com.hrm.hoso_chitiet.dto.request;

import java.time.LocalDateTime;

public record ReqBanThanCoLamViecChoCheDoCu(
        int id,
        LocalDateTime batDau,
        LocalDateTime ketThuc,
        String chucDanhDonViDiaDiem
) {
}
