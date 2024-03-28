package com.hrm.taikhoan.dto.client;

import com.hrm.taikhoan.dto.client.khen_thuong.KhenThuongDTO;
import com.hrm.taikhoan.dto.client.kien_thuc_an_ninh_quoc_phong.KienThucAnNinhQuocPhongDTO;
import com.hrm.taikhoan.dto.client.ky_luat.KyLuatDTO;
import com.hrm.taikhoan.dto.client.lam_viec_cho_che_do_cu.LamViecChoCheDoCu;
import com.hrm.taikhoan.dto.client.lam_viec_cho_che_do_cu.LamViecChoCheDoCuDTO;
import com.hrm.taikhoan.dto.client.lam_viec_o_nuoc_ngoai.LamViecONuocNgoaiDTO;
import com.hrm.taikhoan.dto.client.luong_ban_than.LuongBanThanDTO;
import com.hrm.taikhoan.dto.client.ly_luan_chinh_tri.LyLuanChinhTriDTO;
import com.hrm.taikhoan.dto.client.nghiep_vu_chuyen_nganh.NghiepVuChuyenNganhDTO;
import com.hrm.taikhoan.dto.client.ngoai_ngu.NgoaiNguDTO;
import com.hrm.taikhoan.dto.client.phu_cap_khac.PhuCapKhacDTO;
import com.hrm.taikhoan.dto.client.qua_trinh_cong_tac.QuaTrinhCongTacDTO;
import com.hrm.taikhoan.dto.client.quan_he_gia_dinh.QuanHeGiaDinhDTO;
import com.hrm.taikhoan.dto.client.tin_hoc.TinHocDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.UUID;

@FeignClient(name = "ho-so-chi-tiet", url = "${moduleUrl.ho-so-chi-tiet}")
public interface HoSoChiTietClient {
    @GetMapping(value = "/ho-so/{id}/lam-viec-cho-che-do-cu")
    List<LamViecChoCheDoCuDTO> getByBanThanCoLamViecChoCheDoCu(@PathVariable UUID id);
    @GetMapping(value = "/lam-viec-cho-che-do-cu")
    List<LamViecChoCheDoCu> getAllBanThanCoLamViecChoCheDoCu();
    @GetMapping(value = "/ho-so/{id}/khen-thuong")
    List<KhenThuongDTO> getByKhenThuong(@PathVariable UUID id);
    @GetMapping(value = "/ho-so/{id}/kien-thuc-an-ninh-quoc-phong")
    List<KienThucAnNinhQuocPhongDTO> getByKienThucAnNinhQuocPhong(@PathVariable UUID id);
    @GetMapping(value = "/ho-so/{id}/ky-luat")
    List<KyLuatDTO> getByKyLuat(@PathVariable UUID id);
    @GetMapping(value = "/ho-so/{id}/lam-viec-o-nuoc-ngoai")
    List<LamViecONuocNgoaiDTO> getByLamViecONuocNgoai(@PathVariable UUID id);
    @GetMapping(value = "/ho-so/{id}/luong-ban-than")
    List<LuongBanThanDTO> getByLuongBanThan(@PathVariable UUID id);
    @GetMapping(value = "/ho-so/{id}/ly-luan-chinh-tri")
    List<LyLuanChinhTriDTO> getByLyLuanChinhTri(@PathVariable UUID id);
    @GetMapping(value = "/ho-so/{id}/nghiep-vu-chuyen-nganh")
    List<NghiepVuChuyenNganhDTO> getByNghiepVuChuyenNganh(@PathVariable UUID id);
    @GetMapping(value = "/ho-so/{id}/ngoai-ngu")
    List<NgoaiNguDTO> getByNgoaiNgu(@PathVariable UUID id);
    @GetMapping(value = "/ho-so/{id}/phu-cap-khac")
    List<PhuCapKhacDTO> getByPhuCapKhac(@PathVariable UUID id);
    @GetMapping(value = "/ho-so/{id}/quan-he-gia-dinh")
    List<QuanHeGiaDinhDTO> getByQuanHeGiaDinh(@PathVariable UUID id);
    @GetMapping(value = "/ho-so/{id}/qua-trinh-cong-tac")
    List<QuaTrinhCongTacDTO> getByQuaTrinhCongTac(@PathVariable UUID id);
    @GetMapping(value = "/ho-so/{id}/tin-hoc")
    List<TinHocDTO> getByTinHoc(@PathVariable UUID id);
}
