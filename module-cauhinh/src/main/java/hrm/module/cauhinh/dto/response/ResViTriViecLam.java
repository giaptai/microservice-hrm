package hrm.module.cauhinh.dto.response;

import java.time.LocalDateTime;

public record ResViTriViecLam(
        int id,
        String name,
        int bacLuongId,
        String bacLuongName,
        double tienLuong,
        LocalDateTime create_at,
        LocalDateTime update_at
) {
}
