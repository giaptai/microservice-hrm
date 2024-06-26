package com.hrm.hoso_chitiet.controllers;

import com.hrm.hoso_chitiet.dto.request.ReqLamViecChoCheDoCu;
import com.hrm.hoso_chitiet.dto.response.ResLamViecChoCheDoCu;
import com.hrm.hoso_chitiet.dto.response.ResTheDTO;
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
@Tag(name = "Làm việc cho chế đồ cũ ")
@SecurityRequirement(name = "Bearer Authentication")
@RequiredArgsConstructor // create constructor if field set final or @not null
public class LamViecChoCheDoCuController {
    private final IHoSoChiTietServices.ILamViecChoCheDoCuServiceChiTiet lamViecChoCheDoCuService;

    @GetMapping("/{id}/lam-viec-cho-che-do-cu")
    public ResponseEntity<ResTheDTO<ResLamViecChoCheDoCu>> getAllByHoSoId(
            @PathVariable(name = "id") UUID id,
            @RequestParam(name = "pheDuyet", required = false) XacNhan xacNhan,
            @RequestParam(name = "sort", required = false, defaultValue = "createAt") String byDate,
            @RequestParam(name = "page", required = false, defaultValue = "0") int pageNumber,
            @RequestParam(name = "size", required = false, defaultValue = "10") int pageSize) {
        ResTheDTO<ResLamViecChoCheDoCu> ls = lamViecChoCheDoCuService.xemDanhSachTheoHoSoId(id, xacNhan, byDate, pageNumber, pageSize);
        return new ResponseEntity<>(ls, ResEnum.THANH_CONG.getStatusCode());
    }

    @GetMapping("/lam-viec-cho-che-do-cu")
    public ResponseEntity<ResTheDTO<ResLamViecChoCheDoCu>> getAll(
            @RequestParam(name = "pheDuyet", required = false) XacNhan xacNhan,
            @RequestParam(name = "sort", required = false, defaultValue = "createAt") String byDate,
            @RequestParam(name = "page", required = false, defaultValue = "0") int pageNumber,
            @RequestParam(name = "size", required = false, defaultValue = "10") int pageSize
    ) {
        ResTheDTO<ResLamViecChoCheDoCu> ls = lamViecChoCheDoCuService.xemDanhSach(xacNhan, byDate, pageNumber, pageSize);
        return new ResponseEntity<>(ls, ResEnum.THANH_CONG.getStatusCode());
    }

    @GetMapping("/lam-viec-cho-che-do-cu/{id}")
    public ResponseEntity<ResLamViecChoCheDoCu> getById(@PathVariable(name = "id") int id) {
        ResLamViecChoCheDoCu ls = lamViecChoCheDoCuService.xemChiTiet(id);
        return new ResponseEntity<>(ls, ResEnum.THANH_CONG.getStatusCode());
    }

    @PostMapping("/lam-viec-cho-che-do-cu/{id}")
    @Transactional
    public ResponseEntity<ResLamViecChoCheDoCu> add(@PathVariable(name = "id") UUID id, @RequestBody ReqLamViecChoCheDoCu cu) {
        ResLamViecChoCheDoCu ls = lamViecChoCheDoCuService.them(id, cu);
        return new ResponseEntity<>(ls, ResEnum.TAO_THANH_CONG.getStatusCode());
    }

    @PatchMapping("/lam-viec-cho-che-do-cu/{id}")
    public ResponseEntity<ResLamViecChoCheDoCu> edit(
            @RequestHeader(name = "role", required = false) String role,
            @PathVariable(name = "id") int id, @RequestBody ReqLamViecChoCheDoCu cu) {
        ResLamViecChoCheDoCu ls = lamViecChoCheDoCuService.sua(id, cu, role);
        return new ResponseEntity<>(ls, ResEnum.CAP_NHAT_THANH_CONG.getStatusCode());
    }

    @DeleteMapping("/lam-viec-cho-che-do-cu/{id}")
    public ResponseEntity<Boolean> del(
            @RequestHeader(name = "role", required = false) String role,
            @PathVariable(name = "id") int id) {
        boolean ls = lamViecChoCheDoCuService.xoa(id, role);
        return new ResponseEntity<>(ls, ResEnum.XOA_THANH_CONG.getStatusCode());
    }

    @PatchMapping("/lam-viec-cho-che-do-cu/phe-duyet")
    public ResponseEntity<Boolean> approve(
            @RequestHeader(name = "role", required = false) String role,
            @RequestParam(name = "pheDuyet") XacNhan xacNhan,
            @RequestBody List<ResLamViecChoCheDoCu> res
    ) {
        boolean ls = lamViecChoCheDoCuService.xacNhan(xacNhan, res);
        return new ResponseEntity<>(ls, ResEnum.CAP_NHAT_THANH_CONG.getStatusCode());
    }

    //EMPLOYEE
    @GetMapping("/ca-nhan/lam-viec-cho-che-do-cu")
    public ResponseEntity<ResTheDTO<ResLamViecChoCheDoCu>> getAllCaNhan(
            @RequestHeader(name = "taiKhoanId", required = false) int id,
            @RequestParam(name = "pheDuyet", required = false) XacNhan xacNhan,
            @RequestParam(name = "sort", required = false, defaultValue = "createAt") String byDate,
            @RequestParam(name = "page", required = false, defaultValue = "0") int pageNumber,
            @RequestParam(name = "size", required = false, defaultValue = "10") int pageSize) {
        ResTheDTO<ResLamViecChoCheDoCu> ls = lamViecChoCheDoCuService.xemDanhSachCaNhan(id, xacNhan, byDate, pageNumber, pageSize);
        return new ResponseEntity<>(ls, ResEnum.THANH_CONG.getStatusCode());
    }

    @GetMapping("/ca-nhan/lam-viec-cho-che-do-cu/{id}")
    public ResponseEntity<ResLamViecChoCheDoCu> getByIdCaNhan(@PathVariable(name = "id") int id) {
        ResLamViecChoCheDoCu ls = lamViecChoCheDoCuService.xemChiTiet(id);
        return new ResponseEntity<>(ls, ResEnum.THANH_CONG.getStatusCode());
    }

    @PostMapping("/ca-nhan/lam-viec-cho-che-do-cu")
    @Transactional
    public ResponseEntity<ResLamViecChoCheDoCu> addCaNhan(@RequestHeader(name = "taiKhoanId", required = false) int id, @RequestBody ReqLamViecChoCheDoCu cu) {
        ResLamViecChoCheDoCu ls = lamViecChoCheDoCuService.themCaNhan(id, cu);
        return new ResponseEntity<>(ls, ResEnum.TAO_THANH_CONG.getStatusCode());
    }

    @PatchMapping("/ca-nhan/lam-viec-cho-che-do-cu/{id}")
    public ResponseEntity<ResLamViecChoCheDoCu> editCaNhan(
            @RequestHeader(name = "role", required = false) String role,
            @PathVariable(name = "id") int id, @RequestBody ReqLamViecChoCheDoCu cu) {
        ResLamViecChoCheDoCu ls = lamViecChoCheDoCuService.sua(id, cu, role);
        return new ResponseEntity<>(ls, ResEnum.CAP_NHAT_THANH_CONG.getStatusCode());
    }

    @DeleteMapping("/ca-nhan/lam-viec-cho-che-do-cu/{id}")
    public ResponseEntity<Boolean> delCaNhan(
            @RequestHeader(name = "role", required = false) String role,
            @PathVariable(name = "id") int id) {
        boolean ls = lamViecChoCheDoCuService.xoa(id, role);
        return new ResponseEntity<>(ls, ResEnum.XOA_THANH_CONG.getStatusCode());
    }
}
