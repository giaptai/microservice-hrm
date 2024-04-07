package com.hrm.taikhoan.client.lam_viec_cho_che_do_cu;

import java.time.LocalDateTime;
import java.util.UUID;

public record LamViecChoCheDoCu(
        int id,
        LocalDateTime batDau,
        LocalDateTime ketThuc,
        String chucDanhDonViDiaDiem,
        UUID hoSoId,
        LocalDateTime create_at,
        LocalDateTime update_at
) {
}
