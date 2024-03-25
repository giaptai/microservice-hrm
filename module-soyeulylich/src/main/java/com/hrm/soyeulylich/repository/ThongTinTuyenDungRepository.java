package com.hrm.soyeulylich.repository;

import com.hrm.soyeulylich.models.ThongTinTuyenDung;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ThongTinTuyenDungRepository extends JpaRepository<ThongTinTuyenDung, UUID> {
}
