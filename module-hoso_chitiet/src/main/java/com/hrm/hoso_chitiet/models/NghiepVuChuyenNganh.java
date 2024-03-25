package com.hrm.hoso_chitiet.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.hrm.hoso_chitiet.dto.DateTimeObject;
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

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "nghiep_vu_chuyen_nganh")
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
@JsonIgnoreProperties({"soYeuLyLich"})
public class NghiepVuChuyenNganh extends DateTimeObject {
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

    @Column(name = "chung_chi_duoc_cap", columnDefinition = "varchar(50)")
    String chungChiDuocCap;

    @Enumerated
    @Column(name = "xac_nhan")
    XacNhan xacNhan;

    @Column(name = "so_yeu_ly_lich", columnDefinition = "binary(16)")
    UUID soYeuLyLich;

    public NghiepVuChuyenNganh(LocalDateTime batDau, LocalDateTime ketThuc, int tenCoSoDaoTao, String chungChiDuocCap, XacNhan xacNhan, UUID soYeuLyLich) {
        super();
        this.batDau = batDau;
        this.ketThuc = ketThuc;
        this.tenCoSoDaoTao = tenCoSoDaoTao;
        this.chungChiDuocCap = chungChiDuocCap;
        this.xacNhan = xacNhan;
        this.soYeuLyLich = soYeuLyLich;
    }
}