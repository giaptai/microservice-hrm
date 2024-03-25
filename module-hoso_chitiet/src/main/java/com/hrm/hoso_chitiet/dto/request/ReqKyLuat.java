package com.hrm.hoso_chitiet.dto.request;

import java.time.LocalDateTime;

public record ReqKyLuat(
        LocalDateTime batDau,
        LocalDateTime ketThuc,
        String hinhThuc,
        String hanhViViPhamChinh,
        int coQuanQuyetDinh //DonVi
) {
}
