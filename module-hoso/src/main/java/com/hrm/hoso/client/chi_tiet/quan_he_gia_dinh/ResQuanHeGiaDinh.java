package com.hrm.hoso.client.chi_tiet.quan_he_gia_dinh;

import java.time.LocalDateTime;
import java.util.UUID;

public record ResQuanHeGiaDinh(
        int id,
        int moiQuanHeId,
        String moiQuanHeName,
        String hoVaTen,
        short namSinh,
        String thongTinThanNhan,
        UUID hoSoId,
        LocalDateTime create_at,
        LocalDateTime update_at
) {
}
