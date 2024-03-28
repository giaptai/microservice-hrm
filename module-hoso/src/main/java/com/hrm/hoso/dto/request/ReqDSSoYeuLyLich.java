package com.hrm.hoso.dto.request;


import com.hrm.hoso.enums.PheDuyet;

import java.util.Set;
import java.util.UUID;

public record ReqDSSoYeuLyLich(
        Set<UUID> soYeuLyLichs,
        PheDuyet pheDuyet
) {
}
