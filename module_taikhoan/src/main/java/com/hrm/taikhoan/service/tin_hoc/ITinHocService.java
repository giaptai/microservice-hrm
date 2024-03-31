package com.hrm.taikhoan.service.tin_hoc;

import com.hrm.taikhoan.dto.client.tin_hoc.ReqTinHoc;
import com.hrm.taikhoan.dto.client.tin_hoc.TinHoc;
import com.hrm.taikhoan.dto.client.tin_hoc.TinHocDTO;

import java.util.List;
import java.util.UUID;

public interface ITinHocService {
    List<TinHoc> xemDanhSach();
    List<TinHocDTO> xemDanhSachCaNhan();
    TinHoc xemChiTiet(int id);
    TinHoc them(UUID id, ReqTinHoc req);
    TinHoc themCaNhan(ReqTinHoc req);
    TinHoc sua(int id, ReqTinHoc req);
    boolean xoa(int id);
}
