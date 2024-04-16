package com.hrm.hoso_chitiet.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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

import java.util.UUID;

/**
 * gia dinh bao gom ruot va ben vo hoac chong luon
 **/
@Entity
@Table(name = "quan_he_gia_dinh", indexes = @Index(name = "ho_so_idx", columnList = "ho_so_id"))
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class QuanHeGiaDinh extends DateTimeObject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "INTEGER AUTO_INCREMENT")
    int id;

    @Column(name = "moi_quan_he_id", columnDefinition = "INTEGER")
    int moiQuanHeId;

    @Column(name = "ho_va_ten", columnDefinition = "varchar(50)")
    String hoVaTen;

    @Column(name = "nam_sinh", columnDefinition = "SMALLINT")
    short namSinh;

    @Column(name = "thong_tin_than_nhan", columnDefinition = "text")
    String thongTinThanNhan;

    @Enumerated
    @Column(name = "xac_nhan")
    XacNhan xacNhan;

    @Column(name = "ho_so_id", columnDefinition = "binary(16)")
    UUID hoSoId;

    @Override
    public void setUpdate_at() {
        super.setUpdate_at();
    }

    public QuanHeGiaDinh(int moiQuanHeId, String hoVaTen, short namSinh, String thongTinThanNhan, XacNhan xacNhan, UUID hoSoId) {
        super();
        this.moiQuanHeId = moiQuanHeId;
        this.hoVaTen = hoVaTen;
        this.namSinh = namSinh;
        this.thongTinThanNhan = thongTinThanNhan;
        this.xacNhan = xacNhan;
        this.hoSoId = hoSoId;
    }
}
