package com.hrm.hoso.dto.request;

import com.hrm.hoso.enums.TinhTrangSucKhoe;

public record ReqSucKhoe(
        TinhTrangSucKhoe tinhTrangSucKhoe, //enum,
        float chieuCao,
        float canNang,
        int nhomMau //NhomMau nhomMau
) {
}
