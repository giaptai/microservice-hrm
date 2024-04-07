package com.hrm.authservice.controller;

import com.hrm.authservice.model.ResTaiKhoan;
import com.hrm.authservice.service.ITokenService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name = "Token", description = "The token API")
@RequiredArgsConstructor
public class TokenController {
    private final ITokenService authService;
    @GetMapping("/jwt-login")
    public ResponseEntity<String> taoToken(@RequestBody ResTaiKhoan resTaiKhoan) {
        String token = authService.taoToken(resTaiKhoan);
        return new ResponseEntity<>(token, HttpStatus.CREATED);
    }
}
