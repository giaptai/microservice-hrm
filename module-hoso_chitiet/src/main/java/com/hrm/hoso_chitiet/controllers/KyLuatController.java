package com.hrm.hoso_chitiet.controllers;

import com.hrm.hoso_chitiet.dto.request.ReqKyLuat;
import com.hrm.hoso_chitiet.dto.response.ResKyLuat;
import com.hrm.hoso_chitiet.dto.response.ResTheDTO;
import com.hrm.hoso_chitiet.enums.XacNhan;
import com.hrm.hoso_chitiet.kafka.KafkaProducerService;
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
@Tag(name = "Kỷ luật")
@SecurityRequirement(name = "Bearer Authentication")
@RequiredArgsConstructor // create constructor if field set final or @not null
public class KyLuatController {
    private final IHoSoChiTietServices.IHoKyLuatServiceChiTiet kyLuatService;
    private final KafkaProducerService kafkaProducerService;

//    @GetMapping("/ky-luat/stream-kafka")
//    public ResponseEntity<String> getkafka() {
//        kafkaProducerService.toKyLuat();
//        return new ResponseEntity<>("ls", ResEnum.THANH_CONG.getStatusCode());
//    }

    @GetMapping("/{id}/ky-luat")
    public ResponseEntity<ResTheDTO<ResKyLuat>> getAllByHoSoId(
            @PathVariable(name = "id") UUID id,
            @RequestParam(name = "pheDuyet", required = false) XacNhan xacNhan,
            @RequestParam(name = "sort", required = false, defaultValue = "createAt") String byDate,
            @RequestParam(name = "page", required = false, defaultValue = "0") int pageNumber,
            @RequestParam(name = "size", required = false, defaultValue = "10") int pageSize) {
        ResTheDTO<ResKyLuat> ls = kyLuatService.xemDanhSachTheoHoSoId(id, xacNhan, byDate, pageNumber, pageSize);
        return new ResponseEntity<>(ls, ResEnum.THANH_CONG.getStatusCode());
    }

    @GetMapping("/ky-luat")
    public ResponseEntity<ResTheDTO<ResKyLuat>> getAll(
            @RequestParam(name = "pheDuyet", required = false) XacNhan xacNhan,
            @RequestParam(name = "sort", required = false, defaultValue = "createAt") String byDate,
            @RequestParam(name = "page", required = false, defaultValue = "0") int pageNumber,
            @RequestParam(name = "size", required = false, defaultValue = "10") int pageSize
    ) {
        ResTheDTO<ResKyLuat> ls = kyLuatService.xemDanhSach(xacNhan, byDate, pageNumber, pageSize);
        return new ResponseEntity<>(ls, ResEnum.THANH_CONG.getStatusCode());
    }

    @GetMapping("/ky-luat/{id}")
    public ResponseEntity<ResKyLuat> getById(@PathVariable(name = "id") int id) {
        ResKyLuat ls = kyLuatService.xemChiTiet(id);
        return new ResponseEntity<>(ls, ResEnum.THANH_CONG.getStatusCode());
    }

    @PostMapping("/ky-luat/{id}")
    @Transactional
    public ResponseEntity<ResKyLuat> add(@PathVariable(name = "id") UUID id, @RequestBody ReqKyLuat cu) {
        ResKyLuat ls = kyLuatService.them(id, cu);
        return new ResponseEntity<>(ls, ResEnum.TAO_THANH_CONG.getStatusCode());
    }

    @PostMapping("/ky-luat/api-thuan/{id}")
    @Transactional
    public ResponseEntity<ResKyLuat> addApi(@PathVariable(name = "id") UUID id, @RequestBody ReqKyLuat cu) {
        ResKyLuat ls = kyLuatService.themApi(id, cu);
        return new ResponseEntity<>(ls, ResEnum.TAO_THANH_CONG.getStatusCode());
    }

    @PatchMapping("/ky-luat/{id}")
    public ResponseEntity<ResKyLuat> edit(
            @RequestHeader(name = "role", required = false) String role,
            @PathVariable(name = "id") int id, @RequestBody ReqKyLuat cu) {
        ResKyLuat ls = kyLuatService.sua(id, cu, role);
        return new ResponseEntity<>(ls, ResEnum.CAP_NHAT_THANH_CONG.getStatusCode());
    }

    @DeleteMapping("/ky-luat/{id}")
    public ResponseEntity<Boolean> del(
            @RequestHeader(name = "role", required = false) String role,
            @PathVariable(name = "id") int id) {
        boolean ls = kyLuatService.xoa(id, role);
        return new ResponseEntity<>(ls, ResEnum.XOA_THANH_CONG.getStatusCode());
    }

    @PatchMapping("/ky-luat/phe-duyet")
    public ResponseEntity<Boolean> approve(
            @RequestHeader(name = "role", required = false) String role,
            @RequestParam(name = "pheDuyet") XacNhan xacNhan,
            @RequestBody List<ResKyLuat> res
    ) {
        boolean ls = kyLuatService.xacNhan(xacNhan, res);
        return new ResponseEntity<>(ls, ResEnum.CAP_NHAT_THANH_CONG.getStatusCode());
    }

    //EMPLOYEE
    @GetMapping("/ca-nhan/ky-luat")
    public ResponseEntity<ResTheDTO<ResKyLuat>> getAllCaNhan(
            @RequestHeader(name = "taiKhoanId", required = false) int id,
            @RequestParam(name = "pheDuyet", required = false) XacNhan xacNhan,
            @RequestParam(name = "sort", required = false, defaultValue = "createAt") String byDate,
            @RequestParam(name = "page", required = false, defaultValue = "0") int pageNumber,
            @RequestParam(name = "size", required = false, defaultValue = "10") int pageSize) {
        ResTheDTO<ResKyLuat> ls = kyLuatService.xemDanhSachCaNhan(id, xacNhan, byDate, pageNumber, pageSize);
        return new ResponseEntity<>(ls, ResEnum.THANH_CONG.getStatusCode());
    }

    @GetMapping("/ca-nhan/ky-luat/{id}")
    public ResponseEntity<ResKyLuat> getByIdCaNhan(@PathVariable(name = "id") int id) {
        ResKyLuat ls = kyLuatService.xemChiTiet(id);
        return new ResponseEntity<>(ls, ResEnum.THANH_CONG.getStatusCode());
    }

    @PostMapping("/ca-nhan/ky-luat")
    @Transactional
    public ResponseEntity<ResKyLuat> addCaNhan(@RequestHeader(name = "taiKhoanId", required = false) int id, @RequestBody ReqKyLuat cu) {
        ResKyLuat ls = kyLuatService.themCaNhan(id, cu);
        return new ResponseEntity<>(ls, ResEnum.TAO_THANH_CONG.getStatusCode());
    }

    @PatchMapping("/ca-nhan/ky-luat/{id}")
    public ResponseEntity<ResKyLuat> editCaNhan(
            @RequestHeader(name = "role", required = false) String role,
            @PathVariable(name = "id") int id, @RequestBody ReqKyLuat cu) {
        ResKyLuat ls = kyLuatService.sua(id, cu, role);
        return new ResponseEntity<>(ls, ResEnum.CAP_NHAT_THANH_CONG.getStatusCode());
    }

    @DeleteMapping("/ca-nhan/ky-luat/{id}")
    public ResponseEntity<Boolean> delCaNhan(
            @RequestHeader(name = "role", required = false) String role,
            @PathVariable(name = "id") int id) {
        boolean ls = kyLuatService.xoa(id, role);
        return new ResponseEntity<>(ls, ResEnum.XOA_THANH_CONG.getStatusCode());
    }
}
