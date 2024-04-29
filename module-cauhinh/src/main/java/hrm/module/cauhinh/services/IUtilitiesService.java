package hrm.module.cauhinh.services;

import hrm.module.cauhinh.dto.response.ResTheDTO;
import hrm.module.cauhinh.dto.response.ResViTriViecLam;

import java.util.List;

public interface IUtilitiesService<T, R> {
    default ResTheDTO<T> xemDanhSach(int pageNumber, int pageSize) {
        return null;
    }
    default ResTheDTO<ResViTriViecLam> xemDsViTriViecLam(int pageNumber, int pageSize) {
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
