package com.hrm.taikhoan.dto.resopnse;

public record ResTaiKhoanLogin(
        String username,
        String role,
        String token
) {
}
