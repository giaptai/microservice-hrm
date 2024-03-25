package hrm.module.cauhinh.repositories;

import hrm.module.cauhinh.models.NgachVienChuc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface NgachVienChucRepository extends JpaRepository<NgachVienChuc, Integer> {
    @Query
    NgachVienChuc findByName(String name);

    @Query
    NgachVienChuc findByMa(String name);
}
