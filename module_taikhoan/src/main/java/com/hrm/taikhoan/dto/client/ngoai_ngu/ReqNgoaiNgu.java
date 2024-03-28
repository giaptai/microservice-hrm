package com.hrm.taikhoan.dto.client.ngoai_ngu;

import java.time.LocalDateTime;

public record ReqNgoaiNgu(
        LocalDateTime batDau,
        LocalDateTime ketThuc,
        int tenCoSoDaoTao,
        String tenNgoaiNgu,
        String chungChiDuocCap,
        float diemSo
) {
}
