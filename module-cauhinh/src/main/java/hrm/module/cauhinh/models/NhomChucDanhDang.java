//package sgu.hrm.module_utilities.models;
//
//import jakarta.persistence.Column;
//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
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
//@Table(name = "nhom_chuc_danh_dang")
//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
//@EqualsAndHashCode(callSuper = true)
//@FieldDefaults(level = AccessLevel.PRIVATE)
//public class NhomChucDanhDang extends DateTimeObject {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(columnDefinition = "INTEGER AUTO_INCREMENT")
//    int id;
//
//    @Column(columnDefinition = "varchar(250) unique")
//    String name;
//
//    public NhomChucDanhDang(String name) {
//        super(); // goi thi moi set chu
//        this.name = name;
//    }
//    //danh cho edit
//
//    @Override
//    public void setUpdate_at() {
//        super.setUpdate_at();
//    }
//}
