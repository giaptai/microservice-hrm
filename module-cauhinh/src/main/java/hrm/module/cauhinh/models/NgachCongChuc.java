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
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "ngach_cong_chuc")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class NgachCongChuc extends DateTimeObject {
    @Id
    @Column(columnDefinition = "varchar(10) unique not null")
    String ma;

    @Column(length = 250, unique = true)
    String name;

    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "he_so_luong_cong_chuc_fk"), name = "he_so_luong_cong_chuc_id", referencedColumnName = "id", columnDefinition = "integer")
    HeSoLuongCongChuc heSoLuongCongChucId;

    public NgachCongChuc(String ma, String name, HeSoLuongCongChuc heSoLuongCongChucId) {
        super();
        this.ma = ma;
        this.name = name;
        this.heSoLuongCongChucId = heSoLuongCongChucId;
    }
}
