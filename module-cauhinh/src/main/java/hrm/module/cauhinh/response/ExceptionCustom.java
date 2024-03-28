package hrm.module.cauhinh.response;

import jakarta.ws.rs.NotFoundException;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import java.util.NoSuchElementException;

@Component
@Getter
@Setter
public class ExceptionCustom extends RuntimeException {
    //khong co thuoc tinh luon ?
    private String message;
    public ExceptionCustom() {
        super("");
    }

    public ExceptionCustom(String m) {
        super(m);
    }

    public static class ExceptionConflict extends RuntimeException {
        public ExceptionConflict(String m) {
            super(m);
        }
    }

    public static class ExceptionNotFound extends NoSuchElementException {
        public ExceptionNotFound(String m) {
            super(m);
        }
    }

    public static class CrushEmT extends RuntimeException {
        public CrushEmT(String lon) {
            super(lon);
        }
    }

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

    //    @RestController 1 dang dac biet cua Component
    @ControllerAdvice
    public static class ExceptionController {
//        @ExceptionHandler(value = ExceptionConflict.class)
//        public ResponseEntity<ApiErrors> errConflict() {
//            ApiErrors errors = new ApiErrors(ResEnum.TRUNG_DU_LIEU);
//            return new ResponseEntity<>(errors, ResEnum.TRUNG_DU_LIEU.getStatusCode());
//        }
//
//        @ExceptionHandler(value = ExceptionNotFound.class)
//        public ResponseEntity<ApiErrors> errNotFound() {
//            ApiErrors errors = new ApiErrors(ResEnum.HONG_TIM_THAY);
//            return new ResponseEntity<>(errors, ResEnum.HONG_TIM_THAY.getStatusCode());
//        }
    }
}
