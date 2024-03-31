package com.hrm.taikhoan.dto.client.luong_ban_than;

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

@FeignClient(name = "luong-ban-than", url = "${moduleUrl.ho-so-chi-tiet}")
public interface LuongBanThanClient {
    @GetMapping("/{id}/luong-ban-than")
    List<LuongBanThanDTO> getAllByHoSoId(@PathVariable UUID id);

    @GetMapping(value = "/luong-ban-than")
    List<LuongBanThan> getAll();

    @GetMapping("/luong-ban-than/{id}")
    LuongBanThan getById(@PathVariable int id);

    @PostMapping("/luong-ban-than/{id}")
    LuongBanThan add(@PathVariable UUID id, @RequestBody ReqLuongBanThan cu);

    @PatchMapping("/luong-ban-than/{id}")
    LuongBanThan edit(@PathVariable int id, @RequestBody ReqLuongBanThan cu);

    @DeleteMapping("/luong-ban-than/{id}")
    boolean del(@PathVariable int id);
}
