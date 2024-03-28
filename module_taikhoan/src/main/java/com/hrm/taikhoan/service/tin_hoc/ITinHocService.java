package com.hrm.taikhoan.service.tin_hoc;

import com.hrm.taikhoan.dto.client.tin_hoc.ReqTinHoc;
import com.hrm.taikhoan.dto.client.tin_hoc.TinHoc;

import java.util.List;
import java.util.UUID;

public interface ITinHocService {
    List<TinHoc> xemDanhSach();
    TinHoc xemChiTiet(int id);
    TinHoc them(UUID id, ReqTinHoc req);
    TinHoc sua(int id, ReqTinHoc req);
    boolean xoa(int id);
}
