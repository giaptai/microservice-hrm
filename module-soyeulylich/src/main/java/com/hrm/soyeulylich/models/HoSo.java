package com.hrm.soyeulylich.models;

import com.hrm.soyeulylich.dto.DateTimeObject;
import com.hrm.soyeulylich.enums.GioiTinh;
import com.hrm.soyeulylich.enums.PheDuyet;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
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

/**
 * xung đột khi khai báo biến
 * khi dùng columnDefinition trong annotation
 **/

@Entity
@Table(name = "ho_so")
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class HoSo extends DateTimeObject {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", columnDefinition = "BINARY(16)")
    UUID id;

    @Column(name = "ho_va_ten", columnDefinition = "varchar(50) default ''")
    String hoVaTen;

    @Column(name = "gioi_tinh")
    @Enumerated(EnumType.ORDINAL)
    GioiTinh gioiTinh;

    @Column(name = "cac_ten_goi_khac", columnDefinition = "varchar(50) default ''")
    String cacTenGoiKhac;

    @Column(name = "sinh_ngay", columnDefinition = "datetime")
    LocalDateTime sinhNgay;

    @Column(name = "noi_sinh", columnDefinition = "varchar(100) default ''")
    String noiSinh;

    @Column(name = "que_quan", columnDefinition = "varchar(100) default ''")
    String queQuan;

    @Column(name = "dan_toc", columnDefinition = "int")
    int danToc;

    @Column(name = "ton_giao", columnDefinition = "int")
    int tonGiao;

    @Column(name = "so_cccd", columnDefinition = "varchar(12) unique default ''")
    String soCCCD;

    @Column(name = "ngay_cap_cccd", columnDefinition = "datetime")
    LocalDateTime ngayCapCCCD;

    @Column(name = "so_dien_thoai", columnDefinition = "varchar(12) default ''")
    String soDienThoai;

    @Column(name = "so_bhxh", columnDefinition = "varchar(10) default ''")
    String soBHXH;

    @Column(name = "so_bhyt", columnDefinition = "varchar(15) default ''")
    String soBHYT;

    @Column(name = "noi_o_hien_nay", columnDefinition = "varchar(100) default ''")
    String noiOHienNay;

    @Column(name = "thanh_phan_gia_dinh", columnDefinition = "INTEGER")
    int thanhPhanGiaDinh;

    @OneToOne(mappedBy = "hoSo", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    ThongTinTuyenDung thongTinTuyenDung;

    @OneToOne(mappedBy = "hoSo", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    NghiaVuQuanSu quanSu;

    @Column(name = "doi_tuong_chinh_sach", columnDefinition = "integer")
    int doiTuongChinhSach;

    @OneToOne(mappedBy = "hoSo", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    HocVan hocVan;

    @OneToOne(mappedBy = "hoSo", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    ChucVuHienTai chucVuHienTai;

    @Column(name = "chuc_vu_kiem_nhiem", columnDefinition = "integer")
    int chucVuKiemNhiem;

    @Column(name = "chuc_vu_dang_hien_tai", columnDefinition = "integer")
    int chucVuDangHienTai;

    @Column(name = "chuc_vu_dang_kiem_nhiem", columnDefinition = "integer")
    int chucVuDangKiemNhiem;

    @Column(name = "tien_luong", columnDefinition = "double default 1.0")
    double tienLuong;

    @OneToOne(mappedBy = "hoSo", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    NgachNhanVien ngach;

    @Column(name = "phu_cap_chuc_vu", columnDefinition = "double default 0.0")
    double phuCapChucVu;

    @Column(name = "phu_cap_kiem_nhiem", columnDefinition = "double default 0.0")
    double phuCapKiemNhiem;

    @Column(name = "phu_cap_khac", columnDefinition = "double default 0.0")
    double phuCapKhac;

    @OneToOne(mappedBy = "hoSo", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    ViecLam viecLam;

    @OneToOne(mappedBy = "hoSo", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    SucKhoe sucKhoe;

    @Column(name = "phe_duyet")
    @Enumerated(EnumType.ORDINAL)
    PheDuyet pheDuyet;

    @Column(name = "tai_khoan", unique = true)
    int taiKhoan;
}
