package com.hrm.taikhoan.client.ho_so;

import com.hrm.taikhoan.dto.request.ReqTaoHoSoClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "hoso", url = "${moduleUrl.ho-so}")
public interface HoSoClient {
    @PostMapping(value = "/nhan-vien/ho-so")
    HoSoDTO addHoSo(@RequestBody ReqTaoHoSoClient req);

    @GetMapping(value = "/ho-so-cccd")
    Boolean getHoSoCCCD(@RequestParam(name = "soCCCD") String soCCCD);
}
