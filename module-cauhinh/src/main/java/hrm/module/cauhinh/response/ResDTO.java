package hrm.module.cauhinh.response;

import lombok.Data;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Data
public class ResDTO<T> {
    final int status_code;
    final String message;
    final T data;
    final LocalDateTime time_stamp;

    private ResDTO(ResEnum resEnum, T data) {
        this.status_code = resEnum.getStatusCode().value();
        this.message = resEnum.name();
        this.data = data;
        this.time_stamp = LocalDateTime.parse(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss")));
    }

    public static <T> ResponseEntity<ResDTO<T>> res(T data, ResEnum resEnum) {
        return new ResponseEntity<>(new ResDTO<>(resEnum, data), resEnum.getStatusCode());
    }

    public static <T> ResDTO<T> response(ResEnum resEnum, T data) {
        return new ResDTO<>(resEnum, data);
    }

    @Bean
    public static RuntimeException error(ResEnum resEnum) {
        return new ResponseStatusException(resEnum.getStatusCode(), resEnum.name());
    }
}
