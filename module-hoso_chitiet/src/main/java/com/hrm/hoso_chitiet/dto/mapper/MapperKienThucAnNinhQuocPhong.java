package com.hrm.hoso_chitiet.dto.mapper;

import com.hrm.hoso_chitiet.client.coquan_tochuc_donvi.CoQuanToChucDonViClient;
import com.hrm.hoso_chitiet.client.ho_so.HoSoClient;
import com.hrm.hoso_chitiet.client.ho_so.ResHoSoTomTatClient;
import com.hrm.hoso_chitiet.dto.response.ResKienThucAnNinhQuocPhong;
import com.hrm.hoso_chitiet.models.KienThucAnNinhQuocPhong;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class MapperKienThucAnNinhQuocPhong {
    final CoQuanToChucDonViClient coQuanToChucDonViClient;
    final HoSoClient hoSoClient;
    public ResKienThucAnNinhQuocPhong mapToResKienThucAnNinhQuocPhong(KienThucAnNinhQuocPhong phong) {
        if( phong != null ){
            ResHoSoTomTatClient tomTatClient = hoSoClient.getHoSoNhanVienId(phong.getHoSoId());
            return new ResKienThucAnNinhQuocPhong(
                    phong.getId(),
                    phong.getBatDau(),
                    phong.getKetThuc(),
                    phong.getTenCoSoDaoTaoId(),
                    coQuanToChucDonViClient.getName(phong.getTenCoSoDaoTaoId()),
                    phong.getChungChiDuocCap(),
                    phong.getXacNhan(),
                    phong.getHoSoId(),
                    tomTatClient.hoVaTen(),
                    tomTatClient.soCCCD(),
                    phong.getCreateAt(),
                    phong.getUpdateAt());
        } else return null;
    }
}
