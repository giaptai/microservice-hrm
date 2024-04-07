package hrm.module.cauhinh.dto.response;

import java.time.LocalDateTime;

public record ResNhomCongChuc(
        int id,
        String name,
        int loaiCongChucId,
        String loaiCongChucLoai,
        LocalDateTime create_at,
        LocalDateTime update_at
) {
}
