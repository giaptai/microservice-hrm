package com.hrm.hoso_chitiet.controllers;

import com.hrm.hoso_chitiet.dto.mapper.MapperKhenThuong;
import com.hrm.hoso_chitiet.dto.request.ReqKhenThuong;
import com.hrm.hoso_chitiet.dto.response.ResKhenThuong;

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
    private final MapperKhenThuong mapper;

    @GetMapping("/{id}/khen-thuong")
    public ResponseEntity<List<ResKhenThuong>> getAllByHoSoId(
            @PathVariable UUID id,
            @RequestParam(name = "page", required = false, defaultValue = "0") int pageNumber,
            @RequestParam(name = "size", required = false, defaultValue = "10") int pageSize) {
        List<ResKhenThuong> ls = khenThuongService.xemDanhSachTheoHoSoId(id, pageNumber, pageSize).stream().map(mapper::maptoResKhenThuong).toList();
        return new ResponseEntity<>(ls, ResEnum.THANH_CONG.getStatusCode());
    }

    @GetMapping("/khen-thuong")
    public ResponseEntity<List<ResKhenThuong>> getAll(
            @RequestParam(name = "page", required = false, defaultValue = "0") int pageNumber,
            @RequestParam(name = "size", required = false, defaultValue = "10") int pageSize
    ) {
        List<ResKhenThuong> ls = khenThuongService.xemDanhSach(pageNumber, pageSize).stream().map(mapper::maptoResKhenThuong).toList();
        return new ResponseEntity<>(ls, ResEnum.THANH_CONG.getStatusCode());
    }

    @GetMapping("/khen-thuong/{id}")
    public ResponseEntity<ResKhenThuong> getById(@PathVariable int id) {
        ResKhenThuong ls = mapper.maptoResKhenThuong(khenThuongService.xemChiTiet(id));
        return new ResponseEntity<>(ls, ResEnum.THANH_CONG.getStatusCode());
    }

    @PostMapping("/khen-thuong/{id}")
    @Transactional
    public ResponseEntity<ResKhenThuong> add(@PathVariable UUID id, @RequestBody ReqKhenThuong cu) {
        ResKhenThuong ls = mapper.maptoResKhenThuong(khenThuongService.them(id, cu));
        return new ResponseEntity<>(ls, ResEnum.TAO_THANH_CONG.getStatusCode());
    }

    @PatchMapping("/khen-thuong/{id}")
    public ResponseEntity<ResKhenThuong> edit(@PathVariable int id, @RequestBody ReqKhenThuong cu) {
        ResKhenThuong ls = mapper.maptoResKhenThuong(khenThuongService.sua(id, cu));
        return new ResponseEntity<>(ls, ResEnum.CAP_NHAT_THANH_CONG.getStatusCode());
    }

    @DeleteMapping("/khen-thuong/{id}")
    public ResponseEntity<Boolean> del(@PathVariable int id) {
        boolean ls = khenThuongService.xoa(id);
        return new ResponseEntity<>(ls, ResEnum.XOA_THANH_CONG.getStatusCode());
    }

    //EMPLOYEE
    @GetMapping("/ca-nhan/khen-thuong")
    public ResponseEntity<List<ResKhenThuong>> getAllCaNhan(
            @RequestHeader(name = "taiKhoanId", required = false) int id,
            @RequestParam(name = "page", required = false, defaultValue = "0") int pageNumber,
            @RequestParam(name = "size", required = false, defaultValue = "10") int pageSize
    ) {
        List<ResKhenThuong> ls = khenThuongService.xemDanhSachCaNhan(id, pageNumber, pageSize).stream().map(mapper::maptoResKhenThuong).toList();
        return new ResponseEntity<>(ls, ResEnum.THANH_CONG.getStatusCode());
    }

    @PostMapping("/ca-nhan/khen-thuong")
    @Transactional
    public ResponseEntity<ResKhenThuong> addCaNhan(@RequestHeader(name = "taiKhoanId", required = false) int id, @RequestBody ReqKhenThuong cu) {
        ResKhenThuong ls = mapper.maptoResKhenThuong(khenThuongService.themCaNhan(id, cu));
        return new ResponseEntity<>(ls, ResEnum.TAO_THANH_CONG.getStatusCode());
    }

    @PatchMapping("/ca-nhan/khen-thuong/{id}")
    public ResponseEntity<ResKhenThuong> editCaNhan(@PathVariable int id, @RequestBody ReqKhenThuong cu) {
        ResKhenThuong ls = mapper.maptoResKhenThuong(khenThuongService.sua(id, cu));
        return new ResponseEntity<>(ls, ResEnum.CAP_NHAT_THANH_CONG.getStatusCode());
    }

    @DeleteMapping("/ca-nhan/khen-thuong/{id}")
    public ResponseEntity<Boolean> delCaNhan(@PathVariable int id) {
        boolean ls = khenThuongService.xoa(id);
        return new ResponseEntity<>(ls, ResEnum.XOA_THANH_CONG.getStatusCode());
    }
}
