package com.hrm.hoso.client.nhom_mau;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "nhom-mau", url = "${moduleUrl.cau-hinh}")
public interface NhomMauClient {
    @GetMapping("/nhom-mau-name/{id}")
    String getName(@PathVariable(name = "id") int id);
}
