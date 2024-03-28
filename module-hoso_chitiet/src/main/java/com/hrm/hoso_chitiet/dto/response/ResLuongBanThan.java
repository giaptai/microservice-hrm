package com.hrm.hoso_chitiet.dto.response;

import com.hrm.hoso_chitiet.models.LuongBanThan;

import java.time.LocalDateTime;

public record ResLuongBanThan(
        int id,
        LocalDateTime batDau,
        LocalDateTime ketThuc,
        String maSo,
        String bacLuong,
        float heSoLuong,
        float tienLuongTheoViTri,
        LocalDateTime create_at,
        LocalDateTime update_at

) {
}
