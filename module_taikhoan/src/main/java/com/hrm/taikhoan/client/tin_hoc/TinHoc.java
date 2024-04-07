package com.hrm.taikhoan.client.tin_hoc;

import java.time.LocalDateTime;
import java.util.UUID;

public record TinHoc(
        int id,
        LocalDateTime batDau,
        LocalDateTime ketThuc,
        int tenCoSoDaoTaoId,
        String chungChiDuocCap,
        UUID hoSoId,
        LocalDateTime create_at,
        LocalDateTime update_at
) {
}
