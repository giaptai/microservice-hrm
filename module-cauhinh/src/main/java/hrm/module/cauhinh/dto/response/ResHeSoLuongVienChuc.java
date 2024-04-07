package hrm.module.cauhinh.dto.response;

import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record ResHeSoLuongVienChuc(
        int id,
        float heSo,
        int bacLuongId,
        String bacLuongName,
        int nhomVienChucId,
        String nhomVienChucName,
        LocalDateTime create_at,
        LocalDateTime update_at
) {
}
