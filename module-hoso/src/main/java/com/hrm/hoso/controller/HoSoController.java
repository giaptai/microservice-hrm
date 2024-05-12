package com.hrm.hoso.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.hrm.hoso.dto.request.ReqChucVu;
import com.hrm.hoso.dto.request.ReqHoSoTest;
import com.hrm.hoso.dto.request.ReqTaoHoSo;
import com.hrm.hoso.dto.request.ReqHoSo;
import com.hrm.hoso.dto.response.ResChucVu;
import com.hrm.hoso.dto.response.ResHoSo;
import com.hrm.hoso.dto.response.ResHoSoTomTat;
import com.hrm.hoso.dto.response.ResListHoSo;
import com.hrm.hoso.enums.PheDuyet;
import com.hrm.hoso.response.ResEnum;
import com.hrm.hoso.services.IHoSoService;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@SecurityRequirement(name = "Bearer Authentication")
public class HoSoController {
    private final IHoSoService hoSoService;

    //CLIENT
    @GetMapping(path = "/ho-so-id")
    public ResponseEntity<ResHoSoTomTat> getHoSoId(@RequestHeader(name = "taiKhoanId") int id) {
        return new ResponseEntity<>(hoSoService.layHoSoId(id), ResEnum.THANH_CONG.getCode());
    }

//    @GetMapping(path = "/ho-so-tom-tat-id/{id}")
//    public ResponseEntity<ResHoSoTomTat> getHoSoTomTatId(@PathVariable(name = "taiKhoanId") int id) {
//        return new ResponseEntity<>(hoSoService.layHoSoId(id), ResEnum.THANH_CONG.getCode());
//    }

    //ADMIN - ADMIN - ADMIN
    @GetMapping("/nhan-vien/ho-so")
    public ResponseEntity<ResListHoSo> getAllHoSo(
            @RequestParam(name = "soCCCD", required = false) String cccd,
            @RequestParam(name = "hoVaTen", required = false) String hoVaTen,
            @RequestParam(name = "danTocId", required = false, defaultValue = "-1") String danTocId,
            @RequestParam(name = "chucVuHienTaiId", required = false, defaultValue = "-1") String chucVuHienTaiId,
            @RequestParam(name = "coQuanToChucDonViId", required = false, defaultValue = "-1") String coQuanToChucDonViId,
            @RequestParam(name = "pheDuyet", required = false) PheDuyet pheDuyet,
            @RequestParam(name = "sort", required = false, defaultValue = "createAt") String byDate,
            @RequestParam(name = "page", required = false, defaultValue = "0") int pageNumber,
            @RequestParam(name = "size", required = false, defaultValue = "10") int pageSize
    ) {
        ResListHoSo resHoSos = hoSoService.xemDanhSachHoSo(cccd, hoVaTen, Integer.parseInt(danTocId), Integer.parseInt(chucVuHienTaiId), Integer.parseInt(coQuanToChucDonViId), pheDuyet, byDate, pageNumber, pageSize);
        return new ResponseEntity<>(resHoSos, ResEnum.THANH_CONG.getCode());
    }

    @GetMapping("/nhan-vien/ho-so/{id}")
    public ResponseEntity<ResHoSo> getHoSoById0(@PathVariable(name = "id") UUID id) {
        ResHoSo hoSo = hoSoService.xemHoSoTheoId(id);
        return new ResponseEntity<>(hoSo, ResEnum.THANH_CONG.getCode());
    }

    @PostMapping("/nhan-vien/ho-so")
    @Transactional
    public ResponseEntity<ResHoSo> addHoSo(@RequestBody ReqTaoHoSo req) {
        ResHoSo hoSo = hoSoService.taoHoSo(req);
        return new ResponseEntity<>(hoSo, ResEnum.TAO_HO_SO_THANH_CONG.getCode());
    }

    @PatchMapping("/nhan-vien/ho-so/{id}/chuc-vu")
    @Transactional
    public ResponseEntity<ResChucVu> editChucVu(@PathVariable(name = "id") UUID id, @RequestBody ReqChucVu req) {
        ResChucVu chucVu = hoSoService.capNhatChucVuHienTai(id, req);
        return new ResponseEntity<>(chucVu, ResEnum.CAP_NHAT_HO_SO_THANH_CONG.getCode());
    }

    @PatchMapping("/nhan-vien/ho-so/{id}/chuc-vu-api")
    @Transactional
    public ResponseEntity<ResChucVu> editChucVuApi(@PathVariable(name = "id") UUID id, @RequestBody ReqChucVu req) {
        ResChucVu chucVu = hoSoService.capNhatChucVuHienTaiApi(id, req);
        return new ResponseEntity<>(chucVu, ResEnum.CAP_NHAT_HO_SO_THANH_CONG.getCode());
    }

    @PatchMapping(value = "/nhan-vien/ho-so/{id}", consumes = {
            MediaType.APPLICATION_JSON_VALUE,
            MediaType.MULTIPART_FORM_DATA_VALUE
    })
    @Transactional
    public ResponseEntity<ResHoSo> editHoSo(@PathVariable(name = "id", required = false) UUID id,
                                            @RequestPart(required = false) String reqHoSo,
                                            @RequestPart(value = "anh", required = false) @Schema(type = "string", format = "binary") MultipartFile anh) {
        ResHoSo resHoSo = hoSoService.capNhatHoSoCCVC(id, reqHoSo, anh);
        return new ResponseEntity<>(resHoSo, ResEnum.CAP_NHAT_HO_SO_THANH_CONG.getCode());
    }

    @PutMapping(value = "/nhan-vien/ho-so-test", consumes = {
            MediaType.APPLICATION_JSON_VALUE,
            MediaType.MULTIPART_FORM_DATA_VALUE
    })
    public ResponseEntity<String> editHoSoTest(@RequestPart() String reqHoSoTest,
                                               @RequestPart(value = "anh", required = false) @Schema(type = "string", format = "binary") MultipartFile anh
    ) {
//        ReqHoSoTest soTest = new Gson().toJson(reqHoSoTest);
        System.out.println(reqHoSoTest);
        return new ResponseEntity<>("", ResEnum.CAP_NHAT_HO_SO_THANH_CONG.getCode());
    }

//    @GetMapping("/nhan-vien/ho-so/tim-kiem")
//    public ResponseEntity<ResHoSo> findHoSoBySoCCCDO(@RequestParam(name = "q") String q) {
//        ResHoSo hoSo = hoSoService.xemHoSoTheoSoCCCD(q);
//        return new ResponseEntity<>(hoSo, ResEnum.THANH_CONG.getCode());
//    }

//    @GetMapping("/nhan-vien/ho-so/loc")
//    public ResponseEntity<List<ResHoSo>> filterHoSo(
//            @RequestParam(name = "hoVaTen", required = false, defaultValue = "") String hoVaTen,
//            @RequestParam(name = "danTocId", required = false, defaultValue = "-1") String danTocId,
//            @RequestParam(name = "chucVuHienTaiId", required = false, defaultValue = "-1") String chucVuHienTaiId,
//            @RequestParam(name = "coQuanToChucDonViId", required = false, defaultValue = "-1") String coQuanToChucDonViId,
//            @RequestParam(name = "pheDuyet", required = false, defaultValue = "-1") PheDuyet pheDuyet,
//            @RequestParam(name = "page", required = false, defaultValue = "0") int pageNumber,
//            @RequestParam(name = "size", required = false, defaultValue = "10") int pageSize
//    ) {
//        List<ResHoSo> hoSos = hoSoService.locHoSo(hoVaTen, Integer.parseInt(danTocId), Integer.parseInt(chucVuHienTaiId), Integer.parseInt(coQuanToChucDonViId), pheDuyet, pageNumber, pageSize);
//        return new ResponseEntity<>(hoSos, ResEnum.THANH_CONG.getCode());
//    }

    @PatchMapping("/nhan-vien/ho-so/phe-duyet")
    public ResponseEntity<Boolean> approveHoSo(@RequestParam(name = "pheDuyet") PheDuyet pheDuyet, @RequestBody List<ResHoSo> resHoSos) {
        boolean hoSos = hoSoService.pheDuyetHoSo(pheDuyet, resHoSos);
        return new ResponseEntity<>(hoSos, ResEnum.PHE_DUYET_HO_SO_THANH_CONG.getCode());
    }


    //EMPLOYEE --- EMPLOYEE --- EMPLOYEE
    @GetMapping("/ca-nhan/ho-so")
    public ResponseEntity<ResHoSo> getHoSoCaNhan(@RequestHeader(name = "taiKhoanId", required = false) int id) {
        ResHoSo hoSo = hoSoService.xemHoSoCaNhan(id);
        return new ResponseEntity<>(hoSo, ResEnum.THANH_CONG.getCode());
    }

    @PatchMapping("/ca-nhan/ho-so")
    public ResponseEntity<ResHoSo> editHoSoCaNhan(@RequestHeader(name = "taiKhoanId", required = false) int id, @RequestBody ReqHoSo reqHoSo) {
        ResHoSo resHoSo = hoSoService.capNhatHoSoCaNhan(id, reqHoSo);
        return new ResponseEntity<>(resHoSo, ResEnum.CAP_NHAT_HO_SO_THANH_CONG.getCode());
    }
}
