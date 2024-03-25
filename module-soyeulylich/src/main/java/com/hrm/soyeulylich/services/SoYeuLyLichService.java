package com.hrm.soyeulylich.services;

import com.hrm.soyeulylich.dto.request.ReqDSSoYeuLyLich;
import com.hrm.soyeulylich.dto.request.ReqHoSo;
import com.hrm.soyeulylich.dto.request.ReqSoYeuLyLich;
import com.hrm.soyeulylich.enums.PheDuyet;
import com.hrm.soyeulylich.models.ChucVuHienTai;
import com.hrm.soyeulylich.models.HoSo;
import com.hrm.soyeulylich.models.HocVan;
import com.hrm.soyeulylich.models.NgachNhanVien;
import com.hrm.soyeulylich.models.NghiaVuQuanSu;
import com.hrm.soyeulylich.models.SucKhoe;
import com.hrm.soyeulylich.models.ThongTinTuyenDung;
import com.hrm.soyeulylich.models.ViecLam;
import com.hrm.soyeulylich.repository.ChucVuHienTaiRepository;
import com.hrm.soyeulylich.repository.HocVanRepository;
import com.hrm.soyeulylich.repository.NgachRepository;
import com.hrm.soyeulylich.repository.NghiaVuQuanSuRepository;
import com.hrm.soyeulylich.repository.SoYeuLyLichRepository;
import com.hrm.soyeulylich.repository.SucKhoeRepository;
import com.hrm.soyeulylich.repository.ThongTinTuyenDungRepository;
import com.hrm.soyeulylich.repository.ViecLamRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.UUID;
import java.util.regex.Pattern;

@Service
@RequiredArgsConstructor // tự tạo constructor với filed là final hoặc annotation not null
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SoYeuLyLichService implements ISoYeuLyLichService {
    final SoYeuLyLichRepository soYeuLyLichRepository;
    final ChucVuHienTaiRepository chucVuHienTaiRepository;
    final HocVanRepository hocVanRepository;
    final NgachRepository ngachRepository;
    final NghiaVuQuanSuRepository nghiaVuQuanSuRepository;
    final SucKhoeRepository sucKhoeRepository;
    final ThongTinTuyenDungRepository thongTinTuyenDungRepository;
    final ViecLamRepository viecLamRepository;

//    final DanTocRepository danTocRepository;
//    final ThanhPhanGiaDinhRepository thanhPhanGiaDinhRepository;
//    final CoQuanToChucDonViRepository coQuanToChucDonViRepository;
//    final CapBacLoaiQuanHamQuanDoiRepository capBacLoaiQuanHamQuanDoiRepository;
//    final DoiTuongChinhSachRepository doiTuongChinhSachRepository;
//    final TrinhDoGiaoDucPhoThongRepository trinhDoGiaoDucPhoThongRepository;
//    final TrinhDoChuyenMonRepository trinhDoChuyenMonRepository;
//    final HocHamRepository hocHamRepository;
//    final DanhHieuNhaNuocPhongTangRepository danhHieuNhaNuocPhongTangRepository;
//    final NhomMauRepository nhomMauRepository;
//    final ChucVuRepository chucVuRepository;
//    final ChucDanhDangRepository chucDanhDangRepository;
//    final NgachCongChucRepository ngachCongChucRepository;
//    final NgachVienChucRepository ngachVienChucRepository;
//    final ViTriViecLamRepository viTriViecLamRepository;
//    final DonViRepository donViRepository;
//    final IAuthenticationFacade facadeEmployee;

    @Override
    public HoSo xemHoSoCaNhan() {
        try {
//            return facadeEmployee.getSoYeuLyLich();
            return null;
        } catch (RuntimeException e) {
            throw new RuntimeException(e.getCause());
        }
    }

    @Override
    public HoSo capNhatHoSoCaNhan(ReqSoYeuLyLich reqSoYeuLyLich) {
        try {
//            SoYeuLyLich soYeuLyLich = facadeEmployee.getSoYeuLyLich();
//            if (soYeuLyLich != null) {
//                SoYeuLyLich syllNew = mapToSoYeuLyLich(soYeuLyLich, reqSoYeuLyLich);
//                return soYeuLyLichRepository.save(syllNew);
//            }
            return null;
        } catch (RuntimeException e) {
            throw new RuntimeException(e.getCause());
        }
    }

    @Override
    public HoSo taoHoSo(ReqHoSo req) {
        return soYeuLyLichRepository.save(
                HoSo.builder()
                        .id(req.uuid())
                        .hoVaTen(req.hoVaTen())
                        .soCCCD(req.soCCCD())
                        .taiKhoan(req.taiKhoan())
                        .pheDuyet(PheDuyet.CHO_PHE_DUYET)
                        .build()
        );
    }

    @Override
    public List<HoSo> xemDanhSachHoSo() {
        try {
            return soYeuLyLichRepository.findAll();
        } catch (RuntimeException e) {
            throw new RuntimeException(e.getCause());
        }
    }

    @Override
    public HoSo xemSoYeuLyLichTheoSoCCCDHoacID(String q) {
        try {
            HoSo resSoYeuLyLichSoCCCD = soYeuLyLichRepository.findFirstBySoCCCD(q).orElse(null);
            HoSo resHoSoId = null;
            Pattern UUID_REGEX = Pattern.compile("^[0-9a-fA-F]{8}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{12}$");
            if (UUID_REGEX.matcher(q).matches()) {
                resHoSoId = soYeuLyLichRepository.findById(UUID.fromString(q)).orElse(null);
            }
//            return null;
            return resSoYeuLyLichSoCCCD != null ? resSoYeuLyLichSoCCCD : resHoSoId;
        } catch (RuntimeException e) {
            throw new RuntimeException(e.getCause());
        }
    }

    @Override
    public HoSo capNhatHoSoCCVC(UUID id, ReqSoYeuLyLich req) {
        HoSo hoSo = soYeuLyLichRepository.findById(id).orElse(null);
        if (hoSo != null) {
            return soYeuLyLichRepository.save(mapToHoSo(hoSo, req));
        }
        return null;
    }

    @Override
    public HoSo xemSoYeuLyLichTheoId(UUID id) {
        try {
            return soYeuLyLichRepository.findById(id).orElse(null);
        } catch (RuntimeException e) {
            throw new RuntimeException(e.getCause());
        }
    }

    @Override
    public List<HoSo> pheDuyetSoYeuLyLich(List<ReqDSSoYeuLyLich> reqDSSoYeuLyLich) {
        try {
            List<HoSo> hoSos = reqDSSoYeuLyLich.stream().flatMap(c -> c.soYeuLyLichs().stream().map(t -> {
                HoSo hoSo = soYeuLyLichRepository.findById(t).orElse(null);
                if (hoSo != null) {
                    hoSo.setPheDuyet(c.pheDuyet());
                    hoSo.setUpdate_at();
                }
                return hoSo;
            })).toList();
            return soYeuLyLichRepository.saveAll(hoSos);
        } catch (RuntimeException e) {
            throw new RuntimeException(e.getCause());
        }
    }

    @Override
    public HoSo capNhatTheoId(UUID id, ReqSoYeuLyLich req) {
        try {
            HoSo hoSo = soYeuLyLichRepository.findById(id).orElse(null);
//            if (soYeuLyLich != null) {
//                SoYeuLyLich syllNew = mapToSoYeuLyLich(soYeuLyLich, req);
//                return soYeuLyLichRepository.save(syllNew);
//            }
            return null;
        } catch (RuntimeException e) {
            throw new RuntimeException(e.getCause());
        }
    }

    private double tinhLuongThucNhan(double tienLuong, float heSoLuongNgachNgheNghiep, double phanTramHuongLuongNgachNgheNghiep,
                                     float phuCapThamNienVuotKhungNgachNgheNghiep, float phuCapChucVu, float phuCapKiemNhiem, float phuCapKhac,
                                     double luongTheoMucTien, double phamTramHuongLuong, double phuCapThamNienVuotKhung
    ) {

        return (tienLuong * (heSoLuongNgachNgheNghiep * phanTramHuongLuongNgachNgheNghiep + phuCapThamNienVuotKhungNgachNgheNghiep)
                + phuCapChucVu + phuCapKiemNhiem + phuCapKhac) + (luongTheoMucTien * (phamTramHuongLuong + phuCapThamNienVuotKhung));
    }

    private HoSo mapToHoSo(HoSo hoSo, ReqSoYeuLyLich req) {
        ReqSoYeuLyLich.ReqThongTinTuyenDung tuyenDung = req.thongTinTuyenDung();
        ReqSoYeuLyLich.ReqQuanSu reqQuanSu = req.quanSu();
        ReqSoYeuLyLich.ReqHocVan reqHocVan = req.hocVan();
        ReqSoYeuLyLich.ReqChucVu reqChucVu = req.chucVu();
        ReqSoYeuLyLich.ReqNgachNhanVien reqNgach = req.ngach();
        ReqSoYeuLyLich.ReqViecLam reqViecLam = req.viecLam();
        ReqSoYeuLyLich.ReqSucKhoe reqSucKhoe = req.sucKhoe();
        //table
        ThongTinTuyenDung thongTinTuyenDung = thongTinTuyenDungRepository.findById(hoSo.getId()).orElse(null);
        if (tuyenDung != null) {
            if (thongTinTuyenDung != null) {
                thongTinTuyenDung.setNgheNghiepTruocKhiTuyenDung(tuyenDung.ngheNghiepTruocKhiTuyenDung());
                thongTinTuyenDung.setNgayDuocTuyenDungLanDau(tuyenDung.ngayDuocTuyenDungLanDau());
                thongTinTuyenDung.setCoQuanToChucDonViTuyenDung(tuyenDung.coQuanToChucDonViTuyenDung());
                thongTinTuyenDung.setNgayVaoCoQuanHienDangCongTac(tuyenDung.ngayVaoCoQuanHienDangCongTac());
                thongTinTuyenDung.setNgayVaoDangCongSanVietNam(tuyenDung.ngayVaoDangCongSanVietNam());
                thongTinTuyenDung.setNgayChinhThuc(tuyenDung.ngayChinhThuc());
                thongTinTuyenDung.setNgayThamGiaToChucChinhTriXaHoiDauTien(tuyenDung.ngayThamGiaToChucChinhTriXaHoiDauTien());
                thongTinTuyenDung.setCongViecChinhDuocGiao(tuyenDung.congViecChinhDuocGiao());
                thongTinTuyenDung.setSoTruongCongTac(tuyenDung.soTruongCongTac());
                thongTinTuyenDung.setCongViecLamLauNhat(tuyenDung.congViecLamLauNhat());
                thongTinTuyenDung.setUpdate_at();
            } else
                thongTinTuyenDung = new ThongTinTuyenDung(tuyenDung.ngheNghiepTruocKhiTuyenDung(), tuyenDung.ngayDuocTuyenDungLanDau(), tuyenDung.coQuanToChucDonViTuyenDung(),
                        tuyenDung.ngayVaoCoQuanHienDangCongTac(), tuyenDung.ngayVaoDangCongSanVietNam(), tuyenDung.ngayChinhThuc(), tuyenDung.ngayThamGiaToChucChinhTriXaHoiDauTien(),
                        tuyenDung.congViecChinhDuocGiao(), tuyenDung.soTruongCongTac(), tuyenDung.soTruongCongTac(), hoSo);
        }
        NghiaVuQuanSu quanSu = nghiaVuQuanSuRepository.findById(hoSo.getId()).orElse(null);
        if (reqQuanSu != null) {
            if (quanSu != null) {
                quanSu.setNgayNhapNgu(reqQuanSu.ngayNhapNgu());
                quanSu.setNgayXuatNgu(reqQuanSu.ngayXuatNgu());
                quanSu.setCapBacLoaiQuanHamQuanDoi(reqQuanSu.capBacLoaiQuanHamQuanDoi());
                quanSu.setUpdate_at();
            } else
                quanSu = new NghiaVuQuanSu(reqQuanSu.ngayNhapNgu(), reqQuanSu.ngayXuatNgu(), reqQuanSu.capBacLoaiQuanHamQuanDoi(), hoSo);
        }
        HocVan hocVan = hocVanRepository.findById(hoSo.getId()).orElse(null);
        if (reqHocVan != null) {
            if (hocVan != null) {
                hocVan.setTrinhDoGiaoDucPhoThong(reqHocVan.trinhDoGiaoDucPhoThong());
                hocVan.setTrinhDoChuyenMon(reqHocVan.trinhDoChuyenMon());
                hocVan.setHocHam(reqHocVan.hocHam());
                hocVan.setDanhHieuNhaNuocPhongTang(reqHocVan.danhHieuNhaNuocPhongTang());
                hocVan.setUpdate_at();
            } else
                hocVan = new HocVan(reqHocVan.trinhDoGiaoDucPhoThong(), reqHocVan.trinhDoChuyenMon(), reqHocVan.hocHam(), reqHocVan.danhHieuNhaNuocPhongTang(), hoSo);
        }
        ChucVuHienTai chucVuHienTai = chucVuHienTaiRepository.findById(hoSo.getId()).orElse(null);
        if (reqChucVu != null) {
            if (chucVuHienTai != null) {
                chucVuHienTai.setChucVu(reqChucVu.chucVuHienTai());
                chucVuHienTai.setNgayBoNhiem(reqChucVu.ngayBoNhiem());
                chucVuHienTai.setNgayBoNhiemLai(reqChucVu.ngayBoNhiemLai());
                chucVuHienTai.setDuocQuyHoacChucDanh(reqChucVu.duocQuyHoacChucDanh());
                chucVuHienTai.setUpdate_at();
            } else
                chucVuHienTai = new ChucVuHienTai(reqChucVu.chucVuHienTai(), reqChucVu.ngayBoNhiem(), reqChucVu.ngayBoNhiemLai(), reqChucVu.duocQuyHoacChucDanh(), hoSo);
        }

        NgachNhanVien ngach = ngachRepository.findById(hoSo.getId()).orElse(null);
        if (reqNgach != null) {
            if (ngach != null) {
                ngach.setNgachCongChuc(reqNgach.ngach());
                ngach.setNgachVienChuc(reqNgach.ngach());
                ngach.setNgayBoNhiemNgach(reqNgach.ngayBoNhiemNgach());
                ngach.setNgayHuongLuongNgach(reqNgach.ngayHuongLuongNgach());
                ngach.setPhanTramHuongLuongNgach(reqNgach.phanTramHuongLuongNgach());
                ngach.setPhuCapThamNienVuotKhungNgach(reqNgach.phuCapThamNienVuotKhungNgach());
                ngach.setNgayHuongPCTNVKNgach(reqNgach.ngayHuongPCTNVKNgach());
                ngach.setUpdate_at();
            } else
                ngach = new NgachNhanVien(reqNgach.ngach(), reqNgach.ngach(), reqNgach.ngayBoNhiemNgach(), reqNgach.ngayHuongLuongNgach(),
                        reqNgach.phanTramHuongLuongNgach(), reqNgach.phuCapThamNienVuotKhungNgach(), reqNgach.ngayHuongPCTNVKNgach(), hoSo);
        }
        ViecLam viecLam = viecLamRepository.findById(hoSo.getId()).orElse(null);
        if (reqViecLam != null) {
            if (viecLam != null) {
                viecLam.setViTriViecLam(reqViecLam.viTriViecLam());
                viecLam.setNgayHuongLuongTheoViTriViecLam(reqViecLam.ngayHuongLuongViTriViecLam());
                viecLam.setPhamTramHuongLuong(reqViecLam.phamTramHuongLuong());
                viecLam.setPhuCapThamNienVuotKhung(reqViecLam.phuCapThamNienVuotKhung());
                viecLam.setNgayHuongPCTNVK(reqViecLam.ngayHuongPCTNVK());
            } else viecLam = new ViecLam(reqViecLam.viTriViecLam(), reqViecLam.ngayHuongLuongViTriViecLam(),
                    reqViecLam.phamTramHuongLuong(), reqViecLam.phuCapThamNienVuotKhung(), reqViecLam.ngayHuongPCTNVK(), hoSo);
        }
        SucKhoe sucKhoe = sucKhoeRepository.findById(hoSo.getId()).orElse(null);
        if (reqSucKhoe != null) {
            if (sucKhoe != null) {
                sucKhoe.setTinhTrangSucKhoe(reqSucKhoe.tinhTrangSucKhoe());
                sucKhoe.setChieuCao(reqSucKhoe.chieuCao());
                sucKhoe.setCanNang(reqSucKhoe.canNang());
                sucKhoe.setNhomMau(reqSucKhoe.nhomMau());
                sucKhoe.setUpdate_at();
            } else
                sucKhoe = new SucKhoe(reqSucKhoe.tinhTrangSucKhoe(), reqSucKhoe.chieuCao(), reqSucKhoe.canNang(), reqSucKhoe.nhomMau(), hoSo);
        }
        hoSo.setHoVaTen(req.hovaten());
        hoSo.setGioiTinh(req.gioiTinh());
        hoSo.setCacTenGoiKhac(req.cacTenGoiKhac());
        hoSo.setSinhNgay(req.sinhNgay());
        hoSo.setNoiSinh(req.noiSinh());
        hoSo.setQueQuan(req.queQuan());
        hoSo.setDanToc(req.danToc());
        hoSo.setTonGiao(req.tonGiao());
        hoSo.setSoCCCD(req.soCCCD());
        hoSo.setNgayCapCCCD(req.ngayCapCCCD());
        hoSo.setSoDienThoai(req.soDienThoai());
        hoSo.setSoBHXH(req.soBHXH());
        hoSo.setSoBHYT(req.soBHYT());
        hoSo.setNoiOHienNay(req.noiOHienNay());
        hoSo.setThanhPhanGiaDinh(req.thanhPhanGiaDinh());
        hoSo.setThongTinTuyenDung(thongTinTuyenDung);
        hoSo.setQuanSu(quanSu);
        hoSo.setDoiTuongChinhSach(req.doiTuongChinhSach());
        hoSo.setHocVan(hocVan);
        hoSo.setChucVuHienTai(chucVuHienTai);
        hoSo.setChucVuKiemNhiem(req.chucVuKiemNhiem());
        hoSo.setChucVuDangHienTai(req.chucVuDangHienTai());
        hoSo.setChucVuDangKiemNhiem(req.chucVuDangKiemNhiem());
        hoSo.setTienLuong(req.tienLuong());
        hoSo.setNgach(ngach);
        hoSo.setPhuCapChucVu(req.phuCapChucVu());
        hoSo.setPhuCapKiemNhiem(req.phuCapKiemNhiem());
        hoSo.setPhuCapKhac(req.phuCapKhac());
        hoSo.setViecLam(viecLam);
        hoSo.setSucKhoe(sucKhoe);
        hoSo.setPheDuyet(PheDuyet.CHO_PHE_DUYET);
        hoSo.setUpdate_at();
        return hoSo;
    }

//    private HoSo mapToHoSo(HoSo hoSo, ReqSoYeuLyLich req) {
//        ReqSoYeuLyLich.ReqThongTinTuyenDung tuyenDung = req.thongTinTuyenDung();
//        ReqSoYeuLyLich.ReqQuanSu reqQuanSu = req.quanSu();
//        ReqSoYeuLyLich.ReqHocVan reqHocVan = req.hocVan();
//        ReqSoYeuLyLich.ReqChucVu reqChucVu = req.chucVu();
//        ReqSoYeuLyLich.ReqNgachNhanVien reqNgach = req.ngach();
//        ReqSoYeuLyLich.ReqViecLam reqViecLam = req.viecLam();
//        ReqSoYeuLyLich.ReqSucKhoe reqSucKhoe = req.sucKhoe();
//        /////////////////////////////////////////////////////
//        DanToc danToc = danTocRepository.findById(req.danToc()).orElse(null);
//        ThanhPhanGiaDinh thanhPhanGiaDinh = thanhPhanGiaDinhRepository.findById(req.thanhPhanGiaDinh()).orElse(null);
////        DonVi donVi = donViRepository.findById(tuyenDung.coQuanToChucDonViTuyenDung()).orElse(null); //coQuanToChucDonViTuyenDung
//        CoQuanToChucDonVi donVi = coQuanToChucDonViRepository.findById(tuyenDung.coQuanToChucDonViTuyenDung()).orElse(null); //coQuanToChucDonViTuyenDung
//
//        CapBacLoaiQuanHamQuanDoi capBacLoaiQuanHamQuanDoi = capBacLoaiQuanHamQuanDoiRepository.findById(reqQuanSu.capBacLoaiQuanHamQuanDoi()).orElse(null);
//        DoiTuongChinhSach doiTuongChinhSach = doiTuongChinhSachRepository.findById(req.doiTuongChinhSach()).orElse(null);
//        TrinhDoGiaoDucPhoThong trinhDoGiaoDucPhoThong = trinhDoGiaoDucPhoThongRepository.findById(reqHocVan.trinhDoGiaoDucPhoThong()).orElse(null);
//        TrinhDoChuyenMon trinhDoChuyenMon = trinhDoChuyenMonRepository.findById(reqHocVan.trinhDoChuyenMon()).orElse(null);
//        HocHam hocHam = hocHamRepository.findById(reqHocVan.hocHam()).orElse(null);
//        DanhHieuNhaNuoc danhHieuNhaNuocPhongTang = danhHieuNhaNuocPhongTangRepository.findById(reqHocVan.danhHieuNhaNuocPhongTang()).orElse(null);
//        NhomMau nhomMau = nhomMauRepository.findById(reqSucKhoe.nhomMau()).orElse(null);
//        ChucVu chucVu = chucVuRepository.findById(reqChucVu.chucVuHienTai()).orElse(null);
//        ChucVu chucVuKiemNhiem = chucVuRepository.findById(req.chucVuKiemNhiem()).orElse(null);
//        NgachCongChuc ngachCongChuc = ngachCongChucRepository.findById(reqNgach.ngach()).orElse(null);
//        NgachVienChuc ngachVienChuc = ngachVienChucRepository.findById(reqNgach.ngach()).orElse(null);
//        ViTriViecLam viTriViecLam = viTriViecLamRepository.findById(reqViecLam.viTriViecLam()).orElse(null);
//        ChucDanhDang chucDanhDangHienTai = chucDanhDangRepository.findById(req.chucVuDangHienTai()).orElse(null);
//        ChucDanhDang chucDanhDangKiemNhiem = chucDanhDangRepository.findById(req.chucVuDangKiemNhiem()).orElse(null);
//        //table
//        ThongTinTuyenDung thongTinTuyenDung = thongTinTuyenDungRepository.findById(syll.getId()).orElse(null);
//        if (thongTinTuyenDung != null) {
//            thongTinTuyenDung.setNgheNghiepTruocKhiTuyenDung(tuyenDung.ngheNghiepTruocKhiTuyenDung());
//            thongTinTuyenDung.setNgayDuocTuyenDungLanDau(tuyenDung.ngayDuocTuyenDungLanDau());
//            thongTinTuyenDung.setCoQuanToChucDonViTuyenDung(donVi);
//            thongTinTuyenDung.setNgayVaoCoQuanHienDangCongTac(tuyenDung.ngayVaoCoQuanHienDangCongTac());
//            thongTinTuyenDung.setNgayVaoDangCongSanVietNam(tuyenDung.ngayVaoDangCongSanVietNam());
//            thongTinTuyenDung.setNgayChinhThuc(tuyenDung.ngayChinhThuc());
//            thongTinTuyenDung.setNgayThamGiaToChucChinhTriXaHoiDauTien(tuyenDung.ngayThamGiaToChucChinhTriXaHoiDauTien());
//            thongTinTuyenDung.setCongViecChinhDuocGiao(tuyenDung.congViecChinhDuocGiao());
//            thongTinTuyenDung.setSoTruongCongTac(tuyenDung.soTruongCongTac());
//            thongTinTuyenDung.setCongViecLamLauNhat(tuyenDung.congViecLamLauNhat());
//            thongTinTuyenDung.setUpdate_at();
//        } else
//            thongTinTuyenDung = new ThongTinTuyenDung(tuyenDung.ngheNghiepTruocKhiTuyenDung(), tuyenDung.ngayDuocTuyenDungLanDau(), donVi,
//                    tuyenDung.ngayVaoCoQuanHienDangCongTac(), tuyenDung.ngayVaoDangCongSanVietNam(), tuyenDung.ngayChinhThuc(), tuyenDung.ngayThamGiaToChucChinhTriXaHoiDauTien(),
//                    tuyenDung.congViecChinhDuocGiao(), tuyenDung.soTruongCongTac(), tuyenDung.soTruongCongTac(), syll);
//        NghiaVuQuanSu quanSu = nghiaVuQuanSuRepository.findById(syll.getId()).orElse(null);
//        if (quanSu != null) {
//            quanSu.setNgayNhapNgu(reqQuanSu.ngayNhapNgu());
//            quanSu.setNgayXuatNgu(reqQuanSu.ngayXuatNgu());
//            quanSu.setCapBacLoaiQuanHamQuanDoi(capBacLoaiQuanHamQuanDoi);
//            quanSu.setUpdate_at();
//        } else
//            quanSu = new NghiaVuQuanSu(reqQuanSu.ngayNhapNgu(), reqQuanSu.ngayXuatNgu(), capBacLoaiQuanHamQuanDoi, syll);
//        HocVan hocVan = hocVanRepository.findById(syll.getId()).orElse(null);
//        if (hocVan != null) {
//            hocVan.setTrinhDoGiaoDucPhoThong(trinhDoGiaoDucPhoThong);
//            hocVan.setTrinhDoChuyenMon(trinhDoChuyenMon);
//            hocVan.setHocHam(hocHam);
//            hocVan.setDanhHieuNhaNuocPhongTang(danhHieuNhaNuocPhongTang);
//            hocVan.setUpdate_at();
//        } else hocVan = new HocVan(trinhDoGiaoDucPhoThong, trinhDoChuyenMon, hocHam, danhHieuNhaNuocPhongTang, syll);
//        ChucVuHienTai chucVuHienTai = chucVu != null ? ChucVuHienTai.builder()
//                .soYeuLyLich(syll)
//                .chucVu(chucVu)
//                .ngayBoNhiem(reqChucVu.ngayBoNhiem())
//                .ngayBoNhiemLai(reqChucVu.ngayBoNhiemLai())
//                .duocQuyHoacChucDanh(reqChucVu.duocQuyHoacChucDanh())
//                .build() : null;
//        NgachNhanVien ngach = ngachRepository.findById(syll.getId()).orElse(null);
//        if (ngach != null) {
//            if (ngachCongChuc != null) {
//                ngach.setNgachCongChuc(ngachCongChuc);
//                ngach.setNgachVienChuc(null);
//            } else {
//                ngach.setNgachVienChuc(ngachVienChuc);
//                ngach.setNgachCongChuc(null);
//            }
//            ngach.setNgayBoNhiemNgach(reqNgach.ngayBoNhiemNgach());
//            ngach.setNgayHuongLuongNgach(reqNgach.ngayHuongLuongNgach());
//            ngach.setPhanTramHuongLuongNgach(reqNgach.phanTramHuongLuongNgach());
//            ngach.setPhuCapThamNienVuotKhungNgach(reqNgach.phuCapThamNienVuotKhungNgach());
//            ngach.setNgayHuongPCTNVKNgach(reqNgach.ngayHuongPCTNVKNgach());
//            ngach.setUpdate_at();
//        } else
//            ngach = new NgachNhanVien(ngachCongChuc, ngachVienChuc, reqNgach.ngayBoNhiemNgach(), reqNgach.ngayHuongLuongNgach(),
//                    reqNgach.phanTramHuongLuongNgach(), reqNgach.phuCapThamNienVuotKhungNgach(), reqNgach.ngayHuongPCTNVKNgach(), syll);
//        ViecLam viecLam = viecLamRepository.findById(syll.getId()).orElse(null);
//        if (viecLam != null) {
//            viecLam.setViTriViecLam(viTriViecLam);
//            viecLam.setNgayHuongLuongTheoViTriViecLam(reqViecLam.ngayHuongLuongViTriViecLam());
//            viecLam.setPhamTramHuongLuong(reqViecLam.phamTramHuongLuong());
//            viecLam.setPhuCapThamNienVuotKhung(reqViecLam.phuCapThamNienVuotKhung());
//            viecLam.setNgayHuongPCTNVK(reqViecLam.ngayHuongPCTNVK());
//        } else viecLam = new ViecLam(viTriViecLam, reqViecLam.ngayHuongLuongViTriViecLam(),
//                reqViecLam.phamTramHuongLuong(), reqViecLam.phuCapThamNienVuotKhung(), reqViecLam.ngayHuongPCTNVK(), syll);
//
//        SucKhoe sucKhoe = sucKhoeRepository.findById(syll.getId()).orElse(null);
//        if (sucKhoe != null) {
//            sucKhoe.setTinhTrangSucKhoe(reqSucKhoe.tinhTrangSucKhoe());
//            sucKhoe.setChieuCao(reqSucKhoe.chieuCao());
//            sucKhoe.setCanNang(reqSucKhoe.canNang());
//            sucKhoe.setNhomMau(nhomMau);
//            sucKhoe.setUpdate_at();
//        } else
//            sucKhoe = new SucKhoe(reqSucKhoe.tinhTrangSucKhoe(), reqSucKhoe.chieuCao(), reqSucKhoe.canNang(), nhomMau, syll);
//        syll.setHoVaTen(req.hovaten());
//        syll.setGioiTinh(req.gioiTinh());
//        syll.setCacTenGoiKhac(req.cacTenGoiKhac());
//        syll.setSinhNgay(req.sinhNgay());
//        syll.setNoiSinh(req.noiSinh());
//        syll.setQueQuan(req.queQuan());
//        syll.setDanToc(danToc);
//        syll.setSoCCCD(req.soCCCD());
//        syll.setNgayCapCCCD(req.ngayCapCCCD());
//        syll.setSoDienThoai(req.soDienThoai());
//        syll.setSoBHXH(req.soBHXH());
//        syll.setSoBHYT(req.soBHYT());
//        syll.setNoiOHienNay(req.noiOHienNay());
//        syll.setThanhPhanGiaDinh(thanhPhanGiaDinh);
//        syll.setThongTinTuyenDung(thongTinTuyenDung);
//        syll.setQuanSu(quanSu);
//        syll.setDoiTuongChinhSach(doiTuongChinhSach);
//        syll.setHocVan(hocVan);
//        syll.setChucVuHienTai(chucVuHienTai);
//        syll.setChucVuKiemNhiem(chucVuKiemNhiem);
//        syll.setChucVuDangHienTai(chucDanhDangHienTai);
//        syll.setChucVuDangKiemNhiem(chucDanhDangKiemNhiem);
//        syll.setTienLuong(req.tienLuong());
//        syll.setNgach(ngach);
//        syll.setPhuCapChucVu(req.phuCapChucVu());
//        syll.setPhuCapKiemNhiem(req.phuCapKiemNhiem());
//        syll.setPhuCapKhac(req.phuCapKhac());
//        syll.setViecLam(viecLam);
//        syll.setSucKhoe(sucKhoe);
//        syll.setPheDuyet(PheDuyet.CHO_PHE_DUYET);
//        syll.setUpdate_at();
//        return syll;
//    }
}
