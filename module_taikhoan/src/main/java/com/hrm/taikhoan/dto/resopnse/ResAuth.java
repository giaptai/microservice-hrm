package com.hrm.taikhoan.dto.resopnse;

import lombok.Builder;
import java.util.UUID;

@Builder
public record ResAuth(
        int id,
        String username,
        String password,
        UUID hoSoId,
        String role
) {

}
