package com.hrm.hoso.client.vi_tri_viec_lam;

import lombok.Builder;

@Builder
public record ViTriViecLam(
        int id,
        String name,
        int bacLuongId,
        String bacLuongName,
        double tienLuong
) {
}
