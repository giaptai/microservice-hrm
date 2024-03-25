package hrm.module.cauhinh.dto.request;

public record ReqUtilities(
        String name,
        int loaiQuanHamQuanDoi,
        int nhomChucDanhDang,
        int capNhomChucDanhDang,
        int bacLuong,
        int boCoQuan,
        int donVi,
        double tienLuong
) {
}
