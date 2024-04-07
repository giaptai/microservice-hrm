package com.hrm.hoso.services;

import com.hrm.hoso.dto.request.ReqTaoHoSo;
import com.hrm.hoso.dto.response.ResHoSo;
import com.hrm.hoso.dto.response.ResHoSoHoanChinh;
import com.hrm.hoso.models.HoSo;
import com.hrm.hoso.dto.request.ReqDSHoSo;
import com.hrm.hoso.dto.request.ReqHoSo;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public interface IHoSoService {
    UUID layHoSoId(int taiKhoanId);

    ResHoSo taoHoSo(ReqTaoHoSo req);

    List<ResHoSo> xemDanhSachHoSo();

    ResHoSo xemHoSoTheoSoCCCD(String q);

    ResHoSo capNhatHoSoCCVC(UUID id, ReqHoSo reqHoSo);

    ResHoSo xemHoSoTheoId(UUID id);

    ResHoSo xemHoSoCaNhan(int taiKhoanId);

    ResHoSo capNhatHoSoCaNhan(int taiKhoanId, ReqHoSo reqHoSo);

    default List<HoSo> pheDuyetHoSo(List<ReqDSHoSo> reqDSHoSos) {
        return new ArrayList<>();
    }
}
