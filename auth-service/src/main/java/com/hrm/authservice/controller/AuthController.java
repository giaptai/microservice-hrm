package com.hrm.authservice.controller;

import com.hrm.authservice.dto.ReqAuthLogin;
import com.hrm.authservice.dto.ResAuthLogin;
import com.hrm.authservice.service.IAuthService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name = "Login", description = "The login API")
@RequiredArgsConstructor
public class AuthController {

    private final IAuthService service;

    @PostMapping("/dang-nhap")
    public ResponseEntity<ResAuthLogin> dangNhap(@RequestBody ReqAuthLogin login) {
        ResAuthLogin taiKhoan = service.login(login);
        return new ResponseEntity<>(taiKhoan, HttpStatus.OK);
    }

}
