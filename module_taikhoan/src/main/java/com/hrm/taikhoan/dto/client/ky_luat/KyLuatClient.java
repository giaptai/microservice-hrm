package com.hrm.taikhoan.dto.client.ky_luat;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
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
    List<KyLuatDTO> getAllByHoSoId(@PathVariable UUID id);
    @GetMapping(value = "/ky-luat")
    List<KyLuat> getAll();

    @GetMapping("/ky-luat/{id}")
    KyLuat getById(@PathVariable int id);

    @PostMapping("/ky-luat/{id}")
    KyLuat add(@PathVariable UUID id, @RequestBody ReqKyLuat cu);

    @PatchMapping("/ky-luat/{id}")
    KyLuat edit(@PathVariable int id, @RequestBody ReqKyLuat cu);

    @DeleteMapping("/ky-luat/{id}")
    boolean del(@PathVariable int id);
}
