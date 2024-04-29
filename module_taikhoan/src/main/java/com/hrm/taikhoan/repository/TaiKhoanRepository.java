package com.hrm.taikhoan.repository;

import com.hrm.taikhoan.enums.RoleTaiKhoan;
import com.hrm.taikhoan.models.TaiKhoan;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TaiKhoanRepository extends JpaRepository<TaiKhoan, Integer> {
    @Query
    Page<TaiKhoan> findByUsernameContaining(String username, Pageable pageable);

    @Query(value = "SELECT c FROM TaiKhoan c WHERE c.roleTaiKhoan = ?1")
    Page<TaiKhoan> findAllByRoleTaiKhoan(RoleTaiKhoan role, Pageable pageable);

    @Query(value = "SELECT c FROM TaiKhoan c WHERE c.roleTaiKhoan = ?1 AND LOWER(c.username) LIKE %?2%")
    Page<TaiKhoan> findAllByRoleTaiKhoanAndUsername(RoleTaiKhoan role, String username, Pageable pageable);

    @Query
    TaiKhoan findByUsernameAndPassword(String username, String password);

    //JPQL
    @Query(value = "UPDATE TaiKhoan tk SET tk.trangThai = ?1 where tk.id= ?2")
    abstract TaiKhoan updateTaiKhoanTrangThaiById(boolean thai, int id);
}
