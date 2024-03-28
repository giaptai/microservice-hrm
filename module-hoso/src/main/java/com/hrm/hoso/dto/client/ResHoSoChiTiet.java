package com.hrm.hoso.dto.client;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.hrm.hoso.enums.XacNhan;
import com.hrm.hoso.enums.XepLoaiChuyenMon;
import com.hrm.hoso.enums.XepLoaiThiDua;

import java.time.LocalDateTime;
import java.util.List;

public record ResHoSoChiTiet(
        List<BanThanCoLamViecChoCheDoCu> banThanCoLamViecChoCheDoCus,
        List<KhenThuong> khenThuongs,
        List<KienThucAnNinhQuocPhong> kienThucAnNinhQuocPhongs,
        List<KyLuat> kyLuats,
        List<LamViecONuocNgoai> lamViecONuocNgoais,
        List<LuongBanThan> luongBanThans,
        List<LyLuanChinhTri> lyLuanChinhTris,
        List<NghiepVuChuyenNganh> nghiepVuChuyenNganhs,
        List<NgoaiNgu> ngoaiNgus,
        List<PhuCapKhac> phuCapKhacs,
        List<QuanHeGiaDinh> quanHeGiaDinhs,
        List<QuaTrinhCongTac> quaTrinhCongTacs,
        List<TinHoc> tinHocs
) {
    public record BanThanCoLamViecChoCheDoCu(
            int id,
            LocalDateTime batDau,
            LocalDateTime ketThuc,
            String chucDanhDonViDiaDiem
    ){}
    public record KhenThuong(
            int id,
            @JsonSerialize(using = LocalDateTimeSerializer.class)
            @JsonDeserialize(using = LocalDateTimeDeserializer.class)
            LocalDateTime nam,
            String xepLoaiChuyenMon,
            XepLoaiChuyenMon xepLoaiChuyenMonEnum,
            String xepLoaiThiDua,
            XepLoaiThiDua xepLoaiThiDuaEnum,
            int hinhThucKhenThuong,
            XacNhan xacNhan
    ){}
    public record KienThucAnNinhQuocPhong(
            int id,
            LocalDateTime batDau,
            LocalDateTime ketThuc,
            int IdTenCoSoDaoTao,
            String chungChiDuocCap,
            XacNhan xacNhan
    ){}
    public record KyLuat(
            int id,
            @JsonSerialize(using = LocalDateTimeSerializer.class)
            @JsonDeserialize(using = LocalDateTimeDeserializer.class)
            LocalDateTime batDau,
            @JsonSerialize(using = LocalDateTimeSerializer.class)
            @JsonDeserialize(using = LocalDateTimeDeserializer.class)
            LocalDateTime ketThuc,
            String hinhThuc,
            String hanhViViPhamChinh,
            int IdCoQuanQuyetDinh,
            XacNhan xacNhan
    ){}
    public record LamViecONuocNgoai(
            int id,
            LocalDateTime batDau,
            LocalDateTime ketThuc,
            String toChucDiaChiCongViec
    ){}
    public record LuongBanThan(
            int id,
            LocalDateTime batDau,
            LocalDateTime ketThuc,
            String maSo,
            String bacLuong,
            float heSoLuong,
            float tienLuongTheoViTri
    ){}
    public record LyLuanChinhTri(
            int id,
            LocalDateTime batDau,
            LocalDateTime ketThuc,
            int IdTenCoSoDaoTao,
            String hinhThucDaoTao,
            String vanBangDuocCap
    ){}
    public record NghiepVuChuyenNganh(
            int id,
            LocalDateTime batDau,
            LocalDateTime ketThuc,
            int IdTenCoSoDaoTao,
            String chungChiDuocCap,
            XacNhan xacNhan
    ){}
    public record NgoaiNgu(
            int id,
            @JsonSerialize(using = LocalDateTimeSerializer.class)
            @JsonDeserialize(using = LocalDateTimeDeserializer.class)
            LocalDateTime batDau,
            @JsonSerialize(using = LocalDateTimeSerializer.class)
            @JsonDeserialize(using = LocalDateTimeDeserializer.class)
            LocalDateTime ketThuc,
            int IdTenCoSoDaoTao,
            String tenNgoaiNgu,
            String chungChiDuocCap,
            float diemSo,
            XacNhan xacNhan
    ){}
    public record PhuCapKhac(
            int id,
            LocalDateTime batDau,
            LocalDateTime ketThuc,
            int IdLoaiPhuCap,
            float phanTramHuongPhuCap,
            float heSoPhuCap,
            String hinhThucHuong,
            double giaTri
    ){}
    public record QuanHeGiaDinh(
            int id,
            int moiQuanHe,
            String hoVaTen,
            short namSinh,
            String thongTinThanNhan
    ){}
    public record QuaTrinhCongTac(
            int id,
            LocalDateTime batDau,
            LocalDateTime ketThuc,
            int IdDonViCongTac,
            String chucDanh
    ){}
    public record TinHoc(
            int id,
            LocalDateTime batDau,
            LocalDateTime ketThuc,
            int tenCoSoDaoTao,
            String chungChiDuocCap
    ){}
}
