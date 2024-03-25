package com.hrm.hoso_chitiet.repositories;

import com.hrm.hoso_chitiet.models.BanThanCoLamViecChoCheDoCu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Repository
public interface BanThanCoLamViecChoCheDoCuRepository extends JpaRepository<BanThanCoLamViecChoCheDoCu, Integer> {
    //JPQL
    @Query(value = "SELECT c FROM BanThanCoLamViecChoCheDoCu c WHERE c.soYeuLyLich = ?1")
    List<BanThanCoLamViecChoCheDoCu> listBanThanCoLamViecChoCheDoCu(UUID id);

    //EMPLOYEE
    //READ ALL
    @Query(value = "SELECT c FROM BanThanCoLamViecChoCheDoCu c WHERE c.soYeuLyLich = ?1")
    List<BanThanCoLamViecChoCheDoCu> getAllByHoSo(UUID uuid);

    //READ SPECIFIC
    @Query(value = "SELECT c FROM BanThanCoLamViecChoCheDoCu c WHERE c.id = ?1 AND c.soYeuLyLich = ?2")
    BanThanCoLamViecChoCheDoCu findByIdAndHoSo(int id, UUID uuid);

    //UPDATE
    @Transactional
    @Modifying
    @Query(value = "UPDATE BanThanCoLamViecChoCheDoCu c SET c.batDau = ?1, c.ketThuc = ?2, c.chucDanhDonViDiaDiem =?3 WHERE c.id = ?4 AND c.soYeuLyLich = ?5")
    void updateByIdAndSyll(LocalDateTime l1, LocalDateTime l2, String l3, int id, UUID uuid);
}
