package com.hrm.hoso.client.qua_trinh_cong_tac;

import java.time.LocalDateTime;

public record ReqQuaTrinhCongTac(
        LocalDateTime batDau,
        LocalDateTime ketThuc,
        int donViCongTacId,
        String chucDanh
) {
}
