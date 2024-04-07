package hrm.module.cauhinh.dto.mapper;

import hrm.module.cauhinh.dto.response.ResNgachCongChuc;
import hrm.module.cauhinh.models.NgachCongChuc;
import org.springframework.stereotype.Component;

@Component
public class MapperNgachCongChuc {
    public ResNgachCongChuc mapToResNgachCongChuc(NgachCongChuc ngach) {
        return ngach != null ? new ResNgachCongChuc(
                ngach.getMa(),
                ngach.getName(),
                ngach.getHeSoLuongCongChucId().getId(),
                ngach.getHeSoLuongCongChucId().getNhomCongChucId().getId(),
                ngach.getHeSoLuongCongChucId().getNhomCongChucId().getName(),
                ngach.getHeSoLuongCongChucId().getNhomCongChucId().getLoaiCongChucId().getId(),
                ngach.getHeSoLuongCongChucId().getNhomCongChucId().getLoaiCongChucId().getLoai(),
                ngach.getHeSoLuongCongChucId().getNhomCongChucId().getLoaiCongChucId().getName(),
                ngach.getHeSoLuongCongChucId().getBacLuongId().getId(),
                ngach.getHeSoLuongCongChucId().getBacLuongId().getName(),
                ngach.getHeSoLuongCongChucId().getHeSo()
        ) : null;
    }
}
