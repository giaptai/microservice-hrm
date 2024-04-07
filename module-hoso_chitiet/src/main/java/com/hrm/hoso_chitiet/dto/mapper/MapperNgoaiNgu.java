package com.hrm.hoso_chitiet.dto.mapper;

import com.hrm.hoso_chitiet.client.coquan_tochuc_donvi.CoQuanToChucDonViClient;
import com.hrm.hoso_chitiet.dto.response.ResNgoaiNgu;
import com.hrm.hoso_chitiet.models.NgoaiNgu;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class MapperNgoaiNgu {
    final CoQuanToChucDonViClient coQuanToChucDonViClient;
    public ResNgoaiNgu mapToResNgoaiNgu(NgoaiNgu ngu) {
        return ngu != null ? new ResNgoaiNgu(
                ngu.getId(),
                ngu.getBatDau(),
                ngu.getKetThuc(),
                ngu.getTenCoSoDaoTaoId(),
                coQuanToChucDonViClient.getName(ngu.getTenCoSoDaoTaoId()),
                ngu.getTenNgoaiNgu(),
                ngu.getChungChiDuocCap(),
                ngu.getDiemSo(),
                ngu.getXacNhan(),
                ngu.getHoSoId(),
                ngu.getCreate_at(),
                ngu.getUpdate_at()
        ) : null;
    }
}
