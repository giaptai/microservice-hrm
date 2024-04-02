package com.hrm.taikhoan.dto.client.tin_hoc;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.UUID;

@FeignClient(name = "tin-hoc", url = "${moduleUrl.ho-so-chi-tiet}")
public interface TinHocClient {
    @GetMapping("/{id}/tin-hoc")
    List<TinHocDTO> getAllByHoSoId(@PathVariable UUID id);

    @GetMapping(value = "/tin-hoc")
    List<TinHoc> getAll();

    @GetMapping("/tin-hoc/{id}")
    TinHoc getById(@PathVariable int id);

    @PostMapping("/tin-hoc/{id}")
    TinHoc add(@PathVariable UUID id, @RequestBody ReqTinHoc cu);

    @PatchMapping("/tin-hoc/{id}")
    TinHoc edit(@PathVariable int id, @RequestBody ReqTinHoc cu);

    @DeleteMapping("/tin-hoc/{id}")
    boolean del(@PathVariable int id);
}
