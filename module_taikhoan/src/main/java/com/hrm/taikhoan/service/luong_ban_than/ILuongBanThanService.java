package com.hrm.taikhoan.service.luong_ban_than;


import com.hrm.taikhoan.dto.client.luong_ban_than.LuongBanThan;
import com.hrm.taikhoan.dto.client.luong_ban_than.ReqLuongBanThan;

import java.util.List;
import java.util.UUID;

public interface ILuongBanThanService {
    List<LuongBanThan> xemDanhSach();
    LuongBanThan xemChiTiet(int id);
    LuongBanThan them(UUID id, ReqLuongBanThan req);
    LuongBanThan sua(int id, ReqLuongBanThan req);
    boolean xoa(int id);
}
