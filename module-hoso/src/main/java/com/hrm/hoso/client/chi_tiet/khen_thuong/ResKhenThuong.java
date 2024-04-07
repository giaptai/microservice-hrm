package com.hrm.hoso.client.chi_tiet.khen_thuong;

import java.time.LocalDateTime;
import java.util.UUID;

public record ResKhenThuong(
        int id,
        LocalDateTime nam,
        String xepLoaiChuyenMon,
        String xepLoaiThiDua,
        int hinhThucKhenThuongId,
        String hinhThucKhenThuongName,
        String lyDo,
        String xacNhan,
        UUID hoSoId,
        LocalDateTime create_at,
        LocalDateTime update_at
) {
}
