package com.hrm.hoso.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.hrm.hoso.client.qua_trinh_cong_tac.QuaTrinhCongTacClient;
import com.hrm.hoso.client.qua_trinh_cong_tac.ReqQuaTrinhCongTac;
import com.hrm.hoso.client.qua_trinh_cong_tac.ResQuaTrinhCongTac;
import com.hrm.hoso.dto.mapper.MapperChucVuHienTai;
import com.hrm.hoso.dto.mapper.MapperHoSo;
import com.hrm.hoso.dto.mapper.MapperHoSoTomTat;
import com.hrm.hoso.dto.request.ReqChucVu;
import com.hrm.hoso.dto.request.ReqChucVuKiemNhiem;
import com.hrm.hoso.dto.request.ReqHocVan;
import com.hrm.hoso.dto.request.ReqNgachNhanVien;
import com.hrm.hoso.dto.request.ReqQuanSu;
import com.hrm.hoso.dto.request.ReqSucKhoe;
import com.hrm.hoso.dto.request.ReqTaoHoSo;
import com.hrm.hoso.dto.request.ReqThongTinTuyenDung;
import com.hrm.hoso.dto.request.ReqViecLam;
import com.hrm.hoso.dto.response.ResChucVu;
import com.hrm.hoso.dto.response.ResChucVuKiemNhiem;
import com.hrm.hoso.dto.response.ResHoSo;

import com.hrm.hoso.dto.response.ResHoSoTomTat;
import com.hrm.hoso.dto.response.ResListHoSo;
import com.hrm.hoso.dto.response.ResNgachNhanVien;
import com.hrm.hoso.dto.response.ResViecLam;
import com.hrm.hoso.enums.PheDuyet;

import com.hrm.hoso.dto.request.ReqHoSo;

import com.hrm.hoso.kafka.KafkaConfig;
import com.hrm.hoso.models.ChucVuHienTai;
import com.hrm.hoso.models.ChucVuKiemNhiem;
import com.hrm.hoso.models.HoSo;
import com.hrm.hoso.models.HocVan;
import com.hrm.hoso.models.NgachNhanVien;
import com.hrm.hoso.models.NghiaVuQuanSu;
import com.hrm.hoso.models.SucKhoe;
import com.hrm.hoso.models.ThongTinTuyenDung;
import com.hrm.hoso.models.ViecLam;

import com.hrm.hoso.repository.ChucVuHienTaiRepository;
import com.hrm.hoso.repository.ChucVuKiemNhiemRepository;
import com.hrm.hoso.repository.HocVanRepository;
import com.hrm.hoso.repository.NgachRepository;
import com.hrm.hoso.repository.NghiaVuQuanSuRepository;
import com.hrm.hoso.repository.HoSoRepository;
import com.hrm.hoso.repository.SucKhoeRepository;
import com.hrm.hoso.repository.ThongTinTuyenDungRepository;
import com.hrm.hoso.repository.ViecLamRepository;

import com.hrm.hoso.response.ResEnum;

import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.JoinType;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.core.io.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Service
@RequiredArgsConstructor // tự tạo constructor với filed là final hoặc annotation not null
@FieldDefaults(level = AccessLevel.PRIVATE)
public class HoSoService implements IHoSoService {
    final HoSoRepository hoSoRepository;
    final ChucVuHienTaiRepository chucVuHienTaiRepository;
    final ChucVuKiemNhiemRepository chucVuKiemNhiemRepository;
    final HocVanRepository hocVanRepository;
    final NgachRepository ngachRepository;
    final NghiaVuQuanSuRepository nghiaVuQuanSuRepository;
    final SucKhoeRepository sucKhoeRepository;
    final ThongTinTuyenDungRepository thongTinTuyenDungRepository;
    final ViecLamRepository viecLamRepository;
    //mapper
    final MapperHoSo mapperHoSo;
    final MapperChucVuHienTai mapperChucVuHienTai;
    final MapperHoSoTomTat mapperHoSoTomTat;
    //criticizable
    final EntityManager entityManager;
    //client
    final QuaTrinhCongTacClient quaTrinhCongTacClient;


    @Override
    public ResHoSoTomTat layHoSoId(int taiKhoanId) {
        HoSo hoSo = hoSoRepository.findByTaiKhoanId(taiKhoanId).orElseThrow(() -> new ResponseStatusException(ResEnum.HONG_TIM_THAY.getCode()));
        return mapperHoSoTomTat.mapToResHoSoTomTat(hoSo);
    }

    @Override
    public boolean checkHoSoCCCD(String soCCCD) {
        return hoSoRepository.findBySoCCCD(soCCCD) > 0;
    }

    @Override
    public ResHoSo taoHoSo(ReqTaoHoSo req) {
        HoSo hoSo = HoSo.builder()
                .hoVaTen(req.hoVaTen())
                .soCCCD(req.soCCCD())
                .taiKhoanId(req.taiKhoan())
                .pheDuyet(PheDuyet.CHO_PHE_DUYET)
                .createAt(LocalDateTime.now())
                .build();
        hoSoRepository.save(hoSo);
        return mapperHoSo.mapToResHoSo(hoSo);
    }

    @Override
    public ResListHoSo xemDanhSachHoSo(String soCCCD, String hoVaTen, int danTocId, int chucVuHienTaiId, int coQuanToChucDonViId, PheDuyet pheDuyet, String byDate, int pageNumber, int pageSize) {
        if (soCCCD != null && !soCCCD.isEmpty()) {
            ResHoSo hoSo = xemHoSoTheoSoCCCD(soCCCD);
            return new ResListHoSo(Collections.singletonList(hoSo), 1, 1);
        }
        if (hoVaTen != null || danTocId != -1 || chucVuHienTaiId != -1 || coQuanToChucDonViId != -1 || pheDuyet != null) {
            return locHoSo(hoVaTen, danTocId, chucVuHienTaiId, coQuanToChucDonViId, pheDuyet, byDate, pageNumber, pageSize);
        }
        Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.by(Sort.Direction.DESC, byDate));
        Page<HoSo> hoSoPage = hoSoRepository.findAll(pageable);
        List<ResHoSo> resHoSos = hoSoPage.stream().map(mapperHoSo::mapToResHoSo).toList();
        long totalRecord = hoSoPage.getTotalElements();
        int totalPage = hoSoPage.getTotalPages();
        return new ResListHoSo(resHoSos, totalRecord, totalPage);
    }

    private ResHoSo xemHoSoTheoSoCCCD(String q) {
        HoSo hoSo = hoSoRepository.findFirstBySoCCCD(q).orElseThrow(() -> new ResponseStatusException(ResEnum.HONG_TIM_THAY.getCode()));
//            Pattern UUID_REGEX = Pattern.compile("^[0-9a-fA-F]{8}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{12}$");
//            if (UUID_REGEX.matcher(q).matches()) {
//                resHoSoId = hoSoRepository.findById(UUID.fromString(q)).orElse(null);
//            }
        return mapperHoSo.mapToResHoSo(hoSo);
    }

    private ResListHoSo locHoSo(String hoVaTen, int danTocId, int chucVuHienTaiId, int coQuanToChucDonViId, PheDuyet pheDuyet, String byDate, int pageNumber, int pageSize) {
        // Initialize Criteria Builders
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();

        // Create Queries
        CriteriaQuery<HoSo> query = builder.createQuery(HoSo.class);
        CriteriaQuery<Long> countQuery = builder.createQuery(Long.class);

        // Set Roots
        Root<HoSo> root = query.from(HoSo.class);
        Root<HoSo> countRoot = countQuery.from(HoSo.class);

        // Initialize Predicates
        List<Predicate> predicates = new ArrayList<>();
        List<Predicate> countPredicates = new ArrayList<>();

        // Join Relations
        Join<HoSo, ChucVuHienTai> join = root.join("chucVuHienTai", JoinType.LEFT);
        Join<HoSo, ChucVuHienTai> countJoin = countRoot.join("chucVuHienTai", JoinType.LEFT);

        // Add Conditions
        if (hoVaTen != null && !hoVaTen.isEmpty()) {
            String hoVaTenLower = "%" + hoVaTen.toLowerCase() + "%";
            predicates.add(builder.like(builder.lower(root.get("hoVaTen")), hoVaTenLower));
            countPredicates.add(builder.like(builder.lower(countJoin.get("hoVaTen")), hoVaTenLower));
        }
        if (danTocId > 0) {
            predicates.add(builder.equal(root.get("danTocId"), danTocId));
            countPredicates.add(builder.equal(countJoin.get("danTocId"), danTocId));

//            Predicate danTocPredicate = builder.equal(root.get("danTocId"), danTocId);
//            Predicate danTocCountPredicate = builder.equal(countJoin.get("danTocId"), danTocId); //count

//            predicates = (predicates != null) ? builder.and(predicates, danTocPredicate) : danTocPredicate;
//            countPredicate = (countPredicate != null) ? builder.and(countPredicate, danTocCountPredicate) : danTocCountPredicate; //count
        }
        if (chucVuHienTaiId > 0) {
            predicates.add(builder.equal(join.get("chucVuId"), chucVuHienTaiId));
            countPredicates.add(builder.equal(countJoin.get("chucVuId"), chucVuHienTaiId));
        }
        if (coQuanToChucDonViId > 0) {
            predicates.add(builder.equal(join.get("coQuanToChucDonViTuyenDungId"), coQuanToChucDonViId));
            countPredicates.add(builder.equal(countJoin.get("coQuanToChucDonViTuyenDungId"), coQuanToChucDonViId));
        }
        if (pheDuyet != null) {
            predicates.add(builder.equal(root.get("pheDuyet"), pheDuyet));
            countPredicates.add(builder.equal(countRoot.get("pheDuyet"), pheDuyet));
        }

        // Apply Predicates
        if (!predicates.isEmpty()) {
            query.where(builder.and(predicates.toArray(new Predicate[0])));
            countQuery.select(builder.count(countRoot)).where(builder.and(countPredicates.toArray(new Predicate[0])));
        } else {
            countQuery.select(builder.count(countRoot));
        }

        // Get Total Records and Pages
        long totalRecord = entityManager.createQuery(countQuery).getSingleResult();
        int totalPage = (int) Math.ceil((double) totalRecord / pageSize);

        // Apply Ordering
        if (byDate != null) {
            query.orderBy(builder.desc(root.get(byDate)));
        }

        // Execute Query with Pagination
        List<HoSo> hoSos = entityManager.createQuery(query)
                .setFirstResult(pageNumber * pageSize)
                .setMaxResults(pageSize)
                .getResultList();

        // Map Results
        List<ResHoSo> resHoSos = hoSos.stream().map(mapperHoSo::mapToResHoSo).toList();

        // Return Results
        return new ResListHoSo(resHoSos, totalRecord, totalPage);
    }

    /*
        private ResListHoSo locHoSo(String hoVaTen, int danTocId, int chucVuHienTaiId, int coQuanToChucDonViId, PheDuyet pheDuyet, String byDate, int pageNumber, int pageSize) {
            //JPA Criteria API
            // Initialize Criteria Builders
            CriteriaBuilder builder = entityManager.getCriteriaBuilder();
            CriteriaBuilder countBuilder = entityManager.getCriteriaBuilder(); //count

            // Create Queries
            CriteriaQuery<HoSo> query = builder.createQuery(HoSo.class);
            CriteriaQuery<Long> countQuery = countBuilder.createQuery(Long.class); //count

            // Set Roots
            Root<HoSo> root = query.from(HoSo.class);
            Root<HoSo> countRoot = countQuery.from(HoSo.class); //count

            // Initialize Predicate
            Predicate predicate = null;
            Predicate countPredicate = null; //count

            // Join Relations
            Join<HoSo, ChucVuHienTai> join = root.join("chucVuHienTai", JoinType.LEFT);
            Join<HoSo, ChucVuHienTai> countJoin = countRoot.join("chucVuHienTai", JoinType.LEFT); //count

            if (hoVaTen != null && !hoVaTen.isEmpty()) {
                String lowHoVaTen = "%" + hoVaTen.toLowerCase() + "%";
                predicate = builder.like(builder.lower(root.get("hoVaTen")), lowHoVaTen);
                countPredicate = builder.like(builder.lower(countJoin.get("hoVaTen")), lowHoVaTen); //count
            }
            if (danTocId > 0) {
                Predicate danTocPredicate = builder.equal(root.get("danTocId"), danTocId);
                Predicate danTocCountPredicate = builder.equal(countJoin.get("danTocId"), danTocId); //count

                predicate = (predicate != null) ? builder.and(predicate, danTocPredicate) : danTocPredicate;
                countPredicate = (countPredicate != null) ? builder.and(countPredicate, danTocCountPredicate) : danTocCountPredicate; //count
            }
            if (chucVuHienTaiId > 0) {
                Predicate chucVuPredicate = builder.equal(join.get("chucVuId"), chucVuHienTaiId);
                Predicate chucVuCountPredicate = builder.equal(countJoin.get("chucVuId"), chucVuHienTaiId); //count

                predicate = (predicate != null) ? builder.and(predicate, chucVuPredicate) : chucVuPredicate;
                countPredicate = (countPredicate != null) ? builder.and(countPredicate, chucVuCountPredicate) : chucVuCountPredicate; //count
            }
            if (coQuanToChucDonViId > 0) {
                Predicate coQuanPredicate = builder.equal(join.get("coQuanToChucDonViTuyenDungId"), coQuanToChucDonViId);
                Predicate coQuanCountPredicate = builder.equal(countJoin.get("coQuanToChucDonViTuyenDungId"), coQuanToChucDonViId); //count


                predicate = (predicate != null) ? builder.and(predicate, coQuanPredicate) : coQuanPredicate;
                countPredicate = (countPredicate != null) ? builder.and(countPredicate, coQuanCountPredicate) : coQuanCountPredicate; //count
            }
            if (pheDuyet != null) {
                Predicate pheDuyetPredicate = builder.equal(root.get("pheDuyet"), pheDuyet);
                Predicate pheDuyetCountPredicate = builder.equal(countRoot.get("pheDuyet"), pheDuyet); //count


                predicate = (predicate != null) ? builder.and(predicate, pheDuyetPredicate) : pheDuyetPredicate;
                countPredicate = (countPredicate != null) ? builder.and(countPredicate, pheDuyetCountPredicate) : pheDuyetCountPredicate; //count
            }
            if (predicate != null) {
                query.where(predicate);
            }
            if (countPredicate != null) {
                countQuery.select(countBuilder.count(countRoot)).where(countPredicate); //count
            }
            long totalRecord = entityManager.createQuery(countQuery).getSingleResult();
            int totalPage = Math.round(((float) totalRecord / pageSize));
            // Apply order by
            if (byDate != null) {
                query.orderBy(builder.desc(root.get(byDate)));
            }
            List<HoSo> hoSos = entityManager.createQuery(query)
                    .setFirstResult(pageNumber * pageSize)
                    .setMaxResults(pageSize)
                    .getResultList();
            List<ResHoSo> resHoSos = hoSos.stream().map(mapperHoSo::mapToResHoSo).toList();
            return new ResListHoSo(resHoSos, totalRecord, totalPage);
        }
    */
//    @Override
//    public ResHoSo capNhatHoSoCCVC(UUID id, String req, MultipartFile anh) {
//        try {
//            HoSo hoSo = hoSoRepository.findById(id).orElseThrow(() -> new ResponseStatusException(ResEnum.HONG_TIM_THAY.getCode()));
//            //https://howtodoinjava.com/gson/gson-typeadapter-for-inaccessibleobjectexception/
//            Gson gson = new GsonBuilder().registerTypeAdapter(LocalDateTime.class, new LocalDateTimeTypeAdapter()).create();
//            ReqHoSo json = gson.fromJson(req, ReqHoSo.class);
//            mapToHoSo(hoSo, json); //chuyen tu json thanh model HoSo
//            Path path = Paths.get("module-hoso/src/main/uploads");
////            File file = new File(path.toString());
////            if (!file.exists()) {
////                if (file.mkdirs()) {
////                    System.out.println("Create folder successfully");
////                } else System.out.println("Create folder failed");
////            }
//            if (!Files.exists(path)) {
//                Files.createDirectories(path);
//            }
//            if (anh.getSize() <= 5_242_880 && Objects.equals(anh.getContentType(), "image/png")) {
//                Resource res = anh.getResource();
//                // Lấy tên gốc của file
//                String nameAnh = anh.getOriginalFilename();
//                nameAnh = hoSo.getHoVaTen();
//                // Xác định đường dẫn đích trong thư mục "uploads"
//                Path destinationPath = path.resolve(nameAnh);
//                Files.copy(anh.getInputStream(), destinationPath, StandardCopyOption.REPLACE_EXISTING);
//            } else throw new IllegalArgumentException("File size exceeds 5 MB limit.\n" + "File is not image/png type");
//            hoSoRepository.save(hoSo);
//            return mapperHoSo.mapToResHoSo(hoSo);
//        } catch (IOException e) {
//            System.err.println(e.getMessage());
//            return null;
//        } catch (RuntimeException e) {
//            System.err.println(e.getMessage());
//            throw e;
//        }
//    }
    @Override
    public ResHoSo capNhatHoSoCCVC(UUID id, ReqHoSo req) {
        try {
            HoSo hoSo = hoSoRepository.findById(id).orElseThrow(() -> new ResponseStatusException(ResEnum.HONG_TIM_THAY.getCode()));
            mapToHoSo(hoSo, req);
            hoSoRepository.save(hoSo);
            return mapperHoSo.mapToResHoSo(hoSo);
        } catch (RuntimeException e) {
            System.err.println(e.getMessage());
            throw e;
        }
    }

    @Override
    public ResChucVu capNhatChucVuHienTai(UUID id, ReqChucVu reqChucVu) {
        HoSo hoSo = hoSoRepository.findById(id).orElseThrow(() -> new ResponseStatusException(ResEnum.HONG_TIM_THAY.getCode()));
        ChucVuHienTai chucVuHienTai = chucVuHienTaiRepository.findById(hoSo.getId()).orElse(null);
        if (reqChucVu != null) {
            if (chucVuHienTai != null) {
                chucVuHienTai.setChucVuId(reqChucVu.chucVuHienTaiId());
                chucVuHienTai.setNgayBoNhiem(reqChucVu.ngayBoNhiem());
                chucVuHienTai.setNgayBoNhiemLai(reqChucVu.ngayBoNhiemLai());
                chucVuHienTai.setDuocQuyHoacChucDanh(reqChucVu.duocQuyHoacChucDanh());
                chucVuHienTai.setPhuCapChucVu(reqChucVu.phuCapChucVu());
                chucVuHienTai.setCoQuanToChucDonViTuyenDungId(reqChucVu.coQuanToChucDonViTuyenDungId());
                chucVuHienTai.setUpdate_at();
            } else {
                chucVuHienTai = new ChucVuHienTai(
                        reqChucVu.chucVuHienTaiId(),
                        reqChucVu.ngayBoNhiem(),
                        reqChucVu.ngayBoNhiemLai(),
                        reqChucVu.duocQuyHoacChucDanh(),
                        reqChucVu.phuCapChucVu(),
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
    public ResChucVu capNhatChucVuHienTaiApi(UUID id, ReqChucVu reqChucVu) {
        HoSo hoSo = hoSoRepository.findById(id).orElseThrow(() -> new ResponseStatusException(ResEnum.HONG_TIM_THAY.getCode()));
        ChucVuHienTai chucVuHienTai = chucVuHienTaiRepository.findById(hoSo.getId()).orElse(null);
        ResQuaTrinhCongTac tac = null;
        ResChucVu resChucVu = null;
        if (reqChucVu != null) {
            if (chucVuHienTai != null) {
                chucVuHienTai.setChucVuId(reqChucVu.chucVuHienTaiId());
                chucVuHienTai.setNgayBoNhiem(reqChucVu.ngayBoNhiem());
                chucVuHienTai.setNgayBoNhiemLai(reqChucVu.ngayBoNhiemLai());
                chucVuHienTai.setDuocQuyHoacChucDanh(reqChucVu.duocQuyHoacChucDanh());
                chucVuHienTai.setPhuCapChucVu(reqChucVu.phuCapChucVu());
                chucVuHienTai.setCoQuanToChucDonViTuyenDungId(reqChucVu.coQuanToChucDonViTuyenDungId());
                chucVuHienTai.setUpdate_at();
            } else {
                chucVuHienTai = new ChucVuHienTai(
                        reqChucVu.chucVuHienTaiId(),
                        reqChucVu.ngayBoNhiem(),
                        reqChucVu.ngayBoNhiemLai(),
                        reqChucVu.duocQuyHoacChucDanh(),
                        reqChucVu.phuCapChucVu(),
                        reqChucVu.coQuanToChucDonViTuyenDungId(),
                        hoSo);
            }
            tac = quaTrinhCongTacClient.add(id, new ReqQuaTrinhCongTac(reqChucVu.ngayBoNhiem(), reqChucVu.ngayBoNhiemLai(), reqChucVu.coQuanToChucDonViTuyenDungId(), reqChucVu.duocQuyHoacChucDanh()));
        }
        if (tac == null) {
            throw new ResponseStatusException(ResEnum.KHONG_HOP_LE.getCode());
        }
        chucVuHienTaiRepository.save(chucVuHienTai);
        resChucVu = mapperChucVuHienTai.mapToResChucVu(chucVuHienTai);
        return resChucVu;

    }

    @Override
    public ResHoSo xemHoSoTheoId(UUID id) {
        HoSo hoSo = hoSoRepository.findById(id).orElseThrow(() -> new ResponseStatusException(ResEnum.HONG_TIM_THAY.getCode()));
        return mapperHoSo.mapToResHoSo(hoSo);
    }

    @Override
    public boolean pheDuyetHoSo(PheDuyet pheDuyet, List<ResHoSo> resHoSos) {
        try {
            List<HoSo> hoSos = new ArrayList<>();
            for (ResHoSo resHoSo : resHoSos) {
                HoSo hoSo = hoSoRepository.findById(resHoSo.id()).orElseThrow(() -> new ResponseStatusException(ResEnum.HONG_TIM_THAY.getCode()));
                hoSo.setPheDuyet(pheDuyet);
                hoSo.setUpdate_at();
                hoSos.add(hoSo);
            }
            hoSoRepository.saveAll(hoSos);
            return true;
        } catch (RuntimeException e) {
            System.err.println(e.getMessage());
            throw e;
        }
    }

    @Override
    public ResHoSo xemHoSoCaNhan(int taiKhoanId) {
        HoSo hoSo = hoSoRepository.findByTaiKhoanId(taiKhoanId).orElseThrow(() -> new ResponseStatusException(ResEnum.HONG_TIM_THAY.getCode()));
//        return xemHoSoTheoId(hoSo.getId());
        return mapperHoSo.mapToResHoSo(hoSo);
    }

    @Override
    public ResHoSo capNhatHoSoCaNhan(int taiKhoanId, ReqHoSo reqHoSo) {
        HoSo hoSo = hoSoRepository.findByTaiKhoanId(taiKhoanId).orElseThrow(() -> new ResponseStatusException(ResEnum.HONG_TIM_THAY.getCode()));
        return capNhatHoSoCCVC(hoSo.getId(), reqHoSo);
    }

//    private double tinhLuong(ResHoSo hoSo) {
//        ResChucVu chucVu = hoSo.chucVu();
//        ResChucVuKiemNhiem kiemNhiem = hoSo.chucVuKiemNhiem();
//        ResNgachNhanVien ngach = hoSo.ngach();
//        ResViecLam viecLam = hoSo.viecLam();
//        double phuCapChucVu = chucVu.phuCapChucVu();
//        double phuCapKiemNhiem = kiemNhiem.phuCapKiemNhiem();
//        double phuCapKhac = kiemNhiem.phuCapKhac();
//        float heSoNgach = ngach.heSo();
//        float phanTramNgach = ngach.phanTramHuongLuongNgach();
//        double phuCapNgach = ngach.phuCapThamNienVuotKhungNgach();
//        double luongCoBan = 1_800_000;
//        float phanTramViecLam = viecLam.phamTramHuongLuong();
//        double phuCapViecLam = viecLam.phuCapThamNienVuotKhung();
//        double luongViecLam = viecLam.tienLuong();
//        double tienLuongNhan = (phuCapChucVu + phuCapKiemNhiem + phuCapKhac) +
//                (heSoNgach * phanTramNgach * luongCoBan + phuCapNgach) +
//                (phanTramViecLam * luongViecLam + phuCapViecLam);
//        return tienLuongNhan;
//    }

    private void mapToHoSo(HoSo hoSo, ReqHoSo req) {
        ReqThongTinTuyenDung tuyenDung = req.thongTinTuyenDung();
        ReqQuanSu reqQuanSu = req.quanSu();
        ReqHocVan reqHocVan = req.hocVan();
        ReqChucVu reqChucVu = req.chucVu();
        ReqChucVuKiemNhiem reqChucVuKiemNhiem = req.chucVuKiemNhiem();
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
        ChucVuKiemNhiem chucVuKiemNhiem = chucVuKiemNhiemRepository.findById(hoSo.getId()).orElse(null);
        if (reqChucVuKiemNhiem != null) {
            if (chucVuKiemNhiem != null) {
                chucVuKiemNhiem.setChucVuId(reqChucVuKiemNhiem.chucVuKiemNhiemId());
                chucVuKiemNhiem.setNgayBoNhiem(reqChucVuKiemNhiem.ngayBoNhiem());
                chucVuKiemNhiem.setPhuCapKiemNhiem(reqChucVuKiemNhiem.phuCapKiemNhiem());
                chucVuKiemNhiem.setPhuCapKhac(reqChucVuKiemNhiem.phuCapKhac());
                chucVuKiemNhiem.setUpdate_at();
            } else
                chucVuKiemNhiem = new ChucVuKiemNhiem(
                        reqChucVuKiemNhiem.chucVuKiemNhiemId(),
                        reqChucVuKiemNhiem.ngayBoNhiem(),
                        reqChucVuKiemNhiem.phuCapKiemNhiem(),
                        reqChucVuKiemNhiem.phuCapKhac(),
                        hoSo);
        }
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
//        hoSo.setChucVuKiemNhiemId(req.chucVuKiemNhiem());
        hoSo.setChucVuKiemNhiem(chucVuKiemNhiem);
        hoSo.setChucVuDangHienTaiId(req.chucVuDangHienTai());
        hoSo.setChucVuDangKiemNhiemId(req.chucVuDangKiemNhiem());
        hoSo.setTienLuong(req.tienLuong());
        hoSo.setNgach(ngach);
//        hoSo.setPhuCapChucVu(req.phuCapChucVu());
//        hoSo.setPhuCapKiemNhiem(req.phuCapKiemNhiem());
//        hoSo.setPhuCapKhac(req.phuCapKhac());
        hoSo.setViecLam(viecLam);
        hoSo.setSucKhoe(sucKhoe);
        hoSo.setPheDuyet(req.pheDuyet());
        hoSo.setUpdate_at();
    }
}
