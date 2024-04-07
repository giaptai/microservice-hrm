package com.hrm.hoso.client.chi_tiet.kien_thuc_an_ninh_quoc_phong;

import java.time.LocalDateTime;
import java.util.UUID;

public record ResKienThucAnNinhQuocPhong(
        int id,
        LocalDateTime batDau,
        LocalDateTime ketThuc,
        int tenCoSoDaoTaoId,
        String tenCoSoDaoTaoName,
        String chungChiDuocCap,
        String xacNhan,
        UUID hoSoId,
        LocalDateTime create_at,
        LocalDateTime update_at
) {
}
