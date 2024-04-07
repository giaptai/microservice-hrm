package com.hrm.hoso.client.chi_tiet.lam_viec_cho_che_do_cu;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.UUID;

@FeignClient(name = "lam-viec-cho-che-do-cu", url = "${moduleUrl.ho-so-chi-tiet}")
public interface LamViecChoCheDoCuClient {
    @GetMapping("/{id}/lam-viec-cho-che-do-cu")
    List<LamViecChoCheDoCuAuth> getAllByHoSoId(@PathVariable UUID id);

    @GetMapping(value = "/lam-viec-cho-che-do-cu")
    List<ResLamViecChoCheDoCu> getAll();

    @GetMapping("/lam-viec-cho-che-do-cu/{id}")
    ResLamViecChoCheDoCu getById(@PathVariable int id);

    @PostMapping("/lam-viec-cho-che-do-cu/{id}")
    ResLamViecChoCheDoCu add(@PathVariable UUID id, @RequestBody ReqLamViecChoCheDoCu cu);

    @PatchMapping("/lam-viec-cho-che-do-cu/{id}")
    ResLamViecChoCheDoCu edit(@PathVariable int id, @RequestBody ReqLamViecChoCheDoCu cu);

    @DeleteMapping("/lam-viec-cho-che-do-cu/{id}")
    boolean del(@PathVariable int id);
}
