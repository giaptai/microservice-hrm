package hrm.module.cauhinh.repositories;

import hrm.module.cauhinh.models.DanhHieuNhaNuoc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DanhHieuNhaNuocRepository extends JpaRepository<DanhHieuNhaNuoc, Integer> {
    @Query
    Optional<DanhHieuNhaNuoc> findByName(String name);
}
