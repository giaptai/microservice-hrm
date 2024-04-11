package com.hrm.hoso.dto.request;

import java.time.LocalDateTime;

public record ReqChucVu(
        int chucVuHienTaiId, //ChucVu chucVuHienTai
        LocalDateTime ngayBoNhiem,
        LocalDateTime ngayBoNhiemLai,
        String duocQuyHoacChucDanh,
        int coQuanToChucDonViTuyenDungId
) {
}
