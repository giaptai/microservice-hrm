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
//@Table(name = "bo_coquan")
//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
//@EqualsAndHashCode(callSuper = true)
//@FieldDefaults(level = AccessLevel.PRIVATE)
//public class BoCoQuan extends DateTimeObject {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(columnDefinition = "INTEGER AUTO_INCREMENT")
//    int id;
//
//    @Column(length = 200, unique = true)
//    String name;
//
//    public BoCoQuan(String name) {
//        this.name = name;
//    }
//}
