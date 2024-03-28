package com.hrm.hoso.enums;

import lombok.Getter;

@Getter
public enum GioiTinh {
    NAM(0, "NAM"),
    NU(1, "NỮ"),
    ;
    private int id;
    private String name;

    GioiTinh(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}
