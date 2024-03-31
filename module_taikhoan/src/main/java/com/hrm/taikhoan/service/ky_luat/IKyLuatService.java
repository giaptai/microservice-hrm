package com.hrm.taikhoan.service.ky_luat;

import com.hrm.taikhoan.dto.client.ky_luat.KyLuat;
import com.hrm.taikhoan.dto.client.ky_luat.KyLuatDTO;
import com.hrm.taikhoan.dto.client.ky_luat.ReqKyLuat;

import java.util.List;
import java.util.UUID;

public interface IKyLuatService {
    List<KyLuat> xemDanhSach();
    List<KyLuatDTO> xemDanhSachCaNhan();
    KyLuat xemChiTiet(int id);
    KyLuat them(UUID id, ReqKyLuat req);
    KyLuat themCaNhan(ReqKyLuat req);
    KyLuat sua(int id, ReqKyLuat req);
    boolean xoa(int id);
}
