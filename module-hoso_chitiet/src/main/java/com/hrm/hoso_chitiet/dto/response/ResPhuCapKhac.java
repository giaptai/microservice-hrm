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
    public static ResPhuCapKhac mapToResPhuCapKhac(PhuCapKhac khac) {
        return khac != null ? new ResPhuCapKhac(
                khac.getId(),
                khac.getBatDau(),
                khac.getKetThuc(),
                khac.getLoaiPhuCap(),
                khac.getPhanTramHuongPhuCap(),
                khac.getHeSoPhuCap(),
                khac.getHinhThucHuong(),
                khac.getGiaTri(),
                khac.getCreate_at(),
                khac.getUpdate_at()
        ) : null;
    }

}
