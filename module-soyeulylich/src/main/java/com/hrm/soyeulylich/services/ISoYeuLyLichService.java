package com.hrm.soyeulylich.services;

import com.hrm.soyeulylich.dto.request.ReqDSSoYeuLyLich;
import com.hrm.soyeulylich.dto.request.ReqHoSo;
import com.hrm.soyeulylich.dto.request.ReqSoYeuLyLich;
import com.hrm.soyeulylich.models.HoSo;
import org.springframework.web.bind.annotation.RequestBody;

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
