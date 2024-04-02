package com.hrm.taikhoan.dto.client.nghiep_vu_chuyen_nganh;

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
    List<NghiepVuChuyenNganhDTO> getAllByHoSoId(@PathVariable UUID id);
    @GetMapping(value = "/nghiep-vu-chuyen-nganh")
    List<NghiepVuChuyenNganh> getAll();

    @GetMapping("/nghiep-vu-chuyen-nganh/{id}")
    NghiepVuChuyenNganh getById(@PathVariable int id);

    @PostMapping("/nghiep-vu-chuyen-nganh/{id}")
    NghiepVuChuyenNganh add(@PathVariable UUID id, @RequestBody ReqNghiepVuChuyenNganh cu);

    @PatchMapping("/nghiep-vu-chuyen-nganh/{id}")
    NghiepVuChuyenNganh edit(@PathVariable int id, @RequestBody ReqNghiepVuChuyenNganh cu);

    @DeleteMapping("/nghiep-vu-chuyen-nganh/{id}")
    boolean del(@PathVariable int id);
}
