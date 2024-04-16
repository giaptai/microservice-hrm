package com.hrm.hoso_chitiet.dto.response;

import com.hrm.hoso_chitiet.enums.XacNhan;

import java.time.LocalDateTime;
import java.util.UUID;

public record ResQuanHeGiaDinh(
        int id,
        int moiQuanHeId,
        String moiQuanHeName,
        String hoVaTen,
        short namSinh,
        String thongTinThanNhan,
        XacNhan xacNhan,
        UUID hoSoId,
        LocalDateTime create_at,
        LocalDateTime update_at
) {
}
