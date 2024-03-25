package com.hrm.taikhoan.enums;

public enum TinhTrangSucKhoe {
    YEU("YẾU"),
    TRUNG_BINH("TRUNG BÌNH"),
    KHA("KHÁ"),
    TOT("TỐT"),
    KHOE("KHỎE"),
    ;

    private String name;

    TinhTrangSucKhoe(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
