package hrm.module.cauhinh.repositories;


import hrm.module.cauhinh.models.ChucVu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ChucVuRepository extends JpaRepository<ChucVu, Integer> {
    @Query
    Optional<ChucVu> findByName(String name);
}
