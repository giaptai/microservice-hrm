package com.hrm.soyeulylich.repository;

import com.hrm.soyeulylich.models.HocVan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface HocVanRepository extends JpaRepository<HocVan, UUID> {
}
