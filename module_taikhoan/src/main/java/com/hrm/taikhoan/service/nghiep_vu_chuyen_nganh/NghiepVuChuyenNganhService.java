package com.hrm.taikhoan.service.nghiep_vu_chuyen_nganh;

import com.hrm.taikhoan.dto.client.nghiep_vu_chuyen_nganh.NghiepVuChuyenNganh;
import com.hrm.taikhoan.dto.client.nghiep_vu_chuyen_nganh.NghiepVuChuyenNganhClient;
import com.hrm.taikhoan.dto.client.nghiep_vu_chuyen_nganh.ReqNghiepVuChuyenNganh;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class NghiepVuChuyenNganhService implements INghiepVuChuyenNganhService{
    final NghiepVuChuyenNganhClient client;
    @Override
    public List<NghiepVuChuyenNganh> xemDanhSach() {
        return client.getAll();
    }

    @Override
    public NghiepVuChuyenNganh xemChiTiet(int id) {
        return client.getById(id);
    }

    @Override
    public NghiepVuChuyenNganh them(UUID id, ReqNghiepVuChuyenNganh req) {
        return client.add(id, req);
    }

    @Override
    public NghiepVuChuyenNganh sua(int id, ReqNghiepVuChuyenNganh req) {
        return client.edit(id, req);
    }

    @Override
    public boolean xoa(int id) {
        return client.del(id);
    }
}
