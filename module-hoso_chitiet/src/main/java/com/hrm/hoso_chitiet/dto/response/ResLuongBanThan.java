package com.hrm.hoso_chitiet.dto.response;

import com.hrm.hoso_chitiet.models.LuongBanThan;

import java.time.LocalDateTime;

public record ResLuongBanThan(
        int id,
        LocalDateTime batDau,
        LocalDateTime ketThuc,
        String maSo,
        String bacLuong,
        float heSoLuong,
        float tienLuongTheoViTri,
        LocalDateTime create_at,
        LocalDateTime update_at

) {
    public static ResLuongBanThan mapToResLuongBanThan(LuongBanThan than) {
        return than != null ? new ResLuongBanThan(
                than.getId(),
                than.getBatDau(),
                than.getKetThuc(),
                than.getMaSo(),
                than.getBacLuong(),
                than.getHeSoLuong(),
                than.getTienLuongTheoViTri(),
                than.getCreate_at(),
                than.getUpdate_at()
        ) : null;
    }
}
