package com.hrm.hoso_chitiet.dto.mapper;

import com.hrm.hoso_chitiet.dto.response.ResKyLuat;
import com.hrm.hoso_chitiet.models.KyLuat;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperKyLuat {
    public ResKyLuat mapToResKyLuat(KyLuat luat) {
        return luat != null ? new ResKyLuat(
                luat.getId(),
                luat.getHoSoId(),
                luat.getBatDau(),
                luat.getKetThuc(),
                luat.getHinhThuc(),
                luat.getHanhViViPhamChinh(),
                luat.getCoQuanQuyetDinhId(),
                luat.getXacNhan(),
                luat.getCreate_at(),
                luat.getUpdate_at()
        ) : null;
    }
}
