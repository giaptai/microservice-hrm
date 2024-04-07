package com.hrm.hoso.dto.response;

import java.time.LocalDateTime;

public record ResChucVu(
        int chucVuHienTai, //ChucVu chucVuHienTai
        String chucVuHienTaiName,
        LocalDateTime ngayBoNhiem,
        LocalDateTime ngayBoNhiemLai,
        String duocQuyHoacChucDanh
) {
}
