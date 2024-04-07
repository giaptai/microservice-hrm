package com.hrm.hoso.client.chi_tiet.kien_thuc_an_ninh_quoc_phong;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.UUID;

@FeignClient(name = "kien-thuc-an-ninh-quoc-phong", url = "${moduleUrl.ho-so-chi-tiet}")
public interface KienThucAnNinhQuocPhongClient {
    @GetMapping("/{id}/kien-thuc-an-ninh-quoc-phong")
    List<KienThucAnNinhQuocPhongAuth> getAllByHoSoId(@PathVariable UUID id);

    @GetMapping(value = "/kien-thuc-an-ninh-quoc-phong")
    List<ResKienThucAnNinhQuocPhong> getAll();

    @GetMapping("/kien-thuc-an-ninh-quoc-phong/{id}")
    ResKienThucAnNinhQuocPhong getById(@PathVariable int id);

    @PostMapping("/kien-thuc-an-ninh-quoc-phong/{id}")
    ResKienThucAnNinhQuocPhong add(@PathVariable UUID id, @RequestBody ReqKienThucAnNinhQuocPhong cu);

    @PatchMapping("/kien-thuc-an-ninh-quoc-phong/{id}")
    ResKienThucAnNinhQuocPhong edit(@PathVariable int id, @RequestBody ReqKienThucAnNinhQuocPhong cu);

    @DeleteMapping("/kien-thuc-an-ninh-quoc-phong/{id}")
    boolean del(@PathVariable int id);
}
