package com.hrm.hoso_chitiet.controllers;

import com.hrm.hoso_chitiet.dto.mapper.MapperNgoaiNgu;
import com.hrm.hoso_chitiet.dto.request.ReqNgoaiNgu;
import com.hrm.hoso_chitiet.dto.response.ResNgoaiNgu;
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
@Tag(name = "Ngoại ngữ ")
@SecurityRequirement(name = "Bearer Authentication")
@RequiredArgsConstructor
public class NgoaiNguController {
    private final IHoSoChiTietServices.IHoNgoaiNguServiceChiTiet ngoaiNguService;
    private final MapperNgoaiNgu mapper;

    @GetMapping("/{id}/ngoai-ngu")
    public ResponseEntity<List<ResNgoaiNgu>> getAllByHoSoId(@PathVariable(name = "id") UUID id,
                                                            @RequestParam(name = "page", required = false, defaultValue = "0") int pageNumber,
                                                            @RequestParam(name = "size", required = false, defaultValue = "10") int pageSize) {
        List<ResNgoaiNgu> ls = ngoaiNguService.xemDanhSachTheoHoSoId(id, pageNumber, pageSize).stream().map(mapper::mapToResNgoaiNgu).toList();
        return new ResponseEntity<>(ls, ResEnum.THANH_CONG.getStatusCode());
    }

    @GetMapping("/ngoai-ngu")
    public ResponseEntity<List<ResNgoaiNgu>> getAll(@RequestParam(name = "page", required = false, defaultValue = "0") int pageNumber,
                                                    @RequestParam(name = "size", required = false, defaultValue = "10") int pageSize) {
        List<ResNgoaiNgu> ls = ngoaiNguService.xemDanhSach(pageNumber, pageSize).stream().map(mapper::mapToResNgoaiNgu).toList();
        return new ResponseEntity<>(ls, ResEnum.THANH_CONG.getStatusCode());
    }

    @GetMapping("/ngoai-ngu/{id}")
    public ResponseEntity<ResNgoaiNgu> getById(@PathVariable(name = "id") int id) {
        ResNgoaiNgu ls = mapper.mapToResNgoaiNgu(ngoaiNguService.xemChiTiet(id));
        return new ResponseEntity<>(ls, ResEnum.THANH_CONG.getStatusCode());
    }

    @PostMapping("/ngoai-ngu/{id}")
    @Transactional
    public ResponseEntity<ResNgoaiNgu> add(@PathVariable(name = "id") UUID id, @RequestBody ReqNgoaiNgu cu) {
        ResNgoaiNgu ls = mapper.mapToResNgoaiNgu(ngoaiNguService.them(id, cu));
        return new ResponseEntity<>(ls, ResEnum.TAO_THANH_CONG.getStatusCode());
    }

    @PatchMapping("/ngoai-ngu/{id}")
    public ResponseEntity<ResNgoaiNgu> edit(
            @RequestHeader(name = "role", required = false) String role,
            @PathVariable(name = "id") int id, @RequestBody ReqNgoaiNgu cu) {
        ResNgoaiNgu ls = mapper.mapToResNgoaiNgu(ngoaiNguService.sua(id, cu, role));
        return new ResponseEntity<>(ls, ResEnum.CAP_NHAT_THANH_CONG.getStatusCode());
    }

    @DeleteMapping("/ngoai-ngu/{id}")
    public ResponseEntity<Boolean> del(
            @RequestHeader(name = "role", required = false) String role,
            @PathVariable(name = "id") int id) {
        boolean ls = ngoaiNguService.xoa(id, role);
        return new ResponseEntity<>(ls, ResEnum.XOA_THANH_CONG.getStatusCode());
    }

    //EMPLOYEE
    @GetMapping("/ca-nhan/ngoai-ngu")
    public ResponseEntity<List<ResNgoaiNgu>> getAllCaNhan(@RequestHeader(name = "taiKhoanId", required = false) int id,
                                                          @RequestParam(name = "page", required = false, defaultValue = "0") int pageNumber,
                                                          @RequestParam(name = "size", required = false, defaultValue = "10") int pageSize) {
        List<ResNgoaiNgu> ls = ngoaiNguService.xemDanhSachCaNhan(id, pageNumber, pageSize).stream().map(mapper::mapToResNgoaiNgu).toList();
        return new ResponseEntity<>(ls, ResEnum.THANH_CONG.getStatusCode());
    }

    @PostMapping("/ca-nhan/ngoai-ngu")
    @Transactional
    public ResponseEntity<ResNgoaiNgu> addCaNhan(@RequestHeader(name = "taiKhoanId", required = false) int id, @RequestBody ReqNgoaiNgu cu) {
        ResNgoaiNgu ls = mapper.mapToResNgoaiNgu(ngoaiNguService.themCaNhan(id, cu));
        return new ResponseEntity<>(ls, ResEnum.TAO_THANH_CONG.getStatusCode());
    }

    @PatchMapping("/ca-nhan/ngoai-ngu/{id}")
    public ResponseEntity<ResNgoaiNgu> editCaNhan(
            @RequestHeader(name = "role", required = false) String role,
            @PathVariable(name = "id") int id, @RequestBody ReqNgoaiNgu cu) {
        ResNgoaiNgu ls = mapper.mapToResNgoaiNgu(ngoaiNguService.sua(id, cu, role));
        return new ResponseEntity<>(ls, ResEnum.CAP_NHAT_THANH_CONG.getStatusCode());
    }

    @DeleteMapping("/ca-nhan/ngoai-ngu/{id}")
    public ResponseEntity<Boolean> delCaNhan(
            @RequestHeader(name = "role", required = false) String role,
            @PathVariable(name = "id") int id) {
        boolean ls = ngoaiNguService.xoa(id, role);
        return new ResponseEntity<>(ls, ResEnum.XOA_THANH_CONG.getStatusCode());
    }
}
