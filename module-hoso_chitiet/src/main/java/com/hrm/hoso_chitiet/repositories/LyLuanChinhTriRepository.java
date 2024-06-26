package com.hrm.hoso_chitiet.repositories;

import com.hrm.hoso_chitiet.enums.XacNhan;
import com.hrm.hoso_chitiet.models.LyLuanChinhTri;
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
public interface LyLuanChinhTriRepository extends JpaRepository<LyLuanChinhTri, Integer> {
    @Query(value = "SELECT c FROM LyLuanChinhTri c WHERE c.hoSoId = ?1 AND (?2 is null OR c.xacNhan = ?2)")
    Page<LyLuanChinhTri> getAllByHoSo(UUID id, XacNhan xacNhan, Pageable pageable);

    @Query(value = "SELECT c FROM LyLuanChinhTri c WHERE c.id = ?1 AND c.hoSoId = ?2")
    Optional<LyLuanChinhTri> findByIdAndHoSo(int id, UUID id1);
    @Query(value = "SELECT c FROM LyLuanChinhTri c WHERE (?1 is null OR c.xacNhan = ?1)")
    Page<LyLuanChinhTri> getAllByXacNhan(XacNhan xacNhan, Pageable pageable);
    @Transactional
    @Modifying
    @Query(value = "UPDATE LyLuanChinhTri c SET c.batDau = ?1, c.ketThuc = ?2, c.tenCoSoDaoTaoId =?3, c.hinhThucDaoTao =?4, c.vanBangDuocCap =?5 WHERE c.id = ?6 AND c.hoSoId = ?7")
    void updateByIdAndSyll(LocalDateTime batDau, LocalDateTime ketThuc, String tenCoSoDaoTao, String hinhThucDaoTao, String vanBangDuocCap, int id, UUID id1);
}
