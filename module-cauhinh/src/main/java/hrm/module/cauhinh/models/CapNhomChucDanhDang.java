//package sgu.hrm.module_utilities.models;
//
//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
//import jakarta.persistence.Column;
//import jakarta.persistence.Entity;
//import jakarta.persistence.ForeignKey;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//import jakarta.persistence.JoinColumn;
//import jakarta.persistence.ManyToOne;
//import jakarta.persistence.Table;
//import lombok.AccessLevel;
//import lombok.AllArgsConstructor;
//import lombok.EqualsAndHashCode;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//import lombok.experimental.FieldDefaults;
//import sgu.hrm.module_utilities.models.response.DateTimeObject;
//
//@Entity
//@Table(name = "cap_nhom_chuc_danh_dang")
//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
//@EqualsAndHashCode(callSuper = true)
//@FieldDefaults(level = AccessLevel.PRIVATE)
//@JsonIgnoreProperties({"nhomChucDanhDang"})
//public class CapNhomChucDanhDang extends DateTimeObject {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(columnDefinition = "INTEGER AUTO_INCREMENT")
//    int id;
//
//    @Column(columnDefinition = "varchar(250) unique")
//    String name;
//
//    @ManyToOne
//    @JoinColumn(foreignKey = @ForeignKey(name = "nhom_chuc_danh_dang_fk"), name = "nhom_chuc_danh_dang", referencedColumnName = "id", columnDefinition = "integer")
//    NhomChucDanhDang nhomChucDanhDang;
//
//    public CapNhomChucDanhDang(String name, NhomChucDanhDang nhomChucDanhDang) {
//        super(); // goi thi moi set chu
//        this.name = name;
//        this.nhomChucDanhDang = nhomChucDanhDang;
//    }
//    //danh cho edit
//
//    @Override
//    public void setUpdate_at() {
//        super.setUpdate_at();
//    }
//}
