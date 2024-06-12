package com.hrm.hoso.dto.mapper;

import com.hrm.hoso.client.chuc_vu_dang.ChucVuDangClient;
import com.hrm.hoso.client.dan_toc.DanTocClient;
import com.hrm.hoso.client.doi_tuong_chinh_sach.DoiTuongChinhSachClient;
import com.hrm.hoso.client.thanh_phan_gia_dinh.ThanhPhanGiaDinhClient;
import com.hrm.hoso.client.ton_giao.TonGiaoClient;
import com.hrm.hoso.dto.response.ResChucVu;
import com.hrm.hoso.dto.response.ResChucVuKiemNhiem;
import com.hrm.hoso.dto.response.ResHoSo;

import com.hrm.hoso.dto.response.ResNgachNhanVien;
import com.hrm.hoso.dto.response.ResViecLam;
import com.hrm.hoso.models.ChucVuHienTai;
import com.hrm.hoso.models.ChucVuKiemNhiem;
import com.hrm.hoso.models.HoSo;
import com.hrm.hoso.models.HocVan;
import com.hrm.hoso.models.NgachNhanVien;
import com.hrm.hoso.models.NghiaVuQuanSu;
import com.hrm.hoso.models.SucKhoe;
import com.hrm.hoso.models.ThongTinTuyenDung;
import com.hrm.hoso.models.ViecLam;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

import org.springframework.stereotype.Component;

import java.text.DecimalFormat;

@Component
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class MapperHoSo {
    final MapperThongTinTuyenDung mapperThongTinTuyenDung;
    final MapperQuanSu mapperQuanSu;
    final MapperHocVan mapperHocVan;
    final MapperChucVuHienTai mapperChucVuHienTai;
    final MapperChucVuKiemNhiem mapperChucVuKiemNhiem;
    final MapperNgach mapperNgach;
    final MapperViecLam mapperViecLam;
    final MapperSucKhoe mapperSucKhoe;
    //clients
    final DanTocClient danTocClient;
    final TonGiaoClient tonGiaoClient;
    final ThanhPhanGiaDinhClient thanhPhanGiaDinhClient;
    final DoiTuongChinhSachClient doiTuongChinhSachClient;
//    final ChucVuClient chucVuClient;
    final ChucVuDangClient chucVuDangClient;
    final DecimalFormat df = new DecimalFormat("#.##");

    public ResHoSo mapToResHoSo(HoSo hoSo) {
        ThongTinTuyenDung tuyenDung = hoSo.getThongTinTuyenDung();
        NghiaVuQuanSu quanSu = hoSo.getQuanSu();
        HocVan hocVan = hoSo.getHocVan();
        ChucVuHienTai chucVu = hoSo.getChucVuHienTai();
        ChucVuKiemNhiem chucVuKiemNhiem = hoSo.getChucVuKiemNhiem();
        NgachNhanVien ngach = hoSo.getNgach();
        ViecLam viecLam = hoSo.getViecLam();
        SucKhoe sucKhoe = hoSo.getSucKhoe();
        String danTocName = danTocClient.getName(hoSo.getDanTocId());
        String tonGiaoName = tonGiaoClient.getName(hoSo.getTonGiaoId());
        String thanhPhanGiaDinhName = thanhPhanGiaDinhClient.getName(hoSo.getThanhPhanGiaDinhId());
        String doiTuongChinhSachName = doiTuongChinhSachClient.getName(hoSo.getDoiTuongChinhSachId());
//        String chucVuKiemNhiemName = chucVuClient.getName(hoSo.getChucVuKiemNhiemId());
        String chucVuDangHienTaiName = chucVuDangClient.getName(hoSo.getChucVuDangHienTaiId());
        String chucVuDangKiemNhiemName = chucVuDangClient.getName(hoSo.getChucVuDangKiemNhiemId());
        ResChucVu chucVuHienTai = mapperChucVuHienTai.mapToResChucVu(chucVu);
        ResChucVuKiemNhiem resChucVuKiemNhiem = mapperChucVuKiemNhiem.mapToResChucVuKiemNhiem(chucVuKiemNhiem);
        return new ResHoSo(
                hoSo.getId(),
                hoSo.getHoVaTen(),
                hoSo.getGioiTinh(),
                hoSo.getCacTenGoiKhac(),
                hoSo.getSinhNgay(),
                hoSo.getNoiSinh(),
                hoSo.getQueQuan(),
                hoSo.getDanTocId(),
                danTocName,
                hoSo.getTonGiaoId(),
                tonGiaoName,
                hoSo.getSoCCCD(),
                hoSo.getNgayCapCCCD(),
                hoSo.getSoDienThoai(),
                hoSo.getSoBHXH(),
                hoSo.getSoBHYT(),
                hoSo.getNoiOHienNay(),
                hoSo.getThanhPhanGiaDinhId(),
                thanhPhanGiaDinhName,
                mapperThongTinTuyenDung.mapToResThongTinTuyenDung(tuyenDung),
                mapperQuanSu.mapToResQuanSu(quanSu),
                hoSo.getDoiTuongChinhSachId(),
                doiTuongChinhSachName,
                mapperHocVan.mapToResHocVan(hocVan),
                chucVuHienTai,
                resChucVuKiemNhiem,
//                hoSo.getChucVuKiemNhiemId(),
//                chucVuKiemNhiemName,
                hoSo.getChucVuDangHienTaiId(),
                chucVuDangHienTaiName,
                hoSo.getChucVuDangKiemNhiemId(),
                chucVuDangKiemNhiemName,
                tinhLuong(hoSo),
                mapperNgach.mapToResNgachNhanVien(ngach),
//                hoSo.getPhuCapChucVu(),
//                hoSo.getPhuCapKiemNhiem(),
//                hoSo.getPhuCapKhac(),
                mapperViecLam.mapToResViecLam(viecLam),
                mapperSucKhoe.mapToResSucKhoe(sucKhoe),
                hoSo.getTaiKhoanId(),
                hoSo.getPheDuyet(),
                hoSo.getCreateAt(),
                hoSo.getUpdateAt()
        );
    }

    private double tinhLuong(HoSo hoSo) {
        ChucVuHienTai chucVu = hoSo.getChucVuHienTai();
        ChucVuKiemNhiem kiemNhiem = hoSo.getChucVuKiemNhiem();
        NgachNhanVien ngach = hoSo.getNgach();
        ResNgachNhanVien resNgach = mapperNgach.mapToResNgachNhanVien(ngach);
        ViecLam viecLam = hoSo.getViecLam();
        ResViecLam resViecLam = mapperViecLam.mapToResViecLam(viecLam);
//        Tien
        double phuCapChucVu = chucVu.getPhuCapChucVu();
        double phuCapKiemNhiem = kiemNhiem.getPhuCapKiemNhiem();
        double phuCapKhac = kiemNhiem.getPhuCapKhac();
        float heSoNgach = resNgach.heSo();
        float phanTramNgach = resNgach.phanTramHuongLuongNgach()/100;
        double phuCapNgach = resNgach.phuCapThamNienVuotKhungNgach();
        double luongCoBan = 1_800_000;
        float phanTramViecLam = resViecLam.phamTramHuongLuong()/100;
        double phuCapTNVVkiecLam = resViecLam.phuCapThamNienVuotKhung();
        double luongViecLam = resViecLam.tienLuong();
//
        double tienLuongNhan = (phuCapChucVu + phuCapKiemNhiem + phuCapKhac) +
                (heSoNgach * phanTramNgach * luongCoBan + phuCapNgach) +
                (phanTramViecLam * luongViecLam + phuCapTNVVkiecLam);
        return Double.parseDouble(df.format(tienLuongNhan));
    }
}
