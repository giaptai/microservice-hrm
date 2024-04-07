package com.hrm.taikhoan.client.ky_luat;

import com.hrm.taikhoan.enums.XacNhan;

import java.time.LocalDateTime;
import java.util.UUID;

public record KyLuat(
        int id,
        LocalDateTime batDau,
        LocalDateTime ketThuc,
        String hinhThuc,
        String hanhViViPhamChinh,
        int coQuanQuyetDinhId,
        XacNhan xacNhan,
        UUID hoSoId
) {
}
