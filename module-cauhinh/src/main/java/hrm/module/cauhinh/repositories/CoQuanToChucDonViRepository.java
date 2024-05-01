package hrm.module.cauhinh.repositories;

import hrm.module.cauhinh.models.CoQuanToChucDonVi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CoQuanToChucDonViRepository extends JpaRepository<CoQuanToChucDonVi, Integer> {
    @Query
    Optional<CoQuanToChucDonVi> findByName(String name);
}
