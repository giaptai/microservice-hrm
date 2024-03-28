package com.hrm.taikhoan.dto.client.quan_he_gia_dinh;

import java.time.LocalDateTime;

public record QuanHeGiaDinhDTO(
        int id,
        int moiQuanHe,
        String hoVaTen,
        short namSinh,
        String thongTinThanNhan,
        LocalDateTime create_at,
        LocalDateTime update_at
){
}
