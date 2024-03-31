package com.hrm.taikhoan.controller;

import com.hrm.taikhoan.dto.client.kien_thuc_an_ninh_quoc_phong.KienThucAnNinhQuocPhong;
import com.hrm.taikhoan.dto.client.kien_thuc_an_ninh_quoc_phong.KienThucAnNinhQuocPhongDTO;
import com.hrm.taikhoan.dto.client.kien_thuc_an_ninh_quoc_phong.ReqKienThucAnNinhQuocPhong;
import com.hrm.taikhoan.response.ResDTO;
import com.hrm.taikhoan.response.ResEnum;
import com.hrm.taikhoan.service.kien_thuc_an_ninh_quoc_phong.IKienThucAnNinhQuocPhongService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
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
@SecurityRequirement(name = "Bearer Authentication")
public class KienThucAnNinhQuocPhongController {
    final IKienThucAnNinhQuocPhongService kienThucAnNinhQuocPhongService;
    @GetMapping("/kien-thuc-an-ninh-quoc-phong")
    public ResponseEntity<ResDTO<List<KienThucAnNinhQuocPhong>>> getAll() {
        List<KienThucAnNinhQuocPhong> ls = kienThucAnNinhQuocPhongService.xemDanhSach();
        return ResDTO.reply(ls, ResEnum.THANH_CONG);
    }

    @GetMapping("/kien-thuc-an-ninh-quoc-phong/{id}")
    public ResponseEntity<ResDTO<KienThucAnNinhQuocPhong>> getById(@PathVariable int id) {
        KienThucAnNinhQuocPhong ls = kienThucAnNinhQuocPhongService.xemChiTiet(id);
        return ResDTO.reply(ls, ResEnum.THANH_CONG);
    }

    @PostMapping("/kien-thuc-an-ninh-quoc-phong/{id}")
    public ResponseEntity<ResDTO<KienThucAnNinhQuocPhong>> add(@PathVariable UUID id, @RequestBody ReqKienThucAnNinhQuocPhong req) {
        KienThucAnNinhQuocPhong ls = kienThucAnNinhQuocPhongService.them(id, req);
        return ResDTO.reply(ls, ResEnum.TAO_THANH_CONG);
    }

    @PatchMapping("/kien-thuc-an-ninh-quoc-phong/{id}")
    public ResponseEntity<ResDTO<KienThucAnNinhQuocPhong>> edit(@PathVariable int id, @RequestBody ReqKienThucAnNinhQuocPhong req) {
        KienThucAnNinhQuocPhong ls = kienThucAnNinhQuocPhongService.sua(id, req);
        return ResDTO.reply(ls, ResEnum.CAP_NHAT_THANH_CONG);
    }

    @DeleteMapping("/kien-thuc-an-ninh-quoc-phong/{id}")
    public ResponseEntity<ResDTO<Boolean>> del(@PathVariable int id) {
        boolean ls = kienThucAnNinhQuocPhongService.xoa(id);
        return ResDTO.reply(ls, ResEnum.XOA_THANH_CONG);
    }
    @GetMapping("/ca-nhan/kien-thuc-an-ninh-quoc-phong")
    public ResponseEntity<ResDTO<List<KienThucAnNinhQuocPhongDTO>>> CaNhanGetAll() {
        List<KienThucAnNinhQuocPhongDTO> ls = kienThucAnNinhQuocPhongService.xemDanhSachCaNhan();
        return ResDTO.reply(ls, ResEnum.THANH_CONG);
    }
    @PostMapping("/ca-nhan/kien-thuc-an-ninh-quoc-phong")
    public ResponseEntity<ResDTO<KienThucAnNinhQuocPhong>> caNhanAdd(@RequestBody ReqKienThucAnNinhQuocPhong req) {
        KienThucAnNinhQuocPhong ls = kienThucAnNinhQuocPhongService.themCaNhan(req);
        return ResDTO.reply(ls, ResEnum.TAO_THANH_CONG);
    }

    @PatchMapping("/ca-nhan/kien-thuc-an-ninh-quoc-phong/{id}")
    public ResponseEntity<ResDTO<KienThucAnNinhQuocPhong>> caNhanEdit(@PathVariable int id, @RequestBody ReqKienThucAnNinhQuocPhong req) {
        KienThucAnNinhQuocPhong ls = kienThucAnNinhQuocPhongService.sua(id, req);
        return ResDTO.reply(ls, ResEnum.CAP_NHAT_THANH_CONG);
    }

    @DeleteMapping("/ca-nhan/kien-thuc-an-ninh-quoc-phong/{id}")
    public ResponseEntity<ResDTO<Boolean>> caNhanDel(@PathVariable int id) {
        boolean ls = kienThucAnNinhQuocPhongService.xoa(id);
        return ResDTO.reply(ls, ResEnum.XOA_THANH_CONG);
    }
}
