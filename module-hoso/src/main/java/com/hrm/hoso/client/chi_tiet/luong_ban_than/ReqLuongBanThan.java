package com.hrm.hoso.client.chi_tiet.luong_ban_than;

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
