package com.hrm.hoso_chitiet.dto.mapper;

import com.hrm.hoso_chitiet.client.ho_so.HoSoClient;
import com.hrm.hoso_chitiet.client.ho_so.ResHoSoTomTatClient;
import com.hrm.hoso_chitiet.dto.response.ResLamViecChoCheDoCu;
import com.hrm.hoso_chitiet.models.LamViecChoCheDoCu;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class MapperLamViecChoCheDoCu {
    final HoSoClient hoSoClient;

    public ResLamViecChoCheDoCu maptoResLamViecChoCheDoCu(LamViecChoCheDoCu cu) {
        if (cu != null) {
            ResHoSoTomTatClient tomTatClient = hoSoClient.getHoSoNhanVienId(cu.getHoSoId());
            return new ResLamViecChoCheDoCu(
                    cu.getId(),
                    cu.getBatDau(),
                    cu.getKetThuc(),
                    cu.getChucDanhDonViDiaDiem(),
                    cu.getXacNhan(),
                    cu.getHoSoId(),
                    tomTatClient.hoVaTen(),
                    tomTatClient.soCCCD(),
                    cu.getCreateAt(),
                    cu.getUpdateAt());
        }else return null;
    }
}
