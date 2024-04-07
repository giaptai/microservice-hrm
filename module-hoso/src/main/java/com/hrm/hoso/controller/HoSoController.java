package com.hrm.hoso.controller;

import com.hrm.hoso.dto.request.ReqTaoHoSo;
import com.hrm.hoso.dto.request.ReqHoSo;
import com.hrm.hoso.dto.response.ResHoSo;
import com.hrm.hoso.response.ResEnum;
import com.hrm.hoso.services.IHoSoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
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
@RequiredArgsConstructor
public class HoSoController {
    private final IHoSoService hoSoService;

    //CLIENT
    @GetMapping(path = "/ho-so-id")
    public ResponseEntity<UUID> getHoSoId(@RequestHeader(name = "taiKhoanId") int id) {
        return new ResponseEntity<>(hoSoService.layHoSoId(id), ResEnum.THANH_CONG.getStatusCode());
    }

    //ADMIN - ADMIN - ADMIN
    @GetMapping("/nhan-vien/ho-so")
    public ResponseEntity<List<ResHoSo>> getAllHoSo() {
        List<ResHoSo> resHoSos = hoSoService.xemDanhSachHoSo();
        return new ResponseEntity<>(resHoSos, ResEnum.THANH_CONG.getStatusCode());
    }

    @GetMapping("/nhan-vien/ho-so/{id}")
    public ResponseEntity<ResHoSo> getHoSoById0(@PathVariable(name = "id") UUID id) {
        ResHoSo hoSo = hoSoService.xemHoSoTheoId(id);
        return new ResponseEntity<>(hoSo, ResEnum.THANH_CONG.getStatusCode());
    }

    @PostMapping("/nhan-vien/ho-so")
    @Transactional
    public ResponseEntity<ResHoSo> addHoSo(@RequestBody ReqTaoHoSo req) {
        ResHoSo hoSo = hoSoService.taoHoSo(req);
        return new ResponseEntity<>(hoSo, ResEnum.TAO_HO_SO_THANH_CONG.getStatusCode());
    }

    @PatchMapping("/nhan-vien/ho-so/{id}")
    @Transactional
    public ResponseEntity<ResHoSo> editHoSo(@PathVariable(name = "id", required = false) UUID id,
                                            @RequestBody ReqHoSo reqHoSo) {
        ResHoSo resHoSo = hoSoService.capNhatHoSoCCVC(id, reqHoSo);
        return new ResponseEntity<>(resHoSo, ResEnum.CAP_NHAT_HO_SO_THANH_CONG.getStatusCode());
    }

    @GetMapping("/nhan-vien/ho-so/tim-kiem")
    public ResponseEntity<ResHoSo> findHoSoBySoCCCDO(@RequestParam(name = "q") String q) {
        ResHoSo hoSo = hoSoService.xemHoSoTheoSoCCCD(q);
        return new ResponseEntity<>(hoSo, ResEnum.THANH_CONG.getStatusCode());
    }

    //EMPLOYEE --- EMPLOYEE --- EMPLOYEE
    @GetMapping("/ca-nhan/ho-so")
    public ResponseEntity<ResHoSo> getHoSoCaNhan(@RequestHeader(name = "taiKhoanId") int id) {
        ResHoSo hoSo = hoSoService.xemHoSoCaNhan(id);
        return new ResponseEntity<>(hoSo, ResEnum.THANH_CONG.getStatusCode());
    }

    @PatchMapping("/ca-nhan/ho-so")
    public ResponseEntity<ResHoSo> editHoSoCaNhan(@RequestHeader(name = "taiKhoanId") int id, @RequestBody ReqHoSo reqHoSo) {
        ResHoSo resHoSo = hoSoService.capNhatHoSoCaNhan(id, reqHoSo);
        return new ResponseEntity<>(resHoSo, ResEnum.THANH_CONG.getStatusCode());
    }
}
