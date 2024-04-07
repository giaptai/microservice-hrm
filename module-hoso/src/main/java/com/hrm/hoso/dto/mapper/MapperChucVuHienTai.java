package com.hrm.hoso.dto.mapper;

import com.hrm.hoso.client.data_chung.chuc_vu.ChucVuClient;
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

    public ResChucVu mapToResChucVu(ChucVuHienTai chucVu) {
        if (chucVu == null) {
            return null;
        }
        String chucVuName = chucVuClient.getName(chucVu.getChucVuId());
        return new ResChucVu(
                chucVu.getChucVuId(),
                chucVuName,
                chucVu.getNgayBoNhiem(),
                chucVu.getNgayBoNhiemLai(),
                chucVu.getDuocQuyHoacChucDanh()
        );
    }
}
