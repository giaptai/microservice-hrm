package com.hrm.hoso.client.chi_tiet.quan_he_gia_dinh;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.UUID;

@FeignClient(name = "quan-he-gia-dinh", url = "${moduleUrl.ho-so-chi-tiet}")
public interface QuanHeGiaDinhClient {
    @GetMapping("/{id}/quan-he-gia-dinh")
    List<QuanHeGiaDinhAuth> getAllByHoSoId(@PathVariable UUID id);
    @GetMapping(value = "/quan-he-gia-dinh")
    List<ResQuanHeGiaDinh> getAll();

    @GetMapping("/quan-he-gia-dinh/{id}")
    ResQuanHeGiaDinh getById(@PathVariable int id);

    @PostMapping("/quan-he-gia-dinh/{id}")
    ResQuanHeGiaDinh add(@PathVariable UUID id, @RequestBody ReqQuanHeGiaDinh cu);

    @PatchMapping("/quan-he-gia-dinh/{id}")
    ResQuanHeGiaDinh edit(@PathVariable int id, @RequestBody ReqQuanHeGiaDinh cu);

    @DeleteMapping("/quan-he-gia-dinh/{id}")
    boolean del(@PathVariable int id);
}
