package hrm.module.cauhinh.response;

import jakarta.ws.rs.NotFoundException;
import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

//@RestController //1 dang dac biet cua Component
//@ControllerAdvice
@RestControllerAdvice
public class APIExceptionCustom {
    @Data
    public static class ApiErrors {
        private int status_code;
        private String message;
        private LocalDateTime time_stamp;

        public ApiErrors(ResEnum status_code) {
            this.status_code = status_code.getStatusCode().value();
            this.message = status_code.name();
            this.time_stamp = LocalDateTime.parse(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss")));
        }
    }
    public static class DuplicateData extends RuntimeException {
        public DuplicateData() {
            super(ResEnum.TRUNG_DU_LIEU.name());
        }
    }

    public static class NotFoundData extends RuntimeException {
        public NotFoundData() {
            super(ResEnum.HONG_TIM_THAY.name());
        }
    }

    @ExceptionHandler(value = DuplicateData.class)
    public ResponseEntity<ApiErrors> errConflict() {
        ApiErrors errors = new ApiErrors(ResEnum.TRUNG_DU_LIEU);
        return new ResponseEntity<>(errors, ResEnum.TRUNG_DU_LIEU.getStatusCode());
    }

    @ExceptionHandler(value = NotFoundData.class)
    public ResponseEntity<ApiErrors> errNotFound() {
        ApiErrors errors = new ApiErrors(ResEnum.HONG_TIM_THAY);
        return new ResponseEntity<>(errors, ResEnum.HONG_TIM_THAY.getStatusCode());
    }
}
