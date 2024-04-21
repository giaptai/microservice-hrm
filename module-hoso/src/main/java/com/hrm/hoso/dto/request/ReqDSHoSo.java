package com.hrm.hoso.dto.request;

import java.util.Set;
import java.util.UUID;

public record ReqDSHoSo(
        Set<UUID> hoSoIds
) {
}
