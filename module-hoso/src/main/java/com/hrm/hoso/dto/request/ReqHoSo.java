package com.hrm.hoso.dto.request;

import com.hrm.hoso.enums.GioiTinh;
import com.hrm.hoso.enums.PheDuyet;
import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record ReqHoSo(
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
        int thanhPhanGiaDinh, //ThanhPhanGiaDinh thanhPhanGiaDinh,
        ReqThongTinTuyenDung thongTinTuyenDung, //ThongTinTuyenDung
        ReqQuanSu quanSu, //QuanSu
        int doiTuongChinhSach, //DoiTuongChinhSach doiTuongChinhSach,
        ReqHocVan hocVan, //HocVan
        ReqChucVu chucVu,
        ReqChucVuKiemNhiem chucVuKiemNhiem,
//        int chucVuKiemNhiem, //ChucVu chucVuKiemNhiem
        int chucVuDangHienTai, //ChucDanhDang chucVuDangHienTai;
        int chucVuDangKiemNhiem, // ChucDanhDang chucVuDangKiemNhiem;
        double tienLuong,
        ReqNgachNhanVien ngach,
        double phuCapChucVu,
        double phuCapKiemNhiem,
        double phuCapKhac,
        ReqViecLam viecLam,
        ReqSucKhoe sucKhoe,
//        int taiKhoan,
        PheDuyet pheDuyet
) {
}
