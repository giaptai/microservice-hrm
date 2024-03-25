package hrm.module.cauhinh.repositories;

import hrm.module.cauhinh.models.BacLuong;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


@Repository
public interface BacLuongRepository extends JpaRepository<BacLuong, Integer> {
    @Query
    Optional<BacLuong> findByName(String name);

    @Modifying
    @Transactional
    @Query(value = "UPDATE BacLuong b SET b.name=?2 WHERE b.id=?1")
    int update(int id, String name);
}
