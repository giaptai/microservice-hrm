package com.hrm.hoso_chitiet.dto.response;

import java.time.LocalDateTime;
import java.util.UUID;

public record ResLuongBanThan(
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
