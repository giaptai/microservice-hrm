package com.hrm.hoso_chitiet.controllers;

import com.hrm.hoso_chitiet.dto.mapper.MapperPhuCapKhac;
import com.hrm.hoso_chitiet.dto.request.ReqPhuCapKhac;
import com.hrm.hoso_chitiet.dto.response.ResPhuCapKhac;
import com.hrm.hoso_chitiet.models.PhuCapKhac;
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
@Tag(name = "Phụ cấp khác ")
@SecurityRequirement(name = "Bearer Authentication")
@RequiredArgsConstructor
public class PhuCapKhacController {
    private final IHoSoChiTietServices.IHoPhuCapKhacServiceChiTiet phuCapKhacService;
    private final MapperPhuCapKhac mapper;

    @GetMapping("/ho-so/{id}/phu-cap-khac")
    public ResponseEntity<List<ResPhuCapKhac>> getAllByHoSoId(@PathVariable UUID id) {
        List<ResPhuCapKhac> ls = phuCapKhacService.xemDanhSachTheoHoSo(id).stream().map(mapper::mapToResPhuCapKhac).toList();
        return new ResponseEntity<>(ls, ResEnum.THANH_CONG.getStatusCode());
    }

    @GetMapping("/phu-cap-khac")
    public ResponseEntity<List<PhuCapKhac>> getAll() {
        List<PhuCapKhac> ls = phuCapKhacService.xemDanhSach();
        return new ResponseEntity<>(ls, ResEnum.THANH_CONG.getStatusCode());
    }

    @GetMapping("/phu-cap-khac/{id}")
    public ResponseEntity<PhuCapKhac> getById(@PathVariable int id) {
        PhuCapKhac ls = phuCapKhacService.xemChiTiet(id);
        return new ResponseEntity<>(ls, ResEnum.THANH_CONG.getStatusCode());
    }

    @PostMapping("/phu-cap-khac/{id}")
    @Transactional
    public ResponseEntity<PhuCapKhac> add(@PathVariable UUID id, @RequestBody ReqPhuCapKhac cu) {
        PhuCapKhac ls = phuCapKhacService.them(id, cu);
        return new ResponseEntity<>(ls, ResEnum.TAO_THANH_CONG.getStatusCode());
    }

    @PatchMapping("/phu-cap-khac/{id}")
    public ResponseEntity<PhuCapKhac> edit(@PathVariable int id, @RequestBody ReqPhuCapKhac cu) {
        PhuCapKhac ls = phuCapKhacService.sua(id, cu);
        return new ResponseEntity<>(ls, ResEnum.CAP_NHAT_THANH_CONG.getStatusCode());
    }

    @DeleteMapping("/phu-cap-khac/{id}")
    public ResponseEntity<Boolean> del(@PathVariable int id) {
        boolean ls = phuCapKhacService.xoa(id);
        return new ResponseEntity<>(ls, ResEnum.XOA_THANH_CONG.getStatusCode());
    }
}
