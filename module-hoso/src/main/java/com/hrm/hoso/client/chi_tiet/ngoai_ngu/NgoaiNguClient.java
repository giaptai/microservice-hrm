package com.hrm.hoso.client.chi_tiet.ngoai_ngu;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.UUID;

@FeignClient(name = "ngoai-ngu", url = "${moduleUrl.ho-so-chi-tiet}")
public interface NgoaiNguClient {
    @GetMapping("/{id}/ngoai-ngu")
    List<NgoaiNguAuth> getAllByHoSoId(@PathVariable UUID id);
    @GetMapping(value = "/ngoai-ngu")
    List<ResNgoaiNgu> getAll();

    @GetMapping("/ngoai-ngu/{id}")
    ResNgoaiNgu getById(@PathVariable int id);

    @PostMapping("/ngoai-ngu/{id}")
    ResNgoaiNgu add(@PathVariable UUID id, @RequestBody ReqNgoaiNgu cu);

    @PatchMapping("/ngoai-ngu/{id}")
    ResNgoaiNgu edit(@PathVariable int id, @RequestBody ReqNgoaiNgu cu);

    @DeleteMapping("/ngoai-ngu/{id}")
    boolean del(@PathVariable int id);
}
