//package com.hrm.taikhoan.controller;
//
//import com.hrm.taikhoan.client.ky_luat.KyLuat;
//import com.hrm.taikhoan.client.ky_luat.KyLuatDTO;
//import com.hrm.taikhoan.client.ky_luat.ReqKyLuat;
//import com.hrm.taikhoan.response.ResDTO;
//import com.hrm.taikhoan.response.ResEnum;
//import com.hrm.taikhoan.service.ky_luat.IKyLuatService;
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
//public class KyLuatController {
//    final IKyLuatService kyLuatService;
//
//    @GetMapping("/ky-luat")
//    public ResponseEntity<ResDTO<List<KyLuat>>> getAll() {
//        List<KyLuat> ls = kyLuatService.xemDanhSach();
//        return ResDTO.reply(ls, ResEnum.THANH_CONG);
//    }
//
//    @GetMapping("/ky-luat/{id}")
//    public ResponseEntity<ResDTO<KyLuat>> getById(@PathVariable int id) {
//        KyLuat ls = kyLuatService.xemChiTiet(id);
//        return ResDTO.reply(ls, ResEnum.THANH_CONG);
//    }
//
//    @PostMapping("/ky-luat/{id}")
//    public ResponseEntity<ResDTO<KyLuat>> add(@PathVariable UUID id, @RequestBody ReqKyLuat req) {
//        KyLuat ls = kyLuatService.them(id, req);
//        return ResDTO.reply(ls, ResEnum.TAO_THANH_CONG);
//    }
//
//    @PatchMapping("/ky-luat/{id}")
//    public ResponseEntity<ResDTO<KyLuat>> edit(@PathVariable int id, @RequestBody ReqKyLuat req) {
//        KyLuat ls = kyLuatService.sua(id, req);
//        return ResDTO.reply(ls, ResEnum.CAP_NHAT_THANH_CONG);
//    }
//
//    @DeleteMapping("/ky-luat/{id}")
//    public ResponseEntity<ResDTO<Boolean>> del(@PathVariable int id) {
//        boolean ls = kyLuatService.xoa(id);
//        return ResDTO.reply(ls, ResEnum.XOA_THANH_CONG);
//    }
//    @GetMapping("/ca-nhan/ky-luat")
//    public ResponseEntity<ResDTO<List<KyLuatDTO>>> CaNhanGetAll() {
//        List<KyLuatDTO> ls = kyLuatService.xemDanhSachCaNhan();
//        return ResDTO.reply(ls, ResEnum.THANH_CONG);
//    }
//    @PostMapping("/ca-nhan/ky-luat")
//    public ResponseEntity<ResDTO<KyLuat>> caNhanAdd(@RequestBody ReqKyLuat req) {
//        KyLuat ls = kyLuatService.themCaNhan(req);
//        return ResDTO.reply(ls, ResEnum.TAO_THANH_CONG);
//    }
//
//    @PatchMapping("/ca-nhan/ky-luat/{id}")
//    public ResponseEntity<ResDTO<KyLuat>> caNhanEdit(@PathVariable int id, @RequestBody ReqKyLuat req) {
//        KyLuat ls = kyLuatService.sua(id, req);
//        return ResDTO.reply(ls, ResEnum.CAP_NHAT_THANH_CONG);
//    }
//
//    @DeleteMapping("/ca-nhan/ky-luat/{id}")
//    public ResponseEntity<ResDTO<Boolean>> caNhanDel(@PathVariable int id) {
//        boolean ls = kyLuatService.xoa(id);
//        return ResDTO.reply(ls, ResEnum.XOA_THANH_CONG);
//    }
//}
