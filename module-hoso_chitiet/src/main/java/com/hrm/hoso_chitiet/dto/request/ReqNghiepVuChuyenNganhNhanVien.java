package com.hrm.hoso_chitiet.dto.request;

import java.util.Set;
import java.util.UUID;

public record ReqNghiepVuChuyenNganhNhanVien(
        ReqNghiepVuChuyenNganh nghiepVuChuyenNganh,
        Set<UUID> danhSachMaHoSo
) {
}
