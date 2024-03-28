package com.hrm.taikhoan.dto.client.khen_thuong;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.hrm.taikhoan.enums.XacNhan;
import com.hrm.taikhoan.enums.XepLoaiChuyenMon;
import com.hrm.taikhoan.enums.XepLoaiThiDua;

import java.time.LocalDateTime;
import java.util.UUID;

public record KhenThuongDTO(
        int id,
        @JsonSerialize(using = LocalDateTimeSerializer.class)
        @JsonDeserialize(using = LocalDateTimeDeserializer.class)
        LocalDateTime nam,
        XepLoaiChuyenMon xepLoaiChuyenMon,
        XepLoaiThiDua xepLoaiThiDua,
        int hinhThucKhenThuongId,
        String lyDo,
        XacNhan xacNhan,
        @JsonSerialize(using = LocalDateTimeSerializer.class)
        @JsonDeserialize(using = LocalDateTimeDeserializer.class)
        LocalDateTime create_at,
        @JsonSerialize(using = LocalDateTimeSerializer.class)
        @JsonDeserialize(using = LocalDateTimeDeserializer.class)
        LocalDateTime update_at
) {
}
