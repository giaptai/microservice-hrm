package com.hrm.hoso_chitiet.client.moi_quan_he;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "moi-quan-he-gia-dinh", url = "${moduleUrl.cau-hinh}")
public interface MoiQuanHeClient {
    @GetMapping("/moi-quan-he-name/{id}")
    String getName(@PathVariable(name = "id") int id);
}
