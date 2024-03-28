package com.hrm.taikhoan.controller;

import com.hrm.taikhoan.dto.client.lam_viec_o_nuoc_ngoai.LamViecONuocNgoai;
import com.hrm.taikhoan.dto.client.lam_viec_o_nuoc_ngoai.ReqLamViecONuocNgoai;
import com.hrm.taikhoan.response.ResDTO;
import com.hrm.taikhoan.response.ResEnum;
import com.hrm.taikhoan.service.lam_viec_o_nuoc_ngoai.ILamViecONuocNgoaiService;
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
public class LamViecONuocNgoaiController {
    final ILamViecONuocNgoaiService lamViecONuocNgoaiService;
    @GetMapping("/lam-viec-o-nuoc-ngoai")
    public ResponseEntity<ResDTO<List<LamViecONuocNgoai>>> getAll() {
        List<LamViecONuocNgoai> ls = lamViecONuocNgoaiService.xemDanhSach();
        return ResDTO.reply(ls, ResEnum.THANH_CONG);
    }

    @GetMapping("/lam-viec-o-nuoc-ngoai/{id}")
    public ResponseEntity<ResDTO<LamViecONuocNgoai>> getById(@PathVariable int id) {
        LamViecONuocNgoai ls = lamViecONuocNgoaiService.xemChiTiet(id);
        return ResDTO.reply(ls, ResEnum.THANH_CONG);
    }

    @PostMapping("/lam-viec-o-nuoc-ngoai/{id}")
    @Transactional
    public ResponseEntity<ResDTO<LamViecONuocNgoai>> add(@PathVariable UUID id, @RequestBody ReqLamViecONuocNgoai cu) {
        LamViecONuocNgoai ls = lamViecONuocNgoaiService.them(id, cu);
        return ResDTO.reply(ls, ResEnum.TAO_THANH_CONG);
    }

    @PatchMapping("/lam-viec-o-nuoc-ngoai/{id}")
    public ResponseEntity<ResDTO<LamViecONuocNgoai>> edit(@PathVariable int id, @RequestBody ReqLamViecONuocNgoai cu) {
        LamViecONuocNgoai ls = lamViecONuocNgoaiService.sua(id, cu);
        return ResDTO.reply(ls, ResEnum.CAP_NHAT_THANH_CONG);
    }

    @DeleteMapping("/lam-viec-o-nuoc-ngoai/{id}")
    public ResponseEntity<ResDTO<Boolean>> del(@PathVariable int id) {
        boolean ls = lamViecONuocNgoaiService.xoa(id);
        return ResDTO.reply(ls, ResEnum.XOA_THANH_CONG);
    }
}
