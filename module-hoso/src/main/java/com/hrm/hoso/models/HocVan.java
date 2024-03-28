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

    @Column(name = "trinh_do_giao_duc_pho_thong_id", columnDefinition = "integer")
    int trinhDoGiaoDucPhoThongId;

    @Column(name = "trinh_do_chuyen_mon_id", columnDefinition = "integer")
    int trinhDoChuyenMonCaoNhatId;

    @Column(name = "hoc_ham_id", columnDefinition = "integer")
    int hocHamId;

    @Column(name = "danh_hieu_nha_nuoc_id", columnDefinition = "integer")
    int danhHieuNhaNuocPhongTangId;

    @OneToOne
    @MapsId
    @JoinColumn(foreignKey = @ForeignKey(name = "ho_so_hoc_van"), name = "ho_so_id", referencedColumnName = "id", columnDefinition = "binary(16)")
    HoSo hoSoId;

    public HocVan(int trinhDoGiaoDucPhoThongId, int trinhDoChuyenMonCaoNhatId, int hocHamId, int danhHieuNhaNuocPhongTangId, HoSo hoSoId) {
        super();
        this.trinhDoGiaoDucPhoThongId = trinhDoGiaoDucPhoThongId;
        this.trinhDoChuyenMonCaoNhatId = trinhDoChuyenMonCaoNhatId;
        this.hocHamId = hocHamId;
        this.danhHieuNhaNuocPhongTangId = danhHieuNhaNuocPhongTangId;
        this.hoSoId = hoSoId;
    }

}
