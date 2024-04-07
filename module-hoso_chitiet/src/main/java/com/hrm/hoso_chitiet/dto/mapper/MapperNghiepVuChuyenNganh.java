package com.hrm.hoso_chitiet.dto.mapper;

import com.hrm.hoso_chitiet.client.coquan_tochuc_donvi.CoQuanToChucDonViClient;
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
    public ResNghiepVuChuyenNganh mapToResNghiepVuChuyenNganh(NghiepVuChuyenNganh nganh) {
        return nganh != null ? new ResNghiepVuChuyenNganh(
                nganh.getId(),
                nganh.getBatDau(),
                nganh.getKetThuc(),
                nganh.getTenCoSoDaoTaoId(),
                coQuanToChucDonViClient.getName(nganh.getTenCoSoDaoTaoId()),
                nganh.getChungChiDuocCap(),
                nganh.getXacNhan(),
                nganh.getHoSoId(),
                nganh.getCreate_at(),
                nganh.getUpdate_at()
        ) : null;
    }
}
