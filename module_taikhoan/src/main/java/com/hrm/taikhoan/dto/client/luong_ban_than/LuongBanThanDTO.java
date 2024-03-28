package com.hrm.taikhoan.dto.client.luong_ban_than;

import java.time.LocalDateTime;

public record LuongBanThanDTO(
        int id,
        LocalDateTime batDau,
        LocalDateTime ketThuc,
        String maSo,
        String bacLuong,
        float heSoLuong,
        float tienLuongTheoViTri,
        LocalDateTime create_at,
        LocalDateTime update_at
){
}
