package com.hrm.taikhoan.dto.request;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Builder;

import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.serialization.Deserializer;
import org.apache.kafka.common.serialization.Serializer;

import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.charset.StandardCharsets;
import java.util.Map;

@Builder
public record ReqTaiKhoan(
        String hoVaTen,
        String soCCCD,
        String email
) implements Serializable {
    @Override
    public String toString() {
        return "{" +
                "hoVaTen='" + hoVaTen + '\'' +
                ", soCCCD='" + soCCCD + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public static class ReqTaiKhoanSerializer implements Serializer<ReqTaiKhoan> {
        private final ObjectMapper objectMapper = new ObjectMapper();
//        private final ByteArrayOutputStream bos = new ByteArrayOutputStream();
//        private ObjectOutputStream oos;

        @Override
        public void configure(Map<String, ?> configs, boolean isKey) {
        }

        @Override
        public byte[] serialize(String topic, ReqTaiKhoan data) {
            try {
                ByteArrayOutputStream bos = new ByteArrayOutputStream();
                ObjectOutputStream oos = new ObjectOutputStream(bos);
                if (data == null) {
                    System.out.println("Null received at serializing");
                    return null;
                }
                System.out.println("Serializing...");
                oos.writeObject(data);
                oos.flush();
                return bos.toByteArray();
//                return objectMapper.writeValueAsBytes(data);
            } catch (Exception e) {
                throw new SerializationException("Error when serializing ReqTaiKhoan to byte[]");
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
                return objectMapper.readValue(new String(data, StandardCharsets.UTF_8), ReqTaiKhoan.class);
            } catch (Exception e) {
                throw new SerializationException("Error when deserializing byte[] to MessageDto");
            }
        }

        @Override
        public void close() {
        }
    }
}

