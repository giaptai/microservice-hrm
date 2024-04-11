package com.hrm.hoso.dto.response;

import java.time.LocalDateTime;

public record ResThongTinTuyenDung(
        String ngheNghiepTruocKhiTuyenDung,
        LocalDateTime ngayDuocTuyenDungLanDau,
        LocalDateTime ngayVaoCoQuanHienDangCongTac,
        LocalDateTime ngayVaoDangCongSanVietNam,
        LocalDateTime ngayChinhThuc,
        LocalDateTime ngayThamGiaToChucChinhTriXaHoiDauTien,
        String congViecChinhDuocGiao,
        String soTruongCongTac,
        String congViecLamLauNhat
) {
}
