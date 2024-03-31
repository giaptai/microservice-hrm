package com.hrm.taikhoan.dto.client.ly_luan_chinh_tri;

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

@FeignClient(name = "ly-luan-chinh-tri", url = "${moduleUrl.ho-so-chi-tiet}")
public interface LyLuanChinhTriClient {
    @GetMapping("/{id}/ly-luan-chinh-tri")
    List<LyLuanChinhTriDTO> getAllByHoSoId(@PathVariable UUID id);
    @GetMapping(value = "/ly-luan-chinh-tri")
    List<LyLuanChinhTri> getAll();

    @GetMapping("/ly-luan-chinh-tri/{id}")
    LyLuanChinhTri getById(@PathVariable int id);

    @PostMapping("/ly-luan-chinh-tri/{id}")
    LyLuanChinhTri add(@PathVariable UUID id, @RequestBody ReqLyLuanChinhTri cu);

    @PatchMapping("/ly-luan-chinh-tri/{id}")
    LyLuanChinhTri edit(@PathVariable int id, @RequestBody ReqLyLuanChinhTri cu);

    @DeleteMapping("/ly-luan-chinh-tri/{id}")
    boolean del(@PathVariable int id);
}
