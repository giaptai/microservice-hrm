package com.hrm.hoso.client.data_chung.danh_hieu_nha_nuoc;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "danh-hieu-nha-nuoc-phong", url = "${moduleUrl.cau-hinh}")
public interface DanhHieuNhaNuocClient {
    @GetMapping("/danh-hieu-nha-nuoc-phong-name/{id}")
    String getName(@PathVariable int id);
}
