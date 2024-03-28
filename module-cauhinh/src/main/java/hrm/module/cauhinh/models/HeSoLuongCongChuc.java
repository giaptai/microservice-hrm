package hrm.module.cauhinh.models;

import hrm.module.cauhinh.dto.DateTimeObject;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "he_so_luong_cong_chuc")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
//@IdClass(HeSoLuongCongChucId.class)
public class HeSoLuongCongChuc extends DateTimeObject {
//    @EmbeddedId
//    HeSoLuongCongChucId heSoLuongCongChucId;

    @Id
    @Column(name="id", columnDefinition = "integer auto_increment")
    int id;

    //    @Id
    @ManyToOne
////    @MapsId("nhom_loai_cong_chuc")
    @JoinColumn(foreignKey = @ForeignKey(name = "nhom_cong_chuc_fk"),name = "nhom_cong_chuc_id", columnDefinition = "INTEGER", referencedColumnName = "id")
////    @JsonIgnore
//    @JsonIgnoreProperties({"trangThai", "id"})
    NhomCongChuc nhomCongChucId;
    //
//    @Id
    @ManyToOne
////    @MapsId("bac_luong")
    @JoinColumn(foreignKey = @ForeignKey(name = "bac_luong_cong_chuc_fk"), name = "bac_luong_id", columnDefinition = "INTEGER", referencedColumnName = "id")
////    @JsonIgnore
//    @JsonIgnoreProperties({"trangThai", "id"})
    BacLuong bacLuongId;

    @Column(name = "he_so", columnDefinition = "FLOAT")
    float heSo;

    public HeSoLuongCongChuc(NhomCongChuc nhomCongChucId, BacLuong bacLuongId, float heSo) {
        super();
        this.nhomCongChucId = nhomCongChucId;
        this.bacLuongId = bacLuongId;
        this.heSo = heSo;
    }
}