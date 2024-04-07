package com.hrm.hoso_chitiet.dto.request;

import com.hrm.hoso_chitiet.enums.XepLoaiChuyenMon;
import com.hrm.hoso_chitiet.enums.XepLoaiThiDua;
import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record ReqKhenThuong(
        LocalDateTime nam,
        XepLoaiChuyenMon xepLoaiChuyenMon,
        XepLoaiThiDua xepLoaiThiDua,
        int hinhThucKhenThuongId,
        String lyDo
) {
}
