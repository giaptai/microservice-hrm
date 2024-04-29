package hrm.module.cauhinh.dto.mapper;

import hrm.module.cauhinh.dto.response.ResHeSoLuongVienChuc;
import hrm.module.cauhinh.models.HeSoLuongVienChuc;
import org.springframework.stereotype.Component;

@Component
public class MapperHeSoLuongVienChuc {
    public ResHeSoLuongVienChuc mapToResHeSoLuongVienChuc(HeSoLuongVienChuc lam) {
        return lam != null ? new ResHeSoLuongVienChuc(
                lam.getId(),
                lam.getHeSo(),
                lam.getBacLuongId().getId(),
                lam.getBacLuongId().getName(),
                lam.getNhomVienChucId().getId(),
                lam.getNhomVienChucId().getName(),
                lam.getCreate_at(),
                lam.getUpdate_at()
        ) : null;
    }
}
