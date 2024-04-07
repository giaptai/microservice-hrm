package com.hrm.taikhoan.client.nghiep_vu_chuyen_nganh;

import java.time.LocalDateTime;

public record ReqNghiepVuChuyenNganh(
        LocalDateTime batDau,
        LocalDateTime ketThuc,
        int tenCoSoDaoTao,
        String chungChiDuocCap
) {
}
