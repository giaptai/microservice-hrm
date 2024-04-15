package com.hrm.hoso.dto.response;

import com.hrm.hoso.enums.GioiTinh;
import com.hrm.hoso.enums.PheDuyet;
import com.hrm.hoso.enums.TinhTrangSucKhoe;
import com.hrm.hoso.models.ChucVuHienTai;
import com.hrm.hoso.models.HoSo;
import com.hrm.hoso.models.HocVan;
import com.hrm.hoso.models.NgachNhanVien;
import com.hrm.hoso.models.NghiaVuQuanSu;
import com.hrm.hoso.models.SucKhoe;
import com.hrm.hoso.models.ThongTinTuyenDung;
import com.hrm.hoso.models.ViecLam;
import lombok.Builder;

import java.time.LocalDateTime;
import java.util.UUID;

@Builder
public record ResHoSo(
        UUID id,
        String hoVaTen,
        GioiTinh gioiTinh,
        String cacTenGoiKhac,
        LocalDateTime sinhNgay,
        String noiSinh,
        String queQuan,
        int danToc, //DanToc danToc,
        String danTocName,
        int tonGiao, //DanToc danToc,
        String tonGiaoName,
        String soCCCD,
        LocalDateTime ngayCapCCCD,
        String soDienThoai,
        String soBHXH,
        String soBHYT,
        String noiOHienNay,
        int thanhPhanGiaDinh,
        String thanhPhanGiaDinhName,
        ResThongTinTuyenDung thongTinTuyenDung,
        ResQuanSu quanSu,
        int doiTuongChinhSach, //DoiTuongChinhSach doiTuongChinhSach,
        String doiTuongChinhSachName,
        ResHocVan hocVan, //HocVan
        ResChucVu chucVu,
        ResChucVuKiemNhiem chucVuKiemNhiem,
//        int chucVuKiemNhiem, //ChucVu chucVuKiemNhiem
//        String chucVuKiemNhiemName,
        int chucVuDangHienTai, //ChucDanhDang chucVuDangHienTai;
        String chucVuDangHienTaiName,
        int chucVuDangKiemNhiem, // ChucDanhDang chucVuDangKiemNhiem;
        String chucVuDangKiemNhiemName,
        double tienLuong,
        ResNgachNhanVien ngach,
//        double phuCapChucVu,
//        double phuCapKiemNhiem,
//        double phuCapKhac,
        ResViecLam viecLam,
        ResSucKhoe sucKhoe,
        int taiKhoan,
        PheDuyet pheDuyet,
        LocalDateTime create_at,
        LocalDateTime update_at
) {
}
