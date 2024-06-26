package hrm.module.cauhinh.controllers;

import hrm.module.cauhinh.dto.mapper.MapperHeSoLuongCongChuc;
import hrm.module.cauhinh.dto.mapper.MapperHeSoLuongVienChuc;
import hrm.module.cauhinh.dto.mapper.MapperNgachCongChuc;
import hrm.module.cauhinh.dto.mapper.MapperNgachVienChuc;
import hrm.module.cauhinh.dto.mapper.MapperNhomCongChuc;
import hrm.module.cauhinh.dto.mapper.MapperNhomVienChuc;
import hrm.module.cauhinh.dto.mapper.MapperViTriViecLam;
import hrm.module.cauhinh.dto.request.ReqHeSoLuong;
import hrm.module.cauhinh.dto.request.ReqLoai;
import hrm.module.cauhinh.dto.request.ReqNgach;
import hrm.module.cauhinh.dto.request.ReqNhom;
import hrm.module.cauhinh.dto.request.ReqUtilities;

import hrm.module.cauhinh.dto.response.ResHeSoLuongCongChuc;
import hrm.module.cauhinh.dto.response.ResHeSoLuongVienChuc;
import hrm.module.cauhinh.dto.response.ResNgachCongChuc;
import hrm.module.cauhinh.dto.response.ResNgachVienChuc;
import hrm.module.cauhinh.dto.response.ResNhomCongChuc;
import hrm.module.cauhinh.dto.response.ResNhomVienChuc;
import hrm.module.cauhinh.dto.response.ResTheDTO;
import hrm.module.cauhinh.dto.response.ResViTriViecLam;
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
import hrm.module.cauhinh.models.LoaiCongChuc;
import hrm.module.cauhinh.models.LoaiPhuCap;
import hrm.module.cauhinh.models.LoaiVienChuc;
import hrm.module.cauhinh.models.MoiQuanHe;
import hrm.module.cauhinh.models.NhomMau;
import hrm.module.cauhinh.models.ThanhPhanGiaDinh;
import hrm.module.cauhinh.models.TonGiao;
import hrm.module.cauhinh.models.TrinhDoChuyenMon;
import hrm.module.cauhinh.models.TrinhDoGiaoDucPhoThong;
import hrm.module.cauhinh.models.ViTriViecLam;

import hrm.module.cauhinh.response.ResEnum;

import hrm.module.cauhinh.services.ILoaiNhomHeSoNgachService;
import hrm.module.cauhinh.services.IUtilitiesService;

import io.swagger.v3.oas.annotations.tags.Tag;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UtilitiesController {
    final IUtilitiesService<BacLuong, ReqUtilities> bacLuongService;
    final IUtilitiesService<CapBacLoaiQuanHamQuanDoi, ReqUtilities> capBacLoaiQuanHamQuanDoiService;
    final IUtilitiesService<ChucDanhDang, ReqUtilities> chucDanhDangService;
    final IUtilitiesService<ChucVu, ReqUtilities> chucVuService;
    final IUtilitiesService<CoQuanToChucDonVi, ReqUtilities> coQuanToChucDonViService;
    final IUtilitiesService<DanhHieuNhaNuoc, ReqUtilities> danhHieuNhaNuocPhongTangService;
    final IUtilitiesService<DanToc, ReqUtilities> danTocService;
    final IUtilitiesService<DoiTuongChinhSach, ReqUtilities> doiTuongChinhSachService;
    final IUtilitiesService<HinhThucKhenThuong, ReqUtilities> hinhThucKhenThuongService;
    final IUtilitiesService<HocHam, ReqUtilities> hocHamService;
    final IUtilitiesService<LoaiPhuCap, ReqUtilities> loaiPhuCapService;
    final IUtilitiesService<MoiQuanHe, ReqUtilities> moiQuanHeService;
    final IUtilitiesService<NhomMau, ReqUtilities> nhomMauService;
    final IUtilitiesService<ThanhPhanGiaDinh, ReqUtilities> thanhPhanGiaDinhService;
    final IUtilitiesService<TonGiao, ReqUtilities> tonGiaoService;
    final IUtilitiesService<TrinhDoChuyenMon, ReqUtilities> trinhDoChuyenMonService;
    final IUtilitiesService<TrinhDoGiaoDucPhoThong, ReqUtilities> trinhDoGiaoDucPhoThongService;
    final IUtilitiesService<ViTriViecLam, ReqUtilities> viTriViecLamService;
    //LOAI-NHOM-HESO-NGACH
    final ILoaiNhomHeSoNgachService.ILoaiCongChucService congChucService;
    final ILoaiNhomHeSoNgachService.ILoaiVienChucService vienChucService;
    final ILoaiNhomHeSoNgachService.INhomCongChucService nhomCongChucService;
    final ILoaiNhomHeSoNgachService.INhomVienChucService nhomVienChucService;
    final ILoaiNhomHeSoNgachService.IHeSoLuongCongChucService heSoLuongCongChucService;
    final ILoaiNhomHeSoNgachService.IHeSoLuongVienChucService heSoLuongVienChucService;
    final ILoaiNhomHeSoNgachService.INgachCongChucService ngachCongChucService;
    final ILoaiNhomHeSoNgachService.INgachVienChucService ngachVienChucService;
    //MAPPER
    final MapperHeSoLuongCongChuc mapperHeSoLuongCongChuc;
    final MapperHeSoLuongVienChuc mapperHeSoLuongVienChuc;
    final MapperNhomCongChuc mapperNhomCongChuc;
    final MapperNhomVienChuc mapperNhomVienChuc;
    final MapperNgachCongChuc mapperNgachCongChuc;
    final MapperNgachVienChuc mapperNgachVienChuc;
    final MapperViTriViecLam mapperViTriViecLam;

    @RestController
    @Tag(name = "Bậc lương ", description = "Cấu hình")
    class BacLuongController {
        @GetMapping("/bac-luong")
        public ResponseEntity<ResTheDTO<BacLuong>> getAll(
                @RequestParam(name = "page", required = false, defaultValue = "0") int pageNumber,
                @RequestParam(name = "size", required = false, defaultValue = "10") int pageSize
        ) {
            return new ResponseEntity<>(bacLuongService.xemDanhSach(pageNumber, pageSize), ResEnum.THANH_CONG.getStatusCode());
//            return ResDTO.res(bacLuongService.xemDanhSach(pageNumber, pageSize).getContent(),
//                    bacLuongService.xemDanhSach(pageNumber, pageSize).getTotalElements(),
//                    bacLuongService.xemDanhSach(pageNumber, pageSize).getTotalPages(),
//                    ResEnum.THANH_CONG);
        }

        @GetMapping("/bac-luong/{id}")
        public ResponseEntity<BacLuong> getById(@PathVariable(name = "id") int id) {
            return new ResponseEntity<>(bacLuongService.xemTheoId(id), ResEnum.THANH_CONG.getStatusCode());
        }

        @GetMapping("/bac-luong-name/{id}")
        public ResponseEntity<String> getName(@PathVariable(name = "id") int id) {
            return new ResponseEntity<>(bacLuongService.xemTheoIdTraVeName(id), ResEnum.THANH_CONG.getStatusCode());
        }

        @PostMapping("/bac-luong")
        public ResponseEntity<BacLuong> add(@RequestBody ReqUtilities utilities) {
            return new ResponseEntity<>(bacLuongService.them(utilities), ResEnum.TAO_THANH_CONG.getStatusCode());
        }

        // khong co requestbody van ok, van hieu do la request body
        @PatchMapping("/bac-luong/{id}")
        public ResponseEntity<BacLuong> edit(@PathVariable(name = "id") int id, @RequestBody ReqUtilities luong) {
            return new ResponseEntity<>(bacLuongService.sua(id, luong), ResEnum.CAP_NHAT_THANH_CONG.getStatusCode());
        }

        @DeleteMapping("/bac-luong/{id}")
        public ResponseEntity<Boolean> del(@PathVariable(name = "id") int id) {
            return new ResponseEntity<>(bacLuongService.xoa(id), ResEnum.XOA_THANH_CONG.getStatusCode());
        }
    }

    @RestController
    @Tag(name = "Loại quân hàm quân đội ", description = "Cấu hình")
    class CapBacLoaiQuanHamQuanDoiController {
        @GetMapping("/cap-bac-loai-quan-ham-quan-doi")
        public ResponseEntity<ResTheDTO<CapBacLoaiQuanHamQuanDoi>> getAll(@RequestParam(name = "page", required = false, defaultValue = "0") int pageNumber,
                                                                          @RequestParam(name = "size", required = false, defaultValue = "10") int pageSize) {
            return new ResponseEntity<>(capBacLoaiQuanHamQuanDoiService.xemDanhSach(pageNumber, pageSize), ResEnum.THANH_CONG.getStatusCode());
//            return ResDTO.res(capBacLoaiQuanHamQuanDoiService.xemDanhSach(pageNumber, pageSize).getContent(),
//                    bacLuongService.xemDanhSach(pageNumber, pageSize).getTotalElements(),
//                    bacLuongService.xemDanhSach(pageNumber, pageSize).getTotalPages(),
//                    ResEnum.THANH_CONG);
        }

        @GetMapping("/cap-bac-loai-quan-ham-quan-doi/{id}")
        public ResponseEntity<CapBacLoaiQuanHamQuanDoi> getById(@PathVariable(name = "id") int id) {
            return new ResponseEntity<>(capBacLoaiQuanHamQuanDoiService.xemTheoId(id), ResEnum.THANH_CONG.getStatusCode());
        }

        @GetMapping("/cap-bac-loai-quan-ham-quan-doi-name/{id}")
        public ResponseEntity<String> getName(@PathVariable(name = "id") int id) {
            return new ResponseEntity<>(capBacLoaiQuanHamQuanDoiService.xemTheoIdTraVeName(id), ResEnum.THANH_CONG.getStatusCode());
        }

        @PostMapping("/cap-bac-loai-quan-ham-quan-doi")
        public ResponseEntity<CapBacLoaiQuanHamQuanDoi> add(@RequestBody ReqUtilities utilities) {
            return new ResponseEntity<>(capBacLoaiQuanHamQuanDoiService.them(utilities), ResEnum.TAO_THANH_CONG.getStatusCode());
        }

        @PatchMapping("/cap-bac-loai-quan-ham-quan-doi/{id}")
        public ResponseEntity<CapBacLoaiQuanHamQuanDoi> edit(@PathVariable(name = "id") int id, @RequestBody ReqUtilities luong) {
            return new ResponseEntity<>(capBacLoaiQuanHamQuanDoiService.sua(id, luong), ResEnum.CAP_NHAT_THANH_CONG.getStatusCode());
        }

        @DeleteMapping("/cap-bac-loai-quan-ham-quan-doi/{id}")
        public ResponseEntity<Boolean> del(@PathVariable(name = "id") int id) {
            return new ResponseEntity<>(capBacLoaiQuanHamQuanDoiService.xoa(id), ResEnum.XOA_THANH_CONG.getStatusCode());
        }
    }

    @RestController
    @Tag(name = "Chức danh đảng ", description = "Cấu hình")
    class ChucDanhDangController {
        @GetMapping("/chuc-danh-dang")
        public ResponseEntity<ResTheDTO<ChucDanhDang>> getAll(@RequestParam(name = "page", required = false, defaultValue = "0") int pageNumber,
                                                              @RequestParam(name = "size", required = false, defaultValue = "10") int pageSize) {
            return new ResponseEntity<>(chucDanhDangService.xemDanhSach(pageNumber, pageSize), ResEnum.THANH_CONG.getStatusCode());
//            return ResDTO.res(chucDanhDangService.xemDanhSach(pageNumber, pageSize).getContent(),
//                    bacLuongService.xemDanhSach(pageNumber, pageSize).getTotalElements(),
//                    bacLuongService.xemDanhSach(pageNumber, pageSize).getTotalPages(),
//                    ResEnum.THANH_CONG);
        }

        @GetMapping("/chuc-danh-dang/{id}")
        public ResponseEntity<ChucDanhDang> getById(@PathVariable(name = "id") int id) {
            return new ResponseEntity<>(chucDanhDangService.xemTheoId(id), ResEnum.THANH_CONG.getStatusCode());
        }

        @GetMapping("/chuc-danh-dang-name/{id}")
        public ResponseEntity<String> getName(@PathVariable(name = "id") int id) {
            return new ResponseEntity<>(chucDanhDangService.xemTheoIdTraVeName(id), ResEnum.THANH_CONG.getStatusCode());
        }

        @PostMapping("/chuc-danh-dang")
        public ResponseEntity<ChucDanhDang> add(@RequestBody ReqUtilities utilities) {
            return new ResponseEntity<>(chucDanhDangService.them(utilities), ResEnum.TAO_THANH_CONG.getStatusCode());
        }

        @PatchMapping("/chuc-danh-dang/{id}")
        public ResponseEntity<ChucDanhDang> edit(@PathVariable(name = "id") int id, @RequestBody ReqUtilities luong) {
            return new ResponseEntity<>(chucDanhDangService.sua(id, luong), ResEnum.CAP_NHAT_THANH_CONG.getStatusCode());
        }

        @DeleteMapping("/chuc-danh-dang/{id}")
        public ResponseEntity<Boolean> del(@PathVariable(name = "id") int id) {
            return new ResponseEntity<>(chucDanhDangService.xoa(id), ResEnum.XOA_THANH_CONG.getStatusCode());
        }
    }

    @RestController
    @Tag(name = "Chức vụ ", description = "Cấu hình")
    class ChucVuController {
        @GetMapping("/chuc-vu")
        public ResponseEntity<ResTheDTO<ChucVu>> getAll(@RequestParam(name = "page", required = false, defaultValue = "0") int pageNumber,
                                                        @RequestParam(name = "size", required = false, defaultValue = "10") int pageSize) {
            return new ResponseEntity<>(chucVuService.xemDanhSach(pageNumber, pageSize), ResEnum.THANH_CONG.getStatusCode());
        }

        @GetMapping("/chuc-vu/{id}")
        public ResponseEntity<ChucVu> getById(@PathVariable(name = "id") int id) {
            return new ResponseEntity<>(chucVuService.xemTheoId(id), ResEnum.THANH_CONG.getStatusCode());
        }

        @GetMapping("/chuc-vu-name/{id}")
        public ResponseEntity<String> getName(@PathVariable(name = "id") int id) {
            return new ResponseEntity<>(chucVuService.xemTheoIdTraVeName(id), ResEnum.THANH_CONG.getStatusCode());
        }

        @PostMapping("/chuc-vu")
        public ResponseEntity<ChucVu> add(@RequestBody ReqUtilities utilities) {
            return new ResponseEntity<>(chucVuService.them(utilities), ResEnum.TAO_THANH_CONG.getStatusCode());
        }

        @PatchMapping("/chuc-vu/{id}")
        public ResponseEntity<ChucVu> edit(@PathVariable(name = "id") int id, @RequestBody ReqUtilities luong) {
            return new ResponseEntity<>(chucVuService.sua(id, luong), ResEnum.CAP_NHAT_THANH_CONG.getStatusCode());
        }

        @DeleteMapping("/chuc-vu/{id}")
        public ResponseEntity<Boolean> del(@PathVariable(name = "id") int id) {
            return new ResponseEntity<>(chucVuService.xoa(id), ResEnum.XOA_THANH_CONG.getStatusCode());
        }
    }

    @RestController
    @Tag(name = "Cơ quản tổ chức đơn vị ", description = "Cấu hình")
    class CoQuanToChucDonViController {
        @GetMapping("/coquan-tochuc-donvi")
        public ResponseEntity<ResTheDTO<CoQuanToChucDonVi>> getAll(@RequestParam(name = "page", required = false, defaultValue = "0") int pageNumber,
                                                                   @RequestParam(name = "size", required = false, defaultValue = "10") int pageSize) {
            return new ResponseEntity<>(coQuanToChucDonViService.xemDanhSach(pageNumber, pageSize), ResEnum.THANH_CONG.getStatusCode());
        }

        @GetMapping("/coquan-tochuc-donvi/{id}")
        public ResponseEntity<CoQuanToChucDonVi> getById(@PathVariable(name = "id") int id) {
            return new ResponseEntity<>(coQuanToChucDonViService.xemTheoId(id), ResEnum.THANH_CONG.getStatusCode());
        }

        @GetMapping("/coquan-tochuc-donvi-name/{id}")
        public ResponseEntity<String> getName(@PathVariable(name = "id") int id) {
            return new ResponseEntity<>(coQuanToChucDonViService.xemTheoIdTraVeName(id), ResEnum.THANH_CONG.getStatusCode());
        }

        @PostMapping("/coquan-tochuc-donvi")
        public ResponseEntity<CoQuanToChucDonVi> add(@RequestBody ReqUtilities utilities) {
            return new ResponseEntity<>(coQuanToChucDonViService.them(utilities), ResEnum.TAO_THANH_CONG.getStatusCode());
        }

        @PatchMapping("/coquan-tochuc-donvi/{id}")
        public ResponseEntity<CoQuanToChucDonVi> edit(@PathVariable(name = "id") int id, @RequestBody ReqUtilities luong) {
            return new ResponseEntity<>(coQuanToChucDonViService.sua(id, luong), ResEnum.CAP_NHAT_THANH_CONG.getStatusCode());
        }

        @DeleteMapping("/coquan-tochuc-donvi/{id}")
        public ResponseEntity<Boolean> del(@PathVariable(name = "id") int id) {
            return new ResponseEntity<>(coQuanToChucDonViService.xoa(id), ResEnum.XOA_THANH_CONG.getStatusCode());
        }
    }

    @RestController
    @Tag(name = "Danh hiệu nhà nước ", description = "Cấu hình")
    class DanhHieuNhaNuocPhongTangController {
        @GetMapping("/danh-hieu-nha-nuoc-phong")
        public ResponseEntity<ResTheDTO<DanhHieuNhaNuoc>> getAll(@RequestParam(name = "page", required = false, defaultValue = "0") int pageNumber,
                                                                 @RequestParam(name = "size", required = false, defaultValue = "10") int pageSize) {
            return new ResponseEntity<>(danhHieuNhaNuocPhongTangService.xemDanhSach(pageNumber, pageSize), ResEnum.THANH_CONG.getStatusCode());
        }

        @GetMapping("/danh-hieu-nha-nuoc-phong/{id}")
        public ResponseEntity<DanhHieuNhaNuoc> getById(@PathVariable(name = "id") int id) {
            return new ResponseEntity<>(danhHieuNhaNuocPhongTangService.xemTheoId(id), ResEnum.THANH_CONG.getStatusCode());
        }

        @GetMapping("/danh-hieu-nha-nuoc-phong-name/{id}")
        public ResponseEntity<String> getName(@PathVariable(name = "id") int id) {
            return new ResponseEntity<>(danhHieuNhaNuocPhongTangService.xemTheoIdTraVeName(id), ResEnum.THANH_CONG.getStatusCode());
        }

        @PostMapping("/danh-hieu-nha-nuoc-phong")
        public ResponseEntity<DanhHieuNhaNuoc> add(@RequestBody ReqUtilities utilities) {
            return new ResponseEntity<>(danhHieuNhaNuocPhongTangService.them(utilities), ResEnum.TAO_THANH_CONG.getStatusCode()
            );
        }

        @PatchMapping("/danh-hieu-nha-nuoc-phong/{id}")
        public ResponseEntity<DanhHieuNhaNuoc> edit(@PathVariable(name = "id") int id, @RequestBody ReqUtilities luong) {
            return new ResponseEntity<>(danhHieuNhaNuocPhongTangService.sua(id, luong), ResEnum.CAP_NHAT_THANH_CONG.getStatusCode());
        }

        @DeleteMapping("/danh-hieu-nha-nuoc-phong/{id}")
        public ResponseEntity<Boolean> del(@PathVariable(name = "id") int id) {
            return new ResponseEntity<>(danhHieuNhaNuocPhongTangService.xoa(id), ResEnum.XOA_THANH_CONG.getStatusCode());
        }
    }

    @RestController
    @Tag(name = "Dân tộc ", description = "Cấu hình")
    class DanTocController {
        @GetMapping("/dan-toc")
        public ResponseEntity<ResTheDTO<DanToc>> getAll(@RequestParam(name = "page", required = false, defaultValue = "0") int pageNumber,
                                                        @RequestParam(name = "size", required = false, defaultValue = "10") int pageSize) {
            return new ResponseEntity<>(danTocService.xemDanhSach(pageNumber, pageSize), ResEnum.THANH_CONG.getStatusCode());
        }

        @GetMapping("/dan-toc/{id}")
        public ResponseEntity<DanToc> getById(@PathVariable(name = "id") int id) {
            return new ResponseEntity<>(danTocService.xemTheoId(id), ResEnum.THANH_CONG.getStatusCode());
        }

        @GetMapping("/dan-toc-name/{id}")
        public ResponseEntity<String> getName(@PathVariable(name = "id") int id) {
            return new ResponseEntity<>(danTocService.xemTheoIdTraVeName(id), ResEnum.THANH_CONG.getStatusCode());
        }

        @PostMapping("/dan-toc")
        public ResponseEntity<DanToc> add(@RequestBody ReqUtilities utilities) {
            return new ResponseEntity<>(danTocService.them(utilities), ResEnum.TAO_THANH_CONG.getStatusCode());
        }

        @PatchMapping("/dan-toc/{id}")
        public ResponseEntity<DanToc> edit(@PathVariable(name = "id") int id, @RequestBody ReqUtilities luong) {
            return new ResponseEntity<>(danTocService.sua(id, luong), ResEnum.CAP_NHAT_THANH_CONG.getStatusCode());
        }

        @DeleteMapping("/dan-toc/{id}")
        public ResponseEntity<Boolean> del(@PathVariable(name = "id") int id) {
            return new ResponseEntity<>(danTocService.xoa(id), ResEnum.XOA_THANH_CONG.getStatusCode());
        }
    }

    @RestController
    @Tag(name = "Đối tượng chính sách ", description = "Cấu hình")
    class DoiTuongChinhSachController {
        @GetMapping("/doi-tuong-chinh-sach")
        public ResponseEntity<ResTheDTO<DoiTuongChinhSach>> getAll(@RequestParam(name = "page", required = false, defaultValue = "0") int pageNumber,
                                                                   @RequestParam(name = "size", required = false, defaultValue = "10") int pageSize) {
            return new ResponseEntity<>(doiTuongChinhSachService.xemDanhSach(pageNumber, pageSize), ResEnum.THANH_CONG.getStatusCode());
        }

        @GetMapping("/doi-tuong-chinh-sach/{id}")
        public ResponseEntity<DoiTuongChinhSach> getById(@PathVariable(name = "id") int id) {
            return new ResponseEntity<>(doiTuongChinhSachService.xemTheoId(id), ResEnum.THANH_CONG.getStatusCode());
        }

        @GetMapping("/doi-tuong-chinh-sach-name/{id}")
        public ResponseEntity<String> getName(@PathVariable(name = "id") int id) {
            return new ResponseEntity<>(doiTuongChinhSachService.xemTheoIdTraVeName(id), ResEnum.THANH_CONG.getStatusCode());
        }

        @PostMapping("/doi-tuong-chinh-sach")
        public ResponseEntity<DoiTuongChinhSach> add(@RequestBody ReqUtilities utilities) {
            return new ResponseEntity<>(doiTuongChinhSachService.them(utilities), ResEnum.TAO_THANH_CONG.getStatusCode());
        }

        @PatchMapping("/doi-tuong-chinh-sach/{id}")
        public ResponseEntity<DoiTuongChinhSach> edit(@PathVariable(name = "id") int id, @RequestBody ReqUtilities luong) {
            return new ResponseEntity<>(doiTuongChinhSachService.sua(id, luong), ResEnum.CAP_NHAT_THANH_CONG.getStatusCode());
        }

        @DeleteMapping("/doi-tuong-chinh-sach/{id}")
        public ResponseEntity<Boolean> del(@PathVariable(name = "id") int id) {
            return new ResponseEntity<>(doiTuongChinhSachService.xoa(id), ResEnum.XOA_THANH_CONG.getStatusCode());
        }
    }

    @RestController
    @Tag(name = "Hình thức khen thưởng ", description = "Cấu hình")
    class HinhThucKhenThuongController {
        @GetMapping("/hinh-thuc-khen-thuong")
        public ResponseEntity<ResTheDTO<HinhThucKhenThuong>> getAll(@RequestParam(name = "page", required = false, defaultValue = "0") int pageNumber,
                                                                    @RequestParam(name = "size", required = false, defaultValue = "10") int pageSize) {
            return new ResponseEntity<>(hinhThucKhenThuongService.xemDanhSach(pageNumber, pageSize), ResEnum.THANH_CONG.getStatusCode());
        }

        @GetMapping("/hinh-thuc-khen-thuong/{id}")
        public ResponseEntity<HinhThucKhenThuong> getById(@PathVariable(name = "id") int id) {
            return new ResponseEntity<>(hinhThucKhenThuongService.xemTheoId(id), ResEnum.THANH_CONG.getStatusCode());
        }

        @GetMapping("/hinh-thuc-khen-thuong-name/{id}")
        public ResponseEntity<String> getName(@PathVariable(name = "id") int id) {
            return new ResponseEntity<>(hinhThucKhenThuongService.xemTheoIdTraVeName(id), ResEnum.THANH_CONG.getStatusCode());
        }

        @PostMapping("/hinh-thuc-khen-thuong")
        public ResponseEntity<HinhThucKhenThuong> add(@RequestBody ReqUtilities utilities) {
            return new ResponseEntity<>(hinhThucKhenThuongService.them(utilities), ResEnum.TAO_THANH_CONG.getStatusCode());
        }

        @PatchMapping("/hinh-thuc-khen-thuong/{id}")
        public ResponseEntity<HinhThucKhenThuong> edit(@PathVariable(name = "id") int id, @RequestBody ReqUtilities luong) {
            return new ResponseEntity<>(hinhThucKhenThuongService.sua(id, luong), ResEnum.CAP_NHAT_THANH_CONG.getStatusCode());
        }

        @DeleteMapping("/hinh-thuc-khen-thuong/{id}")
        public ResponseEntity<Boolean> del(@PathVariable(name = "id") int id) {
            return new ResponseEntity<>(hinhThucKhenThuongService.xoa(id), ResEnum.XOA_THANH_CONG.getStatusCode());
        }
    }

    @RestController
    @Tag(name = "Học hàm ", description = "Cấu hình")
    class HocHamController {
        @GetMapping("/hoc-ham")
        public ResponseEntity<ResTheDTO<HocHam>> getAll(@RequestParam(name = "page", required = false, defaultValue = "0") int pageNumber,
                                                        @RequestParam(name = "size", required = false, defaultValue = "10") int pageSize) {
            return new ResponseEntity<>(hocHamService.xemDanhSach(pageNumber, pageSize), ResEnum.THANH_CONG.getStatusCode());
        }

        @GetMapping("/hoc-ham/{id}")
        public ResponseEntity<HocHam> getById(@PathVariable(name = "id") int id) {
            return new ResponseEntity<>(hocHamService.xemTheoId(id), ResEnum.THANH_CONG.getStatusCode());
        }

        @GetMapping("/hoc-ham-name/{id}")
        public ResponseEntity<String> getName(@PathVariable(name = "id") int id) {
            return new ResponseEntity<>(hocHamService.xemTheoIdTraVeName(id), ResEnum.THANH_CONG.getStatusCode());
        }

        @PostMapping("/hoc-ham")
        public ResponseEntity<HocHam> add(@RequestBody ReqUtilities utilities) {
            return new ResponseEntity<>(hocHamService.them(utilities), ResEnum.TAO_THANH_CONG.getStatusCode());
        }

        @PatchMapping("/hoc-ham/{id}")
        public ResponseEntity<HocHam> edit(@PathVariable(name = "id") int id, @RequestBody ReqUtilities luong) {
            return new ResponseEntity<>(hocHamService.sua(id, luong), ResEnum.CAP_NHAT_THANH_CONG.getStatusCode());
        }

        @DeleteMapping("/hoc-ham/{id}")
        public ResponseEntity<Boolean> del(@PathVariable(name = "id") int id) {
            return new ResponseEntity<>(hocHamService.xoa(id), ResEnum.XOA_THANH_CONG.getStatusCode());
        }
    }

    @RestController
    @Tag(name = "Loại phụ cấp ", description = "Cấu hình")
    class LoaiPhuCapController {
        @GetMapping("/loai-phu-cap")
        public ResponseEntity<ResTheDTO<LoaiPhuCap>> getAll(@RequestParam(name = "page", required = false, defaultValue = "0") int pageNumber,
                                                            @RequestParam(name = "size", required = false, defaultValue = "10") int pageSize) {
            return new ResponseEntity<>(loaiPhuCapService.xemDanhSach(pageNumber, pageSize), ResEnum.THANH_CONG.getStatusCode());
        }

        @GetMapping("/loai-phu-cap/{id}")
        public ResponseEntity<LoaiPhuCap> getById(@PathVariable(name = "id") int id) {
            return new ResponseEntity<>(loaiPhuCapService.xemTheoId(id), ResEnum.THANH_CONG.getStatusCode());
        }

        @GetMapping("/loai-phu-cap-name/{id}")
        public ResponseEntity<String> getName(@PathVariable(name = "id") int id) {
            return new ResponseEntity<>(loaiPhuCapService.xemTheoIdTraVeName(id), ResEnum.THANH_CONG.getStatusCode());
        }

        @PostMapping("/loai-phu-cap")
        public ResponseEntity<LoaiPhuCap> add(@RequestBody ReqUtilities utilities) {
            return new ResponseEntity<>(loaiPhuCapService.them(utilities), ResEnum.TAO_THANH_CONG.getStatusCode());
        }

        @PatchMapping("/loai-phu-cap/{id}")
        public ResponseEntity<LoaiPhuCap> edit(@PathVariable(name = "id") int id, @RequestBody ReqUtilities luong) {
            return new ResponseEntity<>(loaiPhuCapService.sua(id, luong), ResEnum.CAP_NHAT_THANH_CONG.getStatusCode());
        }

        @DeleteMapping("/loai-phu-cap/{id}")
        public ResponseEntity<Boolean> del(@PathVariable(name = "id") int id) {
            return new ResponseEntity<>(loaiPhuCapService.xoa(id), ResEnum.XOA_THANH_CONG.getStatusCode());
        }
    }

    @RestController
    @Tag(name = "Mối quan hệ ", description = "Cấu hình")
    class MoiQuanHeController {
        @GetMapping("/moi-quan-he")
        public ResponseEntity<ResTheDTO<MoiQuanHe>> getAll(@RequestParam(name = "page", required = false, defaultValue = "0") int pageNumber,
                                                           @RequestParam(name = "size", required = false, defaultValue = "10") int pageSize) {
            return new ResponseEntity<>(moiQuanHeService.xemDanhSach(pageNumber, pageSize), ResEnum.THANH_CONG.getStatusCode());
        }

        @GetMapping("/moi-quan-he/{id}")
        public ResponseEntity<MoiQuanHe> getById(@PathVariable(name = "id") int id) {
            return new ResponseEntity<>(moiQuanHeService.xemTheoId(id), ResEnum.THANH_CONG.getStatusCode());
        }

        @GetMapping("/moi-quan-he-name/{id}")
        public ResponseEntity<String> getName(@PathVariable(name = "id") int id) {
            return new ResponseEntity<>(moiQuanHeService.xemTheoIdTraVeName(id), ResEnum.THANH_CONG.getStatusCode());
        }

        @PostMapping("/moi-quan-he")
        public ResponseEntity<MoiQuanHe> add(@RequestBody ReqUtilities utilities) {
            return new ResponseEntity<>(moiQuanHeService.them(utilities), ResEnum.TAO_THANH_CONG.getStatusCode());
        }

        @PatchMapping("/moi-quan-he/{id}")
        public ResponseEntity<MoiQuanHe> edit(@PathVariable(name = "id") int id, @RequestBody ReqUtilities luong) {
            return new ResponseEntity<>(moiQuanHeService.sua(id, luong), ResEnum.CAP_NHAT_THANH_CONG.getStatusCode());
        }

        @DeleteMapping("/moi-quan-he/{id}")
        public ResponseEntity<Boolean> del(@PathVariable(name = "id") int id) {
            return new ResponseEntity<>(moiQuanHeService.xoa(id), ResEnum.XOA_THANH_CONG.getStatusCode());
        }
    }

    @RestController
    @Tag(name = "Nhóm máu ", description = "Cấu hình")
    class NhomMauController {
        @GetMapping("/nhom-mau")
        public ResponseEntity<ResTheDTO<NhomMau>> getAll(@RequestParam(name = "page", required = false, defaultValue = "0") int pageNumber,
                                                         @RequestParam(name = "size", required = false, defaultValue = "10") int pageSize) {
            return new ResponseEntity<>(nhomMauService.xemDanhSach(pageNumber, pageSize), ResEnum.THANH_CONG.getStatusCode());
        }

        @GetMapping("/nhom-mau/{id}")
        public ResponseEntity<NhomMau> getById(@PathVariable(name = "id") int id) {
            return new ResponseEntity<>(nhomMauService.xemTheoId(id), ResEnum.THANH_CONG.getStatusCode());
        }

        @GetMapping("/nhom-mau-name/{id}")
        public ResponseEntity<String> getName(@PathVariable(name = "id") int id) {
            return new ResponseEntity<>(nhomMauService.xemTheoIdTraVeName(id), ResEnum.THANH_CONG.getStatusCode());
        }

        @PostMapping("/nhom-mau")
        public ResponseEntity<NhomMau> add(@RequestBody ReqUtilities utilities) {
            return new ResponseEntity<>(nhomMauService.them(utilities), ResEnum.TAO_THANH_CONG.getStatusCode());
        }

        @PatchMapping("/nhom-mau/{id}")
        public ResponseEntity<NhomMau> edit(@PathVariable(name = "id") int id, @RequestBody ReqUtilities luong) {
            return new ResponseEntity<>(nhomMauService.sua(id, luong), ResEnum.CAP_NHAT_THANH_CONG.getStatusCode());
        }

        @DeleteMapping("/nhom-mau/{id}")
        public ResponseEntity<Boolean> del(@PathVariable(name = "id") int id) {
            return new ResponseEntity<>(nhomMauService.xoa(id), ResEnum.XOA_THANH_CONG.getStatusCode());
        }
    }

    @RestController
    @Tag(name = "Thành phần gia đình ", description = "Cấu hình")
    class ThanhPhanGiaDinhController {
        @GetMapping("/thanh-phan-gia-dinh")
        public ResponseEntity<ResTheDTO<ThanhPhanGiaDinh>> getAll(@RequestParam(name = "page", required = false, defaultValue = "0") int pageNumber,
                                                                  @RequestParam(name = "size", required = false, defaultValue = "10") int pageSize) {
            return new ResponseEntity<>(thanhPhanGiaDinhService.xemDanhSach(pageNumber, pageSize), ResEnum.THANH_CONG.getStatusCode());
        }

        @GetMapping("/thanh-phan-gia-dinh/{id}")
        public ResponseEntity<ThanhPhanGiaDinh> getById(@PathVariable(name = "id") int id) {
            return new ResponseEntity<>(thanhPhanGiaDinhService.xemTheoId(id), ResEnum.THANH_CONG.getStatusCode());
        }

        @GetMapping("/thanh-phan-gia-dinh-name/{id}")
        public ResponseEntity<String> getName(@PathVariable(name = "id") int id) {
            return new ResponseEntity<>(thanhPhanGiaDinhService.xemTheoIdTraVeName(id), ResEnum.THANH_CONG.getStatusCode());
        }

        @PostMapping("/thanh-phan-gia-dinh")
        public ResponseEntity<ThanhPhanGiaDinh> add(@RequestBody ReqUtilities utilities) {
            return new ResponseEntity<>(thanhPhanGiaDinhService.them(utilities), ResEnum.TAO_THANH_CONG.getStatusCode());
        }

        @PatchMapping("/thanh-phan-gia-dinh/{id}")
        public ResponseEntity<ThanhPhanGiaDinh> edit(@PathVariable(name = "id") int id, @RequestBody ReqUtilities luong) {
            return new ResponseEntity<>(thanhPhanGiaDinhService.sua(id, luong), ResEnum.CAP_NHAT_THANH_CONG.getStatusCode());
        }

        @DeleteMapping("/thanh-phan-gia-dinh/{id}")
        public ResponseEntity<Boolean> del(@PathVariable(name = "id") int id) {
            return new ResponseEntity<>(thanhPhanGiaDinhService.xoa(id), ResEnum.XOA_THANH_CONG.getStatusCode());
        }
    }

    @RestController
    @Tag(name = "Tôn giáo ", description = "Cấu hình")
    class TonGiaoController {
        @GetMapping("/ton-giao")
        public ResponseEntity<ResTheDTO<TonGiao>> getAll(@RequestParam(name = "page", required = false, defaultValue = "0") int pageNumber,
                                                         @RequestParam(name = "size", required = false, defaultValue = "10") int pageSize) {
            return new ResponseEntity<>(tonGiaoService.xemDanhSach(pageNumber, pageSize), ResEnum.THANH_CONG.getStatusCode());
        }

        @GetMapping("/ton-giao/{id}")
        public ResponseEntity<TonGiao> getById(@PathVariable(name = "id") int id) {
            return new ResponseEntity<>(tonGiaoService.xemTheoId(id), ResEnum.THANH_CONG.getStatusCode());
        }

        @GetMapping("/ton-giao-name/{id}")
        public ResponseEntity<String> getName(@PathVariable(name = "id") int id) {
            return new ResponseEntity<>(tonGiaoService.xemTheoIdTraVeName(id), ResEnum.THANH_CONG.getStatusCode());
        }

        @PostMapping("/ton-giao")
        public ResponseEntity<TonGiao> add(@RequestBody ReqUtilities utilities) {
            return new ResponseEntity<>(tonGiaoService.them(utilities), ResEnum.TAO_THANH_CONG.getStatusCode());
        }

        @PatchMapping("/ton-giao/{id}")
        public ResponseEntity<TonGiao> edit(@PathVariable(name = "id") int id, @RequestBody ReqUtilities luong) {
            return new ResponseEntity<>(tonGiaoService.sua(id, luong), ResEnum.CAP_NHAT_THANH_CONG.getStatusCode());
        }

        @DeleteMapping("/ton-giao/{id}")
        public ResponseEntity<Boolean> del(@PathVariable(name = "id") int id) {
            return new ResponseEntity<>(tonGiaoService.xoa(id), ResEnum.XOA_THANH_CONG.getStatusCode());
        }
    }

    @RestController
    @Tag(name = "Trình độ chuyên môn ", description = "Cấu hình")
    class TrinhDoChuyenMonController {
        @GetMapping("/trinh-do-chuyen-mon")
        public ResponseEntity<ResTheDTO<TrinhDoChuyenMon>> getAll(@RequestParam(name = "page", required = false, defaultValue = "0") int pageNumber,
                                                                  @RequestParam(name = "size", required = false, defaultValue = "10") int pageSize) {
            return new ResponseEntity<>(trinhDoChuyenMonService.xemDanhSach(pageNumber, pageSize), ResEnum.THANH_CONG.getStatusCode());
        }

        @GetMapping("/trinh-do-chuyen-mon/{id}")
        public ResponseEntity<TrinhDoChuyenMon> getById(@PathVariable(name = "id") int id) {
            return new ResponseEntity<>(trinhDoChuyenMonService.xemTheoId(id), ResEnum.THANH_CONG.getStatusCode());
        }

        @GetMapping("/trinh-do-chuyen-mon-name/{id}")
        public ResponseEntity<String> getName(@PathVariable(name = "id") int id) {
            return new ResponseEntity<>(trinhDoChuyenMonService.xemTheoIdTraVeName(id), ResEnum.THANH_CONG.getStatusCode());
        }

        @PostMapping("/trinh-do-chuyen-mon")
        public ResponseEntity<TrinhDoChuyenMon> add(@RequestBody ReqUtilities utilities) {
            return new ResponseEntity<>(trinhDoChuyenMonService.them(utilities), ResEnum.TAO_THANH_CONG.getStatusCode());
        }

        @PatchMapping("/trinh-do-chuyen-mon/{id}")
        public ResponseEntity<TrinhDoChuyenMon> edit(@PathVariable(name = "id") int id, @RequestBody ReqUtilities luong) {
            return new ResponseEntity<>(trinhDoChuyenMonService.sua(id, luong), ResEnum.CAP_NHAT_THANH_CONG.getStatusCode());
        }

        @DeleteMapping("/trinh-do-chuyen-mon/{id}")
        public ResponseEntity<Boolean> del(@PathVariable(name = "id") int id) {
            return new ResponseEntity<>(trinhDoChuyenMonService.xoa(id), ResEnum.XOA_THANH_CONG.getStatusCode());
        }
    }

    @RestController
    @Tag(name = "Trình độ giáo dục phổ thông ", description = "Cấu hình")
    class TrinhDoGiaoDucPhoThongController {
        @GetMapping("/trinh-do-giao-duc-pho-thong")
        public ResponseEntity<ResTheDTO<TrinhDoGiaoDucPhoThong>> getAll(@RequestParam(name = "page", required = false, defaultValue = "0") int pageNumber,
                                                                        @RequestParam(name = "size", required = false, defaultValue = "10") int pageSize) {
            return new ResponseEntity<>(trinhDoGiaoDucPhoThongService.xemDanhSach(pageNumber, pageSize), ResEnum.THANH_CONG.getStatusCode());
        }

        @GetMapping("/trinh-do-giao-duc-pho-thong/{id}")
        public ResponseEntity<TrinhDoGiaoDucPhoThong> getById(@PathVariable(name = "id") int id) {
            return new ResponseEntity<>(trinhDoGiaoDucPhoThongService.xemTheoId(id), ResEnum.THANH_CONG.getStatusCode());
        }

        @GetMapping("/trinh-do-giao-duc-pho-thong-name/{id}")
        public ResponseEntity<String> getName(@PathVariable(name = "id") int id) {
            return new ResponseEntity<>(trinhDoGiaoDucPhoThongService.xemTheoIdTraVeName(id), ResEnum.THANH_CONG.getStatusCode());
        }

        @PostMapping("/trinh-do-giao-duc-pho-thong")
        public ResponseEntity<TrinhDoGiaoDucPhoThong> add(@RequestBody ReqUtilities utilities) {
            return new ResponseEntity<>(trinhDoGiaoDucPhoThongService.them(utilities), ResEnum.TAO_THANH_CONG.getStatusCode());
        }

        @PatchMapping("/trinh-do-giao-duc-pho-thong/{id}")
        public ResponseEntity<TrinhDoGiaoDucPhoThong> edit(@PathVariable(name = "id") int id, @RequestBody ReqUtilities luong) {
            return new ResponseEntity<>(trinhDoGiaoDucPhoThongService.sua(id, luong), ResEnum.CAP_NHAT_THANH_CONG.getStatusCode());
        }

        @DeleteMapping("/trinh-do-giao-duc-pho-thong/{id}")
        public ResponseEntity<Boolean> del(@PathVariable(name = "id") int id) {
            return new ResponseEntity<>(trinhDoGiaoDucPhoThongService.xoa(id), ResEnum.XOA_THANH_CONG.getStatusCode());
        }
    }

    @RestController
    @Tag(name = "Vị trí việc làm ", description = "Cấu hình")
    class ViTriViecLamController {
        @GetMapping("/vi-tri-viec-lam")
        public ResponseEntity<ResTheDTO<ResViTriViecLam>> getAll(@RequestParam(name = "page", required = false, defaultValue = "0") int pageNumber,
                                                                 @RequestParam(name = "size", required = false, defaultValue = "10") int pageSize) {
//            List<ResViTriViecLam> resViTriViecLams = viTriViecLamService.xemDanhSach(pageNumber, pageSize).data().stream().map(mapperViTriViecLam::mapToResViTriViecLam).toList();
//            long totalRecord = viTriViecLamService.xemDanhSach(pageNumber, pageSize).totalRecord();
//            int totalPage = viTriViecLamService.xemDanhSach(pageNumber, pageSize).totalPage();
//            ResTheDTO<ResViTriViecLam> dto = new ResTheDTO<>(resViTriViecLams, totalRecord, totalPage);
//            return new ResponseEntity<>(dto, ResEnum.THANH_CONG.getStatusCode());
            return new ResponseEntity<>(viTriViecLamService.xemDsViTriViecLam(pageNumber, pageSize), ResEnum.THANH_CONG.getStatusCode());
        }

        @GetMapping("/vi-tri-viec-lam/{id}")
        public ResponseEntity<ResViTriViecLam> getById(@PathVariable(name = "id") int id) {
            ResViTriViecLam resViTriViecLam = mapperViTriViecLam.mapToResViTriViecLam(viTriViecLamService.xemTheoId(id));
            return new ResponseEntity<>(resViTriViecLam, ResEnum.THANH_CONG.getStatusCode());
        }

        @PostMapping("/vi-tri-viec-lam")
        public ResponseEntity<ResViTriViecLam> add(@RequestBody ReqUtilities utilities) {
            ResViTriViecLam resViTriViecLam = mapperViTriViecLam.mapToResViTriViecLam(viTriViecLamService.them(utilities));
            return new ResponseEntity<>(resViTriViecLam, ResEnum.TAO_THANH_CONG.getStatusCode());
        }

        @PatchMapping("/vi-tri-viec-lam/{id}")
        public ResponseEntity<ResViTriViecLam> edit(@PathVariable(name = "id") int id, @RequestBody ReqUtilities req) {
            ResViTriViecLam resViTriViecLam = mapperViTriViecLam.mapToResViTriViecLam(viTriViecLamService.sua(id, req));
            return new ResponseEntity<>(resViTriViecLam, ResEnum.CAP_NHAT_THANH_CONG.getStatusCode());
        }

        @DeleteMapping("/vi-tri-viec-lam/{id}")
        public ResponseEntity<Boolean> del(@PathVariable(name = "id") int id) {
            return new ResponseEntity<>(viTriViecLamService.xoa(id), ResEnum.XOA_THANH_CONG.getStatusCode());
        }
    }

    @RestController
    @Tag(name = "Loại công chức ", description = "Cấu hình")
    class LoaiCongChucController {
        @GetMapping("/loai-cong-chuc")
        public ResponseEntity<ResTheDTO<LoaiCongChuc>> getAll(@RequestParam(name = "page", required = false, defaultValue = "0") int pageNumber,
                                                              @RequestParam(name = "size", required = false, defaultValue = "10") int pageSize) {
            return new ResponseEntity<>(congChucService.xemDanhSach(pageNumber, pageSize), ResEnum.THANH_CONG.getStatusCode());
        }

        @GetMapping("/loai-cong-chuc/{id}")
        public ResponseEntity<LoaiCongChuc> getById(@PathVariable(name = "id") int id) {
            return new ResponseEntity<>(congChucService.xemTheoId(id), ResEnum.THANH_CONG.getStatusCode());
        }

        @PostMapping("/loai-cong-chuc")
        public ResponseEntity<LoaiCongChuc> add(@RequestBody ReqLoai loai) {
            return new ResponseEntity<>(congChucService.themLoaiCongChuc(loai), ResEnum.TAO_THANH_CONG.getStatusCode());
        }

        @PatchMapping("/loai-cong-chuc/{id}")
        public ResponseEntity<LoaiCongChuc> edit(@PathVariable(name = "id") int id, @RequestBody ReqLoai loai) {
            return new ResponseEntity<>(congChucService.suaLoaiCongChuc(id, loai), ResEnum.CAP_NHAT_THANH_CONG.getStatusCode());
        }

        @DeleteMapping("/loai-cong-chuc/{id}")
        public ResponseEntity<Boolean> del(@PathVariable(name = "id") int id) {
            return new ResponseEntity<>(congChucService.xoaLoaiCongChuc(id), ResEnum.XOA_THANH_CONG.getStatusCode());
        }
    }

    @RestController
    @Tag(name = "Loại viên chức ", description = "Cấu hình")
    class LoaiVienChucController {
        @GetMapping("/loai-vien-chuc")
        public ResponseEntity<ResTheDTO<LoaiVienChuc>> getAll(@RequestParam(name = "page", required = false, defaultValue = "0") int pageNumber,
                                                              @RequestParam(name = "size", required = false, defaultValue = "10") int pageSize) {
            return new ResponseEntity<>(vienChucService.xemDanhSach(pageNumber, pageSize), ResEnum.THANH_CONG.getStatusCode());
        }

        @GetMapping("/loai-vien-chuc/{id}")
        public ResponseEntity<LoaiVienChuc> getById(@PathVariable(name = "id") int id) {
            return new ResponseEntity<>(vienChucService.xemTheoId(id), ResEnum.THANH_CONG.getStatusCode());
        }

        @PostMapping("/loai-vien-chuc")
        public ResponseEntity<LoaiVienChuc> add(@RequestBody ReqLoai loai) {
            return new ResponseEntity<>(vienChucService.themLoaiVienChuc(loai), ResEnum.TAO_THANH_CONG.getStatusCode());
        }

        @PatchMapping("/loai-vien-chuc/{id}")
        public ResponseEntity<LoaiVienChuc> edit(@PathVariable(name = "id") int id, @RequestBody ReqLoai loai) {
            return new ResponseEntity<>(vienChucService.suaLoaiVienChuc(id, loai), ResEnum.CAP_NHAT_THANH_CONG.getStatusCode());
        }

        @DeleteMapping("/loai-vien-chuc/{id}")
        public ResponseEntity<Boolean> del(@PathVariable(name = "id") int id) {
            return new ResponseEntity<>(vienChucService.xoaLoaiVienChuc(id), ResEnum.XOA_THANH_CONG.getStatusCode());
        }
    }

    @RestController
    @Tag(name = "Nhóm công chức ", description = "Cấu hình")
    class NhomCongChucController {
        @GetMapping("/nhom-cong-chuc")
        public ResponseEntity<ResTheDTO<ResNhomCongChuc>> getAll(@RequestParam(name = "page", required = false, defaultValue = "0") int pageNumber,
                                                                 @RequestParam(name = "size", required = false, defaultValue = "10") int pageSize) {
            ResTheDTO<ResNhomCongChuc> nhomCongChucs = nhomCongChucService.xemDanhSach(pageNumber, pageSize);
            return new ResponseEntity<>(nhomCongChucs, ResEnum.THANH_CONG.getStatusCode());
        }

        @GetMapping("/nhom-cong-chuc/{id}")
        public ResponseEntity<ResNhomCongChuc> getById(@PathVariable(name = "id") int id) {
            ResNhomCongChuc resNhomCongChuc = mapperNhomCongChuc.mapToResNhomCongChuc(nhomCongChucService.xemTheoId(id));
            return new ResponseEntity<>(resNhomCongChuc, ResEnum.THANH_CONG.getStatusCode());
        }

        @PostMapping("/nhom-cong-chuc")
        public ResponseEntity<ResNhomCongChuc> add(@RequestBody ReqNhom loai) {
            ResNhomCongChuc resNhomCongChuc = mapperNhomCongChuc.mapToResNhomCongChuc(nhomCongChucService.themNhomCongChuc(loai));
            return new ResponseEntity<>(resNhomCongChuc, ResEnum.TAO_THANH_CONG.getStatusCode());
        }

        @PatchMapping("/nhom-cong-chuc/{id}")
        public ResponseEntity<ResNhomCongChuc> edit(@PathVariable(name = "id") int id, @RequestBody ReqNhom loai) {
            ResNhomCongChuc resNhomCongChuc = mapperNhomCongChuc.mapToResNhomCongChuc(nhomCongChucService.suaNhomCongChuc(id, loai));
            return new ResponseEntity<>(resNhomCongChuc, ResEnum.CAP_NHAT_THANH_CONG.getStatusCode());
        }

        @DeleteMapping("/nhom-cong-chuc/{id}")
        public ResponseEntity<Boolean> del(@PathVariable(name = "id") int id) {
            return new ResponseEntity<>(nhomCongChucService.xoaNhomCongChuc(id), ResEnum.XOA_THANH_CONG.getStatusCode());
        }
    }

    @RestController
    @Tag(name = "Nhóm viên chức ", description = "Cấu hình")
    class NhomVienChucController {
        @GetMapping("/nhom-vien-chuc")
        public ResponseEntity<ResTheDTO<ResNhomVienChuc>> getAll(@RequestParam(name = "page", required = false, defaultValue = "0") int pageNumber,
                                                                 @RequestParam(name = "size", required = false, defaultValue = "10") int pageSize) {
            ResTheDTO<ResNhomVienChuc> resNhomVienChucs = nhomVienChucService.xemDanhSach(pageNumber, pageSize);
            return new ResponseEntity<>(resNhomVienChucs, ResEnum.THANH_CONG.getStatusCode());
        }

        @GetMapping("/nhom-vien-chuc/{id}")
        public ResponseEntity<ResNhomVienChuc> getById(@PathVariable(name = "id") int id) {
            ResNhomVienChuc resNhomVienChuc = mapperNhomVienChuc.mapToResNhomVienChuc(nhomVienChucService.xemTheoId(id));
            return new ResponseEntity<>(resNhomVienChuc, ResEnum.THANH_CONG.getStatusCode());
        }

        @PostMapping("/nhom-vien-chuc")
        public ResponseEntity<ResNhomVienChuc> add(@RequestBody ReqNhom loai) {
            ResNhomVienChuc resNhomVienChuc = mapperNhomVienChuc.mapToResNhomVienChuc(nhomVienChucService.themNhomVienChuc(loai));
            return new ResponseEntity<>(resNhomVienChuc, ResEnum.TAO_THANH_CONG.getStatusCode());
        }

        @PatchMapping("/nhom-vien-chuc/{id}")
        public ResponseEntity<ResNhomVienChuc> edit(@PathVariable(name = "id") int id, @RequestBody ReqNhom loai) {
            ResNhomVienChuc resNhomVienChuc = mapperNhomVienChuc.mapToResNhomVienChuc(nhomVienChucService.suaNhomVienChuc(id, loai));
            return new ResponseEntity<>(resNhomVienChuc, ResEnum.CAP_NHAT_THANH_CONG.getStatusCode());
        }

        @DeleteMapping("/nhom-vien-chuc/{id}")
        public ResponseEntity<Boolean> del(@PathVariable(name = "id") int id) {
            return new ResponseEntity<>(nhomVienChucService.xoaNhomVienChuc(id), ResEnum.XOA_THANH_CONG.getStatusCode());
        }
    }

    @RestController
    @Tag(name = "Hệ số lương công chức ", description = "Cấu hình")
    class HeSoLuongCongChucController {
        @GetMapping("/he-so-luong-cong-chuc")
        public ResponseEntity<ResTheDTO<ResHeSoLuongCongChuc>> getAll(@RequestParam(name = "page", required = false, defaultValue = "0") int pageNumber,
                                                                      @RequestParam(name = "size", required = false, defaultValue = "10") int pageSize) {
            ResTheDTO<ResHeSoLuongCongChuc> res = heSoLuongCongChucService.xemDanhSach(pageNumber, pageSize);
            return new ResponseEntity<>(res, ResEnum.THANH_CONG.getStatusCode());
        }

        @GetMapping("/he-so-luong-cong-chuc/{id}")
        public ResponseEntity<ResHeSoLuongCongChuc> getById(@PathVariable(name = "id") int id) {
            ResHeSoLuongCongChuc res = mapperHeSoLuongCongChuc.mapToResHeSoLuongCongChuc(heSoLuongCongChucService.xemTheoId(id));
            return new ResponseEntity<>(res, ResEnum.THANH_CONG.getStatusCode());
        }

        @PostMapping("/he-so-luong-cong-chuc")
        public ResponseEntity<ResHeSoLuongCongChuc> add(@RequestBody ReqHeSoLuong loai) {
            ResHeSoLuongCongChuc res = mapperHeSoLuongCongChuc.mapToResHeSoLuongCongChuc(heSoLuongCongChucService.themHeSoLuongCongChuc(loai));
            return new ResponseEntity<>(res, ResEnum.TAO_THANH_CONG.getStatusCode());
        }

        @PatchMapping("/he-so-luong-cong-chuc/{id}")
        public ResponseEntity<ResHeSoLuongCongChuc> edit(@PathVariable(name = "id") int id, @RequestBody ReqHeSoLuong loai) {
            ResHeSoLuongCongChuc res = mapperHeSoLuongCongChuc.mapToResHeSoLuongCongChuc(heSoLuongCongChucService.suaHeSoLuongCongChuc(id, loai));
            return new ResponseEntity<>(res, ResEnum.CAP_NHAT_THANH_CONG.getStatusCode());
        }

        @DeleteMapping("/he-so-luong-cong-chuc/{id}")
        public ResponseEntity<Boolean> del(@PathVariable(name = "id") int id) {
            return new ResponseEntity<>(heSoLuongCongChucService.xoaHeSoLuongCongChuc(id), ResEnum.XOA_THANH_CONG.getStatusCode());
        }
    }

    @RestController
    @Tag(name = "Hệ số lương viên chức ", description = "Cấu hình")
    class HeSoLuongVienChucController {
        @GetMapping("/he-so-luong-vien-chuc")
        public ResponseEntity<ResTheDTO<ResHeSoLuongVienChuc>> getAll(@RequestParam(name = "page", required = false, defaultValue = "0") int pageNumber,
                                                                      @RequestParam(name = "size", required = false, defaultValue = "10") int pageSize) {
            ResTheDTO<ResHeSoLuongVienChuc> res = heSoLuongVienChucService.xemDanhSach(pageNumber, pageSize);
            return new ResponseEntity<>(res, ResEnum.THANH_CONG.getStatusCode());
        }

        @GetMapping("/he-so-luong-vien-chuc/{id}")
        public ResponseEntity<ResHeSoLuongVienChuc> getById(@PathVariable(name = "id") int id) {
            ResHeSoLuongVienChuc res = mapperHeSoLuongVienChuc.mapToResHeSoLuongVienChuc(heSoLuongVienChucService.xemTheoId(id));
            return new ResponseEntity<>(res, ResEnum.THANH_CONG.getStatusCode());
        }

        @PostMapping("/he-so-luong-vien-chuc")
        public ResponseEntity<ResHeSoLuongVienChuc> add(@RequestBody ReqHeSoLuong loai) {
            ResHeSoLuongVienChuc res = mapperHeSoLuongVienChuc.mapToResHeSoLuongVienChuc(heSoLuongVienChucService.themHeSoLuongVienChuc(loai));
            return new ResponseEntity<>(res, ResEnum.TAO_THANH_CONG.getStatusCode());
        }

        @PatchMapping("/he-so-luong-vien-chuc/{id}")
        public ResponseEntity<ResHeSoLuongVienChuc> edit(@PathVariable(name = "id") int id, @RequestBody ReqHeSoLuong loai) {
            ResHeSoLuongVienChuc res = mapperHeSoLuongVienChuc.mapToResHeSoLuongVienChuc(heSoLuongVienChucService.suaHeSoLuongVienChuc(id, loai));
            return new ResponseEntity<>(res, ResEnum.CAP_NHAT_THANH_CONG.getStatusCode());
        }

        @DeleteMapping("/he-so-luong-vien-chuc/{id}")
        public ResponseEntity<Boolean> del(@PathVariable(name = "id") int id) {
            return new ResponseEntity<>(heSoLuongVienChucService.xoaHeSoLuongVienChuc(id), ResEnum.XOA_THANH_CONG.getStatusCode());
        }
    }

    @RestController
    @Tag(name = "Ngạch công chức ", description = "Cấu hình")
    class NgachCongChucController {
        @GetMapping("/ngach-cong-chuc")
        public ResponseEntity<ResTheDTO<ResNgachCongChuc>> getAll(@RequestParam(name = "page", required = false, defaultValue = "0") int pageNumber,
                                                                  @RequestParam(name = "size", required = false, defaultValue = "10") int pageSize) {
            ResTheDTO<ResNgachCongChuc> res = ngachCongChucService.xemDanhSach(pageNumber, pageSize);
            return new ResponseEntity<>(res, ResEnum.THANH_CONG.getStatusCode());
        }

        @GetMapping("/ngach-cong-chuc/{id}")
        public ResponseEntity<ResNgachCongChuc> getById(@PathVariable(name = "id") String id) {
            ResNgachCongChuc res = mapperNgachCongChuc.mapToResNgachCongChuc(ngachCongChucService.xemTheoId(id));
            return new ResponseEntity<>(res, ResEnum.THANH_CONG.getStatusCode());
        }

        @PostMapping("/ngach-cong-chuc")
        public ResponseEntity<ResNgachCongChuc> add(@RequestBody ReqNgach loai) {
            ResNgachCongChuc res = mapperNgachCongChuc.mapToResNgachCongChuc(ngachCongChucService.themNgachCongChuc(loai));
            return new ResponseEntity<>(res, ResEnum.TAO_THANH_CONG.getStatusCode());
        }

        @PatchMapping("/ngach-cong-chuc/{id}")
        public ResponseEntity<ResNgachCongChuc> edit(@PathVariable(name = "id") String id, @RequestBody ReqNgach loai) {
            ResNgachCongChuc res = mapperNgachCongChuc.mapToResNgachCongChuc(ngachCongChucService.suaNgachCongChuc(id, loai));
            return new ResponseEntity<>(res, ResEnum.CAP_NHAT_THANH_CONG.getStatusCode());
        }

        @DeleteMapping("/ngach-cong-chuc/{id}")
        public ResponseEntity<Boolean> del(@PathVariable(name = "id") String id) {
            return new ResponseEntity<>(ngachCongChucService.xoaNgachCongChuc(id), ResEnum.XOA_THANH_CONG.getStatusCode());
        }
    }

    @RestController
    @Tag(name = "Ngạch viên chức ", description = "Cấu hình")
    class NgachVienChucController {
        @GetMapping("/ngach-vien-chuc")
        public ResponseEntity<ResTheDTO<ResNgachVienChuc>> getAll(@RequestParam(name = "page", required = false, defaultValue = "0") int pageNumber,
                                                                  @RequestParam(name = "size", required = false, defaultValue = "10") int pageSize) {
            ResTheDTO<ResNgachVienChuc> res = ngachVienChucService.xemDanhSach(pageNumber, pageSize);
            return new ResponseEntity<>(res, ResEnum.THANH_CONG.getStatusCode());
        }

        @GetMapping("/ngach-vien-chuc/{id}")
        public ResponseEntity<ResNgachVienChuc> getById(@PathVariable(name = "id") String id) {
            ResNgachVienChuc res = mapperNgachVienChuc.mapToResNgachVienChuc(ngachVienChucService.xemTheoId(id));
            return new ResponseEntity<>(res, ResEnum.THANH_CONG.getStatusCode());
        }

        @PostMapping("/ngach-vien-chuc")
        public ResponseEntity<ResNgachVienChuc> add(@RequestBody ReqNgach loai) {
            ResNgachVienChuc res = mapperNgachVienChuc.mapToResNgachVienChuc(ngachVienChucService.themNgachVienChuc(loai));
            return new ResponseEntity<>(res, ResEnum.TAO_THANH_CONG.getStatusCode());
        }

        @PatchMapping("/ngach-vien-chuc/{id}")
        public ResponseEntity<ResNgachVienChuc> edit(@PathVariable(name = "id") String id, @RequestBody ReqNgach loai) {
            ResNgachVienChuc res = mapperNgachVienChuc.mapToResNgachVienChuc(ngachVienChucService.suaNgachVienChuc(id, loai));
            return new ResponseEntity<>(res, ResEnum.CAP_NHAT_THANH_CONG.getStatusCode());
        }

        @DeleteMapping("/ngach-vien-chuc/{id}")
        public ResponseEntity<Boolean> del(@PathVariable(name = "id") String id) {
            return new ResponseEntity<>(ngachVienChucService.xoaNgachVienChuc(id), ResEnum.XOA_THANH_CONG.getStatusCode());
        }
    }
}
