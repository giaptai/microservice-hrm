package com.hrm.hoso.dto.client;

import org.springframework.cloud.openfeign.FeignClient;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.UUID;

@FeignClient(name = "hoso-chitiet", url = "${moduleUrl.ho-so-chi-tiet}")
public interface HoSoChiTietClient {
    @GetMapping("/ho-so/{id}")
    ResHoSoChiTiet getAllByHoSoId(@PathVariable UUID id);
}
