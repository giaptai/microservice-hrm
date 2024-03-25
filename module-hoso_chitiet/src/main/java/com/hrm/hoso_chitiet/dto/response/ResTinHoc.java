package com.hrm.hoso_chitiet.dto.response;

import com.hrm.hoso_chitiet.models.TinHoc;

import java.time.LocalDateTime;

public record ResTinHoc(
        int id,
        LocalDateTime batDau,
        LocalDateTime ketThuc,
        int IdTenCoSoDaoTao,
        String chungChiDuocCap,
        LocalDateTime create_at,
        LocalDateTime update_at

) {
    public static ResTinHoc mapToResTinHoc(TinHoc hoc) {
        return hoc != null ? new ResTinHoc(
                hoc.getId(),
                hoc.getBatDau(),
                hoc.getKetThuc(),
                hoc.getTenCoSoDaoTao(),
                hoc.getChungChiDuocCap(),
                hoc.getCreate_at(),
                hoc.getUpdate_at()
        ) : null;
    }

}
