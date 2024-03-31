package com.hrm.taikhoan.dto.client.ho_so;

import java.time.LocalDateTime;

public record ThongTinTuyenDungDTO (
    String ngheNghiepTruocKhiTuyenDung,
    LocalDateTime ngayDuocTuyenDungLanDau,
    int coQuanToChucDonViTuyenDung,
    LocalDateTime ngayVaoCoQuanHienDangCongTac,
    LocalDateTime ngayVaoDangCongSanVietNam,
    LocalDateTime ngayChinhThuc,
    LocalDateTime ngayThamGiaToChucChinhTriXaHoiDauTien,
    String congViecChinhDuocGiao,
    String soTruongCongTac,
    String congViecLamLauNhat
){}
