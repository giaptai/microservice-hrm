package com.hrm.taikhoan.dto.client.tin_hoc;

import java.time.LocalDateTime;

public record ReqTinHoc(
        LocalDateTime batDau,
        LocalDateTime ketThuc,
        int tenCoSoDaoTao,
        String chungChiDuocCap
) {
}
