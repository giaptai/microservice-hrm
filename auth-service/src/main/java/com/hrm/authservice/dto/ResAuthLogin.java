package com.hrm.authservice.dto;

public record ResAuthLogin(
        String username,
        String role,
        String token
) {
}
