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
    @Column(name = "so_yeu_ly_lich_id")
    UUID id;

    @Column(name = "ngay_nhap_ngu", columnDefinition = "datetime")
    LocalDateTime ngayNhapNgu;

    @Column(name = "ngay_xuat_ngu", columnDefinition = "datetime")
    LocalDateTime ngayXuatNgu;

    @Column(name = "quan_ham_cao_nhat", columnDefinition = "integer")
    int capBacLoaiQuanHamQuanDoi;

    @OneToOne
    @MapsId
    @JoinColumn(name = "so_yeu_ly_lich_id")
    private HoSo hoSo;

    public NghiaVuQuanSu(LocalDateTime ngayNhapNgu, LocalDateTime ngayXuatNgu, int capBacLoaiQuanHamQuanDoi, HoSo hoSo) {
        super();
        this.ngayNhapNgu = ngayNhapNgu;
        this.ngayXuatNgu = ngayXuatNgu;
        this.capBacLoaiQuanHamQuanDoi = capBacLoaiQuanHamQuanDoi;
        this.hoSo = hoSo;
    }
}
