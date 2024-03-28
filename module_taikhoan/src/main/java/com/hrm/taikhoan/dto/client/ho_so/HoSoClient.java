package com.hrm.taikhoan.dto.client.ho_so;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.UUID;

@FeignClient(name = "hoso", url = "${moduleUrl.ho-so}")
public interface HoSoClient {
    @GetMapping(value = "/ho-so")
    List<HoSoDTO> getAllHoSo();

    @GetMapping(value = "/ho-so/{id}")
    HoSoDTO getById(@PathVariable UUID id);

    @PatchMapping(value = "/ho-so/{id}")
    HoSoDTO editHoSoById(@PathVariable UUID id, @RequestBody ReqHoSoDTO req);

    @PatchMapping(value = "/ho-so/tim-kiem")
    String findHoSo();
}
