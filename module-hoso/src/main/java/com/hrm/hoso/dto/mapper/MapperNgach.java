package com.hrm.hoso.dto.mapper;

import com.hrm.hoso.client.ngach.NgachClient;
import com.hrm.hoso.client.ngach.NgachCongChuc;
import com.hrm.hoso.client.ngach.NgachVienChuc;
import com.hrm.hoso.dto.response.ResNgachNhanVien;
import com.hrm.hoso.models.NgachNhanVien;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class MapperNgach {
    final NgachClient ngachClient;
    public ResNgachNhanVien mapToResNgachNhanVien(NgachNhanVien ngach) {
        if (ngach == null) {
            return null;
        }
        if (ngach.getNgachId() == null) {
            return null;
        }
        NgachCongChuc congChuc = ngachClient.getCongChucById(ngach.getNgachId());
        NgachVienChuc vienChuc = ngachClient.getVienChucById(ngach.getNgachId());
        if (congChuc != null) {
            return new ResNgachNhanVien(
                    ngach.getNgachId(),
                    congChuc.name(),
                    congChuc.heSoLuongCongChucId(),
                    congChuc.nhomCongChucId(),
                    congChuc.nhomCongChucName(),
                    congChuc.loaiCongChucId(),
                    congChuc.loaiCongChucLoai(),
                    congChuc.loaiCongChucName(),
                    congChuc.bacLuongId(),
                    congChuc.bacLuongName(),
                    congChuc.heSo(),
                    ngach.getNgayBoNhiemNgach(),
                    ngach.getNgayHuongLuongNgach(),
                    ngach.getPhanTramHuongLuongNgach(),
                    ngach.getPhuCapThamNienVuotKhungNgach(),
                    ngach.getNgayHuongPCTNVKNgach()
            );
        }
        if (vienChuc != null) {
            return new ResNgachNhanVien(
                    ngach.getNgachId(),
                    vienChuc.name(),
                    vienChuc.heSoLuongVienChucId(),
                    vienChuc.nhomVienChucId(),
                    vienChuc.nhomVienChucName(),
                    vienChuc.loaiVienChucId(),
                    vienChuc.loaiVienChucLoai(),
                    vienChuc.loaiVienChucName(),
                    vienChuc.bacLuongId(),
                    vienChuc.bacLuongName(),
                    vienChuc.heSo(),
                    ngach.getNgayBoNhiemNgach(),
                    ngach.getNgayHuongLuongNgach(),
                    ngach.getPhanTramHuongLuongNgach(),
                    ngach.getPhuCapThamNienVuotKhungNgach(),
                    ngach.getNgayHuongPCTNVKNgach()
            );
        }
        return null;
    }
}
