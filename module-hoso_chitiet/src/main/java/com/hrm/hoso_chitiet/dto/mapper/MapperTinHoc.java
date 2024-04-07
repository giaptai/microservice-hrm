package com.hrm.hoso_chitiet.dto.mapper;

import com.hrm.hoso_chitiet.client.coquan_tochuc_donvi.CoQuanToChucDonViClient;
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
    public ResTinHoc mapToResTinHoc(TinHoc hoc) {
        return hoc != null ? new ResTinHoc(
                hoc.getId(),
                hoc.getBatDau(),
                hoc.getKetThuc(),
                hoc.getTenCoSoDaoTaoId(),
                coQuanToChucDonViClient.getName(hoc.getTenCoSoDaoTaoId()),
                hoc.getChungChiDuocCap(),
                hoc.getHoSoId(),
                hoc.getCreate_at(),
                hoc.getUpdate_at()
        ) : null;
    }
}
