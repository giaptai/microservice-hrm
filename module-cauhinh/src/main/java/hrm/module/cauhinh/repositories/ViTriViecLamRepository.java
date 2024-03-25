package hrm.module.cauhinh.repositories;

import hrm.module.cauhinh.models.ViTriViecLam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ViTriViecLamRepository extends JpaRepository<ViTriViecLam, Integer> {
    @Query
    Optional<ViTriViecLam> findByName(String name);
}
