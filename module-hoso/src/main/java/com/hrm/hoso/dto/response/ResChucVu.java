package com.hrm.hoso.dto.response;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.serialization.Serializer;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;

public record ResChucVu(
        int chucVuHienTaiId, //ChucVu chucVuHienTai
        String chucVuHienTaiName,
        LocalDateTime ngayBoNhiem,
        LocalDateTime ngayBoNhiemLai,
        String duocQuyHoacChucDanh,
        double phuCapChucVu,
        int coQuanToChucDonViTuyenDungId,
        String coQuanToChucDonViTuyenDungName,
        String xacNhan,
        UUID hoSoId
) {
    public static class ResChucVuSerializer implements Serializer<ResChucVu> {
        private final ObjectMapper objectMapper = new ObjectMapper();

        @Override
        public void configure(Map<String, ?> configs, boolean isKey) {
        }

        @Override
        public byte[] serialize(String topic, ResChucVu data) {
            try {
//                ByteArrayOutputStream bos = new ByteArrayOutputStream();
//                ObjectOutputStream oos = new ObjectOutputStream(bos);
                if (data == null) {
                    System.out.println("Null received at serializing");
                    return null;
                }
                System.out.println("Serializing...");
//                oos.writeObject(data);
//                oos.flush();
                objectMapper.registerModule(new JavaTimeModule());
                return objectMapper.writeValueAsBytes(data);
            } catch (Exception e) {
                throw new SerializationException("Error when serializing ReqChucVu to byte[]" + e.getMessage());
            }
        }

        @Override
        public void close() {
        }
    }
}
