package com.hrm.taikhoan.dto.client.khen_thuong;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.UUID;

@FeignClient(name = "khen-thuong", url = "${moduleUrl.ho-so-chi-tiet}")
public interface KhenThuongClient {
    @GetMapping(value = "/ho-so/{id}/khen-thuong")
    List<KhenThuongDTO> getAllByHoSoId(@PathVariable UUID id);

    @GetMapping(value = "/khen-thuong")
    List<KhenThuong> getAll();

    @GetMapping("/khen-thuong/{id}")
    KhenThuong getById(@PathVariable int id);

    @PostMapping("/khen-thuong/{id}")
    KhenThuong add(@PathVariable UUID id, @RequestBody ReqKhenThuong cu);

    @PatchMapping("/khen-thuong/{id}")
    KhenThuong edit(@PathVariable int id, @RequestBody ReqKhenThuong cu);

    @DeleteMapping("/khen-thuong/{id}")
    boolean del(@PathVariable int id);
}
