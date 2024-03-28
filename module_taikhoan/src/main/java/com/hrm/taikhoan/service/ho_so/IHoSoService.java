package com.hrm.taikhoan.service.ho_so;

import com.hrm.taikhoan.dto.client.ho_so.HoSoChiTietDTO;
import com.hrm.taikhoan.dto.client.ho_so.HoSoDTO;
import com.hrm.taikhoan.dto.client.ho_so.ReqHoSoDTO;

import java.util.List;
import java.util.UUID;

public interface IHoSoService {
    List<HoSoDTO> getAllHoSo();
    HoSoChiTietDTO getByHoSoId(UUID id);
    HoSoDTO editHoSoById(UUID id, ReqHoSoDTO req);
    String findHoSo();
}
