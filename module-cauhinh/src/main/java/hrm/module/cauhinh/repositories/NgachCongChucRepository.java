package hrm.module.cauhinh.repositories;

import hrm.module.cauhinh.models.NgachCongChuc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface NgachCongChucRepository extends JpaRepository<NgachCongChuc, Integer> {
    @Query
    NgachCongChuc findByName(String name);

    @Query
    NgachCongChuc findByMa(String name);
}
