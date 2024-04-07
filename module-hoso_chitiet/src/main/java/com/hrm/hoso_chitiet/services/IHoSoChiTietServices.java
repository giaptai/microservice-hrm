package com.hrm.hoso_chitiet.services;

import com.hrm.hoso_chitiet.dto.request.ReqLamViecChoCheDoCu;
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

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public interface IHoSoChiTietServices<T, H> {
    List<T> xemDanhSach();

    List<T> xemDanhSachTheoHoSoId(UUID id);

    T xemChiTiet(int id);

    T them(UUID id, H cu);

    T sua(int id, H cu);

    boolean xoa(int id);
    //EMPLOYEE
    List<T> xemDanhSachCaNhan(int taiKhoanId);
    T themCaNhan(int taiKhoanId, H cu);
    default List<T> suaDanhSachThongTin(List<H> cu) {
        return new ArrayList<>();
    }

    interface ILamViecChoCheDoCuServiceChiTiet extends IHoSoChiTietServices<LamViecChoCheDoCu, ReqLamViecChoCheDoCu> {
    }

    interface IHoKhenThuongServiceChiTiet extends IHoSoChiTietServices<KhenThuong, ReqKhenThuong> {
        default List<KhenThuong> khenThuongNhanVien(List<ReqKhenThuongNhanVien> vien) {
            return new ArrayList<>();
        }
    }

    interface IHoKienThucAnNinhQuocPhongServiceChiTiet extends IHoSoChiTietServices<KienThucAnNinhQuocPhong, ReqKienThucAnNinhQuocPhong> {
    }

    interface IHoKyLuatServiceChiTiet extends IHoSoChiTietServices<KyLuat, ReqKyLuat> {
        default List<KyLuat> kyLuatNhanVien(List<ReqKyLuatNhanVien> vien) {
            return new ArrayList<>();
        }
    }

    interface IHoLamViecONuocNgoaiServiceChiTiet extends IHoSoChiTietServices<LamViecONuocNgoai, ReqLamViecONuocNgoai> {
        default List<LamViecONuocNgoai> lamViecONUocNgoaiNhanVien(List<ReqLamViecONuocNgoaiNhanVien> vien) {
            return new ArrayList<>();
        }
    }

    interface IHoLuongBanThanServiceChiTiet extends IHoSoChiTietServices<LuongBanThan, ReqLuongBanThan> {
    }

    interface IHoLyLuanChinhTriServiceChiTiet extends IHoSoChiTietServices<LyLuanChinhTri, ReqLyLuanChinhTri> {
        default List<LyLuanChinhTri> lyLuanChinhTriNhanVien(List<ReqLyLuanChinhTriNhanVien> vien) {
            return new ArrayList<>();
        }
    }

    interface IHoNghiepVuChuyenNganhServiceChiTiet extends IHoSoChiTietServices<NghiepVuChuyenNganh, ReqNghiepVuChuyenNganh> {
        default List<NghiepVuChuyenNganh> nghiepVuChuyenNganhNhanVien(List<ReqNghiepVuChuyenNganhNhanVien> vien) {
            return new ArrayList<>();
        }
    }

    interface IHoNgoaiNguServiceChiTiet extends IHoSoChiTietServices<NgoaiNgu, ReqNgoaiNgu> {
        default List<NgoaiNgu> ngoaiNguNhanVien(List<ReqNgoaiNguNhanVien> vien) {
            return new ArrayList<>();
        }
    }

    interface IHoPhuCapKhacServiceChiTiet extends IHoSoChiTietServices<PhuCapKhac, ReqPhuCapKhac> {
    }

    interface IHoQuanHeGiaDinhServiceChiTiet extends IHoSoChiTietServices<QuanHeGiaDinh, ReqQuanHeGiaDinh> {
    }

    interface IHoQuaTrinhCongTacServiceChiTiet extends IHoSoChiTietServices<QuaTrinhCongTac, ReqQuaTrinhCongTac> {
        default List<QuaTrinhCongTac> chuyenCongTacNhanVien(List<ReqQuaTrinhCongTacNhanVien> vien) {
            return new ArrayList<>();
        }
    }

    interface IHoTinHocServiceChiTiet extends IHoSoChiTietServices<TinHoc, ReqTinHoc> {
    }
}
