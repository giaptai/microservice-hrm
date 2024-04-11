package com.hrm.hoso_chitiet.controllers;

import com.hrm.hoso_chitiet.dto.mapper.MapperPhuCapKhac;
import com.hrm.hoso_chitiet.dto.request.ReqPhuCapKhac;
import com.hrm.hoso_chitiet.dto.response.ResPhuCapKhac;
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
@Tag(name = "Phụ cấp khác ")
@SecurityRequirement(name = "Bearer Authentication")
@RequiredArgsConstructor
public class PhuCapKhacController {
    private final IHoSoChiTietServices.IHoPhuCapKhacServiceChiTiet phuCapKhacService;
    private final MapperPhuCapKhac mapper;

    @GetMapping("/{id}/phu-cap-khac")
    public ResponseEntity<List<ResPhuCapKhac>> getAllByHoSoId(@PathVariable UUID id,
                                                              @RequestParam(name = "page", required = false, defaultValue = "0") int pageNumber,
                                                              @RequestParam(name = "size", required = false, defaultValue = "10") int pageSize) {
        List<ResPhuCapKhac> ls = phuCapKhacService.xemDanhSachTheoHoSoId(id, pageNumber, pageSize).stream().map(mapper::mapToResPhuCapKhac).toList();
        return new ResponseEntity<>(ls, ResEnum.THANH_CONG.getStatusCode());
    }

    @GetMapping("/phu-cap-khac")
    public ResponseEntity<List<ResPhuCapKhac>> getAll(@RequestParam(name = "page", required = false, defaultValue = "0") int pageNumber,
                                                      @RequestParam(name = "size", required = false, defaultValue = "10") int pageSize) {
        List<ResPhuCapKhac> ls = phuCapKhacService.xemDanhSach(pageNumber, pageSize).stream().map(mapper::mapToResPhuCapKhac).toList();
        return new ResponseEntity<>(ls, ResEnum.THANH_CONG.getStatusCode());
    }

    @GetMapping("/phu-cap-khac/{id}")
    public ResponseEntity<ResPhuCapKhac> getById(@PathVariable int id) {
        ResPhuCapKhac ls = mapper.mapToResPhuCapKhac(phuCapKhacService.xemChiTiet(id));
        return new ResponseEntity<>(ls, ResEnum.THANH_CONG.getStatusCode());
    }

    @PostMapping("/phu-cap-khac/{id}")
    @Transactional
    public ResponseEntity<ResPhuCapKhac> add(@PathVariable UUID id, @RequestBody ReqPhuCapKhac cu) {
        ResPhuCapKhac ls = mapper.mapToResPhuCapKhac(phuCapKhacService.them(id, cu));
        return new ResponseEntity<>(ls, ResEnum.TAO_THANH_CONG.getStatusCode());
    }

    @PatchMapping("/phu-cap-khac/{id}")
    public ResponseEntity<ResPhuCapKhac> edit(@PathVariable int id, @RequestBody ReqPhuCapKhac cu) {
        ResPhuCapKhac ls = mapper.mapToResPhuCapKhac(phuCapKhacService.sua(id, cu));
        return new ResponseEntity<>(ls, ResEnum.CAP_NHAT_THANH_CONG.getStatusCode());
    }

    @DeleteMapping("/phu-cap-khac/{id}")
    public ResponseEntity<Boolean> del(@PathVariable int id) {
        boolean ls = phuCapKhacService.xoa(id);
        return new ResponseEntity<>(ls, ResEnum.XOA_THANH_CONG.getStatusCode());
    }

    //EMPLOYEE
    @GetMapping("/ca-nhan/phu-cap-khac")
    public ResponseEntity<List<ResPhuCapKhac>> getAllCaNhan(@RequestHeader(name = "taiKhoanId", required = false) int id,
                                                            @RequestParam(name = "page", required = false, defaultValue = "0") int pageNumber,
                                                            @RequestParam(name = "size", required = false, defaultValue = "10") int pageSize) {
        List<ResPhuCapKhac> ls = phuCapKhacService.xemDanhSachCaNhan(id, pageNumber, pageSize).stream().map(mapper::mapToResPhuCapKhac).toList();
        return new ResponseEntity<>(ls, ResEnum.THANH_CONG.getStatusCode());
    }

    @PostMapping("/ca-nhan/phu-cap-khac")
    @Transactional
    public ResponseEntity<ResPhuCapKhac> addCaNhan(@RequestHeader(name = "taiKhoanId", required = false) int id, @RequestBody ReqPhuCapKhac cu) {
        ResPhuCapKhac ls = mapper.mapToResPhuCapKhac(phuCapKhacService.themCaNhan(id, cu));
        return new ResponseEntity<>(ls, ResEnum.TAO_THANH_CONG.getStatusCode());
    }

    @PatchMapping("/ca-nhan/phu-cap-khac/{id}")
    public ResponseEntity<ResPhuCapKhac> editCaNhan(@PathVariable int id, @RequestBody ReqPhuCapKhac cu) {
        ResPhuCapKhac ls = mapper.mapToResPhuCapKhac(phuCapKhacService.sua(id, cu));
        return new ResponseEntity<>(ls, ResEnum.CAP_NHAT_THANH_CONG.getStatusCode());
    }

    @DeleteMapping("/ca-nhan/phu-cap-khac/{id}")
    public ResponseEntity<Boolean> delCaNhan(@PathVariable int id) {
        boolean ls = phuCapKhacService.xoa(id);
        return new ResponseEntity<>(ls, ResEnum.XOA_THANH_CONG.getStatusCode());
    }
}
