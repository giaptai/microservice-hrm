package com.hrm.taikhoan.dto.client.phu_cap_khac;

import java.time.LocalDateTime;
import java.util.UUID;

public record PhuCapKhac(
        int id,
        LocalDateTime batDau,
        LocalDateTime ketThuc,
        int loaiPhuCapId,
        float phanTramHuongPhuCap,
        float heSoPhuCap,
        String hinhThucThuong,
        double giaTri,
        UUID hoSoId,
        LocalDateTime create_at,
        LocalDateTime update_at
) {
}
