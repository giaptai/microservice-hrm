package com.hrm.hoso_chitiet.dto.response;

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
        String hinhThucHuong,
        double giaTri,
        UUID hoSoId,
        LocalDateTime create_at,
        LocalDateTime update_at
) {
}
