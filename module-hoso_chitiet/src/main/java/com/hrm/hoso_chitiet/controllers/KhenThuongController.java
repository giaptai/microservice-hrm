package com.hrm.hoso_chitiet.controllers;

import com.hrm.hoso_chitiet.dto.mapper.MapperKhenThuong;
import com.hrm.hoso_chitiet.dto.request.ReqKhenThuong;
import com.hrm.hoso_chitiet.dto.response.ResKhenThuong;
import com.hrm.hoso_chitiet.models.KhenThuong;
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
@Tag(name = "Khen Thưởng ")
@SecurityRequirement(name = "Bearer Authentication")
@RequiredArgsConstructor // create constructor if field set final or @not null
public class KhenThuongController {
    private final IHoSoChiTietServices.IHoKhenThuongServiceChiTiet khenThuongService;
    private final MapperKhenThuong mapper;
    @GetMapping("/ho-so/{id}/khen-thuong")
    public ResponseEntity<List<ResKhenThuong>> getAllByHoSoId(@PathVariable UUID id) {
        List<ResKhenThuong> ls = khenThuongService.xemDanhSachTheoHoSo(id).stream().map(mapper::maptoResKhenThuong).toList();
        return new ResponseEntity<>(ls, ResEnum.THANH_CONG.getStatusCode());
    }

    @GetMapping("/khen-thuong")
    public ResponseEntity<List<KhenThuong>> getAll() {
        List<KhenThuong> ls = khenThuongService.xemDanhSach();
        return new ResponseEntity<>(ls, ResEnum.THANH_CONG.getStatusCode());
    }

    @GetMapping("/khen-thuong/{id}")
    public ResponseEntity<KhenThuong> getById(@PathVariable int id) {
        KhenThuong ls = khenThuongService.xemChiTiet(id);
        return new ResponseEntity<>(ls, ResEnum.THANH_CONG.getStatusCode());
    }

    @PostMapping("/khen-thuong/{id}")
    @Transactional
    public ResponseEntity<KhenThuong> add(@PathVariable UUID id, @RequestBody ReqKhenThuong cu) {
        KhenThuong ls = khenThuongService.them(id, cu);
        return new ResponseEntity<>(ls, ResEnum.TAO_THANH_CONG.getStatusCode());
    }

    @PatchMapping("/khen-thuong/{id}")
    public ResponseEntity<KhenThuong> edit(@PathVariable int id, @RequestBody ReqKhenThuong cu) {
        KhenThuong ls = khenThuongService.sua(id, cu);
        return new ResponseEntity<>(ls, ResEnum.CAP_NHAT_THANH_CONG.getStatusCode());
    }

    @DeleteMapping("/khen-thuong/{id}")
    public ResponseEntity<Boolean> del(@PathVariable int id) {
        boolean ls = khenThuongService.xoa(id);
        return new ResponseEntity<>(ls, ResEnum.XOA_THANH_CONG.getStatusCode());
    }
}
