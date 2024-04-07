package com.hrm.hoso.client.chi_tiet.lam_viec_cho_che_do_cu;

import java.time.LocalDateTime;

public record LamViecChoCheDoCuAuth(
    int id,
    LocalDateTime batDau,
    LocalDateTime ketThuc,
    String chucDanhDonViDiaDiem,
    LocalDateTime create_at,
    LocalDateTime update_at
){}
