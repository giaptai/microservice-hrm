package com.hrm.taikhoan.controller;

import com.hrm.taikhoan.dto.client.ho_so.HoSoChiTietDTO;
import com.hrm.taikhoan.dto.client.ho_so.HoSoDTO;
import com.hrm.taikhoan.dto.client.ho_so.ReqHoSoDTO;
import com.hrm.taikhoan.response.ResDTO;
import com.hrm.taikhoan.response.ResEnum;
import com.hrm.taikhoan.service.ho_so.IHoSoService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@SecurityRequirement(name = "Bearer Authentication")
public class HoSoController {
    final IHoSoService hoSoService;

    @GetMapping("/nhan-vien/ho-so")
    public ResponseEntity<ResDTO<List<HoSoDTO>>> getAllHoSo() {
        return ResDTO.reply(hoSoService.getAllHoSo(), ResEnum.THANH_CONG);
    }

    @GetMapping("/nhan-vien/ho-so/{id}")
    public ResponseEntity<ResDTO<HoSoChiTietDTO>> getById(@PathVariable UUID id) {
        return ResDTO.reply(hoSoService.getByHoSoId(id), ResEnum.THANH_CONG);
    }

    @PatchMapping("/nhan-vien/ho-so/{id}")
    public ResponseEntity<ResDTO<HoSoDTO>> editHoSoById(@PathVariable UUID id, @RequestBody ReqHoSoDTO dto) {
        return ResDTO.reply(hoSoService.editHoSoById(id, dto), ResEnum.CAP_NHAT_THANH_CONG);
    }

    @GetMapping("/ca-nhan/ho-so")
    public ResponseEntity<ResDTO<HoSoChiTietDTO>> caNhan() {
        return ResDTO.reply(hoSoService.hoSoCaNhan(), ResEnum.THANH_CONG);
    }

    @PatchMapping("/ca-nhan/ho-so")
    public ResponseEntity<ResDTO<HoSoDTO>> caNhanEdit(@RequestBody ReqHoSoDTO dto) {
        return ResDTO.reply(hoSoService.editHoSoCaNhan(dto), ResEnum.CAP_NHAT_THANH_CONG);
    }
}
