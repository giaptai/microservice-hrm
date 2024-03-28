package com.hrm.hoso_chitiet.services;

import com.hrm.hoso_chitiet.dto.request.ReqLamViecChoCheDoCu;
import com.hrm.hoso_chitiet.dto.request.ReqKhenThuong;
import com.hrm.hoso_chitiet.dto.request.ReqKienThucAnNinhQuocPhong;
import com.hrm.hoso_chitiet.dto.request.ReqKyLuat;
import com.hrm.hoso_chitiet.dto.request.ReqLamViecONuocNgoai;
import com.hrm.hoso_chitiet.dto.request.ReqLuongBanThan;
import com.hrm.hoso_chitiet.dto.request.ReqLyLuanChinhTri;
import com.hrm.hoso_chitiet.dto.request.ReqNghiepVuChuyenNganh;
import com.hrm.hoso_chitiet.dto.request.ReqNgoaiNgu;
import com.hrm.hoso_chitiet.dto.request.ReqPhuCapKhac;
import com.hrm.hoso_chitiet.dto.request.ReqQuaTrinhCongTac;
import com.hrm.hoso_chitiet.dto.request.ReqQuanHeGiaDinh;
import com.hrm.hoso_chitiet.dto.request.ReqTinHoc;
import com.hrm.hoso_chitiet.dto.response.ResHoSoChiTiet;
import com.hrm.hoso_chitiet.enums.XacNhan;
import com.hrm.hoso_chitiet.models.LamViecChoCheDoCu;
import com.hrm.hoso_chitiet.models.KhenThuong;
import com.hrm.hoso_chitiet.models.KienThucAnNinhQuocPhong;
import com.hrm.hoso_chitiet.models.KyLuat;
import com.hrm.hoso_chitiet.models.LamViecONuocNgoai;
import com.hrm.hoso_chitiet.models.LuongBanThan;
import com.hrm.hoso_chitiet.models.LyLuanChinhTri;
import com.hrm.hoso_chitiet.models.NghiepVuChuyenNganh;
import com.hrm.hoso_chitiet.models.NgoaiNgu;
import com.hrm.hoso_chitiet.models.PhuCapKhac;
import com.hrm.hoso_chitiet.models.QuaTrinhCongTac;
import com.hrm.hoso_chitiet.models.QuanHeGiaDinh;
import com.hrm.hoso_chitiet.models.TinHoc;
import com.hrm.hoso_chitiet.repositories.LamViecChoCheDoCuRepository;
import com.hrm.hoso_chitiet.repositories.KhenThuongRepository;
import com.hrm.hoso_chitiet.repositories.KienThucAnNinhQuocPhongRepository;
import com.hrm.hoso_chitiet.repositories.KyLuatRepository;
import com.hrm.hoso_chitiet.repositories.LamViecONuocNgoaiRepository;
import com.hrm.hoso_chitiet.repositories.LuongBanThanRepository;
import com.hrm.hoso_chitiet.repositories.LyLuanChinhTriRepository;
import com.hrm.hoso_chitiet.repositories.NghiepVuChuyenNganhRepository;
import com.hrm.hoso_chitiet.repositories.NgoaiNguRepository;
import com.hrm.hoso_chitiet.repositories.PhuCapKhacRepository;
import com.hrm.hoso_chitiet.repositories.QuaTrinhCongTacRepository;
import com.hrm.hoso_chitiet.repositories.QuanHeGiaDinhRepository;
import com.hrm.hoso_chitiet.repositories.TinHocRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor // create constructor if field is set final or @notnull
@FieldDefaults(level = AccessLevel.PRIVATE)
public class HoSoChiTietServices {
    //DI
    final LamViecChoCheDoCuRepository lamViecChoCheDoCuRepository;
    final KhenThuongRepository khenThuongRepository;
    final KienThucAnNinhQuocPhongRepository kienThucAnNinhQuocPhongRepository;
    final KyLuatRepository kyLuatRepository;
    final LamViecONuocNgoaiRepository lamViecONuocNgoaiRepository;
    final LuongBanThanRepository luongBanThanRepository;
    final LyLuanChinhTriRepository lyLuanChinhTriRepository;
    final NghiepVuChuyenNganhRepository nghiepVuChuyenNganhRepository;
    final NgoaiNguRepository ngoaiNguRepository;
    final PhuCapKhacRepository phuCapKhacRepository;
    final QuanHeGiaDinhRepository quanHeGiaDinhRepository;
    final QuaTrinhCongTacRepository quaTrinhCongTacRepository;
    final TinHocRepository tinHocRepository;

    public ResHoSoChiTiet getAllByHoSoId(UUID id) {
        List<LamViecChoCheDoCu> cheDoCus = lamViecChoCheDoCuRepository.getAllByHoSo(id);
        List<KhenThuong> khenThuongs = khenThuongRepository.getAllByHoSo(id);
        List<KienThucAnNinhQuocPhong> ninhQuocPhongs = kienThucAnNinhQuocPhongRepository.getAllByHoSo(id);
        List<KyLuat> kyLuats = kyLuatRepository.getAllByHoSo(id);
        List<LamViecONuocNgoai> nuocNgoais = lamViecONuocNgoaiRepository.getAllByHoSo(id);
        List<LuongBanThan> luongBanThans = luongBanThanRepository.getAllByHoSo(id);
        List<LyLuanChinhTri> tris = lyLuanChinhTriRepository.getAllByHoSo(id);
        List<NghiepVuChuyenNganh> chuyenNganhs = nghiepVuChuyenNganhRepository.getAllByHoSo(id);
        List<NgoaiNgu> ngoaiNgus = ngoaiNguRepository.getAllByHoSo(id);
        List<PhuCapKhac> phuCapKhacs = phuCapKhacRepository.getAllByHoSo(id);
        List<QuanHeGiaDinh> quanHeGiaDinhs = quanHeGiaDinhRepository.getAllByHoSo(id);
        List<QuaTrinhCongTac> congTacs = quaTrinhCongTacRepository.getAllByHoSo(id);
        List<TinHoc> tinHocs = tinHocRepository.getAllByHoSo(id);
        return new ResHoSoChiTiet(
                cheDoCus, khenThuongs, ninhQuocPhongs, kyLuats, nuocNgoais, luongBanThans, tris,
                chuyenNganhs, ngoaiNgus, phuCapKhacs, quanHeGiaDinhs, congTacs, tinHocs
        );
    }


    @Service
    public class LamViecChoCheDoCuService implements IHoSoChiTietServices.ILamViecChoCheDoCuServiceChiTiet {
        @Override
        public List<LamViecChoCheDoCu> xemDanhSach() {
            return lamViecChoCheDoCuRepository.findAll();
        }

        @Override
        public List<LamViecChoCheDoCu> xemDanhSachTheoHoSo(UUID id) {
            return lamViecChoCheDoCuRepository.getAllByHoSo(id);
        }

        @Override
        public LamViecChoCheDoCu xemChiTiet(int id) {
            try {
                return lamViecChoCheDoCuRepository.findById(id).orElse(null);
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }

        @Override
        public LamViecChoCheDoCu them(UUID id, ReqLamViecChoCheDoCu req) {
            try {
                return lamViecChoCheDoCuRepository.save(new LamViecChoCheDoCu(req.batDau(), req.ketThuc(), req.chucDanhDonViDiaDiem(), id));
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }

        @Override
        public LamViecChoCheDoCu sua(int id, ReqLamViecChoCheDoCu req) {
            try {
                return lamViecChoCheDoCuRepository.findById(id).map(c -> {
                    c.setBatDau(req.batDau() != null ? req.batDau() : c.getBatDau());
                    c.setKetThuc(req.ketThuc() != null ? req.ketThuc() : c.getKetThuc());
                    c.setChucDanhDonViDiaDiem(req.chucDanhDonViDiaDiem() != null ? req.chucDanhDonViDiaDiem() : c.getChucDanhDonViDiaDiem());
                    c.setUpdate_at();
                    return lamViecChoCheDoCuRepository.save(c);
                }).orElse(null);
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }

        @Override
        public boolean xoa(int id) {
            try {
                return lamViecChoCheDoCuRepository.findById(id).map(c -> {
                    lamViecChoCheDoCuRepository.deleteById(id);
                    return true;
                }).orElse(false);
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }
    }

    @Service
    public class KhenThuongService implements IHoSoChiTietServices.IHoKhenThuongServiceChiTiet {
        @Override
        public List<KhenThuong> xemDanhSach() {
            return khenThuongRepository.findAll();
        }

        @Override
        public List<KhenThuong> xemDanhSachTheoHoSo(UUID id) {
            return khenThuongRepository.getAllByHoSo(id);
        }

        @Override
        public KhenThuong xemChiTiet(int id) {
            try {
                return khenThuongRepository.findById(id).orElse(null);
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }

        @Override
        public KhenThuong them(UUID id, ReqKhenThuong req) {
            try {
                return khenThuongRepository.save(new KhenThuong(req.nam(), req.xepLoaiChuyenMon(), req.xepLoaiThiDua(), req.hinhThucKhenThuong(), req.lyDo(), XacNhan.CHO_XAC_NHAN, id));
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }

        @Override
        public KhenThuong sua(int id, ReqKhenThuong req) {
            try {
                return khenThuongRepository.findById(id).map(c -> {
                    c.setNam(req.nam());
                    c.setXepLoaiChuyenMon(req.xepLoaiChuyenMon());
                    c.setXepLoaiThiDua(req.xepLoaiThiDua());
                    c.setHinhThucKhenThuongId(req.hinhThucKhenThuong());
                    c.setLyDo(req.lyDo());
                    c.setUpdate_at();
                    return khenThuongRepository.save(c);
                }).orElse(null);
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }

        @Override
        public boolean xoa(int id) {
            try {
                return khenThuongRepository.findById(id).map(c -> {
                    khenThuongRepository.deleteById(id);
                    return true;
                }).orElse(false);
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }
    }

    @Service
    public class KienThucAnNinhQuocPhongService implements IHoSoChiTietServices.IHoKienThucAnNinhQuocPhongServiceChiTiet {
        @Override
        public List<KienThucAnNinhQuocPhong> xemDanhSach() {
            return kienThucAnNinhQuocPhongRepository.findAll();
        }

        @Override
        public List<KienThucAnNinhQuocPhong> xemDanhSachTheoHoSo(UUID id) {
            return kienThucAnNinhQuocPhongRepository.getAllByHoSo(id);
        }

        @Override
        public KienThucAnNinhQuocPhong xemChiTiet(int id) {
            try {
                return kienThucAnNinhQuocPhongRepository.findById(id).orElse(null);
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }

        @Override
        public KienThucAnNinhQuocPhong them(UUID id, ReqKienThucAnNinhQuocPhong req) {
            try {
                return kienThucAnNinhQuocPhongRepository.save(
                        new KienThucAnNinhQuocPhong(req.batDau(), req.ketThuc(), req.tenCoSoDaoTao(), req.chungChiDuocCap(), XacNhan.CHO_XAC_NHAN, id)
                );
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }

        @Override
        public KienThucAnNinhQuocPhong sua(int id, ReqKienThucAnNinhQuocPhong req) {
            try {
                return kienThucAnNinhQuocPhongRepository.findById(id).map(c -> {
                    c.setBatDau(req.batDau());
                    c.setKetThuc(req.ketThuc());
                    c.setTenCoSoDaoTaoId(req.tenCoSoDaoTao());
                    c.setChungChiDuocCap(req.chungChiDuocCap());
                    c.setUpdate_at();
                    return kienThucAnNinhQuocPhongRepository.save(c);
                }).orElse(null);
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }

        @Override
        public boolean xoa(int id) {
            try {
                return kienThucAnNinhQuocPhongRepository.findById(id).map(c -> {
                    kienThucAnNinhQuocPhongRepository.deleteById(id);
                    return true;
                }).orElse(false);
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }
    }

    @Service
    public class KyLuatService implements IHoSoChiTietServices.IHoKyLuatServiceChiTiet {
        @Override
        public List<KyLuat> xemDanhSach() {
            return kyLuatRepository.findAll();
        }

        @Override
        public List<KyLuat> xemDanhSachTheoHoSo(UUID id) {
            return kyLuatRepository.getAllByHoSo(id);
        }

        @Override
        public KyLuat xemChiTiet(int id) {
            try {
                return kyLuatRepository.findById(id).orElse(null);
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }

        @Override
        public KyLuat them(UUID id, ReqKyLuat req) {
            try {
                return kyLuatRepository.save(new KyLuat(req.batDau(), req.ketThuc(), req.hinhThuc(), req.hanhViViPhamChinh(), req.coQuanQuyetDinh(), XacNhan.CHO_XAC_NHAN, id));
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }

        @Override
        public KyLuat sua(int id, ReqKyLuat req) {
            try {
                return kyLuatRepository.findById(id).map(c -> {
                    c.setBatDau(req.batDau());
                    c.setKetThuc(req.ketThuc());
                    c.setHinhThuc(req.hinhThuc());
                    c.setHanhViViPhamChinh(req.hanhViViPhamChinh());
                    c.setCoQuanQuyetDinhId(req.coQuanQuyetDinh());
                    c.setUpdate_at();
                    return kyLuatRepository.save(c);
                }).orElse(null);
            } catch (RuntimeException e) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND);
            }
        }

        @Override
        public boolean xoa(int id) {
            try {
                return kyLuatRepository.findById(id).map(c -> {
                    kyLuatRepository.deleteById(id);
                    return true;
                }).orElse(false);
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }
    }

    @Service
    public class LamViecONuocNgoaiServcie implements IHoSoChiTietServices.IHoLamViecONuocNgoaiServiceChiTiet {
        @Override
        public List<LamViecONuocNgoai> xemDanhSach() {
            return lamViecONuocNgoaiRepository.findAll();
        }

        @Override
        public List<LamViecONuocNgoai> xemDanhSachTheoHoSo(UUID id) {
            return lamViecONuocNgoaiRepository.getAllByHoSo(id);
        }

        @Override
        public LamViecONuocNgoai xemChiTiet(int id) {
            try {
                return lamViecONuocNgoaiRepository.findById(id).orElse(null);
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }

        @Override
        public LamViecONuocNgoai them(UUID id, ReqLamViecONuocNgoai req) {
            try {
                return lamViecONuocNgoaiRepository.save(
                        new LamViecONuocNgoai(req.batDau(), req.ketThuc(), req.toChucDiaChiCongViec(), id)
                );
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }

        @Override
        public LamViecONuocNgoai sua(int id, ReqLamViecONuocNgoai req) {
            try {
                return lamViecONuocNgoaiRepository.findById(id).map(c -> {
                    c.setBatDau(req.batDau());
                    c.setKetThuc(req.ketThuc());
                    c.setToChucDiaChiCongViec(req.toChucDiaChiCongViec());
                    c.setUpdate_at();
                    return lamViecONuocNgoaiRepository.save(c);
                }).orElse(null);
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }

        @Override
        public boolean xoa(int id) {
            try {
                return lamViecONuocNgoaiRepository.findById(id).map(c -> {
                    lamViecONuocNgoaiRepository.deleteById(id);
                    return true;
                }).orElse(false);
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }
    }

    @Service
    public class LuongBanThanService implements IHoSoChiTietServices.IHoLuongBanThanServiceChiTiet {
        @Override
        public List<LuongBanThan> xemDanhSach() {
            return luongBanThanRepository.findAll();
        }

        @Override
        public List<LuongBanThan> xemDanhSachTheoHoSo(UUID id) {
            return luongBanThanRepository.getAllByHoSo(id);
        }

        @Override
        public LuongBanThan xemChiTiet(int id) {
            try {
                return luongBanThanRepository.findById(id).orElse(null);
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }

        @Override
        public LuongBanThan them(UUID id, ReqLuongBanThan req) {
            try {
                return luongBanThanRepository.save(
                        new LuongBanThan(req.batDau(), req.ketThuc(), req.maSo(), req.bacLuong(), req.heSoLuong(), req.tienLuongTheoViTri(), id)
                );
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }

        @Override
        public LuongBanThan sua(int id, ReqLuongBanThan req) {
            try {
                return luongBanThanRepository.findById(id).map(c -> {
                    c.setBatDau(req.batDau());
                    c.setKetThuc(req.ketThuc());
                    c.setMaSo(req.maSo());
                    c.setBacLuong(req.bacLuong());
                    c.setHeSoLuong(req.heSoLuong());
                    c.setTienLuongTheoViTri(req.tienLuongTheoViTri());
                    c.setUpdate_at();
                    return luongBanThanRepository.save(c);
                }).orElse(null);
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }

        @Override
        public boolean xoa(int id) {
            try {
                return luongBanThanRepository.findById(id).map(c -> {
                    luongBanThanRepository.deleteById(id);
                    return true;
                }).orElse(false);
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }
    }

    @Service
    public class LyHoLuanChinhTriServiceChiTiet implements IHoSoChiTietServices.IHoLyLuanChinhTriServiceChiTiet {
        @Override
        public List<LyLuanChinhTri> xemDanhSach() {
            return lyLuanChinhTriRepository.findAll();
        }

        @Override
        public List<LyLuanChinhTri> xemDanhSachTheoHoSo(UUID id) {
            return lyLuanChinhTriRepository.getAllByHoSo(id);
        }

        @Override
        public LyLuanChinhTri xemChiTiet(int id) {
            try {
                return lyLuanChinhTriRepository.findById(id).orElse(null);
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }

        @Override
        public LyLuanChinhTri them(UUID id, ReqLyLuanChinhTri req) {
            try {
                LyLuanChinhTri tri = new LyLuanChinhTri(req.batDau(), req.ketThuc(), req.tenCoSoDaoTao(), req.hinhThucDaoTao(), req.vanBangDuocCap(), XacNhan.CHO_XAC_NHAN, id);
                tri.setXacNhan(XacNhan.CHO_XAC_NHAN);
                return lyLuanChinhTriRepository.save(tri);
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }

        @Override
        public LyLuanChinhTri sua(int id, ReqLyLuanChinhTri req) {
            try {
                return lyLuanChinhTriRepository.findById(id).map(c -> {
                    c.setBatDau(req.batDau());
                    c.setKetThuc(req.ketThuc());
                    c.setTenCoSoDaoTaoId(req.tenCoSoDaoTao());
                    c.setHinhThucDaoTao(req.hinhThucDaoTao());
                    c.setVanBangDuocCap(req.vanBangDuocCap());
                    c.setUpdate_at();
                    return lyLuanChinhTriRepository.save(c);
                }).orElse(null);
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }

        @Override
        public boolean xoa(int id) {
            try {
                return lyLuanChinhTriRepository.findById(id).map(c -> {
                    lyLuanChinhTriRepository.deleteById(id);
                    return true;
                }).orElse(false);
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }
    }

    @Service
    public class NghiepVuChuyenNganhService implements IHoSoChiTietServices.IHoNghiepVuChuyenNganhServiceChiTiet {
        @Override
        public List<NghiepVuChuyenNganh> xemDanhSach() {
            return nghiepVuChuyenNganhRepository.findAll();
        }

        @Override
        public List<NghiepVuChuyenNganh> xemDanhSachTheoHoSo(UUID id) {
            return nghiepVuChuyenNganhRepository.getAllByHoSo(id);
        }

        @Override
        public NghiepVuChuyenNganh xemChiTiet(int id) {
            try {
                return nghiepVuChuyenNganhRepository.findById(id).orElse(null);
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }

        @Override
        public NghiepVuChuyenNganh them(UUID id, ReqNghiepVuChuyenNganh req) {
            try {
                NghiepVuChuyenNganh vu = new NghiepVuChuyenNganh(req.batDau(), req.ketThuc(), req.tenCoSoDaoTao(), req.chungChiDuocCap(), XacNhan.CHO_XAC_NHAN, id);
                vu.setXacNhan(XacNhan.CHO_XAC_NHAN);
                return nghiepVuChuyenNganhRepository.save(vu);
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }

        @Override
        public NghiepVuChuyenNganh sua(int id, ReqNghiepVuChuyenNganh req) {
            try {
                return nghiepVuChuyenNganhRepository.findById(id).map(c -> {
                    c.setBatDau(req.batDau());
                    c.setKetThuc(req.ketThuc());
                    c.setTenCoSoDaoTaoId(req.tenCoSoDaoTao());
                    c.setChungChiDuocCap(req.chungChiDuocCap());
                    c.setUpdate_at();
                    return nghiepVuChuyenNganhRepository.save(c);
                }).orElse(null);
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }

        @Override
        public boolean xoa(int id) {
            try {
                return nghiepVuChuyenNganhRepository.findById(id).map(c -> {
                    nghiepVuChuyenNganhRepository.deleteById(id);
                    return true;
                }).orElse(false);
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }
    }

    @Service
    public class NgoaiNguService implements IHoSoChiTietServices.IHoNgoaiNguServiceChiTiet {
        @Override
        public List<NgoaiNgu> xemDanhSach() {
            return ngoaiNguRepository.findAll();
        }

        @Override
        public List<NgoaiNgu> xemDanhSachTheoHoSo(UUID id) {
            return ngoaiNguRepository.getAllByHoSo(id);
        }

        @Override
        public NgoaiNgu xemChiTiet(int id) {
            try {
                return ngoaiNguRepository.findById(id).orElse(null);
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }

        @Override
        public NgoaiNgu them(UUID id, ReqNgoaiNgu req) {
            try {
                NgoaiNgu ngu = new NgoaiNgu(req.batDau(), req.ketThuc(), req.tenCoSoDaoTao(), req.tenNgoaiNgu(), req.chungChiDuocCap(), req.diemSo(), XacNhan.CHO_XAC_NHAN, id);
                ngu.setXacNhan(XacNhan.CHO_XAC_NHAN);
                return ngoaiNguRepository.save(ngu);
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }

        @Override
        public NgoaiNgu sua(int id, ReqNgoaiNgu req) {
            try {
                return ngoaiNguRepository.findById(id).map(c -> {
                    c.setBatDau(req.batDau());
                    c.setKetThuc(req.ketThuc());
                    c.setTenCoSoDaoTaoId(req.tenCoSoDaoTao());
                    c.setTenNgoaiNgu(req.tenNgoaiNgu());
                    c.setChungChiDuocCap(req.chungChiDuocCap());
                    c.setDiemSo(req.diemSo());
                    c.setUpdate_at();
                    return ngoaiNguRepository.save(c);
                }).orElse(null);
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }

        @Override
        public boolean xoa(int id) {
            try {
                return ngoaiNguRepository.findById(id).map(c -> {
                    ngoaiNguRepository.deleteById(id);
                    return true;
                }).orElse(false);
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }
    }

    @Service
    public class PhuCapKhacService implements IHoSoChiTietServices.IHoPhuCapKhacServiceChiTiet {
        @Override
        public List<PhuCapKhac> xemDanhSach() {
            return phuCapKhacRepository.findAll();
        }

        @Override
        public List<PhuCapKhac> xemDanhSachTheoHoSo(UUID id) {
            return phuCapKhacRepository.getAllByHoSo(id);
        }

        @Override
        public PhuCapKhac xemChiTiet(int id) {
            try {
                return phuCapKhacRepository.findById(id).orElse(null);
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }

        @Override
        public PhuCapKhac them(UUID id, ReqPhuCapKhac req) {
            return phuCapKhacRepository.save(new PhuCapKhac(
                    req.batDau(), req.ketThuc(), req.loaiPhuCap(), req.phanTramHuongPhuCap(), req.heSoPhuCap(), req.hinhThucThuong(), req.giaTri(), id));
        }

        @Override
        public PhuCapKhac sua(int id, ReqPhuCapKhac req) {
            try {
                return phuCapKhacRepository.findById(id).map(c -> {
                    c.setBatDau(req.batDau());
                    c.setKetThuc(req.ketThuc());
                    c.setLoaiPhuCapId(req.loaiPhuCap());
                    c.setPhanTramHuongPhuCap(req.phanTramHuongPhuCap());
                    c.setHeSoPhuCap(req.heSoPhuCap());
                    c.setHinhThucHuong(req.hinhThucThuong());
                    c.setGiaTri(req.giaTri());
                    c.setUpdate_at();
                    return phuCapKhacRepository.save(c);
                }).orElse(null);
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }

        @Override
        public boolean xoa(int id) {
            try {
                return phuCapKhacRepository.findById(id).map(c -> {
                    phuCapKhacRepository.deleteById(id);
                    return true;
                }).orElse(false);
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }
    }

    @Service
    public class QuanHeGiaDinhService implements IHoSoChiTietServices.IHoQuanHeGiaDinhServiceChiTiet {
        @Override
        public List<QuanHeGiaDinh> xemDanhSach() {
            return quanHeGiaDinhRepository.findAll();
        }

        @Override
        public List<QuanHeGiaDinh> xemDanhSachTheoHoSo(UUID id) {
            return quanHeGiaDinhRepository.getAllByHoSo(id);
        }

        @Override
        public QuanHeGiaDinh xemChiTiet(int id) {
            try {
                return quanHeGiaDinhRepository.findById(id).orElse(null);
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }

        @Override
        public QuanHeGiaDinh them(UUID id, ReqQuanHeGiaDinh req) {
            try {
                QuanHeGiaDinh dinh = new QuanHeGiaDinh(req.moiQuanHe(), req.hoVaTen(), req.namSinh(), req.thongTinThanNhan(), id);
                return quanHeGiaDinhRepository.save(dinh);
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }

        @Override
        public QuanHeGiaDinh sua(int id, ReqQuanHeGiaDinh req) {
            try {
                return quanHeGiaDinhRepository.findById(id).map(c -> {
                    c.setMoiQuanHe(req.moiQuanHe());
                    c.setHoVaTen(req.hoVaTen());
                    c.setNamSinh(req.namSinh());
                    c.setThongTinThanNhan(req.thongTinThanNhan());
                    c.setUpdate_at();
                    return quanHeGiaDinhRepository.save(c);
                }).orElse(null);
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }

        @Override
        public boolean xoa(int id) {
            try {
                return quanHeGiaDinhRepository.findById(id).map(c -> {
                    quanHeGiaDinhRepository.deleteById(id);
                    return true;
                }).orElse(false);
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }
    }

    @Service
    public class QuaTrinhCongTacService implements IHoSoChiTietServices.IHoQuaTrinhCongTacServiceChiTiet {
        @Override
        public List<QuaTrinhCongTac> xemDanhSach() {
            return quaTrinhCongTacRepository.findAll();
        }

        @Override
        public List<QuaTrinhCongTac> xemDanhSachTheoHoSo(UUID id) {
            return quaTrinhCongTacRepository.getAllByHoSo(id);
        }

        @Override
        public QuaTrinhCongTac xemChiTiet(int id) {
            try {
                return quaTrinhCongTacRepository.findById(id).orElse(null);
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }

        @Override
        public QuaTrinhCongTac them(UUID id, ReqQuaTrinhCongTac req) {
            try {
                return quaTrinhCongTacRepository.save(new QuaTrinhCongTac(req.batDau(), req.ketThuc(), req.donViCongTac(), req.chucDanh(), id));
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }

        @Override
        public QuaTrinhCongTac sua(int id, ReqQuaTrinhCongTac req) {
            try {
                return quaTrinhCongTacRepository.findById(id).map(c -> {
                    c.setBatDau(req.batDau());
                    c.setKetThuc(req.ketThuc());
                    c.setDonViCongTacId(req.donViCongTac());
                    c.setChucDanh(req.chucDanh());
                    c.setUpdate_at();
                    return quaTrinhCongTacRepository.save(c);
                }).orElse(null);
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }

        @Override
        public boolean xoa(int id) {
            try {
                return quaTrinhCongTacRepository.findById(id).map(c -> {
                    quaTrinhCongTacRepository.deleteById(id);
                    return true;
                }).orElse(false);
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }
    }

    @Service
    public class TinHocService implements IHoSoChiTietServices.IHoTinHocServiceChiTiet {
        @Override
        public List<TinHoc> xemDanhSach() {
            return tinHocRepository.findAll();
        }

        @Override
        public List<TinHoc> xemDanhSachTheoHoSo(UUID id) {
            return tinHocRepository.getAllByHoSo(id);
        }

        @Override
        public TinHoc xemChiTiet(int id) {
            try {
                return tinHocRepository.findById(id).orElse(null);
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }

        @Override
        public TinHoc them(UUID id, ReqTinHoc req) {
            try {
                TinHoc tin = new TinHoc(req.batDau(), req.ketThuc(), req.tenCoSoDaoTao(), req.chungChiDuocCap(), id);
                return tinHocRepository.save(tin);
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }

        @Override
        public TinHoc sua(int id, ReqTinHoc req) {
            try {
                return tinHocRepository.findById(id).map(c -> {
                    c.setBatDau(req.batDau());
                    c.setKetThuc(req.ketThuc());
                    c.setTenCoSoDaoTaoId(req.tenCoSoDaoTao());
                    c.setChungChiDuocCap(req.chungChiDuocCap());
                    c.setUpdate_at();
                    return tinHocRepository.save(c);
                }).orElse(null);
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }

        @Override
        public boolean xoa(int id) {
            try {
                return tinHocRepository.findById(id).map(c -> {
                    tinHocRepository.deleteById(id);
                    return true;
                }).orElse(false);
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }
    }
}