package com.hrm.hoso_chitiet.dto.mapper;

import com.hrm.hoso_chitiet.dto.response.ResNgoaiNgu;
import com.hrm.hoso_chitiet.models.NgoaiNgu;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperNgoaiNgu {
    public ResNgoaiNgu mapToResNgoaiNgu(NgoaiNgu ngu) {
        return ngu != null ? new ResNgoaiNgu(
                ngu.getId(),
                ngu.getHoSoId(),
                ngu.getBatDau(),
                ngu.getKetThuc(),
                ngu.getTenCoSoDaoTaoId(),
                ngu.getTenNgoaiNgu(),
                ngu.getChungChiDuocCap(),
                ngu.getDiemSo(),
                ngu.getXacNhan(),
                ngu.getCreate_at(),
                ngu.getUpdate_at()
        ) : null;
    }
}
