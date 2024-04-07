package com.hrm.hoso.dto.request;

import java.time.LocalDateTime;

public record ReqChucVu(
        int chucVuHienTai, //ChucVu chucVuHienTai
        LocalDateTime ngayBoNhiem,
        LocalDateTime ngayBoNhiemLai,
        String duocQuyHoacChucDanh
) {
}
