package com.hrm.hoso.client.chi_tiet.ngoai_ngu;

import java.time.LocalDateTime;
import java.util.UUID;

public record ResNgoaiNgu(
        int id,
        LocalDateTime batDau,
        LocalDateTime ketThuc,
        int tenCoSoDaoTaoId,
        String tenCoSoDaoTaoName,
        String tenNgoaiNgu,
        String chungChiDuocCap,
        float diemSo,
        String xacNhan,
        UUID hoSoId,
        LocalDateTime create_at,
        LocalDateTime update_at
) {
}
