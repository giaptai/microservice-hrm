package com.hrm.hoso_chitiet.controllers;

import com.hrm.hoso_chitiet.dto.mapper.MapperKyLuat;
import com.hrm.hoso_chitiet.dto.request.ReqKyLuat;
import com.hrm.hoso_chitiet.dto.response.ResKyLuat;
import com.hrm.hoso_chitiet.models.KyLuat;
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
@Tag(name = "Kỷ luật ")
@SecurityRequirement(name = "Bearer Authentication")
@RequiredArgsConstructor // create constructor if field set final or @not null
public class KyLuatController {
    private final IHoSoChiTietServices.IHoKyLuatServiceChiTiet kyLuatService;
    private final MapperKyLuat mapper;
    @GetMapping("/ho-so/{id}/ky-luat")
    public ResponseEntity<List<ResKyLuat>> getAllByHoSoId(@PathVariable UUID id) {
        List<ResKyLuat> ls = kyLuatService.xemDanhSachTheoHoSo(id).stream().map(mapper::mapToResKyLuat).toList();
        return new ResponseEntity<>(ls, ResEnum.THANH_CONG.getStatusCode());
    }
    @GetMapping("/ky-luat")
    public ResponseEntity<List<KyLuat>> getAll() {
        List<KyLuat> ls = kyLuatService.xemDanhSach();
        return new ResponseEntity<>(ls, ResEnum.THANH_CONG.getStatusCode());
    }
    @GetMapping("/ky-luat/{id}")
    public ResponseEntity<KyLuat> getById(@PathVariable int id) {
        KyLuat ls = kyLuatService.xemChiTiet(id);
        return new ResponseEntity<>(ls, ResEnum.THANH_CONG.getStatusCode());
    }

    @PostMapping("/ky-luat/{id}")
    @Transactional
    public ResponseEntity<KyLuat> add(@PathVariable UUID id, @RequestBody ReqKyLuat cu) {
        KyLuat ls = kyLuatService.them(id, cu);
        return new ResponseEntity<>(ls, ResEnum.TAO_THANH_CONG.getStatusCode());
    }

    @PatchMapping("/ky-luat/{id}")
    public ResponseEntity<KyLuat> edit(@PathVariable int id, @RequestBody ReqKyLuat cu) {
        KyLuat ls = kyLuatService.sua(id, cu);
        return new ResponseEntity<>(ls, ResEnum.CAP_NHAT_THANH_CONG.getStatusCode());
    }

    @DeleteMapping("/ky-luat/{id}")
    public ResponseEntity<Boolean> del(@PathVariable int id) {
        boolean ls = kyLuatService.xoa(id);
        return new ResponseEntity<>(ls, ResEnum.XOA_THANH_CONG.getStatusCode());
    }
}
