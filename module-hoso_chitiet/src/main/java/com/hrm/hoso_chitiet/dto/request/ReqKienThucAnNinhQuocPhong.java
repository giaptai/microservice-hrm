package com.hrm.hoso_chitiet.dto.request;

import java.time.LocalDateTime;

public record ReqKienThucAnNinhQuocPhong(LocalDateTime batDau,
                                         LocalDateTime ketThuc,
                                         int tenCoSoDaoTao,
                                         String chungChiDuocCap
) {
}
