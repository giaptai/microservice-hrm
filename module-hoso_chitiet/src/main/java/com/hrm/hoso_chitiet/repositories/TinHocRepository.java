package com.hrm.hoso_chitiet.repositories;

import com.hrm.hoso_chitiet.enums.XacNhan;
import com.hrm.hoso_chitiet.models.TinHoc;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface TinHocRepository extends JpaRepository<TinHoc, Integer> {
    @Query(value = "SELECT c FROM TinHoc c WHERE c.hoSoId = ?1 AND (?2 is null OR c.xacNhan = ?2)")
    Page<TinHoc> getAllByHoSo(UUID id, XacNhan xacNhan, Pageable pageable);
    @Query(value = "SELECT c FROM TinHoc c WHERE (?1 is null OR c.xacNhan = ?1)")
    Page<TinHoc> getAllByXacNhan(XacNhan xacNhan, Pageable pageable);
    @Query(value = "SELECT c FROM TinHoc c WHERE c.id = ?1 AND c.hoSoId = ?2")
    Optional<TinHoc> findByIdAndHoSo(int id, UUID id1);
}
