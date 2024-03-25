package com.hrm.hoso_chitiet.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hrm.hoso_chitiet.dto.DateTimeObject;
import com.hrm.hoso_chitiet.dto.response.ResNgoaiNgu;
import com.hrm.hoso_chitiet.enums.XacNhan;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;
import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.serialization.Deserializer;
import org.apache.kafka.common.serialization.Serializer;

import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Entity
@Table(name = "ngoai_ngu")
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
@JsonIgnoreProperties({"soYeuLyLich"})
public class NgoaiNgu extends DateTimeObject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "INTEGER AUTO_INCREMENT")
    int id;

    @Column(name = "bat_dau", columnDefinition = "datetime")
    LocalDateTime batDau;

    @Column(name = "ket_thuc", columnDefinition = "datetime")
    LocalDateTime ketThuc;

    @Column(name = "ten_co_so_dao_tao", columnDefinition = "INTEGER")
    int tenCoSoDaoTao;

    @Column(name = "ten_ngoai_ngu", columnDefinition = "varchar(50)")
    String tenNgoaiNgu;

    @Column(name = "chung_chi_duoc_cap", columnDefinition = "varchar(50)")
    String chungChiDuocCap;

    @Column(name = "diem_so", columnDefinition = "float")
    float diemSo;

    @Enumerated
    @Column(name = "xac_nhan")
    XacNhan xacNhan;

    @Column(name = "so_yeu_ly_lich", columnDefinition = "binary(16)")
    UUID soYeuLyLich;

    @Override
    public void setUpdate_at() {
        super.setUpdate_at();
    }

    public NgoaiNgu(LocalDateTime batDau, LocalDateTime ketThuc, int tenCoSoDaoTao, String tenNgoaiNgu, String chungChiDuocCap, float diemSo, XacNhan xacNhan, UUID soYeuLyLich) {
        super();
        this.batDau = batDau;
        this.ketThuc = ketThuc;
        this.tenCoSoDaoTao = tenCoSoDaoTao;
        this.tenNgoaiNgu = tenNgoaiNgu;
        this.chungChiDuocCap = chungChiDuocCap;
        this.diemSo = diemSo;
        this.xacNhan = xacNhan;
        this.soYeuLyLich = soYeuLyLich;
    }

    public static class NgoaiNguSerializer implements Serializer<List<ResNgoaiNgu>> {
        private final ObjectMapper objectMapper = new ObjectMapper();

        @Override
        public void configure(Map<String, ?> configs, boolean isKey) {
        }

        @Override
        public byte[] serialize(String topic, List<ResNgoaiNgu> data) {
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

    public static class NgoaiNguDeserializer implements Deserializer<List<ResNgoaiNgu>> {
        private final ObjectMapper objectMapper = new ObjectMapper();

        @Override
        public void configure(Map<String, ?> configs, boolean isKey) {
        }

        @Override
        public List<ResNgoaiNgu> deserialize(String topic, byte[] data) {
            try {
                if (data == null) {
                    System.out.println("Null received at deserializing");
                    return null;
                }
                System.out.println("Deserializing...");
                return objectMapper.readValue(new String(data, StandardCharsets.UTF_8),
                        objectMapper.getTypeFactory().constructCollectionType(List.class, ResNgoaiNgu.class));
            } catch (Exception e) {
                throw new SerializationException("Error when deserializing byte[] to MessageDto");
            }
        }

        @Override
        public void close() {
        }
    }
}