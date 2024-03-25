//package sgu.hrm.module_cauhinh.dto.response;
//
//import lombok.Builder;
//import sgu.hrm.module_cauhinh.models.NgachCongChuc;
//import sgu.hrm.module_cauhinh.models.HeSoLuongCongChuc;
//
//import java.time.LocalDateTime;
//import java.util.Optional;
//
//@Builder
//public record ResNgachCongChuc(
//        int id,
//        String ma,
//        String name,
//        float heSo,
//        String bacLuong,
//        String nhomLoaiCongChuc,
//        boolean trangThai,
//        LocalDateTime create_at,
//        LocalDateTime update_at
//) {
//    public static ResNgachCongChuc mapToResNgachCongChuc(NgachCongChuc t) {
//        return new ResNgachCongChuc(
//                t.getId(),
//                t.getMa(),
//                t.getName(),
//                Optional.ofNullable(t.getHeSoLuongCongChuc()).map(HeSoLuongCongChuc::getHeSo).orElse(0.0f),
//                t.getHeSoLuongCongChuc() != null ? t.getHeSoLuongCongChuc().getBacLuong().getName() : "",
//                t.getHeSoLuongCongChuc() != null ? t.getHeSoLuongCongChuc().getNhomCongChuc().getName() : "",
//                t.isTrangThai(),
//                t.getCreate_at(),
//                t.getUpdate_at()
//        );
//    }
//}
