package com.hrm.hoso.client.doi_tuong_chinh_sach;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "doi-tuong-chinh-sach", url = "${moduleUrl.cau-hinh}")
public interface DoiTuongChinhSachClient {
    @GetMapping("/doi-tuong-chinh-sach-name/{id}")
    String getName(@PathVariable int id);
}
