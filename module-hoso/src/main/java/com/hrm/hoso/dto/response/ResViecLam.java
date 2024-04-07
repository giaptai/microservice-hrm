package com.hrm.hoso.dto.response;

import java.time.LocalDateTime;

public record ResViecLam (
        int viTriViecLamId,
        String viTriViecLamName,
        int bacLuongId,
        String bacLuongName,
        double tienLuong,
        LocalDateTime ngayHuongLuongViTriViecLam,
        float phamTramHuongLuong,
        double phuCapThamNienVuotKhung,
        LocalDateTime ngayHuongPCTNVK
){
}
