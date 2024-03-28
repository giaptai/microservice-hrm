package com.hrm.hoso_chitiet.dto.mapper;

import com.hrm.hoso_chitiet.dto.response.ResPhuCapKhac;
import com.hrm.hoso_chitiet.models.PhuCapKhac;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperPhuCapKhac {
    public ResPhuCapKhac mapToResPhuCapKhac(PhuCapKhac khac) {
        return khac != null ? new ResPhuCapKhac(
                khac.getId(),
                khac.getBatDau(),
                khac.getKetThuc(),
                khac.getLoaiPhuCapId(),
                khac.getPhanTramHuongPhuCap(),
                khac.getHeSoPhuCap(),
                khac.getHinhThucHuong(),
                khac.getGiaTri(),
                khac.getCreate_at(),
                khac.getUpdate_at()
        ) : null;
    }
}
