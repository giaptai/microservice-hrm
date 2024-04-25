package com.hrm.hoso_chitiet.dto.mapper;

import com.hrm.hoso_chitiet.client.coquan_tochuc_donvi.CoQuanToChucDonViClient;
import com.hrm.hoso_chitiet.client.ho_so.HoSoClient;
import com.hrm.hoso_chitiet.client.ho_so.ResHoSoTomTatClient;
import com.hrm.hoso_chitiet.dto.response.ResTinHoc;
import com.hrm.hoso_chitiet.models.TinHoc;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class MapperTinHoc {
    final CoQuanToChucDonViClient coQuanToChucDonViClient;
    final HoSoClient hoSoClient;

    public ResTinHoc mapToResTinHoc(TinHoc hoc) {
        if (hoc != null) {
            ResHoSoTomTatClient tomTatClient = hoSoClient.getHoSoNhanVienId(hoc.getHoSoId());
            return new ResTinHoc(
                    hoc.getId(),
                    hoc.getBatDau(),
                    hoc.getKetThuc(),
                    hoc.getTenCoSoDaoTaoId(),
                    coQuanToChucDonViClient.getName(hoc.getTenCoSoDaoTaoId()),
                    hoc.getChungChiDuocCap(),
                    hoc.getXacNhan(),
                    hoc.getHoSoId(),
                    tomTatClient.hoVaTen(),
                    tomTatClient.soCCCD(),
                    hoc.getCreateAt(),
                    hoc.getUpdateAt());
        } else return null;
    }
}
