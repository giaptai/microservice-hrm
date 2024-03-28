package com.hrm.taikhoan.controller;

import com.hrm.taikhoan.dto.client.ly_luan_chinh_tri.LyLuanChinhTri;
import com.hrm.taikhoan.dto.client.ly_luan_chinh_tri.ReqLyLuanChinhTri;
import com.hrm.taikhoan.response.ResDTO;
import com.hrm.taikhoan.response.ResEnum;
import com.hrm.taikhoan.service.ly_luan_chinh_tri.ILyLuanChinhTriService;
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
public class LyLuanChinhTriController {
    final ILyLuanChinhTriService lyLuanChinhTriService;

    @GetMapping("/ly-luan-chinh-tri")
    public ResponseEntity<ResDTO<List<LyLuanChinhTri>>> getAll() {
        List<LyLuanChinhTri> ls = lyLuanChinhTriService.xemDanhSach();
        return ResDTO.reply(ls, ResEnum.THANH_CONG);
    }

    @GetMapping("/ly-luan-chinh-tri/{id}")
    public ResponseEntity<ResDTO<LyLuanChinhTri>> getById(@PathVariable int id) {
        LyLuanChinhTri ls = lyLuanChinhTriService.xemChiTiet(id);
        return ResDTO.reply(ls, ResEnum.THANH_CONG);
    }

    @PostMapping("/ly-luan-chinh-tri/{id}")
    @Transactional
    public ResponseEntity<ResDTO<LyLuanChinhTri>> add(@PathVariable UUID id, @RequestBody ReqLyLuanChinhTri cu) {
        LyLuanChinhTri ls = lyLuanChinhTriService.them(id, cu);
        return ResDTO.reply(ls, ResEnum.TAO_THANH_CONG);
    }

    @PatchMapping("/ly-luan-chinh-tri/{id}")
    public ResponseEntity<ResDTO<LyLuanChinhTri>> edit(@PathVariable int id, @RequestBody ReqLyLuanChinhTri cu) {
        LyLuanChinhTri ls = lyLuanChinhTriService.sua(id, cu);
        return ResDTO.reply(ls, ResEnum.CAP_NHAT_THANH_CONG);
    }

    @DeleteMapping("/ly-luan-chinh-tri/{id}")
    public ResponseEntity<ResDTO<Boolean>> del(@PathVariable int id) {
        boolean ls = lyLuanChinhTriService.xoa(id);
        return ResDTO.reply(ls, ResEnum.XOA_THANH_CONG);
    }
}
