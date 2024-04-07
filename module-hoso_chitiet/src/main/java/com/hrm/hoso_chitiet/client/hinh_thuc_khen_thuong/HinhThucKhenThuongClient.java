package com.hrm.hoso_chitiet.client.hinh_thuc_khen_thuong;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "hinh-thuc-khen-thuong", url = "${moduleUrl.cau-hinh}")
public interface HinhThucKhenThuongClient {
    @GetMapping("/hinh-thuc-khen-thuong-name/{id}")
    String getName(@PathVariable int id);
}
