package hrm.module.cauhinh.services;

import hrm.module.cauhinh.dto.request.ReqHeSoLuong;
import hrm.module.cauhinh.dto.request.ReqLoai;
import hrm.module.cauhinh.dto.request.ReqNgach;
import hrm.module.cauhinh.dto.request.ReqNhom;

import hrm.module.cauhinh.models.HeSoLuongCongChuc;
import hrm.module.cauhinh.models.HeSoLuongVienChuc;
import hrm.module.cauhinh.models.LoaiCongChuc;
import hrm.module.cauhinh.models.LoaiVienChuc;
import hrm.module.cauhinh.models.NgachCongChuc;
import hrm.module.cauhinh.models.NgachVienChuc;
import hrm.module.cauhinh.models.NhomCongChuc;
import hrm.module.cauhinh.models.NhomVienChuc;

import java.util.List;

public interface ILoaiNhomHeSoNgachService {
    interface ILoaiCongChucService {
        List<LoaiCongChuc> xemLoaiCongChuc();
        default List<LoaiCongChuc> xemDanhSach(int pageNumber, int pageSize) {
            return null;
        }
        LoaiCongChuc xemTheoId(int id);
        LoaiCongChuc themLoaiCongChuc(ReqLoai loai);
        LoaiCongChuc suaLoaiCongChuc(int id, ReqLoai loai);
        boolean xoaLoaiCongChuc(int id);
    }

    interface ILoaiVienChucService {
        List<LoaiVienChuc> xemLoaiVienChuc();
        default List<LoaiVienChuc> xemDanhSach(int pageNumber, int pageSize) {
            return null;
        }
        LoaiVienChuc xemTheoId(int id);
        LoaiVienChuc themLoaiVienChuc(ReqLoai loai);
        LoaiVienChuc suaLoaiVienChuc(int id, ReqLoai loai);
        boolean xoaLoaiVienChuc(int id);
    }

    interface INhomCongChucService {
        List<NhomCongChuc> xemNhomCongChuc();
        default List<NhomCongChuc> xemDanhSach(int pageNumber, int pageSize) {
            return null;
        }
        NhomCongChuc xemTheoId(int id);
        NhomCongChuc themNhomCongChuc(ReqNhom nhom);
        NhomCongChuc suaNhomCongChuc(int id, ReqNhom nhom);
        boolean xoaNhomCongChuc(int id);

    }

    interface INhomVienChucService {
        List<NhomVienChuc> xemNhomVienChuc();
        default List<NhomVienChuc> xemDanhSach(int pageNumber, int pageSize) {
            return null;
        }
        NhomVienChuc xemTheoId(int id);
        NhomVienChuc themNhomVienChuc(ReqNhom nhom);
        NhomVienChuc suaNhomVienChuc(int id, ReqNhom nhom);
        boolean xoaNhomVienChuc(int id);
    }

    interface IHeSoLuongCongChucService {
        List<HeSoLuongCongChuc> xemHeSoLuongCongChuc();
        default List<HeSoLuongCongChuc> xemDanhSach(int pageNumber, int pageSize) {
            return null;
        }
        HeSoLuongCongChuc xemTheoId(int id);
        HeSoLuongCongChuc themHeSoLuongCongChuc(ReqHeSoLuong luong);
        HeSoLuongCongChuc suaHeSoLuongCongChuc(int id, ReqHeSoLuong luong);
        boolean xoaHeSoLuongCongChuc(int id);
    }

    interface IHeSoLuongVienChucService {
        List<HeSoLuongVienChuc> xemHeSoLuongVienChuc();
        default List<HeSoLuongVienChuc> xemDanhSach(int pageNumber, int pageSize) {
            return null;
        }
        HeSoLuongVienChuc xemTheoId(int id);
        HeSoLuongVienChuc themHeSoLuongVienChuc(ReqHeSoLuong luong);
        HeSoLuongVienChuc suaHeSoLuongVienChuc(int id, ReqHeSoLuong luong);
        boolean xoaHeSoLuongVienChuc(int id);
    }

    interface INgachVienChucService {
        List<NgachVienChuc> xemNgachVienChuc();
        default List<NgachVienChuc> xemDanhSach(int pageNumber, int pageSize) {
            return null;
        }
        NgachVienChuc xemTheoId(String id);
        NgachVienChuc themNgachVienChuc(ReqNgach req);
        NgachVienChuc suaNgachVienChuc(String id, ReqNgach req);
        boolean xoaNgachVienChuc(String id);
    }

    interface INgachCongChucService {
        List<NgachCongChuc> xemNgachCongChuc();
        default List<NgachCongChuc> xemDanhSach(int pageNumber, int pageSize) {
            return null;
        }
        NgachCongChuc xemTheoId(String id);
        NgachCongChuc themNgachCongChuc(ReqNgach req);
        NgachCongChuc suaNgachCongChuc(String id, ReqNgach req);
        boolean xoaNgachCongChuc(String id);
    }
}
