package com.hrm.hoso_chitiet.dto.request;

import java.time.LocalDateTime;

public record ReqPhuCapKhac(
        LocalDateTime batDau,
        LocalDateTime ketThuc,
        int loaiPhuCap,
        float phanTramHuongPhuCap,
        float heSoPhuCap,
        String hinhThucThuong,
        double giaTri,
        String loaiSoYeuLyLichChiTiet,
        String soYeuLyLich
) {
}
