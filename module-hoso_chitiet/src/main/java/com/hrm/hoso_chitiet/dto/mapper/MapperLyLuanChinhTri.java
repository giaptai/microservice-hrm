package com.hrm.hoso_chitiet.dto.mapper;

import com.hrm.hoso_chitiet.client.coquan_tochuc_donvi.CoQuanToChucDonViClient;
import com.hrm.hoso_chitiet.client.ho_so.HoSoClient;
import com.hrm.hoso_chitiet.client.ho_so.ResHoSoTomTatClient;
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
    final HoSoClient hoSoClient;

    public ResLyLuanChinhTri mapToResLyLuanChinhTri(LyLuanChinhTri tri) {
        if (tri != null) {
            ResHoSoTomTatClient tomTatClient = hoSoClient.getHoSoNhanVienId(tri.getHoSoId());
            return new ResLyLuanChinhTri(
                    tri.getId(),
                    tri.getBatDau(),
                    tri.getKetThuc(),
                    tri.getTenCoSoDaoTaoId(),
                    tri.getHinhThucDaoTao(),
                    tri.getVanBangDuocCap(),
                    coQuanToChucDonViClient.getName(tri.getTenCoSoDaoTaoId()),
                    tri.getXacNhan(),
                    tri.getHoSoId(),
                    tomTatClient.hoVaTen(),
                    tomTatClient.soCCCD(),
                    tri.getCreateAt(),
                    tri.getUpdateAt());
        } else return null;
    }
}
