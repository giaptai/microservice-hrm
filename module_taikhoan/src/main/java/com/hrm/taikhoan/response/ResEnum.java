package com.hrm.taikhoan.response;

import lombok.Getter;
import org.springframework.http.HttpStatus;

public enum ResEnum {
    DOI_MAT_KHAU_THANH_CONG(HttpStatus.OK, "Đổi mật khẩu thành công"),
    DOI_EMAIL_THANH_CONG(HttpStatus.OK, "Đổi email thành công"),
    DOI_EMAIL_THAT_BAI(HttpStatus.NOT_MODIFIED, "Đổi email thất bại"),
    DOI_MAT_KHAU_THAT_BAI(HttpStatus.NOT_MODIFIED, "Đổi mật khẩu thất bại"),
    DANG_NHAP_THANH_CONG(HttpStatus.OK, "Đăng nhập thành công"),
    DANG_XUAT_THANH_CONG(HttpStatus.OK, "Đăng xuất thành công"),
    SAI_TAI_KHOAN_HOAC_MAT_KHAU(HttpStatus.UNAUTHORIZED, "Sai username hoặc mật khẩu"),
    TAO_TAI_KHOAN_THANH_CONG(HttpStatus.CREATED, "Tạo tài khoản nhân viên thành công"),
    TAO_TAI_KHOAN_THAT_BAI(HttpStatus.UNPROCESSABLE_ENTITY, "Tạo tài khoản nhân viên thất bại"),
    THANH_CONG(HttpStatus.OK, "Thành công"), //Yêu cầu thành công.
    TAO_THANH_CONG(HttpStatus.CREATED, "Tạo thành công"),
    KAFKA_THANH_CONG(HttpStatus.OK, ""),
    KAFKA_THAT_BAI(HttpStatus.EXPECTATION_FAILED, ""),
    TRUNG_DU_LIEU(HttpStatus.CONFLICT, "Trùng username hoặc email, cccd"),
    KHONG_DUOC_UY_QUYEN(HttpStatus.UNAUTHORIZED, "Không được phép truy cập"), //401 Unauthorized: Client không được phép truy cập tài nguyên.
    TRUY_CAP_BI_CAM(HttpStatus.FORBIDDEN, "Cấm truy cập"), //403 Forbidden: Client bị cấm truy cập tài nguyên.
    HONG_TIM_THAY_TAI_KHOAN(HttpStatus.NOT_FOUND, "Không tìm thấy tài khoản"),
    CAP_NHAT_THANH_CONG(HttpStatus.OK, "Cập nhật thành công"),
    XOA_THANH_CONG(HttpStatus.ACCEPTED, "Xòa thành cộng"); //404 Not Found: Tài nguyên không được tìm thấy.
    @Getter
    private HttpStatus statusCode;
    @Getter
    private String message;

    ResEnum(HttpStatus statusCode, String message) {
        this.statusCode = statusCode;
        this.message = message;
    }
}
