package com.hrm.hoso_chitiet.dto.mapper;

import com.hrm.hoso_chitiet.client.ho_so.HoSoClient;
import com.hrm.hoso_chitiet.client.ho_so.ResHoSoTomTatClient;
import com.hrm.hoso_chitiet.client.moi_quan_he.MoiQuanHeClient;
import com.hrm.hoso_chitiet.dto.response.ResQuanHeGiaDinh;
import com.hrm.hoso_chitiet.models.QuanHeGiaDinh;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class MapperQuanHeGiaDinh {
    final MoiQuanHeClient moiQuanHeClient;
    final HoSoClient hoSoClient;

    public ResQuanHeGiaDinh mapToResQuanHeGiaDinh(QuanHeGiaDinh dinh) {
        if( dinh != null) {
            ResHoSoTomTatClient tomTatClient = hoSoClient.getHoSoNhanVienId(dinh.getHoSoId());
            return new ResQuanHeGiaDinh(
                    dinh.getId(),
                    dinh.getMoiQuanHeId(),
                    moiQuanHeClient.getName(dinh.getMoiQuanHeId()),
                    dinh.getHoVaTen(),
                    dinh.getNamSinh(),
                    dinh.getThongTinThanNhan(),
                    dinh.getXacNhan(),
                    dinh.getHoSoId(),
                    tomTatClient.hoVaTen(),
                    tomTatClient.soCCCD(),
                    dinh.getCreateAt(),
                    dinh.getUpdateAt()
            );
        } return null;
    }
}
