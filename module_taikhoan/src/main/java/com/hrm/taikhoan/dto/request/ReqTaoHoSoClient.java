package com.hrm.taikhoan.dto.request;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.serialization.Serializer;

import java.util.Map;

public record ReqTaoHoSoClient(
//        UUID uuid,
        String hoVaTen,
        String soCCCD,
        int taiKhoan
) {
    public static class ReqHoSoSerializer implements Serializer<ReqTaoHoSoClient> {
        private final ObjectMapper objectMapper = new ObjectMapper();
        @Override
        public void configure(Map<String, ?> configs, boolean isKey) {
        }
        @Override
        public byte[] serialize(String topic, ReqTaoHoSoClient data) {
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
//                return bos.toByteArray();
                return objectMapper.writeValueAsBytes(data);
            } catch (Exception e) {
                throw new SerializationException("Error when serializing ReqHoSo to byte[]");
            }
        }

        @Override
        public void close() {
        }
    }
}
