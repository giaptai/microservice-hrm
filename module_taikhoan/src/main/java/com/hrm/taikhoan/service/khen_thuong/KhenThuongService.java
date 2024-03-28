package com.hrm.taikhoan.service.khen_thuong;

import com.hrm.taikhoan.dto.client.khen_thuong.KhenThuong;
import com.hrm.taikhoan.dto.client.khen_thuong.KhenThuongClient;
import com.hrm.taikhoan.dto.client.khen_thuong.ReqKhenThuong;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class KhenThuongService implements IKhenThuongService {
    final KhenThuongClient khenThuongClient;

    @Override
    public List<KhenThuong> xemDanhSach() {
        return khenThuongClient.getAll();
    }

    @Override
    public KhenThuong xemChiTiet(int id) {
        return khenThuongClient.getById(id);
    }

    @Override
    public KhenThuong them(UUID id, ReqKhenThuong req) {
        return khenThuongClient.add(id, req);
    }

    @Override
    public KhenThuong sua(int id, ReqKhenThuong req) {
        return khenThuongClient.edit(id, req);
    }

    @Override
    public boolean xoa(int id) {
        return khenThuongClient.del(id);
    }
}
