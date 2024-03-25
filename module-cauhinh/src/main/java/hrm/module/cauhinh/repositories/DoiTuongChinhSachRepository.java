package hrm.module.cauhinh.repositories;

import hrm.module.cauhinh.models.DoiTuongChinhSach;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DoiTuongChinhSachRepository extends JpaRepository<DoiTuongChinhSach, Integer> {
    @Query
    Optional<DoiTuongChinhSach> findByName(String name);
}
