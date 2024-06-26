package com.hrm.hoso_chitiet.controllers;

import com.hrm.hoso_chitiet.dto.request.ReqKhenThuong;
import com.hrm.hoso_chitiet.dto.response.ResKhenThuong;

import com.hrm.hoso_chitiet.dto.response.ResTheDTO;
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
@Tag(name = "Khen Thưởng ")
@SecurityRequirement(name = "Bearer Authentication")
@RequiredArgsConstructor // create constructor if field set final or @not null
public class KhenThuongController {
    private final IHoSoChiTietServices.IHoKhenThuongServiceChiTiet khenThuongService;

    @GetMapping("/{id}/khen-thuong")
    public ResponseEntity<ResTheDTO<ResKhenThuong>> getAllByHoSoId(
            @PathVariable(name = "id") UUID id,
            @RequestParam(name = "pheDuyet", required = false) XacNhan xacNhan,
            @RequestParam(name = "sort", required = false, defaultValue = "createAt") String byDate,
            @RequestParam(name = "page", required = false, defaultValue = "0") int pageNumber,
            @RequestParam(name = "size", required = false, defaultValue = "10") int pageSize) {
        ResTheDTO<ResKhenThuong> ls = khenThuongService.xemDanhSachTheoHoSoId(id, xacNhan, byDate, pageNumber, pageSize);
        return new ResponseEntity<>(ls, ResEnum.THANH_CONG.getStatusCode());
    }

    @GetMapping("/khen-thuong")
    public ResponseEntity<ResTheDTO<ResKhenThuong>> getAll(
            @RequestParam(name = "pheDuyet", required = false) XacNhan xacNhan,
            @RequestParam(name = "sort", required = false, defaultValue = "createAt") String byDate,
            @RequestParam(name = "page", required = false, defaultValue = "0") int pageNumber,
            @RequestParam(name = "size", required = false, defaultValue = "10") int pageSize
    ) {
        ResTheDTO<ResKhenThuong> ls = khenThuongService.xemDanhSach(xacNhan, byDate, pageNumber, pageSize);
        return new ResponseEntity<>(ls, ResEnum.THANH_CONG.getStatusCode());
    }

    @GetMapping("/khen-thuong/{id}")
    public ResponseEntity<ResKhenThuong> getById(@PathVariable(name = "id") int id) {
        ResKhenThuong ls = khenThuongService.xemChiTiet(id);
        return new ResponseEntity<>(ls, ResEnum.THANH_CONG.getStatusCode());
    }

    @PostMapping("/khen-thuong/{id}")
    @Transactional
    public ResponseEntity<ResKhenThuong> add(@PathVariable(name = "id") UUID id, @RequestBody ReqKhenThuong cu) {
        ResKhenThuong ls = khenThuongService.them(id, cu);
        return new ResponseEntity<>(ls, ResEnum.TAO_THANH_CONG.getStatusCode());
    }

    @PatchMapping("/khen-thuong/{id}")
    public ResponseEntity<ResKhenThuong> edit(
            @RequestHeader(name = "role", required = false) String role,
            @PathVariable(name = "id") int id,
            @RequestBody ReqKhenThuong cu) {
        ResKhenThuong ls = khenThuongService.sua(id, cu, role);
        return new ResponseEntity<>(ls, ResEnum.CAP_NHAT_THANH_CONG.getStatusCode());
    }

    @DeleteMapping("/khen-thuong/{id}")
    public ResponseEntity<Boolean> del(
            @RequestHeader(name = "role", required = false) String role,
            @PathVariable(name = "id") int id
    ) {
        boolean ls = khenThuongService.xoa(id, role);
        return new ResponseEntity<>(ls, ResEnum.XOA_THANH_CONG.getStatusCode());
    }

    @PatchMapping("/khen-thuong/phe-duyet")
    public ResponseEntity<Boolean> approve(
            @RequestHeader(name = "role", required = false) String role,
            @RequestParam(name = "pheDuyet") XacNhan xacNhan,
            @RequestBody List<ResKhenThuong> res
    ) {
        boolean ls = khenThuongService.xacNhan(xacNhan, res);
        return new ResponseEntity<>(ls, ResEnum.CAP_NHAT_THANH_CONG.getStatusCode());
    }

    //EMPLOYEE
    @GetMapping("/ca-nhan/khen-thuong")
    public ResponseEntity<ResTheDTO<ResKhenThuong>> getAllCaNhan(
            @RequestHeader(name = "taiKhoanId", required = false) int id,
            @RequestParam(name = "pheDuyet", required = false) XacNhan xacNhan,
            @RequestParam(name = "sort", required = false, defaultValue = "createAt") String byDate,
            @RequestParam(name = "page", required = false, defaultValue = "0") int pageNumber,
            @RequestParam(name = "size", required = false, defaultValue = "10") int pageSize
    ) {
        ResTheDTO<ResKhenThuong> ls = khenThuongService.xemDanhSachCaNhan(id, xacNhan, byDate, pageNumber, pageSize);
        return new ResponseEntity<>(ls, ResEnum.THANH_CONG.getStatusCode());
    }

    @GetMapping("/ca-nhan/khen-thuong/{id}")
    public ResponseEntity<ResKhenThuong> getByIdCaNhan(@PathVariable(name = "id") int id) {
        ResKhenThuong ls = khenThuongService.xemChiTiet(id);
        return new ResponseEntity<>(ls, ResEnum.THANH_CONG.getStatusCode());
    }

    @PostMapping("/ca-nhan/khen-thuong")
    @Transactional
    public ResponseEntity<ResKhenThuong> addCaNhan(@RequestHeader(name = "taiKhoanId", required = false) int id, @RequestBody ReqKhenThuong cu) {
        ResKhenThuong ls = khenThuongService.themCaNhan(id, cu);
        return new ResponseEntity<>(ls, ResEnum.TAO_THANH_CONG.getStatusCode());
    }

    @PatchMapping("/ca-nhan/khen-thuong/{id}")
    public ResponseEntity<ResKhenThuong> editCaNhan(
            @RequestHeader(name = "role", required = false) String role,
            @PathVariable(name = "id") int id,
            @RequestBody ReqKhenThuong cu) {
        ResKhenThuong ls = khenThuongService.sua(id, cu, role);
        return new ResponseEntity<>(ls, ResEnum.CAP_NHAT_THANH_CONG.getStatusCode());
    }

    @DeleteMapping("/ca-nhan/khen-thuong/{id}")
    public ResponseEntity<Boolean> delCaNhan(
            @RequestHeader(name = "role", required = false) String role,
            @PathVariable(name = "id") int id) {
        boolean ls = khenThuongService.xoa(id, role);
        return new ResponseEntity<>(ls, ResEnum.XOA_THANH_CONG.getStatusCode());
    }
}
