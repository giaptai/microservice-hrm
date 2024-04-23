package com.hrm.hoso.models;

import com.hrm.hoso.dto.DateTimeObject;
import com.hrm.hoso.enums.GioiTinh;
import com.hrm.hoso.enums.PheDuyet;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
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
@Table(name = "ho_so", indexes = {
        @Index(name = "danotc_idx", columnList = "dan_toc_id"),
        @Index(name = "create_at_idx", columnList = "createAt"),
        @Index(name = "update_at_idx", columnList = "updateAt"),
})
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

    @Column(name = "dan_toc_id", columnDefinition = "int")
    int danTocId;

    @Column(name = "ton_giao_id", columnDefinition = "int")
    int tonGiaoId;

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

    @Column(name = "thanh_phan_gia_dinh_id", columnDefinition = "INTEGER")
    int thanhPhanGiaDinhId;

    @OneToOne(mappedBy = "hoSoId", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    ThongTinTuyenDung thongTinTuyenDung;

    @OneToOne(mappedBy = "hoSoId", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    NghiaVuQuanSu quanSu;

    @Column(name = "doi_tuong_chinh_sach_id", columnDefinition = "integer")
    int doiTuongChinhSachId;

    @OneToOne(mappedBy = "hoSoId", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    HocVan hocVan;

    @OneToOne(mappedBy = "hoSoId", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    ChucVuHienTai chucVuHienTai;

    @OneToOne(mappedBy = "hoSoId", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    ChucVuKiemNhiem chucVuKiemNhiem;

//    @Column(name = "chuc_vu_kiem_nhiem_id", columnDefinition = "integer")
//    int chucVuKiemNhiemId;

    @Column(name = "chuc_vu_dang_hien_tai_id", columnDefinition = "integer")
    int chucVuDangHienTaiId;

    @Column(name = "chuc_vu_dang_kiem_nhiem_id", columnDefinition = "integer")
    int chucVuDangKiemNhiemId;

    @Column(name = "tien_luong", columnDefinition = "double default 1.0")
    double tienLuong;

    @OneToOne(mappedBy = "hoSoId", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    NgachNhanVien ngach;

//    @Column(name = "phu_cap_chuc_vu", columnDefinition = "double default 0.0") //ChucVuHienTai
//    double phuCapChucVu;

//    @Column(name = "phu_cap_kiem_nhiem", columnDefinition = "double default 0.0") //chuc vu kiem nhiem
//    double phuCapKiemNhiem;

//    @Column(name = "phu_cap_khac", columnDefinition = "double default 0.0") //chuc vu kiem nhiem
//    double phuCapKhac;

    @OneToOne(mappedBy = "hoSoId", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    ViecLam viecLam;

    @OneToOne(mappedBy = "hoSoId", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    SucKhoe sucKhoe;

    @Column(name = "phe_duyet")
    @Enumerated(EnumType.ORDINAL)
    PheDuyet pheDuyet;

    @Column(name = "tai_khoan_id", unique = true)
    int taiKhoanId;
}
