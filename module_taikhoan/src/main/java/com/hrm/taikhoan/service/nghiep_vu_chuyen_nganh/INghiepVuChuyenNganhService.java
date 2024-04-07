package com.hrm.taikhoan.service.nghiep_vu_chuyen_nganh;

import com.hrm.taikhoan.client.nghiep_vu_chuyen_nganh.NghiepVuChuyenNganh;
import com.hrm.taikhoan.client.nghiep_vu_chuyen_nganh.NghiepVuChuyenNganhDTO;
import com.hrm.taikhoan.client.nghiep_vu_chuyen_nganh.ReqNghiepVuChuyenNganh;

import java.util.List;
import java.util.UUID;

public interface INghiepVuChuyenNganhService {
    List<NghiepVuChuyenNganh> xemDanhSach();
    List<NghiepVuChuyenNganhDTO> xemDanhSachCaNhan();
    NghiepVuChuyenNganh xemChiTiet(int id);
    NghiepVuChuyenNganh them(UUID id, ReqNghiepVuChuyenNganh req);
    NghiepVuChuyenNganh themCaNhan(ReqNghiepVuChuyenNganh req);
    NghiepVuChuyenNganh sua(int id, ReqNghiepVuChuyenNganh req);
    boolean xoa(int id);
}
