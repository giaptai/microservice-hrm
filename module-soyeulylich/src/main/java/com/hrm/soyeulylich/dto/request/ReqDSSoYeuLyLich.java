package com.hrm.soyeulylich.dto.request;


import com.hrm.soyeulylich.enums.PheDuyet;

import java.util.Set;
import java.util.UUID;

public record ReqDSSoYeuLyLich(
        Set<UUID> soYeuLyLichs,
        PheDuyet pheDuyet
) {
}
