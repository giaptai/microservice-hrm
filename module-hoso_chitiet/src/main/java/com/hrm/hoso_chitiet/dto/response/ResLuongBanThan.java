package com.hrm.hoso_chitiet.dto.response;

import com.hrm.hoso_chitiet.enums.XacNhan;

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
        XacNhan xacNhan,
        UUID hoSoId,
        LocalDateTime create_at,
        LocalDateTime update_at

) {
}
