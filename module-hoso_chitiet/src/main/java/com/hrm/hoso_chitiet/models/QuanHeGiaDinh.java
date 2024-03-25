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

import java.util.UUID;

/**
 * gia dinh bao gom ruot va ben vo hoac chong luon
 **/
@Entity
@Table(name = "quan_he_gia_dinh")
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
@JsonIgnoreProperties({"soYeuLyLich"}) //error field SoYeuLyLich soYeuLyLich;
public class QuanHeGiaDinh extends DateTimeObject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "INTEGER AUTO_INCREMENT")
    int id;

    @Column(name = "moi_quan_he", columnDefinition = "INTEGER")
    int moiQuanHe;

    @Column(name = "ho_va_ten", columnDefinition = "varchar(50)")
    String hoVaTen;

    @Column(name = "nam_sinh", columnDefinition = "SMALLINT")
    short namSinh;

    @Column(name = "thong_tin_than_nhan", columnDefinition = "text")
    String thongTinThanNhan;

    @Column(name = "so_yeu_ly_lich", columnDefinition = "binary(16)")
    UUID soYeuLyLich;

    @Override
    public void setUpdate_at() {
        super.setUpdate_at();
    }

    public QuanHeGiaDinh(int moiQuanHe, String hoVaTen, short namSinh, String thongTinThanNhan, UUID soYeuLyLich) {
        super();
        this.moiQuanHe = moiQuanHe;
        this.hoVaTen = hoVaTen;
        this.namSinh = namSinh;
        this.thongTinThanNhan = thongTinThanNhan;
        this.soYeuLyLich = soYeuLyLich;
    }
}
