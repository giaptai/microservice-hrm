package hrm.module.cauhinh.repositories;

import hrm.module.cauhinh.models.TonGiao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TonGiaoRepository extends JpaRepository<TonGiao, Integer> {
    @Query
    Optional<TonGiao> findByName(String name);
}
