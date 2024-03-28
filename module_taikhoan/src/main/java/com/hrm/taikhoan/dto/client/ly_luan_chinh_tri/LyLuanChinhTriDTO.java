package com.hrm.taikhoan.dto.client.ly_luan_chinh_tri;

import java.time.LocalDateTime;
import java.util.UUID;

public record LyLuanChinhTriDTO(
        int id,
        LocalDateTime batDau,
        LocalDateTime ketThuc,
        int tenCoSoDaoTaoId,
        String hinhThucDaoTao,
        String vanBangDuocCap,
        LocalDateTime create_at,
        LocalDateTime update_at
){
}
