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
import hrm.module.cauhinh.repositories.DanhHieuNhaNuocRepository;
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
import hrm.module.cauhinh.response.APIExceptionCustom;

import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor // if field is set final or @not null
public class UtilitiesService {
    private final BacLuongRepository bacLuongRepository;
    private final CapBacLoaiQuanHamQuanDoiRepository capBacLoaiQuanHamQuanDoiRepository;
    private final ChucDanhDangRepository chucDanhDangRepository;
    private final ChucVuRepository chucVuRepository;
    private final CoQuanToChucDonViRepository coQuanToChucDonViRepository;
    private final DanhHieuNhaNuocRepository danhHieuNhaNuocRepository;
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
        public List<BacLuong> xemDanhSach(int pageNumber, int pageSize) {
            Page<BacLuong> concac = bacLuongRepository.findAll(PageRequest.of(pageNumber, pageSize));
//            Slice<BacLuong> concac2 = bacLuongRepository.findAll(PageRequest.of(pageNumber, pageSize));
            System.out.printf("s1: %d, s2: %d, s3: %d\n", concac.getNumber(), concac.getTotalElements(), concac.getTotalPages());
            return bacLuongRepository.findAll(PageRequest.of(pageNumber, pageSize)).getContent();
        }

        @Override
        public BacLuong xemTheoId(int id) {
            return bacLuongRepository.findById(id).orElseThrow(APIExceptionCustom.NotFoundData::new);
        }

        @Override
        public String xemTheoIdTraVeName(int id) {
            return bacLuongRepository.findById(id).map(BacLuong::getName).orElse("");
        }

        @Override
        public BacLuong them(ReqUtilities name) {
            try {
                return bacLuongRepository.save(new BacLuong(name.name()));
            } catch (RuntimeException e) {
                throw new APIExceptionCustom.DuplicateData();
            }
        }

        @Override
        public BacLuong sua(int id, ReqUtilities luong) {
            return bacLuongRepository.findById(id).map(e -> {
                e.setName(luong.name());
                e.setUpdate_at();
                return bacLuongRepository.save(e);
            }).orElseThrow(APIExceptionCustom.NotFoundData::new);
        }

        @Override
        public boolean xoa(int id) {
            try {
                if (xemTheoId(id) != null) {
                    bacLuongRepository.deleteById(id);
                    return true;
                }
                return false;
            } catch (RuntimeException e) {
                throw new APIExceptionCustom.NotFoundData();
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
        public List<CapBacLoaiQuanHamQuanDoi> xemDanhSach(int pageNumber, int pageSize) {
            return capBacLoaiQuanHamQuanDoiRepository.findAll(PageRequest.of(pageNumber, pageSize)).getContent();
        }

        @Override
        public CapBacLoaiQuanHamQuanDoi xemTheoId(int id) {
            return capBacLoaiQuanHamQuanDoiRepository.findById(id).orElseThrow(APIExceptionCustom.NotFoundData::new);
        }

        @Override
        public String xemTheoIdTraVeName(int id) {
            return capBacLoaiQuanHamQuanDoiRepository.findById(id).map(CapBacLoaiQuanHamQuanDoi::getName).orElse("");
        }

        @Override
        public CapBacLoaiQuanHamQuanDoi them(ReqUtilities req) {
            try {
                return capBacLoaiQuanHamQuanDoiRepository.save(new CapBacLoaiQuanHamQuanDoi(req.name()));
            } catch (RuntimeException e) {
                throw new APIExceptionCustom.DuplicateData();
            }
        }

        @Override
        public CapBacLoaiQuanHamQuanDoi sua(int id, ReqUtilities doi) {
            return capBacLoaiQuanHamQuanDoiRepository.findById(id).map(e -> {
                e.setName(doi.name() != null ? doi.name() : e.getName());
                e.setUpdate_at();
                return capBacLoaiQuanHamQuanDoiRepository.save(e);
            }).orElseThrow(APIExceptionCustom.NotFoundData::new);
        }

        @Override
        public boolean xoa(int id) {
            try {
                if (xemTheoId(id) != null) {
                    capBacLoaiQuanHamQuanDoiRepository.deleteById(id);
                    return true;
                }
                return false;
            } catch (RuntimeException e) {
                throw new APIExceptionCustom.NotFoundData();
            }
        }
    }

    @Service
    public class ChucDanhDangService implements IUtilitiesService<ChucDanhDang, ReqUtilities> {
        @Override
        public List<ChucDanhDang> xemDS() {
            return chucDanhDangRepository.findAll();
        }

        @Override
        public List<ChucDanhDang> xemDanhSach(int pageNumber, int pageSize) {
            return chucDanhDangRepository.findAll(PageRequest.of(pageNumber, pageSize)).getContent();
        }

        @Override
        public ChucDanhDang xemTheoId(int id) {
            return chucDanhDangRepository.findById(id).orElseThrow(APIExceptionCustom.NotFoundData::new);
        }

        @Override
        public String xemTheoIdTraVeName(int id) {
            return chucDanhDangRepository.findById(id).map(ChucDanhDang::getName).orElse("");
        }

        @Override
        public ChucDanhDang them(ReqUtilities req) {
            try {
                return chucDanhDangRepository.save(new ChucDanhDang(req.name()));
            } catch (RuntimeException e) {
                throw new APIExceptionCustom.DuplicateData();
            }
        }

        @Override
        public ChucDanhDang sua(int id, ReqUtilities dang) {
            return chucDanhDangRepository.findById(id).map(e -> {
                e.setName(dang.name() != null ? dang.name() : e.getName());
                e.setUpdate_at();
                return chucDanhDangRepository.save(e);
            }).orElseThrow(APIExceptionCustom.NotFoundData::new);
        }

        @Override
        public boolean xoa(int id) {
            try {
                if (xemTheoId(id) != null) {
                    chucDanhDangRepository.deleteById(id);
                    return true;
                }
                return false;
            } catch (RuntimeException e) {
                throw new APIExceptionCustom.NotFoundData();
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
        public List<ChucVu> xemDanhSach(int pageNumber, int pageSize) {
            return chucVuRepository.findAll(PageRequest.of(pageNumber, pageSize)).getContent();
        }

        @Override
        public ChucVu xemTheoId(int id) {
            return chucVuRepository.findById(id).orElseThrow(APIExceptionCustom.NotFoundData::new);
        }

        @Override
        public String xemTheoIdTraVeName(int id) {
            return chucVuRepository.findById(id).map(ChucVu::getName).orElse("");
        }

        @Override
        public ChucVu them(ReqUtilities req) {
            try {
                return chucVuRepository.save(new ChucVu(req.name()));
            } catch (RuntimeException e) {
                throw new APIExceptionCustom.DuplicateData();
            }
        }

        @Override
        public ChucVu sua(int id, ReqUtilities vu) {
            return chucVuRepository.findById(id).map(e -> {
                e.setName(vu.name());
                e.setUpdate_at();
                return chucVuRepository.save(e);
            }).orElseThrow(APIExceptionCustom.NotFoundData::new);
        }

        @Override
        public boolean xoa(int id) {
            try {
                if (xemTheoId(id) != null) {
                    chucVuRepository.deleteById(id);
                    return true;
                }
                return false;
            } catch (RuntimeException e) {
                throw new APIExceptionCustom.NotFoundData();
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
        public List<CoQuanToChucDonVi> xemDanhSach(int pageNumber, int pageSize) {
            return coQuanToChucDonViRepository.findAll(PageRequest.of(pageNumber, pageSize)).getContent();
        }

        @Override
        public CoQuanToChucDonVi xemTheoId(int id) {
            return coQuanToChucDonViRepository.findById(id).orElseThrow(APIExceptionCustom.NotFoundData::new);
        }

        @Override
        public String xemTheoIdTraVeName(int id) {
            return coQuanToChucDonViRepository.findById(id).map(CoQuanToChucDonVi::getName).orElse("");
        }

        @Override
        public CoQuanToChucDonVi them(ReqUtilities req) {
            try {
                return coQuanToChucDonViRepository.save(new CoQuanToChucDonVi(req.name()));
            } catch (RuntimeException e) {
                throw new APIExceptionCustom.DuplicateData();
            }
        }

        @Override
        public CoQuanToChucDonVi sua(int id, ReqUtilities vi) {
            try {
                return coQuanToChucDonViRepository.findById(id).map(e -> {
                    e.setName(vi.name());
                    e.setUpdate_at();
                    return coQuanToChucDonViRepository.save(e);
                }).orElseThrow(APIExceptionCustom.NotFoundData::new);
            } catch (RuntimeException e) {
                throw new APIExceptionCustom.NotFoundData();
            }
        }

        @Override
        public boolean xoa(int id) {
            try {
                if (xemTheoId(id) != null) {
                    coQuanToChucDonViRepository.deleteById(id);
                    return true;
                }
                return false;
            } catch (RuntimeException e) {
                throw new APIExceptionCustom.NotFoundData();
            }
        }
    }

    @Service
    public class DanhHieuNhaNuocService implements IUtilitiesService<DanhHieuNhaNuoc, ReqUtilities> {
        @Override
        public List<DanhHieuNhaNuoc> xemDS() {
            return danhHieuNhaNuocRepository.findAll();
        }

        @Override
        public List<DanhHieuNhaNuoc> xemDanhSach(int pageNumber, int pageSize) {
            return danhHieuNhaNuocRepository.findAll(PageRequest.of(pageNumber, pageSize)).getContent();
        }

        @Override
        public DanhHieuNhaNuoc xemTheoId(int id) {
            return danhHieuNhaNuocRepository.findById(id).orElseThrow(APIExceptionCustom.NotFoundData::new);
        }

        @Override
        public String xemTheoIdTraVeName(int id) {
            return danhHieuNhaNuocRepository.findById(id).map(DanhHieuNhaNuoc::getName).orElse("");
        }

        @Override
        public DanhHieuNhaNuoc them(ReqUtilities req) {
            try {
                return danhHieuNhaNuocRepository.save(new DanhHieuNhaNuoc(req.name()));
            } catch (RuntimeException e) {
                throw new APIExceptionCustom.DuplicateData();
            }
        }

        @Override
        public DanhHieuNhaNuoc sua(int id, ReqUtilities danh) {
            return danhHieuNhaNuocRepository.findById(id).map(e -> {
                e.setName(danh.name());
                e.setUpdate_at();
                return danhHieuNhaNuocRepository.save(e);
            }).orElseThrow(APIExceptionCustom.NotFoundData::new);
        }

        @Override
        public boolean xoa(int id) {
            try {
                if (xemTheoId(id) != null) {
                    danhHieuNhaNuocRepository.deleteById(id);
                    return true;
                }
                return false;
            } catch (RuntimeException e) {
                throw new APIExceptionCustom.NotFoundData();
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
        public List<DanToc> xemDanhSach(int pageNumber, int pageSize) {
            return danTocRepository.findAll(PageRequest.of(pageNumber, pageSize)).getContent();
        }

        @Override
        public DanToc xemTheoId(int id) {
            return danTocRepository.findById(id).orElseThrow(APIExceptionCustom.NotFoundData::new);
        }

        @Override
        public String xemTheoIdTraVeName(int id) {
            return danTocRepository.findById(id).map(DanToc::getName).orElse("");
        }

        @Override
        public DanToc them(ReqUtilities req) {
            try {
                return danTocRepository.save(new DanToc(req.name()));
            } catch (RuntimeException e) {
                throw new APIExceptionCustom.DuplicateData();
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
                throw new APIExceptionCustom.NotFoundData();
            }
        }

        @Override
        public boolean xoa(int id) {
            try {
                if (xemTheoId(id) != null) {
                    danTocRepository.deleteById(id);
                    return true;
                }
                return false;
            } catch (RuntimeException e) {
                throw new APIExceptionCustom.NotFoundData();
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
        public List<DoiTuongChinhSach> xemDanhSach(int pageNumber, int pageSize) {
            return doiTuongChinhSachRepository.findAll(PageRequest.of(pageNumber, pageSize)).getContent();
        }

        @Override
        public DoiTuongChinhSach xemTheoId(int id) {
            return doiTuongChinhSachRepository.findById(id).orElseThrow(APIExceptionCustom.NotFoundData::new);
        }

        @Override
        public String xemTheoIdTraVeName(int id) {
            return doiTuongChinhSachRepository.findById(id).map(DoiTuongChinhSach::getName).orElse("");
        }

        @Override
        public DoiTuongChinhSach them(ReqUtilities req) {
            try {
                return doiTuongChinhSachRepository.save(new DoiTuongChinhSach(req.name()));
            } catch (RuntimeException e) {
                throw new APIExceptionCustom.DuplicateData();
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
                throw new APIExceptionCustom.NotFoundData();
            }
        }

        @Override
        public boolean xoa(int id) {
            try {
                if (xemTheoId(id) != null) {
                    doiTuongChinhSachRepository.deleteById(id);
                    return true;
                }
                return false;
            } catch (RuntimeException e) {
                throw new APIExceptionCustom.NotFoundData();
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
        public List<HinhThucKhenThuong> xemDanhSach(int pageNumber, int pageSize) {
            return hinhThucKhenThuongRepository.findAll(PageRequest.of(pageNumber, pageSize)).getContent();
        }

        @Override
        public HinhThucKhenThuong xemTheoId(int id) {
            return hinhThucKhenThuongRepository.findById(id).orElseThrow(APIExceptionCustom.NotFoundData::new);
        }

        @Override
        public String xemTheoIdTraVeName(int id) {
            return hinhThucKhenThuongRepository.findById(id).map(HinhThucKhenThuong::getName).orElse("");
        }

        @Override
        public HinhThucKhenThuong them(ReqUtilities req) {
            try {
                return hinhThucKhenThuongRepository.save(new HinhThucKhenThuong(req.name()));
            } catch (RuntimeException e) {
                throw new APIExceptionCustom.DuplicateData();
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
                throw new APIExceptionCustom.NotFoundData();
            }
        }

        @Override
        public boolean xoa(int id) {
            try {
                if (xemTheoId(id) != null) {
                    hinhThucKhenThuongRepository.deleteById(id);
                    return true;
                }
                return false;
            } catch (RuntimeException e) {
                throw new APIExceptionCustom.NotFoundData();
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
        public List<HocHam> xemDanhSach(int pageNumber, int pageSize) {
            return hocHamRepository.findAll(PageRequest.of(pageNumber, pageSize)).getContent();
        }

        @Override
        public HocHam xemTheoId(int id) {
            return hocHamRepository.findById(id).orElseThrow(APIExceptionCustom.NotFoundData::new);
        }

        @Override
        public String xemTheoIdTraVeName(int id) {
            return hocHamRepository.findById(id).map(HocHam::getName).orElse("");
        }

        @Override
        public HocHam them(ReqUtilities req) {
            try {
                return hocHamRepository.save(new HocHam(req.name()));
            } catch (RuntimeException e) {
                throw new APIExceptionCustom.DuplicateData();
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
                throw new APIExceptionCustom.NotFoundData();
            }
        }

        @Override
        public boolean xoa(int id) {
            try {
                if (xemTheoId(id) != null) {
                    hocHamRepository.deleteById(id);
                    return true;
                }
                return false;
            } catch (RuntimeException e) {
                throw new APIExceptionCustom.NotFoundData();
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
        public List<LoaiPhuCap> xemDanhSach(int pageNumber, int pageSize) {
            return loaiPhuCapRepository.findAll(PageRequest.of(pageNumber, pageSize)).getContent();
        }

        @Override
        public LoaiPhuCap xemTheoId(int id) {
            return loaiPhuCapRepository.findById(id).orElseThrow(APIExceptionCustom.NotFoundData::new);
        }

        @Override
        public String xemTheoIdTraVeName(int id) {
            return loaiPhuCapRepository.findById(id).map(LoaiPhuCap::getName).orElse("");
        }

        @Override
        public LoaiPhuCap them(ReqUtilities req) {
            try {
                return loaiPhuCapRepository.save(new LoaiPhuCap(req.name()));
            } catch (RuntimeException e) {
                throw new APIExceptionCustom.DuplicateData();
            }
        }

        @Override
        public LoaiPhuCap sua(int id, ReqUtilities req) {
            try {
                return loaiPhuCapRepository.findById(id).map(e -> {
                    e.setName(req.name());
                    e.setUpdate_at();
                    return loaiPhuCapRepository.save(e);
                }).orElseThrow(APIExceptionCustom.NotFoundData::new);
            } catch (APIExceptionCustom.DuplicateData e) {
                throw new APIExceptionCustom.DuplicateData();
            }
        }

        @Override
        public boolean xoa(int id) {
            try {
                if (xemTheoId(id) != null) {
                    loaiPhuCapRepository.deleteById(id);
                    return true;
                }
                return false;
            } catch (RuntimeException e) {
                throw new APIExceptionCustom.NotFoundData();
            }
        }
    }

    @Service
    public class MoiQuanHeService implements IUtilitiesService<MoiQuanHe, ReqUtilities> {
        @Override
        public List<MoiQuanHe> xemDS() {
            return moiQuanHeRepository.findAll();
        }

        @Override
        public List<MoiQuanHe> xemDanhSach(int pageNumber, int pageSize) {
            return moiQuanHeRepository.findAll(PageRequest.of(pageNumber, pageSize)).getContent();
        }

        @Override
        public MoiQuanHe xemTheoId(int id) {
            return moiQuanHeRepository.findById(id).orElseThrow(APIExceptionCustom.NotFoundData::new);
        }

        @Override
        public String xemTheoIdTraVeName(int id) {
            return moiQuanHeRepository.findById(id).map(MoiQuanHe::getName).orElse("");
        }

        @Override
        public MoiQuanHe them(ReqUtilities req) {
            try {
                return moiQuanHeRepository.save(new MoiQuanHe(req.name()));
            } catch (RuntimeException e) {
                throw new APIExceptionCustom.DuplicateData();
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
                throw new APIExceptionCustom.NotFoundData();
            }
        }

        @Override
        public boolean xoa(int id) {
            try {
                if (xemTheoId(id) != null) {
                    moiQuanHeRepository.deleteById(id);
                    return true;
                }
                return false;
            } catch (RuntimeException e) {
                throw new APIExceptionCustom.NotFoundData();
            }
        }
    }

    @Service
    public class NhomMauService implements IUtilitiesService<NhomMau, ReqUtilities> {

        @Override
        public List<NhomMau> xemDS() {
            return nhomMauRepository.findAll();
        }

        @Override
        public List<NhomMau> xemDanhSach(int pageNumber, int pageSize) {
            return nhomMauRepository.findAll(PageRequest.of(pageNumber, pageSize)).getContent();
        }

        @Override
        public NhomMau xemTheoId(int id) {
            return nhomMauRepository.findById(id).orElseThrow(APIExceptionCustom.NotFoundData::new);
        }

        @Override
        public String xemTheoIdTraVeName(int id) {
            return nhomMauRepository.findById(id).map(NhomMau::getName).orElse("");
        }

        @Override
        public NhomMau them(ReqUtilities req) {
            try {
                return nhomMauRepository.save(new NhomMau(req.name()));
            } catch (RuntimeException e) {
                throw new APIExceptionCustom.DuplicateData();
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
                throw new APIExceptionCustom.NotFoundData();
            }
        }

        @Override
        public boolean xoa(int id) {
            try {
                if (xemTheoId(id) != null) {
                    nhomMauRepository.deleteById(id);
                    return true;
                }
                return false;
            } catch (RuntimeException e) {
                throw new APIExceptionCustom.NotFoundData();
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
        public List<ThanhPhanGiaDinh> xemDanhSach(int pageNumber, int pageSize) {
            return thanhPhanGiaDinhRepository.findAll(PageRequest.of(pageNumber, pageSize)).getContent();
        }

        @Override
        public ThanhPhanGiaDinh xemTheoId(int id) {
            return thanhPhanGiaDinhRepository.findById(id).orElseThrow(APIExceptionCustom.NotFoundData::new);
        }

        @Override
        public String xemTheoIdTraVeName(int id) {
            return thanhPhanGiaDinhRepository.findById(id).map(ThanhPhanGiaDinh::getName).orElse("");
        }

        @Override
        public ThanhPhanGiaDinh them(ReqUtilities req) {
            try {
                return thanhPhanGiaDinhRepository.save(new ThanhPhanGiaDinh(req.name()));
            } catch (RuntimeException e) {
                throw new APIExceptionCustom.DuplicateData();
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
                throw new APIExceptionCustom.NotFoundData();
            }
        }

        @Override
        public boolean xoa(int id) {
            try {
                if (xemTheoId(id) != null) {
                    thanhPhanGiaDinhRepository.deleteById(id);
                    return true;
                }
                return false;
            } catch (RuntimeException e) {
                throw new APIExceptionCustom.NotFoundData();
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
        public List<TonGiao> xemDanhSach(int pageNumber, int pageSize) {
            return tonGiaoRepository.findAll(PageRequest.of(pageNumber, pageSize)).getContent();
        }

        @Override
        public TonGiao xemTheoId(int id) {
            return tonGiaoRepository.findById(id).orElseThrow(APIExceptionCustom.NotFoundData::new);
        }

        @Override
        public String xemTheoIdTraVeName(int id) {
            return tonGiaoRepository.findById(id).map(TonGiao::getName).orElse("");
        }

        @Override
        public TonGiao them(ReqUtilities req) {
            try {
                return tonGiaoRepository.save(new TonGiao(req.name()));
            } catch (RuntimeException e) {
                throw new APIExceptionCustom.DuplicateData();
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
                throw new APIExceptionCustom.NotFoundData();
            }
        }

        @Override
        public boolean xoa(int id) {
            try {
                if (xemTheoId(id) != null) {
                    tonGiaoRepository.deleteById(id);
                    return true;
                }
                return false;
            } catch (RuntimeException e) {
                throw new APIExceptionCustom.NotFoundData();
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
        public List<TrinhDoChuyenMon> xemDanhSach(int pageNumber, int pageSize) {
            return trinhDoChuyenMonRepository.findAll(PageRequest.of(pageNumber, pageSize)).getContent();
        }

        @Override
        public TrinhDoChuyenMon xemTheoId(int id) {
            return trinhDoChuyenMonRepository.findById(id).orElseThrow(APIExceptionCustom.NotFoundData::new);
        }

        @Override
        public String xemTheoIdTraVeName(int id) {
            return trinhDoChuyenMonRepository.findById(id).map(TrinhDoChuyenMon::getName).orElse("");
        }

        @Override
        public TrinhDoChuyenMon them(ReqUtilities req) {
            try {
                return trinhDoChuyenMonRepository.save(new TrinhDoChuyenMon(req.name()));
            } catch (RuntimeException e) {
                throw new APIExceptionCustom.DuplicateData();
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
                throw new APIExceptionCustom.NotFoundData();
            }
        }

        @Override
        public boolean xoa(int id) {
            try {
                if (xemTheoId(id) != null) {
                    trinhDoChuyenMonRepository.deleteById(id);
                    return true;
                }
                return false;
            } catch (RuntimeException e) {
                throw new APIExceptionCustom.NotFoundData();
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
        public List<TrinhDoGiaoDucPhoThong> xemDanhSach(int pageNumber, int pageSize) {
            return trinhDoGiaoDucPhoThongRepository.findAll(PageRequest.of(pageNumber, pageSize)).getContent();
        }

        @Override
        public TrinhDoGiaoDucPhoThong xemTheoId(int id) {
            return trinhDoGiaoDucPhoThongRepository.findById(id).orElseThrow(APIExceptionCustom.NotFoundData::new);
        }

        @Override
        public String xemTheoIdTraVeName(int id) {
            return trinhDoGiaoDucPhoThongRepository.findById(id).map(TrinhDoGiaoDucPhoThong::getName).orElse("");
        }

        @Override
        public TrinhDoGiaoDucPhoThong them(ReqUtilities req) {
            try {
                return trinhDoGiaoDucPhoThongRepository.save(new TrinhDoGiaoDucPhoThong(req.name()));
            } catch (RuntimeException e) {
                throw new APIExceptionCustom.DuplicateData();
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
                throw new APIExceptionCustom.NotFoundData();
            }
        }

        @Override
        public boolean xoa(int id) {
            try {
                if (xemTheoId(id) != null) {
                    trinhDoGiaoDucPhoThongRepository.deleteById(id);
                    return true;
                }
                return false;
            } catch (RuntimeException e) {
                throw new APIExceptionCustom.NotFoundData();
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
        public List<ViTriViecLam> xemDanhSach(int pageNumber, int pageSize) {
            return viTriViecLamRepository.findAll(PageRequest.of(pageNumber, pageSize)).getContent();
        }

        @Override
        public ViTriViecLam xemTheoId(int id) {
            return viTriViecLamRepository.findById(id).orElse(null);
        }

        @Override
        public String xemTheoIdTraVeName(int id) {
            return viTriViecLamRepository.findById(id).map(ViTriViecLam::getName).orElse("");
        }

        @Override
        public ViTriViecLam them(ReqUtilities req) {
            BacLuong bacLuong = bacLuongRepository.findById(req.bacLuongId()).orElseThrow(APIExceptionCustom.NotFoundData::new);
            try {
                return viTriViecLamRepository.save(new ViTriViecLam(req.name(), bacLuong, req.tienLuong()));
            } catch (RuntimeException e) {
                throw new APIExceptionCustom.DuplicateData();
            }
        }

        @Override
        public ViTriViecLam sua(int id, ReqUtilities req) {
            BacLuong bacLuong = bacLuongRepository.findById(req.bacLuongId()).orElseThrow(APIExceptionCustom.NotFoundData::new);
            try {
                return viTriViecLamRepository.findById(id).map(e -> {
                    e.setName(req.name());
                    e.setBacLuongId(bacLuong);
                    e.setTienLuong(req.tienLuong());
                    e.setUpdate_at();
                    return viTriViecLamRepository.save(e);
                }).orElse(null);
            } catch (RuntimeException e) {
                throw new APIExceptionCustom.NotFoundData();
            }
        }

        @Override
        public boolean xoa(int id) {
            try {
                if (xemTheoId(id) != null) {
                    viTriViecLamRepository.deleteById(id);
                    return true;
                }
                return false;
            } catch (RuntimeException e) {
                throw new APIExceptionCustom.NotFoundData();
            }
        }
    }
}

