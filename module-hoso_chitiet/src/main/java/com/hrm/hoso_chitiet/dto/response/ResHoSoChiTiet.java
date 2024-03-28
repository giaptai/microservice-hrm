package com.hrm.hoso_chitiet.dto.response;

import com.hrm.hoso_chitiet.models.LamViecChoCheDoCu;
import com.hrm.hoso_chitiet.models.KhenThuong;
import com.hrm.hoso_chitiet.models.KienThucAnNinhQuocPhong;
import com.hrm.hoso_chitiet.models.KyLuat;
import com.hrm.hoso_chitiet.models.LamViecONuocNgoai;
import com.hrm.hoso_chitiet.models.LuongBanThan;
import com.hrm.hoso_chitiet.models.LyLuanChinhTri;
import com.hrm.hoso_chitiet.models.NghiepVuChuyenNganh;
import com.hrm.hoso_chitiet.models.NgoaiNgu;
import com.hrm.hoso_chitiet.models.PhuCapKhac;
import com.hrm.hoso_chitiet.models.QuaTrinhCongTac;
import com.hrm.hoso_chitiet.models.QuanHeGiaDinh;
import com.hrm.hoso_chitiet.models.TinHoc;

import java.util.List;

public record ResHoSoChiTiet(
        List<LamViecChoCheDoCu> lamViecChoCheDoCuses,
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
}
