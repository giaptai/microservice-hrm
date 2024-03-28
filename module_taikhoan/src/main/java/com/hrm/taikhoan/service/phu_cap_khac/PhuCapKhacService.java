package com.hrm.taikhoan.service.phu_cap_khac;

import com.hrm.taikhoan.dto.client.phu_cap_khac.PhuCapKhac;
import com.hrm.taikhoan.dto.client.phu_cap_khac.PhuCapKhacClient;
import com.hrm.taikhoan.dto.client.phu_cap_khac.ReqPhuCapKhac;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PhuCapKhacService implements IPhuCapKhacService{
    final PhuCapKhacClient client;
    @Override
    public List<PhuCapKhac> xemDanhSach() {
        return client.getAll();
    }

    @Override
    public PhuCapKhac xemChiTiet(int id) {
        return client.getById(id);
    }

    @Override
    public PhuCapKhac them(UUID id, ReqPhuCapKhac req) {
        return client.add(id, req);
    }

    @Override
    public PhuCapKhac sua(int id, ReqPhuCapKhac req) {
        return client.edit(id, req);
    }

    @Override
    public boolean xoa(int id) {
        return client.del(id);
    }
}
