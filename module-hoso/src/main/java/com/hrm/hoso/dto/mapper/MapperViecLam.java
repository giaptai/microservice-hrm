package com.hrm.hoso.dto.mapper;

import com.hrm.hoso.client.data_chung.vi_tri_viec_lam.ViTriViecLam;
import com.hrm.hoso.client.data_chung.vi_tri_viec_lam.ViTriViecLamClient;
import com.hrm.hoso.dto.response.ResViecLam;
import com.hrm.hoso.models.ViecLam;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class MapperViecLam {
    final ViTriViecLamClient viTriViecLamClient;

    public ResViecLam mapToResViecLam(ViecLam viecLam) {
        if (viecLam == null) {
            return null;
        }
        ViTriViecLam viTriViecLam = viTriViecLamClient.getName(viecLam.getViTriViecLam());
        return viTriViecLam != null ? new ResViecLam(
                viecLam.getViTriViecLam(),
                viTriViecLam.name(),
                viTriViecLam.bacLuongId(),
                viTriViecLam.bacLuongName(),
                viTriViecLam.tienLuong(),
                viecLam.getNgayHuongLuongTheoViTriViecLam(),
                viecLam.getPhamTramHuongLuong(),
                viecLam.getPhuCapThamNienVuotKhung(),
                viecLam.getNgayHuongPCTNVK()
        ) : new ResViecLam(
                viecLam.getViTriViecLam(),
                "",
                0,
                "",
                0,
                viecLam.getNgayHuongLuongTheoViTriViecLam(),
                viecLam.getPhamTramHuongLuong(),
                viecLam.getPhuCapThamNienVuotKhung(),
                viecLam.getNgayHuongPCTNVK()
        );
    }
}
