package com.hrm.hoso_chitiet.dto.response;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.hrm.hoso_chitiet.enums.XacNhan;
import com.hrm.hoso_chitiet.models.KyLuat;
import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.serialization.Deserializer;
import org.apache.kafka.common.serialization.Serializer;

import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public record ResKyLuat(
        int id,
        UUID maSyll,
        @JsonSerialize(using = LocalDateTimeSerializer.class)
        @JsonDeserialize(using = LocalDateTimeDeserializer.class)
        LocalDateTime batDau,
        @JsonSerialize(using = LocalDateTimeSerializer.class)
        @JsonDeserialize(using = LocalDateTimeDeserializer.class)
        LocalDateTime ketThuc,
        String hinhThuc,
        String hanhViViPhamChinh,
        int IdCoQuanQuyetDinh,
        XacNhan xacNhan,
        @JsonSerialize(using = LocalDateTimeSerializer.class)
        @JsonDeserialize(using = LocalDateTimeDeserializer.class)
        LocalDateTime create_at,
        @JsonSerialize(using = LocalDateTimeSerializer.class)
        @JsonDeserialize(using = LocalDateTimeDeserializer.class)
        LocalDateTime update_at

) {
    public static ResKyLuat mapToResKyLuat(KyLuat luat) {
        return luat != null ? new ResKyLuat(
                luat.getId(),
                luat.getSoYeuLyLich(),
                luat.getBatDau(),
                luat.getKetThuc(),
                luat.getHinhThuc(),
                luat.getHanhViViPhamChinh(),
                luat.getCoQuanQuyetDinh(),
                luat.getXacNhan(),
                luat.getCreate_at(),
                luat.getUpdate_at()
        ) : null;
    }

    public static class ResKyLuatSerializer implements Serializer<List<ResKyLuat>> {
        private final ObjectMapper objectMapper = new ObjectMapper();

        @Override
        public byte[] serialize(String topic, List<ResKyLuat> data) {
            try {
                return data != null ? objectMapper.writeValueAsBytes(data) : null;
            } catch (Exception e) {
                throw new SerializationException("Error when serializing MessageDto to byte[]");
            }
        }
    }

    public static class ResKyLuatDeserializer implements Deserializer<List<ResKyLuat>> {
        private final ObjectMapper objectMapper = new ObjectMapper();

        @Override
        public List<ResKyLuat> deserialize(String topic, byte[] data) {
            try {
                return data != null ?
                        objectMapper.readValue(new String(data, StandardCharsets.UTF_8),
                                objectMapper.getTypeFactory().constructCollectionType(List.class, ResKyLuat.class)) :
                        null;
            } catch (Exception e) {
                throw new SerializationException("Error when serializing MessageDto to byte[]");
            }
        }
    }
}
