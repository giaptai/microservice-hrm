package com.hrm.hoso.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.hrm.hoso.dto.DateTimeObject;
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
@Table(name = "ngach_nhan_vien")
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
@JsonIgnoreProperties({"soYeuLyLich"})
public class NgachNhanVien extends DateTimeObject {
    @Id
    @Column(name = "ho_so_id")
    UUID id;

    @Column(name = "ngach_cong_chuc_id", columnDefinition = "INTEGER")
    int ngachCongChucId;

    @Column(name = "ngach_vien_chuc_id", columnDefinition = "INTEGER")
    int ngachVienChucId;

    @Column(name = "ngay_bo_nhiem_ngach", columnDefinition = "datetime")
    LocalDateTime ngayBoNhiemNgach;

    @Column(name = "ngay_huong_luong_ngach", columnDefinition = "datetime")
    LocalDateTime ngayHuongLuongNgach;

    @Column(name = "phan_tram_huong_luong_ngach", columnDefinition = "float default 1.0")
    float phanTramHuongLuongNgach;

    @Column(name = "phu_cap_tham_nien_vuot_khung_ngach", columnDefinition = "double default 0.0")
    double phuCapThamNienVuotKhungNgach;

    @Column(name = "ngay_huong_PCTNVK_ngach", columnDefinition = "datetime")
    LocalDateTime ngayHuongPCTNVKNgach;

    @OneToOne
    @MapsId
    @JoinColumn(foreignKey = @ForeignKey(name = "ho_so_ngach"), name = "ho_so_id", referencedColumnName = "id", columnDefinition = "binary(16)")
    HoSo hoSoId;

    public NgachNhanVien(int ngachCongChucId, int ngachVienChucId, LocalDateTime ngayBoNhiemNgach,
                         LocalDateTime ngayHuongLuongNgach, float phanTramHuongLuongNgach, double phuCapThamNienVuotKhungNgach,
                         LocalDateTime ngayHuongPCTNVKNgach, HoSo hoSoId) {
        super();
        this.ngachCongChucId = ngachCongChucId;
        this.ngachVienChucId = ngachVienChucId;
        this.ngayBoNhiemNgach = ngayBoNhiemNgach;
        this.ngayHuongLuongNgach = ngayHuongLuongNgach;
        this.phanTramHuongLuongNgach = phanTramHuongLuongNgach;
        this.phuCapThamNienVuotKhungNgach = phuCapThamNienVuotKhungNgach;
        this.ngayHuongPCTNVKNgach = ngayHuongPCTNVKNgach;
        this.hoSoId = hoSoId;
    }
}
