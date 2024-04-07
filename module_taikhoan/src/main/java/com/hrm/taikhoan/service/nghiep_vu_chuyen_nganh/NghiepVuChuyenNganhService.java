//package com.hrm.taikhoan.service.nghiep_vu_chuyen_nganh;
//
//import com.hrm.taikhoan.client.nghiep_vu_chuyen_nganh.NghiepVuChuyenNganh;
//import com.hrm.taikhoan.client.nghiep_vu_chuyen_nganh.NghiepVuChuyenNganhClient;
//import com.hrm.taikhoan.client.nghiep_vu_chuyen_nganh.NghiepVuChuyenNganhDTO;
//import com.hrm.taikhoan.client.nghiep_vu_chuyen_nganh.ReqNghiepVuChuyenNganh;
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
//public class NghiepVuChuyenNganhService implements INghiepVuChuyenNganhService{
//    final NghiepVuChuyenNganhClient client;
//    final IAuthenticationFacade facade;
//    @Override
//    public List<NghiepVuChuyenNganh> xemDanhSach() {
//        return client.getAll();
//    }
//
//    @Override
//    public List<NghiepVuChuyenNganhDTO> xemDanhSachCaNhan() {
//        TaiKhoan taiKhoan = facade.getTaiKhoan();
//        return client.getAllByHoSoId(taiKhoan.getHoSoId());
//    }
//
//    @Override
//    public NghiepVuChuyenNganh xemChiTiet(int id) {
//        return client.getById(id);
//    }
//
//    @Override
//    public NghiepVuChuyenNganh them(UUID id, ReqNghiepVuChuyenNganh req) {
//        return client.add(id, req);
//    }
//
//    @Override
//    public NghiepVuChuyenNganh themCaNhan(ReqNghiepVuChuyenNganh req) {
//        TaiKhoan taiKhoan = facade.getTaiKhoan();
//        return them(taiKhoan.getHoSoId(), req);
//    }
//
//    @Override
//    public NghiepVuChuyenNganh sua(int id, ReqNghiepVuChuyenNganh req) {
//        return client.edit(id, req);
//    }
//
//    @Override
//    public boolean xoa(int id) {
//        return client.del(id);
//    }
//}
