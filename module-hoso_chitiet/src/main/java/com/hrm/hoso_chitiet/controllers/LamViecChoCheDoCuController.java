package com.hrm.hoso_chitiet.controllers;

import com.hrm.hoso_chitiet.dto.mapper.MapperLamViecChoCheDoCu;
import com.hrm.hoso_chitiet.dto.request.ReqLamViecChoCheDoCu;
import com.hrm.hoso_chitiet.dto.response.ResLamViecChoCheDoCu;
import com.hrm.hoso_chitiet.models.LamViecChoCheDoCu;
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
@Tag(name = "Làm việc cho chế đồ cũ ")
@SecurityRequirement(name = "Bearer Authentication")
@RequiredArgsConstructor // create constructor if field set final or @not null
public class LamViecChoCheDoCuController {
    private final IHoSoChiTietServices.ILamViecChoCheDoCuServiceChiTiet lamViecChoCheDoCuService;
    private final MapperLamViecChoCheDoCu mapper;
    @GetMapping("/ho-so/{id}/lam-viec-cho-che-do-cu")
    public ResponseEntity<List<ResLamViecChoCheDoCu>> getAllByHoSoId(@PathVariable UUID id) {
        List<ResLamViecChoCheDoCu> ls = lamViecChoCheDoCuService.xemDanhSachTheoHoSo(id).stream().map(mapper::maptoResBanThanCoLamViecChoCheDoCu).toList();
        return new ResponseEntity<>(ls, ResEnum.THANH_CONG.getStatusCode());
    }
    @GetMapping("/lam-viec-cho-che-do-cu")
    public ResponseEntity<List<LamViecChoCheDoCu>> getAll() {
        List<LamViecChoCheDoCu> ls = lamViecChoCheDoCuService.xemDanhSach();
        return new ResponseEntity<>(ls, ResEnum.THANH_CONG.getStatusCode());
    }
    @GetMapping("/lam-viec-cho-che-do-cu/{id}")
    public ResponseEntity<LamViecChoCheDoCu> getById(@PathVariable int id) {
        LamViecChoCheDoCu ls = lamViecChoCheDoCuService.xemChiTiet(id);
        return new ResponseEntity<>(ls, ResEnum.THANH_CONG.getStatusCode());
    }

    @PostMapping("/lam-viec-cho-che-do-cu/{id}")
    @Transactional
    public ResponseEntity<LamViecChoCheDoCu> add(@PathVariable UUID id, @RequestBody ReqLamViecChoCheDoCu cu) {
        LamViecChoCheDoCu ls = lamViecChoCheDoCuService.them(id, cu);
        return new ResponseEntity<>(ls, ResEnum.TAO_THANH_CONG.getStatusCode());
    }

    @PatchMapping("/lam-viec-cho-che-do-cu/{id}")
    public ResponseEntity<LamViecChoCheDoCu> edit(@PathVariable int id, @RequestBody ReqLamViecChoCheDoCu cu) {
        LamViecChoCheDoCu ls = lamViecChoCheDoCuService.sua(id, cu);
        return new ResponseEntity<>(ls, ResEnum.CAP_NHAT_THANH_CONG.getStatusCode());
    }

    @DeleteMapping("/lam-viec-cho-che-do-cu/{id}")
    public ResponseEntity<Boolean> del(@PathVariable int id) {
        boolean ls = lamViecChoCheDoCuService.xoa(id);
        return new ResponseEntity<>(ls, ResEnum.XOA_THANH_CONG.getStatusCode());
    }
}
