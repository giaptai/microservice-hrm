package hrm.module.cauhinh.repositories;

import hrm.module.cauhinh.models.LoaiVienChuc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface LoaiVienChucRepository extends JpaRepository<LoaiVienChuc, Integer> {
    @Query
    LoaiVienChuc findByLoai(String loai);
}
