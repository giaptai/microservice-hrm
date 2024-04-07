package com.hrm.hoso.client.chi_tiet.nghiep_vu_chuyen_nganh;

import java.time.LocalDateTime;
import java.util.UUID;

public record ResNghiepVuChuyenNganh(
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
