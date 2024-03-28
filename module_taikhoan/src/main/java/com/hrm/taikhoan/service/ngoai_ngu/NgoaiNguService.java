package com.hrm.taikhoan.service.ngoai_ngu;

import com.hrm.taikhoan.dto.client.ngoai_ngu.NgoaiNgu;
import com.hrm.taikhoan.dto.client.ngoai_ngu.NgoaiNguClient;
import com.hrm.taikhoan.dto.client.ngoai_ngu.ReqNgoaiNgu;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class NgoaiNguService implements INgoaiNguService {
    final NgoaiNguClient client;

    @Override
    public List<NgoaiNgu> xemDanhSach() {
        return client.getAll();
    }

    @Override
    public NgoaiNgu xemChiTiet(int id) {
        return client.getById(id);
    }

    @Override
    public NgoaiNgu them(UUID id, ReqNgoaiNgu req) {
        return client.add(id, req);
    }

    @Override
    public NgoaiNgu sua(int id, ReqNgoaiNgu req) {
        return client.edit(id, req);
    }

    @Override
    public boolean xoa(int id) {
        return client.del(id);
    }
}
