package com.hrm.hoso_chitiet.controllers;

import com.hrm.hoso_chitiet.dto.mapper.MapperLyLuanChinhTri;
import com.hrm.hoso_chitiet.dto.request.ReqLyLuanChinhTri;
import com.hrm.hoso_chitiet.dto.response.ResLyLuanChinhTri;
import com.hrm.hoso_chitiet.models.LyLuanChinhTri;
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
@Tag(name = "Lý luân chính trị ")
@SecurityRequirement(name = "Bearer Authentication")
@RequiredArgsConstructor
public class LyLuanChinhTriController {
    private final IHoSoChiTietServices.IHoLyLuanChinhTriServiceChiTiet lyLuanChinhTriService;
    private final MapperLyLuanChinhTri mapper;

    @GetMapping("/ho-so/{id}/ly-luan-chinh-tri")
    public ResponseEntity<List<ResLyLuanChinhTri>> getAllByHoSoId(@PathVariable UUID id) {
        List<ResLyLuanChinhTri> ls = lyLuanChinhTriService.xemDanhSachTheoHoSo(id).stream().map(mapper::mapToResLyLuanChinhTri).toList();
        return new ResponseEntity<>(ls, ResEnum.THANH_CONG.getStatusCode());
    }

    @GetMapping("/ly-luan-chinh-tri")
    public ResponseEntity<List<LyLuanChinhTri>> getAll() {
        List<LyLuanChinhTri> ls = lyLuanChinhTriService.xemDanhSach();
        return new ResponseEntity<>(ls, ResEnum.THANH_CONG.getStatusCode());
    }

    @GetMapping("/ly-luan-chinh-tri/{id}")
    public ResponseEntity<LyLuanChinhTri> getById(@PathVariable int id) {
        LyLuanChinhTri ls = lyLuanChinhTriService.xemChiTiet(id);
        return new ResponseEntity<>(ls, ResEnum.THANH_CONG.getStatusCode());
    }

    @PostMapping("/ly-luan-chinh-tri/{id}")
    @Transactional
    public ResponseEntity<LyLuanChinhTri> add(@PathVariable UUID id, @RequestBody ReqLyLuanChinhTri cu) {
        LyLuanChinhTri ls = lyLuanChinhTriService.them(id, cu);
        return new ResponseEntity<>(ls, ResEnum.TAO_THANH_CONG.getStatusCode());
    }

    @PatchMapping("/ly-luan-chinh-tri/{id}")
    public ResponseEntity<LyLuanChinhTri> edit(@PathVariable int id, @RequestBody ReqLyLuanChinhTri cu) {
        LyLuanChinhTri ls = lyLuanChinhTriService.sua(id, cu);
        return new ResponseEntity<>(ls, ResEnum.CAP_NHAT_THANH_CONG.getStatusCode());
    }

    @DeleteMapping("/ly-luan-chinh-tri/{id}")
    public ResponseEntity<Boolean> del(@PathVariable int id) {
        boolean ls = lyLuanChinhTriService.xoa(id);
        return new ResponseEntity<>(ls, ResEnum.XOA_THANH_CONG.getStatusCode());
    }
}
