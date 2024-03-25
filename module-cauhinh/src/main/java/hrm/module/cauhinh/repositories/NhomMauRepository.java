package hrm.module.cauhinh.repositories;

import hrm.module.cauhinh.models.NhomMau;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface NhomMauRepository extends JpaRepository<NhomMau, Integer> {
    @Query
    Optional<NhomMau> findByName(String name);
}
