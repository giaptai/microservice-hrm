package com.hrm.hoso.enums;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import lombok.Getter;

import java.util.stream.Stream;

@Getter
public enum XepLoaiChuyenMon {
    LOAI_A("Hoàn thành xuất sắc nhiệm vụ"),
    LOAI_B("Hoàn thành tốt nhiệm vụ"),
    LOAI_C("Hoàn thành nhiệm vụ"),
    LOAI_D("Không hoàn thành nhiệm vụ"),
    ;
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    XepLoaiChuyenMon(String name) {
        this.name = name;
    }

    @Converter(autoApply = true)
    public static class XepLoaiChuyenMonConverter implements AttributeConverter<XepLoaiChuyenMon, String> {
        @Override
        public String convertToDatabaseColumn(XepLoaiChuyenMon xepLoaiChuyenMon) {
            if (xepLoaiChuyenMon == null) {
                return null;
            }
            return xepLoaiChuyenMon.name();
        }

        @Override
        public XepLoaiChuyenMon convertToEntityAttribute(String code) {
            if (code == null) {
                return null;
            }

            return Stream.of(XepLoaiChuyenMon.values())
                    .filter(c -> c.getName().equals(code))
                    .findFirst()
                    .orElseThrow(IllegalArgumentException::new);
        }
    }
}
