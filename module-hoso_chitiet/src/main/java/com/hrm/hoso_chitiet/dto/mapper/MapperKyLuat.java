package com.hrm.hoso_chitiet.dto.mapper;

import com.hrm.hoso_chitiet.client.coquan_tochuc_donvi.CoQuanToChucDonViClient;
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
    public ResKyLuat mapToResKyLuat(KyLuat luat) {
        return luat != null ? new ResKyLuat(
                luat.getId(),
                luat.getBatDau(),
                luat.getKetThuc(),
                luat.getHinhThuc(),
                luat.getHanhViViPhamChinh(),
                luat.getCoQuanQuyetDinhId(),
                coQuanToChucDonViClient.getName(luat.getCoQuanQuyetDinhId()),
                luat.getXacNhan(),
                luat.getHoSoId(),
                luat.getCreateAt(),
                luat.getUpdateAt()
        ) : null;
    }
}
