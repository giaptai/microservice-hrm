package com.hrm.taikhoan.dto.client.ho_so;

import com.hrm.taikhoan.enums.GioiTinh;
import com.hrm.taikhoan.enums.PheDuyet;

import java.time.LocalDateTime;

import java.util.UUID;

import com.hrm.taikhoan.enums.TinhTrangSucKhoe;
import lombok.Builder;

@Builder
public record HoSoDTO(
        UUID id,
        String hovaten,
        GioiTinh gioiTinh,
        String cacTenGoiKhac,
        LocalDateTime sinhNgay,
        String noiSinh,
        String queQuan,
        int danToc, //DanToc danToc,
        int tonGiao, //DanToc danToc,
        String soCCCD,
        LocalDateTime ngayCapCCCD,
        String soDienThoai,
        String soBHXH,
        String soBHYT,
        String noiOHienNay,
        int thanhPhanGiaDinh,
        ResThongTinTuyenDung thongTinTuyenDung,
        ResQuanSu quanSu,
        int doiTuongChinhSach, //DoiTuongChinhSach doiTuongChinhSach,
        ResHocVan hocVan, //HocVan
        ResChucVu chucVu,
        int chucVuKiemNhiem, //ChucVu chucVuKiemNhiem
        int chucVuDangHienTai, //ChucDanhDang chucVuDangHienTai;
        int chucVuDangKiemNhiem, // ChucDanhDang chucVuDangKiemNhiem;
        double tienLuong,
        ResNgachNhanVien ngach,
        double phuCapChucVu,
        double phuCapKiemNhiem,
        double phuCapKhac,
        ResViecLam viecLam,
        ResSucKhoe sucKhoe,
        int taiKhoan,
        PheDuyet pheDuyet,
        LocalDateTime create_at,
        LocalDateTime update_at
) {
    public record ResThongTinTuyenDung(
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
    ) {
    }

    public record ResQuanSu(
            LocalDateTime ngayNhapNgu, //NghiaVuQuanSu quanSu;
            LocalDateTime ngayXuatNgu, //NghiaVuQuanSu quanSu;
            int capBacLoaiQuanHamQuanDoi //NghiaVuQuanSu quanSu;
    ) {
    }

    public record ResHocVan(
            int trinhDoGiaoDucPhoThong, //TrinhDoGiaoDucPhoThong trinhDoGiaoDucPhoThong,
            int trinhDoChuyenMon, //TrinhDoChuyenMon trinhDoChuyenMon,
            int hocHam, //HocHam hocHam,
            int danhHieuNhaNuocPhongTang //DanhHieuNhaNuocPhongTang danhHieuNhaNuocPhongTang,
    ) {
    }

    public record ResChucVu(
            int chucVuHienTai, //ChucVu chucVuHienTai
            LocalDateTime ngayBoNhiem,
            LocalDateTime ngayBoNhiemLai,
            String duocQuyHoacChucDanh
    ) {
    }

    public record ResNgachNhanVien(
            int ngachCongChuc,
            int ngachVienChuc,
            LocalDateTime ngayBoNhiemNgach,
            LocalDateTime ngayHuongLuongNgach,
            float phanTramHuongLuongNgach,
            double phuCapThamNienVuotKhungNgach,
            LocalDateTime ngayHuongPCTNVKNgach
    ) {
    }

    public record ResViecLam(
            int viTriViecLam,
            LocalDateTime ngayHuongLuongViTriViecLam,
            float phamTramHuongLuong,
            double phuCapThamNienVuotKhung,
            LocalDateTime ngayHuongPCTNVK
    ) {
    }

    public record ResSucKhoe(
            TinhTrangSucKhoe tinhTrangSucKhoe, //enum,
            float chieuCao,
            float canNang,
            int nhomMau //NhomMau nhomMau
    ) {
    }
}
