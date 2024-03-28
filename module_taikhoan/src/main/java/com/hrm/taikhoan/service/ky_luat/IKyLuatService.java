package com.hrm.taikhoan.service.ky_luat;


import com.hrm.taikhoan.dto.client.ky_luat.KyLuat;
import com.hrm.taikhoan.dto.client.ky_luat.ReqKyLuat;

import java.util.List;
import java.util.UUID;

public interface IKyLuatService {
    List<KyLuat> xemDanhSach();
    KyLuat xemChiTiet(int id);
    KyLuat them(UUID id, ReqKyLuat req);
    KyLuat sua(int id, ReqKyLuat req);
    boolean xoa(int id);
}
