package com.hrm.hoso_chitiet.controllers;

import com.hrm.hoso_chitiet.dto.mapper.MapperTinHoc;
import com.hrm.hoso_chitiet.dto.request.ReqTinHoc;
import com.hrm.hoso_chitiet.dto.response.ResTinHoc;
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
@Tag(name = "Tin học ")
@SecurityRequirement(name = "Bearer Authentication")
@RequiredArgsConstructor
public class TinHocController {
    private final IHoSoChiTietServices.IHoTinHocServiceChiTiet tinHocService;
    private final MapperTinHoc mapper;

    @GetMapping("/{id}/tin-hoc")
    public ResponseEntity<List<ResTinHoc>> getAllByHoSoId(@PathVariable(name = "id") UUID id,
                                                          @RequestParam(name = "pheDuyet", required = false) XacNhan xacNhan,
                                                          @RequestParam(name = "sort", required = false, defaultValue = "createAt") String byDate,
                                                          @RequestParam(name = "page", required = false, defaultValue = "0") int pageNumber,
                                                          @RequestParam(name = "size", required = false, defaultValue = "10") int pageSize) {
        List<ResTinHoc> ls = tinHocService.xemDanhSachTheoHoSoId(id, xacNhan, byDate, pageNumber, pageSize).stream().map(mapper::mapToResTinHoc).toList();
        return new ResponseEntity<>(ls, ResEnum.THANH_CONG.getStatusCode());
    }

    @GetMapping("/tin-hoc")
    public ResponseEntity<List<ResTinHoc>> getAll(
            @RequestParam(name = "pheDuyet", required = false) XacNhan xacNhan,
            @RequestParam(name = "sort", required = false, defaultValue = "createAt") String byDate,
            @RequestParam(name = "page", required = false, defaultValue = "0") int pageNumber,
            @RequestParam(name = "size", required = false, defaultValue = "10") int pageSize) {
        List<ResTinHoc> ls = tinHocService.xemDanhSach(xacNhan, byDate, pageNumber, pageSize).stream().map(mapper::mapToResTinHoc).toList();
        return new ResponseEntity<>(ls, ResEnum.THANH_CONG.getStatusCode());
    }

    @GetMapping("/tin-hoc/{id}")
    public ResponseEntity<ResTinHoc> getById(@PathVariable(name = "id") int id) {
        ResTinHoc ls = mapper.mapToResTinHoc(tinHocService.xemChiTiet(id));
        return new ResponseEntity<>(ls, ResEnum.THANH_CONG.getStatusCode());
    }

    @PostMapping("/tin-hoc/{id}")
    @Transactional
    public ResponseEntity<ResTinHoc> add(@PathVariable(name = "id") UUID id, @RequestBody ReqTinHoc cu) {
        ResTinHoc ls = mapper.mapToResTinHoc(tinHocService.them(id, cu));
        return new ResponseEntity<>(ls, ResEnum.TAO_THANH_CONG.getStatusCode());
    }

    @PatchMapping("/tin-hoc/{id}")
    public ResponseEntity<ResTinHoc> edit(
            @RequestHeader(name = "role", required = false) String role,
            @PathVariable(name = "id") int id, @RequestBody ReqTinHoc cu) {
        ResTinHoc ls = mapper.mapToResTinHoc(tinHocService.sua(id, cu, role));
        return new ResponseEntity<>(ls, ResEnum.CAP_NHAT_THANH_CONG.getStatusCode());
    }

    @DeleteMapping("/tin-hoc/{id}")
    public ResponseEntity<Boolean> del(
            @RequestHeader(name = "role", required = false) String role,
            @PathVariable(name = "id") int id) {
        boolean ls = tinHocService.xoa(id, role);
        return new ResponseEntity<>(ls, ResEnum.XOA_THANH_CONG.getStatusCode());
    }

    @PatchMapping("/tin-hoc/phe-duyet")
    public ResponseEntity<Boolean> approve(
            @RequestHeader(name = "role", required = false) String role,
            @RequestParam(name = "pheDuyet") XacNhan xacNhan,
            @RequestBody List<ResTinHoc> res
    ) {
        boolean ls = tinHocService.xacNhan(xacNhan, res);
        return new ResponseEntity<>(ls, ResEnum.CAP_NHAT_THANH_CONG.getStatusCode());
    }

    //EMPLOYEE
    @GetMapping("/ca-nhan/tin-hoc")
    public ResponseEntity<List<ResTinHoc>> getAllCaNhan(@RequestHeader(name = "taiKhoanId", required = false) int id,
                                                        @RequestParam(name = "pheDuyet", required = false) XacNhan xacNhan,
                                                        @RequestParam(name = "sort", required = false, defaultValue = "createAt") String byDate,
                                                        @RequestParam(name = "page", required = false, defaultValue = "0") int pageNumber,
                                                        @RequestParam(name = "size", required = false, defaultValue = "10") int pageSize) {
        List<ResTinHoc> ls = tinHocService.xemDanhSachCaNhan(id, xacNhan, byDate, pageNumber, pageSize).stream().map(mapper::mapToResTinHoc).toList();
        return new ResponseEntity<>(ls, ResEnum.THANH_CONG.getStatusCode());
    }

    @GetMapping("/ca-nhan/tin-hoc/{id}")
    public ResponseEntity<ResTinHoc> getByIdCaNhan(@PathVariable(name = "id") int id) {
        ResTinHoc ls = mapper.mapToResTinHoc(tinHocService.xemChiTiet(id));
        return new ResponseEntity<>(ls, ResEnum.THANH_CONG.getStatusCode());
    }
    @PostMapping("/ca-nhan/tin-hoc")
    @Transactional
    public ResponseEntity<ResTinHoc> addCaNhan(@RequestHeader(name = "taiKhoanId", required = false) int id, @RequestBody ReqTinHoc cu) {
        ResTinHoc ls = mapper.mapToResTinHoc(tinHocService.themCaNhan(id, cu));
        return new ResponseEntity<>(ls, ResEnum.TAO_THANH_CONG.getStatusCode());
    }

    @PatchMapping("/ca-nhan/tin-hoc/{id}")
    public ResponseEntity<ResTinHoc> editCaNhan(
            @RequestHeader(name = "role", required = false) String role,
            @PathVariable(name = "id") int id, @RequestBody ReqTinHoc cu) {
        ResTinHoc ls = mapper.mapToResTinHoc(tinHocService.sua(id, cu, role));
        return new ResponseEntity<>(ls, ResEnum.CAP_NHAT_THANH_CONG.getStatusCode());
    }

    @DeleteMapping("/ca-nhan/tin-hoc/{id}")
    public ResponseEntity<Boolean> delCaNhan(
            @RequestHeader(name = "role", required = false) String role,
            @PathVariable(name = "id") int id) {
        boolean ls = tinHocService.xoa(id, role);
        return new ResponseEntity<>(ls, ResEnum.XOA_THANH_CONG.getStatusCode());
    }
}
