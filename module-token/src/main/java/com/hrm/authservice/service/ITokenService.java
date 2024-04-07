package com.hrm.authservice.service;

import com.hrm.authservice.model.ResTaiKhoan;

public interface ITokenService {
    String taoToken(ResTaiKhoan resTaiKhoan);
}
