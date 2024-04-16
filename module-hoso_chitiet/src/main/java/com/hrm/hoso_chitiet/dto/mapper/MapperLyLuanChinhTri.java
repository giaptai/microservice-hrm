package com.hrm.hoso_chitiet.dto.mapper;

import com.hrm.hoso_chitiet.client.coquan_tochuc_donvi.CoQuanToChucDonViClient;
import com.hrm.hoso_chitiet.dto.response.ResLyLuanChinhTri;
import com.hrm.hoso_chitiet.models.LyLuanChinhTri;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class MapperLyLuanChinhTri {
    final CoQuanToChucDonViClient coQuanToChucDonViClient;
    public ResLyLuanChinhTri mapToResLyLuanChinhTri(LyLuanChinhTri tri) {
        return tri != null ? new ResLyLuanChinhTri(
                tri.getId(),
                tri.getBatDau(),
                tri.getKetThuc(),
                tri.getTenCoSoDaoTaoId(),
                tri.getHinhThucDaoTao(),
                tri.getVanBangDuocCap(),
                coQuanToChucDonViClient.getName(tri.getTenCoSoDaoTaoId()),
                tri.getXacNhan(),
                tri.getHoSoId(),
                tri.getCreate_at(),
                tri.getUpdate_at()
        ) : null;
    }
}
