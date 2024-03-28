package com.hrm.taikhoan.dto.client.luong_ban_than;

import java.time.LocalDateTime;
import java.util.UUID;

public record LuongBanThan(
        int id,
        LocalDateTime batDau,
        LocalDateTime ketThuc,
        String maSo,
        String bacLuong,
        float heSoLuong,
        float tienLuongTheoViTri,
        UUID hoSoId,
        LocalDateTime create_at,
        LocalDateTime update_at
) {
}
