package hrm.module.cauhinh.repositories;

import hrm.module.cauhinh.models.NhomVienChuc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface NhomVienChucRepository extends JpaRepository<NhomVienChuc, Integer> {
    @Query
    NhomVienChuc findByName(String name);
}
