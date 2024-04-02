package com.hrm.hoso.services;

import com.hrm.hoso.dto.request.ReqTaoHoSo;
import com.hrm.hoso.models.HoSo;
import com.hrm.hoso.dto.request.ReqDSHoSo;
import com.hrm.hoso.dto.request.ReqHoSo;

import java.util.List;
import java.util.UUID;

public interface IHoSoService {
    HoSo xemHoSoCaNhan();
    HoSo capNhatHoSoCaNhan(ReqHoSo reqHoSo);
    HoSo taoHoSo(ReqTaoHoSo req);
    List<HoSo> xemDanhSachHoSo();
    HoSo xemHoSoTheoSoCCCDHoacID(String q);
    HoSo capNhatHoSoCCVC(UUID id, ReqHoSo reqHoSo);
    HoSo xemHoSoTheoId(UUID id);
    List<HoSo> pheDuyetHoSo(List<ReqDSHoSo> reqDSHoSos);
    HoSo capNhatTheoId(UUID id, ReqHoSo req);
}
