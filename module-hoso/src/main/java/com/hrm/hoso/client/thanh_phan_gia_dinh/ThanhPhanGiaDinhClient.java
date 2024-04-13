package com.hrm.hoso.client.thanh_phan_gia_dinh;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "thanh-phan-gia-dinh", url = "${moduleUrl.cau-hinh}")
public interface ThanhPhanGiaDinhClient {
    @GetMapping("/thanh-phan-gia-dinh-name/{id}")
    String getName(@PathVariable(name = "id") int id);
}
