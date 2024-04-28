package com.hrm.hoso_chitiet.controllers;

import com.hrm.hoso_chitiet.dto.mapper.MapperLamViecONuocNgoai;
import com.hrm.hoso_chitiet.dto.request.ReqLamViecONuocNgoai;
import com.hrm.hoso_chitiet.dto.response.ResLamViecONuocNgoai;
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
@Tag(name = "Làm việc ở nước ngoài ")
@SecurityRequirement(name = "Bearer Authentication")
@RequiredArgsConstructor // create constructor if field set final or @not null
public class LamViecONuocNgoaiController {
    private final IHoSoChiTietServices.IHoLamViecONuocNgoaiServiceChiTiet lamViecONuocNgoaiService;
    private final MapperLamViecONuocNgoai mapper;

    @GetMapping("/{id}/lam-viec-o-nuoc-ngoai")
    public ResponseEntity<List<ResLamViecONuocNgoai>> getAllByHoSoId(
            @PathVariable(name = "id") UUID id,
            @RequestParam(name = "pheDuyet", required = false) XacNhan xacNhan,
            @RequestParam(name = "sort", required = false, defaultValue = "createAt") String byDate,
            @RequestParam(name = "page", required = false, defaultValue = "0") int pageNumber,
            @RequestParam(name = "size", required = false, defaultValue = "10") int pageSize) {
        List<ResLamViecONuocNgoai> ls = lamViecONuocNgoaiService.xemDanhSachTheoHoSoId(id, xacNhan, byDate, pageNumber, pageSize).stream().map(mapper::mapToResLamViecONuocNgoai).toList();
        return new ResponseEntity<>(ls, ResEnum.THANH_CONG.getStatusCode());
    }

    @GetMapping("/lam-viec-o-nuoc-ngoai")
    public ResponseEntity<List<ResLamViecONuocNgoai>> getAll(
            @RequestParam(name = "pheDuyet", required = false) XacNhan xacNhan,
            @RequestParam(name = "sort", required = false, defaultValue = "createAt") String byDate,
            @RequestParam(name = "page", required = false, defaultValue = "0") int pageNumber,
            @RequestParam(name = "size", required = false, defaultValue = "10") int pageSize
    ) {
        List<ResLamViecONuocNgoai> ls = lamViecONuocNgoaiService.xemDanhSach(xacNhan, byDate, pageNumber, pageSize).stream().map(mapper::mapToResLamViecONuocNgoai).toList();
        return new ResponseEntity<>(ls, ResEnum.THANH_CONG.getStatusCode());
    }

    @GetMapping("/lam-viec-o-nuoc-ngoai/{id}")
    public ResponseEntity<ResLamViecONuocNgoai> getById(@PathVariable(name = "id") int id) {
        ResLamViecONuocNgoai ls = mapper.mapToResLamViecONuocNgoai(lamViecONuocNgoaiService.xemChiTiet(id));
        return new ResponseEntity<>(ls, ResEnum.THANH_CONG.getStatusCode());
    }

    @PostMapping("/lam-viec-o-nuoc-ngoai/{id}")
    @Transactional
    public ResponseEntity<ResLamViecONuocNgoai> add(@PathVariable(name = "id") UUID id, @RequestBody ReqLamViecONuocNgoai cu) {
        ResLamViecONuocNgoai ls = mapper.mapToResLamViecONuocNgoai(lamViecONuocNgoaiService.them(id, cu));
        return new ResponseEntity<>(ls, ResEnum.TAO_THANH_CONG.getStatusCode());
    }

    @PatchMapping("/lam-viec-o-nuoc-ngoai/{id}")
    public ResponseEntity<ResLamViecONuocNgoai> edit(
            @RequestHeader(name = "role", required = false) String role,
            @PathVariable(name = "id") int id, @RequestBody ReqLamViecONuocNgoai cu) {
        ResLamViecONuocNgoai ls = mapper.mapToResLamViecONuocNgoai(lamViecONuocNgoaiService.sua(id, cu, role));
        return new ResponseEntity<>(ls, ResEnum.CAP_NHAT_THANH_CONG.getStatusCode());
    }

    @DeleteMapping("/lam-viec-o-nuoc-ngoai/{id}")
    public ResponseEntity<Boolean> del(
            @RequestHeader(name = "role", required = false) String role,
            @PathVariable(name = "id") int id) {
        boolean ls = lamViecONuocNgoaiService.xoa(id, role);
        return new ResponseEntity<>(ls, ResEnum.XOA_THANH_CONG.getStatusCode());
    }

    @PatchMapping("/lam-viec-o-nuoc-ngoai/phe-duyet")
    public ResponseEntity<Boolean> approve(
            @RequestHeader(name = "role", required = false) String role,
            @RequestParam(name = "pheDuyet") XacNhan xacNhan,
            @RequestBody List<ResLamViecONuocNgoai> res
    ) {
        boolean ls = lamViecONuocNgoaiService.xacNhan(xacNhan, res);
        return new ResponseEntity<>(ls, ResEnum.CAP_NHAT_THANH_CONG.getStatusCode());
    }

    //EMPLOYEE
    @GetMapping("/ca-nhan/lam-viec-o-nuoc-ngoai")
    public ResponseEntity<List<ResLamViecONuocNgoai>> getAllCaNhan(
            @RequestHeader(name = "taiKhoanId", required = false) int id,
            @RequestParam(name = "pheDuyet", required = false) XacNhan xacNhan,
            @RequestParam(name = "sort", required = false, defaultValue = "createAt") String byDate,
            @RequestParam(name = "page", required = false, defaultValue = "0") int pageNumber,
            @RequestParam(name = "size", required = false, defaultValue = "10") int pageSize) {
        List<ResLamViecONuocNgoai> ls = lamViecONuocNgoaiService.xemDanhSachCaNhan(id, xacNhan, byDate, pageNumber, pageSize).stream().map(mapper::mapToResLamViecONuocNgoai).toList();
        return new ResponseEntity<>(ls, ResEnum.THANH_CONG.getStatusCode());
    }

    @GetMapping("/ca-nhan/lam-viec-o-nuoc-ngoai/{id}")
    public ResponseEntity<ResLamViecONuocNgoai> getByIdCaNhan(@PathVariable(name = "id") int id) {
        ResLamViecONuocNgoai ls = mapper.mapToResLamViecONuocNgoai(lamViecONuocNgoaiService.xemChiTiet(id));
        return new ResponseEntity<>(ls, ResEnum.THANH_CONG.getStatusCode());
    }

    @PostMapping("/ca-nhan/lam-viec-o-nuoc-ngoai")
    @Transactional
    public ResponseEntity<ResLamViecONuocNgoai> addCaNhan(@RequestHeader(name = "taiKhoanId", required = false) int id, @RequestBody ReqLamViecONuocNgoai cu) {
        ResLamViecONuocNgoai ls = mapper.mapToResLamViecONuocNgoai(lamViecONuocNgoaiService.themCaNhan(id, cu));
        return new ResponseEntity<>(ls, ResEnum.TAO_THANH_CONG.getStatusCode());
    }

    @PatchMapping("/ca-nhan/lam-viec-o-nuoc-ngoai/{id}")
    public ResponseEntity<ResLamViecONuocNgoai> editCaNhan(
            @RequestHeader(name = "role", required = false) String role,
            @PathVariable(name = "id") int id, @RequestBody ReqLamViecONuocNgoai cu) {
        ResLamViecONuocNgoai ls = mapper.mapToResLamViecONuocNgoai(lamViecONuocNgoaiService.sua(id, cu, role));
        return new ResponseEntity<>(ls, ResEnum.CAP_NHAT_THANH_CONG.getStatusCode());
    }

    @DeleteMapping("/ca-nhan/lam-viec-o-nuoc-ngoai/{id}")
    public ResponseEntity<Boolean> delCaNhan(
            @RequestHeader(name = "role", required = false) String role,
            @PathVariable(name = "id") int id) {
        boolean ls = lamViecONuocNgoaiService.xoa(id, role);
        return new ResponseEntity<>(ls, ResEnum.XOA_THANH_CONG.getStatusCode());
    }
}
