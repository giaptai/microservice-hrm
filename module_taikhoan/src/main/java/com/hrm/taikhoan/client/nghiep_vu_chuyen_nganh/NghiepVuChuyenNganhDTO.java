package com.hrm.taikhoan.client.nghiep_vu_chuyen_nganh;

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
