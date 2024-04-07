package com.hrm.hoso.dto.response;

import java.time.LocalDateTime;

public record ResNgachNhanVien(
        String ngachId,
        String ngachName,
        int heSoLuongId,
        int nhomId,
        String nhomName,
        int loaiId,
        String loaiLoai,
        String loaiName,
        int bacLuongId,
        String bacLuongName,
        float heSo,
        LocalDateTime ngayBoNhiemNgach,
        LocalDateTime ngayHuongLuongNgach,
        float phanTramHuongLuongNgach,
        double phuCapThamNienVuotKhungNgach,
        LocalDateTime ngayHuongPCTNVKNgach
) {

}
