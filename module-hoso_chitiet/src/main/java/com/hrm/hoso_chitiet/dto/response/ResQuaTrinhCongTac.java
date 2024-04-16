package com.hrm.hoso_chitiet.dto.response;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hrm.hoso_chitiet.enums.XacNhan;
import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.serialization.Deserializer;
import org.apache.kafka.common.serialization.Serializer;

import java.time.LocalDateTime;
import java.util.UUID;

public record ResQuaTrinhCongTac(
        int id,
        LocalDateTime batDau,
        LocalDateTime ketThuc,
        int donViCongTacId,
        String donViCongTacName,
        String chucDanh,
        XacNhan xacNhan,
        UUID hoSoId,
        LocalDateTime create_at,
        LocalDateTime update_at
) {
    public static class ResQuaTrinhCongTacSerializer implements Serializer<ResQuaTrinhCongTac> {
        private final ObjectMapper objectMapper = new ObjectMapper();

        @Override
        public byte[] serialize(String topic, ResQuaTrinhCongTac data) {
            try {
                return data != null ? objectMapper.writeValueAsBytes(data) : null;
            } catch (Exception e) {
                throw new SerializationException("Error when serializing MessageDto to byte[]");
            }
        }
    }

    public static class ResQuaTrinhCongTacDeserializer implements Deserializer<ResQuaTrinhCongTac> {
        private final ObjectMapper objectMapper = new ObjectMapper();

        @Override
        public ResQuaTrinhCongTac deserialize(String topic, byte[] data) {
            try {
                return data != null ? objectMapper.readValue(data, ResQuaTrinhCongTac.class) : null;
            } catch (Exception e) {
                throw new SerializationException("Error when serializing MessageDto to byte[]");
            }
        }
    }
}
