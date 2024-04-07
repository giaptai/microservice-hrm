package com.hrm.hoso.client.chi_tiet.ky_luat;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.UUID;

@FeignClient(name = "ky-luat", url = "${moduleUrl.ho-so-chi-tiet}")
public interface KyLuatClient {
    @GetMapping("/{id}/ky-luat")
    List<KyLuatAuth> getAllByHoSoId(@PathVariable UUID id);
    @GetMapping(value = "/ky-luat")
    List<ResKyLuat> getAll();

    @GetMapping("/ky-luat/{id}")
    ResKyLuat getById(@PathVariable int id);

    @PostMapping("/ky-luat/{id}")
    ResKyLuat add(@PathVariable UUID id, @RequestBody ReqKyLuat cu);

    @PatchMapping("/ky-luat/{id}")
    ResKyLuat edit(@PathVariable int id, @RequestBody ReqKyLuat cu);

    @DeleteMapping("/ky-luat/{id}")
    boolean del(@PathVariable int id);
}
