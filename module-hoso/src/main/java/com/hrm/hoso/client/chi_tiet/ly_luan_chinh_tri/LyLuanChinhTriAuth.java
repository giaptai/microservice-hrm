package com.hrm.hoso.client.chi_tiet.ly_luan_chinh_tri;

import java.time.LocalDateTime;

public record LyLuanChinhTriAuth(
        int id,
        LocalDateTime batDau,
        LocalDateTime ketThuc,
        int tenCoSoDaoTaoId,
        String tenCoSoDaoTaoName,
        String hinhThucDaoTao,
        String vanBangDuocCap,
        String xacNhan,
        LocalDateTime create_at,
        LocalDateTime update_at
){
}
