package com.hrm.taikhoan.service.qua_trinh_cong_tac;

import com.hrm.taikhoan.dto.client.qua_trinh_cong_tac.QuaTrinhCongTac;
import com.hrm.taikhoan.dto.client.qua_trinh_cong_tac.QuaTrinhCongTacDTO;
import com.hrm.taikhoan.dto.client.qua_trinh_cong_tac.ReqQuaTrinhCongTac;

import java.util.List;
import java.util.UUID;

public interface IQuaTrinhCongTacService {
    List<QuaTrinhCongTac> xemDanhSach();
    List<QuaTrinhCongTacDTO> xemDanhSachCaNhan();
    QuaTrinhCongTac xemChiTiet(int id);
    QuaTrinhCongTac them(UUID id, ReqQuaTrinhCongTac req);
    QuaTrinhCongTac themCaNhan(ReqQuaTrinhCongTac req);
    QuaTrinhCongTac sua(int id, ReqQuaTrinhCongTac req);
    boolean xoa(int id);
}
