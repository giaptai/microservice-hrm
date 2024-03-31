package com.hrm.taikhoan.dto.client.ho_so;

import com.hrm.taikhoan.dto.client.ho_so.HoSoDTO;
import com.hrm.taikhoan.dto.client.khen_thuong.KhenThuongDTO;
import com.hrm.taikhoan.dto.client.kien_thuc_an_ninh_quoc_phong.KienThucAnNinhQuocPhongDTO;
import com.hrm.taikhoan.dto.client.ky_luat.KyLuatDTO;
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
import com.hrm.taikhoan.enums.GioiTinh;
import com.hrm.taikhoan.enums.PheDuyet;
import lombok.Builder;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Builder
public record HoSoChiTietDTO(
        UUID id,
        String hovaten,
        GioiTinh gioiTinh,
        String cacTenGoiKhac,
        LocalDateTime sinhNgay,
        String noiSinh,
        String queQuan,
        int danToc,
        int tonGiao,
        String soCCCD,
        LocalDateTime ngayCapCCCD,
        String soDienThoai,
        String soBHXH,
        String soBHYT,
        String noiOHienNay,
        int thanhPhanGiaDinh,
        ThongTinTuyenDungDTO thongTinTuyenDung,
        QuanSuDTO quanSu,
        int doiTuongChinhSach,
        HocVanDTO hocVan,
        ChucVuDTO chucVu,
        int chucVuKiemNhiem,
        int chucVuDangHienTai,
        int chucVuDangKiemNhiem,
        double tienLuong,
        NgachNhanVienDTO ngach,
        double phuCapChucVu,
        double phuCapKiemNhiem,
        double phuCapKhac,
        ViecLamDTO viecLam,
        SucKhoeDTO sucKhoe,
        List<LamViecChoCheDoCuDTO> banThanCoLamViecChoCheDoCus,
        List<KhenThuongDTO> khenThuongs,
        List<KienThucAnNinhQuocPhongDTO> kienThucAnNinhQuocPhongs,
        List<KyLuatDTO> kyLuats,
        List<LamViecONuocNgoaiDTO> lamViecONuocNgoais,
        List<LuongBanThanDTO> luongBanThans,
        List<LyLuanChinhTriDTO> lyLuanChinhTris,
        List<NghiepVuChuyenNganhDTO> nghiepVuChuyenNganhs,
        List<NgoaiNguDTO> ngoaiNgus,
        List<PhuCapKhacDTO> phuCapKhacs,
        List<QuanHeGiaDinhDTO> quanHeGiaDinhs,
        List<QuaTrinhCongTacDTO> quaTrinhCongTacs,
        List<TinHocDTO> tinHocs,
        int taiKhoan,
        PheDuyet pheDuyet,
        LocalDateTime create_at,
        LocalDateTime update_at
) {
}
