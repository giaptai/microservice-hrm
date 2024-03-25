package hrm.module.cauhinh.repositories;

import hrm.module.cauhinh.models.ChucDanhDang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ChucDanhDangRepository extends JpaRepository<ChucDanhDang, Integer> {
    @Query
    Optional<ChucDanhDang> findByName(String name);
}
