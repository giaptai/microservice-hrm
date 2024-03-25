package hrm.module.cauhinh.repositories;

import hrm.module.cauhinh.models.MoiQuanHe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MoiQuanHeRepository extends JpaRepository<MoiQuanHe, Integer> {
    @Query
    Optional<MoiQuanHe> findByName(String name);
}
