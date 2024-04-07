package com.hrm.taikhoan.client.lam_viec_o_nuoc_ngoai;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.hrm.taikhoan.enums.XacNhan;

import java.time.LocalDateTime;
import java.util.UUID;

public record LamViecONuocNgoaiDTO(
        int id,
        LocalDateTime batDau,
        LocalDateTime ketThuc,
        String toChucDiaChiCongViec,
        LocalDateTime create_at,
        LocalDateTime update_at
){
}
