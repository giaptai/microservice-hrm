package com.hrm.taikhoan.service.ly_luan_chinh_tri;

import com.hrm.taikhoan.dto.client.ly_luan_chinh_tri.LyLuanChinhTri;
import com.hrm.taikhoan.dto.client.ly_luan_chinh_tri.LyLuanChinhTriClient;
import com.hrm.taikhoan.dto.client.ly_luan_chinh_tri.LyLuanChinhTriDTO;
import com.hrm.taikhoan.dto.client.ly_luan_chinh_tri.ReqLyLuanChinhTri;
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
public class LyLuanChinhTriService implements ILyLuanChinhTriService {
    final LyLuanChinhTriClient client;
    final IAuthenticationFacade facade;
    @Override
    public List<LyLuanChinhTri> xemDanhSach() {
        return client.getAll();
    }

    @Override
    public List<LyLuanChinhTriDTO> xemDanhSachCaNhan() {
        TaiKhoan taiKhoan = facade.getTaiKhoan();
        return client.getAllByHoSoId(taiKhoan.getHoSoId());
    }

    @Override
    public LyLuanChinhTri xemChiTiet(int id) {
        return client.getById(id);
    }

    @Override
    public LyLuanChinhTri them(UUID id, ReqLyLuanChinhTri req) {
        return client.add(id, req);
    }

    @Override
    public LyLuanChinhTri themCaNhan(ReqLyLuanChinhTri req) {
        TaiKhoan taiKhoan = facade.getTaiKhoan();
        return them(taiKhoan.getHoSoId(), req);
    }

    @Override
    public LyLuanChinhTri sua(int id, ReqLyLuanChinhTri req) {
        return client.edit(id, req);
    }

    @Override
    public boolean xoa(int id) {
        return client.del(id);
    }
}
