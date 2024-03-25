package com.hrm.hoso_chitiet.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.hrm.hoso_chitiet.dto.DateTimeObject;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
@Table(name = "ban_than_co_lam_viec_cho_che_do_cu")
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
@JsonIgnoreProperties({"soYeuLyLich"})
public class BanThanCoLamViecChoCheDoCu extends DateTimeObject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "INTEGER AUTO_INCREMENT")
    int id;

    @Column(name = "bat_dau", columnDefinition = "datetime")
    LocalDateTime batDau;

    @Column(name = "ket_thuc", columnDefinition = "datetime")
    LocalDateTime ketThuc;

    @Column(name = "chucdanh_donvi_diadiem", columnDefinition = "text")
    String chucDanhDonViDiaDiem;

    @Column(name = "so_yeu_ly_lich", columnDefinition = "binary(16)")
    UUID soYeuLyLich;

    public BanThanCoLamViecChoCheDoCu(LocalDateTime batDau, LocalDateTime ketThuc, String chucDanhDonViDiaDiem, UUID soYeuLyLich) {
        super();
        this.batDau = batDau;
        this.ketThuc = ketThuc;
        this.chucDanhDonViDiaDiem = chucDanhDonViDiaDiem;
        this.soYeuLyLich = soYeuLyLich;
    }
}