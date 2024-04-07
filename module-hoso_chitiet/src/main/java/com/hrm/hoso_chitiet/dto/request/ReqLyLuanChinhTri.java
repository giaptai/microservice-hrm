package com.hrm.hoso_chitiet.dto.request;

import java.time.LocalDateTime;

public record ReqLyLuanChinhTri(
        LocalDateTime batDau,
        LocalDateTime ketThuc,
        int tenCoSoDaoTaoId,
        String hinhThucDaoTao,
        String vanBangDuocCap
) {
}
