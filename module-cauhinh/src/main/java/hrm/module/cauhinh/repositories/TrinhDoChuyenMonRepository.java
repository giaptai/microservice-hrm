package hrm.module.cauhinh.repositories;

import hrm.module.cauhinh.models.TrinhDoChuyenMon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TrinhDoChuyenMonRepository extends JpaRepository<TrinhDoChuyenMon, Integer> {
    @Query
    Optional<TrinhDoChuyenMon> findByName(String name);
}
