package com.hrm.taikhoan.service.luong_ban_than;

import com.hrm.taikhoan.dto.client.luong_ban_than.LuongBanThan;
import com.hrm.taikhoan.dto.client.luong_ban_than.LuongBanThanClient;
import com.hrm.taikhoan.dto.client.luong_ban_than.ReqLuongBanThan;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class LuongBanThanService implements ILuongBanThanService {
    final LuongBanThanClient client;

    @Override
    public List<LuongBanThan> xemDanhSach() {
        return client.getAll();
    }

    @Override
    public LuongBanThan xemChiTiet(int id) {
        return client.getById(id);
    }

    @Override
    public LuongBanThan them(UUID id, ReqLuongBanThan req) {
        return client.add(id, req);
    }

    @Override
    public LuongBanThan sua(int id, ReqLuongBanThan req) {
        return client.edit(id, req);
    }

    @Override
    public boolean xoa(int id) {
        return client.del(id);
    }
}
