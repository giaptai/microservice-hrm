package com.hrm.hoso_chitiet.controllers;

import com.hrm.hoso_chitiet.dto.mapper.MapperKienThucAnNinhQuocPhong;
import com.hrm.hoso_chitiet.dto.request.ReqKienThucAnNinhQuocPhong;
import com.hrm.hoso_chitiet.dto.response.ResKienThucAnNinhQuocPhong;
import com.hrm.hoso_chitiet.models.KienThucAnNinhQuocPhong;
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
@Tag(name = "Kiến thức an ninh quốc phòng ")
@SecurityRequirement(name = "Bearer Authentication")
@RequiredArgsConstructor // create constructor if field set final or @not null
public class KienThucAnNinhQuocPhongController {
    private final IHoSoChiTietServices.IHoKienThucAnNinhQuocPhongServiceChiTiet kienThucAnNinhQuocPhongService;
    private final MapperKienThucAnNinhQuocPhong mapper;

    @GetMapping("/ho-so/{id}/kien-thuc-an-ninh-quoc-phong")
    public ResponseEntity<List<ResKienThucAnNinhQuocPhong>> getAllByHoSoId(@PathVariable UUID id) {
        List<ResKienThucAnNinhQuocPhong> ls = kienThucAnNinhQuocPhongService.xemDanhSachTheoHoSo(id).stream().map(mapper::mapToResKienThucAnNinhQuocPhong).toList();
        return new ResponseEntity<>(ls, ResEnum.THANH_CONG.getStatusCode());
    }

    @GetMapping("/kien-thuc-an-ninh-quoc-phong")
    public ResponseEntity<List<KienThucAnNinhQuocPhong>> getAll() {
        List<KienThucAnNinhQuocPhong> ls = kienThucAnNinhQuocPhongService.xemDanhSach();
        return new ResponseEntity<>(ls, ResEnum.THANH_CONG.getStatusCode());
    }

    @GetMapping("/kien-thuc-an-ninh-quoc-phong/{id}")
    public ResponseEntity<KienThucAnNinhQuocPhong> getById(@PathVariable int id) {
        KienThucAnNinhQuocPhong ls = kienThucAnNinhQuocPhongService.xemChiTiet(id);
        return new ResponseEntity<>(ls, ResEnum.THANH_CONG.getStatusCode());
    }

    @PostMapping("/kien-thuc-an-ninh-quoc-phong/{id}")
    @Transactional
    public ResponseEntity<KienThucAnNinhQuocPhong> add(@PathVariable UUID id, @RequestBody ReqKienThucAnNinhQuocPhong cu) {
        KienThucAnNinhQuocPhong ls = kienThucAnNinhQuocPhongService.them(id, cu);
        return new ResponseEntity<>(ls, ResEnum.TAO_THANH_CONG.getStatusCode());
    }

    @PatchMapping("/kien-thuc-an-ninh-quoc-phong/{id}")
    public ResponseEntity<KienThucAnNinhQuocPhong> edit(@PathVariable int id, @RequestBody ReqKienThucAnNinhQuocPhong cu) {
        KienThucAnNinhQuocPhong ls = kienThucAnNinhQuocPhongService.sua(id, cu);
        return new ResponseEntity<>(ls, ResEnum.CAP_NHAT_THANH_CONG.getStatusCode());
    }

    @DeleteMapping("/kien-thuc-an-ninh-quoc-phong/{id}")
    public ResponseEntity<Boolean> del(@PathVariable int id) {
        boolean ls = kienThucAnNinhQuocPhongService.xoa(id);
        return new ResponseEntity<>(ls, ResEnum.XOA_THANH_CONG.getStatusCode());
    }
}
