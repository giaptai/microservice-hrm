package com.hrm.taikhoan.security;

import com.hrm.taikhoan.models.TaiKhoan;
import org.springframework.security.core.Authentication;


public interface IAuthenticationFacade {
    Authentication getAuthentication();

    TaiKhoan getTaiKhoan();
}
