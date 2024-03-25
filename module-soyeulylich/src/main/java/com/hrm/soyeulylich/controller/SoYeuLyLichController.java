package com.hrm.soyeulylich.controller;

import com.hrm.soyeulylich.dto.request.ReqDSSoYeuLyLich;
import com.hrm.soyeulylich.dto.request.ReqHoSo;
import com.hrm.soyeulylich.dto.request.ReqSoYeuLyLich;
import com.hrm.soyeulylich.dto.response.ResHoSo;
import com.hrm.soyeulylich.models.HoSo;
import com.hrm.soyeulylich.response.ResDTO;
import com.hrm.soyeulylich.response.ResEnum;
import com.hrm.soyeulylich.services.ISoYeuLyLichService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "")
public class SoYeuLyLichController {
    private final ISoYeuLyLichService soYeuLyLichService;

    public SoYeuLyLichController(ISoYeuLyLichService soYeuLyLichService) {
        this.soYeuLyLichService = soYeuLyLichService;
    }

    //EMPLOYEE --- EMPLOYEE --- EMPLOYEE
    @GetMapping("/ca-nhan/ho-so")
    public ResponseEntity<ResDTO<ResHoSo>> so_yeu_ly_lich() {
        return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG,
                ResHoSo.mapToResHoSo(soYeuLyLichService.xemHoSoCaNhan())), HttpStatus.OK);
    }

    @PatchMapping("/ca-nhan/ho-so")
    public ResponseEntity<ResDTO<ResHoSo>> so_yeu_ly_lich_cap_nhat(@RequestBody ReqSoYeuLyLich reqSoYeuLyLich) {
        return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG,
                ResHoSo.mapToResHoSo(soYeuLyLichService.capNhatHoSoCaNhan(reqSoYeuLyLich))), HttpStatus.ACCEPTED);
    }

    //ADMIN --- ADMIN --- ADMIN
    @GetMapping("/nhan-vien/ho-so")
    public ResponseEntity<ResDTO<List<ResHoSo>>> getAllHoSoCCVC() {
        List<ResHoSo> resHoSos = soYeuLyLichService.xemDanhSachHoSo().stream().map(ResHoSo::mapToResHoSo).toList();
        return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG, resHoSos), HttpStatus.ACCEPTED);
    }

    @GetMapping("/nhan-vien/ho-so/tim-kiem")
    public ResponseEntity<ResDTO<ResHoSo>> getHoSoCCVCBySoCCCDOrId(@RequestParam(name = "q") String q) {
        return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG,
                ResHoSo.mapToResHoSo(soYeuLyLichService.xemSoYeuLyLichTheoSoCCCDHoacID(q))), HttpStatus.OK);
    }

    @GetMapping("/nhan-vien/ho-so/{id}")
    public ResponseEntity<ResDTO<ResHoSo>> getHoSoCCVCById(@PathVariable(name = "id") UUID id) {
        ResHoSo hoSo = ResHoSo.mapToResHoSo(soYeuLyLichService.xemSoYeuLyLichTheoId(id));
        return ResDTO.reply(ResEnum.THANH_CONG, hoSo);
    }

    @PostMapping("/nhan-vien/ho-so")
    @Transactional
    public ResponseEntity<ResDTO<HoSo>> editHoSoCCVC(@RequestBody ReqHoSo req) {
        HoSo hoSo = soYeuLyLichService.taoHoSo(req);
        return ResDTO.reply(ResEnum.TAO_HO_SO_THANH_CONG, hoSo);
    }

    @PatchMapping("/nhan-vien/ho-so/{id}")
    @Transactional
    public ResponseEntity<ResDTO<ResHoSo>> editHoSoCCVC0(@PathVariable(name = "id", required = false) UUID id,
                                                         @RequestBody ReqSoYeuLyLich reqSoYeuLyLich) {
        ResHoSo resHoSo = ResHoSo.mapToResHoSo(soYeuLyLichService.capNhatHoSoCCVC(id, reqSoYeuLyLich));
        return ResDTO.reply(ResEnum.CAP_NHAT_HO_SO_THANH_CONG, resHoSo);
    }

    @PatchMapping("/nhan-vien/ho-so/phe-duyet")
    @Transactional
    public ResponseEntity<ResDTO<List<ResHoSo>>> editHoSoCCVC(@PathVariable(name = "id", required = false) String id,
                                                              @RequestBody List<ReqDSSoYeuLyLich> reqDSSoYeuLyLich) {
        List<ResHoSo> resHoSos = soYeuLyLichService.pheDuyetSoYeuLyLich(reqDSSoYeuLyLich).stream().map(ResHoSo::mapToResHoSo).toList();
        return ResDTO.reply(ResEnum.PHE_DUYET_HO_SO_THANH_CONG, resHoSos);
    }
}
