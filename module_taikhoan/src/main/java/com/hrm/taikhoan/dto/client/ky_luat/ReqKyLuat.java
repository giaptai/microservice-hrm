package com.hrm.taikhoan.dto.client.ky_luat;

import java.time.LocalDateTime;

public record ReqKyLuat(
        LocalDateTime batDau,
        LocalDateTime ketThuc,
        String hinhThuc,
        String hanhViViPhamChinh,
        int coQuanQuyetDinh //DonVi
) {
}
