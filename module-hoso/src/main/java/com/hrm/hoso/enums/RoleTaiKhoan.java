package com.hrm.hoso.enums;

import lombok.Getter;

@Getter
public enum RoleTaiKhoan {
    GOD("THẦN"),
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
