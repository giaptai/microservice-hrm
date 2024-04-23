package com.hrm.hoso_chitiet.enums;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import lombok.Getter;

import java.util.stream.Stream;

@Getter
public enum XacNhan {
    CHO_PHE_DUYET(0, "CHỜ PHÊ DUYỆT"),
    DA_PHE_DUYET(1, "ĐÃ PHÊ DUYỆT"),
    TU_CHOI(2, "TỪ CHỐI")
    ;
    private int id;
    private String name;

    XacNhan(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
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
