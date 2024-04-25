package com.hrm.hoso.services;

import com.hrm.hoso.dto.request.ReqChucVu;
import com.hrm.hoso.dto.request.ReqTaoHoSo;
import com.hrm.hoso.dto.response.ResChucVu;
import com.hrm.hoso.dto.response.ResHoSo;
import com.hrm.hoso.dto.response.ResHoSoTomTat;
import com.hrm.hoso.dto.response.ResListHoSo;
import com.hrm.hoso.enums.PheDuyet;
import com.hrm.hoso.dto.request.ReqHoSo;

import java.util.List;
import java.util.UUID;

public interface IHoSoService {
    ResHoSoTomTat layHoSoId(int taiKhoanId);

    ResHoSo taoHoSo(ReqTaoHoSo req);

    ResListHoSo xemDanhSachHoSo(String soCCCD, String hoVaTen, int danTocId, int chucVuHienTaiId, int coQuanToChucDonViId, PheDuyet pheDuyet, String byDate, int pageNumber, int pageSize);

    ResHoSo capNhatHoSoCCVC(UUID id, ReqHoSo reqHoSo);

    ResChucVu capNhatChucVuHienTai(UUID id, ReqChucVu reqChucVu);

    ResHoSo xemHoSoTheoId(UUID id);

    ResHoSo xemHoSoCaNhan(int taiKhoanId);

    ResHoSo capNhatHoSoCaNhan(int taiKhoanId, ReqHoSo reqHoSo);

    default boolean pheDuyetHoSo(PheDuyet pheDuyet, List<ResHoSo> resHoSos) {
        return true;
    }
}
