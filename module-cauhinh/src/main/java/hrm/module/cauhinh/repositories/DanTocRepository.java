package hrm.module.cauhinh.repositories;

import hrm.module.cauhinh.models.DanToc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DanTocRepository extends JpaRepository<DanToc, Integer> {
    @Query
    public Optional<DanToc> findByName(String name);
}
