package hrm.module.cauhinh.dto.response;

import lombok.Builder;

@Builder
public record ResNgachVienChuc(
        String ma,
        String name,
        int heSoLuongVienChucId,
        int nhomVienChucId,
        String nhomVienChucName,
        int loaiVienChucId,
        String loaiVienChucLoai,
        String loaiVienChucName,
        int bacLuongId,
        String bacLuongName,
        float heSo
) {
}
