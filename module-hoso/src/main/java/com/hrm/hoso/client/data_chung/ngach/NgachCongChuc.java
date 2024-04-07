package com.hrm.hoso.client.data_chung.ngach;

import lombok.Builder;

@Builder
public record NgachCongChuc(
        String ma,
        String name,
        int heSoLuongCongChucId,
        int nhomCongChucId,
        String nhomCongChucName,
        int loaiCongChucId,
        String loaiCongChucLoai,
        String loaiCongChucName,
        int bacLuongId,
        String bacLuongName,
        float heSo
) {
}
