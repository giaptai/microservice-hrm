package com.hrm.hoso_chitiet.dto.mapper;

import com.hrm.hoso_chitiet.client.coquan_tochuc_donvi.CoQuanToChucDonViClient;
import com.hrm.hoso_chitiet.client.ho_so.HoSoClient;
import com.hrm.hoso_chitiet.client.ho_so.ResHoSoTomTatClient;
import com.hrm.hoso_chitiet.dto.response.ResKyLuat;
import com.hrm.hoso_chitiet.models.KyLuat;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class MapperKyLuat {
    final CoQuanToChucDonViClient coQuanToChucDonViClient;
    final HoSoClient hoSoClient;

    public ResKyLuat mapToResKyLuat(KyLuat luat) {
        if (luat != null) {
            ResHoSoTomTatClient tomTatClient = hoSoClient.getHoSoNhanVienId(luat.getHoSoId());
            new ResKyLuat(
                    luat.getId(),
                    luat.getBatDau(),
                    luat.getKetThuc(),
                    luat.getHinhThuc(),
                    luat.getHanhViViPhamChinh(),
                    luat.getCoQuanQuyetDinhId(),
                    coQuanToChucDonViClient.getName(luat.getCoQuanQuyetDinhId()),
                    luat.getXacNhan(),
                    luat.getHoSoId(),
                    tomTatClient.hoVaTen(),
                    tomTatClient.soCCCD(),
                    luat.getCreateAt(),
                    luat.getUpdateAt()
            );
        }
        return null;
    }
}
