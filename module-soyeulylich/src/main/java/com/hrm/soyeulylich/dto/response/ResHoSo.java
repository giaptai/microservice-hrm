package com.hrm.soyeulylich.dto.response;

import com.hrm.soyeulylich.enums.GioiTinh;
import com.hrm.soyeulylich.enums.PheDuyet;
import com.hrm.soyeulylich.enums.TinhTrangSucKhoe;
import com.hrm.soyeulylich.models.ChucVuHienTai;
import com.hrm.soyeulylich.models.HoSo;
import com.hrm.soyeulylich.models.HocVan;
import com.hrm.soyeulylich.models.NgachNhanVien;
import com.hrm.soyeulylich.models.NghiaVuQuanSu;
import com.hrm.soyeulylich.models.SucKhoe;
import com.hrm.soyeulylich.models.ThongTinTuyenDung;
import com.hrm.soyeulylich.models.ViecLam;
import lombok.Builder;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Builder
public record ResHoSo(
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
        public static ResThongTinTuyenDung mapToResThongTinTuyenDung(ThongTinTuyenDung tuyenDung) {
            return tuyenDung != null ?
                    new ResThongTinTuyenDung(
                            tuyenDung.getNgheNghiepTruocKhiTuyenDung(),
                            tuyenDung.getNgayDuocTuyenDungLanDau(),
                            tuyenDung.getCoQuanToChucDonViTuyenDung(),
                            tuyenDung.getNgayVaoCoQuanHienDangCongTac(),
                            tuyenDung.getNgayVaoDangCongSanVietNam(),
                            tuyenDung.getNgayChinhThuc(),
                            tuyenDung.getNgayThamGiaToChucChinhTriXaHoiDauTien(),
                            tuyenDung.getCongViecChinhDuocGiao(),
                            tuyenDung.getSoTruongCongTac(),
                            tuyenDung.getCongViecLamLauNhat()
                    ) : null;
        }
    }

    public record ResQuanSu(
            LocalDateTime ngayNhapNgu, //NghiaVuQuanSu quanSu;

            LocalDateTime ngayXuatNgu, //NghiaVuQuanSu quanSu;

            int capBacLoaiQuanHamQuanDoi //NghiaVuQuanSu quanSu;
    ) {
        public static ResQuanSu mapToResQuanSu(NghiaVuQuanSu quanSu) {
            return quanSu != null ?
                    new ResQuanSu(
                            quanSu.getNgayNhapNgu(),
                            quanSu.getNgayXuatNgu(),
                            quanSu.getCapBacLoaiQuanHamQuanDoi()
                    ) : null;
        }
    }

    public record ResHocVan(
            int trinhDoGiaoDucPhoThong, //TrinhDoGiaoDucPhoThong trinhDoGiaoDucPhoThong,

            int trinhDoChuyenMon, //TrinhDoChuyenMon trinhDoChuyenMon,

            int hocHam, //HocHam hocHam,

            int danhHieuNhaNuocPhongTang //DanhHieuNhaNuocPhongTang danhHieuNhaNuocPhongTang,
    ) {
        public static ResHocVan mapToResHocVan(HocVan hocVan) {
            return hocVan != null ?
                    new ResHocVan(
                            hocVan.getTrinhDoGiaoDucPhoThong(),
                            hocVan.getTrinhDoChuyenMon(),
                            hocVan.getHocHam(),
                            hocVan.getDanhHieuNhaNuocPhongTang()
                    ) : null;
        }
    }

    public record ResChucVu(
            int chucVuHienTai, //ChucVu chucVuHienTai

            LocalDateTime ngayBoNhiem,

            LocalDateTime ngayBoNhiemLai,

            String duocQuyHoacChucDanh
    ) {
        public static ResChucVu mapToResChucVu(ChucVuHienTai chucVu) {
            return chucVu != null ?
                    new ResChucVu(
                            chucVu.getChucVu(),
                            chucVu.getNgayBoNhiem(),
                            chucVu.getNgayBoNhiemLai(),
                            chucVu.getDuocQuyHoacChucDanh()
                    ) : null;
        }
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
        public static ResNgachNhanVien mapToResNgachNhanVien(NgachNhanVien ngach) {
            return ngach != null ?
                    new ResNgachNhanVien(
                            ngach.getNgachCongChuc(),
                            ngach.getNgachVienChuc(),
                            ngach.getNgayBoNhiemNgach(),
                            ngach.getNgayHuongLuongNgach(),
                            ngach.getPhanTramHuongLuongNgach(),
                            ngach.getPhuCapThamNienVuotKhungNgach(),
                            ngach.getNgayHuongPCTNVKNgach()
                    ) : null;
        }
    }

    public record ResViecLam(
            int viTriViecLam,

            LocalDateTime ngayHuongLuongViTriViecLam,

            float phamTramHuongLuong,

            double phuCapThamNienVuotKhung,

            LocalDateTime ngayHuongPCTNVK
    ) {
        public static ResViecLam mapToResViecLam(ViecLam viecLam) {
            return viecLam != null ?
                    new ResViecLam(
                            viecLam.getViTriViecLam(),
                            viecLam.getNgayHuongLuongTheoViTriViecLam(),
                            viecLam.getPhamTramHuongLuong(),
                            viecLam.getPhuCapThamNienVuotKhung(),
                            viecLam.getNgayHuongPCTNVK()
                    ) : null;
        }
    }

    public record ResSucKhoe(
            TinhTrangSucKhoe tinhTrangSucKhoe, //enum,

            float chieuCao,

            float canNang,

            int nhomMau //NhomMau nhomMau
    ) {
        public static ResSucKhoe mapToResSucKhoe(SucKhoe sucKhoe) {
            return sucKhoe != null ?
                    new ResSucKhoe(
                            sucKhoe.getTinhTrangSucKhoe(),
                            sucKhoe.getChieuCao(),
                            sucKhoe.getCanNang(),
                            sucKhoe.getNhomMau()
                    ) : null;
        }
    }

    public static ResHoSo mapToResHoSo(HoSo hoSo) {
        ThongTinTuyenDung tuyenDung = hoSo.getThongTinTuyenDung();
        NghiaVuQuanSu quanSu = hoSo.getQuanSu();
        HocVan hocVan = hoSo.getHocVan();
        ChucVuHienTai chucVu = hoSo.getChucVuHienTai();
        NgachNhanVien ngach = hoSo.getNgach();
        ViecLam viecLam = hoSo.getViecLam();
        SucKhoe sucKhoe = hoSo.getSucKhoe();
        return new ResHoSo(
                hoSo.getId(),
                hoSo.getHoVaTen(),
                hoSo.getGioiTinh(),
                hoSo.getCacTenGoiKhac(),
                hoSo.getSinhNgay(),
                hoSo.getNoiSinh(),
                hoSo.getQueQuan(),
                hoSo.getDanToc(),
                hoSo.getTonGiao(),
                hoSo.getSoCCCD(),
                hoSo.getNgayCapCCCD(),
                hoSo.getSoDienThoai(),
                hoSo.getSoBHXH(),
                hoSo.getSoBHYT(),
                hoSo.getNoiOHienNay(),
                hoSo.getThanhPhanGiaDinh(),
                ResThongTinTuyenDung.mapToResThongTinTuyenDung(tuyenDung),
                ResQuanSu.mapToResQuanSu(quanSu),
                hoSo.getDoiTuongChinhSach(),
                ResHocVan.mapToResHocVan(hocVan),
                ResChucVu.mapToResChucVu(chucVu),
                hoSo.getChucVuKiemNhiem(),
                hoSo.getChucVuDangHienTai(),
                hoSo.getChucVuDangKiemNhiem(),
                hoSo.getTienLuong(),
                ResNgachNhanVien.mapToResNgachNhanVien(ngach),
                hoSo.getPhuCapChucVu(),
                hoSo.getPhuCapKiemNhiem(),
                hoSo.getPhuCapKhac(),
                ResViecLam.mapToResViecLam(viecLam),
                ResSucKhoe.mapToResSucKhoe(sucKhoe),
                hoSo.getTaiKhoan(),
                hoSo.getPheDuyet(),
                hoSo.getUpdate_at(),
                hoSo.getUpdate_at()
        );
    }
}
