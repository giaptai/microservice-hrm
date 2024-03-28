package com.hrm.hoso_chitiet.dto.mapper;

import com.hrm.hoso_chitiet.dto.response.ResLyLuanChinhTri;
import com.hrm.hoso_chitiet.models.LyLuanChinhTri;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperLyLuanChinhTri {
    public ResLyLuanChinhTri mapToResLyLuanChinhTri(LyLuanChinhTri tri) {
        return tri != null ? new ResLyLuanChinhTri(
                tri.getId(),
                tri.getHoSoId(),
                tri.getBatDau(),
                tri.getKetThuc(),
                tri.getTenCoSoDaoTaoId(),
                tri.getHinhThucDaoTao(),
                tri.getVanBangDuocCap(),
                tri.getCreate_at(),
                tri.getUpdate_at()
        ) : null;
    }
}