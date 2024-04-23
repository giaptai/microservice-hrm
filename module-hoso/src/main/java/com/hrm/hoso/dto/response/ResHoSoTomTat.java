package com.hrm.hoso.dto.response;

import java.util.UUID;

public record ResHoSoTomTat(
        UUID hoSoId,
        String hoVaTen,
        String soCCCD
) {
}
