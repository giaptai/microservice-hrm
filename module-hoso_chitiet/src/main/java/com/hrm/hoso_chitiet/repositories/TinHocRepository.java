package com.hrm.hoso_chitiet.repositories;

import com.hrm.hoso_chitiet.models.TinHoc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface TinHocRepository extends JpaRepository<TinHoc, Integer> {
    @Query(value = "SELECT c FROM TinHoc c WHERE c.hoSoId = ?1")
    List<TinHoc> listTinHoc(UUID id);

    @Query(value = "SELECT c FROM TinHoc c WHERE c.hoSoId = ?1")
    List<TinHoc> getAllByHoSo(UUID id);

    @Query(value = "SELECT c FROM TinHoc c WHERE c.id = ?1 AND c.hoSoId = ?2")
    Optional<TinHoc> findByIdAndHoSo(int id, UUID id1);
}
