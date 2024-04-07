package hrm.module.cauhinh.dto.mapper;

import hrm.module.cauhinh.dto.response.ResNhomVienChuc;
import hrm.module.cauhinh.models.NhomVienChuc;
import org.springframework.stereotype.Component;

@Component
public class MapperNhomVienChuc {
    public ResNhomVienChuc mapToResNhomVienChuc(NhomVienChuc lam) {
        return lam != null ? new ResNhomVienChuc(
                lam.getId(),
                lam.getName(),
                lam.getLoaiVienChucId().getId(),
                lam.getLoaiVienChucId().getLoai(),
                lam.getCreate_at(),
                lam.getUpdate_at()
        ) : null;
    }
}
