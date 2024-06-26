package com.hrm.hoso_chitiet.controllers;

import com.hrm.hoso_chitiet.dto.request.ReqPhuCapKhac;
import com.hrm.hoso_chitiet.dto.response.ResPhuCapKhac;
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
@Tag(name = "Phụ cấp khác ")
@SecurityRequirement(name = "Bearer Authentication")
@RequiredArgsConstructor
public class PhuCapKhacController {
    private final IHoSoChiTietServices.IHoPhuCapKhacServiceChiTiet phuCapKhacService;

    @GetMapping("/{id}/phu-cap-khac")
    public ResponseEntity<ResTheDTO<ResPhuCapKhac>> getAllByHoSoId(
            @PathVariable(name = "id") UUID id,
            @RequestParam(name = "pheDuyet", required = false) XacNhan xacNhan,
            @RequestParam(name = "sort", required = false, defaultValue = "createAt") String byDate,
            @RequestParam(name = "page", required = false, defaultValue = "0") int pageNumber,
            @RequestParam(name = "size", required = false, defaultValue = "10") int pageSize) {
        ResTheDTO<ResPhuCapKhac> ls = phuCapKhacService.xemDanhSachTheoHoSoId(id, xacNhan, byDate, pageNumber, pageSize);
        return new ResponseEntity<>(ls, ResEnum.THANH_CONG.getStatusCode());
    }

    @GetMapping("/phu-cap-khac")
    public ResponseEntity<ResTheDTO<ResPhuCapKhac>> getAll(
            @RequestParam(name = "pheDuyet", required = false) XacNhan xacNhan,
            @RequestParam(name = "sort", required = false, defaultValue = "createAt") String byDate,
            @RequestParam(name = "page", required = false, defaultValue = "0") int pageNumber,
            @RequestParam(name = "size", required = false, defaultValue = "10") int pageSize) {
        ResTheDTO<ResPhuCapKhac> ls = phuCapKhacService.xemDanhSach(xacNhan, byDate, pageNumber, pageSize);
        return new ResponseEntity<>(ls, ResEnum.THANH_CONG.getStatusCode());
    }

    @GetMapping("/phu-cap-khac/{id}")
    public ResponseEntity<ResPhuCapKhac> getById(@PathVariable(name = "id") int id) {
        ResPhuCapKhac ls = phuCapKhacService.xemChiTiet(id);
        return new ResponseEntity<>(ls, ResEnum.THANH_CONG.getStatusCode());
    }

    @PostMapping("/phu-cap-khac/{id}")
    @Transactional
    public ResponseEntity<ResPhuCapKhac> add(@PathVariable(name = "id") UUID id, @RequestBody ReqPhuCapKhac cu) {
        ResPhuCapKhac ls = phuCapKhacService.them(id, cu);
        return new ResponseEntity<>(ls, ResEnum.TAO_THANH_CONG.getStatusCode());
    }

    @PatchMapping("/phu-cap-khac/{id}")
    public ResponseEntity<ResPhuCapKhac> edit(
            @RequestHeader(name = "role", required = false) String role,
            @PathVariable(name = "id") int id, @RequestBody ReqPhuCapKhac cu) {
        ResPhuCapKhac ls = phuCapKhacService.sua(id, cu, role);
        return new ResponseEntity<>(ls, ResEnum.CAP_NHAT_THANH_CONG.getStatusCode());
    }

    @DeleteMapping("/phu-cap-khac/{id}")
    public ResponseEntity<Boolean> del(
            @RequestHeader(name = "role", required = false) String role,
            @PathVariable(name = "id") int id) {
        boolean ls = phuCapKhacService.xoa(id, role);
        return new ResponseEntity<>(ls, ResEnum.XOA_THANH_CONG.getStatusCode());
    }

    @PatchMapping("/phu-cap-khac/phe-duyet")
    public ResponseEntity<Boolean> approve(
            @RequestHeader(name = "role", required = false) String role,
            @RequestParam(name = "pheDuyet") XacNhan xacNhan,
            @RequestBody List<ResPhuCapKhac> res
    ) {
        boolean ls = phuCapKhacService.xacNhan(xacNhan, res);
        return new ResponseEntity<>(ls, ResEnum.CAP_NHAT_THANH_CONG.getStatusCode());
    }

    //EMPLOYEE
    @GetMapping("/ca-nhan/phu-cap-khac")
    public ResponseEntity<ResTheDTO<ResPhuCapKhac>> getAllCaNhan(
            @RequestHeader(name = "taiKhoanId", required = false) int id,
            @RequestParam(name = "pheDuyet", required = false) XacNhan xacNhan,
            @RequestParam(name = "sort", required = false, defaultValue = "createAt") String byDate,
            @RequestParam(name = "page", required = false, defaultValue = "0") int pageNumber,
            @RequestParam(name = "size", required = false, defaultValue = "10") int pageSize) {
        ResTheDTO<ResPhuCapKhac> ls = phuCapKhacService.xemDanhSachCaNhan(id, xacNhan, byDate, pageNumber, pageSize);
        return new ResponseEntity<>(ls, ResEnum.THANH_CONG.getStatusCode());
    }

    @GetMapping("/ca-nhan/phu-cap-khac/{id}")
    public ResponseEntity<ResPhuCapKhac> getByIdCaNhan(@PathVariable(name = "id") int id) {
        ResPhuCapKhac ls = phuCapKhacService.xemChiTiet(id);
        return new ResponseEntity<>(ls, ResEnum.THANH_CONG.getStatusCode());
    }

    @PostMapping("/ca-nhan/phu-cap-khac")
    @Transactional
    public ResponseEntity<ResPhuCapKhac> addCaNhan(@RequestHeader(name = "taiKhoanId", required = false) int id, @RequestBody ReqPhuCapKhac cu) {
        ResPhuCapKhac ls = phuCapKhacService.themCaNhan(id, cu);
        return new ResponseEntity<>(ls, ResEnum.TAO_THANH_CONG.getStatusCode());
    }

    @PatchMapping("/ca-nhan/phu-cap-khac/{id}")
    public ResponseEntity<ResPhuCapKhac> editCaNhan(
            @RequestHeader(name = "role", required = false) String role,
            @PathVariable(name = "id") int id, @RequestBody ReqPhuCapKhac cu) {
        ResPhuCapKhac ls = phuCapKhacService.sua(id, cu, role);
        return new ResponseEntity<>(ls, ResEnum.CAP_NHAT_THANH_CONG.getStatusCode());
    }

    @DeleteMapping("/ca-nhan/phu-cap-khac/{id}")
    public ResponseEntity<Boolean> delCaNhan(
            @RequestHeader(name = "role", required = false) String role,
            @PathVariable(name = "id") int id) {
        boolean ls = phuCapKhacService.xoa(id, role);
        return new ResponseEntity<>(ls, ResEnum.XOA_THANH_CONG.getStatusCode());
    }
}
