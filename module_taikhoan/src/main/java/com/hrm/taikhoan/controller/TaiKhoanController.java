package com.hrm.taikhoan.controller;

import com.hrm.taikhoan.dto.request.ReqEmail;
import com.hrm.taikhoan.dto.request.ReqMatKhau;
import com.hrm.taikhoan.dto.request.ReqTaiKhoan;
import com.hrm.taikhoan.dto.request.ReqTaiKhoanLogin;
import com.hrm.taikhoan.dto.resopnse.ResTaiKhoan;
import com.hrm.taikhoan.dto.resopnse.ResTaiKhoanLogin;
import com.hrm.taikhoan.dto.resopnse.ResTheDTO;
import com.hrm.taikhoan.enums.RoleTaiKhoan;
import com.hrm.taikhoan.response.ResDTO;
import com.hrm.taikhoan.response.ResEnum;

import com.hrm.taikhoan.service.ITaiKhoanService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

import jakarta.transaction.Transactional;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@SecurityRequirement(name = "Bearer Authentication")
public class TaiKhoanController {
    final ITaiKhoanService taiKhoanService;
    @PostMapping("/dang-nhap")
    public ResponseEntity<ResDTO<ResTaiKhoanLogin>> dangNhap(@RequestBody ReqTaiKhoanLogin reqTaiKhoanLogin) {
        ResTaiKhoanLogin taiKhoan = taiKhoanService.dangNhap(reqTaiKhoanLogin);
        return ResDTO.reply(taiKhoan, ResEnum.DANG_NHAP_THANH_CONG);
    }

    @PostMapping("/dang-nhap/quen-mat-khau")
    public ResponseEntity<Boolean> quenMatKhau(@RequestBody ReqEmail email) {
        boolean sss = taiKhoanService.quenMatKhau(email.email());
        return new ResponseEntity<>(sss, ResEnum.DANG_NHAP_THANH_CONG.getStatusCode());
    }

    @GetMapping("/nhan-vien/tai-khoan")
    public ResponseEntity<ResTheDTO> getAllTaiKhoan(
            @RequestParam(name = "sort", required = false, defaultValue = "createAt") String byDate,
            @RequestParam(name = "username", required = false) String username,
            @RequestParam(name = "role", required = false) RoleTaiKhoan role,
            @RequestParam(name = "page", required = false, defaultValue = "0") int pageNumber,
            @RequestParam(name = "size", required = false, defaultValue = "10") int pageSize
    ) {
//        return ResDTO.reply(taiKhoanService.xemDanhSachTaiKhoan(byDate, username, role, pageNumber, pageSize), ResEnum.THANH_CONG);
        return new ResponseEntity<>(taiKhoanService.xemDanhSachTaiKhoan(byDate, username, role, pageNumber, pageSize), ResEnum.THANH_CONG.getStatusCode());
    }

    @GetMapping("/nhan-vien/tai-khoan/{id}")
    public ResponseEntity<ResDTO<ResTaiKhoan>> getTaiKhoanById(@PathVariable(name = "id") int id) {
        return ResDTO.reply(taiKhoanService.xemTheoId(id), ResEnum.THANH_CONG);
    }

//    @GetMapping("/nhan-vien/tai-khoan/tim-kiem")
//    public ResponseEntity<ResDTO<List<ResTaiKhoan>>> getTaiKhoanBySoCCCD(
//            @RequestParam(name = "page", required = false, defaultValue = "0") int pageNumber,
//            @RequestParam(name = "size", required = false, defaultValue = "10") int pageSize,
//            @RequestParam(name = "q") String username) {
//        return ResDTO.reply(taiKhoanService.xemTheoUsername(username, pageNumber, pageSize), ResEnum.THANH_CONG);
//    }

    @PostMapping("/nhan-vien/tai-khoan")
    @Transactional(Transactional.TxType.NEVER)
    public ResponseEntity<ResDTO<ResTaiKhoan>> addTaiKhoan(@RequestBody ReqTaiKhoan reqTaiKhoan) {
        return ResDTO.reply(taiKhoanService.them(reqTaiKhoan), ResEnum.TAO_TAI_KHOAN_THANH_CONG);
    }

    @PostMapping("/nhan-vien/tai-khoan-api")
    @Transactional(Transactional.TxType.NEVER)
    public ResponseEntity<ResDTO<ResTaiKhoan>> addTaiKhoanApi(@RequestBody ReqTaiKhoan reqTaiKhoan) {
        return ResDTO.reply(taiKhoanService.themApi(reqTaiKhoan), ResEnum.TAO_TAI_KHOAN_THANH_CONG);
    }

    //EMPLOYEE - EMPLOYEE - EMPLOYEE
    @GetMapping("/ca-nhan/tai-khoan")
    @Transactional
    public ResponseEntity<ResDTO<ResTaiKhoan>> getTaiKhoanCaNhan(@RequestHeader(name = "taiKhoanId", required = false) int id) {
        return ResDTO.reply(taiKhoanService.xemTaiKhoanCaNhan(id), ResEnum.THANH_CONG);
    }

    @PatchMapping("/ca-nhan/tai-khoan/doi-mat-khau")
    @Transactional
    public ResponseEntity<ResDTO<Boolean>> doi_mat_khau(@RequestHeader(name = "taiKhoanId", required = false) int id, @RequestBody ReqMatKhau matkhau) {
        boolean doiMk = taiKhoanService.doiMatKhauTaiKhoanCaNhan(id, matkhau.matkhau());
        return ResDTO.reply(doiMk, ResEnum.DOI_MAT_KHAU_THANH_CONG);
    }

    @PatchMapping("/ca-nhan/tai-khoan/doi-email")
    @Transactional
    public ResponseEntity<ResDTO<Boolean>> doi_email(@RequestHeader(name = "taiKhoanId", required = false) int id, @RequestBody ReqEmail email) {
        boolean doiEm = taiKhoanService.doiEmailTaiKhoanCaNhan(id, email.email());
        return ResDTO.reply(doiEm, ResEnum.DOI_EMAIL_THANH_CONG);
    }
}
