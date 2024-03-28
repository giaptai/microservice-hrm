package com.hrm.hoso_chitiet.dto.response;

import java.time.LocalDateTime;

public record ResLamViecChoCheDoCu(
        int id,
        LocalDateTime batDau,
        LocalDateTime ketThuc,
        String chucDanhDonViDiaDiem,
        LocalDateTime create_at,
        LocalDateTime update_at
) {
}
