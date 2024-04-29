package com.hrm.hoso_chitiet.controllers;

import com.hrm.hoso_chitiet.dto.request.ReqKienThucAnNinhQuocPhong;
import com.hrm.hoso_chitiet.dto.response.ResKienThucAnNinhQuocPhong;
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
@Tag(name = "Kiến thức an ninh quốc phòng ")
@SecurityRequirement(name = "Bearer Authentication")
@RequiredArgsConstructor // create constructor if field set final or @not null
public class KienThucAnNinhQuocPhongController {
    private final IHoSoChiTietServices.IHoKienThucAnNinhQuocPhongServiceChiTiet kienThucAnNinhQuocPhongService;

    @GetMapping("/{id}/kien-thuc-an-ninh-quoc-phong")
    public ResponseEntity<ResTheDTO<ResKienThucAnNinhQuocPhong>> getAllByHoSoId(
            @PathVariable(name = "id") UUID id,
            @RequestParam(name = "pheDuyet", required = false) XacNhan xacNhan,
            @RequestParam(name = "sort", required = false, defaultValue = "createAt") String byDate,
            @RequestParam(name = "page", required = false, defaultValue = "0") int pageNumber,
            @RequestParam(name = "size", required = false, defaultValue = "10") int pageSize) {
        ResTheDTO<ResKienThucAnNinhQuocPhong> ls = kienThucAnNinhQuocPhongService.xemDanhSachTheoHoSoId(id, xacNhan, byDate, pageNumber, pageSize);
        return new ResponseEntity<>(ls, ResEnum.THANH_CONG.getStatusCode());
    }

    @GetMapping("/kien-thuc-an-ninh-quoc-phong")
    public ResponseEntity<ResTheDTO<ResKienThucAnNinhQuocPhong>> getAll(
            @RequestParam(name = "pheDuyet", required = false) XacNhan xacNhan,
            @RequestParam(name = "sort", required = false, defaultValue = "createAt") String byDate,
            @RequestParam(name = "page", required = false, defaultValue = "0") int pageNumber,
            @RequestParam(name = "size", required = false, defaultValue = "10") int pageSize
    ) {
        ResTheDTO<ResKienThucAnNinhQuocPhong> ls = kienThucAnNinhQuocPhongService.xemDanhSach(xacNhan, byDate, pageNumber, pageSize);
        return new ResponseEntity<>(ls, ResEnum.THANH_CONG.getStatusCode());
    }

    @GetMapping("/kien-thuc-an-ninh-quoc-phong/{id}")
    public ResponseEntity<ResKienThucAnNinhQuocPhong> getById(@PathVariable(name = "id") int id) {
        ResKienThucAnNinhQuocPhong ls = kienThucAnNinhQuocPhongService.xemChiTiet(id);
        return new ResponseEntity<>(ls, ResEnum.THANH_CONG.getStatusCode());
    }

    @PostMapping("/kien-thuc-an-ninh-quoc-phong/{id}")
    @Transactional
    public ResponseEntity<ResKienThucAnNinhQuocPhong> add(@PathVariable(name = "id") UUID id, @RequestBody ReqKienThucAnNinhQuocPhong cu) {
        ResKienThucAnNinhQuocPhong ls = kienThucAnNinhQuocPhongService.them(id, cu);
        return new ResponseEntity<>(ls, ResEnum.TAO_THANH_CONG.getStatusCode());
    }

    @PatchMapping("/kien-thuc-an-ninh-quoc-phong/{id}")
    public ResponseEntity<ResKienThucAnNinhQuocPhong> edit(
            @RequestHeader(name = "role", required = false) String role,
            @PathVariable(name = "id") int id, @RequestBody ReqKienThucAnNinhQuocPhong cu) {
        ResKienThucAnNinhQuocPhong ls = kienThucAnNinhQuocPhongService.sua(id, cu, role);
        return new ResponseEntity<>(ls, ResEnum.CAP_NHAT_THANH_CONG.getStatusCode());
    }

    @DeleteMapping("/kien-thuc-an-ninh-quoc-phong/{id}")
    public ResponseEntity<Boolean> del(
            @RequestHeader(name = "role", required = false) String role,
            @PathVariable(name = "id") int id) {
        boolean ls = kienThucAnNinhQuocPhongService.xoa(id, role);
        return new ResponseEntity<>(ls, ResEnum.XOA_THANH_CONG.getStatusCode());
    }

    @PatchMapping("/kien-thuc-an-ninh-quoc-phong/phe-duyet")
    public ResponseEntity<Boolean> approve(
            @RequestHeader(name = "role", required = false) String role,
            @RequestParam(name = "pheDuyet") XacNhan xacNhan,
            @RequestBody List<ResKienThucAnNinhQuocPhong> res
    ) {
        boolean ls = kienThucAnNinhQuocPhongService.xacNhan(xacNhan, res);
        return new ResponseEntity<>(ls, ResEnum.CAP_NHAT_THANH_CONG.getStatusCode());
    }

    //EMPLOYEE
    @GetMapping("/ca-nhan/kien-thuc-an-ninh-quoc-phong")
    public ResponseEntity<ResTheDTO<ResKienThucAnNinhQuocPhong>> getAllCaNhan(
            @RequestHeader(name = "taiKhoanId", required = false) int id,
            @RequestParam(name = "pheDuyet", required = false) XacNhan xacNhan,
            @RequestParam(name = "sort", required = false, defaultValue = "createAt") String byDate,
            @RequestParam(name = "page", required = false, defaultValue = "0") int pageNumber,
            @RequestParam(name = "size", required = false, defaultValue = "10") int pageSize) {
        ResTheDTO<ResKienThucAnNinhQuocPhong> ls = kienThucAnNinhQuocPhongService.xemDanhSachCaNhan(id, xacNhan, byDate, pageNumber, pageSize);
        return new ResponseEntity<>(ls, ResEnum.THANH_CONG.getStatusCode());
    }

    @GetMapping("/ca-nhan/kien-thuc-an-ninh-quoc-phong/{id}")
    public ResponseEntity<ResKienThucAnNinhQuocPhong> getByIdCaNhan(@PathVariable(name = "id") int id) {
        ResKienThucAnNinhQuocPhong ls = kienThucAnNinhQuocPhongService.xemChiTiet(id);
        return new ResponseEntity<>(ls, ResEnum.THANH_CONG.getStatusCode());
    }

    @PostMapping("/ca-nhan/kien-thuc-an-ninh-quoc-phong")
    @Transactional
    public ResponseEntity<ResKienThucAnNinhQuocPhong> addCaNhan(@RequestHeader(name = "taiKhoanId", required = false) int id, @RequestBody ReqKienThucAnNinhQuocPhong cu) {
        ResKienThucAnNinhQuocPhong ls = kienThucAnNinhQuocPhongService.themCaNhan(id, cu);
        return new ResponseEntity<>(ls, ResEnum.TAO_THANH_CONG.getStatusCode());
    }

    @PatchMapping("/ca-nhan/kien-thuc-an-ninh-quoc-phong/{id}")
    public ResponseEntity<ResKienThucAnNinhQuocPhong> editCaNhan(
            @RequestHeader(name = "role", required = false) String role,
            @PathVariable(name = "id") int id, @RequestBody ReqKienThucAnNinhQuocPhong cu) {
        ResKienThucAnNinhQuocPhong ls = kienThucAnNinhQuocPhongService.sua(id, cu, role);
        return new ResponseEntity<>(ls, ResEnum.CAP_NHAT_THANH_CONG.getStatusCode());
    }

    @DeleteMapping("/ca-nhan/kien-thuc-an-ninh-quoc-phong/{id}")
    public ResponseEntity<Boolean> delCaNhan(
            @RequestHeader(name = "role", required = false) String role,
            @PathVariable(name = "id") int id) {
        boolean ls = kienThucAnNinhQuocPhongService.xoa(id, role);
        return new ResponseEntity<>(ls, ResEnum.XOA_THANH_CONG.getStatusCode());
    }
}
