package com.hrm.hoso.dto.request;

import java.time.LocalDateTime;

public record ReqChucVuKiemNhiem(
        int chucVuKiemNhiemId, //ChucVu chucVuKiemNhiem
        LocalDateTime ngayBoNhiem,
        double phuCapKiemNhiem,
        double phuCapKhac
) {
}
