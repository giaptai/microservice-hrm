package com.hrm.hoso_chitiet.dto.mapper;

import com.hrm.hoso_chitiet.dto.response.ResQuanHeGiaDinh;
import com.hrm.hoso_chitiet.models.QuanHeGiaDinh;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperQuanHeGiaDinh {
    public ResQuanHeGiaDinh mapToResQuanHeGiaDinh(QuanHeGiaDinh dinh) {
        return dinh != null ? new ResQuanHeGiaDinh(
                dinh.getId(),
                dinh.getMoiQuanHe(),
                dinh.getHoVaTen(),
                dinh.getNamSinh(),
                dinh.getThongTinThanNhan(),
                dinh.getCreate_at(),
                dinh.getUpdate_at()
        ) : null;
    }
}
