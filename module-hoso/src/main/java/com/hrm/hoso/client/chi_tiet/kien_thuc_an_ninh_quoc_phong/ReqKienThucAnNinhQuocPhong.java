package com.hrm.hoso.client.chi_tiet.kien_thuc_an_ninh_quoc_phong;

import java.time.LocalDateTime;

public record ReqKienThucAnNinhQuocPhong(
        LocalDateTime batDau,
        LocalDateTime ketThuc,
        int tenCoSoDaoTao,
        String chungChiDuocCap
) {
}
