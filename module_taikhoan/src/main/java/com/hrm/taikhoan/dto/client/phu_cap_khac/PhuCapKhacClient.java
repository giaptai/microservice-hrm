package com.hrm.taikhoan.dto.client.phu_cap_khac;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.UUID;

@FeignClient(name = "phu-cap-khac", url = "${moduleUrl.ho-so-chi-tiet}")
public interface PhuCapKhacClient {
    @GetMapping("/{id}/phu-cap-khac")
    List<PhuCapKhacDTO> getAllByHoSoId(@PathVariable UUID id);
    @GetMapping(value = "/phu-cap-khac")
    List<PhuCapKhac> getAll();

    @GetMapping("/phu-cap-khac/{id}")
    PhuCapKhac getById(@PathVariable int id);

    @PostMapping("/phu-cap-khac/{id}")
    PhuCapKhac add(@PathVariable UUID id, @RequestBody ReqPhuCapKhac cu);

    @PatchMapping("/phu-cap-khac/{id}")
    PhuCapKhac edit(@PathVariable int id, @RequestBody ReqPhuCapKhac cu);

    @DeleteMapping("/phu-cap-khac/{id}")
    boolean del(@PathVariable int id);
}
