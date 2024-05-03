package com.hrm.taikhoan.client.ho_so;

import com.hrm.taikhoan.enums.GioiTinh;
import com.hrm.taikhoan.enums.PheDuyet;

import java.time.LocalDateTime;

import java.util.UUID;

import lombok.Builder;

@Builder
public record HoSoDTO(
        UUID id,
        String hoVaTen,
        GioiTinh gioiTinh,
        String cacTenGoiKhac,
        LocalDateTime sinhNgay,
        String noiSinh,
        String queQuan,
        int danToc, //DanToc danToc,
        int tonGiao, //DanToc danToc,
        String soCCCD,
        LocalDateTime ngayCapCCCD,
        String soDienThoai,
        String soBHXH,
        String soBHYT,
        String noiOHienNay,
        int thanhPhanGiaDinh,
        ThongTinTuyenDungDTO thongTinTuyenDung,
        QuanSuDTO quanSu,
        int doiTuongChinhSach,
        HocVanDTO hocVan,
        ChucVuDTO chucVu,
        int chucVuKiemNhiem, //ChucVu chucVuKiemNhiem
        int chucVuDangHienTai, //ChucDanhDang chucVuDangHienTai;
        int chucVuDangKiemNhiem, // ChucDanhDang chucVuDangKiemNhiem;
        double tienLuong,
        NgachNhanVienDTO ngach,
        double phuCapChucVu,
        double phuCapKiemNhiem,
        double phuCapKhac,
        ViecLamDTO viecLam,
        SucKhoeDTO sucKhoe,
        int taiKhoan,
        PheDuyet pheDuyet,
        LocalDateTime create_at,
        LocalDateTime update_at
) {
}
