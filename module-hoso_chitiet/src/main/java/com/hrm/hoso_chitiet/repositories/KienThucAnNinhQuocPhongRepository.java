package com.hrm.hoso_chitiet.repositories;

import com.hrm.hoso_chitiet.models.KienThucAnNinhQuocPhong;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Pageable;
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
    //EMPLOYEE
    //READ ALL
    @Query(value = "SELECT c FROM KienThucAnNinhQuocPhong c WHERE c.hoSoId = ?1")
    List<KienThucAnNinhQuocPhong> getAllByHoSo(UUID uuid, Pageable pageable);

    //READ SPECIFIC
    @Query(value = "SELECT c FROM KienThucAnNinhQuocPhong c WHERE c.id = ?1 AND c.hoSoId = ?2")
    Optional<KienThucAnNinhQuocPhong> findByIdAndHoSo(int id, UUID uuid);
}
