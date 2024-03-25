package hrm.module.cauhinh.repositories;


import hrm.module.cauhinh.models.LoaiCongChuc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface LoaiCongChucRepository extends JpaRepository<LoaiCongChuc, Integer> {
    @Query
    LoaiCongChuc findByLoai(String loai);
}
