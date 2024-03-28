package com.hrm.hoso_chitiet.dto.mapper;

import com.hrm.hoso_chitiet.dto.response.ResLuongBanThan;
import com.hrm.hoso_chitiet.models.LuongBanThan;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperLuongBanThan {
    public ResLuongBanThan mapToResLuongBanThan(LuongBanThan than) {
        return than != null ? new ResLuongBanThan(
                than.getId(),
                than.getBatDau(),
                than.getKetThuc(),
                than.getMaSo(),
                than.getBacLuong(),
                than.getHeSoLuong(),
                than.getTienLuongTheoViTri(),
                than.getCreate_at(),
                than.getUpdate_at()
        ) : null;
    }
}
