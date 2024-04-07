package hrm.module.cauhinh.dto.mapper;

import hrm.module.cauhinh.dto.response.ResViTriViecLam;
import hrm.module.cauhinh.models.ViTriViecLam;
import org.springframework.stereotype.Component;

@Component
public class MapperViTriViecLam {
    public ResViTriViecLam mapToResViTriViecLam(ViTriViecLam lam) {
        return lam != null ? new ResViTriViecLam(
                lam.getId(),
                lam.getName(),
                lam.getBacLuongId().getId(),
                lam.getBacLuongId().getName(),
                lam.getTienLuong(),
                lam.getCreate_at(),
                lam.getUpdate_at()
        ) : null;
    }
}
