package com.hrm.taikhoan.dto.client.ho_so;

import com.hrm.taikhoan.enums.TinhTrangSucKhoe;

public record SucKhoeDTO(
        TinhTrangSucKhoe tinhTrangSucKhoe, //enum,
        float chieuCao,
        float canNang,
        int nhomMau //NhomMau nhomMau
) {
}
