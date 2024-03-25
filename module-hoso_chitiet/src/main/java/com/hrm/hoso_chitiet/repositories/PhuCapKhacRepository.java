package com.hrm.hoso_chitiet.repositories;

import com.hrm.hoso_chitiet.models.PhuCapKhac;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface PhuCapKhacRepository extends JpaRepository<PhuCapKhac, Integer> {
    @Query(value = "SELECT c FROM PhuCapKhac c WHERE c.soYeuLyLich = ?1")
    List<PhuCapKhac> listPhuCapKhac(UUID id);

    @Query(value = "SELECT c FROM PhuCapKhac c WHERE c.soYeuLyLich = ?1")
    List<PhuCapKhac> getAllByHoSo(UUID id);

    @Query(value = "SELECT c FROM PhuCapKhac c WHERE c.id = ?1 AND c.soYeuLyLich = ?2")
    Optional<PhuCapKhac> findByIdAndHoSo(int id, UUID id1);
}
