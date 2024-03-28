package com.hrm.taikhoan.dto.client.qua_trinh_cong_tac;

import java.time.LocalDateTime;

public record ReqQuaTrinhCongTac(
        LocalDateTime batDau,
        LocalDateTime ketThuc,
        int donViCongTac,
        String chucDanh
) {
}
