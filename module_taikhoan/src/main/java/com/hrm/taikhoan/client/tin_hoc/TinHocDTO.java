package com.hrm.taikhoan.client.tin_hoc;

import java.time.LocalDateTime;

public record TinHocDTO(
        int id,
        LocalDateTime batDau,
        LocalDateTime ketThuc,
        int tenCoSoDaoTaoId,
        String chungChiDuocCap,
        LocalDateTime create_at,
        LocalDateTime update_at
){
}
