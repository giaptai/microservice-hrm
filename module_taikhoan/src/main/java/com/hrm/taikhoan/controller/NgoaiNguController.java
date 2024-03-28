package com.hrm.taikhoan.controller;

import com.hrm.taikhoan.dto.client.ngoai_ngu.NgoaiNgu;
import com.hrm.taikhoan.dto.client.ngoai_ngu.ReqNgoaiNgu;
import com.hrm.taikhoan.response.ResDTO;
import com.hrm.taikhoan.response.ResEnum;
import com.hrm.taikhoan.service.ngoai_ngu.INgoaiNguService;
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
public class NgoaiNguController {
    final INgoaiNguService ngoaiNguService;
    @GetMapping("/ngoai-ngu")
    public ResponseEntity<ResDTO<List<NgoaiNgu>>> getAll() {
        List<NgoaiNgu> ls = ngoaiNguService.xemDanhSach();
        return ResDTO.reply(ls, ResEnum.THANH_CONG);
    }

    @GetMapping("/ngoai-ngu/{id}")
    public ResponseEntity<ResDTO<NgoaiNgu>> getById(@PathVariable int id) {
        NgoaiNgu ls = ngoaiNguService.xemChiTiet(id);
        return ResDTO.reply(ls, ResEnum.THANH_CONG);
    }

    @PostMapping("/ngoai-ngu/{id}")
    @Transactional
    public ResponseEntity<ResDTO<NgoaiNgu>> add(@PathVariable UUID id, @RequestBody ReqNgoaiNgu cu) {
        NgoaiNgu ls = ngoaiNguService.them(id, cu);
        return ResDTO.reply(ls, ResEnum.TAO_THANH_CONG);
    }

    @PatchMapping("/ngoai-ngu/{id}")
    public ResponseEntity<ResDTO<NgoaiNgu>> edit(@PathVariable int id, @RequestBody ReqNgoaiNgu cu) {
        NgoaiNgu ls = ngoaiNguService.sua(id, cu);
        return ResDTO.reply(ls, ResEnum.CAP_NHAT_THANH_CONG);
    }

    @DeleteMapping("/ngoai-ngu/{id}")
    public ResponseEntity<ResDTO<Boolean>> del(@PathVariable int id) {
        boolean ls = ngoaiNguService.xoa(id);
        return ResDTO.reply(ls, ResEnum.XOA_THANH_CONG);
    }
}
