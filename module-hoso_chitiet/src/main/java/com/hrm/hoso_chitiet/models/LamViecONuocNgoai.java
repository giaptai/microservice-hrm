package com.hrm.hoso_chitiet.models;

import com.hrm.hoso_chitiet.enums.XacNhan;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "lam_viec_o_nuoc_ngoai", indexes = {
        @Index(name = "ho_so_idx", columnList = "ho_so_id"),
        @Index(name = "create_at_idx", columnList = "createAt"),
        @Index(name = "update_at_idx", columnList = "updateAt")
})
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class LamViecONuocNgoai extends DateTimeObject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "INTEGER AUTO_INCREMENT")
    int id;

    @Column(name = "bat_dau", columnDefinition = "datetime")
    LocalDateTime batDau;

    @Column(name = "ket_thuc", columnDefinition = "datetime")
    LocalDateTime ketThuc;

    @Column(name = "to_chuc_dia_chi_cong_viec", columnDefinition = "text")
    String toChucDiaChiCongViec;

    @Enumerated
    @Column(name = "xac_nhan")
    XacNhan xacNhan;

    @Column(name = "ho_so_id", columnDefinition = "binary(16)")
    UUID hoSoId;

    public LamViecONuocNgoai(LocalDateTime batDau, LocalDateTime ketThuc, String toChucDiaChiCongViec, XacNhan xacNhan, UUID hoSoId) {
        super();
        this.batDau = batDau;
        this.ketThuc = ketThuc;
        this.toChucDiaChiCongViec = toChucDiaChiCongViec;
        this.xacNhan = xacNhan;
        this.hoSoId = hoSoId;
    }
}