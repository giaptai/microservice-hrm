package com.hrm.hoso_chitiet.dto.request;

import java.time.LocalDateTime;

public record ReqTinHoc(
        LocalDateTime batDau,
        LocalDateTime ketThuc,
        int tenCoSoDaoTaoId,
        String chungChiDuocCap
) {
}
