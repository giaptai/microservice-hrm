package com.hrm.hoso.dto.mapper;

import com.hrm.hoso.client.chuc_vu.ChucVuClient;
import com.hrm.hoso.client.coquan_tochuc_donvi.CoQuanToChucDonViClient;
import com.hrm.hoso.dto.response.ResChucVu;
import com.hrm.hoso.models.ChucVuHienTai;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class MapperChucVuHienTai {
    final ChucVuClient chucVuClient;
    final CoQuanToChucDonViClient coQuanClient;

    public ResChucVu mapToResChucVu(ChucVuHienTai chucVu) {
        if (chucVu == null) {
            return null;
        }
        String chucVuName = chucVuClient.getName(chucVu.getChucVuId());
        String coQuanName = coQuanClient.getName(chucVu.getCoQuanToChucDonViTuyenDungId());
        return new ResChucVu(
                chucVu.getChucVuId(),
                chucVuName,
                chucVu.getNgayBoNhiem(),
                chucVu.getNgayBoNhiemLai(),
                chucVu.getDuocQuyHoacChucDanh(),
                chucVu.getPhuCapChucVu(),
                chucVu.getCoQuanToChucDonViTuyenDungId(),
                coQuanName,
                "DA_XAC_NHAN",
                chucVu.getId()
        );
    }
}
