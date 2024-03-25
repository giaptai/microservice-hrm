package com.hrm.taikhoan.enums;

import lombok.Getter;

@Getter
public enum RoleTaiKhoan {

    ADMIN("QUẢN LÝ"),

    EMPLOYEE("NHÂN VIÊN"),

    ;
    private String name;

    RoleTaiKhoan(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
