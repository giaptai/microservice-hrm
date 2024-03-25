package hrm.module.cauhinh.dto.response;

import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record ResHeSoLuongCongChuc(
        int id,
        float heSo,
        String bacLuong,
        String nhomLoaiCongChuc,
        boolean trangThai,
        LocalDateTime create_at,
        LocalDateTime update_at
) {
}
