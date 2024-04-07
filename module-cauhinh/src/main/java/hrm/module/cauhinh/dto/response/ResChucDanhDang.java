package hrm.module.cauhinh.dto.response;

import hrm.module.cauhinh.models.ChucDanhDang;

import java.time.LocalDateTime;

public record ResChucDanhDang(
        int id,
        String name,
//        String capNhomChucDanhDang,
        LocalDateTime create_at,
        LocalDateTime update_at
) {
}
