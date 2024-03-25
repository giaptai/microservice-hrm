package hrm.module.cauhinh.repositories;

import hrm.module.cauhinh.models.TrinhDoGiaoDucPhoThong;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TrinhDoGiaoDucPhoThongRepository extends JpaRepository<TrinhDoGiaoDucPhoThong, Integer> {
    @Query
    Optional<TrinhDoGiaoDucPhoThong> findByName(String name);
}
