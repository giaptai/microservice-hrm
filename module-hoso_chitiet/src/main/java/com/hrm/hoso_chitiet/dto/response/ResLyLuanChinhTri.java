package com.hrm.hoso_chitiet.dto.response;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hrm.hoso_chitiet.enums.XacNhan;
import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.serialization.Deserializer;
import org.apache.kafka.common.serialization.Serializer;

import java.time.LocalDateTime;
import java.util.UUID;

public record ResLyLuanChinhTri(
        int id,
        LocalDateTime batDau,
        LocalDateTime ketThuc,
        int tenCoSoDaoTaoId,
        String tenCoSoDaoTaoName,
        String hinhThucDaoTao,
        String vanBangDuocCap,
        XacNhan xacNhan,
        UUID hoSoId,
        String hoVaTen,
        String soCCCD,
        LocalDateTime create_at,
        LocalDateTime update_at

) {
    public static class ResLyLuanChinhTriSerializer implements Serializer<ResLyLuanChinhTri> {
        private final ObjectMapper objectMapper = new ObjectMapper();

        @Override
        public byte[] serialize(String topic, ResLyLuanChinhTri data) {
            try {
                return data != null ? objectMapper.writeValueAsBytes(data) : null;
            } catch (Exception e) {
                throw new SerializationException("Error when serializing MessageDto to byte[]");
            }
        }
    }

    public static class ResLyLuanChinhTriDeserializer implements Deserializer<ResLyLuanChinhTri> {
        private final ObjectMapper objectMapper = new ObjectMapper();

        @Override
        public ResLyLuanChinhTri deserialize(String topic, byte[] data) {
            try {
                return data != null ? objectMapper.readValue(data, ResLyLuanChinhTri.class) : null;
            } catch (Exception e) {
                throw new SerializationException("Error when serializing MessageDto to byte[]");
            }
        }
    }
}
