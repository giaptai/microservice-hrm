package com.hrm.hoso_chitiet.dto.mapper;

import com.hrm.hoso_chitiet.client.ho_so.HoSoClient;
import com.hrm.hoso_chitiet.client.ho_so.ResHoSoTomTatClient;
import com.hrm.hoso_chitiet.client.loai_phu_cap.LoaiPhuCapClient;
import com.hrm.hoso_chitiet.dto.response.ResPhuCapKhac;
import com.hrm.hoso_chitiet.models.PhuCapKhac;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class MapperPhuCapKhac {
    final LoaiPhuCapClient loaiPhuCapClient;
    final HoSoClient hoSoClient;

    public ResPhuCapKhac mapToResPhuCapKhac(PhuCapKhac khac) {
        if( khac != null) {
            ResHoSoTomTatClient tomTatClient = hoSoClient.getHoSoNhanVienId(khac.getHoSoId());
            return new ResPhuCapKhac(
                    khac.getId(),
                    khac.getBatDau(),
                    khac.getKetThuc(),
                    khac.getLoaiPhuCapId(),
                    loaiPhuCapClient.getName(khac.getLoaiPhuCapId()),
                    khac.getPhanTramHuongPhuCap(),
                    khac.getHeSoPhuCap(),
                    khac.getHinhThucHuong(),
                    khac.getGiaTri(),
                    khac.getXacNhan(),
                    khac.getHoSoId(),
                    tomTatClient.hoVaTen(),
                    tomTatClient.soCCCD(),
                    khac.getCreateAt(),
                    khac.getUpdateAt());
        } else return null;
    }
}
