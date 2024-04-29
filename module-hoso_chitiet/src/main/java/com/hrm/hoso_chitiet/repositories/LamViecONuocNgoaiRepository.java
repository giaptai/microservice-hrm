package com.hrm.hoso_chitiet.repositories;

import com.hrm.hoso_chitiet.enums.XacNhan;
import com.hrm.hoso_chitiet.models.LamViecONuocNgoai;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface LamViecONuocNgoaiRepository extends JpaRepository<LamViecONuocNgoai, Integer> {
    @Query(value = "SELECT c FROM LamViecONuocNgoai c WHERE c.hoSoId = ?1 AND (?2 is null OR c.xacNhan = ?2)")
    Page<LamViecONuocNgoai> getAllByHoSo(UUID id, XacNhan xacNhan, Pageable pageable);

    @Query(value = "SELECT c FROM LamViecONuocNgoai c WHERE c.id = ?1 AND c.hoSoId = ?2")
    Optional<LamViecONuocNgoai> findByIdAndHoSo(int id, UUID id1);

    @Query(value = "SELECT c FROM LamViecONuocNgoai c WHERE (?1 is null OR c.xacNhan = ?1)")
    Page<LamViecONuocNgoai> getAllByXacNhan(XacNhan xacNhan, Pageable pageable);

    @Transactional
    @Modifying
    @Query(value = "UPDATE LamViecONuocNgoai c SET c.batDau = ?1, c.ketThuc = ?2, c.toChucDiaChiCongViec =?3 WHERE c.id = ?4 AND c.hoSoId = ?5")
    void updateByIdAndSyll(LocalDateTime batDau, LocalDateTime ketThuc, String toChucDiaChiCongViec, int id, UUID id1);
}
