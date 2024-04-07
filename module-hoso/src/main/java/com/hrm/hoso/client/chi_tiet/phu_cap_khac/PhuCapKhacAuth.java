package com.hrm.hoso.client.chi_tiet.phu_cap_khac;

import java.time.LocalDateTime;

public record PhuCapKhacAuth(
        int id,
        LocalDateTime batDau,
        LocalDateTime ketThuc,
        int loaiPhuCapId,
        String loaiPhuCapName,
        float phanTramHuongPhuCap,
        float heSoPhuCap,
        String hinhThucHuong,
        double giaTri,
        LocalDateTime create_at,
        LocalDateTime update_at
){
}
