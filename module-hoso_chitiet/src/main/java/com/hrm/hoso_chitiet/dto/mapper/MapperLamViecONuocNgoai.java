package com.hrm.hoso_chitiet.dto.mapper;

import com.hrm.hoso_chitiet.dto.response.ResLamViecONuocNgoai;
import com.hrm.hoso_chitiet.models.LamViecONuocNgoai;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperLamViecONuocNgoai {
    public ResLamViecONuocNgoai mapToResLamViecONuocNgoai(LamViecONuocNgoai ngoai) {
        return ngoai != null ? new ResLamViecONuocNgoai(
                ngoai.getId(),
                ngoai.getBatDau(),
                ngoai.getKetThuc(),
                ngoai.getToChucDiaChiCongViec(),
                ngoai.getXacNhan(),
                ngoai.getHoSoId(),
                ngoai.getCreateAt(),
                ngoai.getUpdateAt()
        ) : null;
    }
}
