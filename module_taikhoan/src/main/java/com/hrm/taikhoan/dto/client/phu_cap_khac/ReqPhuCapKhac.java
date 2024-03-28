package com.hrm.taikhoan.dto.client.phu_cap_khac;

import java.time.LocalDateTime;

public record ReqPhuCapKhac(
        LocalDateTime batDau,
        LocalDateTime ketThuc,
        int loaiPhuCap,
        float phanTramHuongPhuCap,
        float heSoPhuCap,
        String hinhThucThuong,
        double giaTri
) {
}
