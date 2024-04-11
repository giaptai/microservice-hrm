package com.hrm.hoso_chitiet.repositories;

import com.hrm.hoso_chitiet.models.NghiepVuChuyenNganh;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface NghiepVuChuyenNganhRepository extends JpaRepository<NghiepVuChuyenNganh, Integer> {
    @Query(value = "SELECT c FROM NghiepVuChuyenNganh c WHERE c.hoSoId = ?1")
    List<NghiepVuChuyenNganh> getAllByHoSo(UUID id, Pageable pageable);

    @Query(value = "SELECT c FROM NghiepVuChuyenNganh c WHERE c.id = ?1 AND c.hoSoId = ?2")
    Optional<NghiepVuChuyenNganh> findByIdAndHoSo(int id, UUID id1);
}
