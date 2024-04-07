package com.hrm.taikhoan.client.ly_luan_chinh_tri;

import java.time.LocalDateTime;

public record ReqLyLuanChinhTri(
        LocalDateTime batDau,
        LocalDateTime ketThuc,
        int tenCoSoDaoTao,
        String hinhThucDaoTao,
        String vanBangDuocCap
) {
}
