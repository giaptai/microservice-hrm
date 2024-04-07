package hrm.module.cauhinh.dto.response;

import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record ResHeSoLuongCongChuc(
        int id,
        float heSo,
        int bacLuongId,
        String bacLuongName,
        int nhomCongChucId,
        String nhomCongChucName,
        LocalDateTime create_at,
        LocalDateTime update_at
) {
}
