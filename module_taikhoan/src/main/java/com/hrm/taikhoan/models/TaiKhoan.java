package com.hrm.taikhoan.models;

import com.hrm.taikhoan.dto.DateTimeObject;
import com.hrm.taikhoan.enums.RoleTaiKhoan;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collection;
import java.util.UUID;
import java.util.stream.Collectors;

@Entity
@Table(name = "taikhoan")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TaiKhoan extends DateTimeObject implements UserDetails {
    @Id
    @Column(columnDefinition = "INTEGER AUTO_INCREMENT")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column(name = "ho_va_ten", columnDefinition = "varchar(50) default ''")
    String hoVaTen;

    @Column(name = "so_CCCD", columnDefinition = "varchar(15) unique")
    String soCCCD;

    @Column(columnDefinition = "varchar(30) unique")
    String username;

    @Column(columnDefinition = "varchar(20)")
    String password;

    @Column(columnDefinition = "varchar(250) not null default ''")
    String email;

    @Column(name = "role")
    @Enumerated(value = EnumType.STRING)
    RoleTaiKhoan roleTaiKhoan;

    @Column(name = "ho_so_id", columnDefinition = "binary(16) unique")
    UUID hoSoId;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
//        return List.of(new SimpleGrantedAuthority(roleTaiKhoan.getName()));
        return Arrays.stream(RoleTaiKhoan.values())
                .map(role -> new SimpleGrantedAuthority(role.name()))
                .toList();
    }

    //ko can getPassword getUsername do @Data no lam roi nhưng tao vẫn làm
    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return this.isTrangThai();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
