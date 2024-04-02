package com.hrm.taikhoan.repository;

import com.hrm.taikhoan.enums.RoleTaiKhoan;
import com.hrm.taikhoan.models.TaiKhoan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaiKhoanRepository extends JpaRepository<TaiKhoan, Integer> {
    @Query
    TaiKhoan findBySoCCCD(String soCCCD);

    @Query
    TaiKhoan findByUsernameContaining(String username);

    @Query(value = "SELECT c FROM TaiKhoan c WHERE c.roleTaiKhoan = ?1")
    List<TaiKhoan> findAllByRoleTaiKhoan(RoleTaiKhoan role);

    @Query
    TaiKhoan findByUsername(String username);

    @Query
    TaiKhoan findByUsernameAndPassword(String username, String password);

    //JPQL
    @Query(value = "UPDATE TaiKhoan tk SET tk.trangThai = ?1 where tk.id= ?2")
    abstract TaiKhoan updateTaiKhoanTrangThaiById(boolean thai, int id);
}
