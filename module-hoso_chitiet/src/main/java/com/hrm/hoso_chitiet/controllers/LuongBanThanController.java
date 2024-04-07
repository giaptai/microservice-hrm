package com.hrm.hoso_chitiet.controllers;

import com.hrm.hoso_chitiet.dto.mapper.MapperLuongBanThan;
import com.hrm.hoso_chitiet.dto.request.ReqLuongBanThan;
import com.hrm.hoso_chitiet.dto.response.ResLuongBanThan;
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
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@Tag(name = "Lương bản thân ")
@SecurityRequirement(name = "Bearer Authentication")
@RequiredArgsConstructor // create constructor if field set final or @not null
public class LuongBanThanController {
    private final IHoSoChiTietServices.IHoLuongBanThanServiceChiTiet luongBanThanService;
    private final MapperLuongBanThan mapper;

    @GetMapping("/{id}/luong-ban-than")
    public ResponseEntity<List<ResLuongBanThan>> getAllByHoSoId(@PathVariable UUID id) {
        List<ResLuongBanThan> ls = luongBanThanService.xemDanhSachTheoHoSoId(id).stream().map(mapper::mapToResLuongBanThan).toList();
        return new ResponseEntity<>(ls, ResEnum.THANH_CONG.getStatusCode());
    }

    @GetMapping("/luong-ban-than")
    public ResponseEntity<List<ResLuongBanThan>> getAll() {
        List<ResLuongBanThan> ls = luongBanThanService.xemDanhSach().stream().map(mapper::mapToResLuongBanThan).toList();
        return new ResponseEntity<>(ls, ResEnum.THANH_CONG.getStatusCode());
    }

    @GetMapping("/luong-ban-than/{id}")
    public ResponseEntity<ResLuongBanThan> getById(@PathVariable int id) {
        ResLuongBanThan ls = mapper.mapToResLuongBanThan(luongBanThanService.xemChiTiet(id));
        return new ResponseEntity<>(ls, ResEnum.THANH_CONG.getStatusCode());
    }

    @PostMapping("/luong-ban-than/{id}")
    @Transactional
    public ResponseEntity<ResLuongBanThan> add(@PathVariable UUID id, @RequestBody ReqLuongBanThan cu) {
        ResLuongBanThan ls = mapper.mapToResLuongBanThan(luongBanThanService.them(id, cu));
        return new ResponseEntity<>(ls, ResEnum.TAO_THANH_CONG.getStatusCode());
    }

    @PatchMapping("/luong-ban-than/{id}")
    public ResponseEntity<ResLuongBanThan> edit(@PathVariable int id, @RequestBody ReqLuongBanThan cu) {
        ResLuongBanThan ls = mapper.mapToResLuongBanThan(luongBanThanService.sua(id, cu));
        return new ResponseEntity<>(ls, ResEnum.CAP_NHAT_THANH_CONG.getStatusCode());
    }

    @DeleteMapping("/luong-ban-than/{id}")
    public ResponseEntity<Boolean> del(@PathVariable int id) {
        boolean ls = luongBanThanService.xoa(id);
        return new ResponseEntity<>(ls, ResEnum.XOA_THANH_CONG.getStatusCode());
    }
    //EMPLOYEE
    @GetMapping("/ca-nhan/luong-ban-than")
    public ResponseEntity<List<ResLuongBanThan>> getAllCaNhan(@RequestHeader(name = "taiKhoanId") int id) {
        List<ResLuongBanThan> ls = luongBanThanService.xemDanhSachCaNhan(id).stream().map(mapper::mapToResLuongBanThan).toList();
        return new ResponseEntity<>(ls, ResEnum.THANH_CONG.getStatusCode());
    }

    @PostMapping("/ca-nhan/luong-ban-than")
    @Transactional
    public ResponseEntity<ResLuongBanThan> addCaNhan(@RequestHeader(name = "taiKhoanId") int id, @RequestBody ReqLuongBanThan cu) {
        ResLuongBanThan ls = mapper.mapToResLuongBanThan(luongBanThanService.themCaNhan(id, cu));
        return new ResponseEntity<>(ls, ResEnum.TAO_THANH_CONG.getStatusCode());
    }

    @PatchMapping("/ca-nhan/luong-ban-than/{id}")
    public ResponseEntity<ResLuongBanThan> editCaNhan(@PathVariable int id, @RequestBody ReqLuongBanThan cu) {
        ResLuongBanThan ls = mapper.mapToResLuongBanThan(luongBanThanService.sua(id, cu));
        return new ResponseEntity<>(ls, ResEnum.CAP_NHAT_THANH_CONG.getStatusCode());
    }

    @DeleteMapping("/ca-nhan/luong-ban-than/{id}")
    public ResponseEntity<Boolean> delCaNhan(@PathVariable int id) {
        boolean ls = luongBanThanService.xoa(id);
        return new ResponseEntity<>(ls, ResEnum.XOA_THANH_CONG.getStatusCode());
    }
}
