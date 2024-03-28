//package com.hrm.hoso_chitiet.controllers;
//
//import com.hrm.hoso_chitiet.dto.response.ResHoSoChiTiet;
//import com.hrm.hoso_chitiet.response.ResEnum;
//import com.hrm.hoso_chitiet.services.HoSoChiTietServices;
//import io.swagger.v3.oas.annotations.security.SecurityRequirement;
//import io.swagger.v3.oas.annotations.tags.Tag;
//import lombok.RequiredArgsConstructor;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.UUID;
//
//@RestController
//@Tag(name = "Hồ sơ chi tiết ")
//@SecurityRequirement(name = "Bearer Authentication")
//@RequiredArgsConstructor // create constructor if field set final or @not null
//public class HoSoChiTietController {
//    private final HoSoChiTietServices hoSoChiTietServices;
//
//
//    //get all list hồ sơ chi tiết from ho so
//    @GetMapping("/ho-so/{id}")
//    public ResponseEntity<ResHoSoChiTiet> getAllByHoSoId(@PathVariable UUID id) {
//        return new ResponseEntity<>(hoSoChiTietServices.getAllByHoSoId(id), ResEnum.THANH_CONG.getStatusCode());
//    }
//}
