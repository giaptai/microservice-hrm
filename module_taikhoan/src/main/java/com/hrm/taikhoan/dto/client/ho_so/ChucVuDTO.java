package com.hrm.taikhoan.dto.client.ho_so;

import java.time.LocalDateTime;

public record ChucVuDTO(
        int chucVuHienTai, //ChucVu chucVuHienTai
        LocalDateTime ngayBoNhiem,
        LocalDateTime ngayBoNhiemLai,
        String duocQuyHoacChucDanh
) {
}
