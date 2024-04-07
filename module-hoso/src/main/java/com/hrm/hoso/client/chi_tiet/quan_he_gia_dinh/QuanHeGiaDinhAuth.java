package com.hrm.hoso.client.chi_tiet.quan_he_gia_dinh;

import java.time.LocalDateTime;

public record QuanHeGiaDinhAuth(
        int id,
        int moiQuanHeId,
        String moiQuanHeName,
        String hoVaTen,
        short namSinh,
        String thongTinThanNhan,
        LocalDateTime create_at,
        LocalDateTime update_at
){
}
