package com.hrm.hoso_chitiet.dto.mapper;

import com.hrm.hoso_chitiet.dto.response.ResLamViecChoCheDoCu;
import com.hrm.hoso_chitiet.models.LamViecChoCheDoCu;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperLamViecChoCheDoCu {
    public ResLamViecChoCheDoCu maptoResBanThanCoLamViecChoCheDoCu(LamViecChoCheDoCu cu) {
        return cu != null ? new ResLamViecChoCheDoCu(
                cu.getId(),
                cu.getBatDau(),
                cu.getKetThuc(),
                cu.getChucDanhDonViDiaDiem(),
                cu.getCreate_at(),
                cu.getUpdate_at()
        ) : null;
    }
}
