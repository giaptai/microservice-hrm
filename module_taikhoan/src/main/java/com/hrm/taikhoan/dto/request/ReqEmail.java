package com.hrm.taikhoan.dto.request;

public record ReqEmail(
        String email
) {
    @Override
    public String toString() {
        return "{" +
                "\"email\":\"" + email + '\"' +
                '}';
    }
}
