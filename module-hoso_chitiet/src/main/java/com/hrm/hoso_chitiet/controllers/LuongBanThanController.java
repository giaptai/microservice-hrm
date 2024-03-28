package com.hrm.hoso_chitiet.controllers;

import com.hrm.hoso_chitiet.dto.mapper.MapperLuongBanThan;
import com.hrm.hoso_chitiet.dto.request.ReqLuongBanThan;
import com.hrm.hoso_chitiet.dto.response.ResLuongBanThan;
import com.hrm.hoso_chitiet.models.LuongBanThan;
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
@Tag(name = "Lương bản thân ")
@SecurityRequirement(name = "Bearer Authentication")
@RequiredArgsConstructor // create constructor if field set final or @not null
public class LuongBanThanController {
    private final IHoSoChiTietServices.IHoLuongBanThanServiceChiTiet luongBanThanService;
    private final MapperLuongBanThan mapper;

    @GetMapping("/ho-so/{id}/luong-ban-than")
    public ResponseEntity<List<ResLuongBanThan>> getAllByHoSoId(@PathVariable UUID id) {
        List<ResLuongBanThan> ls = luongBanThanService.xemDanhSachTheoHoSo(id).stream().map(mapper::mapToResLuongBanThan).toList();
        return new ResponseEntity<>(ls, ResEnum.THANH_CONG.getStatusCode());
    }

    @GetMapping("/luong-ban-than")
    public ResponseEntity<List<LuongBanThan>> getAll() {
        List<LuongBanThan> ls = luongBanThanService.xemDanhSach();
        return new ResponseEntity<>(ls, ResEnum.THANH_CONG.getStatusCode());
    }

    @GetMapping("/luong-ban-than/{id}")
    public ResponseEntity<LuongBanThan> getById(@PathVariable int id) {
        LuongBanThan ls = luongBanThanService.xemChiTiet(id);
        return new ResponseEntity<>(ls, ResEnum.THANH_CONG.getStatusCode());
    }

    @PostMapping("/luong-ban-than/{id}")
    @Transactional
    public ResponseEntity<LuongBanThan> add(@PathVariable UUID id, @RequestBody ReqLuongBanThan cu) {
        LuongBanThan ls = luongBanThanService.them(id, cu);
        return new ResponseEntity<>(ls, ResEnum.TAO_THANH_CONG.getStatusCode());
    }

    @PatchMapping("/luong-ban-than/{id}")
    public ResponseEntity<LuongBanThan> edit(@PathVariable int id, @RequestBody ReqLuongBanThan cu) {
        LuongBanThan ls = luongBanThanService.sua(id, cu);
        return new ResponseEntity<>(ls, ResEnum.CAP_NHAT_THANH_CONG.getStatusCode());
    }

    @DeleteMapping("/luong-ban-than/{id}")
    public ResponseEntity<Boolean> del(@PathVariable int id) {
        boolean ls = luongBanThanService.xoa(id);
        return new ResponseEntity<>(ls, ResEnum.XOA_THANH_CONG.getStatusCode());
    }
}
