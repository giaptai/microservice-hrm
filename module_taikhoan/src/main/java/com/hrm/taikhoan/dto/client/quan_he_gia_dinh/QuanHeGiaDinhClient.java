package com.hrm.taikhoan.dto.client.quan_he_gia_dinh;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
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
    List<QuanHeGiaDinhDTO> getAllByHoSoId(@PathVariable UUID id);
    @GetMapping(value = "/quan-he-gia-dinh")
    List<QuanHeGiaDinh> getAll();

    @GetMapping("/quan-he-gia-dinh/{id}")
    QuanHeGiaDinh getById(@PathVariable int id);

    @PostMapping("/quan-he-gia-dinh/{id}")
    QuanHeGiaDinh add(@PathVariable UUID id, @RequestBody ReqQuanHeGiaDinh cu);

    @PatchMapping("/quan-he-gia-dinh/{id}")
    QuanHeGiaDinh edit(@PathVariable int id, @RequestBody ReqQuanHeGiaDinh cu);

    @DeleteMapping("/quan-he-gia-dinh/{id}")
    boolean del(@PathVariable int id);
}
