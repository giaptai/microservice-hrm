package com.hrm.hoso.dto.response;

import java.util.List;

public record ResListHoSo(
        List<ResHoSo> data,
        long totalRecord,
        int totalPage
) {
}
