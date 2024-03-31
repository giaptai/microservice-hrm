package com.hrm.taikhoan.service.phu_cap_khac;

import com.hrm.taikhoan.dto.client.phu_cap_khac.PhuCapKhac;
import com.hrm.taikhoan.dto.client.phu_cap_khac.PhuCapKhacClient;
import com.hrm.taikhoan.dto.client.phu_cap_khac.PhuCapKhacDTO;
import com.hrm.taikhoan.dto.client.phu_cap_khac.ReqPhuCapKhac;
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
public class PhuCapKhacService implements IPhuCapKhacService{
    final PhuCapKhacClient client;
    final IAuthenticationFacade facade;
    @Override
    public List<PhuCapKhac> xemDanhSach() {
        return client.getAll();
    }

    @Override
    public List<PhuCapKhacDTO> xemDanhSachCaNhan() {
        TaiKhoan taiKhoan = facade.getTaiKhoan();
        return client.getAllByHoSoId(taiKhoan.getHoSoId());
    }

    @Override
    public PhuCapKhac xemChiTiet(int id) {
        return client.getById(id);
    }

    @Override
    public PhuCapKhac them(UUID id, ReqPhuCapKhac req) {
        return client.add(id, req);
    }

    @Override
    public PhuCapKhac themCaNhan(ReqPhuCapKhac req) {
        TaiKhoan taiKhoan = facade.getTaiKhoan();
        return them(taiKhoan.getHoSoId(), req);
    }

    @Override
    public PhuCapKhac sua(int id, ReqPhuCapKhac req) {
        return client.edit(id, req);
    }

    @Override
    public boolean xoa(int id) {
        return client.del(id);
    }
}
