package com.hrm.authservice.service;

import com.hrm.authservice.dto.ReqAuthLogin;
import com.hrm.authservice.dto.ResAuthLogin;

public interface IAuthService {
    ResAuthLogin login(ReqAuthLogin login);
}
