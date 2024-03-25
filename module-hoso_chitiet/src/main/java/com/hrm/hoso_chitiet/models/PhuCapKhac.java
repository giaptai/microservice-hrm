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
@Table(name = "phu_cap_khac")
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
@JsonIgnoreProperties({"soYeuLyLich"})
public class PhuCapKhac extends DateTimeObject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "INTEGER AUTO_INCREMENT")
    int id;

    @Column(name = "bat_dau", columnDefinition = "datetime")
    LocalDateTime batDau;

    @Column(name = "ket_thuc", columnDefinition = "datetime")
    LocalDateTime ketThuc;

    @Column(name = "loai_phu_cap", columnDefinition = "INTEGER")
    int loaiPhuCap;

    @Column(name = "phan_tram_huong_phu_cap", columnDefinition = "float")
    float phanTramHuongPhuCap;

    @Column(name = "he_so_phu_cap", columnDefinition = "float")
    float heSoPhuCap;

    @Column(name = "hinh_thuc_huong", columnDefinition = "varchar(50)")
    String hinhThucHuong;

    @Column(name = "gia_tri", columnDefinition = "double")
    double giaTri;

    @Column(name = "so_yeu_ly_lich", columnDefinition = "binary(16)")
    UUID soYeuLyLich;

    public PhuCapKhac(LocalDateTime batDau, LocalDateTime ketThuc, int loaiPhuCap, float phanTramHuongPhuCap, float heSoPhuCap, String hinhThucHuong, double giaTri, UUID soYeuLyLich) {
        super();
        this.batDau = batDau;
        this.ketThuc = ketThuc;
        this.loaiPhuCap = loaiPhuCap;
        this.phanTramHuongPhuCap = phanTramHuongPhuCap;
        this.heSoPhuCap = heSoPhuCap;
        this.hinhThucHuong = hinhThucHuong;
        this.giaTri = giaTri;
        this.soYeuLyLich = soYeuLyLich;
    }
}