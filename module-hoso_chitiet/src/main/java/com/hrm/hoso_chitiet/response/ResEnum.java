package com.hrm.hoso_chitiet.response;

import org.springframework.http.HttpStatus;

public enum ResEnum {
    TAO_THANH_CONG(HttpStatus.CREATED), //Yêu cầu thành công.
    XOA_THANH_CONG(HttpStatus.ACCEPTED), //Yêu cầu thành công.
    CAP_NHAT_THANH_CONG(HttpStatus.OK), //Yêu cầu thành công.
    KAFKA_THANH_CONG(HttpStatus.OK),
    KAFKA_THAT_BAI(HttpStatus.EXPECTATION_FAILED),
    THANH_CONG(HttpStatus.OK), //Yêu cầu thành công.
    KY_LUAT_THANH_CONG(HttpStatus.OK),
    KY_LUAT_THAT_BAI(HttpStatus.OK),
    PHE_DUYET_HO_SO_THANH_CONG(HttpStatus.OK),
    PHE_DUYET_HO_SO_THAT_BAI(HttpStatus.EXPECTATION_FAILED),
    KHEN_THUONG_THANH_CONG(HttpStatus.OK),
    KHEN_THUONG_THAT_BAI(HttpStatus.OK),
    CHUYEN_CONG_TAC_THANH_CONG(HttpStatus.OK),
    CHUYEN_CONG_TAC_THAT_BAI(HttpStatus.OK),
    DOI_MAT_KHAU_THANH_CONG(HttpStatus.OK),
    DOI_EMAIL_THANH_CONG(HttpStatus.OK),
    DOI_EMAIL_THAT_BAI(HttpStatus.NOT_MODIFIED),
    DOI_MAT_KHAU_THAT_BAI(HttpStatus.NOT_MODIFIED),
    DANG_NHAP_THANH_CONG(HttpStatus.OK),
    DANG_XUAT_THANH_CONG(HttpStatus.OK),
    DANG_NHAP_THAT_BAI(HttpStatus.UNAUTHORIZED),
    PHUONG_THUC_KHONG_HOP_LE(HttpStatus.METHOD_NOT_ALLOWED), //405 Method Not Allowed Phương thức HTTP không được hỗ trợ cho nguồn tài nguyên được yêu cầu.
    KHONG_HOP_LE(HttpStatus.NOT_ACCEPTABLE),
    TRUNG_DU_LIEU(HttpStatus.CONFLICT),
    KHONG_DUOC_UY_QUYEN(HttpStatus.UNAUTHORIZED), //401 Unauthorized: Client không được phép truy cập tài nguyên.
    TRUY_CAP_BI_CAM(HttpStatus.FORBIDDEN), //403 Forbidden: Client bị cấm truy cập tài nguyên.
    HONG_TIM_THAY(HttpStatus.NOT_FOUND); //404 Not Found: Tài nguyên không được tìm thấy.
    private HttpStatus statusCode;

    ResEnum(HttpStatus statusCode) {
        this.statusCode = statusCode;
    }


    public HttpStatus getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(HttpStatus statusCode) {
        this.statusCode = statusCode;
    }
}
