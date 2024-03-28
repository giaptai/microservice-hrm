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
@Table(name = "he_so_luong_vien_chuc")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
//@IdClass(HeSoLuongVienChucId.class) // Add this line
public class HeSoLuongVienChuc extends DateTimeObject {
    @Id
    @Column(name="id", columnDefinition = "integer auto_increment")
    int id;

//    @Id
    @ManyToOne
//    @MapsId("nhom_loai_vien_chuc")
    @JoinColumn(foreignKey = @ForeignKey(name = "nhom_vien_chuc_fk"), name = "nhom_vien_chuc_id", columnDefinition = "INTEGER", referencedColumnName = "id")
//    @JsonIgnore
    NhomVienChuc nhomVienChucId;

//    @Id
    @ManyToOne
//    @MapsId("bac_luong")
    @JoinColumn(foreignKey = @ForeignKey(name = "bac_luong_vien_chuc_fk"), name = "bac_luong_id", columnDefinition = "INTEGER", referencedColumnName = "id")
    BacLuong bacLuongId;

    @Column(name = "he_so", columnDefinition = "FLOAT")
    float heSo;

    public HeSoLuongVienChuc(NhomVienChuc nhomVienChucId, BacLuong bacLuongId, float heSo) {
        super();
        this.nhomVienChucId = nhomVienChucId;
        this.bacLuongId = bacLuongId;
        this.heSo = heSo;
    }
}
