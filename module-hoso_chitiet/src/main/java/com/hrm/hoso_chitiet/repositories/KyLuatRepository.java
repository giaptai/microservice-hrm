package com.hrm.hoso_chitiet.repositories;

import com.hrm.hoso_chitiet.enums.XacNhan;
import com.hrm.hoso_chitiet.models.KyLuat;
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
public interface KyLuatRepository extends JpaRepository<KyLuat, Integer> {
    //EMPLOYEE
    //READ ALL
    @Query(value = "SELECT c FROM KyLuat c WHERE c.hoSoId = ?1 AND (?2 is null OR c.xacNhan = ?2)")
    Page<KyLuat> getAllByHoSo(UUID uuid, XacNhan xacNhan, Pageable pageable);

    //READ SPECIFIC
    @Query(value = "SELECT c FROM KyLuat c WHERE c.id = ?1 AND c.hoSoId = ?2")
    Optional<KyLuat> findByIdAndHoSo(int id, UUID uuid);

    @Query(value = "SELECT c FROM KyLuat c WHERE (?1 is null OR c.xacNhan = ?1)")
    Page<KyLuat> getAllByXacNhan(XacNhan xacNhan, Pageable pageable);

    @Query(value = "SELECT * FROM ky_luat WHERE bat_dau BETWEEN NOW() AND NOW() + INTERVAL 7 DAY ORDER BY bat_dau", nativeQuery = true)
    List<KyLuat> getAllByHoSoInLast7Days();

    //UPDATE
    @Transactional
    @Modifying
    @Query(value = "UPDATE KyLuat c SET c.batDau = ?1, c.ketThuc = ?2, c.hinhThuc =?3, c.hanhViViPhamChinh =?4, c.coQuanQuyetDinhId =?5 WHERE c.id = ?6 AND c.hoSoId = ?7")
    void updateByIdAndSyll(LocalDateTime l1, LocalDateTime l2, String l3, String l4, String l5, int id, UUID uuid);
}
