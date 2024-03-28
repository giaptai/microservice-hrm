package com.hrm.hoso_chitiet.dto.mapper;

import com.hrm.hoso_chitiet.dto.response.ResKhenThuong;
import com.hrm.hoso_chitiet.models.KhenThuong;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperKhenThuong {
    public ResKhenThuong maptoResKhenThuong(KhenThuong thuong) {
        return thuong != null ? new ResKhenThuong(
                thuong.getId(),
                thuong.getHoSoId(),
                thuong.getNam(),
                thuong.getXepLoaiChuyenMon(),
                thuong.getXepLoaiChuyenMon(),
                thuong.getXepLoaiThiDua(),
                thuong.getXepLoaiThiDua(),
                thuong.getHinhThucKhenThuongId(),
                thuong.getLyDo(),
                thuong.getXacNhan(),
                thuong.getCreate_at(),
                thuong.getUpdate_at()
        ) : null;
    }
}
