package com.hrm.hoso.client.dan_toc;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "dan-toc", url = "${moduleUrl.cau-hinh}")
public interface DanTocClient {
    @GetMapping("/dan-toc-name/{id}")
    String getName(@PathVariable(name = "id") int id);
}
