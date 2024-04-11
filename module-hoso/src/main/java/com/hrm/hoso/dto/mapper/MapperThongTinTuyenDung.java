package com.hrm.hoso.dto.mapper;

import com.hrm.hoso.dto.response.ResThongTinTuyenDung;
import com.hrm.hoso.models.ThongTinTuyenDung;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class MapperThongTinTuyenDung {
    public ResThongTinTuyenDung mapToResThongTinTuyenDung(ThongTinTuyenDung tuyenDung) {
        if (tuyenDung == null) {
            return null;
        }
        return new ResThongTinTuyenDung(
                tuyenDung.getNgheNghiepTruocKhiTuyenDung(),
                tuyenDung.getNgayDuocTuyenDungLanDau(),
                tuyenDung.getNgayVaoCoQuanHienDangCongTac(),
                tuyenDung.getNgayVaoDangCongSanVietNam(),
                tuyenDung.getNgayChinhThuc(),
                tuyenDung.getNgayThamGiaToChucChinhTriXaHoiDauTien(),
                tuyenDung.getCongViecChinhDuocGiao(),
                tuyenDung.getSoTruongCongTac(),
                tuyenDung.getCongViecLamLauNhat()
        );
    }
}
