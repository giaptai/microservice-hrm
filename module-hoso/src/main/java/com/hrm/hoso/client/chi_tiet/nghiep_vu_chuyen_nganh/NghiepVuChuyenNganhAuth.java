package com.hrm.hoso.client.chi_tiet.nghiep_vu_chuyen_nganh;

import java.time.LocalDateTime;

public record NghiepVuChuyenNganhAuth(
        int id,
        LocalDateTime batDau,
        LocalDateTime ketThuc,
        int tenCoSoDaoTaoId,
        String tenCoSoDaoTaoName,
        String chungChiDuocCap,
        String xacNhan,
        LocalDateTime create_at,
        LocalDateTime update_at
){
}
