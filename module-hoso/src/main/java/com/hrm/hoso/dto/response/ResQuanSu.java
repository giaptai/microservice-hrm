package com.hrm.hoso.dto.response;

import java.time.LocalDateTime;

public record ResQuanSu(LocalDateTime ngayNhapNgu, //NghiaVuQuanSu quanSu;
        LocalDateTime ngayXuatNgu, //NghiaVuQuanSu quanSu;
        int capBacLoaiQuanHamQuanDoi, //NghiaVuQuanSu quanSu;
        String capBacLoaiQuanHamQuanDoiName
) {
}
