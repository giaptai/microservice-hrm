package hrm.module.cauhinh.dto.response;

import java.time.LocalDateTime;

public record ResNhomVienChuc(
        int id,
        String name,
        int loaiVienChucId,
        String loaiVienChucLoai,
        LocalDateTime create_at,
        LocalDateTime update_at
) {
}
