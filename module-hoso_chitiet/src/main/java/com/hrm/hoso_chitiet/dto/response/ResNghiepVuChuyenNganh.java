package com.hrm.hoso_chitiet.dto.response;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hrm.hoso_chitiet.enums.XacNhan;
import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.serialization.Deserializer;
import org.apache.kafka.common.serialization.Serializer;

import java.time.LocalDateTime;
import java.util.UUID;

public record ResNghiepVuChuyenNganh(
        int id,
        LocalDateTime batDau,
        LocalDateTime ketThuc,
        int tenCoSoDaoTaoId,
        String tenCoSoDaoTaoName,
        String chungChiDuocCap,
        XacNhan xacNhan,
        UUID hoSoId,
        LocalDateTime create_at,
        LocalDateTime update_at
) {
    public static class ResNghiepVuChuyenNganhSerializer implements Serializer<ResNghiepVuChuyenNganh> {
        private final ObjectMapper objectMapper = new ObjectMapper();

        @Override
        public byte[] serialize(String topic, ResNghiepVuChuyenNganh data) {
            try {
                return data != null ? objectMapper.writeValueAsBytes(data) : null;
            } catch (Exception e) {
                throw new SerializationException("Error when serializing MessageDto to byte[]");
            }
        }
    }

    public static class ResNghiepVuChuyenNganhDeserializer implements Deserializer<ResNghiepVuChuyenNganh> {
        private final ObjectMapper objectMapper = new ObjectMapper();

        @Override
        public ResNghiepVuChuyenNganh deserialize(String topic, byte[] data) {
            try {
                return data != null ? objectMapper.readValue(data, ResNghiepVuChuyenNganh.class) : null;
            } catch (Exception e) {
                throw new SerializationException("Error when serializing MessageDto to byte[]");
            }
        }
    }
}
