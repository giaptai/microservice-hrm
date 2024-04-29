package com.hrm.hoso_chitiet.services;

import com.hrm.hoso_chitiet.client.ho_so.HoSoClient;
import com.hrm.hoso_chitiet.client.ho_so.ResHoSoTomTatClient;
import com.hrm.hoso_chitiet.dto.mapper.MapperKhenThuong;
import com.hrm.hoso_chitiet.dto.mapper.MapperKienThucAnNinhQuocPhong;
import com.hrm.hoso_chitiet.dto.mapper.MapperKyLuat;
import com.hrm.hoso_chitiet.dto.mapper.MapperLamViecChoCheDoCu;
import com.hrm.hoso_chitiet.dto.mapper.MapperLamViecONuocNgoai;
import com.hrm.hoso_chitiet.dto.mapper.MapperLuongBanThan;
import com.hrm.hoso_chitiet.dto.mapper.MapperLyLuanChinhTri;
import com.hrm.hoso_chitiet.dto.mapper.MapperNghiepVuChuyenNganh;
import com.hrm.hoso_chitiet.dto.mapper.MapperNgoaiNgu;
import com.hrm.hoso_chitiet.dto.mapper.MapperPhuCapKhac;
import com.hrm.hoso_chitiet.dto.mapper.MapperQuaTrinhCongTac;
import com.hrm.hoso_chitiet.dto.mapper.MapperQuanHeGiaDinh;
import com.hrm.hoso_chitiet.dto.mapper.MapperTinHoc;
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
import com.hrm.hoso_chitiet.dto.response.ResTheDTO;
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
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
    //mapper
    private final MapperKhenThuong mapperKhenThuong;
    private final MapperKienThucAnNinhQuocPhong mapperKienThucAnNinhQuocPhong;
    private final MapperKyLuat mapperKyLuat;
    private final MapperLamViecChoCheDoCu mapperLamViecChoCheDoCu;
    private final MapperLamViecONuocNgoai mapperLamViecONuocNgoai;
    private final MapperLuongBanThan mapperLuongBanThan;
    private final MapperLyLuanChinhTri mapperLyLuanChinhTri;
    private final MapperNghiepVuChuyenNganh mapperNghiepVuChuyenNganh;
    private final MapperNgoaiNgu mapperNgoaiNgu;
    private final MapperPhuCapKhac mapperPhuCapKhac;
    private final MapperQuanHeGiaDinh mapperQuanHeGiaDinh;
    private final MapperQuaTrinhCongTac mapperQuaTrinhCongTac;
    private final MapperTinHoc mapperTinHoc;


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
        public ResTheDTO<ResLamViecChoCheDoCu> xemDanhSach(XacNhan xacNhan, String byDate, int pageNumber, int pageSize) {
            Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.by(Sort.Direction.DESC, byDate));
            Page<LamViecChoCheDoCu> page = lamViecChoCheDoCuRepository.findAll(pageable);
            List<ResLamViecChoCheDoCu> list = page.getContent().stream().map(mapperLamViecChoCheDoCu::maptoResLamViecChoCheDoCu).toList();
            long totalRecord = page.getTotalElements();
            int totalPage = page.getTotalPages();
            return new ResTheDTO<>(list, totalRecord, totalPage);
        }

        @Override
        public ResTheDTO<ResLamViecChoCheDoCu> xemDanhSachTheoHoSoId(UUID id, XacNhan xacNhan, String byDate, int pageNumber, int pageSize) {
            Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.by(Sort.Direction.DESC, byDate));
            Page<LamViecChoCheDoCu> page = lamViecChoCheDoCuRepository.getAllByHoSo(id, xacNhan, pageable);
            List<ResLamViecChoCheDoCu> list = page.getContent().stream().map(mapperLamViecChoCheDoCu::maptoResLamViecChoCheDoCu).toList();
            long totalRecord = page.getTotalElements();
            int totalPage = page.getTotalPages();
            return new ResTheDTO<>(list, totalRecord, totalPage);
        }

        @Override
        public ResLamViecChoCheDoCu xemChiTiet(int id) {
            try {
                return lamViecChoCheDoCuRepository.findById(id).map(mapperLamViecChoCheDoCu::maptoResLamViecChoCheDoCu).orElse(null);
            } catch (RuntimeException e) {
                System.err.println(e.getMessage());
                throw e;
            }
        }

        @Override
        public ResLamViecChoCheDoCu them(UUID id, ReqLamViecChoCheDoCu req) {
            try {
                LamViecChoCheDoCu cu = lamViecChoCheDoCuRepository.save(new LamViecChoCheDoCu(req.batDau(), req.ketThuc(), req.chucDanhDonViDiaDiem(), XacNhan.CHO_PHE_DUYET, id));
                return mapperLamViecChoCheDoCu.maptoResLamViecChoCheDoCu(cu);
            } catch (RuntimeException e) {
                System.err.println(e.getMessage());
                throw e;
            }
        }

        @Override
        public ResLamViecChoCheDoCu sua(int id, ReqLamViecChoCheDoCu req, String role) {
            try {
                return lamViecChoCheDoCuRepository.findById(id).map(c -> {
                    if (role.equals("ADMIN") ||
                            (role.equals("EMPLOYEE")
                                    && c.getXacNhan().equals(XacNhan.CHO_PHE_DUYET))) {
                        c.setBatDau(req.batDau() != null ? req.batDau() : c.getBatDau());
                        c.setKetThuc(req.ketThuc() != null ? req.ketThuc() : c.getKetThuc());
                        c.setChucDanhDonViDiaDiem(req.chucDanhDonViDiaDiem() != null ? req.chucDanhDonViDiaDiem() : c.getChucDanhDonViDiaDiem());
                        c.setUpdateAt();
                        LamViecChoCheDoCu cu = lamViecChoCheDoCuRepository.save(c);
                        return mapperLamViecChoCheDoCu.maptoResLamViecChoCheDoCu(cu);
                    } else throw new ResponseStatusException(ResEnum.KHONG_DUOC_UY_QUYEN.getStatusCode());
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
                    if (role.equals("ADMIN") || (role.equals("EMPLOYEE") && c.getXacNhan().equals(XacNhan.CHO_PHE_DUYET))) {
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
        public ResTheDTO<ResLamViecChoCheDoCu> xemDanhSachCaNhan(int taiKhoanId, XacNhan xacNhan, String byDate, int pageNumber, int pageSize) {
            ResHoSoTomTatClient client = hoSoClient.getHoSoId(taiKhoanId);
            UUID id = client.hoSoId();
            return xemDanhSachTheoHoSoId(id, xacNhan, byDate, pageNumber, pageSize);
        }

        @Override
        public ResLamViecChoCheDoCu themCaNhan(int taiKhoanId, ReqLamViecChoCheDoCu cu) {
            ResHoSoTomTatClient client = hoSoClient.getHoSoId(taiKhoanId);
            UUID id = client.hoSoId();
            return them(id, cu);
        }

        @Override
        public boolean xacNhan(XacNhan xacNhan, List<ResLamViecChoCheDoCu> res) {
            List<LamViecChoCheDoCu> lamViecChoCheDoCus = new ArrayList<>();
            for (ResLamViecChoCheDoCu c : res) {
                LamViecChoCheDoCu cu = lamViecChoCheDoCuRepository.findById(c.id()).orElseThrow(() -> new ResponseStatusException(ResEnum.KHONG_DUOC_UY_QUYEN.getStatusCode()));
                cu.setXacNhan(xacNhan);
                cu.setUpdateAt();
                lamViecChoCheDoCus.add(cu);
            }
            lamViecChoCheDoCuRepository.saveAll(lamViecChoCheDoCus);
            return true;
        }
    }

    @Service
    public class KhenThuongService implements IHoSoChiTietServices.IHoKhenThuongServiceChiTiet {
        @Override
        public ResTheDTO<ResKhenThuong> xemDanhSach(XacNhan xacNhan, String byDate, int pageNumber, int pageSize) {
            Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.by(Sort.Direction.DESC, byDate));
            Page<KhenThuong> page = khenThuongRepository.findAll(pageable);
            List<ResKhenThuong> list = page.getContent().stream().map(mapperKhenThuong::maptoResKhenThuong).toList();
            long totalRecord = page.getTotalElements();
            int totalPage = page.getTotalPages();
            return new ResTheDTO<>(list, totalRecord, totalPage);
        }

        @Override
        public ResTheDTO<ResKhenThuong> xemDanhSachTheoHoSoId(UUID id, XacNhan xacNhan, String byDate, int pageNumber, int pageSize) {
            Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.by(Sort.Direction.DESC, byDate));
            Page<KhenThuong> page = khenThuongRepository.getAllByHoSo(id, xacNhan, pageable);
            List<ResKhenThuong> list = page.getContent().stream().map(mapperKhenThuong::maptoResKhenThuong).toList();
            long totalRecord = page.getTotalElements();
            int totalPage = page.getTotalPages();
            return new ResTheDTO<>(list, totalRecord, totalPage);
        }

        @Override
        public ResKhenThuong xemChiTiet(int id) {
            try {
                KhenThuong thuong = khenThuongRepository.findById(id).orElse(null);
                return mapperKhenThuong.maptoResKhenThuong(thuong);
            } catch (RuntimeException e) {
                System.err.println(e.getMessage());
                throw e;
            }
        }

        @Override
        public ResKhenThuong them(UUID id, ReqKhenThuong req) {
            try {
                KhenThuong thuong = khenThuongRepository.save(new KhenThuong(req.nam(), req.xepLoaiChuyenMon(), req.xepLoaiThiDua(), req.hinhThucKhenThuongId(), req.lyDo(), XacNhan.CHO_PHE_DUYET, id));
                return mapperKhenThuong.maptoResKhenThuong(thuong);
            } catch (RuntimeException e) {
                System.err.println(e.getMessage());
                throw e;
            }
        }

        @Override
        public ResKhenThuong sua(int id, ReqKhenThuong req, String role) {
            try {
                return khenThuongRepository.findById(id).map(c -> {
                    if (role.equals("ADMIN") ||
                            (role.equals("EMPLOYEE")
                                    && c.getXacNhan().equals(XacNhan.CHO_PHE_DUYET))) {
                        c.setNam(req.nam() != null ? req.nam() : c.getNam());
                        c.setXepLoaiChuyenMon(req.xepLoaiChuyenMon());
                        c.setXepLoaiThiDua(req.xepLoaiThiDua());
                        c.setHinhThucKhenThuongId(req.hinhThucKhenThuongId());
                        c.setLyDo(req.lyDo());
                        c.setUpdateAt();
                        KhenThuong thuong = khenThuongRepository.save(c);
                        return mapperKhenThuong.maptoResKhenThuong(thuong);
                    } else throw new ResponseStatusException(ResEnum.KHONG_DUOC_UY_QUYEN.getStatusCode());
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
                                    && c.getXacNhan().equals(XacNhan.CHO_PHE_DUYET))) {
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
        public ResTheDTO<ResKhenThuong> xemDanhSachCaNhan(int taiKhoanId, XacNhan xacNhan, String byDate, int pageNumber, int pageSize) {
            ResHoSoTomTatClient client = hoSoClient.getHoSoId(taiKhoanId);
            UUID id = client.hoSoId();
            return xemDanhSachTheoHoSoId(id, xacNhan, byDate, pageNumber, pageSize);
        }

        @Override
        public ResKhenThuong themCaNhan(int taiKhoanId, ReqKhenThuong cu) {
            ResHoSoTomTatClient client = hoSoClient.getHoSoId(taiKhoanId);
            UUID id = client.hoSoId();
            return them(id, cu);
        }

        @Override
        public boolean xacNhan(XacNhan xacNhan, List<ResKhenThuong> res) {
            List<KhenThuong> khenThuongs = new ArrayList<>();
            for (ResKhenThuong c : res) {
                KhenThuong cu = khenThuongRepository.findById(c.id()).orElseThrow(() -> new ResponseStatusException(ResEnum.KHONG_DUOC_UY_QUYEN.getStatusCode()));
                cu.setXacNhan(xacNhan);
                cu.setUpdateAt();
                khenThuongs.add(cu);
            }
            khenThuongRepository.saveAll(khenThuongs);
            return true;
        }
    }

    @Service
    public class KienThucAnNinhQuocPhongService implements IHoSoChiTietServices.IHoKienThucAnNinhQuocPhongServiceChiTiet {
        @Override
        public ResTheDTO<ResKienThucAnNinhQuocPhong> xemDanhSach(XacNhan xacNhan, String byDate, int pageNumber, int pageSize) {
            Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.by(Sort.Direction.DESC, byDate));
            Page<KienThucAnNinhQuocPhong> page = kienThucAnNinhQuocPhongRepository.findAll(pageable);
            List<ResKienThucAnNinhQuocPhong> list = page.getContent().stream().map(mapperKienThucAnNinhQuocPhong::mapToResKienThucAnNinhQuocPhong).toList();
            long totalRecord = page.getTotalElements();
            int totalPage = page.getTotalPages();
            return new ResTheDTO<>(list, totalRecord, totalPage);
        }

        @Override
        public ResTheDTO<ResKienThucAnNinhQuocPhong> xemDanhSachTheoHoSoId(UUID id, XacNhan xacNhan, String byDate, int pageNumber, int pageSize) {
            Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.by(Sort.Direction.DESC, byDate));
            Page<KienThucAnNinhQuocPhong> page = kienThucAnNinhQuocPhongRepository.getAllByHoSo(id, xacNhan, pageable);
            List<ResKienThucAnNinhQuocPhong> list = page.getContent().stream().map(mapperKienThucAnNinhQuocPhong::mapToResKienThucAnNinhQuocPhong).toList();
            long totalRecord = page.getTotalElements();
            int totalPage = page.getTotalPages();
            return new ResTheDTO<>(list, totalRecord, totalPage);
        }

        @Override
        public ResKienThucAnNinhQuocPhong xemChiTiet(int id) {
            try {
                KienThucAnNinhQuocPhong phong = kienThucAnNinhQuocPhongRepository.findById(id).orElse(null);
                return mapperKienThucAnNinhQuocPhong.mapToResKienThucAnNinhQuocPhong(phong);
            } catch (RuntimeException e) {
                System.err.println(e.getMessage());
                throw e;
            }
        }

        @Override
        public ResKienThucAnNinhQuocPhong them(UUID id, ReqKienThucAnNinhQuocPhong req) {
            try {
                KienThucAnNinhQuocPhong phong = kienThucAnNinhQuocPhongRepository.save(
                        new KienThucAnNinhQuocPhong(req.batDau(), req.ketThuc(), req.tenCoSoDaoTao(), req.chungChiDuocCap(), XacNhan.CHO_PHE_DUYET, id)
                );
                return mapperKienThucAnNinhQuocPhong.mapToResKienThucAnNinhQuocPhong(phong);
            } catch (RuntimeException e) {
                System.err.println(e.getMessage());
                throw e;
            }
        }

        @Override
        public ResKienThucAnNinhQuocPhong sua(int id, ReqKienThucAnNinhQuocPhong req, String role) {
            try {
                return kienThucAnNinhQuocPhongRepository.findById(id).map(c -> {
                    if (role.equals("ADMIN") ||
                            (role.equals("EMPLOYEE")
                                    && c.getXacNhan().equals(XacNhan.CHO_PHE_DUYET))) {
                        c.setBatDau(req.batDau());
                        c.setKetThuc(req.ketThuc());
                        c.setTenCoSoDaoTaoId(req.tenCoSoDaoTao());
                        c.setChungChiDuocCap(req.chungChiDuocCap());
                        c.setUpdateAt();
                        KienThucAnNinhQuocPhong phong = kienThucAnNinhQuocPhongRepository.save(c);
                        return mapperKienThucAnNinhQuocPhong.mapToResKienThucAnNinhQuocPhong(phong);
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
                                    && c.getXacNhan().equals(XacNhan.CHO_PHE_DUYET))) {
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
        public ResTheDTO<ResKienThucAnNinhQuocPhong> xemDanhSachCaNhan(int taiKhoanId, XacNhan xacNhan, String byDate, int pageNumber, int pageSize) {
            ResHoSoTomTatClient client = hoSoClient.getHoSoId(taiKhoanId);
            UUID id = client.hoSoId();
            return xemDanhSachTheoHoSoId(id, xacNhan, byDate, pageNumber, pageSize);
        }

        @Override
        public ResKienThucAnNinhQuocPhong themCaNhan(int taiKhoanId, ReqKienThucAnNinhQuocPhong cu) {
            ResHoSoTomTatClient client = hoSoClient.getHoSoId(taiKhoanId);
            UUID id = client.hoSoId();
            return them(id, cu);
        }

        @Override
        public boolean xacNhan(XacNhan xacNhan, List<ResKienThucAnNinhQuocPhong> res) {
            List<KienThucAnNinhQuocPhong> phongs = new ArrayList<>();
            for (ResKienThucAnNinhQuocPhong c : res) {
                KienThucAnNinhQuocPhong cu = kienThucAnNinhQuocPhongRepository.findById(c.id()).orElseThrow(() -> new ResponseStatusException(ResEnum.KHONG_DUOC_UY_QUYEN.getStatusCode()));
                cu.setXacNhan(xacNhan);
                cu.setUpdateAt();
                phongs.add(cu);
            }
            kienThucAnNinhQuocPhongRepository.saveAll(phongs);
            return true;
        }
    }

    @Service
    public class KyLuatService implements IHoSoChiTietServices.IHoKyLuatServiceChiTiet {
        @Override
        public ResTheDTO<ResKyLuat> xemDanhSach(XacNhan xacNhan, String byDate, int pageNumber, int pageSize) {
            Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.by(Sort.Direction.DESC, byDate));
            Page<KyLuat> page = kyLuatRepository.findAll(pageable);
            List<ResKyLuat> list = page.getContent().stream().map(mapperKyLuat::mapToResKyLuat).toList();
            long totalRecord = page.getTotalElements();
            int totalPage = page.getTotalPages();
            return new ResTheDTO<>(list, totalRecord, totalPage);
        }

        @Override
        public ResTheDTO<ResKyLuat> xemDanhSachTheoHoSoId(UUID id, XacNhan xacNhan, String byDate, int pageNumber, int pageSize) {
            Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.by(Sort.Direction.DESC, byDate));
            Page<KyLuat> page = kyLuatRepository.getAllByHoSo(id, xacNhan, pageable);
            List<ResKyLuat> list = page.getContent().stream().map(mapperKyLuat::mapToResKyLuat).toList();
            long totalRecord = page.getTotalElements();
            int totalPage = page.getTotalPages();
            return new ResTheDTO<>(list, totalRecord, totalPage);
        }

        @Override
        public ResKyLuat xemChiTiet(int id) {
            try {
                KyLuat luat = kyLuatRepository.findById(id).orElse(null);
                return mapperKyLuat.mapToResKyLuat(luat);
            } catch (RuntimeException e) {
                System.err.println(e.getMessage());
                throw e;
            }
        }

        @Override
        public ResKyLuat them(UUID id, ReqKyLuat req) {
            try {
                KyLuat luat = kyLuatRepository.save(new KyLuat(req.batDau(), req.ketThuc(), req.hinhThuc(), req.hanhViViPhamChinh(), req.coQuanQuyetDinhId(), XacNhan.CHO_PHE_DUYET, id));
                return mapperKyLuat.mapToResKyLuat(luat);
            } catch (RuntimeException e) {
                System.err.println(e.getMessage());
                throw e;
            }
        }

        @Override
        public ResKyLuat sua(int id, ReqKyLuat req, String role) {
            try {
                return kyLuatRepository.findById(id).map(c -> {
                    if (role.equals("ADMIN") ||
                            (role.equals("EMPLOYEE")
                                    && c.getXacNhan().equals(XacNhan.CHO_PHE_DUYET))) {
                        c.setBatDau(req.batDau());
                        c.setKetThuc(req.ketThuc());
                        c.setHinhThuc(req.hinhThuc());
                        c.setHanhViViPhamChinh(req.hanhViViPhamChinh());
                        c.setCoQuanQuyetDinhId(req.coQuanQuyetDinhId());
                        c.setUpdateAt();
                        KyLuat luat = kyLuatRepository.save(c);
                        return mapperKyLuat.mapToResKyLuat(luat);
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
                                    && c.getXacNhan().equals(XacNhan.CHO_PHE_DUYET))) {
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
        public ResTheDTO<ResKyLuat> xemDanhSachCaNhan(int taiKhoanId, XacNhan xacNhan, String byDate, int pageNumber, int pageSize) {
            ResHoSoTomTatClient client = hoSoClient.getHoSoId(taiKhoanId);
            UUID id = client.hoSoId();
            return xemDanhSachTheoHoSoId(id, xacNhan, byDate, pageNumber, pageSize);
        }

        @Override
        public ResKyLuat themCaNhan(int taiKhoanId, ReqKyLuat cu) {
            ResHoSoTomTatClient client = hoSoClient.getHoSoId(taiKhoanId);
            UUID id = client.hoSoId();
            return them(id, cu);
        }

        @Override
        public boolean xacNhan(XacNhan xacNhan, List<ResKyLuat> res) {
            List<KyLuat> kyLuats = new ArrayList<>();
            for (ResKyLuat c : res) {
                KyLuat cu = kyLuatRepository.findById(c.id()).orElseThrow(() -> new ResponseStatusException(ResEnum.KHONG_DUOC_UY_QUYEN.getStatusCode()));
                cu.setXacNhan(xacNhan);
                cu.setUpdateAt();
                kyLuats.add(cu);
            }
            kyLuatRepository.saveAll(kyLuats);
            return true;
        }
    }

    @Service
    public class LamViecONuocNgoaiServcie implements IHoSoChiTietServices.IHoLamViecONuocNgoaiServiceChiTiet {
        @Override
        public ResTheDTO<ResLamViecONuocNgoai> xemDanhSach(XacNhan xacNhan, String byDate, int pageNumber, int pageSize) {
            Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.by(Sort.Direction.DESC, byDate));
            Page<LamViecONuocNgoai> page = lamViecONuocNgoaiRepository.findAll(pageable);
            List<ResLamViecONuocNgoai> list = page.getContent().stream().map(mapperLamViecONuocNgoai::mapToResLamViecONuocNgoai).toList();
            long totalRecord = page.getTotalElements();
            int totalPage = page.getTotalPages();
            return new ResTheDTO<>(list, totalRecord, totalPage);
        }

        @Override
        public ResTheDTO<ResLamViecONuocNgoai> xemDanhSachTheoHoSoId(UUID id, XacNhan xacNhan, String byDate, int pageNumber, int pageSize) {
            Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.by(Sort.Direction.DESC, byDate));
            Page<LamViecONuocNgoai> page = lamViecONuocNgoaiRepository.getAllByHoSo(id, xacNhan, pageable);
            List<ResLamViecONuocNgoai> list = page.getContent().stream().map(mapperLamViecONuocNgoai::mapToResLamViecONuocNgoai).toList();
            long totalRecord = page.getTotalElements();
            int totalPage = page.getTotalPages();
            return new ResTheDTO<>(list, totalRecord, totalPage);
        }

        @Override
        public ResLamViecONuocNgoai xemChiTiet(int id) {
            try {
                LamViecONuocNgoai ngoai = lamViecONuocNgoaiRepository.findById(id).orElse(null);
                return mapperLamViecONuocNgoai.mapToResLamViecONuocNgoai(ngoai);
            } catch (RuntimeException e) {
                System.err.println(e.getMessage());
                throw e;
            }
        }

        @Override
        public ResLamViecONuocNgoai them(UUID id, ReqLamViecONuocNgoai req) {
            try {
                LamViecONuocNgoai ngoai = lamViecONuocNgoaiRepository.save(
                        new LamViecONuocNgoai(req.batDau(), req.ketThuc(), req.toChucDiaChiCongViec(), XacNhan.CHO_PHE_DUYET, id)
                );
                return mapperLamViecONuocNgoai.mapToResLamViecONuocNgoai(ngoai);
            } catch (RuntimeException e) {
                System.err.println(e.getMessage());
                throw e;
            }
        }

        @Override
        public ResLamViecONuocNgoai sua(int id, ReqLamViecONuocNgoai req, String role) {
            try {
                return lamViecONuocNgoaiRepository.findById(id).map(c -> {
                    if (role.equals("ADMIN") ||
                            (role.equals("EMPLOYEE")
                                    && c.getXacNhan().equals(XacNhan.CHO_PHE_DUYET))) {
                        c.setBatDau(req.batDau());
                        c.setKetThuc(req.ketThuc());
                        c.setToChucDiaChiCongViec(req.toChucDiaChiCongViec());
                        c.setUpdateAt();
                        LamViecONuocNgoai ngoai = lamViecONuocNgoaiRepository.save(c);
                        return mapperLamViecONuocNgoai.mapToResLamViecONuocNgoai(ngoai);
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
                                    && c.getXacNhan().equals(XacNhan.CHO_PHE_DUYET))) {
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
        public ResTheDTO<ResLamViecONuocNgoai> xemDanhSachCaNhan(int taiKhoanId, XacNhan xacNhan, String byDate, int pageNumber, int pageSize) {
            ResHoSoTomTatClient client = hoSoClient.getHoSoId(taiKhoanId);
            UUID id = client.hoSoId();
            return xemDanhSachTheoHoSoId(id, xacNhan, byDate, pageNumber, pageSize);
        }

        @Override
        public ResLamViecONuocNgoai themCaNhan(int taiKhoanId, ReqLamViecONuocNgoai cu) {
            ResHoSoTomTatClient client = hoSoClient.getHoSoId(taiKhoanId);
            UUID id = client.hoSoId();
            return them(id, cu);
        }

        @Override
        public boolean xacNhan(XacNhan xacNhan, List<ResLamViecONuocNgoai> res) {
            List<LamViecONuocNgoai> ngoais = new ArrayList<>();
            for (ResLamViecONuocNgoai c : res) {
                LamViecONuocNgoai cu = lamViecONuocNgoaiRepository.findById(c.id()).orElseThrow(() -> new ResponseStatusException(ResEnum.KHONG_DUOC_UY_QUYEN.getStatusCode()));
                cu.setXacNhan(xacNhan);
                cu.setUpdateAt();
                ngoais.add(cu);
            }
            lamViecONuocNgoaiRepository.saveAll(ngoais);
            return true;
        }
    }

    @Service
    public class LuongBanThanService implements IHoSoChiTietServices.IHoLuongBanThanServiceChiTiet {
        @Override
        public ResTheDTO<ResLuongBanThan> xemDanhSach(XacNhan xacNhan, String byDate, int pageNumber, int pageSize) {
            Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.by(Sort.Direction.DESC, byDate));
            Page<LuongBanThan> page = luongBanThanRepository.findAll(pageable);
            List<ResLuongBanThan> list = page.getContent().stream().map(mapperLuongBanThan::mapToResLuongBanThan).toList();
            long totalRecord = page.getTotalElements();
            int totalPage = page.getTotalPages();
            return new ResTheDTO<>(list, totalRecord, totalPage);
        }

        @Override
        public ResTheDTO<ResLuongBanThan> xemDanhSachTheoHoSoId(UUID id, XacNhan xacNhan, String byDate, int pageNumber, int pageSize) {
            Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.by(Sort.Direction.DESC, byDate));
            Page<LuongBanThan> page = luongBanThanRepository.getAllByHoSo(id, xacNhan, pageable);
            List<ResLuongBanThan> list = page.getContent().stream().map(mapperLuongBanThan::mapToResLuongBanThan).toList();
            long totalRecord = page.getTotalElements();
            int totalPage = page.getTotalPages();
            return new ResTheDTO<>(list, totalRecord, totalPage);
        }

        @Override
        public ResLuongBanThan xemChiTiet(int id) {
            try {
                LuongBanThan than = luongBanThanRepository.findById(id).orElse(null);
                return mapperLuongBanThan.mapToResLuongBanThan(than);
            } catch (RuntimeException e) {
                System.err.println(e.getMessage());
                throw e;
            }
        }

        @Override
        public ResLuongBanThan them(UUID id, ReqLuongBanThan req) {
            try {
                LuongBanThan than = luongBanThanRepository.save(
                        new LuongBanThan(req.batDau(), req.ketThuc(), req.maSo(), req.bacLuong(), req.heSoLuong(), req.tienLuongTheoViTri(), XacNhan.CHO_PHE_DUYET, id)
                );
                return mapperLuongBanThan.mapToResLuongBanThan(than);
            } catch (RuntimeException e) {
                System.err.println(e.getMessage());
                throw e;
            }
        }

        @Override
        public ResLuongBanThan sua(int id, ReqLuongBanThan req, String role) {
            try {
                return luongBanThanRepository.findById(id).map(c -> {
                    if (role.equals("ADMIN") ||
                            (role.equals("EMPLOYEE")
                                    && c.getXacNhan().equals(XacNhan.CHO_PHE_DUYET))) {
                        c.setBatDau(req.batDau());
                        c.setKetThuc(req.ketThuc());
                        c.setMaSo(req.maSo());
                        c.setBacLuong(req.bacLuong());
                        c.setHeSoLuong(req.heSoLuong());
                        c.setTienLuongTheoViTri(req.tienLuongTheoViTri());
                        c.setUpdateAt();
                        LuongBanThan than = luongBanThanRepository.save(c);
                        return mapperLuongBanThan.mapToResLuongBanThan(than);
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
                                    && c.getXacNhan().equals(XacNhan.CHO_PHE_DUYET))) {
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
        public ResTheDTO<ResLuongBanThan> xemDanhSachCaNhan(int taiKhoanId, XacNhan xacNhan, String byDate, int pageNumber, int pageSize) {
            ResHoSoTomTatClient client = hoSoClient.getHoSoId(taiKhoanId);
            UUID id = client.hoSoId();
            return xemDanhSachTheoHoSoId(id, xacNhan, byDate, pageNumber, pageSize);
        }

        @Override
        public ResLuongBanThan themCaNhan(int taiKhoanId, ReqLuongBanThan cu) {
            ResHoSoTomTatClient client = hoSoClient.getHoSoId(taiKhoanId);
            UUID id = client.hoSoId();
            return them(id, cu);
        }

        @Override
        public boolean xacNhan(XacNhan xacNhan, List<ResLuongBanThan> res) {
            List<LuongBanThan> luongs = new ArrayList<>();
            for (ResLuongBanThan c : res) {
                LuongBanThan cu = luongBanThanRepository.findById(c.id()).orElseThrow(() -> new ResponseStatusException(ResEnum.KHONG_DUOC_UY_QUYEN.getStatusCode()));
                cu.setXacNhan(xacNhan);
                cu.setUpdateAt();
                luongs.add(cu);
            }
            luongBanThanRepository.saveAll(luongs);
            return true;
        }
    }

    @Service
    public class LyHoLuanChinhTriServiceChiTiet implements IHoSoChiTietServices.IHoLyLuanChinhTriServiceChiTiet {
        @Override
        public ResTheDTO<ResLyLuanChinhTri> xemDanhSach(XacNhan xacNhan, String byDate, int pageNumber, int pageSize) {
            Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.by(Sort.Direction.DESC, byDate));
            Page<LyLuanChinhTri> page = lyLuanChinhTriRepository.findAll(pageable);
            List<ResLyLuanChinhTri> list = page.getContent().stream().map(mapperLyLuanChinhTri::mapToResLyLuanChinhTri).toList();
            long totalRecord = page.getTotalElements();
            int totalPage = page.getTotalPages();
            return new ResTheDTO<>(list, totalRecord, totalPage);
        }

        @Override
        public ResTheDTO<ResLyLuanChinhTri> xemDanhSachTheoHoSoId(UUID id, XacNhan xacNhan, String byDate, int pageNumber, int pageSize) {
            Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.by(Sort.Direction.DESC, byDate));
            Page<LyLuanChinhTri> page = lyLuanChinhTriRepository.getAllByHoSo(id, xacNhan, pageable);
            List<ResLyLuanChinhTri> list = page.getContent().stream().map(mapperLyLuanChinhTri::mapToResLyLuanChinhTri).toList();
            long totalRecord = page.getTotalElements();
            int totalPage = page.getTotalPages();
            return new ResTheDTO<>(list, totalRecord, totalPage);
        }

        @Override
        public ResLyLuanChinhTri xemChiTiet(int id) {
            try {
                LyLuanChinhTri tri = lyLuanChinhTriRepository.findById(id).orElse(null);
                return mapperLyLuanChinhTri.mapToResLyLuanChinhTri(tri);
            } catch (RuntimeException e) {
                System.err.println(e.getMessage());
                throw e;
            }
        }

        @Override
        public ResLyLuanChinhTri them(UUID id, ReqLyLuanChinhTri req) {
            try {
                LyLuanChinhTri tri = lyLuanChinhTriRepository.save(new LyLuanChinhTri(req.batDau(), req.ketThuc(), req.tenCoSoDaoTaoId(), req.hinhThucDaoTao(), req.vanBangDuocCap(), XacNhan.CHO_PHE_DUYET, id));
                return mapperLyLuanChinhTri.mapToResLyLuanChinhTri(tri);
            } catch (RuntimeException e) {
                System.err.println(e.getMessage());
                throw e;
            }
        }

        @Override
        public ResLyLuanChinhTri sua(int id, ReqLyLuanChinhTri req, String role) {
            try {
                return lyLuanChinhTriRepository.findById(id).map(c -> {
                    if (role.equals("ADMIN") ||
                            (role.equals("EMPLOYEE")
                                    && c.getXacNhan().equals(XacNhan.CHO_PHE_DUYET))) {
                        c.setBatDau(req.batDau());
                        c.setKetThuc(req.ketThuc());
                        c.setTenCoSoDaoTaoId(req.tenCoSoDaoTaoId());
                        c.setHinhThucDaoTao(req.hinhThucDaoTao());
                        c.setVanBangDuocCap(req.vanBangDuocCap());
                        c.setUpdateAt();
                        LyLuanChinhTri tri = lyLuanChinhTriRepository.save(c);
                        return mapperLyLuanChinhTri.mapToResLyLuanChinhTri(tri);
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
                                    && c.getXacNhan().equals(XacNhan.CHO_PHE_DUYET))) {
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
        public ResTheDTO<ResLyLuanChinhTri> xemDanhSachCaNhan(int taiKhoanId, XacNhan xacNhan, String byDate, int pageNumber, int pageSize) {
            ResHoSoTomTatClient client = hoSoClient.getHoSoId(taiKhoanId);
            UUID id = client.hoSoId();
            return xemDanhSachTheoHoSoId(id, xacNhan, byDate, pageNumber, pageSize);
        }

        @Override
        public ResLyLuanChinhTri themCaNhan(int taiKhoanId, ReqLyLuanChinhTri cu) {
            ResHoSoTomTatClient client = hoSoClient.getHoSoId(taiKhoanId);
            UUID id = client.hoSoId();
            return them(id, cu);
        }

        @Override
        public boolean xacNhan(XacNhan xacNhan, List<ResLyLuanChinhTri> res) {
            List<LyLuanChinhTri> tris = new ArrayList<>();
            for (ResLyLuanChinhTri c : res) {
                LyLuanChinhTri cu = lyLuanChinhTriRepository.findById(c.id()).orElseThrow(() -> new ResponseStatusException(ResEnum.KHONG_DUOC_UY_QUYEN.getStatusCode()));
                cu.setXacNhan(xacNhan);
                cu.setUpdateAt();
                tris.add(cu);
            }
            lyLuanChinhTriRepository.saveAll(tris);
            return true;
        }
    }

    @Service
    public class NghiepVuChuyenNganhService implements IHoSoChiTietServices.IHoNghiepVuChuyenNganhServiceChiTiet {
        @Override
        public ResTheDTO<ResNghiepVuChuyenNganh> xemDanhSach(XacNhan xacNhan, String byDate, int pageNumber, int pageSize) {
            Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.by(Sort.Direction.DESC, byDate));
            Page<NghiepVuChuyenNganh> page = nghiepVuChuyenNganhRepository.findAll(pageable);
            List<ResNghiepVuChuyenNganh> list = page.getContent().stream().map(mapperNghiepVuChuyenNganh::mapToResNghiepVuChuyenNganh).toList();
            long totalRecord = page.getTotalElements();
            int totalPage = page.getTotalPages();
            return new ResTheDTO<>(list, totalRecord, totalPage);
        }

        @Override
        public ResTheDTO<ResNghiepVuChuyenNganh> xemDanhSachTheoHoSoId(UUID id, XacNhan xacNhan, String byDate, int pageNumber, int pageSize) {
            Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.by(Sort.Direction.DESC, byDate));
            Page<NghiepVuChuyenNganh> page = nghiepVuChuyenNganhRepository.getAllByHoSo(id, xacNhan, pageable);
            List<ResNghiepVuChuyenNganh> list = page.getContent().stream().map(mapperNghiepVuChuyenNganh::mapToResNghiepVuChuyenNganh).toList();
            long totalRecord = page.getTotalElements();
            int totalPage = page.getTotalPages();
            return new ResTheDTO<>(list, totalRecord, totalPage);
        }

        @Override
        public ResNghiepVuChuyenNganh xemChiTiet(int id) {
            try {
                NghiepVuChuyenNganh nganh = nghiepVuChuyenNganhRepository.findById(id).orElse(null);
                return mapperNghiepVuChuyenNganh.mapToResNghiepVuChuyenNganh(nganh);
            } catch (RuntimeException e) {
                System.err.println(e.getMessage());
                throw e;
            }
        }

        @Override
        public ResNghiepVuChuyenNganh them(UUID id, ReqNghiepVuChuyenNganh req) {
            try {
                NghiepVuChuyenNganh nganh = nghiepVuChuyenNganhRepository.save(new NghiepVuChuyenNganh(req.batDau(), req.ketThuc(), req.tenCoSoDaoTaoId(), req.chungChiDuocCap(), XacNhan.CHO_PHE_DUYET, id));
                return mapperNghiepVuChuyenNganh.mapToResNghiepVuChuyenNganh(nganh);
            } catch (RuntimeException e) {
                System.err.println(e.getMessage());
                throw e;
            }
        }

        @Override
        public ResNghiepVuChuyenNganh sua(int id, ReqNghiepVuChuyenNganh req, String role) {
            try {
                return nghiepVuChuyenNganhRepository.findById(id).map(c -> {
                    if (role.equals("ADMIN") ||
                            (role.equals("EMPLOYEE")
                                    && c.getXacNhan().equals(XacNhan.CHO_PHE_DUYET))) {
                        c.setBatDau(req.batDau());
                        c.setKetThuc(req.ketThuc());
                        c.setTenCoSoDaoTaoId(req.tenCoSoDaoTaoId());
                        c.setChungChiDuocCap(req.chungChiDuocCap());
                        c.setUpdateAt();
                        NghiepVuChuyenNganh nganh = nghiepVuChuyenNganhRepository.save(c);
                        return mapperNghiepVuChuyenNganh.mapToResNghiepVuChuyenNganh(nganh);
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
                                    && c.getXacNhan().equals(XacNhan.CHO_PHE_DUYET))) {
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
        public ResTheDTO<ResNghiepVuChuyenNganh> xemDanhSachCaNhan(int taiKhoanId, XacNhan xacNhan, String byDate, int pageNumber, int pageSize) {
            ResHoSoTomTatClient client = hoSoClient.getHoSoId(taiKhoanId);
            UUID id = client.hoSoId();
            return xemDanhSachTheoHoSoId(id, xacNhan, byDate, pageNumber, pageSize);
        }

        @Override
        public ResNghiepVuChuyenNganh themCaNhan(int taiKhoanId, ReqNghiepVuChuyenNganh cu) {
            ResHoSoTomTatClient client = hoSoClient.getHoSoId(taiKhoanId);
            UUID id = client.hoSoId();
            return them(id, cu);
        }

        @Override
        public boolean xacNhan(XacNhan xacNhan, List<ResNghiepVuChuyenNganh> res) {
            List<NghiepVuChuyenNganh> nganhs = new ArrayList<>();
            for (ResNghiepVuChuyenNganh c : res) {
                NghiepVuChuyenNganh cu = nghiepVuChuyenNganhRepository.findById(c.id()).orElseThrow(() -> new ResponseStatusException(ResEnum.KHONG_DUOC_UY_QUYEN.getStatusCode()));
                cu.setXacNhan(xacNhan);
                cu.setUpdateAt();
                nganhs.add(cu);
            }
            nghiepVuChuyenNganhRepository.saveAll(nganhs);
            return true;
        }
    }

    @Service
    public class NgoaiNguService implements IHoSoChiTietServices.IHoNgoaiNguServiceChiTiet {
        @Override
        public ResTheDTO<ResNgoaiNgu> xemDanhSach(XacNhan xacNhan, String byDate, int pageNumber, int pageSize) {
            Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.by(Sort.Direction.DESC, byDate));
            Page<NgoaiNgu> page = ngoaiNguRepository.findAll(pageable);
            List<ResNgoaiNgu> list = page.getContent().stream().map(mapperNgoaiNgu::mapToResNgoaiNgu).toList();
            long totalRecord = page.getTotalElements();
            int totalPage = page.getTotalPages();
            return new ResTheDTO<>(list, totalRecord, totalPage);
        }

        @Override
        public ResTheDTO<ResNgoaiNgu> xemDanhSachTheoHoSoId(UUID id, XacNhan xacNhan, String byDate, int pageNumber, int pageSize) {
            Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.by(Sort.Direction.DESC, byDate));
            Page<NgoaiNgu> page = ngoaiNguRepository.getAllByHoSo(id, xacNhan, pageable);
            List<ResNgoaiNgu> list = page.getContent().stream().map(mapperNgoaiNgu::mapToResNgoaiNgu).toList();
            long totalRecord = page.getTotalElements();
            int totalPage = page.getTotalPages();
            return new ResTheDTO<>(list, totalRecord, totalPage);
        }

        @Override
        public ResNgoaiNgu xemChiTiet(int id) {
            try {
                NgoaiNgu ngu = ngoaiNguRepository.findById(id).orElse(null);
                return mapperNgoaiNgu.mapToResNgoaiNgu(ngu);
            } catch (RuntimeException e) {
                System.err.println(e.getMessage());
                throw e;
            }
        }

        @Override
        public ResNgoaiNgu them(UUID id, ReqNgoaiNgu req) {
            try {
                NgoaiNgu ngu = ngoaiNguRepository.save(new NgoaiNgu(req.batDau(), req.ketThuc(), req.tenCoSoDaoTaoId(), req.tenNgoaiNgu(), req.chungChiDuocCap(), req.diemSo(), XacNhan.CHO_PHE_DUYET, id));
                return mapperNgoaiNgu.mapToResNgoaiNgu(ngu);
            } catch (RuntimeException e) {
                System.err.println(e.getMessage());
                throw e;
            }
        }

        @Override
        public ResNgoaiNgu sua(int id, ReqNgoaiNgu req, String role) {
            try {
                return ngoaiNguRepository.findById(id).map(c -> {
                    if (role.equals("ADMIN") ||
                            (role.equals("EMPLOYEE")
                                    && c.getXacNhan().equals(XacNhan.CHO_PHE_DUYET))) {
                        c.setBatDau(req.batDau());
                        c.setKetThuc(req.ketThuc());
                        c.setTenCoSoDaoTaoId(req.tenCoSoDaoTaoId());
                        c.setTenNgoaiNgu(req.tenNgoaiNgu());
                        c.setChungChiDuocCap(req.chungChiDuocCap());
                        c.setDiemSo(req.diemSo());
                        c.setUpdateAt();
                        NgoaiNgu ngu = ngoaiNguRepository.save(c);
                        return mapperNgoaiNgu.mapToResNgoaiNgu(ngu);
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
                                    && c.getXacNhan().equals(XacNhan.CHO_PHE_DUYET))) {
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
        public ResTheDTO<ResNgoaiNgu> xemDanhSachCaNhan(int taiKhoanId, XacNhan xacNhan, String byDate, int pageNumber, int pageSize) {
            ResHoSoTomTatClient client = hoSoClient.getHoSoId(taiKhoanId);
            UUID id = client.hoSoId();
            return xemDanhSachTheoHoSoId(id, xacNhan, byDate, pageNumber, pageSize);
        }

        @Override
        public ResNgoaiNgu themCaNhan(int taiKhoanId, ReqNgoaiNgu cu) {
            ResHoSoTomTatClient client = hoSoClient.getHoSoId(taiKhoanId);
            UUID id = client.hoSoId();
            return them(id, cu);
        }

        @Override
        public boolean xacNhan(XacNhan xacNhan, List<ResNgoaiNgu> res) {
            List<NgoaiNgu> ngus = new ArrayList<>();
            for (ResNgoaiNgu c : res) {
                NgoaiNgu cu = ngoaiNguRepository.findById(c.id()).orElseThrow(() -> new ResponseStatusException(ResEnum.KHONG_DUOC_UY_QUYEN.getStatusCode()));
                cu.setXacNhan(xacNhan);
                cu.setUpdateAt();
                ngus.add(cu);
            }
            ngoaiNguRepository.saveAll(ngus);
            return true;
        }
    }

    @Service
    public class PhuCapKhacService implements IHoSoChiTietServices.IHoPhuCapKhacServiceChiTiet {
        @Override
        public ResTheDTO<ResPhuCapKhac> xemDanhSach(XacNhan xacNhan, String byDate, int pageNumber, int pageSize) {
            Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.by(Sort.Direction.DESC, byDate));
            Page<PhuCapKhac> page = phuCapKhacRepository.findAll(pageable);
            List<ResPhuCapKhac> list = page.getContent().stream().map(mapperPhuCapKhac::mapToResPhuCapKhac).toList();
            long totalRecord = page.getTotalElements();
            int totalPage = page.getTotalPages();
            return new ResTheDTO<>(list, totalRecord, totalPage);
        }

        @Override
        public ResTheDTO<ResPhuCapKhac> xemDanhSachTheoHoSoId(UUID id, XacNhan xacNhan, String byDate, int pageNumber, int pageSize) {
            Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.by(Sort.Direction.DESC, byDate));
            Page<PhuCapKhac> page = phuCapKhacRepository.getAllByHoSo(id, xacNhan, pageable);
            List<ResPhuCapKhac> list = page.getContent().stream().map(mapperPhuCapKhac::mapToResPhuCapKhac).toList();
            long totalRecord = page.getTotalElements();
            int totalPage = page.getTotalPages();
            return new ResTheDTO<>(list, totalRecord, totalPage);
        }

        @Override
        public ResPhuCapKhac xemChiTiet(int id) {
            try {
                PhuCapKhac khac = phuCapKhacRepository.findById(id).orElse(null);
                return mapperPhuCapKhac.mapToResPhuCapKhac(khac);
            } catch (RuntimeException e) {
                System.err.println(e.getMessage());
                throw e;
            }
        }

        @Override
        public ResPhuCapKhac them(UUID id, ReqPhuCapKhac req) {
            PhuCapKhac khac = phuCapKhacRepository.save(new PhuCapKhac(
                    req.batDau(), req.ketThuc(), req.loaiPhuCapId(), req.phanTramHuongPhuCap(), req.heSoPhuCap(), req.hinhThucThuong(), req.giaTri(), XacNhan.CHO_PHE_DUYET, id));
            return mapperPhuCapKhac.mapToResPhuCapKhac(khac);
        }

        @Override
        public ResPhuCapKhac sua(int id, ReqPhuCapKhac req, String role) {
            try {
                return phuCapKhacRepository.findById(id).map(c -> {
                    if (role.equals("ADMIN") ||
                            (role.equals("EMPLOYEE")
                                    && c.getXacNhan().equals(XacNhan.CHO_PHE_DUYET))) {
                        c.setBatDau(req.batDau());
                        c.setKetThuc(req.ketThuc());
                        c.setLoaiPhuCapId(req.loaiPhuCapId());
                        c.setPhanTramHuongPhuCap(req.phanTramHuongPhuCap());
                        c.setHeSoPhuCap(req.heSoPhuCap());
                        c.setHinhThucHuong(req.hinhThucThuong());
                        c.setGiaTri(req.giaTri());
                        c.setUpdateAt();
                        PhuCapKhac khac = phuCapKhacRepository.save(c);
                        return mapperPhuCapKhac.mapToResPhuCapKhac(khac);
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
                                    && c.getXacNhan().equals(XacNhan.CHO_PHE_DUYET))) {
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
        public ResTheDTO<ResPhuCapKhac> xemDanhSachCaNhan(int taiKhoanId, XacNhan xacNhan, String byDate, int pageNumber, int pageSize) {
            ResHoSoTomTatClient client = hoSoClient.getHoSoId(taiKhoanId);
            UUID id = client.hoSoId();
            return xemDanhSachTheoHoSoId(id, xacNhan, byDate, pageNumber, pageSize);
        }

        @Override
        public ResPhuCapKhac themCaNhan(int taiKhoanId, ReqPhuCapKhac cu) {
            ResHoSoTomTatClient client = hoSoClient.getHoSoId(taiKhoanId);
            UUID id = client.hoSoId();
            return them(id, cu);
        }

        @Override
        public boolean xacNhan(XacNhan xacNhan, List<ResPhuCapKhac> res) {
            List<PhuCapKhac> khacs = new ArrayList<>();
            for (ResPhuCapKhac c : res) {
                PhuCapKhac cu = phuCapKhacRepository.findById(c.id()).orElseThrow(() -> new ResponseStatusException(ResEnum.KHONG_DUOC_UY_QUYEN.getStatusCode()));
                cu.setXacNhan(xacNhan);
                cu.setUpdateAt();
                khacs.add(cu);
            }
            phuCapKhacRepository.saveAll(khacs);
            return true;
        }
    }

    @Service
    public class QuanHeGiaDinhService implements IHoSoChiTietServices.IHoQuanHeGiaDinhServiceChiTiet {
        @Override
        public ResTheDTO<ResQuanHeGiaDinh> xemDanhSach(XacNhan xacNhan, String byDate, int pageNumber, int pageSize) {
            Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.by(Sort.Direction.DESC, byDate));
            Page<QuanHeGiaDinh> page = quanHeGiaDinhRepository.findAll(pageable);
            List<ResQuanHeGiaDinh> list = page.getContent().stream().map(mapperQuanHeGiaDinh::mapToResQuanHeGiaDinh).toList();
            long totalRecord = page.getTotalElements();
            int totalPage = page.getTotalPages();
            return new ResTheDTO<>(list, totalRecord, totalPage);
        }

        @Override
        public ResTheDTO<ResQuanHeGiaDinh> xemDanhSachTheoHoSoId(UUID id, XacNhan xacNhan, String byDate, int pageNumber, int pageSize) {
            Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.by(Sort.Direction.DESC, byDate));
            Page<QuanHeGiaDinh> page = quanHeGiaDinhRepository.getAllByHoSo(id, xacNhan, pageable);
            List<ResQuanHeGiaDinh> list = page.getContent().stream().map(mapperQuanHeGiaDinh::mapToResQuanHeGiaDinh).toList();
            long totalRecord = page.getTotalElements();
            int totalPage = page.getTotalPages();
            return new ResTheDTO<>(list, totalRecord, totalPage);
        }

        @Override
        public ResQuanHeGiaDinh xemChiTiet(int id) {
            try {
                QuanHeGiaDinh dinh = quanHeGiaDinhRepository.findById(id).orElse(null);
                return mapperQuanHeGiaDinh.mapToResQuanHeGiaDinh(dinh);
            } catch (RuntimeException e) {
                System.err.println(e.getMessage());
                throw e;
            }
        }

        @Override
        public ResQuanHeGiaDinh them(UUID id, ReqQuanHeGiaDinh req) {
            try {
                QuanHeGiaDinh dinh = quanHeGiaDinhRepository.save(new QuanHeGiaDinh(req.moiQuanHeId(), req.hoVaTen(), req.namSinh(), req.thongTinThanNhan(), XacNhan.CHO_PHE_DUYET, id));
                return mapperQuanHeGiaDinh.mapToResQuanHeGiaDinh(dinh);
            } catch (RuntimeException e) {
                System.err.println(e.getMessage());
                throw e;
            }
        }

        @Override
        public ResQuanHeGiaDinh sua(int id, ReqQuanHeGiaDinh req, String role) {
            try {
                return quanHeGiaDinhRepository.findById(id).map(c -> {
                    if (role.equals("ADMIN") ||
                            (role.equals("EMPLOYEE")
                                    && c.getXacNhan().equals(XacNhan.CHO_PHE_DUYET))) {
                        c.setMoiQuanHeId(req.moiQuanHeId());
                        c.setHoVaTen(req.hoVaTen());
                        c.setNamSinh(req.namSinh());
                        c.setThongTinThanNhan(req.thongTinThanNhan());
                        c.setUpdateAt();
                        QuanHeGiaDinh dinh = quanHeGiaDinhRepository.save(c);
                        return mapperQuanHeGiaDinh.mapToResQuanHeGiaDinh(dinh);
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
                                    && c.getXacNhan().equals(XacNhan.CHO_PHE_DUYET))) {
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
        public ResTheDTO<ResQuanHeGiaDinh> xemDanhSachCaNhan(int taiKhoanId, XacNhan xacNhan, String byDate, int pageNumber, int pageSize) {
            ResHoSoTomTatClient client = hoSoClient.getHoSoId(taiKhoanId);
            UUID id = client.hoSoId();
            return xemDanhSachTheoHoSoId(id, xacNhan, byDate, pageNumber, pageSize);
        }

        @Override
        public ResQuanHeGiaDinh themCaNhan(int taiKhoanId, ReqQuanHeGiaDinh cu) {
            ResHoSoTomTatClient client = hoSoClient.getHoSoId(taiKhoanId);
            UUID id = client.hoSoId();
            return them(id, cu);
        }

        @Override
        public boolean xacNhan(XacNhan xacNhan, List<ResQuanHeGiaDinh> res) {
            List<QuanHeGiaDinh> giaDinhs = new ArrayList<>();
            for (ResQuanHeGiaDinh c : res) {
                QuanHeGiaDinh cu = quanHeGiaDinhRepository.findById(c.id()).orElseThrow(() -> new ResponseStatusException(ResEnum.KHONG_DUOC_UY_QUYEN.getStatusCode()));
                cu.setXacNhan(xacNhan);
                cu.setUpdateAt();
                giaDinhs.add(cu);
            }
            quanHeGiaDinhRepository.saveAll(giaDinhs);
            return true;
        }
    }

    @Service
    public class QuaTrinhCongTacService implements IHoSoChiTietServices.IHoQuaTrinhCongTacServiceChiTiet {
        @Override
        public ResTheDTO<ResQuaTrinhCongTac> xemDanhSach(XacNhan xacNhan, String byDate, int pageNumber, int pageSize) {
            Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.by(Sort.Direction.DESC, byDate));
            Page<QuaTrinhCongTac> page = quaTrinhCongTacRepository.findAll(pageable);
            List<ResQuaTrinhCongTac> list = page.getContent().stream().map(mapperQuaTrinhCongTac::mapToResQuaTrinhCongTac).toList();
            long totalRecord = page.getTotalElements();
            int totalPage = page.getTotalPages();
            return new ResTheDTO<>(list, totalRecord, totalPage);
        }

        @Override
        public ResTheDTO<ResQuaTrinhCongTac> xemDanhSachTheoHoSoId(UUID id, XacNhan xacNhan, String byDate, int pageNumber, int pageSize) {
            Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.by(Sort.Direction.DESC, byDate));
            Page<QuaTrinhCongTac> page = quaTrinhCongTacRepository.getAllByHoSo(id, xacNhan, pageable);
            List<ResQuaTrinhCongTac> list = page.getContent().stream().map(mapperQuaTrinhCongTac::mapToResQuaTrinhCongTac).toList();
            long totalRecord = page.getTotalElements();
            int totalPage = page.getTotalPages();
            return new ResTheDTO<>(list, totalRecord, totalPage);
        }

        @Override
        public ResQuaTrinhCongTac xemChiTiet(int id) {
            try {
                QuaTrinhCongTac tac = quaTrinhCongTacRepository.findById(id).orElse(null);
                return mapperQuaTrinhCongTac.mapToResQuaTrinhCongTac(tac);
            } catch (RuntimeException e) {
                System.err.println(e.getMessage());
                throw e;
            }
        }

        @Override
        public ResQuaTrinhCongTac them(UUID id, ReqQuaTrinhCongTac req) {
            try {
                QuaTrinhCongTac tac = quaTrinhCongTacRepository.save(new QuaTrinhCongTac(req.batDau(), req.ketThuc(), req.donViCongTacId(), req.chucDanh(), XacNhan.CHO_PHE_DUYET, id));
                return mapperQuaTrinhCongTac.mapToResQuaTrinhCongTac(tac);
            } catch (RuntimeException e) {
                System.err.println(e.getMessage());
                throw e;
            }
        }

        @Override
        public ResQuaTrinhCongTac sua(int id, ReqQuaTrinhCongTac req, String role) {
            try {
                return quaTrinhCongTacRepository.findById(id).map(c -> {
                    if (role.equals("ADMIN") ||
                            (role.equals("EMPLOYEE")
                                    && c.getXacNhan().equals(XacNhan.CHO_PHE_DUYET))) {
                        c.setBatDau(req.batDau());
                        c.setKetThuc(req.ketThuc());
                        c.setDonViCongTacId(req.donViCongTacId());
                        c.setChucDanh(req.chucDanh());
                        c.setUpdateAt();
                        QuaTrinhCongTac tac = quaTrinhCongTacRepository.save(c);
                        return mapperQuaTrinhCongTac.mapToResQuaTrinhCongTac(tac);
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
                                    && c.getXacNhan().equals(XacNhan.CHO_PHE_DUYET))) {
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
        public ResTheDTO<ResQuaTrinhCongTac> xemDanhSachCaNhan(int taiKhoanId, XacNhan xacNhan, String byDate, int pageNumber, int pageSize) {
            ResHoSoTomTatClient client = hoSoClient.getHoSoId(taiKhoanId);
            UUID id = client.hoSoId();
            return xemDanhSachTheoHoSoId(id, xacNhan, byDate, pageNumber, pageSize);
        }

        @Override
        public ResQuaTrinhCongTac themCaNhan(int taiKhoanId, ReqQuaTrinhCongTac cu) {
            ResHoSoTomTatClient client = hoSoClient.getHoSoId(taiKhoanId);
            UUID id = client.hoSoId();
            return them(id, cu);
        }

        @Override
        public boolean xacNhan(XacNhan xacNhan, List<ResQuaTrinhCongTac> res) {
            List<QuaTrinhCongTac> tacs = new ArrayList<>();
            for (ResQuaTrinhCongTac c : res) {
                QuaTrinhCongTac cu = quaTrinhCongTacRepository.findById(c.id()).orElseThrow(() -> new ResponseStatusException(ResEnum.KHONG_DUOC_UY_QUYEN.getStatusCode()));
                cu.setXacNhan(xacNhan);
                cu.setUpdateAt();
                tacs.add(cu);
            }
            quaTrinhCongTacRepository.saveAll(tacs);
            return true;
        }
    }

    @Service
    public class TinHocService implements IHoSoChiTietServices.IHoTinHocServiceChiTiet {
        @Override
        public ResTheDTO<ResTinHoc> xemDanhSach(XacNhan xacNhan, String byDate, int pageNumber, int pageSize) {
            Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.by(Sort.Direction.DESC, byDate));
            Page<TinHoc> page = tinHocRepository.findAll(pageable);
            List<ResTinHoc> list = page.getContent().stream().map(mapperTinHoc::mapToResTinHoc).toList();
            long totalRecord = page.getTotalElements();
            int totalPage = page.getTotalPages();
            return new ResTheDTO<>(list, totalRecord, totalPage);
        }

        @Override
        public ResTheDTO<ResTinHoc> xemDanhSachTheoHoSoId(UUID id, XacNhan xacNhan, String byDate, int pageNumber, int pageSize) {
            Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.by(Sort.Direction.DESC, byDate));
            Page<TinHoc> page = tinHocRepository.getAllByHoSo(id, xacNhan, pageable);
            List<ResTinHoc> list = page.getContent().stream().map(mapperTinHoc::mapToResTinHoc).toList();
            long totalRecord = page.getTotalElements();
            int totalPage = page.getTotalPages();
            return new ResTheDTO<>(list, totalRecord, totalPage);
        }

        @Override
        public ResTinHoc xemChiTiet(int id) {
            try {
                TinHoc hoc = tinHocRepository.findById(id).orElse(null);
                return mapperTinHoc.mapToResTinHoc(hoc);
            } catch (RuntimeException e) {
                System.err.println(e.getMessage());
                throw e;
            }
        }

        @Override
        public ResTinHoc them(UUID id, ReqTinHoc req) {
            try {
                TinHoc hoc = tinHocRepository.save(new TinHoc(req.batDau(), req.ketThuc(), req.tenCoSoDaoTaoId(), req.chungChiDuocCap(), XacNhan.CHO_PHE_DUYET, id));
                return mapperTinHoc.mapToResTinHoc(hoc);
            } catch (RuntimeException e) {
                System.err.println(e.getMessage());
                throw e;
            }
        }

        @Override
        public ResTinHoc sua(int id, ReqTinHoc req, String role) {
            return tinHocRepository.findById(id).map(c -> {
                if (role.equals("ADMIN") ||
                        (role.equals("EMPLOYEE")
                                && c.getXacNhan().equals(XacNhan.CHO_PHE_DUYET))) {
                    c.setBatDau(req.batDau());
                    c.setKetThuc(req.ketThuc());
                    c.setTenCoSoDaoTaoId(req.tenCoSoDaoTaoId());
                    c.setChungChiDuocCap(req.chungChiDuocCap());
                    c.setUpdateAt();
                    TinHoc hoc = tinHocRepository.save(c);
                    return mapperTinHoc.mapToResTinHoc(hoc);
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
                                    && c.getXacNhan().equals(XacNhan.CHO_PHE_DUYET))) {
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
        public ResTheDTO<ResTinHoc> xemDanhSachCaNhan(int taiKhoanId, XacNhan xacNhan, String byDate, int pageNumber, int pageSize) {
            ResHoSoTomTatClient client = hoSoClient.getHoSoId(taiKhoanId);
            UUID id = client.hoSoId();
            return xemDanhSachTheoHoSoId(id, xacNhan, byDate, pageNumber, pageSize);
        }

        @Override
        public ResTinHoc themCaNhan(int taiKhoanId, ReqTinHoc cu) {
            ResHoSoTomTatClient client = hoSoClient.getHoSoId(taiKhoanId);
            UUID id = client.hoSoId();
            return them(id, cu);
        }

        @Override
        public boolean xacNhan(XacNhan xacNhan, List<ResTinHoc> res) {
            List<TinHoc> tinHocs = new ArrayList<>();
            for (ResTinHoc c : res) {
                TinHoc cu = tinHocRepository.findById(c.id()).orElseThrow(() -> new ResponseStatusException(ResEnum.KHONG_DUOC_UY_QUYEN.getStatusCode()));
                cu.setXacNhan(xacNhan);
                cu.setUpdateAt();
                tinHocs.add(cu);
            }
            tinHocRepository.saveAll(tinHocs);
            return true;
        }
    }
}
