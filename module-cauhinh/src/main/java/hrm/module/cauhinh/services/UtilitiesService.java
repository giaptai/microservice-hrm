package hrm.module.cauhinh.services;

import hrm.module.cauhinh.dto.request.ReqUtilities;

import hrm.module.cauhinh.models.BacLuong;
import hrm.module.cauhinh.models.CapBacLoaiQuanHamQuanDoi;
import hrm.module.cauhinh.models.ChucDanhDang;
import hrm.module.cauhinh.models.ChucVu;
import hrm.module.cauhinh.models.CoQuanToChucDonVi;
import hrm.module.cauhinh.models.DanToc;
import hrm.module.cauhinh.models.DanhHieuNhaNuoc;
import hrm.module.cauhinh.models.DoiTuongChinhSach;
import hrm.module.cauhinh.models.HinhThucKhenThuong;
import hrm.module.cauhinh.models.HocHam;
import hrm.module.cauhinh.models.LoaiPhuCap;
import hrm.module.cauhinh.models.MoiQuanHe;
import hrm.module.cauhinh.models.NhomMau;
import hrm.module.cauhinh.models.ThanhPhanGiaDinh;
import hrm.module.cauhinh.models.TonGiao;
import hrm.module.cauhinh.models.TrinhDoChuyenMon;
import hrm.module.cauhinh.models.TrinhDoGiaoDucPhoThong;
import hrm.module.cauhinh.models.ViTriViecLam;

import hrm.module.cauhinh.repositories.BacLuongRepository;
import hrm.module.cauhinh.repositories.CapBacLoaiQuanHamQuanDoiRepository;
import hrm.module.cauhinh.repositories.ChucDanhDangRepository;
import hrm.module.cauhinh.repositories.ChucVuRepository;
import hrm.module.cauhinh.repositories.CoQuanToChucDonViRepository;
import hrm.module.cauhinh.repositories.DanTocRepository;
import hrm.module.cauhinh.repositories.DanhHieuNhaNuocPhongTangRepository;
import hrm.module.cauhinh.repositories.DoiTuongChinhSachRepository;
import hrm.module.cauhinh.repositories.HinhThucKhenThuongRepository;
import hrm.module.cauhinh.repositories.HocHamRepository;
import hrm.module.cauhinh.repositories.LoaiPhuCapRepository;
import hrm.module.cauhinh.repositories.MoiQuanHeRepository;
import hrm.module.cauhinh.repositories.NhomMauRepository;
import hrm.module.cauhinh.repositories.ThanhPhanGiaDinhRepository;
import hrm.module.cauhinh.repositories.TonGiaoRepository;
import hrm.module.cauhinh.repositories.TrinhDoChuyenMonRepository;
import hrm.module.cauhinh.repositories.TrinhDoGiaoDucPhoThongRepository;
import hrm.module.cauhinh.repositories.ViTriViecLamRepository;

import hrm.module.cauhinh.response.ExceptionCustom;
import hrm.module.cauhinh.response.ResDTO;
import hrm.module.cauhinh.response.ResEnum;

import jakarta.ws.rs.NotFoundException;
import lombok.RequiredArgsConstructor;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.sql.SQLException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor // if field is set final or @not null
public class UtilitiesService {
    private final BacLuongRepository bacLuongRepository;
    private final CapBacLoaiQuanHamQuanDoiRepository capBacLoaiQuanHamQuanDoiRepository;
    private final ChucDanhDangRepository chucDanhDangRepository;
    private final ChucVuRepository chucVuRepository;
    private final CoQuanToChucDonViRepository coQuanToChucDonViRepository;
    private final DanhHieuNhaNuocPhongTangRepository danhHieuNhaNuocPhongTangRepository;
    private final DanTocRepository danTocRepository;
    private final DoiTuongChinhSachRepository doiTuongChinhSachRepository;
    private final HinhThucKhenThuongRepository hinhThucKhenThuongRepository;
    private final HocHamRepository hocHamRepository;
    private final LoaiPhuCapRepository loaiPhuCapRepository;
    private final MoiQuanHeRepository moiQuanHeRepository;
    private final NhomMauRepository nhomMauRepository;
    private final ThanhPhanGiaDinhRepository thanhPhanGiaDinhRepository;
    private final TonGiaoRepository tonGiaoRepository;
    private final TrinhDoChuyenMonRepository trinhDoChuyenMonRepository;
    private final TrinhDoGiaoDucPhoThongRepository trinhDoGiaoDucPhoThongRepository;
    private final ViTriViecLamRepository viTriViecLamRepository;
    @Service
    public class BacLuongService implements IUtilitiesService<BacLuong, ReqUtilities> {
        @Override
        public List<BacLuong> xemDS() {
            return bacLuongRepository.findAll();
        }

        @Override
        public Optional<BacLuong> xemTheoId(int id) {
            return Optional.ofNullable(bacLuongRepository.findById(id).orElseThrow(() -> new ExceptionCustom.ExceptionNotFound(ResEnum.HONG_TIM_THAY.name())));
        }

        @Override
        public BacLuong them(ReqUtilities name) {
            try {
                return bacLuongRepository.save(new BacLuong(name.name()));
            } catch (RuntimeException e) {
                throw new ExceptionCustom(ResEnum.TRUNG_DU_LIEU.name());
            }
            //khong the xai ExceptionCustom
        }

        @Override
        public BacLuong sua(int id, ReqUtilities luong) {
            try {
                return xemTheoId(id).map(e -> {
                    e.setName(luong.name());
                    e.setUpdate_at();
                    return bacLuongRepository.save(e);
                }).orElseThrow(() -> new ExceptionCustom(ResEnum.HONG_TIM_THAY.name()));
            } catch (ExceptionCustom e) {
                throw new ExceptionCustom(ResEnum.TRUNG_DU_LIEU.name());
            }
        }

        @Override
        public boolean xoa(int id) {
            try {
                if (xemTheoId(id).isPresent()) {
                    bacLuongRepository.deleteById(id);
                    return true;
                }
                return false;
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }
    }

    @Service
    public class CapBacLoaiQuanHamQuanDoiService implements IUtilitiesService<CapBacLoaiQuanHamQuanDoi, ReqUtilities> {
        @Override
        public List<CapBacLoaiQuanHamQuanDoi> xemDS() {
            return capBacLoaiQuanHamQuanDoiRepository.findAll();
        }

        @Override
        public Optional<CapBacLoaiQuanHamQuanDoi> xemTheoId(int id) {
            return Optional.ofNullable(capBacLoaiQuanHamQuanDoiRepository.findById(id).orElseThrow(()->new ExceptionCustom.ExceptionNotFound(ResEnum.HONG_TIM_THAY.name())));
        }

        @Override
        public CapBacLoaiQuanHamQuanDoi them(ReqUtilities req) {
            try {
                return capBacLoaiQuanHamQuanDoiRepository.save(new CapBacLoaiQuanHamQuanDoi(req.name()));
            } catch (RuntimeException e) {
                throw new ExceptionCustom.ExceptionConflict(ResEnum.TRUNG_DU_LIEU.name());
            }
        }

//        public CapBacLoaiQuanHamQuanDoi themCapBacLoaiQuanHamQuanDoi(String name, int loaiQuanHamName) {
//            CapBacLoaiQuanHamQuanDoi capBacLoaiQuanHamQuanDoi = capBacLoaiQuanHamQuanDoiRepository.findByName(name).orElse(null);
////            LoaiQuanHamQuanDoi loaiQuanHamQuanDoi = loaiQuanHamQuanDoiRepository.findById(loaiQuanHamName).orElse(null);
//            try {
//                if (capBacLoaiQuanHamQuanDoi == null) {
////                    return capBacLoaiQuanHamQuanDoiRepository.save(new CapBacLoaiQuanHamQuanDoi(name, loaiQuanHamQuanDoi));
//                    return capBacLoaiQuanHamQuanDoiRepository.save(new CapBacLoaiQuanHamQuanDoi(name));
//                }
//                return capBacLoaiQuanHamQuanDoi;
//            } catch (RuntimeException e) {
//                throw new RuntimeException(e.getCause());
//            }
//        }

        @Override
        public CapBacLoaiQuanHamQuanDoi sua(int id, ReqUtilities doi) {
//            LoaiQuanHamQuanDoi loaiQuanHamQuanDoi = loaiQuanHamQuanDoiRepository.findById(doi.loaiQuanHamQuanDoi()).orElse(null);
            try {
                return capBacLoaiQuanHamQuanDoiRepository.findById(id).map(e -> {
                    e.setName(doi.name() != null ? doi.name() : e.getName());
//                    e.setLoaiQuanHamQuanDoi(loaiQuanHamQuanDoi);
                    e.setUpdate_at();
                    return capBacLoaiQuanHamQuanDoiRepository.save(e);
                }).orElseThrow(()-> new ExceptionCustom.ExceptionConflict(ResEnum.TRUNG_DU_LIEU.name()));
            } catch (RuntimeException e) {
                throw new ExceptionCustom.ExceptionNotFound(ResEnum.HONG_TIM_THAY.name());
            }
        }

        @Override
        public boolean xoa(int id) {
            return IUtilitiesService.super.xoa(id);
        }
    }

//    @Service
//    public class CapNhomChucDanhDangService implements IUtilitiesService<CapNhomChucDanhDang, ReqUtilities> {
//        @Override
//        public List<CapNhomChucDanhDang> xemDS() {
//            return capNhomChucDanhDangRepository.findAll();
//        }
//
//        @Override
//        public Optional<CapNhomChucDanhDang> xemTheoId(int id) {
//            return capNhomChucDanhDangRepository.findById(id);
//        }
//
//        @Override
//        public CapNhomChucDanhDang them(ReqUtilities req) {
//            CapNhomChucDanhDang capNhomChucDanhDang = capNhomChucDanhDangRepository.findByName(req.name()).orElse(null);
//            NhomChucDanhDang nhomChucDanhDang = nhomChucDanhDangRepository.findById(req.nhomChucDanhDang()).orElse(null);
//            try {
//                if (capNhomChucDanhDang == null) {
//                    return capNhomChucDanhDangRepository.save(new CapNhomChucDanhDang(req.name(), nhomChucDanhDang));
//                }
//                return capNhomChucDanhDang;
//            } catch (RuntimeException e) {
//                throw new RuntimeException(e.getCause());
//            }
//        }
//
//        @Override
//        public CapNhomChucDanhDang sua(int id, ReqUtilities dang) {
//            NhomChucDanhDang nhomChucDanhDang = nhomChucDanhDangRepository.findById(dang.nhomChucDanhDang()).orElse(null);
//            try {
//                return capNhomChucDanhDangRepository.findById(id).map(e -> {
//                    e.setName(dang.name() != null ? dang.name() : e.getName());
//                    e.setNhomChucDanhDang(nhomChucDanhDang);
//                    e.setUpdate_at();
//                    return capNhomChucDanhDangRepository.save(e);
//                }).orElse(null);
//            } catch (RuntimeException e) {
//                throw new RuntimeException(e.getCause());
//            }
//        }
//
//        @Override
//        public boolean xoa(int id) {
//            try {
//                if (xemTheoId(id).isPresent()) {
//                    capNhomChucDanhDangRepository.deleteById(id);
//                    return true;
//                }
//                return false;
//            } catch (RuntimeException e) {
//                throw new RuntimeException(e.getCause());
//            }
//        }
//    }

    @Service
    public class ChucDanhDangService implements IUtilitiesService<ChucDanhDang, ReqUtilities> {
        @Override
        public List<ChucDanhDang> xemDS() {
            return chucDanhDangRepository.findAll();
        }

        @Override
        public Optional<ChucDanhDang> xemTheoId(int id) {
            return Optional.ofNullable(chucDanhDangRepository.findById(id).orElseThrow(() -> new ExceptionCustom.ExceptionNotFound(ResEnum.HONG_TIM_THAY.name())));
        }

        @Override
        public ChucDanhDang them(ReqUtilities req) {
            ChucDanhDang chucDanhDang = chucDanhDangRepository.findByName(req.name()).orElse(null);
//            CapNhomChucDanhDang capNhomChucDanhDang = capNhomChucDanhDangRepository.findById(req.capNhomChucDanhDang()).orElse(null);
            try {
//                    return chucDanhDangRepository.save(new ChucDanhDang(req.name(), capNhomChucDanhDang));
                return chucDanhDangRepository.save(new ChucDanhDang(req.name()));
            } catch (RuntimeException e) {
                throw new ExceptionCustom.ExceptionConflict(ResEnum.TRUNG_DU_LIEU.name());
            }
        }

        @Override
        public ChucDanhDang sua(int id, ReqUtilities dang) {
//            CapNhomChucDanhDang capNhomChucDanhDang = capNhomChucDanhDangRepository.findById(dang.capNhomChucDanhDang()).orElse(null);
            try {
                return chucDanhDangRepository.findById(id).map(e -> {
                    e.setName(dang.name() != null ? dang.name() : e.getName());
//                    e.setCapNhomChucDanhDang(capNhomChucDanhDang);
                    e.setUpdate_at();
                    return chucDanhDangRepository.save(e);
                }).orElseThrow(()->new ExceptionCustom.ExceptionNotFound(ResEnum.HONG_TIM_THAY.name()));
            } catch (RuntimeException e) {
                throw new ExceptionCustom.ExceptionConflict(ResEnum.TRUNG_DU_LIEU.name());
            }
        }

        @Override
        public boolean xoa(int id) {
            try {
                if (xemTheoId(id).isPresent()) {
                    chucDanhDangRepository.deleteById(id);
                    return true;
                }
                return false;
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }
    }

    @Service
    public class ChucVuService implements IUtilitiesService<ChucVu, ReqUtilities> {
        @Override
        public List<ChucVu> xemDS() {
            return chucVuRepository.findAll();
        }

        @Override
        public Optional<ChucVu> xemTheoId(int id) {
            return Optional.ofNullable(chucVuRepository.findById(id).orElseThrow(() -> new ExceptionCustom.ExceptionNotFound(ResEnum.HONG_TIM_THAY.name())));
        }

        @Override
        public ChucVu them(ReqUtilities req) {
            try {
                return chucVuRepository.save(new ChucVu(req.name()));
            } catch (RuntimeException e) {
                throw new ExceptionCustom.ExceptionConflict(ResEnum.TRUNG_DU_LIEU.name());
            }
        }

        @Override
        public ChucVu sua(int id, ReqUtilities vu) {
            try {
                return chucVuRepository.findById(id).map(e -> {
                    e.setName(vu.name());
                    e.setUpdate_at();
                    return chucVuRepository.save(e);
                }).orElseThrow(()->new ExceptionCustom.ExceptionNotFound(ResEnum.HONG_TIM_THAY.name()));
            } catch (RuntimeException e) {
                throw new ExceptionCustom.ExceptionConflict(ResEnum.TRUNG_DU_LIEU.name());
            }
        }

        @Override
        public boolean xoa(int id) {
            try {
                if (xemTheoId(id).isPresent()) {
                    chucVuRepository.deleteById(id);
                    return true;
                }
                return false;
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }
    }

    @Service
    public class CoQuanToChucDonViService implements IUtilitiesService<CoQuanToChucDonVi, ReqUtilities> {
        @Override
        public List<CoQuanToChucDonVi> xemDS() {
            return coQuanToChucDonViRepository.findAll();
        }

        @Override
        public Optional<CoQuanToChucDonVi> xemTheoId(int id) {
            return Optional.ofNullable(coQuanToChucDonViRepository.findById(id).orElseThrow(() -> new ExceptionCustom.ExceptionNotFound(ResEnum.HONG_TIM_THAY.name())));
        }

        @Override
        public CoQuanToChucDonVi them(ReqUtilities req) {
            try {
                return coQuanToChucDonViRepository.save(new CoQuanToChucDonVi(req.name()));
            } catch (RuntimeException e) {
                throw new ExceptionCustom.ExceptionConflict(ResEnum.TRUNG_DU_LIEU.name());
            }
        }

        @Override
        public CoQuanToChucDonVi sua(int id, ReqUtilities vi) {
            try {
                return coQuanToChucDonViRepository.findById(id).map(e -> {
                    e.setName(vi.name());
                    e.setUpdate_at();
                    return coQuanToChucDonViRepository.save(e);
                }).orElseThrow(()->new ExceptionCustom.ExceptionNotFound(ResEnum.HONG_TIM_THAY.name()));
            } catch (RuntimeException e) {
                throw new ExceptionCustom.ExceptionConflict(ResEnum.TRUNG_DU_LIEU.name());
            }
        }

        @Override
        public boolean xoa(int id) {
            try {
                if (xemTheoId(id).isPresent()) {
                    coQuanToChucDonViRepository.deleteById(id);
                    return true;
                }
                return false;
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }
    }

//    @Service
//    public class BoCoQuanService implements IUtilitiesService<BoCoQuan, ReqUtilities> {
//        @Override
//        public List<BoCoQuan> xemDS() {
//            return boCoQuanRepository.findAll();
//        }
//
//        @Override
//        public Optional<BoCoQuan> xemTheoId(int id) {
//            return boCoQuanRepository.findById(id);
//        }
//
//        @Override
//        public BoCoQuan them(ReqUtilities req) {
//            BoCoQuan co = boCoQuanRepository.findByName(req.name()).orElse(null);
//            try {
//                if (co == null) {
//                    return boCoQuanRepository.save(new BoCoQuan(req.name()));
//                }
//                return co;
//            } catch (RuntimeException e) {
//                throw new RuntimeException(e.getCause());
//            }
//        }
//
//        @Override
//        public BoCoQuan sua(int id, ReqUtilities vi) {
//            try {
//                return boCoQuanRepository.findById(id).map(e -> {
//                    e.setName(vi.name());
//                    e.setUpdate_at();
//                    return boCoQuanRepository.save(e);
//                }).orElse(null);
//            } catch (RuntimeException e) {
//                throw new RuntimeException(e.getCause());
//            }
//        }
//
//        @Override
//        public boolean xoa(int id) {
//            try {
//                if (xemTheoId(id).isPresent()) {
//                    donViRepository.deleteById(id);
//                    return true;
//                }
//                return false;
//            } catch (RuntimeException e) {
//                throw new RuntimeException(e.getCause());
//            }
//        }
//    }

//    @Service
//    public class DonViService implements IUtilitiesService<DonVi, ReqUtilities> {
//        @Override
//        public List<DonVi> xemDS() {
//            return donViRepository.findAll();
//        }
//
//        @Override
//        public Optional<DonVi> xemTheoId(int id) {
//            return donViRepository.findById(id);
//        }
//
//        @Override
//        public DonVi them(ReqUtilities req) {
//            BoCoQuan boCoQuan = boCoQuanRepository.findById(req.boCoQuan()).orElseThrow(() -> new ResponseStatusException(ResEnum.HONG_TIM_THAY.getStatusCode()));
//            DonVi co = donViRepository.findByName(req.name()).orElse(null);
//            try {
//                if (co == null) {
//                    return donViRepository.save(new DonVi(req.name(), boCoQuan));
//                }
//                return co;
//            } catch (RuntimeException e) {
//                throw new RuntimeException(e.getCause());
//            }
//        }
//
//        @Override
//        public DonVi sua(int id, ReqUtilities vi) {
//            try {
//                return donViRepository.findById(id).map(e -> {
//                    BoCoQuan boCoQuan = boCoQuanRepository.findById(vi.boCoQuan()).orElseThrow(() -> new ResponseStatusException(ResEnum.HONG_TIM_THAY.getStatusCode()));
//                    e.setName(vi.name());
//                    e.setBoCoQuan(boCoQuan);
//                    e.setUpdate_at();
//                    return donViRepository.save(e);
//                }).orElse(null);
//            } catch (RuntimeException e) {
//                throw new RuntimeException(e.getCause());
//            }
//        }
//
//        @Override
//        public boolean xoa(int id) {
//            try {
//                if (xemTheoId(id).isPresent()) {
//                    donViRepository.deleteById(id);
//                    return true;
//                }
//                return false;
//            } catch (RuntimeException e) {
//                throw new RuntimeException(e.getCause());
//            }
//        }
//    }

    @Service
    public class DanhHieuNhaNuocPhongTangService implements IUtilitiesService<DanhHieuNhaNuoc, ReqUtilities> {
        @Override
        public List<DanhHieuNhaNuoc> xemDS() {
            return danhHieuNhaNuocPhongTangRepository.findAll();
        }

        @Override
        public Optional<DanhHieuNhaNuoc> xemTheoId(int id) {
            try {
                return Optional.ofNullable(danhHieuNhaNuocPhongTangRepository.findById(id).orElseThrow(() -> new ExceptionCustom.ExceptionNotFound(ResEnum.HONG_TIM_THAY.name())));
            } catch (RuntimeException e) {
                throw new ExceptionCustom.ExceptionNotFound(ResEnum.HONG_TIM_THAY.name());
            }
        }

        @Override
        public DanhHieuNhaNuoc them(ReqUtilities req) {
            try {
                return danhHieuNhaNuocPhongTangRepository.save(new DanhHieuNhaNuoc(req.name()));
            } catch (RuntimeException e) {
                throw new ExceptionCustom.ExceptionConflict(ResEnum.TRUNG_DU_LIEU.name());
            }
        }

        @Override
        public DanhHieuNhaNuoc sua(int id, ReqUtilities danh) {
            try {
                return danhHieuNhaNuocPhongTangRepository.findById(id).map(e -> {
                    e.setName(danh.name());
                    e.setUpdate_at();
                    return danhHieuNhaNuocPhongTangRepository.save(e);
                }).orElse(null);
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }

        @Override
        public boolean xoa(int id) {
            try {
                if (xemTheoId(id).isPresent()) {
                    danhHieuNhaNuocPhongTangRepository.deleteById(id);
                    return true;
                }
                return false;
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }
    }

    @Service
    public class DanTocService implements IUtilitiesService<DanToc, ReqUtilities> {
        @Override
        public List<DanToc> xemDS() {
            return danTocRepository.findAll();
        }

        @Override
        public Optional<DanToc> xemTheoId(int id) {
            return Optional.ofNullable(danTocRepository.findById(id).orElseThrow(() -> new ExceptionCustom.ExceptionNotFound(ResEnum.HONG_TIM_THAY.name())));
        }

        @Override
        public DanToc them(ReqUtilities req) {
            try {
                return danTocRepository.save(new DanToc(req.name()));
            } catch (RuntimeException e) {
                throw new ExceptionCustom.ExceptionConflict(ResEnum.TRUNG_DU_LIEU.name());
            }
        }

        @Override
        public DanToc sua(int id, ReqUtilities toc) {
            try {
                return danTocRepository.findById(id).map(e -> {
                    e.setName(toc.name());
                    e.setUpdate_at();
                    return danTocRepository.save(e);
                }).orElse(null);
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }

        @Override
        public boolean xoa(int id) {
            try {
                if (xemTheoId(id).isPresent()) {
                    danTocRepository.deleteById(id);
                    return true;
                }
                return false;
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }
    }

    @Service
    public class DoiTuongChinhSachService implements IUtilitiesService<DoiTuongChinhSach, ReqUtilities> {
        @Override
        public List<DoiTuongChinhSach> xemDS() {
            return doiTuongChinhSachRepository.findAll();
        }

        @Override
        public Optional<DoiTuongChinhSach> xemTheoId(int id) {
            return Optional.ofNullable(doiTuongChinhSachRepository.findById(id).orElseThrow(() -> new ExceptionCustom.ExceptionNotFound(ResEnum.HONG_TIM_THAY.name())));
        }

        @Override
        public DoiTuongChinhSach them(ReqUtilities req) {
            try {
                return doiTuongChinhSachRepository.save(new DoiTuongChinhSach(req.name()));
            } catch (RuntimeException e) {
                throw new ExceptionCustom.ExceptionConflict(ResEnum.TRUNG_DU_LIEU.name());
            }
        }

        @Override
        public DoiTuongChinhSach sua(int id, ReqUtilities sach) {
            try {
                return doiTuongChinhSachRepository.findById(id).map(e -> {
                    e.setName(sach.name());
                    e.setUpdate_at();
                    return doiTuongChinhSachRepository.save(e);
                }).orElse(null);
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }

        @Override
        public boolean xoa(int id) {
            try {
                if (xemTheoId(id).isPresent()) {
                    doiTuongChinhSachRepository.deleteById(id);
                    return true;
                }
                return false;
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }
    }

    @Service
    public class HinhThucKhenThuongService implements IUtilitiesService<HinhThucKhenThuong, ReqUtilities> {
        @Override
        public List<HinhThucKhenThuong> xemDS() {
            return hinhThucKhenThuongRepository.findAll();
        }

        @Override
        public Optional<HinhThucKhenThuong> xemTheoId(int id) {
            return Optional.ofNullable(hinhThucKhenThuongRepository.findById(id).orElseThrow(() -> new ExceptionCustom.ExceptionNotFound(ResEnum.HONG_TIM_THAY.name())));
        }

        @Override
        public HinhThucKhenThuong them(ReqUtilities req) {
            try {
                return hinhThucKhenThuongRepository.save(new HinhThucKhenThuong(req.name()));
            } catch (RuntimeException e) {
                throw new ExceptionCustom.ExceptionConflict(ResEnum.TRUNG_DU_LIEU.name());
            }
        }

        @Override
        public HinhThucKhenThuong sua(int id, ReqUtilities tinh) {
            try {
                return hinhThucKhenThuongRepository.findById(id).map(e -> {
                    e.setName(tinh.name());
                    e.setUpdate_at();
                    return hinhThucKhenThuongRepository.save(e);
                }).orElse(null);
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }

        @Override
        public boolean xoa(int id) {
            try {
                if (xemTheoId(id).isPresent()) {
                    hinhThucKhenThuongRepository.deleteById(id);
                    return true;
                }
                return false;
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }
    }

    @Service
    public class HocHamService implements IUtilitiesService<HocHam, ReqUtilities> {

        @Override
        public List<HocHam> xemDS() {
            return hocHamRepository.findAll();
        }

        @Override
        public Optional<HocHam> xemTheoId(int id) {
            return Optional.ofNullable(hocHamRepository.findById(id).orElseThrow(() -> new ExceptionCustom.ExceptionNotFound(ResEnum.HONG_TIM_THAY.name())));
        }

        @Override
        public HocHam them(ReqUtilities req) {
            try {
                return hocHamRepository.save(new HocHam(req.name()));
            } catch (RuntimeException e) {
                throw new ExceptionCustom.ExceptionConflict(ResEnum.TRUNG_DU_LIEU.name());
            }
        }

        @Override
        public HocHam sua(int id, ReqUtilities req) {
            try {
                return hocHamRepository.findById(id).map(e -> {
                    e.setName(req.name());
                    e.setUpdate_at();
                    return hocHamRepository.save(e);
                }).orElse(null);
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }

        @Override
        public boolean xoa(int id) {
            try {
                if (xemTheoId(id).isPresent()) {
                    hocHamRepository.deleteById(id);
                    return true;
                }
                return false;
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }
    }

    @Service
    public class LoaiPhuCapService implements IUtilitiesService<LoaiPhuCap, ReqUtilities> {

        @Override
        public List<LoaiPhuCap> xemDS() {
            return loaiPhuCapRepository.findAll();
        }

        @Override
        public Optional<LoaiPhuCap> xemTheoId(int id) {
            return Optional.ofNullable(loaiPhuCapRepository.findById(id).orElseThrow(() -> new ExceptionCustom.ExceptionNotFound(ResEnum.HONG_TIM_THAY.name())));
        }

        @Override
        public LoaiPhuCap them(ReqUtilities req) {
            try {
                return loaiPhuCapRepository.save(new LoaiPhuCap(req.name()));
            } catch (RuntimeException e) {
                throw new ExceptionCustom.ExceptionConflict(ResEnum.TRUNG_DU_LIEU.name());
            }
        }

        @Override
        public LoaiPhuCap sua(int id, ReqUtilities req) {
            try {
                return loaiPhuCapRepository.findById(id).map(e -> {
                    e.setName(req.name());
                    e.setUpdate_at();
                    return loaiPhuCapRepository.save(e);
                }).orElse(null);
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }

        @Override
        public boolean xoa(int id) {
            try {
                if (xemTheoId(id).isPresent()) {
                    loaiPhuCapRepository.deleteById(id);
                    return true;
                }
                return false;
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }
    }

//    @Service
//    public class LoaiQuanHamQuanDoiService implements IUtilitiesService<LoaiQuanHamQuanDoi, ReqUtilities> {
//
//        @Override
//        public List<LoaiQuanHamQuanDoi> xemDS() {
//            return loaiQuanHamQuanDoiRepository.findAll();
//        }
//
//        @Override
//        public Optional<LoaiQuanHamQuanDoi> xemTheoId(int id) {
//            return loaiQuanHamQuanDoiRepository.findById(id);
//        }
//
//        @Override
//        public LoaiQuanHamQuanDoi them(ReqUtilities req) {
//            LoaiQuanHamQuanDoi ham = loaiQuanHamQuanDoiRepository.findByName(req.name()).orElse(null);
//            try {
//                if (ham == null) {
//                    return loaiQuanHamQuanDoiRepository.save(new LoaiQuanHamQuanDoi(req.name()));
//                }
//                return ham;
//            } catch (RuntimeException e) {
//                throw new RuntimeException(e.getCause());
//            }
//        }
//
//        @Override
//        public LoaiQuanHamQuanDoi sua(int id, ReqUtilities req) {
//            try {
//                return loaiQuanHamQuanDoiRepository.findById(id).map(e -> {
//                    e.setName(req.name());
//                    e.setUpdate_at();
//                    return loaiQuanHamQuanDoiRepository.save(e);
//                }).orElse(null);
//            } catch (RuntimeException e) {
//                throw new RuntimeException(e.getCause());
//            }
//        }
//
//        @Override
//        public boolean xoa(int id) {
//            try {
//                if (xemTheoId(id).isPresent()) {
//                    loaiQuanHamQuanDoiRepository.deleteById(id);
//                    return true;
//                }
//                return false;
//            } catch (RuntimeException e) {
//                throw new RuntimeException(e.getCause());
//            }
//        }
//    }

    @Service
    public class MoiQuanHeService implements IUtilitiesService<MoiQuanHe, ReqUtilities> {
        @Override
        public List<MoiQuanHe> xemDS() {
            return moiQuanHeRepository.findAll();
        }

        @Override
        public Optional<MoiQuanHe> xemTheoId(int id) {
            return Optional.ofNullable(moiQuanHeRepository.findById(id).orElseThrow(() -> new ExceptionCustom.ExceptionNotFound(ResEnum.HONG_TIM_THAY.name())));
        }

        @Override
        public MoiQuanHe them(ReqUtilities req) {
            try {
                return moiQuanHeRepository.save(new MoiQuanHe(req.name()));
            } catch (RuntimeException e) {
                throw new ExceptionCustom.ExceptionConflict(ResEnum.TRUNG_DU_LIEU.name());
            }
        }

        @Override
        public MoiQuanHe sua(int id, ReqUtilities vu) {
            try {
                return moiQuanHeRepository.findById(id).map(e -> {
                    e.setName(vu.name());
                    e.setUpdate_at();
                    return moiQuanHeRepository.save(e);
                }).orElse(null);
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }

        @Override
        public boolean xoa(int id) {
            try {
                if (xemTheoId(id).isPresent()) {
                    moiQuanHeRepository.deleteById(id);
                    return true;
                }
                return false;
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }
    }

//    @Service
//    public class NhomChucDanhDangService implements IUtilitiesService<NhomChucDanhDang, ReqUtilities> {
//
//        @Override
//        public List<NhomChucDanhDang> xemDS() {
//            return nhomChucDanhDangRepository.findAll();
//        }
//
//        @Override
//        public Optional<NhomChucDanhDang> xemTheoId(int id) {
//            return nhomChucDanhDangRepository.findById(id);
//        }
//
//        @Override
//        public NhomChucDanhDang them(ReqUtilities req) {
//            NhomChucDanhDang dang = nhomChucDanhDangRepository.findByName(req.name()).orElse(null);
//            try {
//                if (dang == null) {
//                    return nhomChucDanhDangRepository.save(new NhomChucDanhDang(req.name()));
//                }
//                return dang;
//            } catch (RuntimeException e) {
//                throw new RuntimeException(e.getCause());
//            }
//        }
//
//        @Override
//        public NhomChucDanhDang sua(int id, ReqUtilities req) {
//            try {
//                return nhomChucDanhDangRepository.findById(id).map(e -> {
//                    e.setName(req.name());
//                    e.setUpdate_at();
//                    return nhomChucDanhDangRepository.save(e);
//                }).orElse(null);
//            } catch (RuntimeException e) {
//                throw new RuntimeException(e.getCause());
//            }
//        }
//
//        @Override
//        public boolean xoa(int id) {
//            try {
//                if (xemTheoId(id).isPresent()) {
//                    nhomChucDanhDangRepository.deleteById(id);
//                    return true;
//                }
//                return false;
//            } catch (RuntimeException e) {
//                throw new RuntimeException(e.getCause());
//            }
//        }
//    }

    @Service
    public class NhomMauService implements IUtilitiesService<NhomMau, ReqUtilities> {

        @Override
        public List<NhomMau> xemDS() {
            return nhomMauRepository.findAll();
        }

        @Override
        public Optional<NhomMau> xemTheoId(int id) {
            return Optional.ofNullable(nhomMauRepository.findById(id).orElseThrow(() -> new ExceptionCustom.ExceptionNotFound(ResEnum.HONG_TIM_THAY.name())));
        }

        @Override
        public NhomMau them(ReqUtilities req) {
            try {
                return nhomMauRepository.save(new NhomMau(req.name()));
            } catch (RuntimeException e) {
                throw new ExceptionCustom.ExceptionConflict(ResEnum.TRUNG_DU_LIEU.name());
            }
        }

        @Override
        public NhomMau sua(int id, ReqUtilities req) {
            try {
                return nhomMauRepository.findById(id).map(e -> {
                    e.setName(req.name());
                    e.setUpdate_at();
                    return nhomMauRepository.save(e);
                }).orElse(null);
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }

        @Override
        public boolean xoa(int id) {
            try {
                if (xemTheoId(id).isPresent()) {
                    nhomMauRepository.deleteById(id);
                    return true;
                }
                return false;
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }
    }

    @Service
    public class ThanhPhanGiaDinhService implements IUtilitiesService<ThanhPhanGiaDinh, ReqUtilities> {

        @Override
        public List<ThanhPhanGiaDinh> xemDS() {
            return thanhPhanGiaDinhRepository.findAll();
        }

        @Override
        public Optional<ThanhPhanGiaDinh> xemTheoId(int id) {
            return Optional.ofNullable(thanhPhanGiaDinhRepository.findById(id).orElseThrow(() -> new ExceptionCustom.ExceptionNotFound(ResEnum.HONG_TIM_THAY.name())));
        }

        @Override
        public ThanhPhanGiaDinh them(ReqUtilities req) {
            try {
                return thanhPhanGiaDinhRepository.save(new ThanhPhanGiaDinh(req.name()));
            } catch (RuntimeException e) {
                throw new ExceptionCustom.ExceptionConflict(ResEnum.TRUNG_DU_LIEU.name());
            }
        }

        @Override
        public ThanhPhanGiaDinh sua(int id, ReqUtilities req) {
            try {
                return thanhPhanGiaDinhRepository.findById(id).map(e -> {
                    e.setName(req.name());
                    e.setUpdate_at();
                    return thanhPhanGiaDinhRepository.save(e);
                }).orElse(null);
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }

        @Override
        public boolean xoa(int id) {
            try {
                if (xemTheoId(id).isPresent()) {
                    thanhPhanGiaDinhRepository.deleteById(id);
                    return true;
                }
                return false;
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }
    }

    @Service
    public class TonGiaoService implements IUtilitiesService<TonGiao, ReqUtilities> {

        @Override
        public List<TonGiao> xemDS() {
            return tonGiaoRepository.findAll();
        }

        @Override
        public Optional<TonGiao> xemTheoId(int id) {
            return Optional.ofNullable(tonGiaoRepository.findById(id).orElseThrow(() -> new ExceptionCustom.ExceptionNotFound(ResEnum.HONG_TIM_THAY.name())));
        }

        @Override
        public TonGiao them(ReqUtilities req) {
            try {
                return tonGiaoRepository.save(new TonGiao(req.name()));
            } catch (RuntimeException e) {
                throw new ExceptionCustom.ExceptionConflict(ResEnum.TRUNG_DU_LIEU.name());
            }
        }

        @Override
        public TonGiao sua(int id, ReqUtilities req) {
            try {
                return tonGiaoRepository.findById(id).map(e -> {
                    e.setName(req.name());
                    e.setUpdate_at();
                    return tonGiaoRepository.save(e);
                }).orElse(null);
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }

        @Override
        public boolean xoa(int id) {
            try {
                if (xemTheoId(id).isPresent()) {
                    tonGiaoRepository.deleteById(id);
                    return true;
                }
                return false;
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }
    }

    @Service
    public class TrinhDoChuyenMonService implements IUtilitiesService<TrinhDoChuyenMon, ReqUtilities> {

        @Override
        public List<TrinhDoChuyenMon> xemDS() {
            return trinhDoChuyenMonRepository.findAll();
        }

        @Override
        public Optional<TrinhDoChuyenMon> xemTheoId(int id) {
            return Optional.ofNullable(trinhDoChuyenMonRepository.findById(id).orElseThrow(() -> new ExceptionCustom.ExceptionNotFound(ResEnum.HONG_TIM_THAY.name())));
        }

        @Override
        public TrinhDoChuyenMon them(ReqUtilities req) {
            try {
                return trinhDoChuyenMonRepository.save(new TrinhDoChuyenMon(req.name()));
            } catch (RuntimeException e) {
                throw new ExceptionCustom.ExceptionConflict(ResEnum.TRUNG_DU_LIEU.name());
            }
        }

        @Override
        public TrinhDoChuyenMon sua(int id, ReqUtilities req) {
            try {
                return trinhDoChuyenMonRepository.findById(id).map(e -> {
                    e.setName(req.name());
                    e.setUpdate_at();
                    return trinhDoChuyenMonRepository.save(e);
                }).orElse(null);
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }

        @Override
        public boolean xoa(int id) {
            try {
                if (xemTheoId(id).isPresent()) {
                    trinhDoChuyenMonRepository.deleteById(id);
                    return true;
                }
                return false;
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }
    }

    @Service
    public class TrinhDoGiaoDucPhoThongService implements IUtilitiesService<TrinhDoGiaoDucPhoThong, ReqUtilities> {

        @Override
        public List<TrinhDoGiaoDucPhoThong> xemDS() {
            return trinhDoGiaoDucPhoThongRepository.findAll();
        }

        @Override
        public Optional<TrinhDoGiaoDucPhoThong> xemTheoId(int id) {
            return Optional.ofNullable(trinhDoGiaoDucPhoThongRepository.findById(id).orElseThrow(() -> new ExceptionCustom.ExceptionNotFound(ResEnum.HONG_TIM_THAY.name())));
        }

        @Override
        public TrinhDoGiaoDucPhoThong them(ReqUtilities req) {
            try {
                return trinhDoGiaoDucPhoThongRepository.save(new TrinhDoGiaoDucPhoThong(req.name()));
            } catch (RuntimeException e) {
                throw new ExceptionCustom.ExceptionConflict(ResEnum.TRUNG_DU_LIEU.name());
            }
        }

        @Override
        public TrinhDoGiaoDucPhoThong sua(int id, ReqUtilities req) {
            try {
                return trinhDoGiaoDucPhoThongRepository.findById(id).map(e -> {
                    e.setName(req.name());
                    e.setUpdate_at();
                    return trinhDoGiaoDucPhoThongRepository.save(e);
                }).orElse(null);
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }

        @Override
        public boolean xoa(int id) {
            try {
                if (xemTheoId(id).isPresent()) {
                    trinhDoGiaoDucPhoThongRepository.deleteById(id);
                    return true;
                }
                return false;
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }
    }

    @Service
    public class ViTriViecLamService implements IUtilitiesService<ViTriViecLam, ReqUtilities> {

        @Override
        public List<ViTriViecLam> xemDS() {
            return viTriViecLamRepository.findAll();
        }

        @Override
        public Optional<ViTriViecLam> xemTheoId(int id) {
            return Optional.ofNullable(viTriViecLamRepository.findById(id).orElseThrow(() -> new ExceptionCustom.ExceptionNotFound(ResEnum.HONG_TIM_THAY.name())));
        }

        @Override
        public ViTriViecLam them(ReqUtilities req) {
            BacLuong bacLuong = bacLuongRepository.findById(req.bacLuong()).orElseThrow(() -> new ExceptionCustom.ExceptionNotFound(ResEnum.HONG_TIM_THAY.name()));
            try {
                return viTriViecLamRepository.save(new ViTriViecLam(req.name(), bacLuong, req.tienLuong()));
            } catch (RuntimeException e) {
                throw new ExceptionCustom.CrushEmT(ResEnum.KAFKA_THANH_CONG.name());
            }
        }

        @Override
        public ViTriViecLam sua(int id, ReqUtilities req) {
            BacLuong bacLuong = bacLuongRepository.findById(req.bacLuong()).orElseThrow(() -> new ExceptionCustom.ExceptionNotFound(ResEnum.HONG_TIM_THAY.name()));
            try {
                return viTriViecLamRepository.findById(id).map(e -> {
                    e.setName(req.name());
                    e.setBacLuongId(bacLuong);
                    e.setTienLuong(req.tienLuong());
                    e.setUpdate_at();
                    return viTriViecLamRepository.save(e);
                }).orElse(null);
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }

        @Override
        public boolean xoa(int id) {
            try {
                if (xemTheoId(id).isPresent()) {
                    viTriViecLamRepository.deleteById(id);
                    return true;
                }
                return false;
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }
    }
}

