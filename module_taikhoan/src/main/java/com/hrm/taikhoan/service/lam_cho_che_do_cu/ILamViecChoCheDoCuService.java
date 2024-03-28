package com.hrm.taikhoan.service.lam_cho_che_do_cu;

import com.hrm.taikhoan.dto.client.lam_viec_cho_che_do_cu.LamViecChoCheDoCu;
import com.hrm.taikhoan.dto.client.lam_viec_cho_che_do_cu.ReqLamViecChoCheDoCu;

import java.util.List;
import java.util.UUID;

public interface ILamViecChoCheDoCuService {
    List<LamViecChoCheDoCu> xemDanhSach();
    LamViecChoCheDoCu xemChiTiet(int id);
    LamViecChoCheDoCu them(UUID id, ReqLamViecChoCheDoCu req);
    LamViecChoCheDoCu sua(int id, ReqLamViecChoCheDoCu req);
    boolean xoa(int id);
}
