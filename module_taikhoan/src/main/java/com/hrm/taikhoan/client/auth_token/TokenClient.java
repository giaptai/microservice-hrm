//package com.hrm.taikhoan.client.auth_token;
//
//import com.hrm.taikhoan.dto.resopnse.ResAuth;
//import org.springframework.cloud.openfeign.FeignClient;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//
//@FeignClient(name = "auth-token", url = "${moduleUrl.auth-token}")
//public interface TokenClient {
//    @GetMapping(value = "/jwt-login")
//    String taoToken(@RequestBody ResAuth auth);
//}
