package com.hrm.taikhoan.controller;

import com.hrm.taikhoan.dto.client.phu_cap_khac.PhuCapKhac;
import com.hrm.taikhoan.dto.client.phu_cap_khac.ReqPhuCapKhac;
import com.hrm.taikhoan.response.ResDTO;
import com.hrm.taikhoan.response.ResEnum;
import com.hrm.taikhoan.service.phu_cap_khac.IPhuCapKhacService;
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
public class PhuCapKhacController {
    final IPhuCapKhacService phuCapKhacService;
    @GetMapping("/phu-cap-khac")
    public ResponseEntity<ResDTO<List<PhuCapKhac>>> getAll() {
        List<PhuCapKhac> ls = phuCapKhacService.xemDanhSach();
        return ResDTO.reply(ls, ResEnum.THANH_CONG);
    }

    @GetMapping("/phu-cap-khac/{id}")
    public ResponseEntity<ResDTO<PhuCapKhac>> getById(@PathVariable int id) {
        PhuCapKhac ls = phuCapKhacService.xemChiTiet(id);
        return ResDTO.reply(ls, ResEnum.THANH_CONG);
    }

    @PostMapping("/phu-cap-khac/{id}")
    @Transactional
    public ResponseEntity<ResDTO<PhuCapKhac>> add(@PathVariable UUID id, @RequestBody ReqPhuCapKhac cu) {
        PhuCapKhac ls = phuCapKhacService.them(id, cu);
        return ResDTO.reply(ls, ResEnum.TAO_THANH_CONG);
    }

    @PatchMapping("/phu-cap-khac/{id}")
    public ResponseEntity<ResDTO<PhuCapKhac>> edit(@PathVariable int id, @RequestBody ReqPhuCapKhac cu) {
        PhuCapKhac ls = phuCapKhacService.sua(id, cu);
        return ResDTO.reply(ls, ResEnum.CAP_NHAT_THANH_CONG);
    }

    @DeleteMapping("/phu-cap-khac/{id}")
    public ResponseEntity<ResDTO<Boolean>> del(@PathVariable int id) {
        boolean ls = phuCapKhacService.xoa(id);
        return ResDTO.reply(ls, ResEnum.XOA_THANH_CONG);
    }
}
