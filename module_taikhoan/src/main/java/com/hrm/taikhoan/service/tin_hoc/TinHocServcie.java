package com.hrm.taikhoan.service.tin_hoc;

import com.hrm.taikhoan.dto.client.tin_hoc.ReqTinHoc;
import com.hrm.taikhoan.dto.client.tin_hoc.TinHoc;
import com.hrm.taikhoan.dto.client.tin_hoc.TinHocClient;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TinHocServcie implements ITinHocService {
    final TinHocClient client;

    @Override
    public List<TinHoc> xemDanhSach() {
        return client.getAll();
    }

    @Override
    public TinHoc xemChiTiet(int id) {
        return client.getById(id);
    }

    @Override
    public TinHoc them(UUID id, ReqTinHoc req) {
        return client.add(id, req);
    }

    @Override
    public TinHoc sua(int id, ReqTinHoc req) {
        return client.edit(id, req);
    }

    @Override
    public boolean xoa(int id) {
        return client.del(id);
    }
}
