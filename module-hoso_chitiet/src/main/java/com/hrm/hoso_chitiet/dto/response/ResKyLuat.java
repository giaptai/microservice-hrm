package com.hrm.hoso_chitiet.dto.response;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.hrm.hoso_chitiet.enums.XacNhan;
import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.serialization.Deserializer;
import org.apache.kafka.common.serialization.Serializer;
import org.apache.kafka.connect.data.Field;
import org.apache.kafka.connect.data.Schema;
import org.apache.kafka.connect.data.Struct;
import org.apache.kafka.connect.data.Timestamp;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

public record ResKyLuat(
        int id,
        @JsonSerialize(using = LocalDateTimeSerializer.class)
        @JsonDeserialize(using = LocalDateTimeDeserializer.class)
        LocalDateTime batDau,
        @JsonSerialize(using = LocalDateTimeSerializer.class)
        @JsonDeserialize(using = LocalDateTimeDeserializer.class)
        LocalDateTime ketThuc,
        String hinhThuc,
        String hanhViViPhamChinh,
        int coQuanQuyetDinhId,
        String coQuanQuyetDinhName,
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
    public static class ResKyLuatSerializer implements Serializer<List<ResKyLuat>> {
        private final ObjectMapper objectMapper = new ObjectMapper();

        @Override
        public byte[] serialize(String topic, List<ResKyLuat> data) {
            try {
                return data != null ? objectMapper.writeValueAsBytes(data) : null;
            } catch (Exception e) {
                throw new SerializationException("Error when serializing MessageDto to byte[]");
            }
        }
    }

    public static class ResKyLuatChuanSerializer implements Serializer<Struct> {
        private final ObjectMapper objectMapper = new ObjectMapper();

        @Override
        public byte[] serialize(String topic, Struct data) {
            try {
                if (data == null) {
                    return null;
                }
                objectMapper.registerModule(new JavaTimeModule());

                // Convert Struct to Map
//                Map<String, Object> structMap = new HashMap<>();
//                for (Field field : data.schema().fields()) {
//                    structMap.put(field.name(), data.get(field));
//                }
                Map<String, Object> structMap = data.schema().fields().stream()
                        .collect(Collectors.toMap(Field::name, data::get));
                // Include schema and payload in the JSON object
                Map<String, Object> jsonMap = new HashMap<>();
                jsonMap.put("schema", schemaToJson(data.schema()));
                jsonMap.put("payload", structMap);

                return objectMapper.writeValueAsBytes(jsonMap);
            } catch (Exception e) {
                throw new SerializationException("Error when serializing MessageDto to byte[]" + e.getMessage());
            }
        }

        // Convert Schema to JSON
        private Map<String, Object> schemaToJson(Schema schema) {
            Map<String, Object> schemaJson = new HashMap<>();
            schemaJson.put("type", schema.type().getName().toLowerCase()); // Add type field
            schemaJson.put("optional", schema.isOptional());
            schemaJson.put("fields", fieldsToJson(schema));
            return schemaJson;
        }

        private List<Map<String, Object>> fieldsToJson(Schema schema) {
            List<Map<String, Object>> list = new ArrayList<>();

            //coquan_tochuc_donvi_id
            Map<String, Object> map0 = new HashMap<>();
            map0.put("type", schema.fields().get(0).schema().type().getName().toLowerCase());
            map0.put("optional", schema.fields().get(0).schema().isOptional());
            map0.put("field", schema.fields().get(0).name());

            //xac_nhan
            Map<String, Object> map1 = new HashMap<>();
            map1.put("type", schema.fields().get(1).schema().type().getName().toLowerCase());
            map1.put("optional", schema.fields().get(1).schema().isOptional());
            map1.put("field", schema.fields().get(1).name());

            //bat_dau
            Map<String, Object> map2 = new HashMap<>();
            map2.put("type", schema.fields().get(2).schema().type().getName().toLowerCase());
            map2.put("optional", schema.fields().get(2).schema().isOptional());
            map2.put("field", schema.fields().get(2).name());
            map2.put("version", schema.fields().get(2).schema().version());
            map2.put("name", schema.fields().get(2).schema().name());

            //ket_thuc
            Map<String, Object> map3 = new HashMap<>();
            map3.put("type", schema.fields().get(3).schema().type().getName().toLowerCase());
            map3.put("optional", schema.fields().get(3).schema().isOptional());
            map3.put("field", schema.fields().get(3).name());
            map3.put("version", schema.fields().get(3).schema().version());
            map3.put("name", schema.fields().get(3).schema().name());

            Map<String, Object> map4 = new HashMap<>();
            map4.put("type", schema.fields().get(4).schema().type().getName().toLowerCase());
            map4.put("optional", schema.fields().get(4).schema().isOptional());
            map4.put("field", schema.fields().get(4).name());

            Map<String, Object> map5 = new HashMap<>();
            map5.put("type", schema.fields().get(5).schema().type().getName().toLowerCase());
            map5.put("optional", schema.fields().get(5).schema().isOptional());
            map5.put("field", schema.fields().get(5).name());

            Map<String, Object> map6 = new HashMap<>();
            map6.put("type", schema.fields().get(6).schema().type().getName().toLowerCase());
            map6.put("optional", schema.fields().get(6).schema().isOptional());
            map6.put("field", schema.fields().get(6).name());

            list.add(map0);
            list.add(map1);
            list.add(map2);
            list.add(map3);
            list.add(map4);
            list.add(map5);
            list.add(map6);
            return list;
        }
    }

    public static class ResKyLuatDeserializer implements Deserializer<List<ResKyLuat>> {
        private final ObjectMapper objectMapper = new ObjectMapper();

        @Override
        public List<ResKyLuat> deserialize(String topic, byte[] data) {
            try {
                return data != null ?
                        objectMapper.readValue(new String(data, StandardCharsets.UTF_8),
                                objectMapper.getTypeFactory().constructCollectionType(List.class, ResKyLuat.class)) :
                        null;
            } catch (Exception e) {
                throw new SerializationException("Error when serializing MessageDto to byte[]");
            }
        }
    }
}
