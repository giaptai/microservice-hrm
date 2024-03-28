package com.hrm.taikhoan.service.ngoai_ngu;


import com.hrm.taikhoan.dto.client.ngoai_ngu.NgoaiNgu;
import com.hrm.taikhoan.dto.client.ngoai_ngu.ReqNgoaiNgu;

import java.util.List;
import java.util.UUID;

public interface INgoaiNguService {
    List<NgoaiNgu> xemDanhSach();
    NgoaiNgu xemChiTiet(int id);
    NgoaiNgu them(UUID id, ReqNgoaiNgu req);
    NgoaiNgu sua(int id, ReqNgoaiNgu req);
    boolean xoa(int id);
}
