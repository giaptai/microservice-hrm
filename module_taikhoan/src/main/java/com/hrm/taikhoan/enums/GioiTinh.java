package com.hrm.taikhoan.enums;

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
