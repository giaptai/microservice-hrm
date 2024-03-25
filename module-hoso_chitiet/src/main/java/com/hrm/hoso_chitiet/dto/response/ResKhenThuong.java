package com.hrm.hoso_chitiet.dto.response;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.hrm.hoso_chitiet.enums.XacNhan;
import com.hrm.hoso_chitiet.enums.XepLoaiChuyenMon;
import com.hrm.hoso_chitiet.enums.XepLoaiThiDua;
import com.hrm.hoso_chitiet.models.KhenThuong;
import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.serialization.Deserializer;
import org.apache.kafka.common.serialization.Serializer;

import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public record ResKhenThuong(
        int id,
        UUID maSyll,
        @JsonSerialize(using = LocalDateTimeSerializer.class)
        @JsonDeserialize(using = LocalDateTimeDeserializer.class)
        LocalDateTime nam,
        String xepLoaiChuyenMon,
        XepLoaiChuyenMon xepLoaiChuyenMonEnum,
        String xepLoaiThiDua,
        XepLoaiThiDua xepLoaiThiDuaEnum,
        int hinhThucKhenThuong,
        XacNhan xacNhan,
        @JsonSerialize(using = LocalDateTimeSerializer.class)
        @JsonDeserialize(using = LocalDateTimeDeserializer.class)
        LocalDateTime create_at,
        @JsonSerialize(using = LocalDateTimeSerializer.class)
        @JsonDeserialize(using = LocalDateTimeDeserializer.class)
        LocalDateTime update_at
) {
    public static ResKhenThuong maptoResKhenThuong(KhenThuong thuong) {
        String htktName = "";
        return thuong != null ? new ResKhenThuong(
                thuong.getId(),
                thuong.getSoYeuLyLich(),
                thuong.getNam(),
                thuong.getXepLoaiChuyenMon().getName(),
                thuong.getXepLoaiChuyenMon(),
                thuong.getXepLoaiThiDua().getName(),
                thuong.getXepLoaiThiDua(),
                thuong.getHinhThucKhenThuong(),
                thuong.getXacNhan(),
                thuong.getCreate_at(),
                thuong.getUpdate_at()
        ) : null;
    }

    public static class ResKhenThuongSerializer implements Serializer<List<ResKhenThuong>> {
        private final ObjectMapper objectMapper = new ObjectMapper();

        @Override
        public byte[] serialize(String topic, List<ResKhenThuong> data) {
            try {
                return data != null ? objectMapper.writeValueAsBytes(data) : null;
            } catch (Exception e) {
                throw new SerializationException("Error when serializing MessageDto to byte[]");
            }
        }
    }

    public static class ResKhenThuongDeserializer implements Deserializer<List<ResKhenThuong>> {
        private final ObjectMapper objectMapper = new ObjectMapper();

        @Override
        public List<ResKhenThuong> deserialize(String topic, byte[] data) {
            try {
                return data != null ?
                        objectMapper.readValue(new String(data, StandardCharsets.UTF_8),
                                objectMapper.getTypeFactory().constructCollectionType(List.class, ResKhenThuong.class)) :
                        null;
            } catch (Exception e) {
                throw new SerializationException("Error when serializing MessageDto to byte[]");
            }
        }
    }
}
