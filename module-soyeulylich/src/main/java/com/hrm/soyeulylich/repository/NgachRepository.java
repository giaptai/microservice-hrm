package com.hrm.soyeulylich.repository;

import com.hrm.soyeulylich.models.NgachNhanVien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface NgachRepository extends JpaRepository<NgachNhanVien, UUID> {
}
