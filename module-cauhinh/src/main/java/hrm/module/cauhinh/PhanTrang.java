package hrm.module.cauhinh;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
public class PhanTrang<T> {
    private int pageNumber; //tổng số trang
    private int pageSize; // số lượng xuất hiện trong 1 trang
    private int pageCurrent; // trang hiện tại
    private Sort sort;

    public PhanTrang() {
        this.pageCurrent = 0;
        this.pageSize = 10;
    }

    public PhanTrang(int pageCurrent) {
        this.pageCurrent = pageCurrent;
    }

    public PhanTrang(String pageCurrent) {
        this.pageCurrent = Integer.parseInt(pageCurrent);
        this.pageSize = 10;
    }

    public PageRequest ptr(int pageCurrent) {
        return PageRequest.of(pageCurrent, pageSize);
    }
}
