package hrm.module.cauhinh.services;

import org.springframework.data.domain.Slice;
import java.util.List;

public interface IUtilitiesService<T, R> {
    default List<T> xemDanhSach(int pageNumber, int pageSize) {
        return null;
    }

    List<T> xemDS();

    T xemTheoId(int id);

    String xemTheoIdTraVeName(int id);

    T them(R name);

    T sua(int id, R req);

    default boolean xoa(int id) {
        return true;
    }
}
