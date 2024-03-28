package com.hrm.taikhoan.dto.client.kien_thuc_an_ninh_quoc_phong;

import com.hrm.taikhoan.enums.XacNhan;

import java.time.LocalDateTime;
import java.util.UUID;

public record KienThucAnNinhQuocPhong(
        int id,
        LocalDateTime batDau,
        LocalDateTime ketThuc,
        int tenCoSoDaoTaoId,
        String chungChiDuocCap,
        XacNhan xacNhan,
        UUID hoSoId,
        LocalDateTime create_at,
        LocalDateTime update_at
) {
}
