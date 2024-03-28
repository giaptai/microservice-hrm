package com.hrm.hoso_chitiet.dto.response;

import com.hrm.hoso_chitiet.enums.XacNhan;
import com.hrm.hoso_chitiet.models.KienThucAnNinhQuocPhong;

import java.time.LocalDateTime;

public record ResKienThucAnNinhQuocPhong(
        int id,
        LocalDateTime batDau,
        LocalDateTime ketThuc,
        int IdTenCoSoDaoTao,
        String chungChiDuocCap,
        XacNhan xacNhan,
        LocalDateTime create_at,
        LocalDateTime update_at
) {

}
