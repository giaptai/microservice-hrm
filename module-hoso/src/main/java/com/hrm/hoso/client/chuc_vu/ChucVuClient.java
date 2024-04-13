package com.hrm.hoso.client.chuc_vu;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "chuc-vu", url = "${moduleUrl.cau-hinh}")
public interface ChucVuClient {
    @GetMapping("/chuc-vu-name/{id}")
    String getName(@PathVariable(name = "id") int id);
}
