package com.hrm.hoso_chitiet.dto.request;

import java.time.LocalDateTime;

public record ReqNgoaiNgu(
        LocalDateTime batDau,
        LocalDateTime ketThuc,
        int tenCoSoDaoTaoId,
        String tenNgoaiNgu,
        String chungChiDuocCap,
        float diemSo
) {
}
