//package sgu.hrm.module_utilities.models.response;
//
//import sgu.hrm.module_utilities.models.CapBacLoaiQuanHamQuanDoi;
//import sgu.hrm.module_utilities.models.CapNhomChucDanhDang;
//import sgu.hrm.module_utilities.models.LoaiQuanHamQuanDoi;
//import sgu.hrm.module_utilities.models.NhomChucDanhDang;
//
//import java.time.LocalDateTime;
//import java.util.Optional;
//
//public record ResCapNhomChucDanhDang(
//        int id,
//        String name,
//        String nhomChucDanhDang,
//        LocalDateTime create_at,
//        LocalDateTime update_at
//) {
//    public static ResCapNhomChucDanhDang mapToResCapNhomChucDanhDang(CapNhomChucDanhDang dang) {
//        return dang != null ? new ResCapNhomChucDanhDang(
//                dang.getId(),
//                dang.getName(),
//                Optional.ofNullable(dang.getNhomChucDanhDang()).map(NhomChucDanhDang::getName).orElse(null),
//                dang.getCreate_at(),
//                dang.getUpdate_at()
//        ) : null;
//    }
//}
