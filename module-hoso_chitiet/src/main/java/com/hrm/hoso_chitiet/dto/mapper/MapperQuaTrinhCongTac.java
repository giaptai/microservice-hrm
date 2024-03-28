package com.hrm.hoso_chitiet.dto.mapper;

import com.hrm.hoso_chitiet.dto.response.ResQuaTrinhCongTac;
import com.hrm.hoso_chitiet.models.QuaTrinhCongTac;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperQuaTrinhCongTac {
    public ResQuaTrinhCongTac mapToResQuaTrinhCongTac(QuaTrinhCongTac tac) {
        return tac != null ? new ResQuaTrinhCongTac(
                tac.getId(),
                tac.getBatDau(),
                tac.getKetThuc(),
                tac.getDonViCongTacId(),
                tac.getChucDanh(),
                tac.getCreate_at(),
                tac.getUpdate_at()
        ) : null;
    }
}
