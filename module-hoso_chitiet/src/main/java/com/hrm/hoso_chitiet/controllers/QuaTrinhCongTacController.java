package com.hrm.hoso_chitiet.controllers;

import com.hrm.hoso_chitiet.dto.mapper.MapperQuaTrinhCongTac;
import com.hrm.hoso_chitiet.dto.request.ReqQuaTrinhCongTac;
import com.hrm.hoso_chitiet.dto.response.ResQuaTrinhCongTac;
import com.hrm.hoso_chitiet.enums.XacNhan;
import com.hrm.hoso_chitiet.response.ResEnum;
import com.hrm.hoso_chitiet.services.IHoSoChiTietServices;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@Tag(name = "Quá trình công tác ")
@SecurityRequirement(name = "Bearer Authentication")
@RequiredArgsConstructor
public class QuaTrinhCongTacController {
    private final IHoSoChiTietServices.IHoQuaTrinhCongTacServiceChiTiet quaTrinhCongTacService;
    private final MapperQuaTrinhCongTac mapper;

    @GetMapping("/{id}/qua-trinh-cong-tac")
    public ResponseEntity<List<ResQuaTrinhCongTac>> getAllByHoSoId(@PathVariable(name = "id") UUID id,
                                                                   @RequestParam(name = "pheDuyet", required = false) XacNhan xacNhan,
                                                                   @RequestParam(name = "sort", required = false, defaultValue = "createAt") String byDate,
                                                                   @RequestParam(name = "page", required = false, defaultValue = "0") int pageNumber,
                                                                   @RequestParam(name = "size", required = false, defaultValue = "10") int pageSize) {
        List<ResQuaTrinhCongTac> ls = quaTrinhCongTacService.xemDanhSachTheoHoSoId(id, xacNhan, byDate,pageNumber, pageSize).stream().map(mapper::mapToResQuaTrinhCongTac).toList();
        return new ResponseEntity<>(ls, ResEnum.THANH_CONG.getStatusCode());
    }

    @GetMapping("/qua-trinh-cong-tac")
    public ResponseEntity<List<ResQuaTrinhCongTac>> getAll(
            @RequestParam(name = "pheDuyet", required = false) XacNhan xacNhan,
            @RequestParam(name = "sort", required = false, defaultValue = "createAt") String byDate,
            @RequestParam(name = "page", required = false, defaultValue = "0") int pageNumber,
            @RequestParam(name = "size", required = false, defaultValue = "10") int pageSize) {
        List<ResQuaTrinhCongTac> ls = quaTrinhCongTacService.xemDanhSach(xacNhan, byDate,pageNumber, pageSize).stream().map(mapper::mapToResQuaTrinhCongTac).toList();
        return new ResponseEntity<>(ls, ResEnum.THANH_CONG.getStatusCode());
    }

    @GetMapping("/qua-trinh-cong-tac/{id}")
    public ResponseEntity<ResQuaTrinhCongTac> getById(@PathVariable(name = "id") int id) {
        ResQuaTrinhCongTac ls = mapper.mapToResQuaTrinhCongTac(quaTrinhCongTacService.xemChiTiet(id));
        return new ResponseEntity<>(ls, ResEnum.THANH_CONG.getStatusCode());
    }

    @PostMapping("/qua-trinh-cong-tac/{id}")
    @Transactional
    public ResponseEntity<ResQuaTrinhCongTac> add(@PathVariable(name = "id") UUID id, @RequestBody ReqQuaTrinhCongTac cu) {
        ResQuaTrinhCongTac ls = mapper.mapToResQuaTrinhCongTac(quaTrinhCongTacService.them(id, cu));
        return new ResponseEntity<>(ls, ResEnum.TAO_THANH_CONG.getStatusCode());
    }

    @PatchMapping("/qua-trinh-cong-tac/{id}")
    public ResponseEntity<ResQuaTrinhCongTac> edit(
            @RequestHeader(name = "role", required = false) String role,
            @PathVariable(name = "id") int id, @RequestBody ReqQuaTrinhCongTac cu) {
        ResQuaTrinhCongTac ls = mapper.mapToResQuaTrinhCongTac(quaTrinhCongTacService.sua(id, cu, role));
        return new ResponseEntity<>(ls, ResEnum.CAP_NHAT_THANH_CONG.getStatusCode());
    }

    @DeleteMapping("/qua-trinh-cong-tac/{id}")
    public ResponseEntity<Boolean> del(
            @RequestHeader(name = "role", required = false) String role,
            @PathVariable(name = "id") int id) {
        boolean ls = quaTrinhCongTacService.xoa(id, role);
        return new ResponseEntity<>(ls, ResEnum.XOA_THANH_CONG.getStatusCode());
    }

    @PatchMapping("/qua-trinh-cong-tac/phe-duyet")
    public ResponseEntity<Boolean> approve(
            @RequestHeader(name = "role", required = false) String role,
            @RequestParam(name = "pheDuyet") XacNhan xacNhan,
            @RequestBody List<ResQuaTrinhCongTac> res
    ) {
        boolean ls = quaTrinhCongTacService.xacNhan(xacNhan, res);
        return new ResponseEntity<>(ls, ResEnum.CAP_NHAT_THANH_CONG.getStatusCode());
    }

    //EMPLOYEE
    @GetMapping("/ca-nhan/qua-trinh-cong-tac")
    public ResponseEntity<List<ResQuaTrinhCongTac>> getAllCaNhan(@RequestHeader(name = "taiKhoanId", required = false) int id,
                                                                 @RequestParam(name = "pheDuyet", required = false) XacNhan xacNhan,
                                                                 @RequestParam(name = "sort", required = false, defaultValue = "createAt") String byDate,
                                                                 @RequestParam(name = "page", required = false, defaultValue = "0") int pageNumber,
                                                                 @RequestParam(name = "size", required = false, defaultValue = "10") int pageSize) {
        List<ResQuaTrinhCongTac> ls = quaTrinhCongTacService.xemDanhSachCaNhan(id, xacNhan, byDate,pageNumber, pageSize).stream().map(mapper::mapToResQuaTrinhCongTac).toList();
        return new ResponseEntity<>(ls, ResEnum.THANH_CONG.getStatusCode());
    }

    @GetMapping("/ca-nhan/qua-trinh-cong-tac/{id}")
    public ResponseEntity<ResQuaTrinhCongTac> getByIdCaNhan(@PathVariable(name = "id") int id) {
        ResQuaTrinhCongTac ls = mapper.mapToResQuaTrinhCongTac(quaTrinhCongTacService.xemChiTiet(id));
        return new ResponseEntity<>(ls, ResEnum.THANH_CONG.getStatusCode());
    }
    @PostMapping("/ca-nhan/qua-trinh-cong-tac")
    @Transactional
    public ResponseEntity<ResQuaTrinhCongTac> addCaNhan(@RequestHeader(name = "taiKhoanId", required = false) int id, @RequestBody ReqQuaTrinhCongTac cu) {
        ResQuaTrinhCongTac ls = mapper.mapToResQuaTrinhCongTac(quaTrinhCongTacService.themCaNhan(id, cu));
        return new ResponseEntity<>(ls, ResEnum.TAO_THANH_CONG.getStatusCode());
    }

    @PatchMapping("/ca-nhan/qua-trinh-cong-tac/{id}")
    public ResponseEntity<ResQuaTrinhCongTac> editCaNhan(
            @RequestHeader(name = "role", required = false) String role,
            @PathVariable(name = "id") int id, @RequestBody ReqQuaTrinhCongTac cu) {
        ResQuaTrinhCongTac ls = mapper.mapToResQuaTrinhCongTac(quaTrinhCongTacService.sua(id, cu, role));
        return new ResponseEntity<>(ls, ResEnum.CAP_NHAT_THANH_CONG.getStatusCode());
    }

    @DeleteMapping("/ca-nhan/qua-trinh-cong-tac/{id}")
    public ResponseEntity<Boolean> delCaNhan(
            @RequestHeader(name = "role", required = false) String role,
            @PathVariable(name = "id") int id) {
        boolean ls = quaTrinhCongTacService.xoa(id, role);
        return new ResponseEntity<>(ls, ResEnum.XOA_THANH_CONG.getStatusCode());
    }
}
