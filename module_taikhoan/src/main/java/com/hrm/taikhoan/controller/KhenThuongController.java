//package com.hrm.taikhoan.controller;
//
//import com.hrm.taikhoan.client.khen_thuong.KhenThuong;
//import com.hrm.taikhoan.client.khen_thuong.KhenThuongDTO;
//import com.hrm.taikhoan.client.khen_thuong.ReqKhenThuong;
//import com.hrm.taikhoan.response.ResDTO;
//import com.hrm.taikhoan.response.ResEnum;
//import com.hrm.taikhoan.service.khen_thuong.IKhenThuongService;
//import io.swagger.v3.oas.annotations.security.SecurityRequirement;
//import lombok.AccessLevel;
//import lombok.RequiredArgsConstructor;
//import lombok.experimental.FieldDefaults;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PatchMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.List;
//import java.util.UUID;
//
//@RestController
//@RequiredArgsConstructor
//@FieldDefaults(level = AccessLevel.PRIVATE)
//@SecurityRequirement(name = "Bearer Authentication")
//public class KhenThuongController {
//    final IKhenThuongService khenThuongService;
//
//    @GetMapping("/khen-thuong")
//    public ResponseEntity<ResDTO<List<KhenThuong>>> getAll() {
//        List<KhenThuong> ls = khenThuongService.xemDanhSach();
//        return ResDTO.reply(ls, ResEnum.THANH_CONG);
//    }
//
//    @GetMapping("/khen-thuong/{id}")
//    public ResponseEntity<ResDTO<KhenThuong>> getById(@PathVariable int id) {
//        KhenThuong ls = khenThuongService.xemChiTiet(id);
//        return ResDTO.reply(ls, ResEnum.THANH_CONG);
//    }
//
//    @PostMapping("/khen-thuong/{id}")
//    public ResponseEntity<ResDTO<KhenThuong>> add(@PathVariable UUID id, @RequestBody ReqKhenThuong req) {
//        KhenThuong ls = khenThuongService.them(id, req);
//        return ResDTO.reply(ls, ResEnum.TAO_THANH_CONG);
//    }
//
//    @PatchMapping("/khen-thuong/{id}")
//    public ResponseEntity<ResDTO<KhenThuong>> edit(@PathVariable int id, @RequestBody ReqKhenThuong req) {
//        KhenThuong ls = khenThuongService.sua(id, req);
//        return ResDTO.reply(ls, ResEnum.CAP_NHAT_THANH_CONG);
//    }
//
//    @DeleteMapping("/khen-thuong/{id}")
//    public ResponseEntity<ResDTO<Boolean>> del(@PathVariable int id) {
//        boolean ls = khenThuongService.xoa(id);
//        return ResDTO.reply(ls, ResEnum.XOA_THANH_CONG);
//    }
//    @GetMapping("/ca-nhan/khen-thuong")
//    public ResponseEntity<ResDTO<List<KhenThuongDTO>>> CaNhanGetAll() {
//        List<KhenThuongDTO> ls = khenThuongService.xemDanhSachCaNhan();
//        return ResDTO.reply(ls, ResEnum.THANH_CONG);
//    }
//    @PostMapping("/ca-nhan/khen-thuong")
//    public ResponseEntity<ResDTO<KhenThuong>> caNhanAdd(@RequestBody ReqKhenThuong req) {
//        KhenThuong ls = khenThuongService.themCaNhan(req);
//        return ResDTO.reply(ls, ResEnum.TAO_THANH_CONG);
//    }
//
//    @PatchMapping("/ca-nhan/khen-thuong/{id}")
//    public ResponseEntity<ResDTO<KhenThuong>> caNhanEdit(@PathVariable int id, @RequestBody ReqKhenThuong req) {
//        KhenThuong ls = khenThuongService.sua(id, req);
//        return ResDTO.reply(ls, ResEnum.CAP_NHAT_THANH_CONG);
//    }
//
//    @DeleteMapping("/ca-nhan/khen-thuong/{id}")
//    public ResponseEntity<ResDTO<Boolean>> caNhanDel(@PathVariable int id) {
//        boolean ls = khenThuongService.xoa(id);
//        return ResDTO.reply(ls, ResEnum.XOA_THANH_CONG);
//    }
//}
