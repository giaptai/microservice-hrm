package com.hrm.hoso.dto.mapper;

import com.hrm.hoso.client.chuc_vu.ChucVuClient;
import com.hrm.hoso.dto.response.ResChucVu;
import com.hrm.hoso.dto.response.ResChucVuKiemNhiem;
import com.hrm.hoso.models.ChucVuKiemNhiem;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class MapperChucVuKiemNhiem {
    final ChucVuClient chucVuClient;
    public ResChucVuKiemNhiem mapToResChucVuKiemNhiem(ChucVuKiemNhiem chucVu) {
        if (chucVu == null) {
            return null;
        }
        String chucVuName = chucVuClient.getName(chucVu.getChucVuId());
        return new ResChucVuKiemNhiem(
                chucVu.getChucVuId(),
                chucVuName,
                chucVu.getNgayBoNhiem(),
                chucVu.getPhuCapKiemNhiem(),
                chucVu.getPhuCapKhac(),
                chucVu.getId()
        );
    }
}
