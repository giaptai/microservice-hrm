package com.hrm.hoso.dto.mapper;

import com.hrm.hoso.dto.response.ResHoSoTomTat;
import com.hrm.hoso.models.HoSo;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class MapperHoSoTomTat {
    public ResHoSoTomTat mapToResHoSoTomTat(HoSo hoSo) {
        if (hoSo == null) {
            return null;
        }
        return new ResHoSoTomTat(
                hoSo.getId(),
                hoSo.getHoVaTen(),
                hoSo.getSoCCCD()
        );
    }
}
