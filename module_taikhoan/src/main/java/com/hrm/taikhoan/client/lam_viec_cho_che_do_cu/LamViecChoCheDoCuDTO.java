package com.hrm.taikhoan.client.lam_viec_cho_che_do_cu;

import java.time.LocalDateTime;

public record LamViecChoCheDoCuDTO(
    int id,
    LocalDateTime batDau,
    LocalDateTime ketThuc,
    String chucDanhDonViDiaDiem,
    LocalDateTime create_at,
    LocalDateTime update_at
){}
