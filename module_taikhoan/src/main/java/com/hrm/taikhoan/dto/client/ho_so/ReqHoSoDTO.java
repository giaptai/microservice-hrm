package com.hrm.taikhoan.dto.client.ho_so;

import com.hrm.taikhoan.enums.GioiTinh;
import com.hrm.taikhoan.enums.PheDuyet;
import com.hrm.taikhoan.enums.TinhTrangSucKhoe;
import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record ReqHoSoDTO(
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
        ReqThongTinTuyenDung thongTinTuyenDung,
        ReqQuanSu quanSu,
        int doiTuongChinhSach, //DoiTuongChinhSach doiTuongChinhSach,
        ReqHocVan hocVan, //HocVan
        ReqChucVu chucVu,
        int chucVuKiemNhiem, //ChucVu chucVuKiemNhiem
        int chucVuDangHienTai, //ChucDanhDang chucVuDangHienTai;
        int chucVuDangKiemNhiem, // ChucDanhDang chucVuDangKiemNhiem;
        double tienLuong,
        ReqNgachNhanVien ngach,
        double phuCapChucVu,
        double phuCapKiemNhiem,
        double phuCapKhac,
        ReqViecLam viecLam,
        ReqSucKhoe sucKhoe,
        int taiKhoan,
        PheDuyet pheDuyet,
        LocalDateTime create_at,
        LocalDateTime update_at
) {
    public record ReqThongTinTuyenDung(
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

    public record ReqQuanSu(
            LocalDateTime ngayNhapNgu, //NghiaVuQuanSu quanSu;
            LocalDateTime ngayXuatNgu, //NghiaVuQuanSu quanSu;
            int capBacLoaiQuanHamQuanDoi //NghiaVuQuanSu quanSu;
    ) {
    }

    public record ReqHocVan(
            int trinhDoGiaoDucPhoThong, //TrinhDoGiaoDucPhoThong trinhDoGiaoDucPhoThong,
            int trinhDoChuyenMon, //TrinhDoChuyenMon trinhDoChuyenMon,
            int hocHam, //HocHam hocHam,
            int danhHieuNhaNuocPhongTang //DanhHieuNhaNuocPhongTang danhHieuNhaNuocPhongTang,
    ) {
    }

    public record ReqChucVu(
            int chucVuHienTai, //ChucVu chucVuHienTai
            LocalDateTime ngayBoNhiem,
            LocalDateTime ngayBoNhiemLai,
            String duocQuyHoacChucDanh
    ) {
    }

    public record ReqNgachNhanVien(
            int ngachCongChuc,
            int ngachVienChuc,
            LocalDateTime ngayBoNhiemNgach,
            LocalDateTime ngayHuongLuongNgach,
            float phanTramHuongLuongNgach,
            double phuCapThamNienVuotKhungNgach,
            LocalDateTime ngayHuongPCTNVKNgach
    ) {
    }

    public record ReqViecLam(
            int viTriViecLam,
            LocalDateTime ngayHuongLuongViTriViecLam,
            float phamTramHuongLuong,
            double phuCapThamNienVuotKhung,
            LocalDateTime ngayHuongPCTNVK
    ) {
    }

    public record ReqSucKhoe(
            TinhTrangSucKhoe tinhTrangSucKhoe, //enum,
            float chieuCao,
            float canNang,
            int nhomMau //NhomMau nhomMau
    ) {
    }
}
