package com.hrm.taikhoan.service.lam_cho_che_do_cu;

import com.hrm.taikhoan.dto.client.lam_viec_cho_che_do_cu.LamViecChoCheDoCu;
import com.hrm.taikhoan.dto.client.HoSoChiTietClient;
import com.hrm.taikhoan.dto.client.lam_viec_cho_che_do_cu.LamViecChoCheDoCuClient;
import com.hrm.taikhoan.dto.client.lam_viec_cho_che_do_cu.ReqLamViecChoCheDoCu;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class LamViecChoCheDoCuService implements ILamViecChoCheDoCuService {
    final LamViecChoCheDoCuClient client;
    @Override
    public List<LamViecChoCheDoCu> xemDanhSach() {
        return client.getAll();
    }

    @Override
    public LamViecChoCheDoCu xemChiTiet(int id) {
        return client.getById(id);
    }

    @Override
    public LamViecChoCheDoCu them(UUID id, ReqLamViecChoCheDoCu req) {
        return client.add(id, req);
    }

    @Override
    public LamViecChoCheDoCu sua(int id, ReqLamViecChoCheDoCu req) {
        return client.edit(id, req);
    }

    @Override
    public boolean xoa(int id) {
        return client.del(id);
    }
}
