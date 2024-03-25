package com.hrm.hoso_chitiet.dto.response;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hrm.hoso_chitiet.enums.XacNhan;
import com.hrm.hoso_chitiet.models.NghiepVuChuyenNganh;
import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.serialization.Deserializer;
import org.apache.kafka.common.serialization.Serializer;

import java.time.LocalDateTime;
import java.util.UUID;

public record ResNghiepVuChuyenNganh(
        int id,
        UUID maSyll,
        LocalDateTime batDau,
        LocalDateTime ketThuc,
        int IdTenCoSoDaoTao,
        String chungChiDuocCap,
        XacNhan xacNhan,
        LocalDateTime create_at,
        LocalDateTime update_at
) {
    public static ResNghiepVuChuyenNganh mapToResNghiepVuChuyenNganh(NghiepVuChuyenNganh nganh) {
        return nganh != null ? new ResNghiepVuChuyenNganh(
                nganh.getId(),
                nganh.getSoYeuLyLich(),
                nganh.getBatDau(),
                nganh.getKetThuc(),
                nganh.getTenCoSoDaoTao(),
                nganh.getChungChiDuocCap(),
                nganh.getXacNhan(),
                nganh.getCreate_at(),
                nganh.getUpdate_at()
        ) : null;
    }

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
