package com.hrm.hoso_chitiet.controllers;

import com.hrm.hoso_chitiet.dto.mapper.MapperNgoaiNgu;
import com.hrm.hoso_chitiet.dto.request.ReqNgoaiNgu;
import com.hrm.hoso_chitiet.dto.response.ResNgoaiNgu;
import com.hrm.hoso_chitiet.models.NgoaiNgu;
import com.hrm.hoso_chitiet.response.ResDTO;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "")
@Tag(name = "Ngoại ngữ ")
@SecurityRequirement(name = "Bearer Authentication")
@RequiredArgsConstructor
public class NgoaiNguController {
    private final IHoSoChiTietServices.IHoNgoaiNguServiceChiTiet ngoaiNguService;
    private final MapperNgoaiNgu mapper;

    @GetMapping("/ho-so/{id}/ngoai-ngu")
    public ResponseEntity<List<ResNgoaiNgu>> getAllByHoSoId(@PathVariable UUID id) {
        List<ResNgoaiNgu> ls = ngoaiNguService.xemDanhSachTheoHoSo(id).stream().map(mapper::mapToResNgoaiNgu).toList();
        return new ResponseEntity<>(ls, ResEnum.THANH_CONG.getStatusCode());
    }

    @GetMapping("/ngoai-ngu")
    public ResponseEntity<List<NgoaiNgu>> getAll() {
        List<NgoaiNgu> ls = ngoaiNguService.xemDanhSach();
        return new ResponseEntity<>(ls, ResEnum.THANH_CONG.getStatusCode());
    }

    @GetMapping("/ngoai-ngu/{id}")
    public ResponseEntity<NgoaiNgu> getById(@PathVariable int id) {
        NgoaiNgu ls = ngoaiNguService.xemChiTiet(id);
        return new ResponseEntity<>(ls, ResEnum.THANH_CONG.getStatusCode());
    }

    @PostMapping("/ngoai-ngu/{id}")
    @Transactional
    public ResponseEntity<NgoaiNgu> add(@PathVariable UUID id, @RequestBody ReqNgoaiNgu cu) {
        NgoaiNgu ls = ngoaiNguService.them(id, cu);
        return new ResponseEntity<>(ls, ResEnum.TAO_THANH_CONG.getStatusCode());
    }

    @PatchMapping("/ngoai-ngu/{id}")
    public ResponseEntity<NgoaiNgu> edit(@PathVariable int id, @RequestBody ReqNgoaiNgu cu) {
        NgoaiNgu ls = ngoaiNguService.sua(id, cu);
        return new ResponseEntity<>(ls, ResEnum.CAP_NHAT_THANH_CONG.getStatusCode());
    }

    @DeleteMapping("/ngoai-ngu/{id}")
    public ResponseEntity<Boolean> del(@PathVariable int id) {
        boolean ls = ngoaiNguService.xoa(id);
        return new ResponseEntity<>(ls, ResEnum.XOA_THANH_CONG.getStatusCode());
    }
}
