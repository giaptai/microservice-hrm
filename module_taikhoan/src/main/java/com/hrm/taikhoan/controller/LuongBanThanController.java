package com.hrm.taikhoan.controller;

import com.hrm.taikhoan.dto.client.luong_ban_than.LuongBanThan;
import com.hrm.taikhoan.dto.client.luong_ban_than.ReqLuongBanThan;
import com.hrm.taikhoan.response.ResDTO;
import com.hrm.taikhoan.response.ResEnum;
import com.hrm.taikhoan.service.luong_ban_than.ILuongBanThanService;
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
public class LuongBanThanController {
    final ILuongBanThanService luongBanThanService;
    @GetMapping("/luong-ban-than")
    public ResponseEntity<ResDTO<List<LuongBanThan>>> getAll() {
        List<LuongBanThan> ls = luongBanThanService.xemDanhSach();
        return ResDTO.reply(ls, ResEnum.THANH_CONG);
    }

    @GetMapping("/luong-ban-than/{id}")
    public ResponseEntity<ResDTO<LuongBanThan>> getById(@PathVariable int id) {
        LuongBanThan ls = luongBanThanService.xemChiTiet(id);
        return ResDTO.reply(ls, ResEnum.THANH_CONG);
    }

    @PostMapping("/luong-ban-than/{id}")
    @Transactional
    public ResponseEntity<ResDTO<LuongBanThan>> add(@PathVariable UUID id, @RequestBody ReqLuongBanThan cu) {
        LuongBanThan ls = luongBanThanService.them(id, cu);
        return ResDTO.reply(ls, ResEnum.TAO_THANH_CONG);
    }

    @PatchMapping("/luong-ban-than/{id}")
    public ResponseEntity<ResDTO<LuongBanThan>> edit(@PathVariable int id, @RequestBody ReqLuongBanThan cu) {
        LuongBanThan ls = luongBanThanService.sua(id, cu);
        return ResDTO.reply(ls, ResEnum.CAP_NHAT_THANH_CONG);
    }

    @DeleteMapping("/luong-ban-than/{id}")
    public ResponseEntity<ResDTO<Boolean>> del(@PathVariable int id) {
        boolean ls = luongBanThanService.xoa(id);
        return ResDTO.reply(ls, ResEnum.XOA_THANH_CONG);
    }
}
