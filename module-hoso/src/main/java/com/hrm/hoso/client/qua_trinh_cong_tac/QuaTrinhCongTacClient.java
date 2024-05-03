package com.hrm.hoso.client.qua_trinh_cong_tac;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.UUID;

@FeignClient(name = "qua-trinh-cong-tac", url = "${moduleUrl.ho-so-chi-tiet}")
public interface QuaTrinhCongTacClient {
    @PostMapping("/qua-trinh-cong-tac/{id}")
    ResQuaTrinhCongTac add(@PathVariable(name = "id") UUID id, @RequestBody ReqQuaTrinhCongTac cu);
}
