package com.hrm.hoso_chitiet.dto.request;

import java.time.LocalDateTime;

public record ReqLamViecChoCheDoCu(
        LocalDateTime batDau,
        LocalDateTime ketThuc,
        String chucDanhDonViDiaDiem
) {
}
