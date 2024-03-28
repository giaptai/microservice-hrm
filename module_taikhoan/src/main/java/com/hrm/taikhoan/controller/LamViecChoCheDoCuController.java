package com.hrm.taikhoan.controller;

import com.hrm.taikhoan.dto.client.lam_viec_cho_che_do_cu.LamViecChoCheDoCu;
import com.hrm.taikhoan.dto.client.lam_viec_cho_che_do_cu.ReqLamViecChoCheDoCu;
import com.hrm.taikhoan.response.ResDTO;
import com.hrm.taikhoan.response.ResEnum;
import com.hrm.taikhoan.service.lam_cho_che_do_cu.ILamViecChoCheDoCuService;
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
}
