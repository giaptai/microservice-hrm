package com.hrm.hoso_chitiet.dto.response;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.hrm.hoso_chitiet.enums.XacNhan;
import com.hrm.hoso_chitiet.enums.XepLoaiChuyenMon;
import com.hrm.hoso_chitiet.enums.XepLoaiThiDua;
import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.serialization.Deserializer;
import org.apache.kafka.common.serialization.Serializer;

import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public record ResKhenThuong(
        int id,
        @JsonSerialize(using = LocalDateTimeSerializer.class)
        @JsonDeserialize(using = LocalDateTimeDeserializer.class)
        LocalDateTime nam,
        XepLoaiChuyenMon xepLoaiChuyenMon,
        XepLoaiThiDua xepLoaiThiDua,
        int hinhThucKhenThuongId,
        String hinhThucKhenThuongName,
        String lyDo,
        XacNhan xacNhan,
        UUID hoSoId,
        String hoVaTen,
        String soCCCD,
        @JsonSerialize(using = LocalDateTimeSerializer.class)
        @JsonDeserialize(using = LocalDateTimeDeserializer.class)
        LocalDateTime create_at,
        @JsonSerialize(using = LocalDateTimeSerializer.class)
        @JsonDeserialize(using = LocalDateTimeDeserializer.class)
        LocalDateTime update_at
) {
    @Override
    public String toString() {
        return "{" +
                "\"id\":" + id +
                ", \"nam\":\"" + nam + '\"' +
                ", \"xepLoaiChuyenMon\":\"" + xepLoaiChuyenMon + '\"' +
                ", \"xepLoaiThiDua\":\"" + xepLoaiThiDua + '\"' +
                ", \"hinhThucKhenThuongId\":" + hinhThucKhenThuongId +
                ", \"hinhThucKhenThuongName\":\"" + hinhThucKhenThuongName + '\"' +
                ", \"lyDo\":\"" + lyDo + '\"' +
                ", \"xacNhan\":\"" + xacNhan + '\"' +
                ", \"hoSoId\":\"" + hoSoId + '\"' +
                ", \"hoVaTen\":\"" + hoVaTen + '\"' +
                ", \"soCCCD\":\"" + soCCCD + '\"' +
                ", \"create_at\":\"" + create_at + '\"' +
                ", \"update_at\":\"" + update_at + '\"' +
                "}";
    }

    public static class ResKhenThuongSerializer implements Serializer<List<ResKhenThuong>> {
        private final ObjectMapper objectMapper = new ObjectMapper();

        @Override
        public byte[] serialize(String topic, List<ResKhenThuong> data) {
            try {
                return data != null ? objectMapper.writeValueAsBytes(data) : null;
            } catch (Exception e) {
                throw new SerializationException("Error when serializing MessageDto to byte[]");
            }
        }
    }

    public static class ResKhenThuongDeserializer implements Deserializer<List<ResKhenThuong>> {
        private final ObjectMapper objectMapper = new ObjectMapper();

        @Override
        public List<ResKhenThuong> deserialize(String topic, byte[] data) {
            try {
                return data != null ?
                        objectMapper.readValue(new String(data, StandardCharsets.UTF_8),
                                objectMapper.getTypeFactory().constructCollectionType(List.class, ResKhenThuong.class)) :
                        null;
            } catch (Exception e) {
                throw new SerializationException("Error when serializing MessageDto to byte[]");
            }
        }
    }
}
