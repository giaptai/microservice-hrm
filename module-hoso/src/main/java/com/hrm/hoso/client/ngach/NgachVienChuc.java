package com.hrm.hoso.client.ngach;

import lombok.Builder;

@Builder
public record NgachVienChuc(
        String ma,
        String name,
        int heSoLuongVienChucId,
        int nhomVienChucId,
        String nhomVienChucName,
        int loaiVienChucId,
        String loaiVienChucLoai,
        String loaiVienChucName,
        int bacLuongId,
        String bacLuongName,
        float heSo
) {
}
