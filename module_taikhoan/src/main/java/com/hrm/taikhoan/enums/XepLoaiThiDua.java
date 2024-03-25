package com.hrm.taikhoan.enums;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.stream.Stream;


public enum XepLoaiThiDua {
    XUAT_SAC("Xuất sắc"),
    TOT("Tốt"),
    KHA("Khá"),
    TRUNG_BINH("Trung bình"),
    ;
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    XepLoaiThiDua(String name) {
        this.name = name;
    }

    @Converter(autoApply = true)
    public static class XepLoaiThiDuaConverter implements AttributeConverter<XepLoaiThiDua, String> {

        @Override
        public String convertToDatabaseColumn(XepLoaiThiDua xepLoaiThiDua) {
            if (xepLoaiThiDua == null) {
                return null;
            }
            return xepLoaiThiDua.getName();
        }

        @Override
        public XepLoaiThiDua convertToEntityAttribute(String code) {
            if (code == null) {
                return null;
            }
            return Stream.of(XepLoaiThiDua.values())
                    .filter(c -> c.getName().equals(code))
                    .findFirst()
                    .orElseThrow(IllegalArgumentException::new);
        }
    }
}
