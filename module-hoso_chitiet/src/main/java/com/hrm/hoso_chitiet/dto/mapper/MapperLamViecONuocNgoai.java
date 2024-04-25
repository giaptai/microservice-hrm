package com.hrm.hoso_chitiet.dto.mapper;

import com.hrm.hoso_chitiet.client.ho_so.HoSoClient;
import com.hrm.hoso_chitiet.client.ho_so.ResHoSoTomTatClient;
import com.hrm.hoso_chitiet.dto.response.ResLamViecONuocNgoai;
import com.hrm.hoso_chitiet.models.LamViecONuocNgoai;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class MapperLamViecONuocNgoai {
    final HoSoClient hoSoClient;

    public ResLamViecONuocNgoai mapToResLamViecONuocNgoai(LamViecONuocNgoai ngoai) {
        if (ngoai != null) {
            ResHoSoTomTatClient tomTatClient = hoSoClient.getHoSoNhanVienId(ngoai.getHoSoId());
            return new ResLamViecONuocNgoai(
                    ngoai.getId(),
                    ngoai.getBatDau(),
                    ngoai.getKetThuc(),
                    ngoai.getToChucDiaChiCongViec(),
                    ngoai.getXacNhan(),
                    ngoai.getHoSoId(),
                    tomTatClient.hoVaTen(),
                    tomTatClient.soCCCD(),
                    ngoai.getCreateAt(),
                    ngoai.getUpdateAt());
        } else return null;
    }
}
