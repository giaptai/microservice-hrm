package com.hrm.taikhoan.service.ly_luan_chinh_tri;

import com.hrm.taikhoan.dto.client.ly_luan_chinh_tri.LyLuanChinhTri;
import com.hrm.taikhoan.dto.client.ly_luan_chinh_tri.ReqLyLuanChinhTri;

import java.util.List;
import java.util.UUID;

public interface ILyLuanChinhTriService {
    List<LyLuanChinhTri> xemDanhSach();
    LyLuanChinhTri xemChiTiet(int id);
    LyLuanChinhTri them(UUID id, ReqLyLuanChinhTri req);
    LyLuanChinhTri sua(int id, ReqLyLuanChinhTri req);
    boolean xoa(int id);
}
