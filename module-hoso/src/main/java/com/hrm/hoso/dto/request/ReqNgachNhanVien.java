package com.hrm.hoso.dto.request;

import java.time.LocalDateTime;

public record ReqNgachNhanVien(
        String ngachId, //NgachCongChuc ngachCongChuc;  NgachVienChuc ngachVienChuc;
        LocalDateTime ngayBoNhiemNgach,
        LocalDateTime ngayHuongLuongNgach,
        float phanTramHuongLuongNgach,
        double phuCapThamNienVuotKhungNgach,
        LocalDateTime ngayHuongPCTNVKNgach
) {
}
