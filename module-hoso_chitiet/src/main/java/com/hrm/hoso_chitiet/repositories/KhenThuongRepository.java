package com.hrm.hoso_chitiet.repositories;

import com.hrm.hoso_chitiet.models.KhenThuong;
import com.hrm.hoso_chitiet.models.KyLuat;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
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
public interface KhenThuongRepository extends JpaRepository<KhenThuong, Integer> {
    //EMPLOYEE
    //READ ALL
    @Query(value = "SELECT c FROM KhenThuong c WHERE c.hoSoId = ?1")
    List<KhenThuong> getAllByHoSo(UUID uuid, Pageable pageable);
    //READ SPECIFIC
    @Query(value = "SELECT c FROM KhenThuong c WHERE c.id = ?1 AND c.hoSoId = ?2")
    Optional<KhenThuong> findByIdAndHoSo(int id, UUID uuid);
    @Query(value = "SELECT " +
            "hinh_thuc_khen_thuong_id, " +
            "id, " +
            "trang_thai, " +
            "xac_nhan, " +
            "create_at, " +
            "nam, " +
            "update_at, " +
            "ho_so_id, " +
            "ly_do, " +
            "xep_loai_chuyen_mon, " +
            "xep_loai_thi_dua " +
            "FROM khen_thuong WHERE nam BETWEEN NOW() AND DATE_ADD(NOW(),INTERVAL 7 DAY) ORDER BY nam", nativeQuery = true)
    List<KhenThuong> getAllByHoSoInLast7Days();
    //UPDATE
    @Transactional
    @Modifying
    @Query(value = "UPDATE KhenThuong c SET c.nam = ?1, c.xepLoaiChuyenMon = ?2, c.xepLoaiThiDua =?3, c.hinhThucKhenThuongId =?4, c.lyDo = ?5 WHERE c.id = ?6 AND c.hoSoId = ?7")
    void updateByIdAndSyll(LocalDateTime nam, String l2, String l3, int l4, String l5, int id, UUID uuid);
}
