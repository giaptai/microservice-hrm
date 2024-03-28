package com.hrm.hoso.repository;

import com.hrm.hoso.models.ChucVuHienTai;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ChucVuHienTaiRepository extends JpaRepository<ChucVuHienTai, UUID> {
}
