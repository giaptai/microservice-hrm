package com.hrm.taikhoan.client.khen_thuong;

import com.hrm.taikhoan.enums.XacNhan;
import com.hrm.taikhoan.enums.XepLoaiChuyenMon;
import com.hrm.taikhoan.enums.XepLoaiThiDua;

import java.time.LocalDateTime;
import java.util.UUID;

public record KhenThuong(
        int id,
        LocalDateTime nam,
        XepLoaiChuyenMon xepLoaiChuyenMon,
        XepLoaiThiDua xepLoaiThiDua,
        int hinhThucKhenThuongId,
        String lyDo,
        XacNhan xacNhan,
        UUID hoSoId,
        LocalDateTime create_at,
        LocalDateTime update_at
) {
}
