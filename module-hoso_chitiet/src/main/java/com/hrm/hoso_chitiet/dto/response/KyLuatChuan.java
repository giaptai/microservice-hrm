package com.hrm.hoso_chitiet.dto.response;

import java.time.LocalDateTime;
import java.util.UUID;

public record KyLuatChuan(
        int coquan_tochuc_donvi_id,
        int xac_nhan,
        LocalDateTime bat_dau,
        LocalDateTime ket_thuc,
        UUID ho_so_id,
        String hanh_vi_vi_pham_chinh,
        String hinh_thuc
) {
}
