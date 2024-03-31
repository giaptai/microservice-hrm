package com.hrm.taikhoan.dto.client.ho_so;

import java.time.LocalDateTime;

public record QuanSuDTO(
        LocalDateTime ngayNhapNgu, //NghiaVuQuanSu quanSu;
        LocalDateTime ngayXuatNgu, //NghiaVuQuanSu quanSu;
        int capBacLoaiQuanHamQuanDoi //NghiaVuQuanSu quanSu;
) {
}
