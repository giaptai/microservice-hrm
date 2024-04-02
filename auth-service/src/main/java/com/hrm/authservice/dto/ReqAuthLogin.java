package com.hrm.authservice.dto;

public record ReqAuthLogin(
        String username,
        String password
) {
}
