package com.hrm.taikhoan.dto.client.nghiep_vu_chuyen_nganh;

import com.hrm.taikhoan.enums.XacNhan;

import java.time.LocalDateTime;

public record NghiepVuChuyenNganhDTO(
        int id,
        LocalDateTime batDau,
        LocalDateTime ketThuc,
        int tenCoSoDaoTaoId,
        String chungChiDuocCap,
        XacNhan xacNhan,
        LocalDateTime create_at,
        LocalDateTime update_at
){
}
