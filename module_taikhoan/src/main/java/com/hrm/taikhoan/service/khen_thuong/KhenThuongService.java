//package com.hrm.taikhoan.service.khen_thuong;
//
//import com.hrm.taikhoan.client.khen_thuong.KhenThuong;
//import com.hrm.taikhoan.client.khen_thuong.KhenThuongClient;
//import com.hrm.taikhoan.client.khen_thuong.KhenThuongDTO;
//import com.hrm.taikhoan.client.khen_thuong.ReqKhenThuong;
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
//public class KhenThuongService implements IKhenThuongService {
//    final KhenThuongClient khenThuongClient;
//    final IAuthenticationFacade facade;
//
//    @Override
//    public List<KhenThuong> xemDanhSach() {
//        return khenThuongClient.getAll();
//    }
//
//    @Override
//    public List<KhenThuongDTO> xemDanhSachCaNhan() {
//        TaiKhoan taiKhoan = facade.getTaiKhoan();
//        return khenThuongClient.getAllByHoSoId(taiKhoan.getHoSoId());
//    }
//
//    @Override
//    public KhenThuong xemChiTiet(int id) {
//        return khenThuongClient.getById(id);
//    }
//
//    @Override
//    public KhenThuong them(UUID id, ReqKhenThuong req) {
//        return khenThuongClient.add(id, req);
//    }
//
//    @Override
//    public KhenThuong themCaNhan(ReqKhenThuong req) {
//        TaiKhoan taiKhoan = facade.getTaiKhoan();
//        return them(taiKhoan.getHoSoId(), req);
//    }
//
//    @Override
//    public KhenThuong sua(int id, ReqKhenThuong req) {
//        return khenThuongClient.edit(id, req);
//    }
//
//    @Override
//    public boolean xoa(int id) {
//        return khenThuongClient.del(id);
//    }
//}
