package com.hrm.taikhoan.dto.client.lam_viec_o_nuoc_ngoai;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.UUID;

@FeignClient(name = "lam-viec-o-nuoc-ngoai", url = "${moduleUrl.ho-so-chi-tiet}")
public interface LamViecONuocNgoaiClient {
    @GetMapping("/{id}/lam-viec-o-nuoc-ngoai")
    List<LamViecONuocNgoaiDTO> getAllByHoSoId(@PathVariable UUID id);

    @GetMapping(value = "/lam-viec-o-nuoc-ngoai")
    List<LamViecONuocNgoai> getAll();

    @GetMapping("/lam-viec-o-nuoc-ngoai/{id}")
    LamViecONuocNgoai getById(@PathVariable int id);

    @PostMapping("/lam-viec-o-nuoc-ngoai/{id}")
    LamViecONuocNgoai add(@PathVariable UUID id, @RequestBody ReqLamViecONuocNgoai cu);

    @PatchMapping("/lam-viec-o-nuoc-ngoai/{id}")
    LamViecONuocNgoai edit(@PathVariable int id, @RequestBody ReqLamViecONuocNgoai cu);

    @DeleteMapping("/lam-viec-o-nuoc-ngoai/{id}")
    boolean del(@PathVariable int id);
}
