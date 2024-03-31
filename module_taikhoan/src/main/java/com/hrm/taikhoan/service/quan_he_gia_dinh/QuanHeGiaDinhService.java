package com.hrm.taikhoan.service.quan_he_gia_dinh;

import com.hrm.taikhoan.dto.client.quan_he_gia_dinh.QuanHeGiaDinh;
import com.hrm.taikhoan.dto.client.quan_he_gia_dinh.QuanHeGiaDinhClient;
import com.hrm.taikhoan.dto.client.quan_he_gia_dinh.QuanHeGiaDinhDTO;
import com.hrm.taikhoan.dto.client.quan_he_gia_dinh.ReqQuanHeGiaDinh;
import com.hrm.taikhoan.models.TaiKhoan;
import com.hrm.taikhoan.security.IAuthenticationFacade;
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
    final IAuthenticationFacade facade;
    @Override
    public List<QuanHeGiaDinh> xemDanhSach() {
        return client.getAll();
    }

    @Override
    public List<QuanHeGiaDinhDTO> xemDanhSachCaNhan() {
        TaiKhoan taiKhoan = facade.getTaiKhoan();
        return client.getAllByHoSoId(taiKhoan.getHoSoId());
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
    public QuanHeGiaDinh themCaNhan(ReqQuanHeGiaDinh req) {
        TaiKhoan taiKhoan = facade.getTaiKhoan();
        return them(taiKhoan.getHoSoId(), req);
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
