package com.hrm.hoso_chitiet.dto.response;

import com.hrm.hoso_chitiet.models.QuanHeGiaDinh;

import java.time.LocalDateTime;

public record ResQuanHeGiaDinh(
        int id,
        int moiQuanHe,
        String hoVaTen,
        short namSinh,
        String thongTinThanNhan,
        LocalDateTime create_at,
        LocalDateTime update_at
) {
    public static ResQuanHeGiaDinh mapToResQuanHeGiaDinh(QuanHeGiaDinh dinh) {
        return dinh != null ? new ResQuanHeGiaDinh(
                dinh.getId(),
                dinh.getMoiQuanHe(),
                dinh.getHoVaTen(),
                dinh.getNamSinh(),
                dinh.getThongTinThanNhan(),
                dinh.getCreate_at(),
                dinh.getUpdate_at()
        ) : null;
    }
}
