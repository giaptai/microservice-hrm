package com.hrm.hoso_chitiet.dto.request;

import java.util.Set;
import java.util.UUID;

public record ReqNgoaiNguNhanVien(
        ReqNgoaiNgu ngoaiNgu,
        Set<UUID> danhSachMaHoSo
) {
}
