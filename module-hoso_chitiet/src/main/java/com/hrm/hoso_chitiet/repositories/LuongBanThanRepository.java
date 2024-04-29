package com.hrm.hoso_chitiet.repositories;

import com.hrm.hoso_chitiet.enums.XacNhan;
import com.hrm.hoso_chitiet.models.LuongBanThan;
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
public interface LuongBanThanRepository extends JpaRepository<LuongBanThan, Integer> {
    @Query(value = "SELECT c FROM LuongBanThan c WHERE c.hoSoId = ?1 AND (?2 is null OR c.xacNhan = ?2)")
    Page<LuongBanThan> getAllByHoSo(UUID id, XacNhan xacNhan, Pageable pageable);

    @Query(value = "SELECT c FROM LuongBanThan c WHERE c.id = ?1 AND c.hoSoId = ?2")
    Optional<LuongBanThan> findByIdAndHoSo(int id, UUID id1);
    @Query(value = "SELECT c FROM LuongBanThan c WHERE (?1 is null OR c.xacNhan = ?1)")
    Page<LuongBanThan> getAllByXacNhan(XacNhan xacNhan, Pageable pageable);
    @Transactional
    @Modifying
    @Query(value = "UPDATE LuongBanThan c SET c.batDau = ?1, c.ketThuc = ?2, c.maSo =?3, c.bacLuong =?4, c.heSoLuong =?5, c.tienLuongTheoViTri =?6 WHERE c.id = ?7 AND c.hoSoId = ?8")
    void updateByIdAndSyll(LocalDateTime batDau, LocalDateTime ketThuc, String maSo, String bacLuong, float heSoLuong, float tienLuongTheoViTri, int id, UUID id1);
}
