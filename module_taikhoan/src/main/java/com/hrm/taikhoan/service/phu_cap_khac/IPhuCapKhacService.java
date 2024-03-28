package com.hrm.taikhoan.service.phu_cap_khac;

import com.hrm.taikhoan.dto.client.phu_cap_khac.PhuCapKhac;
import com.hrm.taikhoan.dto.client.phu_cap_khac.ReqPhuCapKhac;

import java.util.List;
import java.util.UUID;

public interface IPhuCapKhacService {
    List<PhuCapKhac> xemDanhSach();
    PhuCapKhac xemChiTiet(int id);
    PhuCapKhac them(UUID id, ReqPhuCapKhac req);
    PhuCapKhac sua(int id, ReqPhuCapKhac req);
    boolean xoa(int id);
}
