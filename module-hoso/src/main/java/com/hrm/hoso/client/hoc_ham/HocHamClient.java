package com.hrm.hoso.client.hoc_ham;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "hoc-ham", url = "${moduleUrl.cau-hinh}")
public interface HocHamClient {
    @GetMapping("/hoc-ham-name/{id}")
    String getName(@PathVariable(name = "id") int id);
}
