package com.hrm.taikhoan.dto.mapper;

import com.hrm.taikhoan.dto.resopnse.ResTaiKhoan;
import com.hrm.taikhoan.models.TaiKhoan;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class MapperTaiKhoan {
    public ResTaiKhoan mapToResTaiKhoan(TaiKhoan taiKhoan) {
        return new ResTaiKhoan(
                taiKhoan.getId(),
                taiKhoan.getHoVaTen(),
                taiKhoan.getUsername(),
                taiKhoan.getEmail(),
                Optional.of(taiKhoan).map(TaiKhoan::getHoSoId).orElse(null),
                taiKhoan.getRoleTaiKhoan().name(),
                taiKhoan.isTrangThai(),
                taiKhoan.getCreateAt(),
                taiKhoan.getUpdateAt()
        );
    }
}
