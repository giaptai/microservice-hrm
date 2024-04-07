package com.hrm.hoso.client.cap_bac_loai_ham_quan_doi;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "cap-bac-loai-quan-ham-quan-doi", url = "${moduleUrl.cau-hinh}")
public interface CapBacLoaiHamQuanDoiClient {
    @GetMapping("/cap-bac-loai-quan-ham-quan-doi-name/{id}")
    String getName(@PathVariable int id);
}
