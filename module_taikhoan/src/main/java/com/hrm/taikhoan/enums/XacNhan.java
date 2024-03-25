package com.hrm.taikhoan.enums;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.stream.Stream;

public enum XacNhan {
    CHO_XAC_NHAN(0, "CHỜ XÁC NHẬN"),
    XAC_NHAN(1, "ĐÃ XÁC NHÂN"),
    TU_CHOI(2, "TỪ CHỐI"),
    QUA_HAN(3, "QUÁ HẠN"),
    ;
    private int id;
    private String name;

    XacNhan(int id, String name) {
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

    @Converter(autoApply = false)
    public static class XacNhanConverter implements AttributeConverter<XacNhan, String> {

        @Override
        public String convertToDatabaseColumn(XacNhan attribute) {
            return attribute != null ? attribute.name() : null;
        }

        @Override
        public XacNhan convertToEntityAttribute(String dbData) {
            return dbData != null ?
                    Stream.of(XacNhan.values())
                            .filter(c -> c.getName()
                                    .equals(dbData))
                            .findFirst()
                            .orElseThrow(IllegalArgumentException::new) :
                    null;
        }
    }
}
