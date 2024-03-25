package hrm.module.cauhinh.models;

import hrm.module.cauhinh.dto.DateTimeObject;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
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
@Table(name = "vi_tri_viec_lam")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ViTriViecLam extends DateTimeObject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "INTEGER AUTO_INCREMENT")
    int id;

    @Column(length = 100, unique = true)
    String name;

    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "bac_luong_fk"), name = "bac_luong", referencedColumnName = "id", columnDefinition = "INTEGER")
    BacLuong bacLuong;

    @Column(columnDefinition = "double default 0")
    double tienLuong;

    public ViTriViecLam(String name, BacLuong bacLuong, double tienLuong) {
        super();
        this.name = name;
        this.bacLuong = bacLuong;
        this.tienLuong = tienLuong;
    }
}
