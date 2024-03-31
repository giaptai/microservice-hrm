package com.hrm.hoso_chitiet.controllers;

import com.hrm.hoso_chitiet.dto.mapper.MapperQuaTrinhCongTac;
import com.hrm.hoso_chitiet.dto.request.ReqQuaTrinhCongTac;
import com.hrm.hoso_chitiet.dto.response.ResQuaTrinhCongTac;
import com.hrm.hoso_chitiet.models.QuaTrinhCongTac;
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
@Tag(name = "Quá trình công tác ")
@SecurityRequirement(name = "Bearer Authentication")
@RequiredArgsConstructor
public class QuaTrinhCongTacController {
    private final IHoSoChiTietServices.IHoQuaTrinhCongTacServiceChiTiet quaTrinhCongTacService;
    private final MapperQuaTrinhCongTac mapper;

    @GetMapping("/{id}/qua-trinh-cong-tac")
    public ResponseEntity<List<ResQuaTrinhCongTac>> getAllByHoSoId(@PathVariable UUID id) {
        List<ResQuaTrinhCongTac> ls = quaTrinhCongTacService.xemDanhSachTheoHoSo(id).stream().map(mapper::mapToResQuaTrinhCongTac).toList();
        return new ResponseEntity<>(ls, ResEnum.THANH_CONG.getStatusCode());
    }

    @GetMapping("/qua-trinh-cong-tac")
    public ResponseEntity<List<QuaTrinhCongTac>> getAll() {
        List<QuaTrinhCongTac> ls = quaTrinhCongTacService.xemDanhSach();
        return new ResponseEntity<>(ls, ResEnum.THANH_CONG.getStatusCode());
    }

    @GetMapping("/qua-trinh-cong-tac/{id}")
    public ResponseEntity<QuaTrinhCongTac> getById(@PathVariable int id) {
        QuaTrinhCongTac ls = quaTrinhCongTacService.xemChiTiet(id);
        return new ResponseEntity<>(ls, ResEnum.THANH_CONG.getStatusCode());
    }

    @PostMapping("/qua-trinh-cong-tac/{id}")
    @Transactional
    public ResponseEntity<QuaTrinhCongTac> add(@PathVariable UUID id, @RequestBody ReqQuaTrinhCongTac cu) {
        QuaTrinhCongTac ls = quaTrinhCongTacService.them(id, cu);
        return new ResponseEntity<>(ls, ResEnum.TAO_THANH_CONG.getStatusCode());
    }

    @PatchMapping("/qua-trinh-cong-tac/{id}")
    public ResponseEntity<QuaTrinhCongTac> edit(@PathVariable int id, @RequestBody ReqQuaTrinhCongTac cu) {
        QuaTrinhCongTac ls = quaTrinhCongTacService.sua(id, cu);
        return new ResponseEntity<>(ls, ResEnum.CAP_NHAT_THANH_CONG.getStatusCode());
    }

    @DeleteMapping("/qua-trinh-cong-tac/{id}")
    public ResponseEntity<Boolean> del(@PathVariable int id) {
        boolean ls = quaTrinhCongTacService.xoa(id);
        return new ResponseEntity<>(ls, ResEnum.XOA_THANH_CONG.getStatusCode());
    }
}
