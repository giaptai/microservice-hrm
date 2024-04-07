package hrm.module.cauhinh.dto.mapper;

import hrm.module.cauhinh.dto.response.ResNgachVienChuc;
import hrm.module.cauhinh.models.NgachVienChuc;
import org.springframework.stereotype.Component;

@Component
public class MapperNgachVienChuc {
    public ResNgachVienChuc mapToResNgachVienChuc(NgachVienChuc ngach) {
        return ngach != null ? new ResNgachVienChuc(
                ngach.getMa(),
                ngach.getName(),
                ngach.getHeSoLuongVienChucId().getId(),
                ngach.getHeSoLuongVienChucId().getNhomVienChucId().getId(),
                ngach.getHeSoLuongVienChucId().getNhomVienChucId().getName(),
                ngach.getHeSoLuongVienChucId().getNhomVienChucId().getLoaiVienChucId().getId(),
                ngach.getHeSoLuongVienChucId().getNhomVienChucId().getLoaiVienChucId().getLoai(),
                ngach.getHeSoLuongVienChucId().getNhomVienChucId().getLoaiVienChucId().getName(),
                ngach.getHeSoLuongVienChucId().getBacLuongId().getId(),
                ngach.getHeSoLuongVienChucId().getBacLuongId().getName(),
                ngach.getHeSoLuongVienChucId().getHeSo()
        ) : null;
    }
}
