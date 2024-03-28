package com.hrm.taikhoan.dto.client.qua_trinh_cong_tac;

import java.time.LocalDateTime;

public record QuaTrinhCongTacDTO(
        int id,
        LocalDateTime batDau,
        LocalDateTime ketThuc,
        int donViCongTacId,
        String chucDanh,
        LocalDateTime create_at,
        LocalDateTime update_at
){
}
