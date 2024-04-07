package com.hrm.hoso_chitiet.dto.mapper;

import com.hrm.hoso_chitiet.client.coquan_tochuc_donvi.CoQuanToChucDonViClient;
import com.hrm.hoso_chitiet.dto.response.ResKienThucAnNinhQuocPhong;
import com.hrm.hoso_chitiet.models.KienThucAnNinhQuocPhong;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class MapperKienThucAnNinhQuocPhong {
    final CoQuanToChucDonViClient coQuanToChucDonViClient;
    public ResKienThucAnNinhQuocPhong mapToResKienThucAnNinhQuocPhong(KienThucAnNinhQuocPhong phong) {
        return phong != null ? new ResKienThucAnNinhQuocPhong(
                phong.getId(),
                phong.getBatDau(),
                phong.getKetThuc(),
                phong.getTenCoSoDaoTaoId(),
                coQuanToChucDonViClient.getName(phong.getTenCoSoDaoTaoId()),
                phong.getChungChiDuocCap(),
                phong.getXacNhan(),
                phong.getHoSoId(),
                phong.getCreate_at(),
                phong.getUpdate_at()
        ) : null;
    }
}
