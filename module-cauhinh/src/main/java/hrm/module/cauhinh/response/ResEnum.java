package hrm.module.cauhinh.response;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum ResEnum {
    KAFKA_THANH_CONG(HttpStatus.OK),
    THANH_CONG(HttpStatus.OK), //Yêu cầu thành công.
    TAO_THANH_CONG(HttpStatus.CREATED), //201 Created: Yêu cầu thành công và một tài nguyên mới đã được tạo.
    CAP_NHAT_THANH_CONG(HttpStatus.OK), //204 No Content:Yêu cầu thành công nhưng không có nội dung nào để trả về.
    XOA_THANH_CONG(HttpStatus.OK),
    KHONG_HOP_LE(HttpStatus.NOT_ACCEPTABLE),
    TRUNG_DU_LIEU(HttpStatus.CONFLICT),
    HONG_TIM_THAY(HttpStatus.NOT_FOUND); //404 Not Found: Tài nguyên không được tìm thấy.
    private HttpStatus statusCode;

    ResEnum(HttpStatus statusCode) {
        this.statusCode = statusCode;
    }

    public void setStatusCode(HttpStatus statusCode) {
        this.statusCode = statusCode;
    }
}
