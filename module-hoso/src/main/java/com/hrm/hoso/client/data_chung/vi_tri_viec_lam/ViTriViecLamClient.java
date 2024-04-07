package com.hrm.hoso.client.data_chung.vi_tri_viec_lam;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "vi-tri-viec-lam", url = "${moduleUrl.cau-hinh}")
public interface ViTriViecLamClient {
    @GetMapping("/vi-tri-viec-lam/{id}")
    ViTriViecLam getName(@PathVariable int id);
}
