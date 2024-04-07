package com.hrm.taikhoan.client.ho_so;

import java.time.LocalDateTime;

public record NgachNhanVienDTO(
        int ngachCongChuc,
        int ngachVienChuc,
        LocalDateTime ngayBoNhiemNgach,
        LocalDateTime ngayHuongLuongNgach,
        float phanTramHuongLuongNgach,
        double phuCapThamNienVuotKhungNgach,
        LocalDateTime ngayHuongPCTNVKNgach
) {
}
