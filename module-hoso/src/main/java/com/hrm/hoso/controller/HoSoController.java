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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "")
@RequiredArgsConstructor
public class HoSoController {
    private final IHoSoService hoSoService;

    @GetMapping("/ho-so")
    public ResponseEntity<List<ResHoSo>> getAllHoSo() {
        List<ResHoSo> resHoSos = hoSoService.xemDanhSachHoSo().stream().map(ResHoSo::mapToResHoSo).toList();
        return new ResponseEntity<>(resHoSos, ResEnum.THANH_CONG.getStatusCode());
    }

    @GetMapping("/ho-so/{id}")
    public ResponseEntity<ResHoSo> getHoSoById0(@PathVariable(name = "id") UUID id) {
        ResHoSo hoSo = ResHoSo.mapToResHoSo(hoSoService.xemHoSoTheoId(id));
        return new ResponseEntity<>(hoSo, ResEnum.THANH_CONG.getStatusCode());
    }
    @PostMapping("/ho-so")
    @Transactional
    public ResponseEntity<ResHoSo> addHoSo(@RequestBody ReqTaoHoSo req) {
        ResHoSo hoSo = ResHoSo.mapToResHoSo(hoSoService.taoHoSo(req));
        return new ResponseEntity<>(hoSo, ResEnum.TAO_HO_SO_THANH_CONG.getStatusCode());
    }
    @PatchMapping("/ho-so/{id}")
    @Transactional
    public ResponseEntity<ResHoSo> editHoSo(@PathVariable(name = "id", required = false) UUID id,
                                                 @RequestBody ReqHoSo reqHoSo) {
        ResHoSo resHoSo = ResHoSo.mapToResHoSo(hoSoService.capNhatHoSoCCVC(id, reqHoSo));
        return new ResponseEntity<>(resHoSo, ResEnum.CAP_NHAT_HO_SO_THANH_CONG.getStatusCode());
    }
    @GetMapping("/ho-so/tim-kiem")
    public ResponseEntity<ResHoSo> getHoSoCCVCBySoCCCDOrId0(@RequestParam(name = "q") String q) {
        ResHoSo hoSo = ResHoSo.mapToResHoSo(hoSoService.xemHoSoTheoSoCCCDHoacID(q));
        return new ResponseEntity<>(hoSo, ResEnum.THANH_CONG.getStatusCode());
    }
    //EMPLOYEE --- EMPLOYEE --- EMPLOYEE
//    @GetMapping("/ca-nhan/ho-so")
//    public ResponseEntity<ResDTO<ResHoSo>> so_yeu_ly_lich() {
//        return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG,
//                ResHoSo.mapToResHoSo(hoSoService.xemHoSoCaNhan())), HttpStatus.OK);
//    }
//
//    @PatchMapping("/ca-nhan/ho-so")
//    public ResponseEntity<ResDTO<ResHoSo>> so_yeu_ly_lich_cap_nhat(@RequestBody ReqSoYeuLyLich reqSoYeuLyLich) {
//        return new ResponseEntity<>(ResDTO.response(ResEnum.THANH_CONG,
//                ResHoSo.mapToResHoSo(hoSoService.capNhatHoSoCaNhan(reqSoYeuLyLich))), HttpStatus.ACCEPTED);
//    }

    //ADMIN --- ADMIN --- ADMIN
//    @GetMapping("/nhan-vien/ho-so")
//    public ResponseEntity<ResDTO<List<ResHoSo>>> getAllHoSoCCVC() {
//        List<ResHoSo> resHoSos = hoSoService.xemDanhSachHoSo().stream().map(ResHoSo::mapToResHoSo).toList();
//        return ResDTO.reply(ResEnum.THANH_CONG, resHoSos);
//    }

//    @GetMapping("/nhan-vien/ho-so/{id}")
//    public ResponseEntity<ResDTO<ResHoSoFullDetails>> getHoSoCCVCById(@PathVariable(name = "id") UUID id) {
//        ResHoSoFullDetails hoSo = hoSoService.xemSoYeuLyLichTheoId(id);
//        return ResDTO.reply(ResEnum.THANH_CONG, hoSo);
//    }

//    @GetMapping("/nhan-vien/ho-so/tim-kiem")
//    public ResponseEntity<ResDTO<ResHoSo>> getHoSoCCVCBySoCCCDOrId(@RequestParam(name = "q") String q) {
//        ResHoSo hoSo = ResHoSo.mapToResHoSo(hoSoService.xemHoSoTheoSoCCCDHoacID(q));
//        return ResDTO.reply(ResEnum.THANH_CONG, hoSo);
//    }

//    @PostMapping("/nhan-vien/ho-so")
//    @Transactional
//    public ResponseEntity<ResDTO<HoSo>> addHoSoCCVC(@RequestBody ReqHoSo req) {
//        HoSo hoSo = hoSoService.taoHoSo(req);
//        return ResDTO.reply(ResEnum.TAO_HO_SO_THANH_CONG, hoSo);
//    }

//    @PatchMapping("/nhan-vien/ho-so/{id}")
//    @Transactional
//    public ResponseEntity<ResDTO<ResHoSo>> editHoSoCCVC(@PathVariable(name = "id", required = false) UUID id,
//                                                        @RequestBody ReqSoYeuLyLich reqSoYeuLyLich) {
//        ResHoSo resHoSo = ResHoSo.mapToResHoSo(hoSoService.capNhatHoSoCCVC(id, reqSoYeuLyLich));
//        return ResDTO.reply(ResEnum.CAP_NHAT_HO_SO_THANH_CONG, resHoSo);
//    }

//    @PatchMapping("/nhan-vien/ho-so/phe-duyet")
//    @Transactional
//    public ResponseEntity<ResDTO<List<ResHoSo>>> editHoSoCCVC(@PathVariable(name = "id", required = false) String id,
//                                                              @RequestBody List<ReqDSSoYeuLyLich> reqDSSoYeuLyLich) {
//        List<ResHoSo> resHoSos = hoSoService.pheDuyetSoYeuLyLich(reqDSSoYeuLyLich).stream().map(ResHoSo::mapToResHoSo).toList();
//        return ResDTO.reply(ResEnum.PHE_DUYET_HO_SO_THANH_CONG, resHoSos);
//    }
}
