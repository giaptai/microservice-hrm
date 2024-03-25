package com.hrm.hoso_chitiet.dto.request;

import java.time.LocalDateTime;

public record ReqNghiepVuChuyenNganh(
        LocalDateTime batDau,
        LocalDateTime ketThuc,
        int tenCoSoDaoTao,
        String chungChiDuocCap
) {
}
