package com.hrm.taikhoan.service.quan_he_gia_dinh;

import com.hrm.taikhoan.dto.client.quan_he_gia_dinh.QuanHeGiaDinh;
import com.hrm.taikhoan.dto.client.quan_he_gia_dinh.ReqQuanHeGiaDinh;

import java.util.List;
import java.util.UUID;

public interface IQuanHeGiaDinhService {
    List<QuanHeGiaDinh> xemDanhSach();
    QuanHeGiaDinh xemChiTiet(int id);
    QuanHeGiaDinh them(UUID id, ReqQuanHeGiaDinh req);
    QuanHeGiaDinh sua(int id, ReqQuanHeGiaDinh req);
    boolean xoa(int id);
}