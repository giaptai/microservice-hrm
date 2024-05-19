//package com.hrm.taikhoan.dto.mapper;
//
//import com.hrm.taikhoan.dto.resopnse.ResAuth;
//import com.hrm.taikhoan.models.TaiKhoan;
//import org.springframework.stereotype.Component;
//
//import java.util.Optional;
//
//@Component
//public class MapperAuth {
//    public ResAuth mapToResAuth(TaiKhoan taiKhoan) {
//        return new ResAuth(
//                taiKhoan.getId(),
//                taiKhoan.getUsername(),
//                taiKhoan.getPassword(),
//                Optional.of(taiKhoan).map(TaiKhoan::getHoSoId).orElse(null),
//                taiKhoan.getRoleTaiKhoan().name()
//        );
//    }
//}
