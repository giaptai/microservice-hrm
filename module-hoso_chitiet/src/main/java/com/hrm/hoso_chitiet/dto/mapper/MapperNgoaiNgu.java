package com.hrm.hoso_chitiet.dto.mapper;

import com.hrm.hoso_chitiet.client.coquan_tochuc_donvi.CoQuanToChucDonViClient;
import com.hrm.hoso_chitiet.client.ho_so.HoSoClient;
import com.hrm.hoso_chitiet.client.ho_so.ResHoSoTomTatClient;
import com.hrm.hoso_chitiet.dto.response.ResNgoaiNgu;
import com.hrm.hoso_chitiet.models.NgoaiNgu;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class MapperNgoaiNgu {
    final CoQuanToChucDonViClient coQuanToChucDonViClient;
    final HoSoClient hoSoClient;

    public ResNgoaiNgu mapToResNgoaiNgu(NgoaiNgu ngu) {
        if (ngu != null) {
            ResHoSoTomTatClient tomTatClient = hoSoClient.getHoSoNhanVienId(ngu.getHoSoId());
            return new ResNgoaiNgu(
                    ngu.getId(),
                    ngu.getBatDau(),
                    ngu.getKetThuc(),
                    ngu.getTenCoSoDaoTaoId(),
                    coQuanToChucDonViClient.getName(ngu.getTenCoSoDaoTaoId()),
                    ngu.getTenNgoaiNgu(),
                    ngu.getChungChiDuocCap(),
                    ngu.getDiemSo(),
                    ngu.getXacNhan(),
                    ngu.getHoSoId(),
                    tomTatClient.hoVaTen(),
                    tomTatClient.soCCCD(),
                    ngu.getCreateAt(),
                    ngu.getUpdateAt());
        } else return null;
    }
}
