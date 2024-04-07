package com.hrm.hoso.client.chi_tiet.khen_thuong;

import java.time.LocalDateTime;

public record ReqKhenThuong(
        LocalDateTime nam,
        String xepLoaiChuyenMon,
        String xepLoaiThiDua,
        int hinhThucKhenThuong,
        String lyDo
) {
}
