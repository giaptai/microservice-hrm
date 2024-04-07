package com.hrm.hoso.client.chi_tiet.tin_hoc;

import java.time.LocalDateTime;

public record TinHocAuth(
        int id,
        LocalDateTime batDau,
        LocalDateTime ketThuc,
        int tenCoSoDaoTaoId,
        String tenCoSoDaoTaoName,
        String chungChiDuocCap,
        LocalDateTime create_at,
        LocalDateTime update_at
){
}
