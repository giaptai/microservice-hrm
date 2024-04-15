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
@Table(name="chuc_vu_kiem_nhiem")
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@FieldDefaults(level = AccessLevel.PRIVATE)
//@JsonIgnoreProperties({"hoSoId"})
public class ChucVuKiemNhiem extends DateTimeObject {
    @Id
    @Column(name = "ho_so_id")
    UUID id;

    @Column(name = "chuc_vu_kiem_nhiem_id", columnDefinition = "integer")
    int chucVuId;

    @Column(name = "ngay_bo_nhiem", columnDefinition = "datetime")
    LocalDateTime ngayBoNhiem;

    @Column(name = "phu_cap_kiem_nhiem", columnDefinition = "double default 0.0")
    double phuCapKiemNhiem;

    @Column(name = "phu_cap_khac", columnDefinition = "double default 0.0") //chuc vu kiem nhiem
    double phuCapKhac;

    @OneToOne
    @MapsId
    @JoinColumn(name = "ho_so_id")
    HoSo hoSoId;

    public ChucVuKiemNhiem(int chucVuId, LocalDateTime ngayBoNhiem, double phuCapKiemNhiem, double phuCapKhac, HoSo hoSoId) {
        super();
        this.chucVuId = chucVuId;
        this.ngayBoNhiem = ngayBoNhiem;
        this.phuCapKiemNhiem = phuCapKiemNhiem;
        this.phuCapKhac = phuCapKhac;
        this.hoSoId = hoSoId;
    }
}
