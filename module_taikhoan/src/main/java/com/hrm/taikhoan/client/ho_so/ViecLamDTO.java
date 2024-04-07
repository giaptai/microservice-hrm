package com.hrm.taikhoan.client.ho_so;

import java.time.LocalDateTime;

public record ViecLamDTO(
        int viTriViecLam,
        LocalDateTime ngayHuongLuongViTriViecLam,
        float phamTramHuongLuong,
        double phuCapThamNienVuotKhung,
        LocalDateTime ngayHuongPCTNVK
) {
}
