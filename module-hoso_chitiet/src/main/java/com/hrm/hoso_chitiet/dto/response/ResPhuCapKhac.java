package com.hrm.hoso_chitiet.dto.response;

import com.hrm.hoso_chitiet.models.PhuCapKhac;

import java.time.LocalDateTime;

public record ResPhuCapKhac(
        int id,
        LocalDateTime batDau,
        LocalDateTime ketThuc,
        int IdLoaiPhuCap,
        float phanTramHuongPhuCap,
        float heSoPhuCap,
        String hinhThucHuong,
        double giaTri,
        LocalDateTime create_at,
        LocalDateTime update_at
) {
}
