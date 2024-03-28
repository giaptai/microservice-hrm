package com.hrm.taikhoan.dto.client.kien_thuc_an_ninh_quoc_phong;

import java.time.LocalDateTime;

public record ReqKienThucAnNinhQuocPhong(
        LocalDateTime batDau,
        LocalDateTime ketThuc,
        int tenCoSoDaoTao,
        String chungChiDuocCap
) {
}
