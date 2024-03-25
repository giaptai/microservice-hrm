package hrm.module.cauhinh.repositories;


import hrm.module.cauhinh.models.CapBacLoaiQuanHamQuanDoi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface CapBacLoaiQuanHamQuanDoiRepository extends JpaRepository<CapBacLoaiQuanHamQuanDoi, Integer> {
    @Query
    Optional<CapBacLoaiQuanHamQuanDoi> findByName(String name);
}
