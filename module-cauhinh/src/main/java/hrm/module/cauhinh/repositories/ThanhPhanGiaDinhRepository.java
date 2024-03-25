package hrm.module.cauhinh.repositories;

import hrm.module.cauhinh.models.ThanhPhanGiaDinh;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ThanhPhanGiaDinhRepository extends JpaRepository<ThanhPhanGiaDinh, Integer> {
    @Query
    Optional<ThanhPhanGiaDinh> findByName(String name);
}
