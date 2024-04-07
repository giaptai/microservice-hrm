//package com.hrm.taikhoan.service.tin_hoc;
//
//import com.hrm.taikhoan.client.tin_hoc.ReqTinHoc;
//import com.hrm.taikhoan.client.tin_hoc.TinHoc;
//import com.hrm.taikhoan.client.tin_hoc.TinHocClient;
//import com.hrm.taikhoan.client.tin_hoc.TinHocDTO;
//import com.hrm.taikhoan.models.TaiKhoan;
//import com.hrm.taikhoan.security.IAuthenticationFacade;
//import lombok.AccessLevel;
//import lombok.RequiredArgsConstructor;
//import lombok.experimental.FieldDefaults;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.UUID;
//
//@Service
//@RequiredArgsConstructor
//@FieldDefaults(level = AccessLevel.PRIVATE)
//public class TinHocServcie implements ITinHocService {
//    final TinHocClient client;
//    final IAuthenticationFacade facade;
//
//    @Override
//    public List<TinHoc> xemDanhSach() {
//        return client.getAll();
//    }
//
//    @Override
//    public List<TinHocDTO> xemDanhSachCaNhan() {
//        TaiKhoan taiKhoan = facade.getTaiKhoan();
//        return client.getAllByHoSoId(taiKhoan.getHoSoId());
//    }
//
//    @Override
//    public TinHoc xemChiTiet(int id) {
//        return client.getById(id);
//    }
//
//    @Override
//    public TinHoc them(UUID id, ReqTinHoc req) {
//        return client.add(id, req);
//    }
//
//    @Override
//    public TinHoc themCaNhan(ReqTinHoc req) {
//        TaiKhoan taiKhoan = facade.getTaiKhoan();
//        return them(taiKhoan.getHoSoId(), req);
//    }
//
//    @Override
//    public TinHoc sua(int id, ReqTinHoc req) {
//        return client.edit(id, req);
//    }
//
//    @Override
//    public boolean xoa(int id) {
//        return client.del(id);
//    }
//}
