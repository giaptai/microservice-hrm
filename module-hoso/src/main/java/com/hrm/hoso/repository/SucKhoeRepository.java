package com.hrm.hoso.repository;

import com.hrm.hoso.models.SucKhoe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SucKhoeRepository extends JpaRepository<SucKhoe, UUID> {
}
