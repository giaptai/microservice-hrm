package com.hrm.hoso.dto.mapper;

import com.hrm.hoso.client.danh_hieu_nha_nuoc.DanhHieuNhaNuocClient;
import com.hrm.hoso.client.hoc_ham.HocHamClient;
import com.hrm.hoso.client.trinh_do_chuyen_mon.TrinhDoChuyenMonClient;
import com.hrm.hoso.client.trinh_do_giao_duc_pho_thong.TrinhDoGiaoDucPhoThongClient;
import com.hrm.hoso.dto.response.ResHoSoTomTat;
import com.hrm.hoso.dto.response.ResHocVan;
import com.hrm.hoso.models.HoSo;
import com.hrm.hoso.models.HocVan;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class MapperHoSoTomTat {
    public ResHoSoTomTat mapToResHoSoTomTat(HoSo hoSo) {
        if (hoSo == null) {
            return null;
        }
        return new ResHoSoTomTat(
                hoSo.getId(),
                hoSo.getHoVaTen(),
                hoSo.getSoCCCD()
        );
    }
}
