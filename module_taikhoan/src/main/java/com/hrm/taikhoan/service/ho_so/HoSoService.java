package com.hrm.taikhoan.service.ho_so;

import com.hrm.taikhoan.dto.client.lam_viec_cho_che_do_cu.LamViecChoCheDoCuDTO;
import com.hrm.taikhoan.dto.client.HoSoChiTietClient;
import com.hrm.taikhoan.dto.client.ho_so.HoSoChiTietDTO;
import com.hrm.taikhoan.dto.client.ho_so.HoSoDTO;
import com.hrm.taikhoan.dto.client.ho_so.HoSoClient;
import com.hrm.taikhoan.dto.client.khen_thuong.KhenThuongDTO;
import com.hrm.taikhoan.dto.client.kien_thuc_an_ninh_quoc_phong.KienThucAnNinhQuocPhongDTO;
import com.hrm.taikhoan.dto.client.ky_luat.KyLuatDTO;
import com.hrm.taikhoan.dto.client.lam_viec_o_nuoc_ngoai.LamViecONuocNgoaiDTO;
import com.hrm.taikhoan.dto.client.luong_ban_than.LuongBanThanDTO;
import com.hrm.taikhoan.dto.client.ly_luan_chinh_tri.LyLuanChinhTriDTO;
import com.hrm.taikhoan.dto.client.nghiep_vu_chuyen_nganh.NghiepVuChuyenNganhDTO;
import com.hrm.taikhoan.dto.client.ngoai_ngu.NgoaiNguDTO;
import com.hrm.taikhoan.dto.client.phu_cap_khac.PhuCapKhacDTO;
import com.hrm.taikhoan.dto.client.qua_trinh_cong_tac.QuaTrinhCongTacDTO;
import com.hrm.taikhoan.dto.client.quan_he_gia_dinh.QuanHeGiaDinhDTO;
import com.hrm.taikhoan.dto.client.ho_so.ReqHoSoDTO;
import com.hrm.taikhoan.dto.client.tin_hoc.TinHocDTO;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class HoSoService implements IHoSoService {
    final HoSoClient hoSoClient;
    final HoSoChiTietClient chiTietClient;

    @Override
    public List<HoSoDTO> getAllHoSo() {
        return hoSoClient.getAllHoSo();
    }

    @Override
    public HoSoChiTietDTO getByHoSoId(UUID id) {
        HoSoDTO hoSo = hoSoClient.getById(id);
        List<LamViecChoCheDoCuDTO> cheDoCus = chiTietClient.getByBanThanCoLamViecChoCheDoCu(id);
        List<KhenThuongDTO> khenThuongs = chiTietClient.getByKhenThuong(id);
        List<KienThucAnNinhQuocPhongDTO> kienThucAnNinhQuocPhongs = chiTietClient.getByKienThucAnNinhQuocPhong(id);
        List<KyLuatDTO> kyLuats = chiTietClient.getByKyLuat(id);
        List<LamViecONuocNgoaiDTO> lamViecONuocNgoais = chiTietClient.getByLamViecONuocNgoai(id);
        List<LuongBanThanDTO> luongBanThans = chiTietClient.getByLuongBanThan(id);
        List<LyLuanChinhTriDTO> lyLuanChinhTris = chiTietClient.getByLyLuanChinhTri(id);
        List<NghiepVuChuyenNganhDTO> nghiepVuChuyenNganhs = chiTietClient.getByNghiepVuChuyenNganh(id);
        List<NgoaiNguDTO> ngoaiNgus = chiTietClient.getByNgoaiNgu(id);
        List<PhuCapKhacDTO> phuCapKhacs = chiTietClient.getByPhuCapKhac(id);
        List<QuanHeGiaDinhDTO> quanHeGiaDinhs = chiTietClient.getByQuanHeGiaDinh(id);
        List<QuaTrinhCongTacDTO> quaTrinhCongTacs = chiTietClient.getByQuaTrinhCongTac(id);
        List<TinHocDTO> tinHocs = chiTietClient.getByTinHoc(id);
        return new HoSoChiTietDTO(
                hoSo.id(),
                hoSo.hovaten(),
                hoSo.gioiTinh(),
                hoSo.cacTenGoiKhac(),
                hoSo.sinhNgay(),
                hoSo.noiSinh(),
                hoSo.queQuan(),
                hoSo.danToc(),
                hoSo.tonGiao(),
                hoSo.soCCCD(),
                hoSo.ngayCapCCCD(),
                hoSo.soDienThoai(),
                hoSo.soBHXH(),
                hoSo.soBHYT(),
                hoSo.noiOHienNay(),
                hoSo.thanhPhanGiaDinh(),
                hoSo.thongTinTuyenDung(),
                hoSo.quanSu(),
                hoSo.doiTuongChinhSach(),
                hoSo.hocVan(),
                hoSo.chucVu(),
                hoSo.chucVuKiemNhiem(),
                hoSo.chucVuDangHienTai(),
                hoSo.chucVuDangKiemNhiem(),
                hoSo.tienLuong(),
                hoSo.ngach(),
                hoSo.phuCapChucVu(),
                hoSo.phuCapKiemNhiem(),
                hoSo.phuCapKhac(),
                hoSo.viecLam(),
                hoSo.sucKhoe(),
                cheDoCus,
                khenThuongs,
                kienThucAnNinhQuocPhongs,
                kyLuats,
                lamViecONuocNgoais,
                luongBanThans,
                lyLuanChinhTris,
                nghiepVuChuyenNganhs,
                ngoaiNgus,
                phuCapKhacs,
                quanHeGiaDinhs,
                quaTrinhCongTacs,
                tinHocs,
                hoSo.taiKhoan(),
                hoSo.pheDuyet(),
                hoSo.create_at(),
                hoSo.update_at()
        );
    }

    @Override
    public HoSoDTO editHoSoById(UUID id, ReqHoSoDTO req) {
        return hoSoClient.editHoSoById(id, req);
    }

    @Override
    public String findHoSo() {
        return null;
    }
}
