package com.hrm.hoso.repository;

import com.hrm.hoso.models.ChucVuKiemNhiem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface ChucVuKiemNhiemRepository extends JpaRepository<ChucVuKiemNhiem, UUID> {
}
