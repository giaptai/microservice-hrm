package hrm.module.cauhinh.services;

import hrm.module.cauhinh.dto.mapper.MapperHeSoLuongCongChuc;
import hrm.module.cauhinh.dto.mapper.MapperHeSoLuongVienChuc;
import hrm.module.cauhinh.dto.mapper.MapperNgachCongChuc;
import hrm.module.cauhinh.dto.mapper.MapperNgachVienChuc;
import hrm.module.cauhinh.dto.mapper.MapperNhomCongChuc;
import hrm.module.cauhinh.dto.mapper.MapperNhomVienChuc;
import hrm.module.cauhinh.dto.request.ReqHeSoLuong;
import hrm.module.cauhinh.dto.request.ReqLoai;
import hrm.module.cauhinh.dto.request.ReqNgach;
import hrm.module.cauhinh.dto.request.ReqNhom;

import hrm.module.cauhinh.dto.response.ResHeSoLuongCongChuc;
import hrm.module.cauhinh.dto.response.ResHeSoLuongVienChuc;
import hrm.module.cauhinh.dto.response.ResNgachCongChuc;
import hrm.module.cauhinh.dto.response.ResNgachVienChuc;
import hrm.module.cauhinh.dto.response.ResNhomCongChuc;
import hrm.module.cauhinh.dto.response.ResNhomVienChuc;
import hrm.module.cauhinh.dto.response.ResTheDTO;
import hrm.module.cauhinh.models.BacLuong;
import hrm.module.cauhinh.models.HeSoLuongCongChuc;
import hrm.module.cauhinh.models.HeSoLuongVienChuc;
import hrm.module.cauhinh.models.LoaiCongChuc;
import hrm.module.cauhinh.models.LoaiVienChuc;
import hrm.module.cauhinh.models.NgachCongChuc;
import hrm.module.cauhinh.models.NgachVienChuc;
import hrm.module.cauhinh.models.NhomCongChuc;
import hrm.module.cauhinh.models.NhomVienChuc;

import hrm.module.cauhinh.repositories.BacLuongRepository;
import hrm.module.cauhinh.repositories.HeSoLuongCongChucRepository;
import hrm.module.cauhinh.repositories.HeSoLuongVienChucRepository;
import hrm.module.cauhinh.repositories.LoaiCongChucRepository;
import hrm.module.cauhinh.repositories.LoaiVienChucRepository;
import hrm.module.cauhinh.repositories.NgachCongChucRepository;
import hrm.module.cauhinh.repositories.NgachVienChucRepository;
import hrm.module.cauhinh.repositories.NhomCongChucRepository;
import hrm.module.cauhinh.repositories.NhomVienChucRepository;

import hrm.module.cauhinh.response.ResDTO;
import hrm.module.cauhinh.response.ResEnum;

import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;


import java.util.List;

@Service
@RequiredArgsConstructor
public class LoaiNhomHeSoNgachService {
    private final BacLuongRepository bacLuongRepository;
    private final LoaiCongChucRepository loaiCongChucRepository;
    private final LoaiVienChucRepository loaiVienChucRepository;
    private final NhomCongChucRepository nhomCongChucRepository;
    private final NhomVienChucRepository nhomVienChucRepository;
    private final HeSoLuongCongChucRepository heSoLuongCongChucRepository;
    private final HeSoLuongVienChucRepository heSoLuongVienChucRepository;
    private final NgachCongChucRepository ngachCongChucRepository;
    private final NgachVienChucRepository ngachVienChucRepository;
    //mapper
    final MapperNhomCongChuc mapperNhomCongChuc;
    final MapperNhomVienChuc mapperNhomVienChuc;
    final MapperNgachCongChuc mapperNgachCongChuc;
    final MapperNgachVienChuc mapperNgachVienChuc;
    final MapperHeSoLuongCongChuc mapperHeSoLuongCongChuc;
    final MapperHeSoLuongVienChuc mapperHeSoLuongVienChuc;

    @Service
    public class LoaiCongChucService implements ILoaiNhomHeSoNgachService.ILoaiCongChucService {

        @Override
        public ResTheDTO<LoaiCongChuc> xemDanhSach(int pageNumber, int pageSize) {
            Page<LoaiCongChuc> res = loaiCongChucRepository.findAll(PageRequest.of(pageNumber, pageSize));
            long totalRecord = res.getTotalElements();
            int totalPage = res.getTotalPages();
            return new ResTheDTO<>(res.getContent(), totalRecord, totalPage);
        }

        @Override
        public LoaiCongChuc xemTheoId(int id) {
            return loaiCongChucRepository.findById(id).orElse(null);
        }

        @Override
        public LoaiCongChuc themLoaiCongChuc(ReqLoai loai) {
            try {
                LoaiCongChuc chuc = loaiCongChucRepository.findByLoai(loai.loai());
                if (chuc == null) {
                    return loaiCongChucRepository.save(new LoaiCongChuc(loai.loai(), loai.name()));
                } else throw ResDTO.error(ResEnum.TRUNG_DU_LIEU);
            } catch (RuntimeException e) {
                throw ResDTO.error(ResEnum.KHONG_HOP_LE);
            }
        }

        @Override
        public LoaiCongChuc suaLoaiCongChuc(int id, ReqLoai loai) {
            try {
                return loaiCongChucRepository.findById(id).map(e -> {
                            e.setLoai(loai.loai());
                            e.setName(loai.name());
                            e.setUpdate_at();
                            return loaiCongChucRepository.save(e);
                        }
                ).orElse(null);
            } catch (RuntimeException e) {
                throw ResDTO.error(ResEnum.KHONG_HOP_LE);
            }
        }

        @Override
        public boolean xoaLoaiCongChuc(int id) {
            try {
                return loaiCongChucRepository.findById(id).map(e -> {
                            loaiCongChucRepository.deleteById(id);
                            return true;
                        }
                ).orElse(false);
            } catch (RuntimeException e) {
                throw ResDTO.error(ResEnum.KHONG_HOP_LE);
            }
        }
    }

    @Service
    public class LoaiVienChucService implements ILoaiNhomHeSoNgachService.ILoaiVienChucService {
        @Override
        public ResTheDTO<LoaiVienChuc> xemDanhSach(int pageNumber, int pageSize) {
            Page<LoaiVienChuc> res = loaiVienChucRepository.findAll(PageRequest.of(pageNumber, pageSize));
            long totalRecord = res.getTotalElements();
            int totalPage = res.getTotalPages();
            return new ResTheDTO<>(res.getContent(), totalRecord, totalPage);
        }

        @Override
        public LoaiVienChuc xemTheoId(int id) {
            return loaiVienChucRepository.findById(id).orElse(null);
        }

        @Override
        public LoaiVienChuc themLoaiVienChuc(ReqLoai loai) {
            try {
                LoaiVienChuc chuc = loaiVienChucRepository.findByLoai(loai.loai());
                if (chuc == null) {
                    return loaiVienChucRepository.save(new LoaiVienChuc(loai.loai(), loai.name()));
                } else throw ResDTO.error(ResEnum.TRUNG_DU_LIEU);
            } catch (RuntimeException e) {
                throw ResDTO.error(ResEnum.KHONG_HOP_LE);
            }
        }

        @Override
        public LoaiVienChuc suaLoaiVienChuc(int id, ReqLoai loai) {
            try {
                return loaiVienChucRepository.findById(id).map(e -> {
                            e.setLoai(loai.loai());
                            e.setName(loai.name());
                            e.setUpdate_at();
                            return loaiVienChucRepository.save(e);
                        }
                ).orElse(null);
            } catch (RuntimeException e) {
                throw ResDTO.error(ResEnum.KHONG_HOP_LE);
            }
        }

        @Override
        public boolean xoaLoaiVienChuc(int id) {
            try {
                return loaiVienChucRepository.findById(id).map(e -> {
                            loaiVienChucRepository.deleteById(id);
                            return true;
                        }
                ).orElse(false);
            } catch (RuntimeException e) {
                throw ResDTO.error(ResEnum.KHONG_HOP_LE);
            }
        }
    }

    @Service
    public class NhomCongChucService implements ILoaiNhomHeSoNgachService.INhomCongChucService {
        @Override
        public ResTheDTO<ResNhomCongChuc> xemDanhSach(int pageNumber, int pageSize) {
            Page<NhomCongChuc> page = nhomCongChucRepository.findAll(PageRequest.of(pageNumber, pageSize));
            List<ResNhomCongChuc> res = page.getContent().stream().map(mapperNhomCongChuc::mapToResNhomCongChuc).toList();
            long totalRecord = page.getTotalElements();
            int totalPage = page.getTotalPages();
            return new ResTheDTO<>(res, totalRecord, totalPage);
        }

        @Override
        public NhomCongChuc xemTheoId(int id) {
            return nhomCongChucRepository.findById(id).orElse(null);
        }

        @Override
        public NhomCongChuc themNhomCongChuc(ReqNhom nhom) {
            try {
                LoaiCongChuc loai = loaiCongChucRepository.findById(nhom.loaiId()).orElseThrow(() -> new ResponseStatusException(ResEnum.HONG_TIM_THAY.getStatusCode()));
                NhomCongChuc chuc = nhomCongChucRepository.findByName(nhom.name());
                if (chuc == null) {
                    return nhomCongChucRepository.save(new NhomCongChuc(nhom.name(), loai));
                } else throw ResDTO.error(ResEnum.TRUNG_DU_LIEU);
            } catch (RuntimeException e) {
                throw ResDTO.error(ResEnum.KHONG_HOP_LE);
            }
        }

        @Override
        public NhomCongChuc suaNhomCongChuc(int id, ReqNhom nhom) {
            try {
                LoaiCongChuc loai = loaiCongChucRepository.findById(nhom.loaiId()).orElseThrow(() -> new ResponseStatusException(ResEnum.HONG_TIM_THAY.getStatusCode()));
                return nhomCongChucRepository.findById(id).map(e -> {
                            e.setLoaiCongChucId(loai);
                            e.setName(nhom.name());
                            e.setUpdate_at();
                            return nhomCongChucRepository.save(e);
                        }
                ).orElse(null);
            } catch (RuntimeException e) {
                throw ResDTO.error(ResEnum.KHONG_HOP_LE);
            }
        }

        @Override
        public boolean xoaNhomCongChuc(int id) {
            try {
                return nhomCongChucRepository.findById(id).map(e -> {
                            nhomCongChucRepository.deleteById(id);
                            return true;
                        }
                ).orElse(false);
            } catch (RuntimeException e) {
                throw ResDTO.error(ResEnum.KHONG_HOP_LE);
            }
        }
    }

    @Service
    public class NhomVienChucService implements ILoaiNhomHeSoNgachService.INhomVienChucService {
        @Override
        public ResTheDTO<ResNhomVienChuc> xemDanhSach(int pageNumber, int pageSize) {
            Page<NhomVienChuc> page = nhomVienChucRepository.findAll(PageRequest.of(pageNumber, pageSize));
            List<ResNhomVienChuc> res = page.getContent().stream().map(mapperNhomVienChuc::mapToResNhomVienChuc).toList();
            long totalRecord = page.getTotalElements();
            int totalPage = page.getTotalPages();
            return new ResTheDTO<>(res, totalRecord, totalPage);
        }

        @Override
        public NhomVienChuc xemTheoId(int id) {
            return nhomVienChucRepository.findById(id).orElse(null);
        }

        @Override
        public NhomVienChuc themNhomVienChuc(ReqNhom nhom) {
            try {
                LoaiVienChuc loai = loaiVienChucRepository.findById(nhom.loaiId()).orElseThrow(() -> new ResponseStatusException(ResEnum.HONG_TIM_THAY.getStatusCode()));
                NhomVienChuc vien = nhomVienChucRepository.findByName(nhom.name());
                if (vien == null) {
                    return nhomVienChucRepository.save(new NhomVienChuc(nhom.name(), loai));
                } else throw ResDTO.error(ResEnum.TRUNG_DU_LIEU);
            } catch (RuntimeException e) {
                throw ResDTO.error(ResEnum.KHONG_HOP_LE);
            }
        }

        @Override
        public NhomVienChuc suaNhomVienChuc(int id, ReqNhom nhom) {
            try {
                LoaiVienChuc loai = loaiVienChucRepository.findById(nhom.loaiId()).orElseThrow(() -> new ResponseStatusException(ResEnum.HONG_TIM_THAY.getStatusCode()));
                return nhomVienChucRepository.findById(id).map(e -> {
                            e.setLoaiVienChucId(loai);
                            e.setName(nhom.name());
                            e.setUpdate_at();
                            return nhomVienChucRepository.save(e);
                        }
                ).orElse(null);
            } catch (RuntimeException e) {
                throw ResDTO.error(ResEnum.KHONG_HOP_LE);
            }
        }

        @Override
        public boolean xoaNhomVienChuc(int id) {
            try {
                return nhomVienChucRepository.findById(id).map(e -> {
                            nhomVienChucRepository.deleteById(id);
                            return true;
                        }
                ).orElse(false);
            } catch (RuntimeException e) {
                throw ResDTO.error(ResEnum.KHONG_HOP_LE);
            }
        }
    }

    @Service
    public class HeSoLuongCongChucService implements ILoaiNhomHeSoNgachService.IHeSoLuongCongChucService {
        @Override
        public ResTheDTO<ResHeSoLuongCongChuc> xemDanhSach(int pageNumber, int pageSize) {
            Page<HeSoLuongCongChuc> page = heSoLuongCongChucRepository.findAll(PageRequest.of(pageNumber, pageSize));
            List<ResHeSoLuongCongChuc> res = page.getContent().stream().map(mapperHeSoLuongCongChuc::mapToResHeSoLuongCongChuc).toList();
            long totalRecord = page.getTotalElements();
            int totalPage = page.getTotalPages();
            return new ResTheDTO<>(res, totalRecord, totalPage);
        }

        @Override
        public HeSoLuongCongChuc xemTheoId(int id) {
            return heSoLuongCongChucRepository.findById(id).orElse(null);
        }

        @Override
        public HeSoLuongCongChuc themHeSoLuongCongChuc(ReqHeSoLuong luong) {
            try {
                NhomCongChuc nhom = nhomCongChucRepository.findById(luong.nhomId()).orElseThrow(() -> new ResponseStatusException(ResEnum.HONG_TIM_THAY.getStatusCode()));
                BacLuong bac = bacLuongRepository.findById(luong.bacLuongId()).orElseThrow(() -> new ResponseStatusException(ResEnum.HONG_TIM_THAY.getStatusCode()));
                return heSoLuongCongChucRepository.save(new HeSoLuongCongChuc(nhom, bac, luong.heSo()));
            } catch (RuntimeException e) {
                throw ResDTO.error(ResEnum.KHONG_HOP_LE);
            }
        }

        @Override
        public HeSoLuongCongChuc suaHeSoLuongCongChuc(int id, ReqHeSoLuong luong) {
            try {
                NhomCongChuc nhom = nhomCongChucRepository.findById(luong.nhomId()).orElseThrow(() -> new ResponseStatusException(ResEnum.HONG_TIM_THAY.getStatusCode()));
                BacLuong bac = bacLuongRepository.findById(luong.bacLuongId()).orElseThrow(() -> new ResponseStatusException(ResEnum.HONG_TIM_THAY.getStatusCode()));
                return heSoLuongCongChucRepository.findById(id).map(e -> {
                    e.setNhomCongChucId(nhom);
                    e.setBacLuongId(bac);
                    e.setHeSo(luong.heSo());
                    e.setUpdate_at();
                    return heSoLuongCongChucRepository.save(e);
                }).orElse(null);
            } catch (RuntimeException e) {
                throw ResDTO.error(ResEnum.KHONG_HOP_LE);
            }
        }

        @Override
        public boolean xoaHeSoLuongCongChuc(int id) {
            try {
                return heSoLuongCongChucRepository.findById(id).map(e -> {
                            heSoLuongCongChucRepository.deleteById(id);
                            return true;
                        }
                ).orElse(false);
            } catch (RuntimeException e) {
                throw ResDTO.error(ResEnum.KHONG_HOP_LE);
            }
        }
    }

    @Service
    public class HeSoLuongVienChucService implements ILoaiNhomHeSoNgachService.IHeSoLuongVienChucService {
        @Override
        public ResTheDTO<ResHeSoLuongVienChuc> xemDanhSach(int pageNumber, int pageSize) {
            Page<HeSoLuongVienChuc> page = heSoLuongVienChucRepository.findAll(PageRequest.of(pageNumber, pageSize));
            List<ResHeSoLuongVienChuc> res = page.getContent().stream().map(mapperHeSoLuongVienChuc::mapToResHeSoLuongVienChuc).toList();
            long totalRecord = page.getTotalElements();
            int totalPage = page.getTotalPages();
            return new ResTheDTO<>(res, totalRecord, totalPage);
        }

        @Override
        public HeSoLuongVienChuc xemTheoId(int id) {
            return heSoLuongVienChucRepository.findById(id).orElse(null);
        }

        @Override
        public HeSoLuongVienChuc themHeSoLuongVienChuc(ReqHeSoLuong luong) {
            try {
                NhomVienChuc nhom = nhomVienChucRepository.findById(luong.nhomId()).orElseThrow(() -> new ResponseStatusException(ResEnum.HONG_TIM_THAY.getStatusCode()));
                BacLuong bac = bacLuongRepository.findById(luong.bacLuongId()).orElseThrow(() -> new ResponseStatusException(ResEnum.HONG_TIM_THAY.getStatusCode()));
                return heSoLuongVienChucRepository.save(new HeSoLuongVienChuc(nhom, bac, luong.heSo()));
            } catch (RuntimeException e) {
                throw ResDTO.error(ResEnum.KHONG_HOP_LE);
            }
        }

        @Override
        public HeSoLuongVienChuc suaHeSoLuongVienChuc(int id, ReqHeSoLuong luong) {
            try {
                NhomVienChuc nhom = nhomVienChucRepository.findById(luong.nhomId()).orElseThrow(() -> new ResponseStatusException(ResEnum.HONG_TIM_THAY.getStatusCode()));
                BacLuong bac = bacLuongRepository.findById(luong.bacLuongId()).orElseThrow(() -> new ResponseStatusException(ResEnum.HONG_TIM_THAY.getStatusCode()));
                return heSoLuongVienChucRepository.findById(id).map(e -> {
                    e.setNhomVienChucId(nhom);
                    e.setBacLuongId(bac);
                    e.setHeSo(luong.heSo());
                    e.setUpdate_at();
                    return heSoLuongVienChucRepository.save(e);
                }).orElse(null);
            } catch (RuntimeException e) {
                throw ResDTO.error(ResEnum.KHONG_HOP_LE);
            }
        }

        @Override
        public boolean xoaHeSoLuongVienChuc(int id) {
            try {
                return heSoLuongVienChucRepository.findById(id).map(e -> {
                            heSoLuongVienChucRepository.deleteById(id);
                            return true;
                        }
                ).orElse(false);
            } catch (RuntimeException e) {
                throw ResDTO.error(ResEnum.KHONG_HOP_LE);
            }
        }
    }

    @Service
    public class NgachCongChucService implements ILoaiNhomHeSoNgachService.INgachCongChucService {
        @Override
        public ResTheDTO<ResNgachCongChuc> xemDanhSach(int pageNumber, int pageSize) {
            Page<NgachCongChuc> page = ngachCongChucRepository.findAll(PageRequest.of(pageNumber, pageSize));
            List<ResNgachCongChuc> res = page.getContent().stream().map(mapperNgachCongChuc::mapToResNgachCongChuc).toList();
            long totalRecord = page.getTotalElements();
            int totalPage = page.getTotalPages();
            return new ResTheDTO<>(res, totalRecord, totalPage);
        }

        @Override
        public NgachCongChuc xemTheoId(String id) {
            return ngachCongChucRepository.findById(id).orElse(null);
        }

        @Override
        public NgachCongChuc themNgachCongChuc(ReqNgach req) {
            try {
                HeSoLuongCongChuc heSo = heSoLuongCongChucRepository.findById(req.heSoLuongId()).orElseThrow(() -> new ResponseStatusException(ResEnum.HONG_TIM_THAY.getStatusCode()));
                NgachCongChuc ngach = ngachCongChucRepository.findByName(req.name());
                if (ngach == null) {
                    return ngachCongChucRepository.save(new NgachCongChuc(req.ma(), req.name(), heSo));
                } else throw ResDTO.error(ResEnum.TRUNG_DU_LIEU);
            } catch (RuntimeException e) {
                throw ResDTO.error(ResEnum.KHONG_HOP_LE);
            }
        }

        @Override
        public NgachCongChuc suaNgachCongChuc(String id, ReqNgach req) {
            try {
                HeSoLuongCongChuc heSo = heSoLuongCongChucRepository.findById(req.heSoLuongId()).orElseThrow(() -> new ResponseStatusException(ResEnum.HONG_TIM_THAY.getStatusCode()));
                return ngachCongChucRepository.findById(id).map(e -> {
                    e.setMa(req.ma());
                    e.setName(req.name());
                    e.setHeSoLuongCongChucId(heSo);
                    e.setUpdate_at();
                    return ngachCongChucRepository.save(e);
                }).orElse(null);
            } catch (RuntimeException e) {
                throw ResDTO.error(ResEnum.KHONG_HOP_LE);
            }
        }

        @Override
        public boolean xoaNgachCongChuc(String id) {
            try {
                return ngachCongChucRepository.findById(id).map(e -> {
                    ngachCongChucRepository.deleteById(id);
                    return true;
                }).orElse(false);
            } catch (RuntimeException e) {
                throw ResDTO.error(ResEnum.KHONG_HOP_LE);
            }
        }
    }

    @Service
    public class NgachVienChucService implements ILoaiNhomHeSoNgachService.INgachVienChucService {
        @Override
        public ResTheDTO<ResNgachVienChuc> xemDanhSach(int pageNumber, int pageSize) {
            Page<NgachVienChuc> page = ngachVienChucRepository.findAll(PageRequest.of(pageNumber, pageSize));
            List<ResNgachVienChuc> res = page.getContent().stream().map(mapperNgachVienChuc::mapToResNgachVienChuc).toList();
            long totalRecord = page.getTotalElements();
            int totalPage = page.getTotalPages();
            return new ResTheDTO<>(res, totalRecord, totalPage);
        }

        @Override
        public NgachVienChuc xemTheoId(String id) {
            return ngachVienChucRepository.findById(id).orElse(null);
        }

        @Override
        public NgachVienChuc themNgachVienChuc(ReqNgach req) {
            try {
                HeSoLuongVienChuc heSo = heSoLuongVienChucRepository.findById(req.heSoLuongId()).orElseThrow(() -> new ResponseStatusException(ResEnum.HONG_TIM_THAY.getStatusCode()));
                NgachVienChuc vien = ngachVienChucRepository.findByName(req.name());
                if (vien == null) {
                    return ngachVienChucRepository.save(new NgachVienChuc(req.ma(), req.name(), heSo));
                } else throw ResDTO.error(ResEnum.TRUNG_DU_LIEU);
            } catch (RuntimeException e) {
                throw ResDTO.error(ResEnum.KHONG_HOP_LE);
            }
        }

        @Override
        public NgachVienChuc suaNgachVienChuc(String id, ReqNgach req) {
            try {
                HeSoLuongVienChuc heSo = heSoLuongVienChucRepository.findById(req.heSoLuongId()).orElseThrow(() -> new ResponseStatusException(ResEnum.HONG_TIM_THAY.getStatusCode()));
                return ngachVienChucRepository.findById(id).map(e -> {
                    e.setMa(req.ma());
                    e.setName(req.name());
                    e.setHeSoLuongVienChucId(heSo);
                    e.setUpdate_at();
                    return ngachVienChucRepository.save(e);
                }).orElse(null);
            } catch (RuntimeException e) {
                throw ResDTO.error(ResEnum.KHONG_HOP_LE);
            }
        }

        @Override
        public boolean xoaNgachVienChuc(String id) {
            try {
                return ngachVienChucRepository.findById(id).map(e -> {
                    ngachVienChucRepository.deleteById(id);
                    return true;
                }).orElse(false);
            } catch (RuntimeException e) {
                throw ResDTO.error(ResEnum.KHONG_HOP_LE);
            }
        }
    }
}
