//package com.hrm.taikhoan.service.qua_trinh_cong_tac;
//
//import com.hrm.taikhoan.client.qua_trinh_cong_tac.QuaTrinhCongTac;
//import com.hrm.taikhoan.client.qua_trinh_cong_tac.QuaTrinhCongTacClient;
//import com.hrm.taikhoan.client.qua_trinh_cong_tac.QuaTrinhCongTacDTO;
//import com.hrm.taikhoan.client.qua_trinh_cong_tac.ReqQuaTrinhCongTac;
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
//public class QuaTrinhCongTacService implements IQuaTrinhCongTacService {
//    final QuaTrinhCongTacClient client;
//    final IAuthenticationFacade facade;
//    @Override
//    public List<QuaTrinhCongTac> xemDanhSach() {
//        return client.getAll();
//    }
//
//    @Override
//    public List<QuaTrinhCongTacDTO> xemDanhSachCaNhan() {
//        TaiKhoan taiKhoan = facade.getTaiKhoan();
//        return client.getAllByHoSoId(taiKhoan.getHoSoId());
//    }
//
//    @Override
//    public QuaTrinhCongTac xemChiTiet(int id) {
//        return client.getById(id);
//    }
//
//    @Override
//    public QuaTrinhCongTac them(UUID id, ReqQuaTrinhCongTac req) {
//        return client.add(id, req);
//    }
//
//    @Override
//    public QuaTrinhCongTac themCaNhan(ReqQuaTrinhCongTac req) {
//        TaiKhoan taiKhoan = facade.getTaiKhoan();
//        return them(taiKhoan.getHoSoId(), req);
//    }
//
//    @Override
//    public QuaTrinhCongTac sua(int id, ReqQuaTrinhCongTac req) {
//        return client.edit(id, req);
//    }
//
//    @Override
//    public boolean xoa(int id) {
//        return client.del(id);
//    }
//}
