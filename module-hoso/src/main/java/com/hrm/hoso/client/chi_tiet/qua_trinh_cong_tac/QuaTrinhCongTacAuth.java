package com.hrm.hoso.client.chi_tiet.qua_trinh_cong_tac;

import java.time.LocalDateTime;

public record QuaTrinhCongTacAuth(
        int id,
        LocalDateTime batDau,
        LocalDateTime ketThuc,
        int donViCongTacId,
        String donViCongTacName,
        String chucDanh,
        LocalDateTime create_at,
        LocalDateTime update_at
){
}
