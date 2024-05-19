package com.hrm.hoso_chitiet.kafka;

import com.hrm.hoso_chitiet.dto.response.ResKyLuat;
import org.apache.kafka.connect.data.Struct;

import java.nio.ByteBuffer;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.UUID;

public class ResKyLuatMapper {
//    public static Struct mapToStruct(ResKyLuat luat) {
//        // Convert JSON string to Struct with the schema
//        Struct struct = new Struct(ResKyLuatSchema.SCHEMA)
//                .put("coquan_tochuc_donvi_id", luat.coQuanQuyetDinhId())
//                .put("xac_nhan", luat.xacNhan().getId())
//                .put("bat_dau", getFromLocalDateTime(luat.batDau()))
//                .put("ket_thuc", getFromLocalDateTime(luat.ketThuc()))
//                .put("ho_so_id", uuidToBytes(luat.hoSoId()))
//                .put("hanh_vi_vi_pham_chinh", luat.hanhViViPhamChinh())
//                .put("hinh_thuc", luat.hinhThuc());
//        return struct;
//    }

    public static long getFromLocalDateTime(LocalDateTime localDateTime) {
        ZonedDateTime zdt = ZonedDateTime.of(localDateTime, ZoneId.systemDefault());
        return zdt.toInstant().toEpochMilli();
    }

//    public static Date getTimeLong(LocalDateTime localDateTime) {
//        return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
//    }

    public static byte[] uuidToBytes(UUID uuid) {
        ByteBuffer byteBuffer = ByteBuffer.wrap(new byte[16]);
        byteBuffer.putLong(uuid.getMostSignificantBits());
        byteBuffer.putLong(uuid.getLeastSignificantBits());
        return byteBuffer.array();
    }
}
