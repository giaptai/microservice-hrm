package com.hrm.hoso_chitiet.controllers;

import com.hrm.hoso_chitiet.dto.request.ReqBanThanCoLamViecChoCheDoCu;
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
import com.hrm.hoso_chitiet.dto.response.ResBanThanCoLamViecChoCheDoCu;
import com.hrm.hoso_chitiet.dto.response.ResKhenThuong;
import com.hrm.hoso_chitiet.dto.response.ResKienThucAnNinhQuocPhong;
import com.hrm.hoso_chitiet.dto.response.ResKyLuat;
import com.hrm.hoso_chitiet.dto.response.ResLamViecONuocNgoai;
import com.hrm.hoso_chitiet.dto.response.ResLuongBanThan;
import com.hrm.hoso_chitiet.dto.response.ResLyLuanChinhTri;
import com.hrm.hoso_chitiet.dto.response.ResNghiepVuChuyenNganh;
import com.hrm.hoso_chitiet.dto.response.ResNgoaiNgu;
import com.hrm.hoso_chitiet.dto.response.ResPhuCapKhac;
import com.hrm.hoso_chitiet.dto.response.ResQuaTrinhCongTac;
import com.hrm.hoso_chitiet.dto.response.ResQuanHeGiaDinh;
import com.hrm.hoso_chitiet.dto.response.ResTinHoc;
import com.hrm.hoso_chitiet.response.ResDTO;
import com.hrm.hoso_chitiet.response.ResEnum;
import com.hrm.hoso_chitiet.services.IHoSoServices;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor // create constructor if field set final or @not null
public class HoSoChiTietController {
    private final IHoSoServices.IHoBanThanCoLamViecChoCheDoCuSefvice banThanCoLamViecChoCheDoCuSefvice;
    private final IHoSoServices.IHoKhenThuongSefvice khenThuongSefvice;
    private final IHoSoServices.IHoKienThucAnNinhQuocPhongSefvice kienThucAnNinhQuocPhongSefvice;
    private final IHoSoServices.IHoKyLuatSefvice kyLuatSefvice;
    private final IHoSoServices.IHoLamViecONuocNgoaiSefvice lamViecONuocNgoaiSefvice;
    private final IHoSoServices.IHoLuongBanThanSefvice luongBanThanSefvice;
    private final IHoSoServices.IHoLyLuanChinhTriSefvice lyLuanChinhTriSefvice;
    private final IHoSoServices.IHoNghiepVuChuyenNganhSefvice nghiepVuChuyenNganhSefvice;
    private final IHoSoServices.IHoNgoaiNguSefvice ngoaiNguSefvice;
    private final IHoSoServices.IHoPhuCapKhacSefvice phuCapKhacSefvice;
    private final IHoSoServices.IHoQuanHeGiaDinhSefvice quanHeGiaDinhSefvice;
    private final IHoSoServices.IHoQuaTrinhCongTacSefvice quaTrinhCongTacSefvice;
    private final IHoSoServices.IHoTinHocSefvice tinHocSefvice;

    @RestController
    @RequestMapping(value = "")
    @Tag(name = "Làm việc cho chế đồ cũ ")
    @SecurityRequirement(name = "Bearer Authentication")
    public class BanThanCoLamViecChoCheDoCuController {
        @GetMapping("/ho-so/{id}/lam-viec-cho-che-do-cu/")
        public ResponseEntity<ResDTO<List<ResBanThanCoLamViecChoCheDoCu>>> getAll(@PathVariable UUID id) {
            List<ResBanThanCoLamViecChoCheDoCu> ls = banThanCoLamViecChoCheDoCuSefvice.xemDanhSachTheoHoSo(id).stream().map(ResBanThanCoLamViecChoCheDoCu::maptoResBanThanCoLamViecChoCheDoCu).toList();
            return ResDTO.reply(ResEnum.THANH_CONG, ls);
        }

        @GetMapping("/lam-viec-cho-che-do-cu/{id}")
        public ResponseEntity<ResDTO<ResBanThanCoLamViecChoCheDoCu>> getById(@PathVariable int id) {
            ResBanThanCoLamViecChoCheDoCu cu = ResBanThanCoLamViecChoCheDoCu.maptoResBanThanCoLamViecChoCheDoCu(banThanCoLamViecChoCheDoCuSefvice.xemChiTiet(id));
            return ResDTO.reply(ResEnum.THANH_CONG, cu);
        }

        @PostMapping("/lam-viec-cho-che-do-cu/{id}")
        @Transactional
        public ResponseEntity<ResDTO<ResBanThanCoLamViecChoCheDoCu>> add(@PathVariable UUID id, @RequestBody ReqBanThanCoLamViecChoCheDoCu cu) {
            ResBanThanCoLamViecChoCheDoCu doCu = ResBanThanCoLamViecChoCheDoCu.maptoResBanThanCoLamViecChoCheDoCu(banThanCoLamViecChoCheDoCuSefvice.them(id, cu));
            return ResDTO.reply(ResEnum.TAO_THANH_CONG, doCu);
        }

        @PatchMapping("/lam-viec-cho-che-do-cu/{id}")
        public ResponseEntity<ResDTO<ResBanThanCoLamViecChoCheDoCu>> edit(@PathVariable int id, @RequestBody ReqBanThanCoLamViecChoCheDoCu cu) {
            ResBanThanCoLamViecChoCheDoCu doCu = ResBanThanCoLamViecChoCheDoCu.maptoResBanThanCoLamViecChoCheDoCu(banThanCoLamViecChoCheDoCuSefvice.sua(id, cu));
            return ResDTO.reply(ResEnum.CAP_NHAT_THANH_CONG, doCu);
        }

        @DeleteMapping("/lam-viec-cho-che-do-cu/{id}")
        public ResponseEntity<ResDTO<Boolean>> del(@PathVariable int id) {
            return ResDTO.reply(ResEnum.XOA_THANH_CONG, banThanCoLamViecChoCheDoCuSefvice.xoa(id));
        }
    }

    @RestController
    @RequestMapping(value = "")
    @Tag(name = "Khen Thưởng ")
    @SecurityRequirement(name = "Bearer Authentication")
    public class KhenThuongController {
        @GetMapping("/ho-so/{id}/khen-thuong")
        public ResponseEntity<ResDTO<List<ResKhenThuong>>> getAll(@PathVariable UUID id) {
            List<ResKhenThuong> ls = khenThuongSefvice.xemDanhSachTheoHoSo(id).stream().map(ResKhenThuong::maptoResKhenThuong).toList();
            return ResDTO.reply(ResEnum.THANH_CONG, ls);
        }

        @GetMapping("/khen-thuong/{id}")
        public ResponseEntity<ResDTO<ResKhenThuong>> getById(@PathVariable int id) {
            ResKhenThuong cu = ResKhenThuong.maptoResKhenThuong(khenThuongSefvice.xemChiTiet(id));
            return ResDTO.reply(ResEnum.THANH_CONG, cu);
        }

        @PostMapping("/khen-thuong/{id}")
        @Transactional
        public ResponseEntity<ResDTO<ResKhenThuong>> add(@PathVariable UUID id, @RequestBody ReqKhenThuong cu) {
            ResKhenThuong doCu = ResKhenThuong.maptoResKhenThuong(khenThuongSefvice.them(id, cu));
            return ResDTO.reply(ResEnum.TAO_THANH_CONG, doCu);
        }

        @PatchMapping("/khen-thuong/{id}")
        public ResponseEntity<ResDTO<ResKhenThuong>> edit(@PathVariable int id, @RequestBody ReqKhenThuong cu) {
            ResKhenThuong doCu = ResKhenThuong.maptoResKhenThuong(khenThuongSefvice.sua(id, cu));
            return ResDTO.reply(ResEnum.CAP_NHAT_THANH_CONG, doCu);
        }

        @DeleteMapping("/khen-thuong/{id}")
        public ResponseEntity<ResDTO<Boolean>> del(@PathVariable int id) {
            return ResDTO.reply(ResEnum.XOA_THANH_CONG, khenThuongSefvice.xoa(id));
        }
    }

    @RestController
    @RequestMapping(value = "")
    @Tag(name = "Kiến thức an ninh quốc phòng ")
    @SecurityRequirement(name = "Bearer Authentication")
    public class KienThucAnNinhQuocPhongController {
        @GetMapping("/ho-so/{id}/kien-thuc-an-ninh-quoc-phong")
        public ResponseEntity<ResDTO<List<ResKienThucAnNinhQuocPhong>>> getAll(@PathVariable UUID id) {
            List<ResKienThucAnNinhQuocPhong> ls = kienThucAnNinhQuocPhongSefvice.xemDanhSachTheoHoSo(id).stream().map(ResKienThucAnNinhQuocPhong::mapToResKienThucAnNinhQuocPhong).toList();
            return ResDTO.reply(ResEnum.THANH_CONG, ls);
        }

        @GetMapping("/kien-thuc-an-ninh-quoc-phong/{id}")
        public ResponseEntity<ResDTO<ResKienThucAnNinhQuocPhong>> getById(@PathVariable int id) {
            ResKienThucAnNinhQuocPhong cu = ResKienThucAnNinhQuocPhong.mapToResKienThucAnNinhQuocPhong(kienThucAnNinhQuocPhongSefvice.xemChiTiet(id));
            return ResDTO.reply(ResEnum.THANH_CONG, cu);
        }

        @PostMapping("/kien-thuc-an-ninh-quoc-phong/{id}")
        @Transactional
        public ResponseEntity<ResDTO<ResKienThucAnNinhQuocPhong>> add(@PathVariable UUID id, @RequestBody ReqKienThucAnNinhQuocPhong cu) {
            ResKienThucAnNinhQuocPhong doCu = ResKienThucAnNinhQuocPhong.mapToResKienThucAnNinhQuocPhong(kienThucAnNinhQuocPhongSefvice.them(id, cu));
            return ResDTO.reply(ResEnum.TAO_THANH_CONG, doCu);
        }

        @PatchMapping("/kien-thuc-an-ninh-quoc-phong/{id}")
        public ResponseEntity<ResDTO<ResKienThucAnNinhQuocPhong>> edit(@PathVariable int id, @RequestBody ReqKienThucAnNinhQuocPhong cu) {
            ResKienThucAnNinhQuocPhong doCu = ResKienThucAnNinhQuocPhong.mapToResKienThucAnNinhQuocPhong(kienThucAnNinhQuocPhongSefvice.sua(id, cu));
            return ResDTO.reply(ResEnum.CAP_NHAT_THANH_CONG, doCu);
        }

        @DeleteMapping("/kien-thuc-an-ninh-quoc-phong/{id}")
        public ResponseEntity<ResDTO<Boolean>> del(@PathVariable int id) {
            return ResDTO.reply(ResEnum.XOA_THANH_CONG, kienThucAnNinhQuocPhongSefvice.xoa(id));
        }
    }

    @RestController
    @RequestMapping(value = "")
    @Tag(name = "Kỷ luật ")
    @SecurityRequirement(name = "Bearer Authentication")
    public class KyLuatController {
        @GetMapping("/ho-so/{id}/ky-luat")
        public ResponseEntity<ResDTO<List<ResKyLuat>>> getAll(@PathVariable UUID id) {
            List<ResKyLuat> ls = kyLuatSefvice.xemDanhSachTheoHoSo(id).stream().map(ResKyLuat::mapToResKyLuat).toList();
            return ResDTO.reply(ResEnum.THANH_CONG, ls);
        }

        @GetMapping("/ky-luat/{id}")
        public ResponseEntity<ResDTO<ResKyLuat>> getById(@PathVariable int id) {
            ResKyLuat cu = ResKyLuat.mapToResKyLuat(kyLuatSefvice.xemChiTiet(id));
            return ResDTO.reply(ResEnum.THANH_CONG, cu);
        }

        @PostMapping("/ky-luat/{id}")
        @Transactional
        public ResponseEntity<ResDTO<ResKyLuat>> add(@PathVariable UUID id, @RequestBody ReqKyLuat cu) {
            ResKyLuat doCu = ResKyLuat.mapToResKyLuat(kyLuatSefvice.them(id, cu));
            return ResDTO.reply(ResEnum.TAO_THANH_CONG, doCu);
        }

        @PatchMapping("/ky-luat/{id}")
        public ResponseEntity<ResDTO<ResKyLuat>> edit(@PathVariable int id, @RequestBody ReqKyLuat cu) {
            ResKyLuat doCu = ResKyLuat.mapToResKyLuat(kyLuatSefvice.sua(id, cu));
            return ResDTO.reply(ResEnum.CAP_NHAT_THANH_CONG, doCu);
        }

        @DeleteMapping("/ky-luat/{id}")
        public ResponseEntity<ResDTO<Boolean>> del(@PathVariable int id) {
            return ResDTO.reply(ResEnum.XOA_THANH_CONG, kyLuatSefvice.xoa(id));
        }
    }

    @RestController
    @RequestMapping(value = "")
    @Tag(name = "Làm việc ở nước ngoài ")
    @SecurityRequirement(name = "Bearer Authentication")
    public class LamViecONuocNgoaiController {
        @GetMapping("/ho-so/{id}/lam-viec-o-nuoc-ngoai")
        public ResponseEntity<ResDTO<List<ResLamViecONuocNgoai>>> getAll(@PathVariable UUID id) {
            List<ResLamViecONuocNgoai> ls = lamViecONuocNgoaiSefvice.xemDanhSachTheoHoSo(id).stream().map(ResLamViecONuocNgoai::mapToResLamViecONuocNgoai).toList();
            return ResDTO.reply(ResEnum.THANH_CONG, ls);
        }

        @GetMapping("/lam-viec-o-nuoc-ngoai/{id}")
        public ResponseEntity<ResDTO<ResLamViecONuocNgoai>> getById(@PathVariable int id) {
            ResLamViecONuocNgoai cu = ResLamViecONuocNgoai.mapToResLamViecONuocNgoai(lamViecONuocNgoaiSefvice.xemChiTiet(id));
            return ResDTO.reply(ResEnum.THANH_CONG, cu);
        }

        @PostMapping("/lam-viec-o-nuoc-ngoai/{id}")
        @Transactional
        public ResponseEntity<ResDTO<ResLamViecONuocNgoai>> add(@PathVariable UUID id, @RequestBody ReqLamViecONuocNgoai cu) {
            ResLamViecONuocNgoai doCu = ResLamViecONuocNgoai.mapToResLamViecONuocNgoai(lamViecONuocNgoaiSefvice.them(id, cu));
            return ResDTO.reply(ResEnum.TAO_THANH_CONG, doCu);
        }

        @PatchMapping("/lam-viec-o-nuoc-ngoai/{id}")
        public ResponseEntity<ResDTO<ResLamViecONuocNgoai>> edit(@PathVariable int id, @RequestBody ReqLamViecONuocNgoai cu) {
            ResLamViecONuocNgoai doCu = ResLamViecONuocNgoai.mapToResLamViecONuocNgoai(lamViecONuocNgoaiSefvice.sua(id, cu));
            return ResDTO.reply(ResEnum.CAP_NHAT_THANH_CONG, doCu);
        }

        @DeleteMapping("/lam-viec-o-nuoc-ngoai/{id}")
        public ResponseEntity<ResDTO<Boolean>> del(@PathVariable int id) {
            return ResDTO.reply(ResEnum.CAP_NHAT_THANH_CONG, lamViecONuocNgoaiSefvice.xoa(id));
        }
    }

    @RestController
    @RequestMapping(value = "")
    @Tag(name = "Lương bản thân ")
    @SecurityRequirement(name = "Bearer Authentication")
    public class LuongBanThanController {
        @GetMapping("/ho-so/{id}/luong-ban-than")
        public ResponseEntity<ResDTO<List<ResLuongBanThan>>> getAll(@PathVariable UUID id) {
            List<ResLuongBanThan> ls = luongBanThanSefvice.xemDanhSachTheoHoSo(id).stream().map(ResLuongBanThan::mapToResLuongBanThan).toList();
            return ResDTO.reply(ResEnum.THANH_CONG, ls);
        }

        @GetMapping("/luong-ban-than/{id}")
        public ResponseEntity<ResDTO<ResLuongBanThan>> getById(@PathVariable int id) {
            ResLuongBanThan cu = ResLuongBanThan.mapToResLuongBanThan(luongBanThanSefvice.xemChiTiet(id));
            return ResDTO.reply(ResEnum.THANH_CONG, cu);
        }

        @PostMapping("/luong-ban-than/{id}")
        @Transactional
        public ResponseEntity<ResDTO<ResLuongBanThan>> add(@PathVariable UUID id, @RequestBody ReqLuongBanThan cu) {
            ResLuongBanThan doCu = ResLuongBanThan.mapToResLuongBanThan(luongBanThanSefvice.them(id, cu));
            return ResDTO.reply(ResEnum.TAO_THANH_CONG, doCu);
        }

        @PatchMapping("/luong-ban-than/{id}")
        public ResponseEntity<ResDTO<ResLuongBanThan>> edit(@PathVariable int id, @RequestBody ReqLuongBanThan cu) {
            ResLuongBanThan doCu = ResLuongBanThan.mapToResLuongBanThan(luongBanThanSefvice.sua(id, cu));
            return ResDTO.reply(ResEnum.CAP_NHAT_THANH_CONG, doCu);
        }

        @DeleteMapping("/luong-ban-than/{id}")
        public ResponseEntity<ResDTO<Boolean>> del(@PathVariable int id) {
            return ResDTO.reply(ResEnum.XOA_THANH_CONG, luongBanThanSefvice.xoa(id));
        }
    }

    @RestController
    @RequestMapping(value = "")
    @Tag(name = "Lý luân chính trị ")
    @SecurityRequirement(name = "Bearer Authentication")
    public class LyLuanChinhTriController {
        @GetMapping("/ho-so/{id}/ly-luan-chinh-tri")
        public ResponseEntity<ResDTO<List<ResLyLuanChinhTri>>> getAll(@PathVariable UUID id) {
            List<ResLyLuanChinhTri> ls = lyLuanChinhTriSefvice.xemDanhSachTheoHoSo(id).stream().map(ResLyLuanChinhTri::mapToResLyLuanChinhTri).toList();
            return ResDTO.reply(ResEnum.THANH_CONG, ls);
        }

        @GetMapping("/ly-luan-chinh-tri/{id}")
        public ResponseEntity<ResDTO<ResLyLuanChinhTri>> getById(@PathVariable int id) {
            ResLyLuanChinhTri cu = ResLyLuanChinhTri.mapToResLyLuanChinhTri(lyLuanChinhTriSefvice.xemChiTiet(id));
            return ResDTO.reply(ResEnum.THANH_CONG, cu);
        }

        @PostMapping("/ly-luan-chinh-tri/{id}")
        @Transactional
        public ResponseEntity<ResDTO<ResLyLuanChinhTri>> add(@PathVariable UUID id, @RequestBody ReqLyLuanChinhTri cu) {
            ResLyLuanChinhTri doCu = ResLyLuanChinhTri.mapToResLyLuanChinhTri(lyLuanChinhTriSefvice.them(id, cu));
            return ResDTO.reply(ResEnum.TAO_THANH_CONG, doCu);
        }

        @PatchMapping("/ly-luan-chinh-tri/{id}")
        public ResponseEntity<ResDTO<ResLyLuanChinhTri>> edit(@PathVariable int id, @RequestBody ReqLyLuanChinhTri cu) {
            ResLyLuanChinhTri doCu = ResLyLuanChinhTri.mapToResLyLuanChinhTri(lyLuanChinhTriSefvice.sua(id, cu));
            return ResDTO.reply(ResEnum.CAP_NHAT_THANH_CONG, doCu);
        }

        @DeleteMapping("/ly-luan-chinh-tri/{id}")
        public ResponseEntity<ResDTO<Boolean>> del(@PathVariable int id) {
            return ResDTO.reply(ResEnum.XOA_THANH_CONG, lyLuanChinhTriSefvice.xoa(id));
        }
    }

    @RestController
    @RequestMapping(value = "")
    @Tag(name = "Nghiệp vụ chuyên ngành ", description = "Quản lý")
    @SecurityRequirement(name = "Bearer Authentication")
    public class NghiepVuChuyenNganhController {
        @GetMapping("/ho-so/{id}/nghiep-vu-chuyen-nganh")
        public ResponseEntity<ResDTO<List<ResNghiepVuChuyenNganh>>> getAll(@PathVariable UUID id) {
            List<ResNghiepVuChuyenNganh> ls = nghiepVuChuyenNganhSefvice.xemDanhSachTheoHoSo(id).stream().map(ResNghiepVuChuyenNganh::mapToResNghiepVuChuyenNganh).toList();
            return ResDTO.reply(ResEnum.THANH_CONG, ls);
        }

        @GetMapping("/nghiep-vu-chuyen-nganh/{id}")
        public ResponseEntity<ResDTO<ResNghiepVuChuyenNganh>> getById(@PathVariable int id) {
            ResNghiepVuChuyenNganh cu = ResNghiepVuChuyenNganh.mapToResNghiepVuChuyenNganh(nghiepVuChuyenNganhSefvice.xemChiTiet(id));
            return ResDTO.reply(ResEnum.THANH_CONG, cu);
        }

        @PostMapping("/nghiep-vu-chuyen-nganh/{id}")
        @Transactional
        public ResponseEntity<ResDTO<ResNghiepVuChuyenNganh>> add(@PathVariable UUID id, @RequestBody ReqNghiepVuChuyenNganh cu) {
            ResNghiepVuChuyenNganh doCu = ResNghiepVuChuyenNganh.mapToResNghiepVuChuyenNganh(nghiepVuChuyenNganhSefvice.them(id, cu));
            return ResDTO.reply(ResEnum.TAO_THANH_CONG, doCu);
        }

        @PatchMapping("/nghiep-vu-chuyen-nganh/{id}")
        public ResponseEntity<ResDTO<ResNghiepVuChuyenNganh>> edit(@PathVariable int id, @RequestBody ReqNghiepVuChuyenNganh cu) {
            ResNghiepVuChuyenNganh doCu = ResNghiepVuChuyenNganh.mapToResNghiepVuChuyenNganh(nghiepVuChuyenNganhSefvice.sua(id, cu));
            return ResDTO.reply(ResEnum.CAP_NHAT_THANH_CONG, doCu);
        }

        @DeleteMapping("/nghiep-vu-chuyen-nganh/{id}")
        public ResponseEntity<ResDTO<Boolean>> del(@PathVariable int id) {
            return ResDTO.reply(ResEnum.XOA_THANH_CONG, nghiepVuChuyenNganhSefvice.xoa(id));
        }
    }

    @RestController
    @RequestMapping(value = "")
    @Tag(name = "Ngoại ngữ ")
    @SecurityRequirement(name = "Bearer Authentication")
    public class NgoaiNguController {
        @GetMapping("/ho-so/{id}/ngoai-ngu")
        public ResponseEntity<ResDTO<List<ResNgoaiNgu>>> getAll(@PathVariable UUID id) {
            List<ResNgoaiNgu> ls = ngoaiNguSefvice.xemDanhSachTheoHoSo(id).stream().map(ResNgoaiNgu::mapToResNgoaiNgu).toList();
            return ResDTO.reply(ResEnum.THANH_CONG, ls);
        }

        @GetMapping("/ngoai-ngu/{id}")
        public ResponseEntity<ResDTO<ResNgoaiNgu>> getById(@PathVariable int id) {
            ResNgoaiNgu cu = ResNgoaiNgu.mapToResNgoaiNgu(ngoaiNguSefvice.xemChiTiet(id));
            return ResDTO.reply(ResEnum.THANH_CONG, cu);
        }

        @PostMapping("/ngoai-ngu/{id}")
        @Transactional
        public ResponseEntity<ResDTO<ResNgoaiNgu>> add(@PathVariable UUID id, @RequestBody ReqNgoaiNgu cu) {
            ResNgoaiNgu doCu = ResNgoaiNgu.mapToResNgoaiNgu(ngoaiNguSefvice.them(id, cu));
            return ResDTO.reply(ResEnum.TAO_THANH_CONG, doCu);
        }

        @PatchMapping("/ngoai-ngu/{id}")
        public ResponseEntity<ResDTO<ResNgoaiNgu>> edit(@PathVariable int id, @RequestBody ReqNgoaiNgu cu) {
            ResNgoaiNgu doCu = ResNgoaiNgu.mapToResNgoaiNgu(ngoaiNguSefvice.sua(id, cu));
            return ResDTO.reply(ResEnum.CAP_NHAT_THANH_CONG, doCu);
        }

        @DeleteMapping("/ngoai-ngu/{id}")
        public ResponseEntity<ResDTO<Boolean>> del(@PathVariable int id) {
            return ResDTO.reply(ResEnum.XOA_THANH_CONG, ngoaiNguSefvice.xoa(id));
        }
    }

    @RestController
    @RequestMapping(value = "")
    @Tag(name = "Phụ cấp khác ")
    @SecurityRequirement(name = "Bearer Authentication")
    public class PhuCapKhacController {
        @GetMapping("/ho-so/{id}/phu-cap-khac")
        public ResponseEntity<ResDTO<List<ResPhuCapKhac>>> getAll(@PathVariable UUID id) {
            List<ResPhuCapKhac> ls = phuCapKhacSefvice.xemDanhSachTheoHoSo(id).stream().map(ResPhuCapKhac::mapToResPhuCapKhac).toList();
            return ResDTO.reply(ResEnum.THANH_CONG, ls);
        }

        @GetMapping("/phu-cap-khac/{id}")
        public ResponseEntity<ResDTO<ResPhuCapKhac>> getById(@PathVariable int id) {
            ResPhuCapKhac cu = ResPhuCapKhac.mapToResPhuCapKhac(phuCapKhacSefvice.xemChiTiet(id));
            return ResDTO.reply(ResEnum.THANH_CONG, cu);
        }

        @PostMapping("/phu-cap-khac/{id}")
        @Transactional
        public ResponseEntity<ResDTO<ResPhuCapKhac>> add(@PathVariable UUID id, @RequestBody ReqPhuCapKhac cu) {
            ResPhuCapKhac doCu = ResPhuCapKhac.mapToResPhuCapKhac(phuCapKhacSefvice.them(id, cu));
            return ResDTO.reply(ResEnum.TAO_THANH_CONG, doCu);
        }

        @PatchMapping("/phu-cap-khac/{id}")
        public ResponseEntity<ResDTO<ResPhuCapKhac>> edit(@PathVariable int id, @RequestBody ReqPhuCapKhac cu) {
            ResPhuCapKhac doCu = ResPhuCapKhac.mapToResPhuCapKhac(phuCapKhacSefvice.sua(id, cu));
            return ResDTO.reply(ResEnum.CAP_NHAT_THANH_CONG, doCu);
        }

        @DeleteMapping("/phu-cap-khac/{id}")
        public ResponseEntity<ResDTO<Boolean>> del(@PathVariable int id) {
            return ResDTO.reply(ResEnum.XOA_THANH_CONG, phuCapKhacSefvice.xoa(id));
        }
    }

    @RestController
    @RequestMapping(value = "")
    @Tag(name = "Quan hệ gia đình ")
    @SecurityRequirement(name = "Bearer Authentication")
    public class QuanHeGiaDinhController {
        @GetMapping("/ho-so/{id}/quan-he-gia-dinh")
        public ResponseEntity<ResDTO<List<ResQuanHeGiaDinh>>> getAll(@PathVariable UUID id) {
            List<ResQuanHeGiaDinh> ls = quanHeGiaDinhSefvice.xemDanhSachTheoHoSo(id).stream().map(ResQuanHeGiaDinh::mapToResQuanHeGiaDinh).toList();
            return ResDTO.reply(ResEnum.THANH_CONG, ls);
        }

        @GetMapping("/quan-he-gia-dinh/{id}")
        public ResponseEntity<ResDTO<ResQuanHeGiaDinh>> getById(@PathVariable int id) {
            ResQuanHeGiaDinh cu = ResQuanHeGiaDinh.mapToResQuanHeGiaDinh(quanHeGiaDinhSefvice.xemChiTiet(id));
            return ResDTO.reply(ResEnum.THANH_CONG, cu);
        }

        @PostMapping("/quan-he-gia-dinh/{id}")
        @Transactional
        public ResponseEntity<ResDTO<ResQuanHeGiaDinh>> add(@PathVariable UUID id, @RequestBody ReqQuanHeGiaDinh cu) {
            ResQuanHeGiaDinh doCu = ResQuanHeGiaDinh.mapToResQuanHeGiaDinh(quanHeGiaDinhSefvice.them(id, cu));
            return ResDTO.reply(ResEnum.TAO_THANH_CONG, doCu);
        }

        @PatchMapping("/quan-he-gia-dinh/{id}")
        public ResponseEntity<ResDTO<ResQuanHeGiaDinh>> edit(@PathVariable int id, @RequestBody ReqQuanHeGiaDinh cu) {
            ResQuanHeGiaDinh doCu = ResQuanHeGiaDinh.mapToResQuanHeGiaDinh(quanHeGiaDinhSefvice.sua(id, cu));
            return ResDTO.reply(ResEnum.CAP_NHAT_THANH_CONG, doCu);
        }

        @DeleteMapping("/quan-he-gia-dinh/{id}")
        public ResponseEntity<ResDTO<Boolean>> del(@PathVariable int id) {
            return ResDTO.reply(ResEnum.XOA_THANH_CONG, quanHeGiaDinhSefvice.xoa(id));
        }
    }

    @RestController
    @RequestMapping(value = "")
    @Tag(name = "Quá trình công tác ")
    @SecurityRequirement(name = "Bearer Authentication")
    public class QuaTrinhCongTacController {
        @GetMapping("/ho-so/{id}/qua-trinh-cong-tac")
        public ResponseEntity<ResDTO<List<ResQuaTrinhCongTac>>> getAll(@PathVariable UUID id) {
            List<ResQuaTrinhCongTac> ls = quaTrinhCongTacSefvice.xemDanhSachTheoHoSo(id).stream().map(ResQuaTrinhCongTac::mapToResQuaTrinhCongTac).toList();
            return ResDTO.reply(ResEnum.THANH_CONG, ls);
        }

        @GetMapping("/qua-trinh-cong-tac/{id}")
        public ResponseEntity<ResDTO<ResQuaTrinhCongTac>> getById(@PathVariable int id) {
            ResQuaTrinhCongTac cu = ResQuaTrinhCongTac.mapToResQuaTrinhCongTac(quaTrinhCongTacSefvice.xemChiTiet(id));
            return ResDTO.reply(ResEnum.THANH_CONG, cu);
        }

        @PostMapping("/qua-trinh-cong-tac/{id}")
        @Transactional
        public ResponseEntity<ResDTO<ResQuaTrinhCongTac>> add(@PathVariable UUID id, @RequestBody ReqQuaTrinhCongTac cu) {
            ResQuaTrinhCongTac doCu = ResQuaTrinhCongTac.mapToResQuaTrinhCongTac(quaTrinhCongTacSefvice.them(id, cu));
            return ResDTO.reply(ResEnum.TAO_THANH_CONG, doCu);
        }

        @PatchMapping("/qua-trinh-cong-tac/{id}")
        public ResponseEntity<ResDTO<ResQuaTrinhCongTac>> edit(@PathVariable int id, @RequestBody ReqQuaTrinhCongTac cu) {
            ResQuaTrinhCongTac doCu = ResQuaTrinhCongTac.mapToResQuaTrinhCongTac(quaTrinhCongTacSefvice.sua(id, cu));
            return ResDTO.reply(ResEnum.CAP_NHAT_THANH_CONG, doCu);
        }

        @DeleteMapping("/qua-trinh-cong-tac/{id}")
        public ResponseEntity<ResDTO<Boolean>> del(@PathVariable int id) {
            return ResDTO.reply(ResEnum.XOA_THANH_CONG, quaTrinhCongTacSefvice.xoa(id));
        }
    }

    @RestController
    @RequestMapping(value = "")
    @Tag(name = "Tin học ")
    @SecurityRequirement(name = "Bearer Authentication")
    public class TinHocController {
        @GetMapping("/ho-so/{id}/tin-hoc")
        public ResponseEntity<ResDTO<List<ResTinHoc>>> getAll(@PathVariable UUID id) {
            List<ResTinHoc> ls = tinHocSefvice.xemDanhSachTheoHoSo(id).stream().map(ResTinHoc::mapToResTinHoc).toList();
            return ResDTO.reply(ResEnum.THANH_CONG, ls);
        }

        @GetMapping("/tin-hoc/{id}")
        public ResponseEntity<ResDTO<ResTinHoc>> getById(@PathVariable int id) {
            ResTinHoc cu = ResTinHoc.mapToResTinHoc(tinHocSefvice.xemChiTiet(id));
            return ResDTO.reply(ResEnum.THANH_CONG, cu);
        }

        @PostMapping("/tin-hoc/{id}")
        @Transactional
        public ResponseEntity<ResDTO<ResTinHoc>> add(@PathVariable UUID id, @RequestBody ReqTinHoc cu) {
            ResTinHoc doCu = ResTinHoc.mapToResTinHoc(tinHocSefvice.them(id, cu));
            return ResDTO.reply(ResEnum.TAO_THANH_CONG, doCu);
        }

        @PatchMapping("/tin-hoc/{id}")
        public ResponseEntity<ResDTO<ResTinHoc>> edit(@PathVariable int id, @RequestBody ReqTinHoc cu) {
            ResTinHoc doCu = ResTinHoc.mapToResTinHoc(tinHocSefvice.sua(id, cu));
            return ResDTO.reply(ResEnum.CAP_NHAT_THANH_CONG, doCu);
        }

        @DeleteMapping("/tin-hoc/{id}")
        public ResponseEntity<ResDTO<Boolean>> del(@PathVariable int id) {
            return ResDTO.reply(ResEnum.XOA_THANH_CONG, tinHocSefvice.xoa(id));
        }
    }
}
