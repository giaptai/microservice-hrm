package com.hrm.hoso_chitiet.services;

import com.hrm.hoso_chitiet.client.ho_so.HoSoClient;
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
import com.hrm.hoso_chitiet.dto.response.ResKhenThuong;
import com.hrm.hoso_chitiet.dto.response.ResKienThucAnNinhQuocPhong;
import com.hrm.hoso_chitiet.dto.response.ResKyLuat;
import com.hrm.hoso_chitiet.dto.response.ResLamViecChoCheDoCu;
import com.hrm.hoso_chitiet.dto.response.ResLamViecONuocNgoai;
import com.hrm.hoso_chitiet.dto.response.ResLuongBanThan;
import com.hrm.hoso_chitiet.dto.response.ResLyLuanChinhTri;
import com.hrm.hoso_chitiet.dto.response.ResNghiepVuChuyenNganh;
import com.hrm.hoso_chitiet.dto.response.ResNgoaiNgu;
import com.hrm.hoso_chitiet.dto.response.ResPhuCapKhac;
import com.hrm.hoso_chitiet.dto.response.ResQuaTrinhCongTac;
import com.hrm.hoso_chitiet.dto.response.ResQuanHeGiaDinh;
import com.hrm.hoso_chitiet.dto.response.ResTinHoc;
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
import com.hrm.hoso_chitiet.response.ResEnum;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
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
    //clients
    final HoSoClient hoSoClient;

//    public ResHoSoChiTiet getAllByHoSoId(UUID id) {
//        List<LamViecChoCheDoCu> cheDoCus = lamViecChoCheDoCuRepository.getAllByHoSo(id);
//        List<KhenThuong> khenThuongs = khenThuongRepository.getAllByHoSo(id).getContent();
//        List<KienThucAnNinhQuocPhong> ninhQuocPhongs = kienThucAnNinhQuocPhongRepository.getAllByHoSo(id);
//        List<KyLuat> kyLuats = kyLuatRepository.getAllByHoSo(id);
//        List<LamViecONuocNgoai> nuocNgoais = lamViecONuocNgoaiRepository.getAllByHoSo(id);
//        List<LuongBanThan> luongBanThans = luongBanThanRepository.getAllByHoSo(id);
//        List<LyLuanChinhTri> tris = lyLuanChinhTriRepository.getAllByHoSo(id);
//        List<NghiepVuChuyenNganh> chuyenNganhs = nghiepVuChuyenNganhRepository.getAllByHoSo(id);
//        List<NgoaiNgu> ngoaiNgus = ngoaiNguRepository.getAllByHoSo(id);
//        List<PhuCapKhac> phuCapKhacs = phuCapKhacRepository.getAllByHoSo(id);
//        List<QuanHeGiaDinh> quanHeGiaDinhs = quanHeGiaDinhRepository.getAllByHoSo(id);
//        List<QuaTrinhCongTac> congTacs = quaTrinhCongTacRepository.getAllByHoSo(id);
//        List<TinHoc> tinHocs = tinHocRepository.getAllByHoSo(id);
//        return new ResHoSoChiTiet(
//                cheDoCus, khenThuongs, ninhQuocPhongs, kyLuats, nuocNgoais, luongBanThans, tris,
//                chuyenNganhs, ngoaiNgus, phuCapKhacs, quanHeGiaDinhs, congTacs, tinHocs
//        );
//    }


    @Service
    public class LamViecChoCheDoCuService implements IHoSoChiTietServices.ILamViecChoCheDoCuServiceChiTiet {
        @Override
        public List<LamViecChoCheDoCu> xemDanhSach(int pageNumber, int pageSize) {
            return lamViecChoCheDoCuRepository.findAll(PageRequest.of(pageNumber, pageSize)).getContent();
        }

        @Override
        public List<LamViecChoCheDoCu> xemDanhSachTheoHoSoId(UUID id, int pageNumber, int pageSize) {
            return lamViecChoCheDoCuRepository.getAllByHoSo(id, PageRequest.of(pageNumber, pageSize));
        }

        @Override
        public LamViecChoCheDoCu xemChiTiet(int id) {
            try {
                return lamViecChoCheDoCuRepository.findById(id).orElse(null);
            } catch (RuntimeException e) {
                System.err.println(e.getMessage());
                throw e;
            }
        }

        @Override
        public LamViecChoCheDoCu them(UUID id, ReqLamViecChoCheDoCu req) {
            try {
                return lamViecChoCheDoCuRepository.save(new LamViecChoCheDoCu(req.batDau(), req.ketThuc(), req.chucDanhDonViDiaDiem(), XacNhan.CHO_XAC_NHAN, id));
            } catch (RuntimeException e) {
                System.err.println(e.getMessage());
                throw e;
            }
        }

        @Override
        public LamViecChoCheDoCu sua(int id, ReqLamViecChoCheDoCu req, String role) {
            try {
                return lamViecChoCheDoCuRepository.findById(id).map(c -> {
                    if (role.equals("ADMIN") ||
                            (role.equals("EMPLOYEE")
                                    && c.getXacNhan().equals(XacNhan.CHO_XAC_NHAN))) {
                        c.setBatDau(req.batDau() != null ? req.batDau() : c.getBatDau());
                        c.setKetThuc(req.ketThuc() != null ? req.ketThuc() : c.getKetThuc());
                        c.setChucDanhDonViDiaDiem(req.chucDanhDonViDiaDiem() != null ? req.chucDanhDonViDiaDiem() : c.getChucDanhDonViDiaDiem());
                        c.setUpdate_at();
                        return lamViecChoCheDoCuRepository.save(c);
                    } else throw new
                            ResponseStatusException(ResEnum.KHONG_DUOC_UY_QUYEN.getStatusCode());
                }).orElse(null);
            } catch (RuntimeException e) {
                System.err.println(e.getMessage());
                throw e;
            }
        }

        @Override
        public boolean xoa(int id, String role) {
            try {
                return lamViecChoCheDoCuRepository.findById(id).map(c -> {
                    if (role.equals("ADMIN") || (role.equals("EMPLOYEE") && c.getXacNhan().equals(XacNhan.CHO_XAC_NHAN))) {
                        lamViecChoCheDoCuRepository.deleteById(id);
                        return true;
                    } else throw
                            new ResponseStatusException(ResEnum.KHONG_DUOC_UY_QUYEN.getStatusCode());
                }).orElse(false);
            } catch (RuntimeException e) {
                System.err.println(e.getMessage());
                throw e;
            }
        }

        @Override
        public List<LamViecChoCheDoCu> xemDanhSachCaNhan(int taiKhoanId, int pageNumber, int pageSize) {
            UUID id = hoSoClient.getHoSoId(taiKhoanId);
            return xemDanhSachTheoHoSoId(id, pageNumber, pageSize);
        }

        @Override
        public LamViecChoCheDoCu themCaNhan(int taiKhoanId, ReqLamViecChoCheDoCu cu) {
            UUID id = hoSoClient.getHoSoId(taiKhoanId);
            return them(id, cu);
        }

        @Override
        public boolean xacNhan(XacNhan xacNhan, List<ResLamViecChoCheDoCu> res) {
            List<LamViecChoCheDoCu> lamViecChoCheDoCus = new ArrayList<>();
            for(ResLamViecChoCheDoCu c : res){
                LamViecChoCheDoCu cu = lamViecChoCheDoCuRepository.findById(c.id()).orElseThrow(() -> new ResponseStatusException(ResEnum.KHONG_DUOC_UY_QUYEN.getStatusCode()));
                cu.setXacNhan(xacNhan);
                cu.setUpdate_at();
                lamViecChoCheDoCus.add(cu);
            }
            lamViecChoCheDoCuRepository.saveAll(lamViecChoCheDoCus);
            return true;
        }
    }

    @Service
    public class KhenThuongService implements IHoSoChiTietServices.IHoKhenThuongServiceChiTiet {
        @Override
        public List<KhenThuong> xemDanhSach(int pageNumber, int pageSize) {
            return khenThuongRepository.findAll(PageRequest.of(pageNumber, pageSize)).getContent();
        }

        @Override
        public List<KhenThuong> xemDanhSachTheoHoSoId(UUID id, int pageNumber, int pageSize) {
            return khenThuongRepository.getAllByHoSo(id, PageRequest.of(pageNumber, pageSize));
        }

        @Override
        public KhenThuong xemChiTiet(int id) {
            try {
                return khenThuongRepository.findById(id).orElse(null);
            } catch (RuntimeException e) {
                System.err.println(e.getMessage());
                throw e;
            }
        }

        @Override
        public KhenThuong them(UUID id, ReqKhenThuong req) {
            try {
                return khenThuongRepository.save(new KhenThuong(req.nam(), req.xepLoaiChuyenMon(), req.xepLoaiThiDua(), req.hinhThucKhenThuongId(), req.lyDo(), XacNhan.CHO_XAC_NHAN, id));
            } catch (RuntimeException e) {
                System.err.println(e.getMessage());
                throw e;
            }
        }

        @Override
        public KhenThuong sua(int id, ReqKhenThuong req, String role) {
            try {
                return khenThuongRepository.findById(id).map(c -> {
                    if (role.equals("ADMIN") ||
                            (role.equals("EMPLOYEE")
                                    && c.getXacNhan().equals(XacNhan.CHO_XAC_NHAN))) {
                        c.setNam(req.nam() != null ? req.nam() : c.getNam());
                        c.setXepLoaiChuyenMon(req.xepLoaiChuyenMon());
                        c.setXepLoaiThiDua(req.xepLoaiThiDua());
                        c.setHinhThucKhenThuongId(req.hinhThucKhenThuongId());
                        c.setLyDo(req.lyDo());
                        c.setUpdate_at();
                        return khenThuongRepository.save(c);
                    } else throw new
                            ResponseStatusException(ResEnum.KHONG_DUOC_UY_QUYEN.getStatusCode());
                }).orElse(null);
            } catch (RuntimeException e) {
                System.err.println(e.getMessage());
                throw e;
            }
        }

        @Override
        public boolean xoa(int id, String role) {
            try {
                return khenThuongRepository.findById(id).map(c -> {
                    if (role.equals("ADMIN") ||
                            (role.equals("EMPLOYEE")
                                    && c.getXacNhan().equals(XacNhan.CHO_XAC_NHAN))) {
                        khenThuongRepository.deleteById(id);
                        return true;
                    } else throw
                            new ResponseStatusException(ResEnum.KHONG_DUOC_UY_QUYEN.getStatusCode());
                }).orElse(false);
            } catch (RuntimeException e) {
                System.err.println(e.getMessage());
                throw e;
            }
        }

        @Override
        public List<KhenThuong> xemDanhSachCaNhan(int taiKhoanId, int pageNumber, int pageSize) {
            UUID id = hoSoClient.getHoSoId(taiKhoanId);
            return xemDanhSachTheoHoSoId(id, pageNumber, pageSize);
        }

        @Override
        public KhenThuong themCaNhan(int taiKhoanId, ReqKhenThuong cu) {
            UUID id = hoSoClient.getHoSoId(taiKhoanId);
            return them(id, cu);
        }
        @Override
        public boolean xacNhan(XacNhan xacNhan, List<ResKhenThuong> res) {
            List<KhenThuong> khenThuongs = new ArrayList<>();
            for(ResKhenThuong c : res){
                KhenThuong cu = khenThuongRepository.findById(c.id()).orElseThrow(() -> new ResponseStatusException(ResEnum.KHONG_DUOC_UY_QUYEN.getStatusCode()));
                cu.setXacNhan(xacNhan);
                cu.setUpdate_at();
                khenThuongs.add(cu);
            }
            khenThuongRepository.saveAll(khenThuongs);
            return true;
        }
    }

    @Service
    public class KienThucAnNinhQuocPhongService implements IHoSoChiTietServices.IHoKienThucAnNinhQuocPhongServiceChiTiet {
        @Override
        public List<KienThucAnNinhQuocPhong> xemDanhSach(int pageNumber, int pageSize) {
            return kienThucAnNinhQuocPhongRepository.findAll(PageRequest.of(pageNumber, pageSize)).getContent();
        }

        @Override
        public List<KienThucAnNinhQuocPhong> xemDanhSachTheoHoSoId(UUID id, int pageNumber, int pageSize) {
            return kienThucAnNinhQuocPhongRepository.getAllByHoSo(id, PageRequest.of(pageNumber, pageSize));
        }

        @Override
        public KienThucAnNinhQuocPhong xemChiTiet(int id) {
            try {
                return kienThucAnNinhQuocPhongRepository.findById(id).orElse(null);
            } catch (RuntimeException e) {
                System.err.println(e.getMessage());
                throw e;
            }
        }

        @Override
        public KienThucAnNinhQuocPhong them(UUID id, ReqKienThucAnNinhQuocPhong req) {
            try {
                return kienThucAnNinhQuocPhongRepository.save(
                        new KienThucAnNinhQuocPhong(req.batDau(), req.ketThuc(), req.tenCoSoDaoTao(), req.chungChiDuocCap(), XacNhan.CHO_XAC_NHAN, id)
                );
            } catch (RuntimeException e) {
                System.err.println(e.getMessage());
                throw e;
            }
        }

        @Override
        public KienThucAnNinhQuocPhong sua(int id, ReqKienThucAnNinhQuocPhong req, String role) {
            try {
                return kienThucAnNinhQuocPhongRepository.findById(id).map(c -> {
                    if (role.equals("ADMIN") ||
                            (role.equals("EMPLOYEE")
                                    && c.getXacNhan().equals(XacNhan.CHO_XAC_NHAN))) {
                        c.setBatDau(req.batDau());
                        c.setKetThuc(req.ketThuc());
                        c.setTenCoSoDaoTaoId(req.tenCoSoDaoTao());
                        c.setChungChiDuocCap(req.chungChiDuocCap());
                        c.setUpdate_at();
                        return kienThucAnNinhQuocPhongRepository.save(c);
                    } else throw new
                            ResponseStatusException(ResEnum.KHONG_DUOC_UY_QUYEN.getStatusCode());
                }).orElse(null);
            } catch (RuntimeException e) {
                System.err.println(e.getMessage());
                throw e;
            }
        }

        @Override
        public boolean xoa(int id, String role) {
            try {
                return kienThucAnNinhQuocPhongRepository.findById(id).map(c -> {
                    if (role.equals("ADMIN") ||
                            (role.equals("EMPLOYEE")
                                    && c.getXacNhan().equals(XacNhan.CHO_XAC_NHAN))) {
                        kienThucAnNinhQuocPhongRepository.deleteById(id);
                        return true;
                    } else throw
                            new ResponseStatusException(
                                    ResEnum.KHONG_DUOC_UY_QUYEN.getStatusCode());
                }).orElse(false);
            } catch (RuntimeException e) {
                System.err.println(e.getMessage());
                throw e;
            }
        }

        @Override
        public List<KienThucAnNinhQuocPhong> xemDanhSachCaNhan(int taiKhoanId, int pageNumber, int pageSize) {
            UUID id = hoSoClient.getHoSoId(taiKhoanId);
            return xemDanhSachTheoHoSoId(id, pageNumber, pageSize);
        }

        @Override
        public KienThucAnNinhQuocPhong themCaNhan(int taiKhoanId, ReqKienThucAnNinhQuocPhong cu) {
            UUID id = hoSoClient.getHoSoId(taiKhoanId);
            return them(id, cu);
        }

        @Override
        public boolean xacNhan(XacNhan xacNhan, List<ResKienThucAnNinhQuocPhong> res) {
            List<KienThucAnNinhQuocPhong> phongs = new ArrayList<>();
            for(ResKienThucAnNinhQuocPhong c : res){
                KienThucAnNinhQuocPhong cu = kienThucAnNinhQuocPhongRepository.findById(c.id()).orElseThrow(() -> new ResponseStatusException(ResEnum.KHONG_DUOC_UY_QUYEN.getStatusCode()));
                cu.setXacNhan(xacNhan);
                cu.setUpdate_at();
                phongs.add(cu);
            }
            kienThucAnNinhQuocPhongRepository.saveAll(phongs);
            return true;
        }
    }

    @Service
    public class KyLuatService implements IHoSoChiTietServices.IHoKyLuatServiceChiTiet {
        @Override
        public List<KyLuat> xemDanhSach(int pageNumber, int pageSize) {
            return kyLuatRepository.findAll(PageRequest.of(pageNumber, pageSize)).getContent();
        }

        @Override
        public List<KyLuat> xemDanhSachTheoHoSoId(UUID id, int pageNumber, int pageSize) {
            return kyLuatRepository.getAllByHoSo(id, PageRequest.of(pageNumber, pageSize));
        }

        @Override
        public KyLuat xemChiTiet(int id) {
            try {
                return kyLuatRepository.findById(id).orElse(null);
            } catch (RuntimeException e) {
                System.err.println(e.getMessage());
                throw e;
            }
        }

        @Override
        public KyLuat them(UUID id, ReqKyLuat req) {
            try {
                return kyLuatRepository.save(new KyLuat(req.batDau(), req.ketThuc(), req.hinhThuc(), req.hanhViViPhamChinh(), req.coQuanQuyetDinhId(), XacNhan.CHO_XAC_NHAN, id));
            } catch (RuntimeException e) {
                System.err.println(e.getMessage());
                throw e;
            }
        }

        @Override
        public KyLuat sua(int id, ReqKyLuat req, String role) {
            try {
                return kyLuatRepository.findById(id).map(c -> {
                    if (role.equals("ADMIN") ||
                            (role.equals("EMPLOYEE")
                                    && c.getXacNhan().equals(XacNhan.CHO_XAC_NHAN))) {
                        c.setBatDau(req.batDau());
                        c.setKetThuc(req.ketThuc());
                        c.setHinhThuc(req.hinhThuc());
                        c.setHanhViViPhamChinh(req.hanhViViPhamChinh());
                        c.setCoQuanQuyetDinhId(req.coQuanQuyetDinhId());
                        c.setUpdate_at();
                        return kyLuatRepository.save(c);
                    } else throw new
                            ResponseStatusException(
                            ResEnum.KHONG_DUOC_UY_QUYEN.getStatusCode());
                }).orElse(null);
            } catch (RuntimeException e) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND);
            }
        }

        @Override
        public boolean xoa(int id, String role) {
            try {
                return kyLuatRepository.findById(id).map(c -> {
                    if (role.equals("ADMIN") ||
                            (role.equals("EMPLOYEE")
                                    && c.getXacNhan().equals(XacNhan.CHO_XAC_NHAN))) {
                        kyLuatRepository.deleteById(id);
                        return true;
                    } else throw
                            new ResponseStatusException(
                                    ResEnum.KHONG_DUOC_UY_QUYEN.getStatusCode());
                }).orElse(false);
            } catch (RuntimeException e) {
                System.err.println(e.getMessage());
                throw e;
            }
        }

        @Override
        public List<KyLuat> xemDanhSachCaNhan(int taiKhoanId, int pageNumber, int pageSize) {
            UUID id = hoSoClient.getHoSoId(taiKhoanId);
            return xemDanhSachTheoHoSoId(id, pageNumber, pageSize);
        }

        @Override
        public KyLuat themCaNhan(int taiKhoanId, ReqKyLuat cu) {
            UUID id = hoSoClient.getHoSoId(taiKhoanId);
            return them(id, cu);
        }
        @Override
        public boolean xacNhan(XacNhan xacNhan, List<ResKyLuat> res) {
            List<KyLuat> kyLuats = new ArrayList<>();
            for(ResKyLuat c : res){
                KyLuat cu = kyLuatRepository.findById(c.id()).orElseThrow(() -> new ResponseStatusException(ResEnum.KHONG_DUOC_UY_QUYEN.getStatusCode()));
                cu.setXacNhan(xacNhan);
                cu.setUpdate_at();
                kyLuats.add(cu);
            }
            kyLuatRepository.saveAll(kyLuats);
            return true;
        }
    }

    @Service
    public class LamViecONuocNgoaiServcie implements IHoSoChiTietServices.IHoLamViecONuocNgoaiServiceChiTiet {
        @Override
        public List<LamViecONuocNgoai> xemDanhSach(int pageNumber, int pageSize) {
            return lamViecONuocNgoaiRepository.findAll(PageRequest.of(pageNumber, pageSize)).getContent();
        }

        @Override
        public List<LamViecONuocNgoai> xemDanhSachTheoHoSoId(UUID id, int pageNumber, int pageSize) {
            return lamViecONuocNgoaiRepository.getAllByHoSo(id, PageRequest.of(pageNumber, pageSize));
        }

        @Override
        public LamViecONuocNgoai xemChiTiet(int id) {
            try {
                return lamViecONuocNgoaiRepository.findById(id).orElse(null);
            } catch (RuntimeException e) {
                System.err.println(e.getMessage());
                throw e;
            }
        }

        @Override
        public LamViecONuocNgoai them(UUID id, ReqLamViecONuocNgoai req) {
            try {
                return lamViecONuocNgoaiRepository.save(
                        new LamViecONuocNgoai(req.batDau(), req.ketThuc(), req.toChucDiaChiCongViec(), XacNhan.CHO_XAC_NHAN, id)
                );
            } catch (RuntimeException e) {
                System.err.println(e.getMessage());
                throw e;
            }
        }

        @Override
        public LamViecONuocNgoai sua(int id, ReqLamViecONuocNgoai req, String role) {
            try {
                return lamViecONuocNgoaiRepository.findById(id).map(c -> {
                    if (role.equals("ADMIN") ||
                            (role.equals("EMPLOYEE")
                                    && c.getXacNhan().equals(XacNhan.CHO_XAC_NHAN))) {
                        c.setBatDau(req.batDau());
                        c.setKetThuc(req.ketThuc());
                        c.setToChucDiaChiCongViec(req.toChucDiaChiCongViec());
                        c.setUpdate_at();
                        return lamViecONuocNgoaiRepository.save(c);
                    } else throw new
                            ResponseStatusException(
                            ResEnum.KHONG_DUOC_UY_QUYEN.getStatusCode());
                }).orElse(null);
            } catch (RuntimeException e) {
                System.err.println(e.getMessage());
                throw e;
            }
        }

        @Override
        public boolean xoa(int id, String role) {
            try {
                return lamViecONuocNgoaiRepository.findById(id).map(c -> {
                    if (role.equals("ADMIN") ||
                            (role.equals("EMPLOYEE")
                                    && c.getXacNhan().equals(XacNhan.CHO_XAC_NHAN))) {
                        lamViecONuocNgoaiRepository.deleteById(id);
                        return true;
                    } else throw new
                            ResponseStatusException(
                            ResEnum.KHONG_DUOC_UY_QUYEN.getStatusCode());
                }).orElse(false);
            } catch (RuntimeException e) {
                System.err.println(e.getMessage());
                throw e;
            }
        }

        @Override
        public List<LamViecONuocNgoai> xemDanhSachCaNhan(int taiKhoanId, int pageNumber, int pageSize) {
            UUID id = hoSoClient.getHoSoId(taiKhoanId);
            return xemDanhSachTheoHoSoId(id, pageNumber, pageSize);
        }

        @Override
        public LamViecONuocNgoai themCaNhan(int taiKhoanId, ReqLamViecONuocNgoai cu) {
            UUID id = hoSoClient.getHoSoId(taiKhoanId);
            return them(id, cu);
        }

        @Override
        public boolean xacNhan(XacNhan xacNhan, List<ResLamViecONuocNgoai> res) {
            List<LamViecONuocNgoai> ngoais = new ArrayList<>();
            for(ResLamViecONuocNgoai c : res){
                LamViecONuocNgoai cu = lamViecONuocNgoaiRepository.findById(c.id()).orElseThrow(() -> new ResponseStatusException(ResEnum.KHONG_DUOC_UY_QUYEN.getStatusCode()));
                cu.setXacNhan(xacNhan);
                cu.setUpdate_at();
                ngoais.add(cu);
            }
            lamViecONuocNgoaiRepository.saveAll(ngoais);
            return true;
        }
    }

    @Service
    public class LuongBanThanService implements IHoSoChiTietServices.IHoLuongBanThanServiceChiTiet {
        @Override
        public List<LuongBanThan> xemDanhSach(int pageNumber, int pageSize) {
            return luongBanThanRepository.findAll(PageRequest.of(pageNumber, pageSize)).getContent();
        }

        @Override
        public List<LuongBanThan> xemDanhSachTheoHoSoId(UUID id, int pageNumber, int pageSize) {
            return luongBanThanRepository.getAllByHoSo(id, PageRequest.of(pageNumber, pageSize));
        }

        @Override
        public LuongBanThan xemChiTiet(int id) {
            try {
                return luongBanThanRepository.findById(id).orElse(null);
            } catch (RuntimeException e) {
                System.err.println(e.getMessage());
                throw e;
            }
        }

        @Override
        public LuongBanThan them(UUID id, ReqLuongBanThan req) {
            try {
                return luongBanThanRepository.save(
                        new LuongBanThan(req.batDau(), req.ketThuc(), req.maSo(), req.bacLuong(), req.heSoLuong(), req.tienLuongTheoViTri(), XacNhan.CHO_XAC_NHAN, id)
                );
            } catch (RuntimeException e) {
                System.err.println(e.getMessage());
                throw e;
            }
        }

        @Override
        public LuongBanThan sua(int id, ReqLuongBanThan req, String role) {
            try {
                return luongBanThanRepository.findById(id).map(c -> {
                    if (role.equals("ADMIN") ||
                            (role.equals("EMPLOYEE")
                                    && c.getXacNhan().equals(XacNhan.CHO_XAC_NHAN))) {
                        c.setBatDau(req.batDau());
                        c.setKetThuc(req.ketThuc());
                        c.setMaSo(req.maSo());
                        c.setBacLuong(req.bacLuong());
                        c.setHeSoLuong(req.heSoLuong());
                        c.setTienLuongTheoViTri(req.tienLuongTheoViTri());
                        c.setUpdate_at();
                        return luongBanThanRepository.save(c);
                    } else throw new
                            ResponseStatusException(
                            ResEnum.KHONG_DUOC_UY_QUYEN.getStatusCode());
                }).orElse(null);
            } catch (RuntimeException e) {
                System.err.println(e.getMessage());
                throw e;
            }
        }

        @Override
        public boolean xoa(int id, String role) {
            try {
                return luongBanThanRepository.findById(id).map(c -> {
                    if (role.equals("ADMIN") ||
                            (role.equals("EMPLOYEE")
                                    && c.getXacNhan().equals(XacNhan.CHO_XAC_NHAN))) {
                        luongBanThanRepository.deleteById(id);
                        return true;
                    } else throw new
                            ResponseStatusException(
                            ResEnum.KHONG_DUOC_UY_QUYEN.getStatusCode());
                }).orElse(false);
            } catch (RuntimeException e) {
                System.err.println(e.getMessage());
                throw e;
            }
        }

        @Override
        public List<LuongBanThan> xemDanhSachCaNhan(int taiKhoanId, int pageNumber, int pageSize) {
            UUID id = hoSoClient.getHoSoId(taiKhoanId);
            return xemDanhSachTheoHoSoId(id, pageNumber, pageSize);
        }

        @Override
        public LuongBanThan themCaNhan(int taiKhoanId, ReqLuongBanThan cu) {
            UUID id = hoSoClient.getHoSoId(taiKhoanId);
            return them(id, cu);
        }

        @Override
        public boolean xacNhan(XacNhan xacNhan, List<ResLuongBanThan> res) {
            List<LuongBanThan> luongs = new ArrayList<>();
            for(ResLuongBanThan c : res){
                LuongBanThan cu = luongBanThanRepository.findById(c.id()).orElseThrow(() -> new ResponseStatusException(ResEnum.KHONG_DUOC_UY_QUYEN.getStatusCode()));
                cu.setXacNhan(xacNhan);
                cu.setUpdate_at();
                luongs.add(cu);
            }
            luongBanThanRepository.saveAll(luongs);
            return true;
        }
    }

    @Service
    public class LyHoLuanChinhTriServiceChiTiet implements IHoSoChiTietServices.IHoLyLuanChinhTriServiceChiTiet {
        @Override
        public List<LyLuanChinhTri> xemDanhSach(int pageNumber, int pageSize) {
            return lyLuanChinhTriRepository.findAll(PageRequest.of(pageNumber, pageSize)).getContent();
        }

        @Override
        public List<LyLuanChinhTri> xemDanhSachTheoHoSoId(UUID id, int pageNumber, int pageSize) {
            return lyLuanChinhTriRepository.getAllByHoSo(id, PageRequest.of(pageNumber, pageSize));
        }

        @Override
        public LyLuanChinhTri xemChiTiet(int id) {
            try {
                return lyLuanChinhTriRepository.findById(id).orElse(null);
            } catch (RuntimeException e) {
                System.err.println(e.getMessage());
                throw e;
            }
        }

        @Override
        public LyLuanChinhTri them(UUID id, ReqLyLuanChinhTri req) {
            try {
                LyLuanChinhTri tri = new LyLuanChinhTri(req.batDau(), req.ketThuc(), req.tenCoSoDaoTaoId(), req.hinhThucDaoTao(), req.vanBangDuocCap(), XacNhan.CHO_XAC_NHAN, id);
                tri.setXacNhan(XacNhan.CHO_XAC_NHAN);
                return lyLuanChinhTriRepository.save(tri);
            } catch (RuntimeException e) {
                System.err.println(e.getMessage());
                throw e;
            }
        }

        @Override
        public LyLuanChinhTri sua(int id, ReqLyLuanChinhTri req, String role) {
            try {
                return lyLuanChinhTriRepository.findById(id).map(c -> {
                    if (role.equals("ADMIN") ||
                            (role.equals("EMPLOYEE")
                                    && c.getXacNhan().equals(XacNhan.CHO_XAC_NHAN))) {
                        c.setBatDau(req.batDau());
                        c.setKetThuc(req.ketThuc());
                        c.setTenCoSoDaoTaoId(req.tenCoSoDaoTaoId());
                        c.setHinhThucDaoTao(req.hinhThucDaoTao());
                        c.setVanBangDuocCap(req.vanBangDuocCap());
                        c.setUpdate_at();
                        return lyLuanChinhTriRepository.save(c);
                    } else throw new
                            ResponseStatusException(
                            ResEnum.KHONG_DUOC_UY_QUYEN.getStatusCode());
                }).orElse(null);
            } catch (RuntimeException e) {
                System.err.println(e.getMessage());
                throw e;
            }
        }

        @Override
        public boolean xoa(int id, String role) {
            try {
                return lyLuanChinhTriRepository.findById(id).map(c -> {
                    if (role.equals("ADMIN") ||
                            (role.equals("EMPLOYEE")
                                    && c.getXacNhan().equals(XacNhan.CHO_XAC_NHAN))) {
                        lyLuanChinhTriRepository.deleteById(id);
                        return true;
                    } else throw new
                            ResponseStatusException(
                            ResEnum.KHONG_DUOC_UY_QUYEN.getStatusCode());
                }).orElse(false);
            } catch (RuntimeException e) {
                System.err.println(e.getMessage());
                throw e;
            }
        }

        @Override
        public List<LyLuanChinhTri> xemDanhSachCaNhan(int taiKhoanId, int pageNumber, int pageSize) {
            UUID id = hoSoClient.getHoSoId(taiKhoanId);
            return xemDanhSachTheoHoSoId(id, pageNumber, pageSize);
        }

        @Override
        public LyLuanChinhTri themCaNhan(int taiKhoanId, ReqLyLuanChinhTri cu) {
            UUID id = hoSoClient.getHoSoId(taiKhoanId);
            return them(id, cu);
        }

        @Override
        public boolean xacNhan(XacNhan xacNhan, List<ResLyLuanChinhTri> res) {
            List<LyLuanChinhTri> tris = new ArrayList<>();
            for(ResLyLuanChinhTri c : res){
                LyLuanChinhTri cu = lyLuanChinhTriRepository.findById(c.id()).orElseThrow(() -> new ResponseStatusException(ResEnum.KHONG_DUOC_UY_QUYEN.getStatusCode()));
                cu.setXacNhan(xacNhan);
                cu.setUpdate_at();
                tris.add(cu);
            }
            lyLuanChinhTriRepository.saveAll(tris);
            return true;
        }
    }

    @Service
    public class NghiepVuChuyenNganhService implements IHoSoChiTietServices.IHoNghiepVuChuyenNganhServiceChiTiet {
        @Override
        public List<NghiepVuChuyenNganh> xemDanhSach(int pageNumber, int pageSize) {
            return nghiepVuChuyenNganhRepository.findAll(PageRequest.of(pageNumber, pageSize)).getContent();
        }

        @Override
        public List<NghiepVuChuyenNganh> xemDanhSachTheoHoSoId(UUID id, int pageNumber, int pageSize) {
            return nghiepVuChuyenNganhRepository.getAllByHoSo(id, PageRequest.of(pageNumber, pageSize));
        }

        @Override
        public NghiepVuChuyenNganh xemChiTiet(int id) {
            try {
                return nghiepVuChuyenNganhRepository.findById(id).orElse(null);
            } catch (RuntimeException e) {
                System.err.println(e.getMessage());
                throw e;
            }
        }

        @Override
        public NghiepVuChuyenNganh them(UUID id, ReqNghiepVuChuyenNganh req) {
            try {
                NghiepVuChuyenNganh vu = new NghiepVuChuyenNganh(req.batDau(), req.ketThuc(), req.tenCoSoDaoTaoId(), req.chungChiDuocCap(), XacNhan.CHO_XAC_NHAN, id);
                vu.setXacNhan(XacNhan.CHO_XAC_NHAN);
                return nghiepVuChuyenNganhRepository.save(vu);
            } catch (RuntimeException e) {
                System.err.println(e.getMessage());
                throw e;
            }
        }

        @Override
        public NghiepVuChuyenNganh sua(int id, ReqNghiepVuChuyenNganh req, String role) {
            try {
                return nghiepVuChuyenNganhRepository.findById(id).map(c -> {
                    if (role.equals("ADMIN") ||
                            (role.equals("EMPLOYEE")
                                    && c.getXacNhan().equals(XacNhan.CHO_XAC_NHAN))) {
                        c.setBatDau(req.batDau());
                        c.setKetThuc(req.ketThuc());
                        c.setTenCoSoDaoTaoId(req.tenCoSoDaoTaoId());
                        c.setChungChiDuocCap(req.chungChiDuocCap());
                        c.setUpdate_at();
                        return nghiepVuChuyenNganhRepository.save(c);
                    } else throw new
                            ResponseStatusException(
                            ResEnum.KHONG_DUOC_UY_QUYEN.getStatusCode());
                }).orElse(null);
            } catch (RuntimeException e) {
                System.err.println(e.getMessage());
                throw e;
            }
        }

        @Override
        public boolean xoa(int id, String role) {
            try {
                return nghiepVuChuyenNganhRepository.findById(id).map(c -> {
                    if (role.equals("ADMIN") ||
                            (role.equals("EMPLOYEE")
                                    && c.getXacNhan().equals(XacNhan.CHO_XAC_NHAN))) {
                        nghiepVuChuyenNganhRepository.deleteById(id);
                        return true;
                    } else throw new
                            ResponseStatusException(
                            ResEnum.KHONG_DUOC_UY_QUYEN.getStatusCode());
                }).orElse(false);
            } catch (RuntimeException e) {
                System.err.println(e.getMessage());
                throw e;
            }
        }

        @Override
        public List<NghiepVuChuyenNganh> xemDanhSachCaNhan(int taiKhoanId, int pageNumber, int pageSize) {
            UUID id = hoSoClient.getHoSoId(taiKhoanId);
            return xemDanhSachTheoHoSoId(id, pageNumber, pageSize);
        }

        @Override
        public NghiepVuChuyenNganh themCaNhan(int taiKhoanId, ReqNghiepVuChuyenNganh cu) {
            UUID id = hoSoClient.getHoSoId(taiKhoanId);
            return them(id, cu);
        }

        @Override
        public boolean xacNhan(XacNhan xacNhan, List<ResNghiepVuChuyenNganh> res) {
            List<NghiepVuChuyenNganh> nganhs = new ArrayList<>();
            for(ResNghiepVuChuyenNganh c : res){
                NghiepVuChuyenNganh cu = nghiepVuChuyenNganhRepository.findById(c.id()).orElseThrow(() -> new ResponseStatusException(ResEnum.KHONG_DUOC_UY_QUYEN.getStatusCode()));
                cu.setXacNhan(xacNhan);
                cu.setUpdate_at();
                nganhs.add(cu);
            }
            nghiepVuChuyenNganhRepository.saveAll(nganhs);
            return true;
        }
    }

    @Service
    public class NgoaiNguService implements IHoSoChiTietServices.IHoNgoaiNguServiceChiTiet {
        @Override
        public List<NgoaiNgu> xemDanhSach(int pageNumber, int pageSize) {
            return ngoaiNguRepository.findAll(PageRequest.of(pageNumber, pageSize)).getContent();
        }

        @Override
        public List<NgoaiNgu> xemDanhSachTheoHoSoId(UUID id, int pageNumber, int pageSize) {
            return ngoaiNguRepository.getAllByHoSo(id, PageRequest.of(pageNumber, pageSize));
        }

        @Override
        public NgoaiNgu xemChiTiet(int id) {
            try {
                return ngoaiNguRepository.findById(id).orElse(null);
            } catch (RuntimeException e) {
                System.err.println(e.getMessage());
                throw e;
            }
        }

        @Override
        public NgoaiNgu them(UUID id, ReqNgoaiNgu req) {
            try {
                NgoaiNgu ngu = new NgoaiNgu(req.batDau(), req.ketThuc(), req.tenCoSoDaoTaoId(), req.tenNgoaiNgu(), req.chungChiDuocCap(), req.diemSo(), XacNhan.CHO_XAC_NHAN, id);
                ngu.setXacNhan(XacNhan.CHO_XAC_NHAN);
                return ngoaiNguRepository.save(ngu);
            } catch (RuntimeException e) {
                System.err.println(e.getMessage());
                throw e;
            }
        }

        @Override
        public NgoaiNgu sua(int id, ReqNgoaiNgu req, String role) {
            try {
                return ngoaiNguRepository.findById(id).map(c -> {
                    if (role.equals("ADMIN") ||
                            (role.equals("EMPLOYEE")
                                    && c.getXacNhan().equals(XacNhan.CHO_XAC_NHAN))) {
                        c.setBatDau(req.batDau());
                        c.setKetThuc(req.ketThuc());
                        c.setTenCoSoDaoTaoId(req.tenCoSoDaoTaoId());
                        c.setTenNgoaiNgu(req.tenNgoaiNgu());
                        c.setChungChiDuocCap(req.chungChiDuocCap());
                        c.setDiemSo(req.diemSo());
                        c.setUpdate_at();
                        return ngoaiNguRepository.save(c);
                    } else throw new
                            ResponseStatusException(
                            ResEnum.KHONG_DUOC_UY_QUYEN.getStatusCode());
                }).orElse(null);
            } catch (RuntimeException e) {
                System.err.println(e.getMessage());
                throw e;
            }
        }

        @Override
        public boolean xoa(int id, String role) {
            try {
                return ngoaiNguRepository.findById(id).map(c -> {
                    if (role.equals("ADMIN") ||
                            (role.equals("EMPLOYEE")
                                    && c.getXacNhan().equals(XacNhan.CHO_XAC_NHAN))) {
                        ngoaiNguRepository.deleteById(id);
                        return true;
                    } else throw new
                            ResponseStatusException(
                            ResEnum.KHONG_DUOC_UY_QUYEN.getStatusCode());
                }).orElse(false);
            } catch (RuntimeException e) {
                System.err.println(e.getMessage());
                throw e;
            }
        }

        @Override
        public List<NgoaiNgu> xemDanhSachCaNhan(int taiKhoanId, int pageNumber, int pageSize) {
            UUID id = hoSoClient.getHoSoId(taiKhoanId);
            return xemDanhSachTheoHoSoId(id, pageNumber, pageSize);
        }

        @Override
        public NgoaiNgu themCaNhan(int taiKhoanId, ReqNgoaiNgu cu) {
            UUID id = hoSoClient.getHoSoId(taiKhoanId);
            return them(id, cu);
        }

        @Override
        public boolean xacNhan(XacNhan xacNhan, List<ResNgoaiNgu> res) {
            List<NgoaiNgu> ngus = new ArrayList<>();
            for(ResNgoaiNgu c : res){
                NgoaiNgu cu = ngoaiNguRepository.findById(c.id()).orElseThrow(() -> new ResponseStatusException(ResEnum.KHONG_DUOC_UY_QUYEN.getStatusCode()));
                cu.setXacNhan(xacNhan);
                cu.setUpdate_at();
                ngus.add(cu);
            }
            ngoaiNguRepository.saveAll(ngus);
            return true;
        }
    }

    @Service
    public class PhuCapKhacService implements IHoSoChiTietServices.IHoPhuCapKhacServiceChiTiet {
        @Override
        public List<PhuCapKhac> xemDanhSach(int pageNumber, int pageSize) {
            return phuCapKhacRepository.findAll(PageRequest.of(pageNumber, pageSize)).getContent();
        }

        @Override
        public List<PhuCapKhac> xemDanhSachTheoHoSoId(UUID id, int pageNumber, int pageSize) {
            return phuCapKhacRepository.getAllByHoSo(id, PageRequest.of(pageNumber, pageSize));
        }

        @Override
        public PhuCapKhac xemChiTiet(int id) {
            try {
                return phuCapKhacRepository.findById(id).orElse(null);
            } catch (RuntimeException e) {
                System.err.println(e.getMessage());
                throw e;
            }
        }

        @Override
        public PhuCapKhac them(UUID id, ReqPhuCapKhac req) {
            return phuCapKhacRepository.save(new PhuCapKhac(
                    req.batDau(), req.ketThuc(), req.loaiPhuCapId(), req.phanTramHuongPhuCap(), req.heSoPhuCap(), req.hinhThucThuong(), req.giaTri(), XacNhan.CHO_XAC_NHAN, id));
        }

        @Override
        public PhuCapKhac sua(int id, ReqPhuCapKhac req, String role) {
            try {
                return phuCapKhacRepository.findById(id).map(c -> {
                    if (role.equals("ADMIN") ||
                            (role.equals("EMPLOYEE")
                                    && c.getXacNhan().equals(XacNhan.CHO_XAC_NHAN))) {
                        c.setBatDau(req.batDau());
                        c.setKetThuc(req.ketThuc());
                        c.setLoaiPhuCapId(req.loaiPhuCapId());
                        c.setPhanTramHuongPhuCap(req.phanTramHuongPhuCap());
                        c.setHeSoPhuCap(req.heSoPhuCap());
                        c.setHinhThucHuong(req.hinhThucThuong());
                        c.setGiaTri(req.giaTri());
                        c.setUpdate_at();
                        return phuCapKhacRepository.save(c);
                    } else throw new
                            ResponseStatusException(
                            ResEnum.KHONG_DUOC_UY_QUYEN.getStatusCode());
                }).orElse(null);
            } catch (RuntimeException e) {
                System.err.println(e.getMessage());
                throw e;
            }
        }

        @Override
        public boolean xoa(int id, String role) {
            try {
                return phuCapKhacRepository.findById(id).map(c -> {
                    if (role.equals("ADMIN") ||
                            (role.equals("EMPLOYEE")
                                    && c.getXacNhan().equals(XacNhan.CHO_XAC_NHAN))) {
                        phuCapKhacRepository.deleteById(id);
                        return true;
                    } else throw new
                            ResponseStatusException(
                            ResEnum.KHONG_DUOC_UY_QUYEN.getStatusCode());
                }).orElse(false);
            } catch (RuntimeException e) {
                System.err.println(e.getMessage());
                throw e;
            }
        }

        @Override
        public List<PhuCapKhac> xemDanhSachCaNhan(int taiKhoanId, int pageNumber, int pageSize) {
            UUID id = hoSoClient.getHoSoId(taiKhoanId);
            return xemDanhSachTheoHoSoId(id, pageNumber, pageSize);
        }

        @Override
        public PhuCapKhac themCaNhan(int taiKhoanId, ReqPhuCapKhac cu) {
            UUID id = hoSoClient.getHoSoId(taiKhoanId);
            return them(id, cu);
        }

        @Override
        public boolean xacNhan(XacNhan xacNhan, List<ResPhuCapKhac> res) {
            List<PhuCapKhac> khacs = new ArrayList<>();
            for(ResPhuCapKhac c : res){
                PhuCapKhac cu = phuCapKhacRepository.findById(c.id()).orElseThrow(() -> new ResponseStatusException(ResEnum.KHONG_DUOC_UY_QUYEN.getStatusCode()));
                cu.setXacNhan(xacNhan);
                cu.setUpdate_at();
                khacs.add(cu);
            }
            phuCapKhacRepository.saveAll(khacs);
            return true;
        }
    }

    @Service
    public class QuanHeGiaDinhService implements IHoSoChiTietServices.IHoQuanHeGiaDinhServiceChiTiet {
        @Override
        public List<QuanHeGiaDinh> xemDanhSach(int pageNumber, int pageSize) {
            return quanHeGiaDinhRepository.findAll(PageRequest.of(pageNumber, pageSize)).getContent();
        }

        @Override
        public List<QuanHeGiaDinh> xemDanhSachTheoHoSoId(UUID id, int pageNumber, int pageSize) {
            return quanHeGiaDinhRepository.getAllByHoSo(id, PageRequest.of(pageNumber, pageSize));
        }

        @Override
        public QuanHeGiaDinh xemChiTiet(int id) {
            try {
                return quanHeGiaDinhRepository.findById(id).orElse(null);
            } catch (RuntimeException e) {
                System.err.println(e.getMessage());
                throw e;
            }
        }

        @Override
        public QuanHeGiaDinh them(UUID id, ReqQuanHeGiaDinh req) {
            try {
                QuanHeGiaDinh dinh = new QuanHeGiaDinh(req.moiQuanHeId(), req.hoVaTen(), req.namSinh(), req.thongTinThanNhan(), XacNhan.CHO_XAC_NHAN, id);
                return quanHeGiaDinhRepository.save(dinh);
            } catch (RuntimeException e) {
                System.err.println(e.getMessage());
                throw e;
            }
        }

        @Override
        public QuanHeGiaDinh sua(int id, ReqQuanHeGiaDinh req, String role) {
            try {
                return quanHeGiaDinhRepository.findById(id).map(c -> {
                    if (role.equals("ADMIN") ||
                            (role.equals("EMPLOYEE")
                                    && c.getXacNhan().equals(XacNhan.CHO_XAC_NHAN))) {
                        c.setMoiQuanHeId(req.moiQuanHeId());
                        c.setHoVaTen(req.hoVaTen());
                        c.setNamSinh(req.namSinh());
                        c.setThongTinThanNhan(req.thongTinThanNhan());
                        c.setUpdate_at();
                        return quanHeGiaDinhRepository.save(c);
                    } else throw new
                            ResponseStatusException(
                            ResEnum.KHONG_DUOC_UY_QUYEN.getStatusCode());
                }).orElse(null);
            } catch (RuntimeException e) {
                System.err.println(e.getMessage());
                throw e;
            }
        }

        @Override
        public boolean xoa(int id, String role) {
            try {
                return quanHeGiaDinhRepository.findById(id).map(c -> {
                    if (role.equals("ADMIN") ||
                            (role.equals("EMPLOYEE")
                                    && c.getXacNhan().equals(XacNhan.CHO_XAC_NHAN))) {
                        quanHeGiaDinhRepository.deleteById(id);
                        return true;
                    } else throw new
                            ResponseStatusException(
                            ResEnum.KHONG_DUOC_UY_QUYEN.getStatusCode());
                }).orElse(false);
            } catch (RuntimeException e) {
                System.err.println(e.getMessage());
                throw e;
            }
        }

        @Override
        public List<QuanHeGiaDinh> xemDanhSachCaNhan(int taiKhoanId, int pageNumber, int pageSize) {
            UUID id = hoSoClient.getHoSoId(taiKhoanId);
            return xemDanhSachTheoHoSoId(id, pageNumber, pageSize);
        }

        @Override
        public QuanHeGiaDinh themCaNhan(int taiKhoanId, ReqQuanHeGiaDinh cu) {
            UUID id = hoSoClient.getHoSoId(taiKhoanId);
            return them(id, cu);
        }

        @Override
        public boolean xacNhan(XacNhan xacNhan, List<ResQuanHeGiaDinh> res) {
            List<QuanHeGiaDinh> giaDinhs = new ArrayList<>();
            for(ResQuanHeGiaDinh c : res){
                QuanHeGiaDinh cu = quanHeGiaDinhRepository.findById(c.id()).orElseThrow(() -> new ResponseStatusException(ResEnum.KHONG_DUOC_UY_QUYEN.getStatusCode()));
                cu.setXacNhan(xacNhan);
                cu.setUpdate_at();
                giaDinhs.add(cu);
            }
            quanHeGiaDinhRepository.saveAll(giaDinhs);
            return true;
        }
    }

    @Service
    public class QuaTrinhCongTacService implements IHoSoChiTietServices.IHoQuaTrinhCongTacServiceChiTiet {
        @Override
        public List<QuaTrinhCongTac> xemDanhSach(int pageNumber, int pageSize) {
            return quaTrinhCongTacRepository.findAll(PageRequest.of(pageNumber, pageSize)).getContent();
        }

        @Override
        public List<QuaTrinhCongTac> xemDanhSachTheoHoSoId(UUID id, int pageNumber, int pageSize) {
            return quaTrinhCongTacRepository.getAllByHoSo(id, PageRequest.of(pageNumber, pageSize));
        }

        @Override
        public QuaTrinhCongTac xemChiTiet(int id) {
            try {
                return quaTrinhCongTacRepository.findById(id).orElse(null);
            } catch (RuntimeException e) {
                System.err.println(e.getMessage());
                throw e;
            }
        }

        @Override
        public QuaTrinhCongTac them(UUID id, ReqQuaTrinhCongTac req) {
            try {
                return quaTrinhCongTacRepository.save(new QuaTrinhCongTac(req.batDau(), req.ketThuc(), req.donViCongTacId(), req.chucDanh(), XacNhan.CHO_XAC_NHAN, id));
            } catch (RuntimeException e) {
                System.err.println(e.getMessage());
                throw e;
            }
        }

        @Override
        public QuaTrinhCongTac sua(int id, ReqQuaTrinhCongTac req, String role) {
            try {
                return quaTrinhCongTacRepository.findById(id).map(c -> {
                    if (role.equals("ADMIN") ||
                            (role.equals("EMPLOYEE")
                                    && c.getXacNhan().equals(XacNhan.CHO_XAC_NHAN))) {
                        c.setBatDau(req.batDau());
                        c.setKetThuc(req.ketThuc());
                        c.setDonViCongTacId(req.donViCongTacId());
                        c.setChucDanh(req.chucDanh());
                        c.setUpdate_at();
                        return quaTrinhCongTacRepository.save(c);
                    } else throw new
                            ResponseStatusException(
                            ResEnum.KHONG_DUOC_UY_QUYEN.getStatusCode());
                }).orElse(null);
            } catch (RuntimeException e) {
                System.err.println(e.getMessage());
                throw e;
            }
        }

        @Override
        public boolean xoa(int id, String role) {
            try {
                return quaTrinhCongTacRepository.findById(id).map(c -> {
                    if (role.equals("ADMIN") ||
                            (role.equals("EMPLOYEE")
                                    && c.getXacNhan().equals(XacNhan.CHO_XAC_NHAN))) {
                        quaTrinhCongTacRepository.deleteById(id);
                        return true;
                    } else throw new
                            ResponseStatusException(
                            ResEnum.KHONG_DUOC_UY_QUYEN.getStatusCode());
                }).orElse(false);
            } catch (RuntimeException e) {
                System.err.println(e.getMessage());
                throw e;
            }
        }

        @Override
        public List<QuaTrinhCongTac> xemDanhSachCaNhan(int taiKhoanId, int pageNumber, int pageSize) {
            UUID id = hoSoClient.getHoSoId(taiKhoanId);
            return xemDanhSachTheoHoSoId(id, pageNumber, pageSize);
        }

        @Override
        public QuaTrinhCongTac themCaNhan(int taiKhoanId, ReqQuaTrinhCongTac cu) {
            UUID id = hoSoClient.getHoSoId(taiKhoanId);
            return them(id, cu);
        }

        @Override
        public boolean xacNhan(XacNhan xacNhan, List<ResQuaTrinhCongTac> res) {
            List<QuaTrinhCongTac> tacs = new ArrayList<>();
            for(ResQuaTrinhCongTac c : res){
                QuaTrinhCongTac cu = quaTrinhCongTacRepository.findById(c.id()).orElseThrow(() -> new ResponseStatusException(ResEnum.KHONG_DUOC_UY_QUYEN.getStatusCode()));
                cu.setXacNhan(xacNhan);
                cu.setUpdate_at();
                tacs.add(cu);
            }
            quaTrinhCongTacRepository.saveAll(tacs);
            return true;
        }
    }

    @Service
    public class TinHocService implements IHoSoChiTietServices.IHoTinHocServiceChiTiet {
        @Override
        public List<TinHoc> xemDanhSach(int pageNumber, int pageSize) {
            return tinHocRepository.findAll(PageRequest.of(pageNumber, pageSize)).getContent();
        }

        @Override
        public List<TinHoc> xemDanhSachTheoHoSoId(UUID id, int pageNumber, int pageSize) {
            return tinHocRepository.getAllByHoSo(id, PageRequest.of(pageNumber, pageSize));
        }

        @Override
        public TinHoc xemChiTiet(int id) {
            try {
                return tinHocRepository.findById(id).orElse(null);
            } catch (RuntimeException e) {
                System.err.println(e.getMessage());
                throw e;
            }
        }

        @Override
        public TinHoc them(UUID id, ReqTinHoc req) {
            try {
                TinHoc tin = new TinHoc(req.batDau(), req.ketThuc(), req.tenCoSoDaoTaoId(), req.chungChiDuocCap(), XacNhan.CHO_XAC_NHAN, id);
                return tinHocRepository.save(tin);
            } catch (RuntimeException e) {
                System.err.println(e.getMessage());
                throw e;
            }
        }

        @Override
        public TinHoc sua(int id, ReqTinHoc req, String role) {
            return tinHocRepository.findById(id).map(c -> {
                if (role.equals("ADMIN") ||
                        (role.equals("EMPLOYEE")
                                && c.getXacNhan().equals(XacNhan.CHO_XAC_NHAN))) {
                    c.setBatDau(req.batDau());
                    c.setKetThuc(req.ketThuc());
                    c.setTenCoSoDaoTaoId(req.tenCoSoDaoTaoId());
                    c.setChungChiDuocCap(req.chungChiDuocCap());
                    c.setUpdate_at();
                    return tinHocRepository.save(c);
                } else throw new
                        ResponseStatusException(
                        ResEnum.KHONG_DUOC_UY_QUYEN.getStatusCode());
            }).orElse(null);
        }

        @Override
        public boolean xoa(int id, String role) {
            try {
                return tinHocRepository.findById(id).map(c -> {
                    if (role.equals("ADMIN") ||
                            (role.equals("EMPLOYEE")
                                    && c.getXacNhan().equals(XacNhan.CHO_XAC_NHAN))) {
                        tinHocRepository.deleteById(id);
                        return true;
                    } else throw new
                            ResponseStatusException(
                            ResEnum.KHONG_DUOC_UY_QUYEN.getStatusCode());
                }).orElseThrow(() -> new ResponseStatusException(ResEnum.HONG_TIM_THAY.getStatusCode()));
            } catch (RuntimeException e) {
                System.err.println(e.getMessage());
                throw e;
            }
        }

        @Override
        public List<TinHoc> xemDanhSachCaNhan(int taiKhoanId, int pageNumber, int pageSize) {
            UUID id = hoSoClient.getHoSoId(taiKhoanId);
            return xemDanhSachTheoHoSoId(id, pageNumber, pageSize);
        }

        @Override
        public TinHoc themCaNhan(int taiKhoanId, ReqTinHoc cu) {
            UUID id = hoSoClient.getHoSoId(taiKhoanId);
            return them(id, cu);
        }

        @Override
        public boolean xacNhan(XacNhan xacNhan, List<ResTinHoc> res) {
            List<TinHoc> tinHocs = new ArrayList<>();
            for(ResTinHoc c : res){
                TinHoc cu = tinHocRepository.findById(c.id()).orElseThrow(() -> new ResponseStatusException(ResEnum.KHONG_DUOC_UY_QUYEN.getStatusCode()));
                cu.setXacNhan(xacNhan);
                cu.setUpdate_at();
                tinHocs.add(cu);
            }
            tinHocRepository.saveAll(tinHocs);
            return true;
        }
    }
}
