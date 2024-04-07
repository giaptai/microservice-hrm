package com.hrm.hoso.dto.request;

import java.time.LocalDateTime;

public record ReqQuanSu(
        LocalDateTime ngayNhapNgu, //NghiaVuQuanSu quanSu;

        LocalDateTime ngayXuatNgu, //NghiaVuQuanSu quanSu;

        int capBacLoaiQuanHamQuanDoi //NghiaVuQuanSu quanSu;
) {
}
