package com.hrm.taikhoan.controller;

import com.hrm.taikhoan.dto.request.ReqTaiKhoan;
import com.hrm.taikhoan.dto.resopnse.ResTaiKhoan;
import com.hrm.taikhoan.models.TaiKhoan;
import com.hrm.taikhoan.response.ResDTO;
import com.hrm.taikhoan.response.ResEnum;
import com.hrm.taikhoan.service.tai_khoan.ITaiKhoanService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.transaction.Transactional;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Tag(name = "Admin tai-khoan", description = "Quản lý")
@SecurityRequirement(name = "Bearer Authentication")
public class AdminTaiKhoanController {

    private final ITaiKhoanService taiKhoanService;

    public AdminTaiKhoanController(ITaiKhoanService taiKhoanService) {
        this.taiKhoanService = taiKhoanService;
    }

    @GetMapping("/nhan-vien/tai-khoan")
    public ResponseEntity<ResDTO<List<ResTaiKhoan>>> getAllTaiKhoan() {
        List<ResTaiKhoan> resTaiKhoans = taiKhoanService.xemDanhSachTaiKhoan().stream().map(ResTaiKhoan::mapToResTaiKhoan).toList();
        return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG, resTaiKhoans), ResEnum.THANH_CONG.getStatusCode());
    }

    @GetMapping("/nhan-vien/tai-khoan/{id}")
    public ResponseEntity<ResDTO<ResTaiKhoan>> getTaiKhoanBySoCCCD(@PathVariable(name = "id") int id) {
        TaiKhoan taiKhoan = taiKhoanService.xemTheoId(id);
        if (taiKhoan != null) {
            ResTaiKhoan resTaiKhoan = ResTaiKhoan.mapToResTaiKhoan(taiKhoan);
            return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG, resTaiKhoan), ResEnum.THANH_CONG.getStatusCode());
        }
        return new ResponseEntity<>(ResDTO.response(ResEnum.HONG_TIM_THAY_TAI_KHOAN, null), ResEnum.HONG_TIM_THAY_TAI_KHOAN.getStatusCode());
    }

    @GetMapping("/nhan-vien/tai-khoan/tim-kiem")
    public ResponseEntity<ResDTO<ResTaiKhoan>> getTaiKhoanBySoCCCD(@RequestParam(name = "q") String number) {
        TaiKhoan taiKhoan = taiKhoanService.xemTheoSoCCCDOrUsername(number);
        if (taiKhoan != null) {
            ResTaiKhoan resTaiKhoan = ResTaiKhoan.mapToResTaiKhoan(taiKhoan);
            return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG, resTaiKhoan), ResEnum.THANH_CONG.getStatusCode());
        }
        return new ResponseEntity<>(ResDTO.response(ResEnum.HONG_TIM_THAY_TAI_KHOAN, null), ResEnum.HONG_TIM_THAY_TAI_KHOAN.getStatusCode());
    }

    @PostMapping("/nhan-vien/tai-khoan")
    @Transactional(Transactional.TxType.NEVER)
    public ResponseEntity<ResDTO<ResTaiKhoan>> addTaiKhoan(@RequestBody ReqTaiKhoan reqTaiKhoan) {
        TaiKhoan taiKhoan = taiKhoanService.them(reqTaiKhoan);
        if (taiKhoan != null) {
            ResTaiKhoan resTaiKhoan = ResTaiKhoan.mapToResTaiKhoan(taiKhoan);
            return new ResponseEntity<>(ResDTO.response(ResEnum.TAO_TAI_KHOAN_THANH_CONG, resTaiKhoan), ResEnum.TAO_TAI_KHOAN_THANH_CONG.getStatusCode());
        } else
            return new ResponseEntity<>(ResDTO.response(ResEnum.TRUNG_DU_LIEU, null), ResEnum.TRUNG_DU_LIEU.getStatusCode());
    }
}
