//package sgu.hrm.module_utilities.models;
//
//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
//import jakarta.persistence.Column;
//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//import jakarta.persistence.OneToMany;
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
//import java.util.List;
//
//@Entity
//@Table(name = "loai_quan_ham_quan_doi")
//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
//@EqualsAndHashCode(callSuper = true)
//@FieldDefaults(level = AccessLevel.PRIVATE)
//@JsonIgnoreProperties({"capBacLoaiQuanHamQuanDois"})
//public class LoaiQuanHamQuanDoi extends DateTimeObject {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(columnDefinition = "INTEGER")
//    int id;
//
//    @Column(length = 50, unique = true)
//    String name;
//
//    @OneToMany(mappedBy = "loaiQuanHamQuanDoi")
//    List<CapBacLoaiQuanHamQuanDoi> capBacLoaiQuanHamQuanDois;
//
//    public LoaiQuanHamQuanDoi(String name) {
//        this.name = name;
//    }
//}