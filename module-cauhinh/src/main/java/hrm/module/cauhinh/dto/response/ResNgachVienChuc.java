//package sgu.hrm.module_cauhinh.dto.response;
//
//import lombok.Builder;
//import sgu.hrm.module_cauhinh.models.NgachVienChuc;
//import sgu.hrm.module_cauhinh.models.HeSoLuongVienChuc;
//
//import java.time.LocalDateTime;
//import java.util.Optional;
//
//@Builder
//public record ResNgachVienChuc(
//        int id,
//        String ma,
//        String name,
//        float heSo,
//        String bacLuong,
//        String nhomLoaiVienChuc,
//        boolean trangThai,
//        LocalDateTime create_at,
//        LocalDateTime update_at
//) {
//    public static ResNgachVienChuc mapToResNgachVienChuc(NgachVienChuc v) {
//        return new ResNgachVienChuc(
//                v.getId(),
//                v.getMa(),
//                v.getName(),
//                Optional.ofNullable(v.getHeSoLuongVienChuc()).map(HeSoLuongVienChuc::getHeSo).orElse(0.0f),
//                v.getHeSoLuongVienChuc() != null ? v.getHeSoLuongVienChuc().getBacLuong().getName() : "",
//                v.getHeSoLuongVienChuc() != null ? v.getHeSoLuongVienChuc().getNhomVienChuc().getName() : "",
//                v.isTrangThai(),
//                v.getCreate_at(),
//                v.getUpdate_at()
//        );
//    }
//}
