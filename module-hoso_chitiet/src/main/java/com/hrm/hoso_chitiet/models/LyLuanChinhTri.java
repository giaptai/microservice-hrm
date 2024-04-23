package com.hrm.hoso_chitiet.models;

import com.hrm.hoso_chitiet.enums.XacNhan;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
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
@Table(name = "ly_luan_chinh_tri",indexes = {
        @Index(name = "ho_so_idx", columnList = "ho_so_id"),
        @Index(name = "create_at_idx", columnList = "createAt"),
        @Index(name = "update_at_idx", columnList = "updateAt")
})
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class LyLuanChinhTri extends DateTimeObject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "INTEGER AUTO_INCREMENT")
    int id;

    @Column(name = "bat_dau", columnDefinition = "datetime")
    LocalDateTime batDau;

    @Column(name = "ket_thuc", columnDefinition = "datetime")
    LocalDateTime ketThuc;

    @Column(name = "coquan_tochuc_donvi_id", columnDefinition = "INTEGER")
    int tenCoSoDaoTaoId;

    @Column(name = "hinh_thuc_dao_tao", columnDefinition = "varchar(50)")
    String hinhThucDaoTao;

    @Column(name = "van_bang_duoc_cap", columnDefinition = "varchar(50)")
    String vanBangDuocCap;

    @Enumerated
    @Column(name = "xac_nhan")
    XacNhan xacNhan;

    @Column(name = "ho_so_id", columnDefinition = "binary(16)")
    UUID hoSoId;

    public LyLuanChinhTri(LocalDateTime batDau, LocalDateTime ketThuc, int tenCoSoDaoTaoId, String hinhThucDaoTao, String vanBangDuocCap, XacNhan xacNhan, UUID hoSoId) {
        super();
        this.batDau = batDau;
        this.ketThuc = ketThuc;
        this.tenCoSoDaoTaoId = tenCoSoDaoTaoId;
        this.hinhThucDaoTao = hinhThucDaoTao;
        this.vanBangDuocCap = vanBangDuocCap;
        this.xacNhan = xacNhan;
        this.hoSoId = hoSoId;
    }
}