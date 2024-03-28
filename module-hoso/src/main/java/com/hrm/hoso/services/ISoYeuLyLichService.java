package com.hrm.hoso.services;

import com.hrm.hoso.dto.response.ResHoSoFullDetails;
import com.hrm.hoso.models.HoSo;
import com.hrm.hoso.dto.request.ReqDSSoYeuLyLich;
import com.hrm.hoso.dto.request.ReqHoSo;
import com.hrm.hoso.dto.request.ReqSoYeuLyLich;

import java.util.List;
import java.util.UUID;


public interface ISoYeuLyLichService {
    HoSo xemHoSoCaNhan();
    HoSo capNhatHoSoCaNhan(ReqSoYeuLyLich reqSoYeuLyLich);
    HoSo taoHoSo(ReqHoSo req);
    List<HoSo> xemDanhSachHoSo();
    HoSo xemSoYeuLyLichTheoSoCCCDHoacID(String q);
    HoSo capNhatHoSoCCVC(UUID id, ReqSoYeuLyLich reqSoYeuLyLich);
    HoSo xemSoYeuLyLichTheoId(UUID id);
    List<HoSo> pheDuyetSoYeuLyLich(List<ReqDSSoYeuLyLich> reqDSSoYeuLyLich);
    HoSo capNhatTheoId(UUID id, ReqSoYeuLyLich req);
}
