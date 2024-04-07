package com.hrm.hoso_chitiet.dto.mapper;

import com.hrm.hoso_chitiet.client.coquan_tochuc_donvi.CoQuanToChucDonViClient;
import com.hrm.hoso_chitiet.dto.response.ResQuaTrinhCongTac;
import com.hrm.hoso_chitiet.models.QuaTrinhCongTac;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class MapperQuaTrinhCongTac {
    final CoQuanToChucDonViClient coQuanToChucDonViClient;
    public ResQuaTrinhCongTac mapToResQuaTrinhCongTac(QuaTrinhCongTac tac) {
        return tac != null ? new ResQuaTrinhCongTac(
                tac.getId(),
                tac.getBatDau(),
                tac.getKetThuc(),
                tac.getDonViCongTacId(),
                coQuanToChucDonViClient.getName(tac.getDonViCongTacId()),
                tac.getChucDanh(),
                tac.getHoSoId(),
                tac.getCreate_at(),
                tac.getUpdate_at()
        ) : null;
    }
}
