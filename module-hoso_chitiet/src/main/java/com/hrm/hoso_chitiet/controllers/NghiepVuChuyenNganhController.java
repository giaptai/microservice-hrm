package com.hrm.hoso_chitiet.controllers;

import com.hrm.hoso_chitiet.dto.mapper.MapperNghiepVuChuyenNganh;
import com.hrm.hoso_chitiet.dto.request.ReqNghiepVuChuyenNganh;
import com.hrm.hoso_chitiet.dto.response.ResNghiepVuChuyenNganh;
import com.hrm.hoso_chitiet.enums.XacNhan;
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
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@Tag(name = "Nghiệp vụ chuyên ngành ")
@SecurityRequirement(name = "Bearer Authentication")
@RequiredArgsConstructor
public class NghiepVuChuyenNganhController {
    private final IHoSoChiTietServices.IHoNghiepVuChuyenNganhServiceChiTiet nghiepVuChuyenNganhService;
    private final MapperNghiepVuChuyenNganh mapper;

    @GetMapping("/{id}/nghiep-vu-chuyen-nganh")
    public ResponseEntity<List<ResNghiepVuChuyenNganh>> getAllByHoSoId(@PathVariable(name = "id") UUID id,
                                                                       @RequestParam(name = "pheDuyet", required = false) XacNhan xacNhan,
                                                                       @RequestParam(name = "sort", required = false, defaultValue = "createAt") String byDate,
                                                                       @RequestParam(name = "page", required = false, defaultValue = "0") int pageNumber,
                                                                       @RequestParam(name = "size", required = false, defaultValue = "10") int pageSize) {
        List<ResNghiepVuChuyenNganh> ls = nghiepVuChuyenNganhService.xemDanhSachTheoHoSoId(id, xacNhan, byDate, pageNumber, pageSize).stream().map(mapper::mapToResNghiepVuChuyenNganh).toList();
        return new ResponseEntity<>(ls, ResEnum.THANH_CONG.getStatusCode());
    }

    @GetMapping("/nghiep-vu-chuyen-nganh")
    public ResponseEntity<List<ResNghiepVuChuyenNganh>> getAll(
            @RequestParam(name = "pheDuyet", required = false) XacNhan xacNhan,
            @RequestParam(name = "sort", required = false, defaultValue = "createAt") String byDate,
            @RequestParam(name = "page", required = false, defaultValue = "0") int pageNumber,
            @RequestParam(name = "size", required = false, defaultValue = "10") int pageSize
    ) {
        List<ResNghiepVuChuyenNganh> ls = nghiepVuChuyenNganhService.xemDanhSach(xacNhan, byDate, pageNumber, pageSize).stream().map(mapper::mapToResNghiepVuChuyenNganh).toList();
        return new ResponseEntity<>(ls, ResEnum.THANH_CONG.getStatusCode());
    }

    @GetMapping("/nghiep-vu-chuyen-nganh/{id}")
    public ResponseEntity<ResNghiepVuChuyenNganh> getById(@PathVariable(name = "id") int id) {
        ResNghiepVuChuyenNganh ls = mapper.mapToResNghiepVuChuyenNganh(nghiepVuChuyenNganhService.xemChiTiet(id));
        return new ResponseEntity<>(ls, ResEnum.THANH_CONG.getStatusCode());
    }

    @PostMapping("/nghiep-vu-chuyen-nganh/{id}")
    @Transactional
    public ResponseEntity<ResNghiepVuChuyenNganh> add(@PathVariable(name = "id") UUID id, @RequestBody ReqNghiepVuChuyenNganh cu) {
        ResNghiepVuChuyenNganh ls = mapper.mapToResNghiepVuChuyenNganh(nghiepVuChuyenNganhService.them(id, cu));
        return new ResponseEntity<>(ls, ResEnum.TAO_THANH_CONG.getStatusCode());
    }

    @PatchMapping("/nghiep-vu-chuyen-nganh/{id}")
    public ResponseEntity<ResNghiepVuChuyenNganh> edit(
            @RequestHeader(name = "role", required = false) String role,
            @PathVariable(name = "id") int id, @RequestBody ReqNghiepVuChuyenNganh cu) {
        ResNghiepVuChuyenNganh ls = mapper.mapToResNghiepVuChuyenNganh(nghiepVuChuyenNganhService.sua(id, cu, role));
        return new ResponseEntity<>(ls, ResEnum.CAP_NHAT_THANH_CONG.getStatusCode());
    }

    @DeleteMapping("/nghiep-vu-chuyen-nganh/{id}")
    public ResponseEntity<Boolean> del(
            @RequestHeader(name = "role", required = false) String role,
            @PathVariable(name = "id") int id) {
        boolean ls = nghiepVuChuyenNganhService.xoa(id, role);
        return new ResponseEntity<>(ls, ResEnum.XOA_THANH_CONG.getStatusCode());
    }

    @PatchMapping("/nghiep-vu-chuyen-nganh/phe-duyet")
    public ResponseEntity<Boolean> approve(
            @RequestHeader(name = "role", required = false) String role,
            @RequestParam(name = "pheDuyet") XacNhan xacNhan,
            @RequestBody List<ResNghiepVuChuyenNganh> res
    ) {
        boolean ls = nghiepVuChuyenNganhService.xacNhan(xacNhan, res);
        return new ResponseEntity<>(ls, ResEnum.CAP_NHAT_THANH_CONG.getStatusCode());
    }

    //EMPLOYEE
    @GetMapping("/ca-nhan/nghiep-vu-chuyen-nganh")
    public ResponseEntity<List<ResNghiepVuChuyenNganh>> getAllCaNhan(@RequestHeader(name = "taiKhoanId", required = false) int id,
                                                                     @RequestParam(name = "pheDuyet", required = false) XacNhan xacNhan,
                                                                     @RequestParam(name = "sort", required = false, defaultValue = "createAt") String byDate,
                                                                     @RequestParam(name = "page", required = false, defaultValue = "0") int pageNumber,
                                                                     @RequestParam(name = "size", required = false, defaultValue = "10") int pageSize) {
        List<ResNghiepVuChuyenNganh> ls = nghiepVuChuyenNganhService.xemDanhSachCaNhan(id, xacNhan, byDate, pageNumber, pageSize).stream().map(mapper::mapToResNghiepVuChuyenNganh).toList();
        return new ResponseEntity<>(ls, ResEnum.THANH_CONG.getStatusCode());
    }

    @GetMapping("/ca-nhan/nghiep-vu-chuyen-nganh/{id}")
    public ResponseEntity<ResNghiepVuChuyenNganh> getByIdCaNhan(@PathVariable(name = "id") int id) {
        ResNghiepVuChuyenNganh ls = mapper.mapToResNghiepVuChuyenNganh(nghiepVuChuyenNganhService.xemChiTiet(id));
        return new ResponseEntity<>(ls, ResEnum.THANH_CONG.getStatusCode());
    }

    @PostMapping("/ca-nhan/nghiep-vu-chuyen-nganh")
    @Transactional
    public ResponseEntity<ResNghiepVuChuyenNganh> addCaNhan(@RequestHeader(name = "taiKhoanId", required = false) int id, @RequestBody ReqNghiepVuChuyenNganh cu) {
        ResNghiepVuChuyenNganh ls = mapper.mapToResNghiepVuChuyenNganh(nghiepVuChuyenNganhService.themCaNhan(id, cu));
        return new ResponseEntity<>(ls, ResEnum.TAO_THANH_CONG.getStatusCode());
    }

    @PatchMapping("/ca-nhan/nghiep-vu-chuyen-nganh/{id}")
    public ResponseEntity<ResNghiepVuChuyenNganh> editCaNhan(
            @RequestHeader(name = "role", required = false) String role,
            @PathVariable(name = "id") int id, @RequestBody ReqNghiepVuChuyenNganh cu) {
        ResNghiepVuChuyenNganh ls = mapper.mapToResNghiepVuChuyenNganh(nghiepVuChuyenNganhService.sua(id, cu, role));
        return new ResponseEntity<>(ls, ResEnum.CAP_NHAT_THANH_CONG.getStatusCode());
    }

    @DeleteMapping("/ca-nhan/nghiep-vu-chuyen-nganh/{id}")
    public ResponseEntity<Boolean> delCaNhan(
            @RequestHeader(name = "role", required = false) String role,
            @PathVariable(name = "id") int id) {
        boolean ls = nghiepVuChuyenNganhService.xoa(id, role);
        return new ResponseEntity<>(ls, ResEnum.XOA_THANH_CONG.getStatusCode());
    }
}
