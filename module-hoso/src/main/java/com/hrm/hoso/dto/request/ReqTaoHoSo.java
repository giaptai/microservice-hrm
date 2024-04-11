package com.hrm.hoso.dto.request;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.serialization.Deserializer;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.charset.StandardCharsets;
import java.util.Map;

public record ReqTaoHoSo(
        String hoVaTen,
        String soCCCD,
        int taiKhoan
){
    public static class ReqTaoHoSoDeserializer implements Deserializer<ReqTaoHoSo> {
        private final ObjectMapper objectMapper = new ObjectMapper();
        @Override
        public void configure(Map<String, ?> configs, boolean isKey) {
        }

        @Override
        public ReqTaoHoSo deserialize(String topic, byte[] data) {
            try {
                if (data == null) {
                    System.out.println("Null received at deserializing");
                    return null;
                }
//                ByteArrayInputStream bis = new ByteArrayInputStream(data);
//                ObjectInputStream ois = new ObjectInputStream(bis);
                System.out.println("Deserializing...");
//                return (ReqTaoHoSo) ois.readObject();
                return objectMapper.readValue(new String(data, StandardCharsets.UTF_8), ReqTaoHoSo.class);
            } catch (Exception e) {
                throw new SerializationException("Error when deserializing byte[] to ReqTaoHoSo");
            }
        }

        @Override
        public void close() {
        }
    }
}
