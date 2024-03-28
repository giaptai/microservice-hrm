package com.hrm.taikhoan.service.khen_thuong;

import com.hrm.taikhoan.dto.client.khen_thuong.KhenThuong;
import com.hrm.taikhoan.dto.client.khen_thuong.ReqKhenThuong;

import java.util.List;
import java.util.UUID;

public interface IKhenThuongService {
    List<KhenThuong> xemDanhSach();
    KhenThuong xemChiTiet(int id);
    KhenThuong them(UUID id, ReqKhenThuong req);
    KhenThuong sua(int id, ReqKhenThuong req);
    boolean xoa(int id);
}