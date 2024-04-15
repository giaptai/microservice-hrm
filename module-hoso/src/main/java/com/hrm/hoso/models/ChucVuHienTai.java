package com.hrm.hoso.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.hrm.hoso.dto.DateTimeObject;

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
//@JsonIgnoreProperties({"hoSoId"})
public class ChucVuHienTai extends DateTimeObject {
    @Id
    @Column(name = "ho_so_id")
    UUID id;

    @Column(name = "chuc_vu_hien_tai_id", columnDefinition = "integer")
    int chucVuId;

    @Column(name = "ngay_bo_nhiem", columnDefinition = "datetime")
    LocalDateTime ngayBoNhiem;

    @Column(name = "ngay_bo_nhiem_lai", columnDefinition = "datetime")
    LocalDateTime ngayBoNhiemLai;

    @Column(name = "duoc_quy_hoach_chuc_danh", columnDefinition = "varchar(50) default 'Không'")
    String duocQuyHoacChucDanh;

    @Column(name = "phu_cap_chuc_vu", columnDefinition = "double default 0.0")
    double phuCapChucVu;

    @Column(name = "coquan_tochuc_donvi_id", columnDefinition = "INTEGER")
    int coQuanToChucDonViTuyenDungId;

    @OneToOne
    @MapsId
    @JoinColumn(name = "ho_so_id")
    HoSo hoSoId;

//    public ChucVuHienTai(int chucVuId, LocalDateTime ngayBoNhiem, LocalDateTime ngayBoNhiemLai, String duocQuyHoacChucDanh, int coQuanToChucDonViTuyenDungId, HoSo hoSoId) {
//        super();
//        this.chucVuId = chucVuId;
//        this.ngayBoNhiem = ngayBoNhiem;
//        this.ngayBoNhiemLai = ngayBoNhiemLai;
//        this.duocQuyHoacChucDanh = duocQuyHoacChucDanh;
//        this.coQuanToChucDonViTuyenDungId = coQuanToChucDonViTuyenDungId;
//        this.hoSoId = hoSoId;
//    }

    public ChucVuHienTai(int chucVuId, LocalDateTime ngayBoNhiem, LocalDateTime ngayBoNhiemLai, String duocQuyHoacChucDanh, double phuCapChucVu, int coQuanToChucDonViTuyenDungId, HoSo hoSoId) {
        super();
        this.chucVuId = chucVuId;
        this.ngayBoNhiem = ngayBoNhiem;
        this.ngayBoNhiemLai = ngayBoNhiemLai;
        this.duocQuyHoacChucDanh = duocQuyHoacChucDanh;
        this.phuCapChucVu = phuCapChucVu;
        this.coQuanToChucDonViTuyenDungId = coQuanToChucDonViTuyenDungId;
        this.hoSoId = hoSoId;
    }
}
