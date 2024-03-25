package hrm.module.cauhinh.repositories;

import hrm.module.cauhinh.models.HocHam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface HocHamRepository extends JpaRepository<HocHam, Integer> {
    @Query
    Optional<HocHam> findByName(String name);
}
