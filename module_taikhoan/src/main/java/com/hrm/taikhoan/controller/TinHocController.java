package com.hrm.taikhoan.controller;

import com.hrm.taikhoan.dto.client.tin_hoc.ReqTinHoc;
import com.hrm.taikhoan.dto.client.tin_hoc.TinHoc;
import com.hrm.taikhoan.response.ResDTO;
import com.hrm.taikhoan.response.ResEnum;
import com.hrm.taikhoan.service.tin_hoc.ITinHocService;
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
public class TinHocController {
    final ITinHocService tinHocService;
    @GetMapping("/tin-hoc")
    public ResponseEntity<ResDTO<List<TinHoc>>> getAll() {
        List<TinHoc> ls = tinHocService.xemDanhSach();
        return ResDTO.reply(ls, ResEnum.THANH_CONG);
    }

    @GetMapping("/tin-hoc/{id}")
    public ResponseEntity<ResDTO<TinHoc>> getById(@PathVariable int id) {
        TinHoc ls = tinHocService.xemChiTiet(id);
        return ResDTO.reply(ls, ResEnum.THANH_CONG);
    }

    @PostMapping("/tin-hoc/{id}")
    @Transactional
    public ResponseEntity<ResDTO<TinHoc>> add(@PathVariable UUID id, @RequestBody ReqTinHoc cu) {
        TinHoc ls = tinHocService.them(id, cu);
        return ResDTO.reply(ls, ResEnum.TAO_THANH_CONG);
    }

    @PatchMapping("/tin-hoc/{id}")
    public ResponseEntity<ResDTO<TinHoc>> edit(@PathVariable int id, @RequestBody ReqTinHoc cu) {
        TinHoc ls = tinHocService.sua(id, cu);
        return ResDTO.reply(ls, ResEnum.CAP_NHAT_THANH_CONG);

    }

    @DeleteMapping("/tin-hoc/{id}")
    public ResponseEntity<ResDTO<Boolean>> del(@PathVariable int id) {
        boolean ls = tinHocService.xoa(id);
        return ResDTO.reply(ls, ResEnum.XOA_THANH_CONG);
    }
}