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

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public interface IHoSoChiTietServices<T, H> {
    List<T> xemDanhSach(String byDate, int pageNumber, int pageSize);

    List<T> xemDanhSachTheoHoSoId(UUID id, String byDate, int pageNumber, int pageSize);

    T xemChiTiet(int id);

    T them(UUID id, H cu);

    T sua(int id, H cu, String role);

    boolean xoa(int id, String role);

    //EMPLOYEE
    List<T> xemDanhSachCaNhan(int taiKhoanId, String byDate, int pageNumber, int pageSize);

    T themCaNhan(int taiKhoanId, H cu);

    default List<T> suaDanhSachThongTin(List<H> cu) {
        return new ArrayList<>();
    }

    interface ILamViecChoCheDoCuServiceChiTiet extends IHoSoChiTietServices<LamViecChoCheDoCu, ReqLamViecChoCheDoCu> {
        default boolean xacNhan(XacNhan xacNhan, List<ResLamViecChoCheDoCu> res) {
            return true;
        }
    }

    interface IHoKhenThuongServiceChiTiet extends IHoSoChiTietServices<KhenThuong, ReqKhenThuong> {
        default List<KhenThuong> khenThuongNhanVien(List<ReqKhenThuongNhanVien> vien) {
            return new ArrayList<>();
        }

        default boolean xacNhan(XacNhan xacNhan, List<ResKhenThuong> res) {
            return true;
        }
    }

    interface IHoKienThucAnNinhQuocPhongServiceChiTiet extends IHoSoChiTietServices<KienThucAnNinhQuocPhong, ReqKienThucAnNinhQuocPhong> {
        default boolean xacNhan(XacNhan xacNhan, List<ResKienThucAnNinhQuocPhong> res) {
            return true;
        }
    }

    interface IHoKyLuatServiceChiTiet extends IHoSoChiTietServices<KyLuat, ReqKyLuat> {
        default List<KyLuat> kyLuatNhanVien(List<ReqKyLuatNhanVien> vien) {
            return new ArrayList<>();
        }

        default boolean xacNhan(XacNhan xacNhan, List<ResKyLuat> res) {
            return true;
        }
    }

    interface IHoLamViecONuocNgoaiServiceChiTiet extends IHoSoChiTietServices<LamViecONuocNgoai, ReqLamViecONuocNgoai> {
        default List<LamViecONuocNgoai> lamViecONUocNgoaiNhanVien(List<ReqLamViecONuocNgoaiNhanVien> vien) {
            return new ArrayList<>();
        }

        default boolean xacNhan(XacNhan xacNhan, List<ResLamViecONuocNgoai> res) {
            return true;
        }
    }

    interface IHoLuongBanThanServiceChiTiet extends IHoSoChiTietServices<LuongBanThan, ReqLuongBanThan> {
        default boolean xacNhan(XacNhan xacNhan, List<ResLuongBanThan> res) {
            return true;
        }
    }

    interface IHoLyLuanChinhTriServiceChiTiet extends IHoSoChiTietServices<LyLuanChinhTri, ReqLyLuanChinhTri> {
        default List<LyLuanChinhTri> lyLuanChinhTriNhanVien(List<ReqLyLuanChinhTriNhanVien> vien) {
            return new ArrayList<>();
        }

        default boolean xacNhan(XacNhan xacNhan, List<ResLyLuanChinhTri> res) {
            return true;
        }
    }

    interface IHoNghiepVuChuyenNganhServiceChiTiet extends IHoSoChiTietServices<NghiepVuChuyenNganh, ReqNghiepVuChuyenNganh> {
        default List<NghiepVuChuyenNganh> nghiepVuChuyenNganhNhanVien(List<ReqNghiepVuChuyenNganhNhanVien> vien) {
            return new ArrayList<>();
        }

        default boolean xacNhan(XacNhan xacNhan, List<ResNghiepVuChuyenNganh> res) {
            return true;
        }
    }

    interface IHoNgoaiNguServiceChiTiet extends IHoSoChiTietServices<NgoaiNgu, ReqNgoaiNgu> {
        default List<NgoaiNgu> ngoaiNguNhanVien(List<ReqNgoaiNguNhanVien> vien) {
            return new ArrayList<>();
        }

        default boolean xacNhan(XacNhan xacNhan, List<ResNgoaiNgu> res) {
            return true;
        }
    }

    interface IHoPhuCapKhacServiceChiTiet extends IHoSoChiTietServices<PhuCapKhac, ReqPhuCapKhac> {
        default boolean xacNhan(XacNhan xacNhan, List<ResPhuCapKhac> res) {
            return true;
        }
    }

    interface IHoQuanHeGiaDinhServiceChiTiet extends IHoSoChiTietServices<QuanHeGiaDinh, ReqQuanHeGiaDinh> {
        default boolean xacNhan(XacNhan xacNhan, List<ResQuanHeGiaDinh> res) {
            return true;
        }
    }

    interface IHoQuaTrinhCongTacServiceChiTiet extends IHoSoChiTietServices<QuaTrinhCongTac, ReqQuaTrinhCongTac> {
        default List<QuaTrinhCongTac> chuyenCongTacNhanVien(List<ReqQuaTrinhCongTacNhanVien> vien) {
            return new ArrayList<>();
        }

        default boolean xacNhan(XacNhan xacNhan, List<ResQuaTrinhCongTac> res) {
            return true;
        }
    }

    interface IHoTinHocServiceChiTiet extends IHoSoChiTietServices<TinHoc, ReqTinHoc> {
        default boolean xacNhan(XacNhan xacNhan, List<ResTinHoc> res) {
            return true;
        }
    }
}
