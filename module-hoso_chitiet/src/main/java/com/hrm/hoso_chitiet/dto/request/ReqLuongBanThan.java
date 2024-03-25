package com.hrm.hoso_chitiet.dto.request;

import java.time.LocalDateTime;

public record ReqLuongBanThan(
        LocalDateTime batDau,
        LocalDateTime ketThuc,
        String maSo,
        String bacLuong,
        float heSoLuong,
        float tienLuongTheoViTri
) {
}
