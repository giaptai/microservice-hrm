package com.hrm.hoso.dto.mapper;

import com.hrm.hoso.client.data_chung.cap_bac_loai_ham_quan_doi.CapBacLoaiHamQuanDoiClient;
import com.hrm.hoso.dto.response.ResQuanSu;
import com.hrm.hoso.models.NghiaVuQuanSu;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class MapperQuanSu {
    final CapBacLoaiHamQuanDoiClient capBacLoaiHamQuanDoiClient;

    public ResQuanSu mapToResQuanSu(NghiaVuQuanSu quanSu) {
        if (quanSu == null) {
            return null;
        }
        String capBacLoaiQuanHamQuanDoiName = capBacLoaiHamQuanDoiClient.getName(quanSu.getQuanHamCaoNhatId());
        return new ResQuanSu(
                quanSu.getNgayNhapNgu(),
                quanSu.getNgayXuatNgu(),
                quanSu.getQuanHamCaoNhatId(),
                capBacLoaiQuanHamQuanDoiName
        );
    }
}
