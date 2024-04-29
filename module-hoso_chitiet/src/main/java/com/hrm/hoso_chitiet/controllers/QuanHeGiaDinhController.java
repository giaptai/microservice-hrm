package com.hrm.hoso_chitiet.controllers;

import com.hrm.hoso_chitiet.dto.request.ReqQuanHeGiaDinh;
import com.hrm.hoso_chitiet.dto.response.ResQuanHeGiaDinh;
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
@Tag(name = "Quan hệ gia đình ")
@SecurityRequirement(name = "Bearer Authentication")
@RequiredArgsConstructor
public class QuanHeGiaDinhController {
    private final IHoSoChiTietServices.IHoQuanHeGiaDinhServiceChiTiet quanHeGiaDinhService;
    @GetMapping("/{id}/quan-he-gia-dinh")
    public ResponseEntity<ResTheDTO<ResQuanHeGiaDinh>> getAllByHoSoId(
            @PathVariable(name = "id") UUID id,
            @RequestParam(name = "pheDuyet", required = false) XacNhan xacNhan,
            @RequestParam(name = "sort", required = false, defaultValue = "createAt") String byDate,
            @RequestParam(name = "page", required = false, defaultValue = "0") int pageNumber,
            @RequestParam(name = "size", required = false, defaultValue = "10") int pageSize) {
        ResTheDTO<ResQuanHeGiaDinh> ls = quanHeGiaDinhService.xemDanhSachTheoHoSoId(id, xacNhan, byDate, pageNumber, pageSize);
        return new ResponseEntity<>(ls, ResEnum.THANH_CONG.getStatusCode());
    }

    @GetMapping("/quan-he-gia-dinh")
    public ResponseEntity<ResTheDTO<ResQuanHeGiaDinh>> getAll(
            @RequestParam(name = "pheDuyet", required = false) XacNhan xacNhan,
            @RequestParam(name = "sort", required = false, defaultValue = "createAt") String byDate,
            @RequestParam(name = "page", required = false, defaultValue = "0") int pageNumber,
            @RequestParam(name = "size", required = false, defaultValue = "10") int pageSize) {
        ResTheDTO<ResQuanHeGiaDinh> ls = quanHeGiaDinhService.xemDanhSach(xacNhan, byDate, pageNumber, pageSize);
        return new ResponseEntity<>(ls, ResEnum.THANH_CONG.getStatusCode());
    }

    @GetMapping("/quan-he-gia-dinh/{id}")
    public ResponseEntity<ResQuanHeGiaDinh> getById(@PathVariable(name = "id") int id) {
        ResQuanHeGiaDinh ls = quanHeGiaDinhService.xemChiTiet(id);
        return new ResponseEntity<>(ls, ResEnum.THANH_CONG.getStatusCode());
    }

    @PostMapping("/quan-he-gia-dinh/{id}")
    @Transactional
    public ResponseEntity<ResQuanHeGiaDinh> add(@PathVariable(name = "id") UUID id, @RequestBody ReqQuanHeGiaDinh cu) {
        ResQuanHeGiaDinh ls = quanHeGiaDinhService.them(id, cu);
        return new ResponseEntity<>(ls, ResEnum.TAO_THANH_CONG.getStatusCode());
    }

    @PatchMapping("/quan-he-gia-dinh/{id}")
    public ResponseEntity<ResQuanHeGiaDinh> edit(
            @RequestHeader(name = "role", required = false) String role,
            @PathVariable(name = "id") int id, @RequestBody ReqQuanHeGiaDinh cu) {
        ResQuanHeGiaDinh ls = quanHeGiaDinhService.sua(id, cu, role);
        return new ResponseEntity<>(ls, ResEnum.CAP_NHAT_THANH_CONG.getStatusCode());
    }

    @DeleteMapping("/quan-he-gia-dinh/{id}")
    public ResponseEntity<Boolean> del(
            @RequestHeader(name = "role", required = false) String role,
            @PathVariable(name = "id") int id) {
        boolean ls = quanHeGiaDinhService.xoa(id, role);
        return new ResponseEntity<>(ls, ResEnum.XOA_THANH_CONG.getStatusCode());
    }

    @PatchMapping("/quan-he-gia-dinh/phe-duyet")
    public ResponseEntity<Boolean> approve(
            @RequestHeader(name = "role", required = false) String role,
            @RequestParam(name = "pheDuyet") XacNhan xacNhan,
            @RequestBody List<ResQuanHeGiaDinh> res
    ) {
        boolean ls = quanHeGiaDinhService.xacNhan(xacNhan, res);
        return new ResponseEntity<>(ls, ResEnum.CAP_NHAT_THANH_CONG.getStatusCode());
    }

    //EMPLOYEE
    @GetMapping("/ca-nhan/quan-he-gia-dinh")
    public ResponseEntity<ResTheDTO<ResQuanHeGiaDinh>> getAllCaNhan(
            @RequestHeader(name = "taiKhoanId", required = false) int id,
            @RequestParam(name = "pheDuyet", required = false) XacNhan xacNhan,
            @RequestParam(name = "sort", required = false, defaultValue = "createAt") String byDate,
            @RequestParam(name = "page", required = false, defaultValue = "0") int pageNumber,
            @RequestParam(name = "size", required = false, defaultValue = "10") int pageSize) {
        ResTheDTO<ResQuanHeGiaDinh> ls = quanHeGiaDinhService.xemDanhSachCaNhan(id, xacNhan, byDate, pageNumber, pageSize);
        return new ResponseEntity<>(ls, ResEnum.THANH_CONG.getStatusCode());
    }

    @GetMapping("/ca-nhan/quan-he-gia-dinh/{id}")
    public ResponseEntity<ResQuanHeGiaDinh> getByIdCaNhan(@PathVariable(name = "id") int id) {
        ResQuanHeGiaDinh ls = quanHeGiaDinhService.xemChiTiet(id);
        return new ResponseEntity<>(ls, ResEnum.THANH_CONG.getStatusCode());
    }

    @PostMapping("/ca-nhan/quan-he-gia-dinh")
    @Transactional
    public ResponseEntity<ResQuanHeGiaDinh> addCaNhan(@RequestHeader(name = "taiKhoanId", required = false) int id, @RequestBody ReqQuanHeGiaDinh cu) {
        ResQuanHeGiaDinh ls = quanHeGiaDinhService.themCaNhan(id, cu);
        return new ResponseEntity<>(ls, ResEnum.TAO_THANH_CONG.getStatusCode());
    }

    @PatchMapping("/ca-nhan/quan-he-gia-dinh/{id}")
    public ResponseEntity<ResQuanHeGiaDinh> editCaNhan(
            @RequestHeader(name = "role", required = false) String role,
            @PathVariable(name = "id") int id, @RequestBody ReqQuanHeGiaDinh cu) {
        ResQuanHeGiaDinh ls = quanHeGiaDinhService.sua(id, cu, role);
        return new ResponseEntity<>(ls, ResEnum.CAP_NHAT_THANH_CONG.getStatusCode());
    }

    @DeleteMapping("/ca-nhan/quan-he-gia-dinh/{id}")
    public ResponseEntity<Boolean> delCaNhan(
            @RequestHeader(name = "role", required = false) String role,
            @PathVariable(name = "id") int id) {
        boolean ls = quanHeGiaDinhService.xoa(id, role);
        return new ResponseEntity<>(ls, ResEnum.XOA_THANH_CONG.getStatusCode());
    }
}
