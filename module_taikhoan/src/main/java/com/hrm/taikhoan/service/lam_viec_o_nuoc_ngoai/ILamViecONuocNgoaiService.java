package com.hrm.taikhoan.service.lam_viec_o_nuoc_ngoai;


import com.hrm.taikhoan.dto.client.lam_viec_o_nuoc_ngoai.LamViecONuocNgoai;
import com.hrm.taikhoan.dto.client.lam_viec_o_nuoc_ngoai.ReqLamViecONuocNgoai;

import java.util.List;
import java.util.UUID;

public interface ILamViecONuocNgoaiService {
    List<LamViecONuocNgoai> xemDanhSach();
    LamViecONuocNgoai xemChiTiet(int id);
    LamViecONuocNgoai them(UUID id, ReqLamViecONuocNgoai req);
    LamViecONuocNgoai sua(int id, ReqLamViecONuocNgoai req);
    boolean xoa(int id);
}
