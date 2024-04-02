package com.hrm.taikhoan.dto.client.qua_trinh_cong_tac;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.UUID;

@FeignClient(name = "qua-trinh-cong-tac", url = "${moduleUrl.ho-so-chi-tiet}")
public interface QuaTrinhCongTacClient {
    @GetMapping("/{id}/qua-trinh-cong-tac")
    List<QuaTrinhCongTacDTO> getAllByHoSoId(@PathVariable UUID id);
    @GetMapping(value = "/qua-trinh-cong-tac")
    List<QuaTrinhCongTac> getAll();

    @GetMapping("/qua-trinh-cong-tac/{id}")
    QuaTrinhCongTac getById(@PathVariable int id);

    @PostMapping("/qua-trinh-cong-tac/{id}")
    QuaTrinhCongTac add(@PathVariable UUID id, @RequestBody ReqQuaTrinhCongTac cu);

    @PatchMapping("/qua-trinh-cong-tac/{id}")
    QuaTrinhCongTac edit(@PathVariable int id, @RequestBody ReqQuaTrinhCongTac cu);

    @DeleteMapping("/qua-trinh-cong-tac/{id}")
    boolean del(@PathVariable int id);
}
