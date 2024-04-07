package com.hrm.hoso_chitiet.controllers;

import com.hrm.hoso_chitiet.dto.mapper.MapperKienThucAnNinhQuocPhong;
import com.hrm.hoso_chitiet.dto.request.ReqKienThucAnNinhQuocPhong;
import com.hrm.hoso_chitiet.dto.response.ResKienThucAnNinhQuocPhong;
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
@Tag(name = "Kiến thức an ninh quốc phòng ")
@SecurityRequirement(name = "Bearer Authentication")
@RequiredArgsConstructor // create constructor if field set final or @not null
public class KienThucAnNinhQuocPhongController {
    private final IHoSoChiTietServices.IHoKienThucAnNinhQuocPhongServiceChiTiet kienThucAnNinhQuocPhongService;
    private final MapperKienThucAnNinhQuocPhong mapper;

    @GetMapping("/{id}/kien-thuc-an-ninh-quoc-phong")
    public ResponseEntity<List<ResKienThucAnNinhQuocPhong>> getAllByHoSoId(@PathVariable UUID id) {
        List<ResKienThucAnNinhQuocPhong> ls = kienThucAnNinhQuocPhongService.xemDanhSachTheoHoSo(id).stream().map(mapper::mapToResKienThucAnNinhQuocPhong).toList();
        return new ResponseEntity<>(ls, ResEnum.THANH_CONG.getStatusCode());
    }

    @GetMapping("/kien-thuc-an-ninh-quoc-phong")
    public ResponseEntity<List<ResKienThucAnNinhQuocPhong>> getAll() {
        List<ResKienThucAnNinhQuocPhong> ls = kienThucAnNinhQuocPhongService.xemDanhSach().stream().map(mapper::mapToResKienThucAnNinhQuocPhong).toList();
        return new ResponseEntity<>(ls, ResEnum.THANH_CONG.getStatusCode());
    }

    @GetMapping("/kien-thuc-an-ninh-quoc-phong/{id}")
    public ResponseEntity<ResKienThucAnNinhQuocPhong> getById(@PathVariable int id) {
        ResKienThucAnNinhQuocPhong ls = mapper.mapToResKienThucAnNinhQuocPhong(kienThucAnNinhQuocPhongService.xemChiTiet(id));
        return new ResponseEntity<>(ls, ResEnum.THANH_CONG.getStatusCode());
    }

    @PostMapping("/kien-thuc-an-ninh-quoc-phong/{id}")
    @Transactional
    public ResponseEntity<ResKienThucAnNinhQuocPhong> add(@PathVariable UUID id, @RequestBody ReqKienThucAnNinhQuocPhong cu) {
        ResKienThucAnNinhQuocPhong ls = mapper.mapToResKienThucAnNinhQuocPhong(kienThucAnNinhQuocPhongService.them(id, cu));
        return new ResponseEntity<>(ls, ResEnum.TAO_THANH_CONG.getStatusCode());
    }

    @PatchMapping("/kien-thuc-an-ninh-quoc-phong/{id}")
    public ResponseEntity<ResKienThucAnNinhQuocPhong> edit(@PathVariable int id, @RequestBody ReqKienThucAnNinhQuocPhong cu) {
        ResKienThucAnNinhQuocPhong ls = mapper.mapToResKienThucAnNinhQuocPhong(kienThucAnNinhQuocPhongService.sua(id, cu));
        return new ResponseEntity<>(ls, ResEnum.CAP_NHAT_THANH_CONG.getStatusCode());
    }

    @DeleteMapping("/kien-thuc-an-ninh-quoc-phong/{id}")
    public ResponseEntity<Boolean> del(@PathVariable int id) {
        boolean ls = kienThucAnNinhQuocPhongService.xoa(id);
        return new ResponseEntity<>(ls, ResEnum.XOA_THANH_CONG.getStatusCode());
    }
    //EMPLOYEE
    @GetMapping("/ca-nhan/kien-thuc-an-ninh-quoc-phong")
    public ResponseEntity<List<ResKienThucAnNinhQuocPhong>> getAllCaNhan(@RequestHeader(name = "taiKhoanId") int id) {
        List<ResKienThucAnNinhQuocPhong> ls = kienThucAnNinhQuocPhongService.xemDanhSachCaNhan(id).stream().map(mapper::mapToResKienThucAnNinhQuocPhong).toList();
        return new ResponseEntity<>(ls, ResEnum.THANH_CONG.getStatusCode());
    }

    @PostMapping("/ca-nhan/kien-thuc-an-ninh-quoc-phong")
    @Transactional
    public ResponseEntity<ResKienThucAnNinhQuocPhong> addCaNhan(@RequestHeader(name = "taiKhoanId") int id, @RequestBody ReqKienThucAnNinhQuocPhong cu) {
        ResKienThucAnNinhQuocPhong ls = mapper.mapToResKienThucAnNinhQuocPhong(kienThucAnNinhQuocPhongService.themCaNhan(id, cu));
        return new ResponseEntity<>(ls, ResEnum.TAO_THANH_CONG.getStatusCode());
    }

    @PatchMapping("/ca-nhan/kien-thuc-an-ninh-quoc-phong/{id}")
    public ResponseEntity<ResKienThucAnNinhQuocPhong> editCaNhan(@PathVariable int id, @RequestBody ReqKienThucAnNinhQuocPhong cu) {
        ResKienThucAnNinhQuocPhong ls = mapper.mapToResKienThucAnNinhQuocPhong(kienThucAnNinhQuocPhongService.sua(id, cu));
        return new ResponseEntity<>(ls, ResEnum.CAP_NHAT_THANH_CONG.getStatusCode());
    }

    @DeleteMapping("/ca-nhan/kien-thuc-an-ninh-quoc-phong/{id}")
    public ResponseEntity<Boolean> delCaNhan(@PathVariable int id) {
        boolean ls = kienThucAnNinhQuocPhongService.xoa(id);
        return new ResponseEntity<>(ls, ResEnum.XOA_THANH_CONG.getStatusCode());
    }
}
