package hrm.module.cauhinh.dto.response;

import lombok.Builder;

@Builder
public record ResNgachCongChuc(
        String ma,
        String name,
        int heSoLuongCongChucId,
        int nhomCongChucId,
        String nhomCongChucName,
        int loaiCongChucId,
        String loaiCongChucLoai,
        String loaiCongChucName,
        int bacLuongId,
        String bacLuongName,
        float heSo
) {
}
