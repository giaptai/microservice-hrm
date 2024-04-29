package hrm.module.cauhinh.dto.response;

import java.util.List;

public record ResTheDTO<T>(
        List<T> data,
        long totalRecord,
        int totalPage
) {
}
