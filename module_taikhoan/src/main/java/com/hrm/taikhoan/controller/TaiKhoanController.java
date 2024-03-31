package com.hrm.taikhoan.controller;

import com.hrm.taikhoan.dto.request.ReqEmail;
import com.hrm.taikhoan.dto.request.ReqMatKhau;
import com.hrm.taikhoan.dto.request.ReqTaiKhoan;
import com.hrm.taikhoan.dto.resopnse.ResTaiKhoan;
import com.hrm.taikhoan.models.TaiKhoan;
import com.hrm.taikhoan.response.ResDTO;
import com.hrm.taikhoan.response.ResEnum;
import com.hrm.taikhoan.service.tai_khoan.ITaiKhoanService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Tag(name = "Tài khoản")
@SecurityRequirement(name = "Bearer Authentication")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TaiKhoanController {
    final ITaiKhoanService taiKhoanService;

    @GetMapping("/nhan-vien/tai-khoan")
    public ResponseEntity<ResDTO<List<ResTaiKhoan>>> getAllTaiKhoan() {
        List<ResTaiKhoan> resTaiKhoans = taiKhoanService.xemDanhSachTaiKhoan().stream().map(ResTaiKhoan::mapToResTaiKhoan).toList();
        return ResDTO.reply(resTaiKhoans, ResEnum.THANH_CONG);
    }

    @GetMapping("/nhan-vien/tai-khoan/{id}")
    public ResponseEntity<ResDTO<ResTaiKhoan>> getTaiKhoanBySoCCCD(@PathVariable(name = "id") int id) {
        TaiKhoan taiKhoan = taiKhoanService.xemTheoId(id);
        ResTaiKhoan resTaiKhoan = ResTaiKhoan.mapToResTaiKhoan(taiKhoan);
        return ResDTO.reply(resTaiKhoan, ResEnum.THANH_CONG);
    }

    @GetMapping("/nhan-vien/tai-khoan/tim-kiem")
    public ResponseEntity<ResDTO<ResTaiKhoan>> getTaiKhoanBySoCCCD(@RequestParam(name = "q") String number) {
        TaiKhoan taiKhoan = taiKhoanService.xemTheoSoCCCDOrUsername(number);
        ResTaiKhoan resTaiKhoan = ResTaiKhoan.mapToResTaiKhoan(taiKhoan);
        return ResDTO.reply(resTaiKhoan, ResEnum.THANH_CONG);
    }

    @PostMapping("/nhan-vien/tai-khoan")
    @Transactional(Transactional.TxType.NEVER)
    public ResponseEntity<ResDTO<ResTaiKhoan>> addTaiKhoan(@RequestBody ReqTaiKhoan reqTaiKhoan) {
        TaiKhoan taiKhoan = taiKhoanService.them(reqTaiKhoan);
        ResTaiKhoan resTaiKhoan = ResTaiKhoan.mapToResTaiKhoan(taiKhoan);
        return ResDTO.reply(resTaiKhoan, ResEnum.TAO_TAI_KHOAN_THANH_CONG);
    }

    //thong-tin-ca-nhan
    @GetMapping("/ca-nhan/tai-khoan")
    @Transactional
    public ResponseEntity<ResDTO<ResTaiKhoan>> thong_tin_ca_nhan() {
        ResTaiKhoan resTaiKhoan = ResTaiKhoan.mapToResTaiKhoan(taiKhoanService.xemThongTin());
        return ResDTO.reply(resTaiKhoan, ResEnum.THANH_CONG);
    }

    //doi-mat-khau
    @PatchMapping("/ca-nhan/tai-khoan/doi-mat-khau")
    @Transactional
    public ResponseEntity<ResDTO<Boolean>> doi_mat_khau(@RequestBody ReqMatKhau reqMatKhau) {
        boolean doiMk = taiKhoanService.doiMatKhau(reqMatKhau.matkhau());
        return ResDTO.reply(doiMk, ResEnum.DOI_MAT_KHAU_THANH_CONG);
    }

    @PatchMapping("/ca-nhan/tai-khoan/doi-email")
    @Transactional
    public ResponseEntity<ResDTO<Boolean>> doi_email(@RequestBody ReqEmail email) {
        boolean doiEm = taiKhoanService.doiEmail(email.email());
        return ResDTO.reply(doiEm, ResEnum.DOI_EMAIL_THANH_CONG);
    }
}
