package com.hrm.hoso.dto.mapper;

import com.hrm.hoso.client.danh_hieu_nha_nuoc.DanhHieuNhaNuocClient;
import com.hrm.hoso.client.hoc_ham.HocHamClient;
import com.hrm.hoso.client.trinh_do_chuyen_mon.TrinhDoChuyenMonClient;
import com.hrm.hoso.client.trinh_do_giao_duc_pho_thong.TrinhDoGiaoDucPhoThongClient;
import com.hrm.hoso.dto.response.ResHocVan;
import com.hrm.hoso.models.HocVan;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class MapperHocVan {
    final TrinhDoGiaoDucPhoThongClient trinhDoGiaoDucPhoThongClient;
    final TrinhDoChuyenMonClient trinhDoChuyenMonClient;
    final HocHamClient hocHamClient;
    final DanhHieuNhaNuocClient danhHieuNhaNuocClient;

    public ResHocVan mapToResHocVan(HocVan hocVan) {
        if (hocVan == null) {
            return null;
        }
        String trinhDoGiaoDucPhoThongName = trinhDoGiaoDucPhoThongClient.getName(hocVan.getTrinhDoGiaoDucPhoThongId());
        String trinhDoChuyenMonName = trinhDoChuyenMonClient.getName(hocVan.getTrinhDoChuyenMonCaoNhatId());
        String hocHamName = hocHamClient.getName(hocVan.getHocHamId());
        String danhHieuNhaNuocPhongTangName = danhHieuNhaNuocClient.getName(hocVan.getDanhHieuNhaNuocPhongTangId());
        return new ResHocVan(
                hocVan.getTrinhDoGiaoDucPhoThongId(),
                trinhDoGiaoDucPhoThongName,
                hocVan.getTrinhDoChuyenMonCaoNhatId(),
                trinhDoChuyenMonName,
                hocVan.getHocHamId(),
                hocHamName,
                hocVan.getDanhHieuNhaNuocPhongTangId(),
                danhHieuNhaNuocPhongTangName
        );
    }
}
