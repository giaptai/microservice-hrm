package com.hrm.authservice.client;

import com.hrm.authservice.dto.ReqAuthLogin;
import com.hrm.authservice.model.TaiKhoanDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "hoso", url = "${moduleUrl.tai-khoan}")
public interface TaiKhoanClient {
    @PostMapping(value = "/dang-nhap")
    TaiKhoanDTO dangNhap(@RequestBody ReqAuthLogin authLogin);

    @PostMapping(value = "/tai-khoan")
    TaiKhoanDTO dangNhap0(@RequestBody ReqAuthLogin login);
}
