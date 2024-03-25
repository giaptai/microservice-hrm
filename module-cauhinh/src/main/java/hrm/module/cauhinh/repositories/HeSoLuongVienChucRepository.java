package hrm.module.cauhinh.repositories;

import hrm.module.cauhinh.models.HeSoLuongVienChuc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HeSoLuongVienChucRepository extends JpaRepository<HeSoLuongVienChuc, Integer> {
}
