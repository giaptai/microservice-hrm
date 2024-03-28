package com.hrm.taikhoan.dto.client.khen_thuong;

import com.hrm.taikhoan.enums.XepLoaiChuyenMon;
import com.hrm.taikhoan.enums.XepLoaiThiDua;

import java.time.LocalDateTime;

public record ReqKhenThuong(
        LocalDateTime nam,
        XepLoaiChuyenMon xepLoaiChuyenMon,
        XepLoaiThiDua xepLoaiThiDua,
        int hinhThucKhenThuong,
        String lyDo
) {
}
