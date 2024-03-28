package com.hrm.hoso_chitiet.controllers;

import com.hrm.hoso_chitiet.dto.mapper.MapperTinHoc;
import com.hrm.hoso_chitiet.dto.request.ReqTinHoc;
import com.hrm.hoso_chitiet.dto.response.ResTinHoc;
import com.hrm.hoso_chitiet.models.TinHoc;
import com.hrm.hoso_chitiet.response.ResDTO;
import com.hrm.hoso_chitiet.response.ResEnum;
import com.hrm.hoso_chitiet.services.IHoSoChiTietServices;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "")
@Tag(name = "Tin học ")
@SecurityRequirement(name = "Bearer Authentication")
@RequiredArgsConstructor
public class TinHocController {
    private final IHoSoChiTietServices.IHoTinHocServiceChiTiet tinHocService;
    private final MapperTinHoc mapper;

    @GetMapping("/ho-so/{id}/tin-hoc")
    public ResponseEntity<List<ResTinHoc>> getAllByHoSoId(@PathVariable UUID id) {
        List<ResTinHoc> ls = tinHocService.xemDanhSachTheoHoSo(id).stream().map(mapper::mapToResTinHoc).toList();
        return new ResponseEntity<>(ls, ResEnum.THANH_CONG.getStatusCode());
    }

    @GetMapping("/tin-hoc")
    public ResponseEntity<List<TinHoc>> getAll() {
        List<TinHoc> ls = tinHocService.xemDanhSach();
        return new ResponseEntity<>(ls, ResEnum.THANH_CONG.getStatusCode());
    }

    @GetMapping("/tin-hoc/{id}")
    public ResponseEntity<TinHoc> getById(@PathVariable int id) {
        TinHoc ls = tinHocService.xemChiTiet(id);
        return new ResponseEntity<>(ls, ResEnum.THANH_CONG.getStatusCode());
    }

    @PostMapping("/tin-hoc/{id}")
    @Transactional
    public ResponseEntity<TinHoc> add(@PathVariable UUID id, @RequestBody ReqTinHoc cu) {
        TinHoc ls = tinHocService.them(id, cu);
        return new ResponseEntity<>(ls, ResEnum.TAO_THANH_CONG.getStatusCode());
    }

    @PatchMapping("/tin-hoc/{id}")
    public ResponseEntity<TinHoc> edit(@PathVariable int id, @RequestBody ReqTinHoc cu) {
        TinHoc ls = tinHocService.sua(id, cu);
        return new ResponseEntity<>(ls, ResEnum.CAP_NHAT_THANH_CONG.getStatusCode());
    }

    @DeleteMapping("/tin-hoc/{id}")
    public ResponseEntity<Boolean> del(@PathVariable int id) {
        boolean ls = tinHocService.xoa(id);
        return new ResponseEntity<>(ls, ResEnum.XOA_THANH_CONG.getStatusCode());
    }
}