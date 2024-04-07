package com.hrm.hoso_chitiet.dto.mapper;

import com.hrm.hoso_chitiet.client.hinh_thuc_khen_thuong.HinhThucKhenThuongClient;
import com.hrm.hoso_chitiet.dto.response.ResKhenThuong;
import com.hrm.hoso_chitiet.models.KhenThuong;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class MapperKhenThuong {
    final HinhThucKhenThuongClient hinhThucKhenThuongClient;

    public ResKhenThuong maptoResKhenThuong(KhenThuong thuong) {
        return thuong != null ?
                new ResKhenThuong(
                        thuong.getId(),
                        thuong.getNam(),
                        thuong.getXepLoaiChuyenMon(),
                        thuong.getXepLoaiThiDua(),
                        thuong.getHinhThucKhenThuongId(),
                        hinhThucKhenThuongClient.getName(thuong.getHinhThucKhenThuongId()),
                        thuong.getLyDo(),
                        thuong.getXacNhan(),
                        thuong.getHoSoId(),
                        thuong.getCreate_at(),
                        thuong.getUpdate_at()
                ) : null;
    }
}
