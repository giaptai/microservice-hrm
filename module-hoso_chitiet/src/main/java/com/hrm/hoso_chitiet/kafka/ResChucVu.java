package com.hrm.hoso_chitiet.kafka;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.hrm.hoso_chitiet.enums.XacNhan;
import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.serialization.Deserializer;

import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;

public record ResChucVu(
        int chucVuHienTaiId, //ChucVu chucVuHienTai
        String chucVuHienTaiName,
        LocalDateTime ngayBoNhiem,
        LocalDateTime ngayBoNhiemLai,
        String duocQuyHoacChucDanh,
        int coQuanToChucDonViTuyenDungId,
        String coQuanToChucDonViTuyenDungName,
        XacNhan xacNhan,
        UUID hoSoId
) {
    public static class ResChucVuSoDeserializer implements Deserializer<ResChucVu> {
        private final ObjectMapper objectMapper = new ObjectMapper();
        @Override
        public void configure(Map<String, ?> configs, boolean isKey) {
        }

        @Override
        public ResChucVu deserialize(String topic, byte[] data) {
            try {
                if (data == null) {
                    System.out.println("Null received at deserializing");
                    return null;
                }
//                ByteArrayInputStream bis = new ByteArrayInputStream(data);
//                ObjectInputStream ois = new ObjectInputStream(bis);
                System.out.println("Deserializing...");
//                return (ReqTaoHoSo) ois.readObject();
                objectMapper.registerModule(new JavaTimeModule());
                return objectMapper.readValue(new String(data, StandardCharsets.UTF_8), ResChucVu.class);
            } catch (Exception e) {
                throw new SerializationException("Error when deserializing byte[] to ResChucVu");
            }
        }

        @Override
        public void close() {
        }
    }
}
