package com.hrm.hoso.dto.mapper;

import com.hrm.hoso.client.nhom_mau.NhomMauClient;
import com.hrm.hoso.dto.response.ResSucKhoe;
import com.hrm.hoso.models.SucKhoe;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class MapperSucKhoe {
    final NhomMauClient nhomMauClient;

    public ResSucKhoe mapToResSucKhoe(SucKhoe sucKhoe) {
        if (sucKhoe == null) {
            return null;
        }
        String nhomMauName = nhomMauClient.getName(sucKhoe.getNhomMauId());
        return new ResSucKhoe(
                sucKhoe.getTinhTrangSucKhoe(),
                sucKhoe.getChieuCao(),
                sucKhoe.getCanNang(),
                sucKhoe.getNhomMauId(),
                nhomMauName
        );
    }
}
