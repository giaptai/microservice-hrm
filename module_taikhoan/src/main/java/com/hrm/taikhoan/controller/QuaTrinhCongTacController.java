package com.hrm.taikhoan.controller;

import com.hrm.taikhoan.dto.client.qua_trinh_cong_tac.QuaTrinhCongTac;
import com.hrm.taikhoan.dto.client.qua_trinh_cong_tac.ReqQuaTrinhCongTac;
import com.hrm.taikhoan.response.ResDTO;
import com.hrm.taikhoan.response.ResEnum;
import com.hrm.taikhoan.service.qua_trinh_cong_tac.IQuaTrinhCongTacService;
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
public class QuaTrinhCongTacController {
    final IQuaTrinhCongTacService quaTrinhCongTacService;
    @GetMapping("/qua-trinh-cong-tac")
    public ResponseEntity<ResDTO<List<QuaTrinhCongTac>>> getAll() {
        List<QuaTrinhCongTac> ls = quaTrinhCongTacService.xemDanhSach();
        return ResDTO.reply(ls, ResEnum.THANH_CONG);
    }

    @GetMapping("/qua-trinh-cong-tac/{id}")
    public ResponseEntity<ResDTO<QuaTrinhCongTac>> getById(@PathVariable int id) {
        QuaTrinhCongTac ls = quaTrinhCongTacService.xemChiTiet(id);
        return ResDTO.reply(ls, ResEnum.THANH_CONG);
    }

    @PostMapping("/qua-trinh-cong-tac/{id}")
    @Transactional
    public ResponseEntity<ResDTO<QuaTrinhCongTac>> add(@PathVariable UUID id, @RequestBody ReqQuaTrinhCongTac cu) {
        QuaTrinhCongTac ls = quaTrinhCongTacService.them(id, cu);
        return ResDTO.reply(ls, ResEnum.TAO_THANH_CONG);
    }

    @PatchMapping("/qua-trinh-cong-tac/{id}")
    public ResponseEntity<ResDTO<QuaTrinhCongTac>> edit(@PathVariable int id, @RequestBody ReqQuaTrinhCongTac cu) {
        QuaTrinhCongTac ls = quaTrinhCongTacService.sua(id, cu);
        return ResDTO.reply(ls, ResEnum.CAP_NHAT_THANH_CONG);
    }

    @DeleteMapping("/qua-trinh-cong-tac/{id}")
    public ResponseEntity<ResDTO<Boolean>> del(@PathVariable int id) {
        boolean ls = quaTrinhCongTacService.xoa(id);
        return ResDTO.reply(ls, ResEnum.XOA_THANH_CONG);
    }
}
