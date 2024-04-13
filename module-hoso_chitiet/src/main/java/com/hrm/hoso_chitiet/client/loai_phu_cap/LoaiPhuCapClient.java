package com.hrm.hoso_chitiet.client.loai_phu_cap;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "loai-phu-cap", url = "${moduleUrl.cau-hinh}")
public interface LoaiPhuCapClient {
    @GetMapping("/loai-phu-cap-name/{id}")
    String getName(@PathVariable(name = "id") int id);
}
