package hrm.module.cauhinh.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
@Table(name = "nhom_vien_chuc")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
@JsonIgnoreProperties({"loaiVienChuc"})
public class NhomVienChuc extends DateTimeObject {
    @Id
    @Column(columnDefinition = "INTEGER AUTO_INCREMENT")
    int id;

    @Column(length = 6, unique = true)
    String name;

    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "loai_vien_chuc_fk"), name = "loai_vien_chuc", referencedColumnName = "id", columnDefinition = "INTEGER")
    LoaiVienChuc loaiVienChuc;

    public NhomVienChuc(String name, LoaiVienChuc loaiVienChuc) {
        super();
        this.name = name;
        this.loaiVienChuc = loaiVienChuc;
    }
}
