package com.hrm.taikhoan.models;

import com.hrm.taikhoan.dto.DateTimeObject;
import com.hrm.taikhoan.enums.RoleTaiKhoan;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

import java.util.UUID;

@Entity
@Table(name = "taikhoan", indexes = {@Index(name = "create_at_idx", columnList = "createAt"),
        @Index(name = "update_at_idx", columnList = "updateAt")})
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TaiKhoan extends DateTimeObject {
    @Id
    @Column(columnDefinition = "INTEGER AUTO_INCREMENT")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column(name = "ho_va_ten", columnDefinition = "varchar(50) default ''")
    String hoVaTen;

    @Column(columnDefinition = "varchar(30) unique")
    String username;

    @Column(columnDefinition = "varchar(20)")
    String password;

    @Column(columnDefinition = "varchar(250) unique")
    String email;

    @Column(name = "role")
    @Enumerated(value = EnumType.STRING)
    RoleTaiKhoan roleTaiKhoan;

    @Column(name = "ho_so_id", columnDefinition = "binary(16) unique")
    UUID hoSoId;
}
