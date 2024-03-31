package com.hrm.taikhoan.dto.request;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Builder;
import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.serialization.Deserializer;
import org.apache.kafka.common.serialization.Serializer;

import java.util.Map;

@Builder
public record ReqTaiKhoan(String hoVaTen, String soCCCD, String email) {
    public static class ReqTaiKhoanSerializer implements Serializer<ReqTaiKhoan> {
        private final ObjectMapper objectMapper = new ObjectMapper();

        @Override
        public void configure(Map<String, ?> configs, boolean isKey) {
        }

        @Override
        public byte[] serialize(String topic, ReqTaiKhoan data) {
            try {
                if (data == null) {
                    System.out.println("Null received at serializing");
                    return null;
                }
                System.out.println("Serializing...");
                return objectMapper.writeValueAsBytes(data);
            } catch (Exception e) {
                throw new SerializationException("Error when serializing MessageDto to byte[]");
            }
        }

        @Override
        public void close() {
        }
    }

    public static class ReqTaiKhoanDeserializer implements Deserializer<ReqTaiKhoan> {
        private final ObjectMapper objectMapper = new ObjectMapper();

        @Override
        public void configure(Map<String, ?> configs, boolean isKey) {
        }

        @Override
        public ReqTaiKhoan deserialize(String topic, byte[] data) {
            try {
                if (data == null) {
                    System.out.println("Null received at deserializing");
                    return null;
                }
                System.out.println("Deserializing...");
                return objectMapper.readValue(new String(data, "UTF-8"), ReqTaiKhoan.class);
            } catch (Exception e) {
                throw new SerializationException("Error when deserializing byte[] to MessageDto");
            }
        }

        @Override
        public void close() {
        }
    }

}

