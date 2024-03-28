package com.hrm.taikhoan.controller;

import com.hrm.taikhoan.dto.client.quan_he_gia_dinh.QuanHeGiaDinh;
import com.hrm.taikhoan.dto.client.quan_he_gia_dinh.ReqQuanHeGiaDinh;
import com.hrm.taikhoan.response.ResDTO;
import com.hrm.taikhoan.response.ResEnum;
import com.hrm.taikhoan.service.quan_he_gia_dinh.IQuanHeGiaDinhService;
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
public class QuanHeGiaDinhController {
    final IQuanHeGiaDinhService quanHeGiaDinhService;

    @GetMapping("/quan-he-gia-dinh")
    public ResponseEntity<ResDTO<List<QuanHeGiaDinh>>> getAll() {
        List<QuanHeGiaDinh> ls = quanHeGiaDinhService.xemDanhSach();
        return ResDTO.reply(ls, ResEnum.THANH_CONG);
    }

    @GetMapping("/quan-he-gia-dinh/{id}")
    public ResponseEntity<ResDTO<QuanHeGiaDinh>> getById(@PathVariable int id) {
        QuanHeGiaDinh ls = quanHeGiaDinhService.xemChiTiet(id);
        return ResDTO.reply(ls, ResEnum.THANH_CONG);
    }

    @PostMapping("/quan-he-gia-dinh/{id}")
    @Transactional
    public ResponseEntity<ResDTO<QuanHeGiaDinh>> add(@PathVariable UUID id, @RequestBody ReqQuanHeGiaDinh cu) {
        QuanHeGiaDinh ls = quanHeGiaDinhService.them(id, cu);
        return ResDTO.reply(ls, ResEnum.TAO_THANH_CONG);
    }

    @PatchMapping("/quan-he-gia-dinh/{id}")
    public ResponseEntity<ResDTO<QuanHeGiaDinh>> edit(@PathVariable int id, @RequestBody ReqQuanHeGiaDinh cu) {
        QuanHeGiaDinh ls = quanHeGiaDinhService.sua(id, cu);
        return ResDTO.reply(ls, ResEnum.CAP_NHAT_THANH_CONG);
    }

    @DeleteMapping("/quan-he-gia-dinh/{id}")
    public ResponseEntity<ResDTO<Boolean>> del(@PathVariable int id) {
        boolean ls = quanHeGiaDinhService.xoa(id);
        return ResDTO.reply(ls, ResEnum.XOA_THANH_CONG);
    }
}
