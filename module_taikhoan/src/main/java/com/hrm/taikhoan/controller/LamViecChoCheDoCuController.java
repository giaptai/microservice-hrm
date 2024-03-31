package com.hrm.taikhoan.controller;

import com.hrm.taikhoan.dto.client.lam_viec_cho_che_do_cu.LamViecChoCheDoCu;
import com.hrm.taikhoan.dto.client.lam_viec_cho_che_do_cu.LamViecChoCheDoCuDTO;
import com.hrm.taikhoan.dto.client.lam_viec_cho_che_do_cu.ReqLamViecChoCheDoCu;
import com.hrm.taikhoan.response.ResDTO;
import com.hrm.taikhoan.response.ResEnum;
import com.hrm.taikhoan.service.lam_cho_che_do_cu.ILamViecChoCheDoCuService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@SecurityRequirement(name = "Bearer Authentication")
public class LamViecChoCheDoCuController {
    final ILamViecChoCheDoCuService lamViecChoCheDoCuService;
    @GetMapping("/lam-viec-cho-che-do-cu")
    public ResponseEntity<ResDTO<List<LamViecChoCheDoCu>>> getAll() {
        List<LamViecChoCheDoCu> ls = lamViecChoCheDoCuService.xemDanhSach();
        return ResDTO.reply(ls, ResEnum.THANH_CONG);
    }
    @GetMapping("/lam-viec-cho-che-do-cu/{id}")
    public ResponseEntity<ResDTO<LamViecChoCheDoCu>> getById(@PathVariable int id) {
        LamViecChoCheDoCu ls = lamViecChoCheDoCuService.xemChiTiet(id);
        return ResDTO.reply(ls, ResEnum.THANH_CONG);
    }

    @PostMapping("/lam-viec-cho-che-do-cu/{id}")
    @Transactional
    public ResponseEntity<ResDTO<LamViecChoCheDoCu>> add(@PathVariable UUID id, @RequestBody ReqLamViecChoCheDoCu cu) {
        LamViecChoCheDoCu ls = lamViecChoCheDoCuService.them(id, cu);
        return ResDTO.reply(ls, ResEnum.TAO_THANH_CONG);
    }

    @PatchMapping("/lam-viec-cho-che-do-cu/{id}")
    public ResponseEntity<ResDTO<LamViecChoCheDoCu>> edit(@PathVariable int id, @RequestBody ReqLamViecChoCheDoCu cu) {
        LamViecChoCheDoCu ls = lamViecChoCheDoCuService.sua(id, cu);
        return ResDTO.reply(ls, ResEnum.CAP_NHAT_THANH_CONG);
    }

    @DeleteMapping("/lam-viec-cho-che-do-cu/{id}")
    public ResponseEntity<ResDTO<Boolean>> del(@PathVariable int id) {
        boolean ls = lamViecChoCheDoCuService.xoa(id);
        return ResDTO.reply(ls, ResEnum.XOA_THANH_CONG);
    }
    @GetMapping("/ca-nhan/lam-viec-cho-che-do-cu")
    public ResponseEntity<ResDTO<List<LamViecChoCheDoCuDTO>>> CaNhanGetAll() {
        List<LamViecChoCheDoCuDTO> ls = lamViecChoCheDoCuService.xemDanhSachCaNhan();
        return ResDTO.reply(ls, ResEnum.THANH_CONG);
    }
    @PostMapping("/ca-nhan/lam-viec-cho-che-do-cu")
    public ResponseEntity<ResDTO<LamViecChoCheDoCu>> caNhanAdd(@RequestBody ReqLamViecChoCheDoCu req) {
        LamViecChoCheDoCu ls = lamViecChoCheDoCuService.themCaNhan(req);
        return ResDTO.reply(ls, ResEnum.TAO_THANH_CONG);
    }

    @PatchMapping("/ca-nhan/lam-viec-cho-che-do-cu/{id}")
    public ResponseEntity<ResDTO<LamViecChoCheDoCu>> caNhanEdit(@PathVariable int id, @RequestBody ReqLamViecChoCheDoCu req) {
        LamViecChoCheDoCu ls = lamViecChoCheDoCuService.sua(id, req);
        return ResDTO.reply(ls, ResEnum.CAP_NHAT_THANH_CONG);
    }

    @DeleteMapping("/ca-nhan/lam-viec-cho-che-do-cu/{id}")
    public ResponseEntity<ResDTO<Boolean>> caNhanDel(@PathVariable int id) {
        boolean ls = lamViecChoCheDoCuService.xoa(id);
        return ResDTO.reply(ls, ResEnum.XOA_THANH_CONG);
    }
}
