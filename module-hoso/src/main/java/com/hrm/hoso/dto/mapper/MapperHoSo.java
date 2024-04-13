package com.hrm.hoso.dto.mapper;

import com.hrm.hoso.client.chuc_vu.ChucVuClient;
import com.hrm.hoso.client.chuc_vu_dang.ChucVuDangClient;
import com.hrm.hoso.client.dan_toc.DanTocClient;
import com.hrm.hoso.client.doi_tuong_chinh_sach.DoiTuongChinhSachClient;
import com.hrm.hoso.client.thanh_phan_gia_dinh.ThanhPhanGiaDinhClient;
import com.hrm.hoso.client.ton_giao.TonGiaoClient;
import com.hrm.hoso.dto.response.ResChucVu;
import com.hrm.hoso.dto.response.ResHoSo;

import com.hrm.hoso.kakfka.KafkaConfig;
import com.hrm.hoso.models.ChucVuHienTai;
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

@Component
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class MapperHoSo {
    final MapperThongTinTuyenDung mapperThongTinTuyenDung;
    final MapperQuanSu mapperQuanSu;
    final MapperHocVan mapperHocVan;
    final MapperChucVuHienTai mapperChucVuHienTai;
    final MapperNgach mapperNgach;
    final MapperViecLam mapperViecLam;
    final MapperSucKhoe mapperSucKhoe;
    //clients
    final DanTocClient danTocClient;
    final TonGiaoClient tonGiaoClient;
    final ThanhPhanGiaDinhClient thanhPhanGiaDinhClient;
    final DoiTuongChinhSachClient doiTuongChinhSachClient;
    final ChucVuClient chucVuClient;
    final ChucVuDangClient chucVuDangClient;

    final public ResHoSo mapToResHoSo(HoSo hoSo) {
        ThongTinTuyenDung tuyenDung = hoSo.getThongTinTuyenDung();
        NghiaVuQuanSu quanSu = hoSo.getQuanSu();
        HocVan hocVan = hoSo.getHocVan();
        ChucVuHienTai chucVu = hoSo.getChucVuHienTai();
        NgachNhanVien ngach = hoSo.getNgach();
        ViecLam viecLam = hoSo.getViecLam();
        SucKhoe sucKhoe = hoSo.getSucKhoe();
        String danTocName = danTocClient.getName(hoSo.getDanTocId());
        String tonGiaoName = tonGiaoClient.getName(hoSo.getTonGiaoId());
        String thanhPhanGiaDinhName = thanhPhanGiaDinhClient.getName(hoSo.getThanhPhanGiaDinhId());
        String doiTuongChinhSachName = doiTuongChinhSachClient.getName(hoSo.getDoiTuongChinhSachId());
        String chucVuKiemNhiemName = chucVuClient.getName(hoSo.getChucVuKiemNhiemId());
        String chucVuDangHienTaiName = chucVuDangClient.getName(hoSo.getChucVuDangHienTaiId());
        String chucVuDangKiemNhiemName = chucVuDangClient.getName(hoSo.getChucVuDangKiemNhiemId());
        ResChucVu chucVuHienTai = mapperChucVuHienTai.mapToResChucVu(chucVu);
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
                hoSo.getChucVuKiemNhiemId(),
                chucVuKiemNhiemName,
                hoSo.getChucVuDangHienTaiId(),
                chucVuDangHienTaiName,
                hoSo.getChucVuDangKiemNhiemId(),
                chucVuDangKiemNhiemName,
                hoSo.getTienLuong(),
                mapperNgach.mapToResNgachNhanVien(ngach),
                hoSo.getPhuCapChucVu(),
                hoSo.getPhuCapKiemNhiem(),
                hoSo.getPhuCapKhac(),
                mapperViecLam.mapToResViecLam(viecLam),
                mapperSucKhoe.mapToResSucKhoe(sucKhoe),
                hoSo.getTaiKhoanId(),
                hoSo.getPheDuyet(),
                hoSo.getCreate_at(),
                hoSo.getUpdate_at()
        );
    }
}
