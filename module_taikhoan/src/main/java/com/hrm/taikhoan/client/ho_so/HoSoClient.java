package com.hrm.taikhoan.client.ho_so;

import com.hrm.taikhoan.dto.request.ReqHoSo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "hoso", url = "${moduleUrl.ho-so}")
public interface HoSoClient {
    @PostMapping(value = "/nhan-vien/ho-so")
    HoSoDTO addHoSo(@RequestBody ReqHoSo req);
}
