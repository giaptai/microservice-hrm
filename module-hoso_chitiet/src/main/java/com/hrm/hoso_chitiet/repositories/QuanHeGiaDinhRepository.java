package com.hrm.hoso_chitiet.repositories;

import com.hrm.hoso_chitiet.models.QuanHeGiaDinh;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface QuanHeGiaDinhRepository extends JpaRepository<QuanHeGiaDinh, Integer> {
    @Query(value = "SELECT c FROM QuanHeGiaDinh c WHERE c.hoSoId = ?1")
    List<QuanHeGiaDinh> listQuanHeGiaDinh(UUID id);
    @Query(value = "SELECT c FROM QuanHeGiaDinh c WHERE c.hoSoId = ?1")
    List<QuanHeGiaDinh> getAllByHoSo(UUID id);
    @Query(value = "SELECT c FROM QuanHeGiaDinh c WHERE c.id = ?1 AND c.hoSoId = ?2")
    Optional<QuanHeGiaDinh> findByIdAndHoSo(int id, UUID id1);
}
