package com.hrm.hoso.response;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum ResEnum {
    TAO_HO_SO_THANH_CONG(HttpStatus.CREATED), //201 Created: Yêu cầu thành công và một tài nguyên mới đã được tạo.
    CAP_NHAT_HO_SO_THANH_CONG(HttpStatus.OK), //204 No Content:Yêu cầu thành công nhưng không có nội dung nào để trả về.
    XOA_HO_SO_THANH_CONG(HttpStatus.OK),
    PHE_DUYET_HO_SO_THANH_CONG(HttpStatus.OK),
    PHE_DUYET_HO_SO_THAT_BAI(HttpStatus.EXPECTATION_FAILED),
    THANH_CONG(HttpStatus.OK), //Yêu cầu thành công.
    CHUYEN_CONG_TAC_THANH_CONG(HttpStatus.OK),
    CHUYEN_CONG_TAC_THAT_BAI(HttpStatus.OK),
    PHUONG_THUC_KHONG_HOP_LE(HttpStatus.METHOD_NOT_ALLOWED), //405 Method Not Allowed Phương thức HTTP không được hỗ trợ cho nguồn tài nguyên được yêu cầu.
    KHONG_HOP_LE(HttpStatus.NOT_ACCEPTABLE),
    TRUNG_DU_LIEU(HttpStatus.CONFLICT),
    KHONG_DUOC_UY_QUYEN(HttpStatus.UNAUTHORIZED), //401 Unauthorized: Client không được phép truy cập tài nguyên.
    TRUY_CAP_BI_CAM(HttpStatus.FORBIDDEN), //403 Forbidden: Client bị cấm truy cập tài nguyên.
    HONG_TIM_THAY(HttpStatus.NOT_FOUND), //404 Not Found: Tài nguyên không được tìm thấy.
    ;
    private final HttpStatus code;

    ResEnum(HttpStatus code) {
        this.code = code;
    }
}
