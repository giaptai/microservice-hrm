package hrm.module.cauhinh.dto.response;

import hrm.module.cauhinh.models.CapBacLoaiQuanHamQuanDoi;

import java.time.LocalDateTime;

public record ResCapBacLoaiHamQuanDoi(
        int id,
        String name,
        LocalDateTime create_at,
        LocalDateTime update_at
) {
    public static ResCapBacLoaiHamQuanDoi mapToResCapBacLoaiHamQuanDoi(CapBacLoaiQuanHamQuanDoi doi) {
        return doi != null ? new ResCapBacLoaiHamQuanDoi(
                doi.getId(),
                doi.getName(),
                doi.getCreate_at(),
                doi.getUpdate_at()
        ) : null;
    }
}
