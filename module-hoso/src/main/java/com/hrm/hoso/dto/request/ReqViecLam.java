package com.hrm.hoso.dto.request;

import java.time.LocalDateTime;

public record ReqViecLam(
        int viTriViecLamId,
        LocalDateTime ngayHuongLuongViTriViecLam,
        float phamTramHuongLuong,
        double phuCapThamNienVuotKhung,
        LocalDateTime ngayHuongPCTNVK
) {
}
