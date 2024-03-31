package com.hrm.taikhoan.service.ngoai_ngu;

import com.hrm.taikhoan.dto.client.ngoai_ngu.NgoaiNgu;
import com.hrm.taikhoan.dto.client.ngoai_ngu.NgoaiNguClient;
import com.hrm.taikhoan.dto.client.ngoai_ngu.NgoaiNguDTO;
import com.hrm.taikhoan.dto.client.ngoai_ngu.ReqNgoaiNgu;
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
public class NgoaiNguService implements INgoaiNguService {
    final NgoaiNguClient client;
    final IAuthenticationFacade facade;
    @Override
    public List<NgoaiNgu> xemDanhSach() {
        return client.getAll();
    }

    @Override
    public List<NgoaiNguDTO> xemDanhSachCaNhan() {
        TaiKhoan taiKhoan = facade.getTaiKhoan();
        return client.getAllByHoSoId(taiKhoan.getHoSoId());
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
    public NgoaiNgu themCaNhan(ReqNgoaiNgu req) {
        TaiKhoan taiKhoan = facade.getTaiKhoan();
        return them(taiKhoan.getHoSoId(), req);
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
