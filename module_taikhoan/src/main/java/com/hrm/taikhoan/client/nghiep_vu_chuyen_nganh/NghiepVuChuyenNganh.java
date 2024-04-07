package com.hrm.taikhoan.client.nghiep_vu_chuyen_nganh;

import com.hrm.taikhoan.enums.XacNhan;

import java.time.LocalDateTime;
import java.util.UUID;

public record NghiepVuChuyenNganh(
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
