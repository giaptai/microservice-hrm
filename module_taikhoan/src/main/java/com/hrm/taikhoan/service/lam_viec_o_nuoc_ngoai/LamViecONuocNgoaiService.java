package com.hrm.taikhoan.service.lam_viec_o_nuoc_ngoai;

import com.hrm.taikhoan.dto.client.lam_viec_o_nuoc_ngoai.LamViecONuocNgoai;
import com.hrm.taikhoan.dto.client.lam_viec_o_nuoc_ngoai.LamViecONuocNgoaiClient;
import com.hrm.taikhoan.dto.client.lam_viec_o_nuoc_ngoai.ReqLamViecONuocNgoai;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class LamViecONuocNgoaiService implements ILamViecONuocNgoaiService{
    final LamViecONuocNgoaiClient client;
    @Override
    public List<LamViecONuocNgoai> xemDanhSach() {
        return client.getAll();
    }

    @Override
    public LamViecONuocNgoai xemChiTiet(int id) {
        return client.getById(id);
    }

    @Override
    public LamViecONuocNgoai them(UUID id, ReqLamViecONuocNgoai req) {
        return client.add(id, req);
    }

    @Override
    public LamViecONuocNgoai sua(int id, ReqLamViecONuocNgoai req) {
        return client.edit(id, req);
    }

    @Override
    public boolean xoa(int id) {
        return client.del(id);
    }
}
