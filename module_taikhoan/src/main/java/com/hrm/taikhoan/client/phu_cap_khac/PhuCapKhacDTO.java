package com.hrm.taikhoan.client.phu_cap_khac;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.hrm.taikhoan.enums.XacNhan;

import java.time.LocalDateTime;

public record PhuCapKhacDTO(
        int id,
        LocalDateTime batDau,
        LocalDateTime ketThuc,
        int IdLoaiPhuCap,
        float phanTramHuongPhuCap,
        float heSoPhuCap,
        String hinhThucHuong,
        double giaTri,
        LocalDateTime create_at,
        LocalDateTime update_at
){
}
