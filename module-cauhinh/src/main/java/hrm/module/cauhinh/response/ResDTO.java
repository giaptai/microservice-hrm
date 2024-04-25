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
    long totalRecord;
    int totalPage;
    final LocalDateTime time_stamp;

    private ResDTO(ResEnum resEnum, T data, long totalRecord, int totalPage) {
        this.status_code = resEnum.getStatusCode().value();
        this.message = resEnum.name();
        this.data = data;
        this.totalRecord = totalRecord;
        this.totalPage = totalPage;
        this.time_stamp = LocalDateTime.parse(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss")));
    }

    public static <T> ResponseEntity<ResDTO<T>> res(T data, long totalRecord, int totalPage, ResEnum resEnum) {
        return new ResponseEntity<>(new ResDTO<>(resEnum, data, totalRecord, totalPage), resEnum.getStatusCode());
    }

    public static <T> ResDTO<T> response(ResEnum resEnum, T data, int totalRecord, int totalPage) {
        return new ResDTO<>(resEnum, data, totalRecord, totalPage);
    }

    @Bean
    public static RuntimeException error(ResEnum resEnum) {
        return new ResponseStatusException(resEnum.getStatusCode(), resEnum.name());
    }
}
