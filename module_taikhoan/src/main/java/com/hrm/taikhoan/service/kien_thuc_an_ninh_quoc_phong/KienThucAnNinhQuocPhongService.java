package com.hrm.taikhoan.service.kien_thuc_an_ninh_quoc_phong;

import com.hrm.taikhoan.dto.client.kien_thuc_an_ninh_quoc_phong.KienThucAnNinhQuocPhong;
import com.hrm.taikhoan.dto.client.kien_thuc_an_ninh_quoc_phong.KienThucAnNinhQuocPhongClient;
import com.hrm.taikhoan.dto.client.kien_thuc_an_ninh_quoc_phong.KienThucAnNinhQuocPhongDTO;
import com.hrm.taikhoan.dto.client.kien_thuc_an_ninh_quoc_phong.ReqKienThucAnNinhQuocPhong;
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
public class KienThucAnNinhQuocPhongService implements IKienThucAnNinhQuocPhongService {
    final KienThucAnNinhQuocPhongClient client;
    final IAuthenticationFacade facade;
    @Override
    public List<KienThucAnNinhQuocPhong> xemDanhSach() {
        return client.getAll();
    }

    @Override
    public List<KienThucAnNinhQuocPhongDTO> xemDanhSachCaNhan() {
        TaiKhoan taiKhoan = facade.getTaiKhoan();
        return client.getAllByHoSoId(taiKhoan.getHoSoId());
    }

    @Override
    public KienThucAnNinhQuocPhong xemChiTiet(int id) {
        return client.getById(id);
    }

    @Override
    public KienThucAnNinhQuocPhong them(UUID id, ReqKienThucAnNinhQuocPhong req) {
        return client.add(id, req);
    }

    @Override
    public KienThucAnNinhQuocPhong themCaNhan(ReqKienThucAnNinhQuocPhong req) {
        TaiKhoan taiKhoan = facade.getTaiKhoan();
        return them(taiKhoan.getHoSoId(), req);
    }

    @Override
    public KienThucAnNinhQuocPhong sua(int id, ReqKienThucAnNinhQuocPhong req) {
        return client.edit(id, req);
    }

    @Override
    public boolean xoa(int id) {
        return client.del(id);
    }
}
