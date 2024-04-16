package com.hrm.hoso_chitiet.dto.mapper;

import com.hrm.hoso_chitiet.client.moi_quan_he.MoiQuanHeClient;
import com.hrm.hoso_chitiet.dto.response.ResQuanHeGiaDinh;
import com.hrm.hoso_chitiet.models.QuanHeGiaDinh;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class MapperQuanHeGiaDinh {
    final MoiQuanHeClient moiQuanHeClient;
    public ResQuanHeGiaDinh mapToResQuanHeGiaDinh(QuanHeGiaDinh dinh) {
        return dinh != null ? new ResQuanHeGiaDinh(
                dinh.getId(),
                dinh.getMoiQuanHeId(),
                moiQuanHeClient.getName(dinh.getMoiQuanHeId()),
                dinh.getHoVaTen(),
                dinh.getNamSinh(),
                dinh.getThongTinThanNhan(),
                dinh.getXacNhan(),
                dinh.getHoSoId(),
                dinh.getCreate_at(),
                dinh.getUpdate_at()
        ) : null;
    }
}
