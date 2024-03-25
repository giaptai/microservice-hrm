package com.hrm.taikhoan.dto.request;

import java.util.UUID;

public record ReqHoSo(
        UUID uuid,
        String hoVaTen,
        String soCCCD,
        int taiKhoan
) {
}
