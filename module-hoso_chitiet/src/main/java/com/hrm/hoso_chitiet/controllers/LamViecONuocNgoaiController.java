package com.hrm.hoso_chitiet.controllers;

import com.hrm.hoso_chitiet.dto.mapper.MapperKyLuat;
import com.hrm.hoso_chitiet.dto.mapper.MapperLamViecONuocNgoai;
import com.hrm.hoso_chitiet.dto.request.ReqLamViecONuocNgoai;
import com.hrm.hoso_chitiet.dto.response.ResLamViecONuocNgoai;
import com.hrm.hoso_chitiet.models.LamViecONuocNgoai;
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
@Tag(name = "Làm việc ở nước ngoài ")
@SecurityRequirement(name = "Bearer Authentication")
@RequiredArgsConstructor // create constructor if field set final or @not null
public class LamViecONuocNgoaiController {
    private final IHoSoChiTietServices.IHoLamViecONuocNgoaiServiceChiTiet lamViecONuocNgoaiService;
    private final MapperLamViecONuocNgoai mapper;
    @GetMapping("/ho-so/{id}/lam-viec-o-nuoc-ngoai")
    public ResponseEntity<List<ResLamViecONuocNgoai>> getAllByHoSoId(@PathVariable UUID id) {
        List<ResLamViecONuocNgoai> ls = lamViecONuocNgoaiService.xemDanhSachTheoHoSo(id).stream().map(mapper::mapToResLamViecONuocNgoai).toList();
        return new ResponseEntity<>(ls, ResEnum.THANH_CONG.getStatusCode());
    }

    @GetMapping("/lam-viec-o-nuoc-ngoai")
    public ResponseEntity<List<LamViecONuocNgoai>> getAll() {
        List<LamViecONuocNgoai> ls = lamViecONuocNgoaiService.xemDanhSach();
        return new ResponseEntity<>(ls, ResEnum.THANH_CONG.getStatusCode());
    }

    @GetMapping("/lam-viec-o-nuoc-ngoai/{id}")
    public ResponseEntity<LamViecONuocNgoai> getById(@PathVariable int id) {
        LamViecONuocNgoai ls = lamViecONuocNgoaiService.xemChiTiet(id);
        return new ResponseEntity<>(ls, ResEnum.THANH_CONG.getStatusCode());
    }

    @PostMapping("/lam-viec-o-nuoc-ngoai/{id}")
    @Transactional
    public ResponseEntity<LamViecONuocNgoai> add(@PathVariable UUID id, @RequestBody ReqLamViecONuocNgoai cu) {
        LamViecONuocNgoai ls = lamViecONuocNgoaiService.them(id, cu);
        return new ResponseEntity<>(ls, ResEnum.TAO_THANH_CONG.getStatusCode());
    }

    @PatchMapping("/lam-viec-o-nuoc-ngoai/{id}")
    public ResponseEntity<LamViecONuocNgoai> edit(@PathVariable int id, @RequestBody ReqLamViecONuocNgoai cu) {
        LamViecONuocNgoai ls = lamViecONuocNgoaiService.sua(id, cu);
        return new ResponseEntity<>(ls, ResEnum.CAP_NHAT_THANH_CONG.getStatusCode());
    }

    @DeleteMapping("/lam-viec-o-nuoc-ngoai/{id}")
    public ResponseEntity<Boolean> del(@PathVariable int id) {
        boolean ls = lamViecONuocNgoaiService.xoa(id);
        return new ResponseEntity<>(ls, ResEnum.XOA_THANH_CONG.getStatusCode());
    }
}
