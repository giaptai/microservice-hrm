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

import java.util.UUID;

@Entity
@Table(name = "hoc_van")
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
@JsonIgnoreProperties({"soYeuLyLich"})
public class HocVan extends DateTimeObject {
    @Id
    @Column(name = "ho_so_id")
    UUID id;

    @Column(name = "trinh_do_giao_duc_pho_thong", columnDefinition = "integer")
    int trinhDoGiaoDucPhoThong;

    @Column(name = "trinh_do_chuyen_mon_cao_nhat", columnDefinition = "integer")
    int trinhDoChuyenMon;

    @Column(name = "hoc_ham", columnDefinition = "integer")
    int hocHam;

    @Column(name = "danh_hieu_nha_nuoc", columnDefinition = "integer")
    int danhHieuNhaNuocPhongTang;

    @OneToOne
    @MapsId
    @JoinColumn(foreignKey = @ForeignKey(name = "so_yeu_ly_lich_hoc_van"), name = "ho_so_id", referencedColumnName = "id", columnDefinition = "binary(16)")
    HoSo hoSo;

    public HocVan(int trinhDoGiaoDucPhoThong, int trinhDoChuyenMon, int hocHam, int danhHieuNhaNuocPhongTang, HoSo hoSo) {
        super();
        this.trinhDoGiaoDucPhoThong = trinhDoGiaoDucPhoThong;
        this.trinhDoChuyenMon = trinhDoChuyenMon;
        this.hocHam = hocHam;
        this.danhHieuNhaNuocPhongTang = danhHieuNhaNuocPhongTang;
        this.hoSo = hoSo;
    }

}
