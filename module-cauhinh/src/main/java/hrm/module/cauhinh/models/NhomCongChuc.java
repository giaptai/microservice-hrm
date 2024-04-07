package hrm.module.cauhinh.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Table(name = "nhom_cong_chuc")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class NhomCongChuc extends DateTimeObject {
    @Id
    @Column(columnDefinition = "INTEGER AUTO_INCREMENT")
    int id;

    @Column(length = 6, unique = true)
    String name;

//    @OneToMany(mappedBy = "nhomLoaiCongChuc")
//    List<HeSoLuongCongChuc> heSoLuongCongChucs;

    @ManyToOne
    //name là tên cột chứa khóa ngoại tron sql
    //referencedColumnName nghĩa là lấy theo tên của trường trong class
    @JoinColumn(foreignKey = @ForeignKey(name = "loai_cong_chuc_fk"),name = "loai_cong_chuc_id", referencedColumnName = "id", columnDefinition = "INTEGER")
    LoaiCongChuc loaiCongChucId;

    public NhomCongChuc(String name, LoaiCongChuc loaiCongChucId) {
        super();
        this.name = name;
        this.loaiCongChucId = loaiCongChucId;
    }
}