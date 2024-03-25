//package sgu.hrm.module_utilities.models;
//
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
//@Table(name = "don_vi")
//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
//@EqualsAndHashCode(callSuper = true)
//@FieldDefaults(level = AccessLevel.PRIVATE)
//public class DonVi extends DateTimeObject {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(columnDefinition = "INTEGER AUTO_INCREMENT")
//    int id;
//
//    @Column(length = 200, unique = true)
//    String name;
//
//    @ManyToOne
//    @JoinColumn(foreignKey = @ForeignKey(name = "bo_coquan_fk"), name = "bo_coquan", referencedColumnName = "id", columnDefinition = "integer")
//    BoCoQuan boCoQuan;
//
//    public DonVi(String name, BoCoQuan boCoQuan) {
//        this.name = name;
//        this.boCoQuan = boCoQuan;
//    }
//}
