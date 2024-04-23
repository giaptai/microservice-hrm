package com.hrm.hoso_chitiet.dto.mapper;

import com.hrm.hoso_chitiet.client.coquan_tochuc_donvi.CoQuanToChucDonViClient;
import com.hrm.hoso_chitiet.client.ho_so.HoSoClient;
import com.hrm.hoso_chitiet.client.ho_so.ResHoSoTomTatClient;
import com.hrm.hoso_chitiet.dto.response.ResNghiepVuChuyenNganh;
import com.hrm.hoso_chitiet.models.NghiepVuChuyenNganh;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class MapperNghiepVuChuyenNganh {
    final CoQuanToChucDonViClient coQuanToChucDonViClient;
    final HoSoClient hoSoClient;

    public ResNghiepVuChuyenNganh mapToResNghiepVuChuyenNganh(NghiepVuChuyenNganh nganh) {
        if (nganh != null) {
            ResHoSoTomTatClient tomTatClient = hoSoClient.getHoSoNhanVienId(nganh.getHoSoId());
            return new ResNghiepVuChuyenNganh(
                    nganh.getId(),
                    nganh.getBatDau(),
                    nganh.getKetThuc(),
                    nganh.getTenCoSoDaoTaoId(),
                    coQuanToChucDonViClient.getName(nganh.getTenCoSoDaoTaoId()),
                    nganh.getChungChiDuocCap(),
                    nganh.getXacNhan(),
                    nganh.getHoSoId(),
                    tomTatClient.hoVaTen(),
                    tomTatClient.soCCCD(),
                    nganh.getCreateAt(),
                    nganh.getUpdateAt()
            );
        } else return null;
    }
}
