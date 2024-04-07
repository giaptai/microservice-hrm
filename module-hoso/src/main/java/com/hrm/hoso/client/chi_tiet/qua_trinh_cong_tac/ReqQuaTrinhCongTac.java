package com.hrm.hoso.client.chi_tiet.qua_trinh_cong_tac;

import java.time.LocalDateTime;

public record ReqQuaTrinhCongTac(
        LocalDateTime batDau,
        LocalDateTime ketThuc,
        int donViCongTac,
        String chucDanh
) {
}
