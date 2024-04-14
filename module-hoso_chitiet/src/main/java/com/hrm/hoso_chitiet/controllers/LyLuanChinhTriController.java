package com.hrm.hoso_chitiet.controllers;

import com.hrm.hoso_chitiet.dto.mapper.MapperLyLuanChinhTri;
import com.hrm.hoso_chitiet.dto.request.ReqLyLuanChinhTri;
import com.hrm.hoso_chitiet.dto.response.ResLyLuanChinhTri;
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
@Tag(name = "Lý luân chính trị ")
@SecurityRequirement(name = "Bearer Authentication")
@RequiredArgsConstructor
public class LyLuanChinhTriController {
    private final IHoSoChiTietServices.IHoLyLuanChinhTriServiceChiTiet lyLuanChinhTriService;
    private final MapperLyLuanChinhTri mapper;

    @GetMapping("/{id}/ly-luan-chinh-tri")
    public ResponseEntity<List<ResLyLuanChinhTri>> getAllByHoSoId(@PathVariable(name = "id") UUID id,
                                                                  @RequestParam(name = "page", required = false, defaultValue = "0") int pageNumber,
                                                                  @RequestParam(name = "size", required = false, defaultValue = "10") int pageSize) {
        List<ResLyLuanChinhTri> ls = lyLuanChinhTriService.xemDanhSachTheoHoSoId(id, pageNumber, pageSize).stream().map(mapper::mapToResLyLuanChinhTri).toList();
        return new ResponseEntity<>(ls, ResEnum.THANH_CONG.getStatusCode());
    }

    @GetMapping("/ly-luan-chinh-tri")
    public ResponseEntity<List<ResLyLuanChinhTri>> getAll(@RequestParam(name = "page", required = false, defaultValue = "0") int pageNumber,
                                                          @RequestParam(name = "size", required = false, defaultValue = "10") int pageSize) {
        List<ResLyLuanChinhTri> ls = lyLuanChinhTriService.xemDanhSach(pageNumber, pageSize).stream().map(mapper::mapToResLyLuanChinhTri).toList();
        return new ResponseEntity<>(ls, ResEnum.THANH_CONG.getStatusCode());
    }

    @GetMapping("/ly-luan-chinh-tri/{id}")
    public ResponseEntity<ResLyLuanChinhTri> getById(@PathVariable(name = "id") int id) {
        ResLyLuanChinhTri ls = mapper.mapToResLyLuanChinhTri(lyLuanChinhTriService.xemChiTiet(id));
        return new ResponseEntity<>(ls, ResEnum.THANH_CONG.getStatusCode());
    }

    @PostMapping("/ly-luan-chinh-tri/{id}")
    @Transactional
    public ResponseEntity<ResLyLuanChinhTri> add(@PathVariable(name = "id") UUID id, @RequestBody ReqLyLuanChinhTri cu) {
        ResLyLuanChinhTri ls = mapper.mapToResLyLuanChinhTri(lyLuanChinhTriService.them(id, cu));
        return new ResponseEntity<>(ls, ResEnum.TAO_THANH_CONG.getStatusCode());
    }

    @PatchMapping("/ly-luan-chinh-tri/{id}")
    public ResponseEntity<ResLyLuanChinhTri> edit(@PathVariable(name = "id") int id, @RequestBody ReqLyLuanChinhTri cu) {
        ResLyLuanChinhTri ls = mapper.mapToResLyLuanChinhTri(lyLuanChinhTriService.sua(id, cu));
        return new ResponseEntity<>(ls, ResEnum.CAP_NHAT_THANH_CONG.getStatusCode());
    }

    @DeleteMapping("/ly-luan-chinh-tri/{id}")
    public ResponseEntity<Boolean> del(@PathVariable(name = "id") int id) {
        boolean ls = lyLuanChinhTriService.xoa(id);
        return new ResponseEntity<>(ls, ResEnum.XOA_THANH_CONG.getStatusCode());
    }

    //EMPLOYEE
    @GetMapping("/ca-nhan/ly-luan-chinh-tri")
    public ResponseEntity<List<ResLyLuanChinhTri>> getAllCaNhan(@RequestHeader(name = "taiKhoanId", required = false) int id,
                                                                @RequestParam(name = "page", required = false, defaultValue = "0") int pageNumber,
                                                                @RequestParam(name = "size", required = false, defaultValue = "10") int pageSize) {
        List<ResLyLuanChinhTri> ls = lyLuanChinhTriService.xemDanhSachCaNhan(id, pageNumber, pageSize).stream().map(mapper::mapToResLyLuanChinhTri).toList();
        return new ResponseEntity<>(ls, ResEnum.THANH_CONG.getStatusCode());
    }

    @PostMapping("/ca-nhan/ly-luan-chinh-tri")
    @Transactional
    public ResponseEntity<ResLyLuanChinhTri> addCaNhan(@RequestHeader(name = "taiKhoanId", required = false) int id, @RequestBody ReqLyLuanChinhTri cu) {
        ResLyLuanChinhTri ls = mapper.mapToResLyLuanChinhTri(lyLuanChinhTriService.themCaNhan(id, cu));
        return new ResponseEntity<>(ls, ResEnum.TAO_THANH_CONG.getStatusCode());
    }

    @PatchMapping("/ca-nhan/ly-luan-chinh-tri/{id}")
    public ResponseEntity<ResLyLuanChinhTri> editCaNhan(@PathVariable(name = "id") int id, @RequestBody ReqLyLuanChinhTri cu) {
        ResLyLuanChinhTri ls = mapper.mapToResLyLuanChinhTri(lyLuanChinhTriService.sua(id, cu));
        return new ResponseEntity<>(ls, ResEnum.CAP_NHAT_THANH_CONG.getStatusCode());
    }

    @DeleteMapping("/ca-nhan/ly-luan-chinh-tri/{id}")
    public ResponseEntity<Boolean> delCaNhan(@PathVariable(name = "id") int id) {
        boolean ls = lyLuanChinhTriService.xoa(id);
        return new ResponseEntity<>(ls, ResEnum.XOA_THANH_CONG.getStatusCode());
    }
}
