package com.hrm.hoso_chitiet.services;


import com.hrm.hoso_chitiet.dto.request.ReqBanThanCoLamViecChoCheDoCu;
import com.hrm.hoso_chitiet.dto.request.ReqKhenThuong;
import com.hrm.hoso_chitiet.dto.request.ReqKhenThuongNhanVien;
import com.hrm.hoso_chitiet.dto.request.ReqKienThucAnNinhQuocPhong;
import com.hrm.hoso_chitiet.dto.request.ReqKyLuat;
import com.hrm.hoso_chitiet.dto.request.ReqKyLuatNhanVien;
import com.hrm.hoso_chitiet.dto.request.ReqLamViecONuocNgoai;
import com.hrm.hoso_chitiet.dto.request.ReqLamViecONuocNgoaiNhanVien;
import com.hrm.hoso_chitiet.dto.request.ReqLuongBanThan;
import com.hrm.hoso_chitiet.dto.request.ReqLyLuanChinhTri;
import com.hrm.hoso_chitiet.dto.request.ReqLyLuanChinhTriNhanVien;
import com.hrm.hoso_chitiet.dto.request.ReqNghiepVuChuyenNganh;
import com.hrm.hoso_chitiet.dto.request.ReqNghiepVuChuyenNganhNhanVien;
import com.hrm.hoso_chitiet.dto.request.ReqNgoaiNgu;
import com.hrm.hoso_chitiet.dto.request.ReqNgoaiNguNhanVien;
import com.hrm.hoso_chitiet.dto.request.ReqPhuCapKhac;
import com.hrm.hoso_chitiet.dto.request.ReqQuaTrinhCongTac;
import com.hrm.hoso_chitiet.dto.request.ReqQuaTrinhCongTacNhanVien;
import com.hrm.hoso_chitiet.dto.request.ReqQuanHeGiaDinh;
import com.hrm.hoso_chitiet.dto.request.ReqTinHoc;
import com.hrm.hoso_chitiet.models.BanThanCoLamViecChoCheDoCu;
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

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public interface IHoSoServices<T, H> {
    default List<T> xemDanhSach() {
        return new ArrayList<>();
    }

    List<T> xemDanhSachTheoHoSo(UUID id);

    T xemChiTiet(int id);

    T them(UUID id, H cu);

    T sua(int id, H cu);

    boolean xoa(int id);

    default List<T> suaDanhSachThongTin(List<H> cu) {
        return new ArrayList<>();
    }

    interface IHoBanThanCoLamViecChoCheDoCuSefvice extends IHoSoServices<BanThanCoLamViecChoCheDoCu, ReqBanThanCoLamViecChoCheDoCu> {
    }

    interface IHoKhenThuongSefvice extends IHoSoServices<KhenThuong, ReqKhenThuong> {
        default List<KhenThuong> khenThuongNhanVien(List<ReqKhenThuongNhanVien> vien) {
            return new ArrayList<>();
        }
    }

    interface IHoKienThucAnNinhQuocPhongSefvice extends IHoSoServices<KienThucAnNinhQuocPhong, ReqKienThucAnNinhQuocPhong> {
    }

    interface IHoKyLuatSefvice extends IHoSoServices<KyLuat, ReqKyLuat> {
        default List<KyLuat> kyLuatNhanVien(List<ReqKyLuatNhanVien> vien) {
            return new ArrayList<>();
        }
    }

    interface IHoLamViecONuocNgoaiSefvice extends IHoSoServices<LamViecONuocNgoai, ReqLamViecONuocNgoai> {
        default List<LamViecONuocNgoai> lamViecONUocNgoaiNhanVien(List<ReqLamViecONuocNgoaiNhanVien> vien) {
            return new ArrayList<>();
        }
    }

    interface IHoLuongBanThanSefvice extends IHoSoServices<LuongBanThan, ReqLuongBanThan> {
    }

    interface IHoLyLuanChinhTriSefvice extends IHoSoServices<LyLuanChinhTri, ReqLyLuanChinhTri> {
        default List<LyLuanChinhTri> lyLuanChinhTriNhanVien(List<ReqLyLuanChinhTriNhanVien> vien) {
            return new ArrayList<>();
        }
    }

    interface IHoNghiepVuChuyenNganhSefvice extends IHoSoServices<NghiepVuChuyenNganh, ReqNghiepVuChuyenNganh> {
        default List<NghiepVuChuyenNganh> nghiepVuChuyenNganhNhanVien(List<ReqNghiepVuChuyenNganhNhanVien> vien) {
            return new ArrayList<>();
        }
    }

    interface IHoNgoaiNguSefvice extends IHoSoServices<NgoaiNgu, ReqNgoaiNgu> {
        default List<NgoaiNgu> ngoaiNguNhanVien(List<ReqNgoaiNguNhanVien> vien) {
            return new ArrayList<>();
        }
    }

    interface IHoPhuCapKhacSefvice extends IHoSoServices<PhuCapKhac, ReqPhuCapKhac> {
    }

    interface IHoQuanHeGiaDinhSefvice extends IHoSoServices<QuanHeGiaDinh, ReqQuanHeGiaDinh> {
    }

    interface IHoQuaTrinhCongTacSefvice extends IHoSoServices<QuaTrinhCongTac, ReqQuaTrinhCongTac> {
        default List<QuaTrinhCongTac> chuyenCongTacNhanVien(List<ReqQuaTrinhCongTacNhanVien> vien) {
            return new ArrayList<>();
        }
    }

    interface IHoTinHocSefvice extends IHoSoServices<TinHoc, ReqTinHoc> {
    }
}
