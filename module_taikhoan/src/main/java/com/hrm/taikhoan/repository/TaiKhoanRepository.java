package com.hrm.taikhoan.repository;

import com.hrm.taikhoan.models.TaiKhoan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TaiKhoanRepository extends JpaRepository<TaiKhoan, Integer> {
    @Query
    TaiKhoan findBySoCCCD(String soCCCD);

    @Query
    TaiKhoan findByUsernameContaining(String username);

    @Query
    TaiKhoan findByUsername(String username);

    //JPQL
    @Query(value = "UPDATE TaiKhoan tk SET tk.trangThai = ?1 where tk.id= ?2")
    abstract TaiKhoan updateTaiKhoanTrangThaiById(boolean thai, int id);
}
