package com.hrm.hoso.repository;

import com.hrm.hoso.models.HoSo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface HoSoRepository extends JpaRepository<HoSo, UUID> {
    @Query
    Optional<HoSo> findFirstBySoCCCD(String soCCCD);

    @Query(value = "SELECT COUNT(h.soCCCD) FROM HoSo h WHERE h.soCCCD = ?1")
    int findBySoCCCD(String soCCCD);

    //using JPQL
    @Query(value = "UPDATE HoSo h SET h.trangThai = ?1 WHERE h.id = ?2")
    abstract HoSo updateTrangThaiSoYeuLyLich(boolean check, UUID id);

//    @Query(value = "UPDATE SoYeuLyLich syll SET syll.coQuanToChucDonViTuyenDung = ?1 WHERE syll.id = ?2")
//    abstract SoYeuLyLich upadtecoQuanToChucDonVi(CoQuanToChucDonVi co, UUID id);

    @Query
    Optional<HoSo> findByTaiKhoanId(int id);
}
