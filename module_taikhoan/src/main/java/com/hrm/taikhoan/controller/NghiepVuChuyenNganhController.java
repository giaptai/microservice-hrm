package com.hrm.taikhoan.controller;

import com.hrm.taikhoan.dto.client.nghiep_vu_chuyen_nganh.NghiepVuChuyenNganh;
import com.hrm.taikhoan.dto.client.nghiep_vu_chuyen_nganh.ReqNghiepVuChuyenNganh;
import com.hrm.taikhoan.response.ResDTO;
import com.hrm.taikhoan.response.ResEnum;
import com.hrm.taikhoan.service.nghiep_vu_chuyen_nganh.INghiepVuChuyenNganhService;
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
public class NghiepVuChuyenNganhController {
    final INghiepVuChuyenNganhService nghiepVuChuyenNganhService;
    @GetMapping("/nghiep-vu-chuyen-nganh")
    public ResponseEntity<ResDTO<List<NghiepVuChuyenNganh>>> getAll() {
        List<NghiepVuChuyenNganh> ls = nghiepVuChuyenNganhService.xemDanhSach();
        return ResDTO.reply(ls, ResEnum.THANH_CONG);
    }

    @GetMapping("/nghiep-vu-chuyen-nganh/{id}")
    public ResponseEntity<ResDTO<NghiepVuChuyenNganh>> getById(@PathVariable int id) {
        NghiepVuChuyenNganh ls = nghiepVuChuyenNganhService.xemChiTiet(id);
        return ResDTO.reply(ls, ResEnum.THANH_CONG);
    }

    @PostMapping("/nghiep-vu-chuyen-nganh/{id}")
    @Transactional
    public ResponseEntity<ResDTO<NghiepVuChuyenNganh>> add(@PathVariable UUID id, @RequestBody ReqNghiepVuChuyenNganh cu) {
        NghiepVuChuyenNganh ls = nghiepVuChuyenNganhService.them(id, cu);
        return ResDTO.reply(ls, ResEnum.TAO_THANH_CONG);
    }

    @PatchMapping("/nghiep-vu-chuyen-nganh/{id}")
    public ResponseEntity<ResDTO<NghiepVuChuyenNganh>> edit(@PathVariable int id, @RequestBody ReqNghiepVuChuyenNganh cu) {
        NghiepVuChuyenNganh ls = nghiepVuChuyenNganhService.sua(id, cu);
        return ResDTO.reply(ls, ResEnum.CAP_NHAT_THANH_CONG);
    }

    @DeleteMapping("/nghiep-vu-chuyen-nganh/{id}")
    public ResponseEntity<ResDTO<Boolean>> del(@PathVariable int id) {
        boolean ls = nghiepVuChuyenNganhService.xoa(id);
        return ResDTO.reply(ls, ResEnum.XOA_THANH_CONG);
    }
}
