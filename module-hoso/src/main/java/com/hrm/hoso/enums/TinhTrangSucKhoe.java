package com.hrm.hoso.enums;

import lombok.Getter;

@Getter
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

    public void setName(String name) {
        this.name = name;
    }
}
