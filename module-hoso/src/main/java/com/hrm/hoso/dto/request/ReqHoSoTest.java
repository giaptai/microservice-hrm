package com.hrm.hoso.dto.request;

import com.hrm.hoso.enums.GioiTinh;
import com.hrm.hoso.enums.PheDuyet;
import lombok.Builder;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;

@Builder
public record ReqHoSoTest(
        MultipartFile anh,
        String hoVaTen,
        ReqQuanSu quanSu
) {
}
