package com.hrm.hoso.client.data_chung.chuc_vu_dang;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "chuc-danh-dang", url = "${moduleUrl.cau-hinh}")
public interface ChucVuDangClient {
    @GetMapping("/chuc-danh-dang-name/{id}")
    String getName(@PathVariable int id);
}
