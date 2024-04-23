package com.hrm.hoso_chitiet.controllers;

import com.hrm.hoso_chitiet.dto.mapper.MapperLamViecChoCheDoCu;
import com.hrm.hoso_chitiet.dto.request.ReqLamViecChoCheDoCu;
import com.hrm.hoso_chitiet.dto.response.ResLamViecChoCheDoCu;
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
    private final MapperLamViecChoCheDoCu mapper;

    @GetMapping("/{id}/lam-viec-cho-che-do-cu")
    public ResponseEntity<List<ResLamViecChoCheDoCu>> getAllByHoSoId(
            @PathVariable(name = "id") UUID id,
            @RequestParam(name = "sort", required = false, defaultValue = "createAt") String byDate,
            @RequestParam(name = "page", required = false, defaultValue = "0") int pageNumber,
            @RequestParam(name = "size", required = false, defaultValue = "10") int pageSize) {
        List<ResLamViecChoCheDoCu> ls = lamViecChoCheDoCuService.xemDanhSachTheoHoSoId(id, byDate, pageNumber, pageSize).stream().map(mapper::maptoResLamViecChoCheDoCu).toList();
        return new ResponseEntity<>(ls, ResEnum.THANH_CONG.getStatusCode());
    }

    @GetMapping("/lam-viec-cho-che-do-cu")
    public ResponseEntity<List<ResLamViecChoCheDoCu>> getAll(
            @RequestParam(name = "sort", required = false, defaultValue = "createAt") String byDate,
            @RequestParam(name = "page", required = false, defaultValue = "0") int pageNumber,
            @RequestParam(name = "size", required = false, defaultValue = "10") int pageSize
    ) {
        List<ResLamViecChoCheDoCu> ls = lamViecChoCheDoCuService.xemDanhSach(byDate, pageNumber, pageSize).stream().map(mapper::maptoResLamViecChoCheDoCu).toList();
        return new ResponseEntity<>(ls, ResEnum.THANH_CONG.getStatusCode());
    }

    @GetMapping("/lam-viec-cho-che-do-cu/{id}")
    public ResponseEntity<ResLamViecChoCheDoCu> getById(@PathVariable(name = "id") int id) {
        ResLamViecChoCheDoCu ls = mapper.maptoResLamViecChoCheDoCu(lamViecChoCheDoCuService.xemChiTiet(id));
        return new ResponseEntity<>(ls, ResEnum.THANH_CONG.getStatusCode());
    }

    @PostMapping("/lam-viec-cho-che-do-cu/{id}")
    @Transactional
    public ResponseEntity<ResLamViecChoCheDoCu> add(@PathVariable(name = "id") UUID id, @RequestBody ReqLamViecChoCheDoCu cu) {
        ResLamViecChoCheDoCu ls = mapper.maptoResLamViecChoCheDoCu(lamViecChoCheDoCuService.them(id, cu));
        return new ResponseEntity<>(ls, ResEnum.TAO_THANH_CONG.getStatusCode());
    }

    @PatchMapping("/lam-viec-cho-che-do-cu/{id}")
    public ResponseEntity<ResLamViecChoCheDoCu> edit(
            @RequestHeader(name = "role", required = false) String role,
            @PathVariable(name = "id") int id, @RequestBody ReqLamViecChoCheDoCu cu) {
        ResLamViecChoCheDoCu ls = mapper.maptoResLamViecChoCheDoCu(lamViecChoCheDoCuService.sua(id, cu, role));
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
            @RequestParam(name = "xacNhan") XacNhan xacNhan,
            @RequestBody List<ResLamViecChoCheDoCu> res
    ) {
        boolean ls = lamViecChoCheDoCuService.xacNhan(xacNhan, res);
        return new ResponseEntity<>(ls, ResEnum.CAP_NHAT_THANH_CONG.getStatusCode());
    }

    //EMPLOYEE
    @GetMapping("/ca-nhan/lam-viec-cho-che-do-cu")
    public ResponseEntity<List<ResLamViecChoCheDoCu>> getAllCaNhan(
            @RequestHeader(name = "taiKhoanId", required = false) int id,
            @RequestParam(name = "sort", required = false, defaultValue = "createAt") String byDate,
            @RequestParam(name = "page", required = false, defaultValue = "0") int pageNumber,
            @RequestParam(name = "size", required = false, defaultValue = "10") int pageSize) {
        List<ResLamViecChoCheDoCu> ls = lamViecChoCheDoCuService.xemDanhSachCaNhan(id, byDate, pageNumber, pageSize).stream().map(mapper::maptoResLamViecChoCheDoCu).toList();
        return new ResponseEntity<>(ls, ResEnum.THANH_CONG.getStatusCode());
    }

    @PostMapping("/ca-nhan/lam-viec-cho-che-do-cu")
    @Transactional
    public ResponseEntity<ResLamViecChoCheDoCu> addCaNhan(@RequestHeader(name = "taiKhoanId", required = false) int id, @RequestBody ReqLamViecChoCheDoCu cu) {
        ResLamViecChoCheDoCu ls = mapper.maptoResLamViecChoCheDoCu(lamViecChoCheDoCuService.themCaNhan(id, cu));
        return new ResponseEntity<>(ls, ResEnum.TAO_THANH_CONG.getStatusCode());
    }

    @PatchMapping("/ca-nhan/lam-viec-cho-che-do-cu/{id}")
    public ResponseEntity<ResLamViecChoCheDoCu> editCaNhan(
            @RequestHeader(name = "role", required = false) String role,
            @PathVariable(name = "id") int id, @RequestBody ReqLamViecChoCheDoCu cu) {
        ResLamViecChoCheDoCu ls = mapper.maptoResLamViecChoCheDoCu(lamViecChoCheDoCuService.sua(id, cu, role));
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
