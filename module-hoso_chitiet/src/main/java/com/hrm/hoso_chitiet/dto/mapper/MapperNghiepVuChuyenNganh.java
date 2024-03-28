package com.hrm.hoso_chitiet.dto.mapper;

import com.hrm.hoso_chitiet.dto.response.ResNghiepVuChuyenNganh;
import com.hrm.hoso_chitiet.models.NghiepVuChuyenNganh;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperNghiepVuChuyenNganh {
    public ResNghiepVuChuyenNganh mapToResNghiepVuChuyenNganh(NghiepVuChuyenNganh nganh) {
        return nganh != null ? new ResNghiepVuChuyenNganh(
                nganh.getId(),
                nganh.getHoSoId(),
                nganh.getBatDau(),
                nganh.getKetThuc(),
                nganh.getTenCoSoDaoTaoId(),
                nganh.getChungChiDuocCap(),
                nganh.getXacNhan(),
                nganh.getCreate_at(),
                nganh.getUpdate_at()
        ) : null;
    }
}
