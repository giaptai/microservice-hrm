package com.hrm.hoso_chitiet.dto.response;

import java.util.List;

public record ResTheDTO<T>(
        List<T> data,
        long totalRecord,
        int totalPage
) {
}
