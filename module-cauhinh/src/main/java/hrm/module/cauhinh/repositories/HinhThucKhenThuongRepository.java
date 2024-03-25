package hrm.module.cauhinh.repositories;


import hrm.module.cauhinh.models.HinhThucKhenThuong;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface HinhThucKhenThuongRepository extends JpaRepository<HinhThucKhenThuong, Integer> {
    @Query
    Optional<HinhThucKhenThuong> findByName(String name);
}
