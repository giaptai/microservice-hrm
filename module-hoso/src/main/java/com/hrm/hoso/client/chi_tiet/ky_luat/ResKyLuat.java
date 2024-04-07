package com.hrm.hoso.client.chi_tiet.ky_luat;

import java.time.LocalDateTime;
import java.util.UUID;

public record ResKyLuat(
        int id,
        LocalDateTime batDau,
        LocalDateTime ketThuc,
        String hinhThuc,
        String hanhViViPhamChinh,
        int coQuanQuyetDinhId,
        String coQuanQuyetDinhName,
        String xacNhan,
        UUID hoSoId
) {
}
