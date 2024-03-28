package com.hrm.taikhoan.service.quan_he_gia_dinh;

import com.hrm.taikhoan.dto.client.quan_he_gia_dinh.QuanHeGiaDinh;
import com.hrm.taikhoan.dto.client.quan_he_gia_dinh.QuanHeGiaDinhClient;
import com.hrm.taikhoan.dto.client.quan_he_gia_dinh.ReqQuanHeGiaDinh;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class QuanHeGiaDinhService implements IQuanHeGiaDinhService{
    final QuanHeGiaDinhClient client;
    @Override
    public List<QuanHeGiaDinh> xemDanhSach() {
        return client.getAll();
    }

    @Override
    public QuanHeGiaDinh xemChiTiet(int id) {
        return client.getById(id);
    }

    @Override
    public QuanHeGiaDinh them(UUID id, ReqQuanHeGiaDinh req) {
        return client.add(id, req);
    }

    @Override
    public QuanHeGiaDinh sua(int id, ReqQuanHeGiaDinh req) {
        return client.edit(id, req);
    }

    @Override
    public boolean xoa(int id) {
        return client.del(id);
    }
}
