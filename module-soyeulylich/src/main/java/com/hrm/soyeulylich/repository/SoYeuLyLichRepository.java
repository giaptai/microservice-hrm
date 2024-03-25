package com.hrm.soyeulylich.repository;

import com.hrm.soyeulylich.models.HoSo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface SoYeuLyLichRepository extends JpaRepository<HoSo, UUID> {
    @Query
    Optional<HoSo> findFirstBySoCCCD(String soCCCD);

    //using JPQL
    @Query(value = "UPDATE HoSo syll SET syll.trangThai = ?1 WHERE syll.id = ?2")
    abstract HoSo updateTrangThaiSoYeuLyLich(boolean check, UUID id);

//    @Query(value = "UPDATE SoYeuLyLich syll SET syll.coQuanToChucDonViTuyenDung = ?1 WHERE syll.id = ?2")
//    abstract SoYeuLyLich upadtecoQuanToChucDonVi(CoQuanToChucDonVi co, UUID id);

    @Query
    Optional<HoSo> findByTaiKhoan(int id);
}
