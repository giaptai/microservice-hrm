package com.hrm.hoso_chitiet.repositories;

import com.hrm.hoso_chitiet.enums.XacNhan;
import com.hrm.hoso_chitiet.models.LamViecChoCheDoCu;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Repository
public interface LamViecChoCheDoCuRepository extends JpaRepository<LamViecChoCheDoCu, Integer> {
    //JPQL
    //EMPLOYEE
    //READ ALL
    @Query(value = "SELECT c FROM LamViecChoCheDoCu c WHERE c.hoSoId = ?1 AND (?2 is null OR c.xacNhan = ?2)")
    Page<LamViecChoCheDoCu> getAllByHoSo(UUID uuid, XacNhan xacNhan, Pageable pageable);

    //READ SPECIFIC
    @Query(value = "SELECT c FROM LamViecChoCheDoCu c WHERE c.id = ?1 AND c.hoSoId = ?2")
    LamViecChoCheDoCu findByIdAndHoSo(int id, UUID uuid);

    @Query(value = "SELECT c FROM LamViecChoCheDoCu c WHERE (?1 is null OR c.xacNhan = ?1)")
    Page<LamViecChoCheDoCu> getAllByXacNhan(XacNhan xacNhan, Pageable pageable);

    //UPDATE
    @Transactional
    @Modifying
    @Query(value = "UPDATE LamViecChoCheDoCu c SET c.batDau = ?1, c.ketThuc = ?2, c.chucDanhDonViDiaDiem =?3 WHERE c.id = ?4 AND c.hoSoId = ?5")
    void updateByIdAndSyll(LocalDateTime l1, LocalDateTime l2, String l3, int id, UUID uuid);
}
