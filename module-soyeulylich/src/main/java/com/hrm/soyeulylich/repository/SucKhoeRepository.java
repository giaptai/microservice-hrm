package com.hrm.soyeulylich.repository;

import com.hrm.soyeulylich.models.SucKhoe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SucKhoeRepository extends JpaRepository<SucKhoe, UUID> {
}
