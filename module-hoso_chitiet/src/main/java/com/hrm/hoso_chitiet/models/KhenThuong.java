package com.hrm.hoso_chitiet.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.hrm.hoso_chitiet.dto.DateTimeObject;
import com.hrm.hoso_chitiet.enums.XacNhan;
import com.hrm.hoso_chitiet.enums.XepLoaiChuyenMon;
import com.hrm.hoso_chitiet.enums.XepLoaiThiDua;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
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
@Table(name = "khen_thuong")
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
@JsonIgnoreProperties({"soYeuLyLich"})
public class KhenThuong extends DateTimeObject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "INTEGER AUTO_INCREMENT")
    int id;

    @Column(name = "nam", columnDefinition = "datetime")
    LocalDateTime nam;

    @Column(name = "xep_loai_chuyen_mon")
    @Enumerated(EnumType.STRING)
    XepLoaiChuyenMon xepLoaiChuyenMon;

    @Column(name = "xep_loai_thi_dua")
    @Enumerated(EnumType.STRING)
    XepLoaiThiDua xepLoaiThiDua;

    @Column(name = "hinh_thuc_khen_thuong", columnDefinition = "integer")
    int hinhThucKhenThuong;

    @Column(name = "ly_do", columnDefinition = "text")
    String lyDo;

    @Enumerated
    @Column(name = "xac_nhan")
    XacNhan xacNhan;

    @Column(name = "so_yeu_ly_lich", columnDefinition = "binary(16)")
    UUID soYeuLyLich;

    public KhenThuong(LocalDateTime nam, XepLoaiChuyenMon xepLoaiChuyenMon, XepLoaiThiDua xepLoaiThiDua, int hinhThucKhenThuong, String lyDo, XacNhan xacNhan, UUID soYeuLyLich) {
        super();
        this.nam = nam;
        this.xepLoaiChuyenMon = xepLoaiChuyenMon;
        this.xepLoaiThiDua = xepLoaiThiDua;
        this.hinhThucKhenThuong = hinhThucKhenThuong;
        this.lyDo = lyDo;
        this.xacNhan = xacNhan;
        this.soYeuLyLich = soYeuLyLich;
    }
}