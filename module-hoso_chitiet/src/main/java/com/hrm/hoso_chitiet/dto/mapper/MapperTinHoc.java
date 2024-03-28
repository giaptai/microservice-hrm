package com.hrm.hoso_chitiet.dto.mapper;

import com.hrm.hoso_chitiet.dto.response.ResTinHoc;
import com.hrm.hoso_chitiet.models.TinHoc;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperTinHoc {
    public ResTinHoc mapToResTinHoc(TinHoc hoc) {
        return hoc != null ? new ResTinHoc(
                hoc.getId(),
                hoc.getBatDau(),
                hoc.getKetThuc(),
                hoc.getTenCoSoDaoTaoId(),
                hoc.getChungChiDuocCap(),
                hoc.getCreate_at(),
                hoc.getUpdate_at()
        ) : null;
    }
}
