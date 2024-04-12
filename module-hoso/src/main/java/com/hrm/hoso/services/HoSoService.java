package com.hrm.hoso.services;

import com.hrm.hoso.dto.mapper.MapperChucVuHienTai;
import com.hrm.hoso.dto.mapper.MapperHoSo;
import com.hrm.hoso.dto.request.ReqChucVu;
import com.hrm.hoso.dto.request.ReqHocVan;
import com.hrm.hoso.dto.request.ReqNgachNhanVien;
import com.hrm.hoso.dto.request.ReqQuanSu;
import com.hrm.hoso.dto.request.ReqSucKhoe;
import com.hrm.hoso.dto.request.ReqTaoHoSo;
import com.hrm.hoso.dto.request.ReqThongTinTuyenDung;
import com.hrm.hoso.dto.request.ReqViecLam;
import com.hrm.hoso.dto.response.ResChucVu;
import com.hrm.hoso.dto.response.ResHoSo;

import com.hrm.hoso.enums.PheDuyet;

import com.hrm.hoso.dto.request.ReqHoSo;

import com.hrm.hoso.kakfka.KafkaConfig;
import com.hrm.hoso.models.ChucVuHienTai;
import com.hrm.hoso.models.HoSo;
import com.hrm.hoso.models.HocVan;
import com.hrm.hoso.models.NgachNhanVien;
import com.hrm.hoso.models.NghiaVuQuanSu;
import com.hrm.hoso.models.SucKhoe;
import com.hrm.hoso.models.ThongTinTuyenDung;
import com.hrm.hoso.models.ViecLam;

import com.hrm.hoso.repository.ChucVuHienTaiRepository;
import com.hrm.hoso.repository.HocVanRepository;
import com.hrm.hoso.repository.NgachRepository;
import com.hrm.hoso.repository.NghiaVuQuanSuRepository;
import com.hrm.hoso.repository.HoSoRepository;
import com.hrm.hoso.repository.SucKhoeRepository;
import com.hrm.hoso.repository.ThongTinTuyenDungRepository;
import com.hrm.hoso.repository.ViecLamRepository;

import jakarta.ws.rs.NotFoundException;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor // tự tạo constructor với filed là final hoặc annotation not null
@FieldDefaults(level = AccessLevel.PRIVATE)
public class HoSoService implements IHoSoService {
    final HoSoRepository hoSoRepository;
    final ChucVuHienTaiRepository chucVuHienTaiRepository;
    final HocVanRepository hocVanRepository;
    final NgachRepository ngachRepository;
    final NghiaVuQuanSuRepository nghiaVuQuanSuRepository;
    final SucKhoeRepository sucKhoeRepository;
    final ThongTinTuyenDungRepository thongTinTuyenDungRepository;
    final ViecLamRepository viecLamRepository;
    //mapper
    final MapperHoSo mapperHoSo;
    final MapperChucVuHienTai mapperChucVuHienTai;


    @Override
    public UUID layHoSoId(int taiKhoanId) {
        return hoSoRepository.findByTaiKhoanId(taiKhoanId).map(HoSo::getId).orElseThrow(NotFoundException::new);
    }

    @Override
    public ResHoSo taoHoSo(ReqTaoHoSo req) {
        HoSo hoSo = HoSo.builder()
                .hoVaTen(req.hoVaTen())
                .soCCCD(req.soCCCD())
                .taiKhoanId(req.taiKhoan())
                .pheDuyet(PheDuyet.CHO_PHE_DUYET)
                .create_at(LocalDateTime.now())
                .build();
        hoSoRepository.save(hoSo);
        return mapperHoSo.mapToResHoSo(hoSo);
    }

    @Override
    public List<ResHoSo> xemDanhSachHoSo(int pageNumber, int pageSize) {
        return hoSoRepository.findAll(PageRequest.of(pageNumber, pageSize)).stream().map(mapperHoSo::mapToResHoSo).toList();
    }


    @Override
    public ResHoSo xemHoSoTheoSoCCCD(String q) {
        HoSo hoSo = hoSoRepository.findFirstBySoCCCD(q).orElseThrow(NotFoundException::new);
//            Pattern UUID_REGEX = Pattern.compile("^[0-9a-fA-F]{8}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{12}$");
//            if (UUID_REGEX.matcher(q).matches()) {
//                resHoSoId = hoSoRepository.findById(UUID.fromString(q)).orElse(null);
//            }
        return mapperHoSo.mapToResHoSo(hoSo);
    }

    @Override
    public ResHoSo capNhatHoSoCCVC(UUID id, ReqHoSo req) {
        HoSo hoSo = hoSoRepository.findById(id).orElseThrow(NotFoundException::new);
        mapToHoSo(hoSo, req);
        hoSoRepository.save(hoSo);
        return mapperHoSo.mapToResHoSo(hoSo);
    }

    @Override
    public ResChucVu capNhatChucVuHienTai(UUID id, ReqChucVu reqChucVu) {
        HoSo hoSo = hoSoRepository.findById(id).orElseThrow(NotFoundException::new);
        ChucVuHienTai chucVuHienTai = chucVuHienTaiRepository.findById(hoSo.getId()).orElse(null);
        if (reqChucVu != null) {
            if (chucVuHienTai != null) {
                chucVuHienTai.setChucVuId(reqChucVu.chucVuHienTaiId());
                chucVuHienTai.setNgayBoNhiem(reqChucVu.ngayBoNhiem());
                chucVuHienTai.setNgayBoNhiemLai(reqChucVu.ngayBoNhiemLai());
                chucVuHienTai.setDuocQuyHoacChucDanh(reqChucVu.duocQuyHoacChucDanh());
                chucVuHienTai.setCoQuanToChucDonViTuyenDungId(reqChucVu.coQuanToChucDonViTuyenDungId());
                chucVuHienTai.setUpdate_at();
            } else {
                chucVuHienTai = new ChucVuHienTai(
                        reqChucVu.chucVuHienTaiId(),
                        reqChucVu.ngayBoNhiem(),
                        reqChucVu.ngayBoNhiemLai(),
                        reqChucVu.duocQuyHoacChucDanh(),
                        reqChucVu.coQuanToChucDonViTuyenDungId(),
                        hoSo);
            }
            chucVuHienTaiRepository.save(chucVuHienTai);
        }
        ResChucVu resChucVu = mapperChucVuHienTai.mapToResChucVu(chucVuHienTai);
        KafkaConfig kafkaConfig = new KafkaConfig(StringSerializer.class.getName(), ResChucVu.ResChucVuSerializer.class.getName());
        // create the producer
        KafkaProducer<String, ResChucVu> producer = new KafkaProducer<>(kafkaConfig.getProperties());
        // create a producer record
        ProducerRecord<String, ResChucVu> producerRecord = new ProducerRecord<>("qua-trinh-cong-tac", resChucVu);
        // send data - asynchronous
        producer.send(producerRecord, (metadata, exc) -> {
            if (exc == null) {
                System.out.printf("""
                                Received new metadata
                                "Topic: %s
                                Partition: %s
                                Offset: %s
                                Timestamp: %s
                                """,
                        metadata.topic(),
                        metadata.partition(),
                        metadata.offset(),
                        metadata.timestamp());
            }
        });
        // flush data - synchronous
        producer.flush();
        // flush and close producer
        producer.close();
        return resChucVu;
    }

    @Override
    public ResHoSo xemHoSoTheoId(UUID id) {
        HoSo hoSo = hoSoRepository.findById(id).orElseThrow(NotFoundException::new);
        return mapperHoSo.mapToResHoSo(hoSo);
    }

//    @Override
//    public List<HoSo> pheDuyetHoSo(List<ReqDSHoSo> reqDSHoSos) {
//        try {
//            List<HoSo> hoSos = reqDSHoSos.stream().flatMap(c -> c.soYeuLyLichs().stream().map(t -> {
//                HoSo hoSo = hoSoRepository.findById(t).orElse(null);
//                if (hoSo != null) {
//                    hoSo.setPheDuyet(c.pheDuyet());
//                    hoSo.setUpdate_at();
//                }
//                return hoSo;
//            })).toList();
//            return hoSoRepository.saveAll(hoSos);
//        } catch (RuntimeException e) {
//            throw new RuntimeException(e.getCause());
//        }
//    }

    @Override
    public ResHoSo xemHoSoCaNhan(int taiKhoanId) {
        HoSo hoSo = hoSoRepository.findByTaiKhoanId(taiKhoanId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
//        return xemHoSoTheoId(hoSo.getId());
        return mapperHoSo.mapToResHoSo(hoSo);
    }

    @Override
    public ResHoSo capNhatHoSoCaNhan(int taiKhoanId, ReqHoSo reqHoSo) {
        HoSo hoSo = hoSoRepository.findByTaiKhoanId(taiKhoanId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return capNhatHoSoCCVC(hoSo.getId(), reqHoSo);
    }

    private void mapToHoSo(HoSo hoSo, ReqHoSo req) {
        ReqThongTinTuyenDung tuyenDung = req.thongTinTuyenDung();
        ReqQuanSu reqQuanSu = req.quanSu();
        ReqHocVan reqHocVan = req.hocVan();
        ReqChucVu reqChucVu = req.chucVu();
        ReqNgachNhanVien reqNgach = req.ngach();
        ReqViecLam reqViecLam = req.viecLam();
        ReqSucKhoe reqSucKhoe = req.sucKhoe();
        //table
        ThongTinTuyenDung thongTinTuyenDung = thongTinTuyenDungRepository.findById(hoSo.getId()).orElse(null);
        if (tuyenDung != null) {
            if (thongTinTuyenDung != null) {
                thongTinTuyenDung.setNgheNghiepTruocKhiTuyenDung(tuyenDung.ngheNghiepTruocKhiTuyenDung());
                thongTinTuyenDung.setNgayDuocTuyenDungLanDau(tuyenDung.ngayDuocTuyenDungLanDau());
                thongTinTuyenDung.setNgayVaoCoQuanHienDangCongTac(tuyenDung.ngayVaoCoQuanHienDangCongTac());
                thongTinTuyenDung.setNgayVaoDangCongSanVietNam(tuyenDung.ngayVaoDangCongSanVietNam());
                thongTinTuyenDung.setNgayChinhThuc(tuyenDung.ngayChinhThuc());
                thongTinTuyenDung.setNgayThamGiaToChucChinhTriXaHoiDauTien(tuyenDung.ngayThamGiaToChucChinhTriXaHoiDauTien());
                thongTinTuyenDung.setCongViecChinhDuocGiao(tuyenDung.congViecChinhDuocGiao());
                thongTinTuyenDung.setSoTruongCongTac(tuyenDung.soTruongCongTac());
                thongTinTuyenDung.setCongViecLamLauNhat(tuyenDung.congViecLamLauNhat());
                thongTinTuyenDung.setUpdate_at();
            } else
                thongTinTuyenDung = new ThongTinTuyenDung(tuyenDung.ngheNghiepTruocKhiTuyenDung(), tuyenDung.ngayDuocTuyenDungLanDau(),
                        tuyenDung.ngayVaoCoQuanHienDangCongTac(), tuyenDung.ngayVaoDangCongSanVietNam(), tuyenDung.ngayChinhThuc(),
                        tuyenDung.ngayThamGiaToChucChinhTriXaHoiDauTien(), tuyenDung.congViecChinhDuocGiao(),
                        tuyenDung.soTruongCongTac(), tuyenDung.soTruongCongTac(), hoSo);
        }
        NghiaVuQuanSu quanSu = nghiaVuQuanSuRepository.findById(hoSo.getId()).orElse(null);
        if (reqQuanSu != null) {
            if (quanSu != null) {
                quanSu.setNgayNhapNgu(reqQuanSu.ngayNhapNgu());
                quanSu.setNgayXuatNgu(reqQuanSu.ngayXuatNgu());
                quanSu.setQuanHamCaoNhatId(reqQuanSu.capBacLoaiQuanHamQuanDoi());
                quanSu.setUpdate_at();
            } else
                quanSu = new NghiaVuQuanSu(reqQuanSu.ngayNhapNgu(), reqQuanSu.ngayXuatNgu(), reqQuanSu.capBacLoaiQuanHamQuanDoi(), hoSo);
        }
        HocVan hocVan = hocVanRepository.findById(hoSo.getId()).orElse(null);
        if (reqHocVan != null) {
            if (hocVan != null) {
                hocVan.setTrinhDoGiaoDucPhoThongId(reqHocVan.trinhDoGiaoDucPhoThong());
                hocVan.setTrinhDoChuyenMonCaoNhatId(reqHocVan.trinhDoChuyenMon());
                hocVan.setHocHamId(reqHocVan.hocHam());
                hocVan.setDanhHieuNhaNuocPhongTangId(reqHocVan.danhHieuNhaNuocPhongTang());
                hocVan.setUpdate_at();
            } else
                hocVan = new HocVan(reqHocVan.trinhDoGiaoDucPhoThong(), reqHocVan.trinhDoChuyenMon(), reqHocVan.hocHam(), reqHocVan.danhHieuNhaNuocPhongTang(), hoSo);
        }
//        ChucVuHienTai chucVuHienTai = chucVuHienTaiRepository.findById(hoSo.getId()).orElse(null);
//        if (reqChucVu != null) {
//            if (chucVuHienTai != null) {
//                chucVuHienTai.setChucVuId(reqChucVu.chucVuHienTaiId());
//                chucVuHienTai.setNgayBoNhiem(reqChucVu.ngayBoNhiem());
//                chucVuHienTai.setNgayBoNhiemLai(reqChucVu.ngayBoNhiemLai());
//                chucVuHienTai.setDuocQuyHoacChucDanh(reqChucVu.duocQuyHoacChucDanh());
//                chucVuHienTai.setCoQuanToChucDonViTuyenDungId(reqChucVu.coQuanToChucDonViTuyenDungId());
//                chucVuHienTai.setUpdate_at();
//            } else
//                chucVuHienTai = new ChucVuHienTai(
//                        reqChucVu.chucVuHienTaiId(),
//                        reqChucVu.ngayBoNhiem(),
//                        reqChucVu.ngayBoNhiemLai(),
//                        reqChucVu.duocQuyHoacChucDanh(),
//                        reqChucVu.coQuanToChucDonViTuyenDungId(),
//                        hoSo);
//        }
        NgachNhanVien ngach = ngachRepository.findById(hoSo.getId()).orElse(null);
        if (reqNgach != null) {
            if (ngach != null) {
                ngach.setNgachId(reqNgach.ngachId());
                ngach.setNgayBoNhiemNgach(reqNgach.ngayBoNhiemNgach());
                ngach.setNgayHuongLuongNgach(reqNgach.ngayHuongLuongNgach());
                ngach.setPhanTramHuongLuongNgach(reqNgach.phanTramHuongLuongNgach());
                ngach.setPhuCapThamNienVuotKhungNgach(reqNgach.phuCapThamNienVuotKhungNgach());
                ngach.setNgayHuongPCTNVKNgach(reqNgach.ngayHuongPCTNVKNgach());
                ngach.setUpdate_at();
            } else
                ngach = new NgachNhanVien(reqNgach.ngachId(), reqNgach.ngayBoNhiemNgach(), reqNgach.ngayHuongLuongNgach(),
                        reqNgach.phanTramHuongLuongNgach(), reqNgach.phuCapThamNienVuotKhungNgach(), reqNgach.ngayHuongPCTNVKNgach(), hoSo);
        }
        ViecLam viecLam = viecLamRepository.findById(hoSo.getId()).orElse(null);
        if (reqViecLam != null) {
            if (viecLam != null) {
                viecLam.setViTriViecLam(reqViecLam.viTriViecLamId());
                viecLam.setNgayHuongLuongTheoViTriViecLam(reqViecLam.ngayHuongLuongViTriViecLam());
                viecLam.setPhamTramHuongLuong(reqViecLam.phamTramHuongLuong());
                viecLam.setPhuCapThamNienVuotKhung(reqViecLam.phuCapThamNienVuotKhung());
                viecLam.setNgayHuongPCTNVK(reqViecLam.ngayHuongPCTNVK());
                viecLam.setUpdate_at();
            } else viecLam = new ViecLam(reqViecLam.viTriViecLamId(), reqViecLam.ngayHuongLuongViTriViecLam(),
                    reqViecLam.phamTramHuongLuong(), reqViecLam.phuCapThamNienVuotKhung(), reqViecLam.ngayHuongPCTNVK(), hoSo);
        }
        SucKhoe sucKhoe = sucKhoeRepository.findById(hoSo.getId()).orElse(null);
        if (reqSucKhoe != null) {
            if (sucKhoe != null) {
                sucKhoe.setTinhTrangSucKhoe(reqSucKhoe.tinhTrangSucKhoe());
                sucKhoe.setChieuCao(reqSucKhoe.chieuCao());
                sucKhoe.setCanNang(reqSucKhoe.canNang());
                sucKhoe.setNhomMauId(reqSucKhoe.nhomMau());
                sucKhoe.setUpdate_at();
            } else
                sucKhoe = new SucKhoe(reqSucKhoe.tinhTrangSucKhoe(), reqSucKhoe.chieuCao(), reqSucKhoe.canNang(), reqSucKhoe.nhomMau(), hoSo);
        }
//        hoSo.setHoVaTen(req.hoVaTen());
        hoSo.setGioiTinh(req.gioiTinh());
        hoSo.setCacTenGoiKhac(req.cacTenGoiKhac());
        hoSo.setSinhNgay(req.sinhNgay());
        hoSo.setNoiSinh(req.noiSinh());
        hoSo.setQueQuan(req.queQuan());
        hoSo.setDanTocId(req.danToc());
        hoSo.setTonGiaoId(req.tonGiao());
//        hoSo.setSoCCCD(req.soCCCD());
        hoSo.setNgayCapCCCD(req.ngayCapCCCD());
        hoSo.setSoDienThoai(req.soDienThoai());
        hoSo.setSoBHXH(req.soBHXH());
        hoSo.setSoBHYT(req.soBHYT());
        hoSo.setNoiOHienNay(req.noiOHienNay());
        hoSo.setThanhPhanGiaDinhId(req.thanhPhanGiaDinh());
        hoSo.setThongTinTuyenDung(thongTinTuyenDung);
        hoSo.setQuanSu(quanSu);
        hoSo.setDoiTuongChinhSachId(req.doiTuongChinhSach());
        hoSo.setHocVan(hocVan);
//        hoSo.setChucVuHienTai(chucVuHienTai);
        hoSo.setChucVuKiemNhiemId(req.chucVuKiemNhiem());
        hoSo.setChucVuDangHienTaiId(req.chucVuDangHienTai());
        hoSo.setChucVuDangKiemNhiemId(req.chucVuDangKiemNhiem());
        hoSo.setTienLuong(req.tienLuong());
        hoSo.setNgach(ngach);
        hoSo.setPhuCapChucVu(req.phuCapChucVu());
        hoSo.setPhuCapKiemNhiem(req.phuCapKiemNhiem());
        hoSo.setPhuCapKhac(req.phuCapKhac());
        hoSo.setViecLam(viecLam);
        hoSo.setSucKhoe(sucKhoe);
        hoSo.setPheDuyet(req.pheDuyet());
        hoSo.setUpdate_at();
    }
}
