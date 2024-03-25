package com.hrm.hoso_chitiet.repositories;

import com.hrm.hoso_chitiet.models.KienThucAnNinhQuocPhong;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface KienThucAnNinhQuocPhongRepository extends JpaRepository<KienThucAnNinhQuocPhong, Integer> {
    @Query(value = "SELECT c FROM KienThucAnNinhQuocPhong c WHERE c.soYeuLyLich = ?1")
    List<KienThucAnNinhQuocPhong> listKienThucAnNinhQuocPhong(UUID id);

    //EMPLOYEE
    //READ ALL
    @Query(value = "SELECT c FROM KienThucAnNinhQuocPhong c WHERE c.soYeuLyLich = ?1")
    List<KienThucAnNinhQuocPhong> getAllByHoSo(UUID uuid);

    //READ SPECIFIC
    @Query(value = "SELECT c FROM KienThucAnNinhQuocPhong c WHERE c.id = ?1 AND c.soYeuLyLich = ?2")
    Optional<KienThucAnNinhQuocPhong> findByIdAndHoSo(int id, UUID uuid);

    //UPDATE
    @Transactional
    @Modifying
    @Query(value = "UPDATE KienThucAnNinhQuocPhong c SET c.batDau = ?1, c.ketThuc = ?2, c.tenCoSoDaoTao =?3, c.chungChiDuocCap =?4 WHERE c.id = ?5 AND c.soYeuLyLich = ?6")
    void updateByIdAndSyll(LocalDateTime l1, LocalDateTime l2, String l3, String l4, int id, UUID uuid);
}
