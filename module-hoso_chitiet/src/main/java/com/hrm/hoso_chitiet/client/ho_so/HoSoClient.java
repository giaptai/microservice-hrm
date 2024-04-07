package com.hrm.hoso_chitiet.client.ho_so;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.UUID;

@FeignClient(name = "ho-so", url = "${moduleUrl.ho-so}")
public interface HoSoClient {
    @GetMapping(path = "/ho-so-id")
    UUID getHoSoId(@RequestHeader(name = "taiKhoanId") int id);
}
