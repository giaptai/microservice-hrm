package com.hrm.taikhoan.client.quan_he_gia_dinh;

import java.time.LocalDateTime;
import java.util.UUID;

public record QuanHeGiaDinh(
        int id,
        int moiQuanHe,
        String hoVaTen,
        short namSinh,
        String thongTinThanNhan,
        UUID hoSoId,
        LocalDateTime create_at,
        LocalDateTime update_at
) {
}
