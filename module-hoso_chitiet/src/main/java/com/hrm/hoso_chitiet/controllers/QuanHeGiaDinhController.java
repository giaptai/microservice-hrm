package com.hrm.hoso_chitiet.controllers;

import com.hrm.hoso_chitiet.dto.mapper.MapperQuanHeGiaDinh;
import com.hrm.hoso_chitiet.dto.request.ReqQuanHeGiaDinh;
import com.hrm.hoso_chitiet.dto.response.ResQuanHeGiaDinh;
import com.hrm.hoso_chitiet.models.QuanHeGiaDinh;
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
@Tag(name = "Quan hệ gia đình ")
@SecurityRequirement(name = "Bearer Authentication")
@RequiredArgsConstructor
public class QuanHeGiaDinhController {
    private final IHoSoChiTietServices.IHoQuanHeGiaDinhServiceChiTiet quanHeGiaDinhService;
    private final MapperQuanHeGiaDinh mapper;
    @GetMapping("/{id}/quan-he-gia-dinh")
    public ResponseEntity<List<ResQuanHeGiaDinh>> getAllByHoSoId(@PathVariable UUID id) {
        List<ResQuanHeGiaDinh> ls = quanHeGiaDinhService.xemDanhSachTheoHoSo(id).stream().map(mapper::mapToResQuanHeGiaDinh).toList();
        return new ResponseEntity<>(ls, ResEnum.THANH_CONG.getStatusCode());
    }
    @GetMapping("/quan-he-gia-dinh")
    public ResponseEntity<List<QuanHeGiaDinh>> getAll() {
        List<QuanHeGiaDinh> ls = quanHeGiaDinhService.xemDanhSach();
        return new ResponseEntity<>(ls, ResEnum.THANH_CONG.getStatusCode());
    }
    @GetMapping("/quan-he-gia-dinh/{id}")
    public ResponseEntity<QuanHeGiaDinh> getById(@PathVariable int id) {
        QuanHeGiaDinh ls = quanHeGiaDinhService.xemChiTiet(id);
        return new ResponseEntity<>(ls, ResEnum.THANH_CONG.getStatusCode());
    }

    @PostMapping("/quan-he-gia-dinh/{id}")
    @Transactional
    public ResponseEntity<QuanHeGiaDinh> add(@PathVariable UUID id, @RequestBody ReqQuanHeGiaDinh cu) {
        QuanHeGiaDinh ls = quanHeGiaDinhService.them(id, cu);
        return new ResponseEntity<>(ls, ResEnum.TAO_THANH_CONG.getStatusCode());
    }

    @PatchMapping("/quan-he-gia-dinh/{id}")
    public ResponseEntity<QuanHeGiaDinh> edit(@PathVariable int id, @RequestBody ReqQuanHeGiaDinh cu) {
        QuanHeGiaDinh ls = quanHeGiaDinhService.sua(id, cu);
        return new ResponseEntity<>(ls, ResEnum.CAP_NHAT_THANH_CONG.getStatusCode());
    }

    @DeleteMapping("/quan-he-gia-dinh/{id}")
    public ResponseEntity<Boolean> del(@PathVariable int id) {
        boolean ls = quanHeGiaDinhService.xoa(id);
        return new ResponseEntity<>(ls, ResEnum.XOA_THANH_CONG.getStatusCode());
    }
}
