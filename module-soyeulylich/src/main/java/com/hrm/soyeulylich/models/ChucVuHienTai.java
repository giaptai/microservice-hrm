package com.hrm.soyeulylich.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.hrm.soyeulylich.dto.DateTimeObject;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
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
@Table(name="chuc_vu_hien_tai")
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@FieldDefaults(level = AccessLevel.PRIVATE)
@JsonIgnoreProperties({"hoSo"})
public class ChucVuHienTai extends DateTimeObject {
    @Id
    @Column(name = "ho_so_id")
    UUID id;

    @Column(name = "chuc_vu_hientai", columnDefinition = "integer")
    int chucVu;

    @Column(name = "ngay_bo_nhiem", columnDefinition = "datetime")
    LocalDateTime ngayBoNhiem;

    @Column(name = "ngay_bo_nhiem_lai", columnDefinition = "datetime")
    LocalDateTime ngayBoNhiemLai;

    @Column(name = "duoc_quy_hoach_chuc_danh", columnDefinition = "varchar(50) default ''")
    String duocQuyHoacChucDanh;

    @OneToOne
    @MapsId
    @JoinColumn(name = "ho_so_id")
    HoSo hoSo;

    public ChucVuHienTai(int chucVu, LocalDateTime ngayBoNhiem, LocalDateTime ngayBoNhiemLai, String duocQuyHoacChucDanh, HoSo hoSo) {
        super();
        this.chucVu = chucVu;
        this.ngayBoNhiem = ngayBoNhiem;
        this.ngayBoNhiemLai = ngayBoNhiemLai;
        this.duocQuyHoacChucDanh = duocQuyHoacChucDanh;
        this.hoSo = hoSo;
    }
}
