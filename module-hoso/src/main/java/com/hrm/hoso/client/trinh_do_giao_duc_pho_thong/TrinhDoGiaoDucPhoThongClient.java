package com.hrm.hoso.client.trinh_do_giao_duc_pho_thong;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "trinh-do-giao-duc-pho-thong", url = "${moduleUrl.cau-hinh}")
public interface TrinhDoGiaoDucPhoThongClient {
    @GetMapping("/trinh-do-giao-duc-pho-thong-name/{id}")
    String getName(@PathVariable int id);
}
