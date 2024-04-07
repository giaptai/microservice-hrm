package com.hrm.hoso_chitiet.dto.response;

import java.time.LocalDateTime;
import java.util.UUID;

public record ResLamViecChoCheDoCu(
        int id,
        LocalDateTime batDau,
        LocalDateTime ketThuc,
        String chucDanhDonViDiaDiem,
        UUID hoSoId,
        LocalDateTime create_at,
        LocalDateTime update_at
) {
}
