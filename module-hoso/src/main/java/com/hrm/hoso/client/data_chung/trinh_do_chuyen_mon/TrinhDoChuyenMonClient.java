package com.hrm.hoso.client.data_chung.trinh_do_chuyen_mon;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "trinh-do-chuyen-mon", url = "${moduleUrl.cau-hinh}")
public interface TrinhDoChuyenMonClient {
    @GetMapping("/trinh-do-chuyen-mon-name/{id}")
    String getName(@PathVariable int id);
}
