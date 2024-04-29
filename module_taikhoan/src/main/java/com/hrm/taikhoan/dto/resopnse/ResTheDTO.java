package com.hrm.taikhoan.dto.resopnse;

import java.util.List;

public record ResTheDTO(
        List<ResTaiKhoan> data,
        long totalRecord,
        int totalPage
) {
}
