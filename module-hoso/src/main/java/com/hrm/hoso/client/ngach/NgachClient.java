package com.hrm.hoso.client.ngach;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ngach", url = "${moduleUrl.cau-hinh}")
public interface NgachClient {
    @GetMapping("/ngach-cong-chuc/{id}")
    NgachCongChuc getCongChucById(@PathVariable String id);
    @GetMapping("/ngach-vien-chuc/{id}")
    NgachVienChuc getVienChucById(@PathVariable String id);
}
