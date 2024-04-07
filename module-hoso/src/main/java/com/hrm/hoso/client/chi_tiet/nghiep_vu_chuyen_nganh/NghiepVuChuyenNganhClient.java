package com.hrm.hoso.client.chi_tiet.nghiep_vu_chuyen_nganh;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.UUID;

@FeignClient(name = "nghiep-vu-chuyen-nganh", url = "${moduleUrl.ho-so-chi-tiet}")
public interface NghiepVuChuyenNganhClient {
    @GetMapping("/{id}/nghiep-vu-chuyen-nganh")
    List<NghiepVuChuyenNganhAuth> getAllByHoSoId(@PathVariable UUID id);
    @GetMapping(value = "/nghiep-vu-chuyen-nganh")
    List<ResNghiepVuChuyenNganh> getAll();

    @GetMapping("/nghiep-vu-chuyen-nganh/{id}")
    ResNghiepVuChuyenNganh getById(@PathVariable int id);

    @PostMapping("/nghiep-vu-chuyen-nganh/{id}")
    ResNghiepVuChuyenNganh add(@PathVariable UUID id, @RequestBody ReqNghiepVuChuyenNganh cu);

    @PatchMapping("/nghiep-vu-chuyen-nganh/{id}")
    ResNghiepVuChuyenNganh edit(@PathVariable int id, @RequestBody ReqNghiepVuChuyenNganh cu);

    @DeleteMapping("/nghiep-vu-chuyen-nganh/{id}")
    boolean del(@PathVariable int id);
}
