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
@Table(name = "nghia_vu_quan_su")
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
@JsonIgnoreProperties({"soYeuLyLich"})
public class NghiaVuQuanSu extends DateTimeObject {
    @Id
    @Column(name = "ho_so_id")
    UUID id;

    @Column(name = "ngay_nhap_ngu", columnDefinition = "datetime")
    LocalDateTime ngayNhapNgu;

    @Column(name = "ngay_xuat_ngu", columnDefinition = "datetime")
    LocalDateTime ngayXuatNgu;

    @Column(name = "cap_bac_loai_quan_ham_quan_doi_id", columnDefinition = "integer")
    int quanHamCaoNhatId;

    @OneToOne
    @MapsId
    @JoinColumn(name = "ho_so_id")
    private HoSo hoSoId;

    public NghiaVuQuanSu(LocalDateTime ngayNhapNgu, LocalDateTime ngayXuatNgu, int quanHamCaoNhatId, HoSo hoSoId) {
        super();
        this.ngayNhapNgu = ngayNhapNgu;
        this.ngayXuatNgu = ngayXuatNgu;
        this.quanHamCaoNhatId = quanHamCaoNhatId;
        this.hoSoId = hoSoId;
    }
}
