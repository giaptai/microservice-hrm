package com.hrm.hoso_chitiet.dto.mapper;

import com.hrm.hoso_chitiet.client.loai_phu_cap.LoaiPhuCapClient;
import com.hrm.hoso_chitiet.dto.response.ResPhuCapKhac;
import com.hrm.hoso_chitiet.models.PhuCapKhac;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class MapperPhuCapKhac {
    final LoaiPhuCapClient loaiPhuCapClient;
    public ResPhuCapKhac mapToResPhuCapKhac(PhuCapKhac khac) {
        return khac != null ? new ResPhuCapKhac(
                khac.getId(),
                khac.getBatDau(),
                khac.getKetThuc(),
                khac.getLoaiPhuCapId(),
                loaiPhuCapClient.getName(khac.getLoaiPhuCapId()),
                khac.getPhanTramHuongPhuCap(),
                khac.getHeSoPhuCap(),
                khac.getHinhThucHuong(),
                khac.getGiaTri(),
                khac.getXacNhan(),
                khac.getHoSoId(),
                khac.getCreate_at(),
                khac.getUpdate_at()
        ) : null;
    }
}
