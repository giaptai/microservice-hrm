package com.hrm.taikhoan.client.kien_thuc_an_ninh_quoc_phong;

import com.hrm.taikhoan.enums.XacNhan;

import java.time.LocalDateTime;

public record KienThucAnNinhQuocPhongDTO(
        int id,
        LocalDateTime batDau,
        LocalDateTime ketThuc,
        int tenCoSoDaoTaoId,
        String chungChiDuocCap,
        XacNhan xacNhan,
        LocalDateTime create_at,
        LocalDateTime update_at
){}
