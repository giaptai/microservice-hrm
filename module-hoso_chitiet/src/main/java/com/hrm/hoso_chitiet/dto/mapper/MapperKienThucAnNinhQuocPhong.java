package com.hrm.hoso_chitiet.dto.mapper;

import com.hrm.hoso_chitiet.dto.response.ResKienThucAnNinhQuocPhong;
import com.hrm.hoso_chitiet.models.KienThucAnNinhQuocPhong;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperKienThucAnNinhQuocPhong {
    public ResKienThucAnNinhQuocPhong mapToResKienThucAnNinhQuocPhong(KienThucAnNinhQuocPhong phong) {
        return phong != null ? new ResKienThucAnNinhQuocPhong(
                phong.getId(),
                phong.getBatDau(),
                phong.getKetThuc(),
                phong.getTenCoSoDaoTaoId(),
                phong.getChungChiDuocCap(),
                phong.getXacNhan(),
                phong.getCreate_at(),
                phong.getUpdate_at()
        ) : null;
    }
}
