package hrm.module.cauhinh.dto.mapper;

import hrm.module.cauhinh.dto.response.ResHeSoLuongCongChuc;
import hrm.module.cauhinh.models.HeSoLuongCongChuc;
import org.springframework.stereotype.Component;

@Component
public class MapperHeSoLuongCongChuc {
    public ResHeSoLuongCongChuc mapToResHeSoLuongCongChuc(HeSoLuongCongChuc lam) {
        return lam != null ? new ResHeSoLuongCongChuc(
                lam.getId(),
                lam.getHeSo(),
                lam.getBacLuongId().getId(),
                lam.getBacLuongId().getName(),
                lam.getNhomCongChucId().getId(),
                lam.getNhomCongChucId().getName(),
                lam.getCreate_at(),
                lam.getUpdate_at()
        ) : null;
    }
}
