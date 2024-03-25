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
    public static ResKienThucAnNinhQuocPhong mapToResKienThucAnNinhQuocPhong(KienThucAnNinhQuocPhong phong) {
        return phong != null ? new ResKienThucAnNinhQuocPhong(
                phong.getId(),
                phong.getBatDau(),
                phong.getKetThuc(),
                phong.getTenCoSoDaoTao(),
                phong.getChungChiDuocCap(),
                phong.getXacNhan(),
                phong.getCreate_at(),
                phong.getUpdate_at()
        ) : null;
    }
}
