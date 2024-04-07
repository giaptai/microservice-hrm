package com.hrm.taikhoan.service.kien_thuc_an_ninh_quoc_phong;

import com.hrm.taikhoan.client.kien_thuc_an_ninh_quoc_phong.KienThucAnNinhQuocPhong;
import com.hrm.taikhoan.client.kien_thuc_an_ninh_quoc_phong.KienThucAnNinhQuocPhongDTO;
import com.hrm.taikhoan.client.kien_thuc_an_ninh_quoc_phong.ReqKienThucAnNinhQuocPhong;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public interface IKienThucAnNinhQuocPhongService {
    List<KienThucAnNinhQuocPhong> xemDanhSach();
    List<KienThucAnNinhQuocPhongDTO> xemDanhSachCaNhan();
    KienThucAnNinhQuocPhong xemChiTiet(int id);
    KienThucAnNinhQuocPhong them(UUID id, ReqKienThucAnNinhQuocPhong req);
    KienThucAnNinhQuocPhong themCaNhan(ReqKienThucAnNinhQuocPhong req);
    KienThucAnNinhQuocPhong sua(int id, ReqKienThucAnNinhQuocPhong req);
    boolean xoa(int id);
}
