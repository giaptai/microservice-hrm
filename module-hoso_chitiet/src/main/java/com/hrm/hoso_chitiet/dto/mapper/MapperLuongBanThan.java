package com.hrm.hoso_chitiet.dto.mapper;

import com.hrm.hoso_chitiet.client.ho_so.HoSoClient;
import com.hrm.hoso_chitiet.client.ho_so.ResHoSoTomTatClient;
import com.hrm.hoso_chitiet.dto.response.ResLuongBanThan;
import com.hrm.hoso_chitiet.models.LuongBanThan;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class MapperLuongBanThan {
    final HoSoClient hoSoClient;

    public ResLuongBanThan mapToResLuongBanThan(LuongBanThan than) {
        if (than != null) {
            ResHoSoTomTatClient tomTatClient = hoSoClient.getHoSoNhanVienId(than.getHoSoId());
            return new ResLuongBanThan(
                    than.getId(),
                    than.getBatDau(),
                    than.getKetThuc(),
                    than.getMaSo(),
                    than.getBacLuong(),
                    than.getHeSoLuong(),
                    than.getTienLuongTheoViTri(),
                    than.getXacNhan(),
                    than.getHoSoId(),
                    tomTatClient.hoVaTen(),
                    tomTatClient.soCCCD(),
                    than.getCreateAt(),
                    than.getUpdateAt());
        } else return null;
    }
}
