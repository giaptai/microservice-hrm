package com.hrm.hoso.services;

import com.hrm.hoso.client.data_chung.chuc_vu.ChucVuClient;
import com.hrm.hoso.client.data_chung.chuc_vu_dang.ChucVuDangClient;
import com.hrm.hoso.client.data_chung.dan_toc.DanTocClient;
import com.hrm.hoso.client.data_chung.doi_tuong_chinh_sach.DoiTuongChinhSachClient;
import com.hrm.hoso.client.chi_tiet.khen_thuong.KhenThuongAuth;
import com.hrm.hoso.client.chi_tiet.khen_thuong.KhenThuongClient;
import com.hrm.hoso.client.chi_tiet.kien_thuc_an_ninh_quoc_phong.KienThucAnNinhQuocPhongAuth;
import com.hrm.hoso.client.chi_tiet.kien_thuc_an_ninh_quoc_phong.KienThucAnNinhQuocPhongClient;
import com.hrm.hoso.client.chi_tiet.ky_luat.KyLuatAuth;
import com.hrm.hoso.client.chi_tiet.ky_luat.KyLuatClient;
import com.hrm.hoso.client.chi_tiet.lam_viec_cho_che_do_cu.LamViecChoCheDoCuAuth;
import com.hrm.hoso.client.chi_tiet.lam_viec_cho_che_do_cu.LamViecChoCheDoCuClient;
import com.hrm.hoso.client.chi_tiet.lam_viec_o_nuoc_ngoai.LamViecONuocNgoaiAuth;
import com.hrm.hoso.client.chi_tiet.lam_viec_o_nuoc_ngoai.LamViecONuocNgoaiClient;
import com.hrm.hoso.client.chi_tiet.luong_ban_than.LuongBanThanAuth;
import com.hrm.hoso.client.chi_tiet.luong_ban_than.LuongBanThanClient;
import com.hrm.hoso.client.chi_tiet.ly_luan_chinh_tri.LyLuanChinhTriAuth;
import com.hrm.hoso.client.chi_tiet.ly_luan_chinh_tri.LyLuanChinhTriClient;
import com.hrm.hoso.client.chi_tiet.nghiep_vu_chuyen_nganh.NghiepVuChuyenNganhAuth;
import com.hrm.hoso.client.chi_tiet.nghiep_vu_chuyen_nganh.NghiepVuChuyenNganhClient;
import com.hrm.hoso.client.chi_tiet.ngoai_ngu.NgoaiNguAuth;
import com.hrm.hoso.client.chi_tiet.ngoai_ngu.NgoaiNguClient;
import com.hrm.hoso.client.chi_tiet.phu_cap_khac.PhuCapKhacAuth;
import com.hrm.hoso.client.chi_tiet.phu_cap_khac.PhuCapKhacClient;
import com.hrm.hoso.client.chi_tiet.qua_trinh_cong_tac.QuaTrinhCongTacAuth;
import com.hrm.hoso.client.chi_tiet.qua_trinh_cong_tac.QuaTrinhCongTacClient;
import com.hrm.hoso.client.chi_tiet.quan_he_gia_dinh.QuanHeGiaDinhAuth;
import com.hrm.hoso.client.chi_tiet.quan_he_gia_dinh.QuanHeGiaDinhClient;
import com.hrm.hoso.client.data_chung.thanh_phan_gia_dinh.ThanhPhanGiaDinhClient;
import com.hrm.hoso.client.chi_tiet.tin_hoc.TinHocAuth;
import com.hrm.hoso.client.chi_tiet.tin_hoc.TinHocClient;

import com.hrm.hoso.client.data_chung.ton_giao.TonGiaoClient;
import com.hrm.hoso.dto.mapper.MapperHoSo;
import com.hrm.hoso.dto.request.ReqChucVu;
import com.hrm.hoso.dto.request.ReqHocVan;
import com.hrm.hoso.dto.request.ReqNgachNhanVien;
import com.hrm.hoso.dto.request.ReqQuanSu;
import com.hrm.hoso.dto.request.ReqSucKhoe;
import com.hrm.hoso.dto.request.ReqTaoHoSo;
import com.hrm.hoso.dto.request.ReqThongTinTuyenDung;
import com.hrm.hoso.dto.request.ReqViecLam;
import com.hrm.hoso.dto.response.ResChucVu;
import com.hrm.hoso.dto.response.ResHoSo;
import com.hrm.hoso.dto.response.ResHoSoHoanChinh;
import com.hrm.hoso.dto.response.ResHocVan;
import com.hrm.hoso.dto.response.ResNgachNhanVien;
import com.hrm.hoso.dto.response.ResQuanSu;
import com.hrm.hoso.dto.response.ResSucKhoe;
import com.hrm.hoso.dto.response.ResThongTinTuyenDung;
import com.hrm.hoso.dto.response.ResViecLam;

import com.hrm.hoso.enums.PheDuyet;

import com.hrm.hoso.dto.mapper.MapperChucVuHienTai;
import com.hrm.hoso.dto.mapper.MapperHocVan;
import com.hrm.hoso.dto.mapper.MapperNgach;
import com.hrm.hoso.dto.mapper.MapperQuanSu;
import com.hrm.hoso.dto.mapper.MapperSucKhoe;
import com.hrm.hoso.dto.mapper.MapperThongTinTuyenDung;
import com.hrm.hoso.dto.mapper.MapperViecLam;

import com.hrm.hoso.dto.request.ReqDSHoSo;
import com.hrm.hoso.dto.request.ReqHoSo;

import com.hrm.hoso.models.ChucVuHienTai;
import com.hrm.hoso.models.HoSo;
import com.hrm.hoso.models.HocVan;
import com.hrm.hoso.models.NgachNhanVien;
import com.hrm.hoso.models.NghiaVuQuanSu;
import com.hrm.hoso.models.SucKhoe;
import com.hrm.hoso.models.ThongTinTuyenDung;
import com.hrm.hoso.models.ViecLam;

import com.hrm.hoso.repository.ChucVuHienTaiRepository;
import com.hrm.hoso.repository.HocVanRepository;
import com.hrm.hoso.repository.NgachRepository;
import com.hrm.hoso.repository.NghiaVuQuanSuRepository;
import com.hrm.hoso.repository.HoSoRepository;
import com.hrm.hoso.repository.SucKhoeRepository;
import com.hrm.hoso.repository.ThongTinTuyenDungRepository;
import com.hrm.hoso.repository.ViecLamRepository;

import jakarta.ws.rs.NotFoundException;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor // tự tạo constructor với filed là final hoặc annotation not null
@FieldDefaults(level = AccessLevel.PRIVATE)
public class HoSoService implements IHoSoService {
    final HoSoRepository hoSoRepository;
    final ChucVuHienTaiRepository chucVuHienTaiRepository;
    final HocVanRepository hocVanRepository;
    final NgachRepository ngachRepository;
    final NghiaVuQuanSuRepository nghiaVuQuanSuRepository;
    final SucKhoeRepository sucKhoeRepository;
    final ThongTinTuyenDungRepository thongTinTuyenDungRepository;
    final ViecLamRepository viecLamRepository;
    //client
    final KhenThuongClient khenThuongClient;
    final KienThucAnNinhQuocPhongClient kienThucAnNinhQuocPhongClient;
    final KyLuatClient kyLuatClient;
    final LamViecChoCheDoCuClient lamViecChoCheDoCuClient;
    final LamViecONuocNgoaiClient lamViecONuocNgoaiClient;
    final LuongBanThanClient luongBanThanClient;
    final LyLuanChinhTriClient lyLuanChinhTriClient;
    final NghiepVuChuyenNganhClient nghiepVuChuyenNganhClient;
    final NgoaiNguClient ngoaiNguClient;
    final PhuCapKhacClient phuCapKhacClient;
    final QuaTrinhCongTacClient quaTrinhCongTacClient;
    final QuanHeGiaDinhClient quanHeGiaDinhClient;
    final TinHocClient tinHocClient;
    //mapper
    final MapperThongTinTuyenDung mapperThongTinTuyenDung;
    final MapperQuanSu mapperQuanSu;
    final MapperHocVan mapperHocVan;
    final MapperChucVuHienTai mapperChucVuHienTai;
    final MapperNgach mapperNgach;
    final MapperViecLam mapperViecLam;
    final MapperSucKhoe mapperSucKhoe;
    final MapperHoSo mapperHoSo;
    //clients
    final DanTocClient danTocClient;
    final TonGiaoClient tonGiaoClient;
    final ThanhPhanGiaDinhClient thanhPhanGiaDinhClient;
    final DoiTuongChinhSachClient doiTuongChinhSachClient;
    final ChucVuClient chucVuClient;
    final ChucVuDangClient chucVuDangClient;

    @Override
    public UUID layHoSoId(int taiKhoanId) {
        return hoSoRepository.findByTaiKhoanId(taiKhoanId).map(HoSo::getId).orElseThrow(() -> new NotFoundException());
    }

    @Override
    public ResHoSo taoHoSo(ReqTaoHoSo req) {
        HoSo hoSo = HoSo.builder()
                .hoVaTen(req.hoVaTen())
                .soCCCD(req.soCCCD())
                .taiKhoanId(req.taiKhoan())
                .pheDuyet(PheDuyet.CHO_PHE_DUYET)
                .create_at(LocalDateTime.now())
                .build();
        hoSoRepository.save(hoSo);
        return mapperHoSo.mapToResHoSo(hoSo);
    }

    @Override
    public List<ResHoSo> xemDanhSachHoSo() {
        List<HoSo> hoSos = hoSoRepository.findAll();
        return hoSos.stream().map(mapperHoSo::mapToResHoSo).toList();
    }

    @Override
    public ResHoSo xemHoSoTheoSoCCCD(String q) {
        HoSo hoSo = hoSoRepository.findFirstBySoCCCD(q).orElseThrow(NotFoundException::new);
//            Pattern UUID_REGEX = Pattern.compile("^[0-9a-fA-F]{8}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{12}$");
//            if (UUID_REGEX.matcher(q).matches()) {
//                resHoSoId = hoSoRepository.findById(UUID.fromString(q)).orElse(null);
//            }
        return mapperHoSo.mapToResHoSo(hoSo);
    }

    @Override
    public ResHoSo capNhatHoSoCCVC(UUID id, ReqHoSo req) {
        HoSo hoSo = hoSoRepository.findById(id).orElseThrow(NotFoundException::new);
        mapToHoSo(hoSo, req);
        hoSoRepository.save(hoSo);
        return mapperHoSo.mapToResHoSo(hoSo);
    }

    @Override
    public ResHoSo xemHoSoTheoId(UUID id) {
        try {
            HoSo hoSo = hoSoRepository.findById(id).orElseThrow(NotFoundException::new);
//            List<LamViecChoCheDoCuAuth> cheDoCus = lamViecChoCheDoCuClient.getAllByHoSoId(id);
//            List<KhenThuongAuth> khenThuongs = khenThuongClient.getAllByHoSoId(id);
//            List<KienThucAnNinhQuocPhongAuth> kienThucAnNinhQuocPhongs = kienThucAnNinhQuocPhongClient.getAllByHoSoId(id);
//            List<KyLuatAuth> kyLuats = kyLuatClient.getAllByHoSoId(id);
//            List<LamViecONuocNgoaiAuth> lamViecONuocNgoais = lamViecONuocNgoaiClient.getAllByHoSoId(id);
//            List<LuongBanThanAuth> luongBanThans = luongBanThanClient.getAllByHoSoId(id);
//            List<LyLuanChinhTriAuth> lyLuanChinhTris = lyLuanChinhTriClient.getAllByHoSoId(id);
//            List<NghiepVuChuyenNganhAuth> nghiepVuChuyenNganhs = nghiepVuChuyenNganhClient.getAllByHoSoId(id);
//            List<NgoaiNguAuth> ngoaiNgus = ngoaiNguClient.getAllByHoSoId(id);
//            List<PhuCapKhacAuth> phuCapKhacs = phuCapKhacClient.getAllByHoSoId(id);
//            List<QuanHeGiaDinhAuth> quanHeGiaDinhs = quanHeGiaDinhClient.getAllByHoSoId(id);
//            List<QuaTrinhCongTacAuth> quaTrinhCongTacs = quaTrinhCongTacClient.getAllByHoSoId(id);
//            List<TinHocAuth> tinHocs = tinHocClient.getAllByHoSoId(id);
//            ResThongTinTuyenDung resThongTinTuyenDung = mapperThongTinTuyenDung.mapToResThongTinTuyenDung(hoSo.getThongTinTuyenDung());
//            ResQuanSu resQuanSu = mapperQuanSu.mapToResQuanSu(hoSo.getQuanSu());
//            ResHocVan resHocVan = mapperHocVan.mapToResHocVan(hoSo.getHocVan());
//            ResChucVu resChucVu = mapperChucVuHienTai.mapToResChucVu(hoSo.getChucVuHienTai());
//            ResNgachNhanVien resNgachNhanVien = mapperNgach.mapToResNgachNhanVien(hoSo.getNgach());
//            ResViecLam resViecLam = mapperViecLam.mapToResViecLam(hoSo.getViecLam());
//            ResSucKhoe resSucKhoe = mapperSucKhoe.mapToResSucKhoe(hoSo.getSucKhoe());
            return mapperHoSo.mapToResHoSo(hoSo);
//            return new ResHoSoHoanChinh(
//                    hoSo.getId(),
//                    hoSo.getHoVaTen(),
//                    hoSo.getGioiTinh(),
//                    hoSo.getCacTenGoiKhac(),
//                    hoSo.getSinhNgay(),
//                    hoSo.getNoiSinh(),
//                    hoSo.getQueQuan(),
//                    hoSo.getDanTocId(),
//                    danTocClient.getName(hoSo.getDanTocId()),
//                    hoSo.getTonGiaoId(),
//                    tonGiaoClient.getName(hoSo.getTonGiaoId()),
//                    hoSo.getSoCCCD(),
//                    hoSo.getNgayCapCCCD(),
//                    hoSo.getSoDienThoai(),
//                    hoSo.getSoBHXH(),
//                    hoSo.getSoBHYT(),
//                    hoSo.getNoiOHienNay(),
//                    hoSo.getThanhPhanGiaDinhId(),
//                    thanhPhanGiaDinhClient.getName(hoSo.getThanhPhanGiaDinhId()),
//                    resThongTinTuyenDung,
//                    resQuanSu,
//                    hoSo.getDoiTuongChinhSachId(),
//                    doiTuongChinhSachClient.getName(hoSo.getDoiTuongChinhSachId()),
//                    resHocVan,
//                    resChucVu,
//                    hoSo.getChucVuKiemNhiemId(),
//                    chucVuClient.getName(hoSo.getChucVuKiemNhiemId()),
//                    hoSo.getChucVuDangHienTaiId(),
//                    chucVuDangClient.getName(hoSo.getChucVuDangHienTaiId()),
//                    hoSo.getChucVuDangKiemNhiemId(),
//                    chucVuDangClient.getName(hoSo.getChucVuDangKiemNhiemId()),
//                    hoSo.getTienLuong(),
//                    resNgachNhanVien,
//                    hoSo.getPhuCapChucVu(),
//                    hoSo.getPhuCapKiemNhiem(),
//                    hoSo.getPhuCapKhac(),
//                    resViecLam,
//                    resSucKhoe,
//                    cheDoCus,
//                    khenThuongs,
//                    kienThucAnNinhQuocPhongs,
//                    kyLuats,
//                    lamViecONuocNgoais,
//                    luongBanThans,
//                    lyLuanChinhTris,
//                    nghiepVuChuyenNganhs,
//                    ngoaiNgus,
//                    phuCapKhacs,
//                    quanHeGiaDinhs,
//                    quaTrinhCongTacs,
//                    tinHocs,
//                    hoSo.getTaiKhoanId(),
//                    hoSo.getPheDuyet(),
//                    hoSo.getCreate_at(),
//                    hoSo.getUpdate_at()
//            );
        } catch (RuntimeException e) {
            throw new RuntimeException(e.getCause());
        }
    }

//    @Override
//    public List<HoSo> pheDuyetHoSo(List<ReqDSHoSo> reqDSHoSos) {
//        try {
//            List<HoSo> hoSos = reqDSHoSos.stream().flatMap(c -> c.soYeuLyLichs().stream().map(t -> {
//                HoSo hoSo = hoSoRepository.findById(t).orElse(null);
//                if (hoSo != null) {
//                    hoSo.setPheDuyet(c.pheDuyet());
//                    hoSo.setUpdate_at();
//                }
//                return hoSo;
//            })).toList();
//            return hoSoRepository.saveAll(hoSos);
//        } catch (RuntimeException e) {
//            throw new RuntimeException(e.getCause());
//        }
//    }

    @Override
    public ResHoSo xemHoSoCaNhan(int taiKhoanId) {
        HoSo hoSo = hoSoRepository.findByTaiKhoanId(taiKhoanId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
//        return xemHoSoTheoId(hoSo.getId());
        return mapperHoSo.mapToResHoSo(hoSo);
    }

    @Override
    public ResHoSo capNhatHoSoCaNhan(int taiKhoanId, ReqHoSo reqHoSo) {
        HoSo hoSo = hoSoRepository.findByTaiKhoanId(taiKhoanId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return capNhatHoSoCCVC(hoSo.getId(), reqHoSo);
    }

    private HoSo mapToHoSo(HoSo hoSo, ReqHoSo req) {
        ReqThongTinTuyenDung tuyenDung = req.thongTinTuyenDung();
        ReqQuanSu reqQuanSu = req.quanSu();
        ReqHocVan reqHocVan = req.hocVan();
        ReqChucVu reqChucVu = req.chucVu();
        ReqNgachNhanVien reqNgach = req.ngach();
        ReqViecLam reqViecLam = req.viecLam();
        ReqSucKhoe reqSucKhoe = req.sucKhoe();
        //table
        ThongTinTuyenDung thongTinTuyenDung = thongTinTuyenDungRepository.findById(hoSo.getId()).orElse(null);
        if (tuyenDung != null) {
            if (thongTinTuyenDung != null) {
                thongTinTuyenDung.setNgheNghiepTruocKhiTuyenDung(tuyenDung.ngheNghiepTruocKhiTuyenDung());
                thongTinTuyenDung.setNgayDuocTuyenDungLanDau(tuyenDung.ngayDuocTuyenDungLanDau());
                thongTinTuyenDung.setCoQuanToChucDonViTuyenDungId(tuyenDung.coQuanToChucDonViTuyenDung());
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
                quanSu.setQuanHamCaoNhatId(reqQuanSu.capBacLoaiQuanHamQuanDoi());
                quanSu.setUpdate_at();
            } else
                quanSu = new NghiaVuQuanSu(reqQuanSu.ngayNhapNgu(), reqQuanSu.ngayXuatNgu(), reqQuanSu.capBacLoaiQuanHamQuanDoi(), hoSo);
        }
        HocVan hocVan = hocVanRepository.findById(hoSo.getId()).orElse(null);
        if (reqHocVan != null) {
            if (hocVan != null) {
                hocVan.setTrinhDoGiaoDucPhoThongId(reqHocVan.trinhDoGiaoDucPhoThong());
                hocVan.setTrinhDoChuyenMonCaoNhatId(reqHocVan.trinhDoChuyenMon());
                hocVan.setHocHamId(reqHocVan.hocHam());
                hocVan.setDanhHieuNhaNuocPhongTangId(reqHocVan.danhHieuNhaNuocPhongTang());
                hocVan.setUpdate_at();
            } else
                hocVan = new HocVan(reqHocVan.trinhDoGiaoDucPhoThong(), reqHocVan.trinhDoChuyenMon(), reqHocVan.hocHam(), reqHocVan.danhHieuNhaNuocPhongTang(), hoSo);
        }
        ChucVuHienTai chucVuHienTai = chucVuHienTaiRepository.findById(hoSo.getId()).orElse(null);
        if (reqChucVu != null) {
            if (chucVuHienTai != null) {
                chucVuHienTai.setChucVuId(reqChucVu.chucVuHienTai());
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
                ngach.setNgachId(reqNgach.ngachId());
                ngach.setNgayBoNhiemNgach(reqNgach.ngayBoNhiemNgach());
                ngach.setNgayHuongLuongNgach(reqNgach.ngayHuongLuongNgach());
                ngach.setPhanTramHuongLuongNgach(reqNgach.phanTramHuongLuongNgach());
                ngach.setPhuCapThamNienVuotKhungNgach(reqNgach.phuCapThamNienVuotKhungNgach());
                ngach.setNgayHuongPCTNVKNgach(reqNgach.ngayHuongPCTNVKNgach());
                ngach.setUpdate_at();
            } else
                ngach = new NgachNhanVien(reqNgach.ngachId(), reqNgach.ngayBoNhiemNgach(), reqNgach.ngayHuongLuongNgach(),
                        reqNgach.phanTramHuongLuongNgach(), reqNgach.phuCapThamNienVuotKhungNgach(), reqNgach.ngayHuongPCTNVKNgach(), hoSo);
        }
        ViecLam viecLam = viecLamRepository.findById(hoSo.getId()).orElse(null);
        if (reqViecLam != null) {
            if (viecLam != null) {
                viecLam.setViTriViecLam(reqViecLam.viTriViecLamId());
                viecLam.setNgayHuongLuongTheoViTriViecLam(reqViecLam.ngayHuongLuongViTriViecLam());
                viecLam.setPhamTramHuongLuong(reqViecLam.phamTramHuongLuong());
                viecLam.setPhuCapThamNienVuotKhung(reqViecLam.phuCapThamNienVuotKhung());
                viecLam.setNgayHuongPCTNVK(reqViecLam.ngayHuongPCTNVK());
                viecLam.setUpdate_at();
            } else viecLam = new ViecLam(reqViecLam.viTriViecLamId(), reqViecLam.ngayHuongLuongViTriViecLam(),
                    reqViecLam.phamTramHuongLuong(), reqViecLam.phuCapThamNienVuotKhung(), reqViecLam.ngayHuongPCTNVK(), hoSo);
        }
        SucKhoe sucKhoe = sucKhoeRepository.findById(hoSo.getId()).orElse(null);
        if (reqSucKhoe != null) {
            if (sucKhoe != null) {
                sucKhoe.setTinhTrangSucKhoe(reqSucKhoe.tinhTrangSucKhoe());
                sucKhoe.setChieuCao(reqSucKhoe.chieuCao());
                sucKhoe.setCanNang(reqSucKhoe.canNang());
                sucKhoe.setNhomMauId(reqSucKhoe.nhomMau());
                sucKhoe.setUpdate_at();
            } else
                sucKhoe = new SucKhoe(reqSucKhoe.tinhTrangSucKhoe(), reqSucKhoe.chieuCao(), reqSucKhoe.canNang(), reqSucKhoe.nhomMau(), hoSo);
        }
//        hoSo.setHoVaTen(req.hoVaTen());
        hoSo.setGioiTinh(req.gioiTinh());
        hoSo.setCacTenGoiKhac(req.cacTenGoiKhac());
        hoSo.setSinhNgay(req.sinhNgay());
        hoSo.setNoiSinh(req.noiSinh());
        hoSo.setQueQuan(req.queQuan());
        hoSo.setDanTocId(req.danToc());
        hoSo.setTonGiaoId(req.tonGiao());
//        hoSo.setSoCCCD(req.soCCCD());
        hoSo.setNgayCapCCCD(req.ngayCapCCCD());
        hoSo.setSoDienThoai(req.soDienThoai());
        hoSo.setSoBHXH(req.soBHXH());
        hoSo.setSoBHYT(req.soBHYT());
        hoSo.setNoiOHienNay(req.noiOHienNay());
        hoSo.setThanhPhanGiaDinhId(req.thanhPhanGiaDinh());
        hoSo.setThongTinTuyenDung(thongTinTuyenDung);
        hoSo.setQuanSu(quanSu);
        hoSo.setDoiTuongChinhSachId(req.doiTuongChinhSach());
        hoSo.setHocVan(hocVan);
        hoSo.setChucVuHienTai(chucVuHienTai);
        hoSo.setChucVuKiemNhiemId(req.chucVuKiemNhiem());
        hoSo.setChucVuDangHienTaiId(req.chucVuDangHienTai());
        hoSo.setChucVuDangKiemNhiemId(req.chucVuDangKiemNhiem());
        hoSo.setTienLuong(req.tienLuong());
        hoSo.setNgach(ngach);
        hoSo.setPhuCapChucVu(req.phuCapChucVu());
        hoSo.setPhuCapKiemNhiem(req.phuCapKiemNhiem());
        hoSo.setPhuCapKhac(req.phuCapKhac());
        hoSo.setViecLam(viecLam);
        hoSo.setSucKhoe(sucKhoe);
        hoSo.setPheDuyet(req.pheDuyet());
        hoSo.setUpdate_at();
        return hoSo;
    }
}
