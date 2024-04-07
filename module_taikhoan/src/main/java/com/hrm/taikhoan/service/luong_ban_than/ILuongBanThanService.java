package com.hrm.taikhoan.service.luong_ban_than;

import com.hrm.taikhoan.client.luong_ban_than.LuongBanThan;
import com.hrm.taikhoan.client.luong_ban_than.LuongBanThanDTO;
import com.hrm.taikhoan.client.luong_ban_than.ReqLuongBanThan;

import java.util.List;
import java.util.UUID;

public interface ILuongBanThanService {
    List<LuongBanThan> xemDanhSach();
    List<LuongBanThanDTO> xemDanhSachCaNhan();
    LuongBanThan xemChiTiet(int id);
    LuongBanThan them(UUID id, ReqLuongBanThan req);
    LuongBanThan themCaNhan(ReqLuongBanThan req);
    LuongBanThan sua(int id, ReqLuongBanThan req);
    boolean xoa(int id);
}
