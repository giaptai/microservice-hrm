package com.hrm.hoso.client.coquan_tochuc_donvi;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "coquan-tochuc-donvi", url = "${moduleUrl.cau-hinh}")
public interface CoQuanToChucDonViClient {
    @GetMapping("/coquan-tochuc-donvi-name/{id}")
    String getName(@PathVariable(name = "id") int id);
}
