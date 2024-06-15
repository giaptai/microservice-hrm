//package com.hrm.hoso_chitiet.dto.request;
//
//import lombok.Getter;
//import lombok.Setter;
//import lombok.experimental.SuperBuilder;
//import org.apache.kafka.connect.data.Schema;
//import org.apache.kafka.connect.data.SchemaBuilder;
//import org.apache.kafka.connect.data.Struct;
//import org.apache.kafka.connect.data.Timestamp;
//
//import java.time.LocalDateTime;
//
//@SuperBuilder
//@Getter
//@Setter
//public class ReqKyLuatS {
//    final String COQUAN_TOCHUC_DONVI = "coquan_tochuc_donvi_id";
//    final String XAC_NHAN = "xac_nhan";
//    final String BAT_DAU = "bat_dau";
//    final String KET_THUC = "ket_thuc";
//    final String HO_SO_ID = "ho_so_id";
//    final String HANH_VI_VI_PHAM_CHINH = "hanh_vi_vi_pham_chinh";
//    final String HINH_THUC = "hinh_thuc";
//
//    final Schema schema = SchemaBuilder.struct()
//            .field(COQUAN_TOCHUC_DONVI, Schema.OPTIONAL_INT32_SCHEMA)
//            .field(XAC_NHAN, Schema.OPTIONAL_INT8_SCHEMA)
//            .field(BAT_DAU, Timestamp.builder())
//            .field(KET_THUC, Timestamp.builder())
//            .field(HO_SO_ID, Schema.OPTIONAL_BYTES_SCHEMA)
//            .field(HANH_VI_VI_PHAM_CHINH, Schema.OPTIONAL_STRING_SCHEMA)
//            .field(HINH_THUC, Schema.OPTIONAL_STRING_SCHEMA)
//            .build();
//
//    private LocalDateTime batDau;
//    private LocalDateTime ketThuc;
//    private String hinhThuc;
//    private String hanhViViPhamChinh;
//    private int coQuanQuyetDinhId;
//
//}
