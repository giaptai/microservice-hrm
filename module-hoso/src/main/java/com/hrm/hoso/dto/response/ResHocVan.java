package com.hrm.hoso.dto.response;

public record ResHocVan(
        int trinhDoGiaoDucPhoThong, //TrinhDoGiaoDucPhoThong trinhDoGiaoDucPhoThong,
        String trinhDoGiaoDucPhoThongName,
        int trinhDoChuyenMon, //TrinhDoChuyenMon trinhDoChuyenMon,
        String trinhDoChuyenMonName,
        int hocHam, //HocHam hocHam,
        String hocHamName,
        int danhHieuNhaNuocPhongTang, //DanhHieuNhaNuocPhongTang danhHieuNhaNuocPhongTang,
        String danhHieuNhaNuocPhongTangName
) {

}
