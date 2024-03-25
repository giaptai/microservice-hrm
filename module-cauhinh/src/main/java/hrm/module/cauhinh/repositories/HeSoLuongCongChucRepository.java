package hrm.module.cauhinh.repositories;

import hrm.module.cauhinh.models.HeSoLuongCongChuc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HeSoLuongCongChucRepository extends JpaRepository<HeSoLuongCongChuc, Integer> {
}
