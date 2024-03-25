package hrm.module.cauhinh.repositories;

import hrm.module.cauhinh.models.NhomCongChuc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface NhomCongChucRepository extends JpaRepository<NhomCongChuc, Integer> {
    @Query
    NhomCongChuc findByName(String name);
}
