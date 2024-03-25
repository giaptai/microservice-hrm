package com.hrm.taikhoan.dto.resopnse;

public record ResTaiKhoanLogin(
        ResTaiKhoan taikhoan,
        String token
) {
}
