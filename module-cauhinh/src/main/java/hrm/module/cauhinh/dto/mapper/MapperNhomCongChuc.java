package hrm.module.cauhinh.dto.mapper;

import hrm.module.cauhinh.dto.response.ResNhomCongChuc;
import hrm.module.cauhinh.models.NhomCongChuc;
import org.springframework.stereotype.Component;

@Component
public class MapperNhomCongChuc {
    public ResNhomCongChuc mapToResNhomCongChuc(NhomCongChuc lam) {
        return lam != null ? new ResNhomCongChuc(
                lam.getId(),
                lam.getName(),
                lam.getLoaiCongChucId().getId(),
                lam.getLoaiCongChucId().getLoai(),
                lam.getCreate_at(),
                lam.getUpdate_at()
        ) : null;
    }
}
