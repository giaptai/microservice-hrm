package com.hrm.taikhoan.service.ky_luat;

import com.hrm.taikhoan.dto.client.ky_luat.KyLuat;
import com.hrm.taikhoan.dto.client.ky_luat.KyLuatClient;
import com.hrm.taikhoan.dto.client.ky_luat.ReqKyLuat;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class KyLuatService implements IKyLuatService {
    final KyLuatClient client;

    @Override
    public List<KyLuat> xemDanhSach() {
        return client.getAll();
    }

    @Override
    public KyLuat xemChiTiet(int id) {
        return client.getById(id);
    }

    @Override
    public KyLuat them(UUID id, ReqKyLuat req) {
        return client.add(id, req);
    }

    @Override
    public KyLuat sua(int id, ReqKyLuat req) {
        return client.edit(id, req);
    }

    @Override
    public boolean xoa(int id) {
        return client.del(id);
    }
}
