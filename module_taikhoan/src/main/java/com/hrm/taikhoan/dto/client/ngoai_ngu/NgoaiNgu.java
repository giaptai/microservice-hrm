package com.hrm.taikhoan.dto.client.ngoai_ngu;

import com.hrm.taikhoan.enums.XacNhan;

import java.time.LocalDateTime;
import java.util.UUID;

public record NgoaiNgu(
        int id,
        LocalDateTime batDau,
        LocalDateTime ketThuc,
        int tenCoSoDaoTaoId,
        String tenNgoaiNgu,
        String chungChiDuocCap,
        float diemSo,
        XacNhan xacNhan,
        UUID hoSoId,
        LocalDateTime create_at,
        LocalDateTime update_at
) {
}
