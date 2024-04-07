package com.hrm.hoso.client.chi_tiet.ly_luan_chinh_tri;

import java.time.LocalDateTime;
import java.util.UUID;

public record ResLyLuanChinhTri(
        int id,
        LocalDateTime batDau,
        LocalDateTime ketThuc,
        int tenCoSoDaoTaoId,
        String tenCoSoDaoTaoName,
        String hinhThucDaoTao,
        String vanBangDuocCap,
        String xacNhan,
        UUID hoSoId,
        LocalDateTime create_at,
        LocalDateTime update_at
) {
}
