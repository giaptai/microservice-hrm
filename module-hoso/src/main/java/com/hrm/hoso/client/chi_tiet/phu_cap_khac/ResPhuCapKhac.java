package com.hrm.hoso.client.chi_tiet.phu_cap_khac;

import java.time.LocalDateTime;
import java.util.UUID;

public record ResPhuCapKhac(
        int id,
        LocalDateTime batDau,
        LocalDateTime ketThuc,
        int loaiPhuCapId,
        String loaiPhuCapName,
        float phanTramHuongPhuCap,
        float heSoPhuCap,
        String hinhThucThuong,
        double giaTri,
        UUID hoSoId,
        LocalDateTime create_at,
        LocalDateTime update_at
) {
}
