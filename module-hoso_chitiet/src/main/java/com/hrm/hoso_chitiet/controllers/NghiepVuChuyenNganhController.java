package com.hrm.hoso_chitiet.controllers;

import com.hrm.hoso_chitiet.dto.mapper.MapperNghiepVuChuyenNganh;
import com.hrm.hoso_chitiet.dto.request.ReqNghiepVuChuyenNganh;
import com.hrm.hoso_chitiet.dto.response.ResNghiepVuChuyenNganh;
import com.hrm.hoso_chitiet.models.NghiepVuChuyenNganh;
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
@Tag(name = "Nghiệp vụ chuyên ngành ", description = "Quản lý")
@SecurityRequirement(name = "Bearer Authentication")
@RequiredArgsConstructor
public class NghiepVuChuyenNganhController {
    private final IHoSoChiTietServices.IHoNghiepVuChuyenNganhServiceChiTiet nghiepVuChuyenNganhService;
    private final MapperNghiepVuChuyenNganh mapper;

    @GetMapping("/{id}/nghiep-vu-chuyen-nganh")
    public ResponseEntity<List<ResNghiepVuChuyenNganh>> getAllByHoSoId(@PathVariable UUID id) {
        List<ResNghiepVuChuyenNganh> ls = nghiepVuChuyenNganhService.xemDanhSachTheoHoSo(id).stream().map(mapper::mapToResNghiepVuChuyenNganh).toList();
        return new ResponseEntity<>(ls, ResEnum.THANH_CONG.getStatusCode());
    }

    @GetMapping("/nghiep-vu-chuyen-nganh")
    public ResponseEntity<List<NghiepVuChuyenNganh>> getAll() {
        List<NghiepVuChuyenNganh> ls = nghiepVuChuyenNganhService.xemDanhSach();
        return new ResponseEntity<>(ls, ResEnum.THANH_CONG.getStatusCode());
    }

    @GetMapping("/nghiep-vu-chuyen-nganh/{id}")
    public ResponseEntity<NghiepVuChuyenNganh> getById(@PathVariable int id) {
        NghiepVuChuyenNganh ls = nghiepVuChuyenNganhService.xemChiTiet(id);
        return new ResponseEntity<>(ls, ResEnum.THANH_CONG.getStatusCode());
    }

    @PostMapping("/nghiep-vu-chuyen-nganh/{id}")
    @Transactional
    public ResponseEntity<NghiepVuChuyenNganh> add(@PathVariable UUID id, @RequestBody ReqNghiepVuChuyenNganh cu) {
        NghiepVuChuyenNganh ls = nghiepVuChuyenNganhService.them(id, cu);
        return new ResponseEntity<>(ls, ResEnum.TAO_THANH_CONG.getStatusCode());
    }

    @PatchMapping("/nghiep-vu-chuyen-nganh/{id}")
    public ResponseEntity<NghiepVuChuyenNganh> edit(@PathVariable int id, @RequestBody ReqNghiepVuChuyenNganh cu) {
        NghiepVuChuyenNganh ls = nghiepVuChuyenNganhService.sua(id, cu);
        return new ResponseEntity<>(ls, ResEnum.CAP_NHAT_THANH_CONG.getStatusCode());
    }

    @DeleteMapping("/nghiep-vu-chuyen-nganh/{id}")
    public ResponseEntity<Boolean> del(@PathVariable int id) {
        boolean ls = nghiepVuChuyenNganhService.xoa(id);
        return new ResponseEntity<>(ls, ResEnum.XOA_THANH_CONG.getStatusCode());
    }
}
