package com.hrm.hoso.client.chi_tiet.khen_thuong;

import org.springframework.cloud.openfeign.FeignClient;
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
    @GetMapping(value = "/{id}/khen-thuong")
    List<KhenThuongAuth> getAllByHoSoId(@PathVariable UUID id);

    @GetMapping(value = "/khen-thuong")
    List<ResKhenThuong> getAll();

    @GetMapping("/khen-thuong/{id}")
    ResKhenThuong getById(@PathVariable int id);

    @PostMapping("/khen-thuong/{id}")
    ResKhenThuong add(@PathVariable UUID id, @RequestBody ReqKhenThuong cu);

    @PatchMapping("/khen-thuong/{id}")
    ResKhenThuong edit(@PathVariable int id, @RequestBody ReqKhenThuong cu);

    @DeleteMapping("/khen-thuong/{id}")
    boolean del(@PathVariable int id);
}
