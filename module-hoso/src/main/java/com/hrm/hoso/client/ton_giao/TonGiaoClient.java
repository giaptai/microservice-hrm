package com.hrm.hoso.client.ton_giao;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ton-giao", url = "${moduleUrl.cau-hinh}")
public interface TonGiaoClient {
    @GetMapping("/ton-giao-name/{id}")
    String getName(@PathVariable int id);
}
