package com.hrm.taikhoan.dto.resopnse;

public record QuenMatKhau(
        String email,
        String username,
        String password,
        String type
) {
    @Override
    public String toString() {
        return "{" +
                "\"email\":\"" + email + '\"' +
                ",\"username\":\"" + username + '\"' +
                ",\"password\":\"" + password + '\"' +
                ",\"type\":\"" + type + '\"' +
                '}';
    }
}
