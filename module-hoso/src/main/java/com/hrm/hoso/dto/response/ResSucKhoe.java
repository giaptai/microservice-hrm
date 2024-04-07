package com.hrm.hoso.dto.response;

import com.hrm.hoso.enums.TinhTrangSucKhoe;

public record ResSucKhoe(
        TinhTrangSucKhoe tinhTrangSucKhoe, //enum,
        float chieuCao,
        float canNang,
        int nhomMau, //NhomMau nhomMau
        String nhomMauName
) {
}
