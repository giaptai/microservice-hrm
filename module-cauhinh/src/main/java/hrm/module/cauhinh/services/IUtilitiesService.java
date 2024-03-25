package hrm.module.cauhinh.services;


import hrm.module.cauhinh.PhanTrang;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface IUtilitiesService<T, R> {
    List<T> xemDS();

    default List<T> xemDS(PhanTrang<T> phanTrang){
        return new ArrayList<>();
    };
    Optional<T> xemTheoId(int id);

    T them(R name);

    T sua(int id, R req);

    default boolean xoa(int id) {
        return true;
    }
}
