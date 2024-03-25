package com.hrm.soyeulylich.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.hrm.soyeulylich.dto.DateTimeObject;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
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
@Table(name = "thong_tin_tuyen_dung")
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
@JsonIgnoreProperties({"soYeuLyLich"})
public class ThongTinTuyenDung extends DateTimeObject {
    @Id
    @Column(name = "so_yeu_ly_lich_id")
    UUID id;

    @Column(name = "nghe_nghiep_truoc_khi_duoc_tuyen_dung", columnDefinition = "varchar(100) default 'Không nghề nghiệp'")
    String ngheNghiepTruocKhiTuyenDung;

    @Column(name = "ngay_duoc_tuyen_dung_lan_dau", columnDefinition = "datetime")
    LocalDateTime ngayDuocTuyenDungLanDau;

    @Column(name = "coquan_tochuc_donvi", columnDefinition = "INTEGER")
    int coQuanToChucDonViTuyenDung;

    @Column(name = "ngay_vao_co_quan_hien_dang_cong_tac", columnDefinition = "datetime")
    LocalDateTime ngayVaoCoQuanHienDangCongTac;

    @Column(name = "ngay_vao_dang_cong_san_viet_nam", columnDefinition = "datetime")
    LocalDateTime ngayVaoDangCongSanVietNam;

    @Column(name = "ngay_chinh_thuc", columnDefinition = "datetime")
    LocalDateTime ngayChinhThuc;

    @Column(name = "ngay_tham_gia_to_chuc_chinh_tri_xa_hoi_dau_tien", columnDefinition = "datetime")
    LocalDateTime ngayThamGiaToChucChinhTriXaHoiDauTien;

    @Column(name = "cong_viec_chinh_duoc_giao", columnDefinition = "varchar(150) default ''")
    String congViecChinhDuocGiao;

    @Column(name = "so_truong_cong_tac", columnDefinition = "varchar(150) default 'Không'")
    String soTruongCongTac;

    @Column(name = "cong_viec_lam_lau_nhat", columnDefinition = "varchar(150) default ''")
    String congViecLamLauNhat;

    @OneToOne
    @MapsId
    @JoinColumn(foreignKey = @ForeignKey(name = "so_yeu_ly_lich_thong_tin_tuyen_dung"), name = "so_yeu_ly_lich_id", referencedColumnName = "id", columnDefinition = "binary(16)")
    HoSo hoSo;

    public ThongTinTuyenDung(String ngheNghiepTruocKhiTuyenDung, LocalDateTime ngayDuocTuyenDungLanDau, int coQuanToChucDonViTuyenDung,
                             LocalDateTime ngayVaoCoQuanHienDangCongTac, LocalDateTime ngayVaoDangCongSanVietNam, LocalDateTime ngayChinhThuc,
                             LocalDateTime ngayThamGiaToChucChinhTriXaHoiDauTien, String congViecChinhDuocGiao, String soTruongCongTac,
                             String congViecLamLauNhat, HoSo hoSo) {
        super();
        this.ngheNghiepTruocKhiTuyenDung = ngheNghiepTruocKhiTuyenDung;
        this.ngayDuocTuyenDungLanDau = ngayDuocTuyenDungLanDau;
        this.coQuanToChucDonViTuyenDung = coQuanToChucDonViTuyenDung;
        this.ngayVaoCoQuanHienDangCongTac = ngayVaoCoQuanHienDangCongTac;
        this.ngayVaoDangCongSanVietNam = ngayVaoDangCongSanVietNam;
        this.ngayChinhThuc = ngayChinhThuc;
        this.ngayThamGiaToChucChinhTriXaHoiDauTien = ngayThamGiaToChucChinhTriXaHoiDauTien;
        this.congViecChinhDuocGiao = congViecChinhDuocGiao;
        this.soTruongCongTac = soTruongCongTac;
        this.congViecLamLauNhat = congViecLamLauNhat;
        this.hoSo = hoSo;
    }
}
