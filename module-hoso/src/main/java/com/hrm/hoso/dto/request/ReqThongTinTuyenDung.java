package com.hrm.hoso.dto.request;

import java.time.LocalDateTime;

public record ReqThongTinTuyenDung(
        String ngheNghiepTruocKhiTuyenDung,
        LocalDateTime ngayDuocTuyenDungLanDau,
        int coQuanToChucDonViTuyenDung, //DonVi donVi,
        LocalDateTime ngayVaoCoQuanHienDangCongTac,
        LocalDateTime ngayVaoDangCongSanVietNam,
        LocalDateTime ngayChinhThuc,
        LocalDateTime ngayThamGiaToChucChinhTriXaHoiDauTien,
        String congViecChinhDuocGiao,
        String soTruongCongTac,
        String congViecLamLauNhat
) {
}
