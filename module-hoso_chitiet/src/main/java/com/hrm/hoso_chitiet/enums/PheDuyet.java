package com.hrm.hoso_chitiet.enums;

import lombok.Getter;

@Getter
public enum PheDuyet {
    CHO_PHE_DUYET(0, "CHỜ PHÊ DUYỆT"),
    DA_PHE_DUYET(1, "ĐÃ PHÊ DUYỆT"),
    TU_CHOI(2, "TỪ CHỐI"),
    QUA_HAN(3, "QUÁ HẠN"),
    ;
    private int id;
    private String name;

    PheDuyet(int id, String name) {
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
