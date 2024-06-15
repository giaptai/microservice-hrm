package com.hrm.hoso_chitiet.dto.mapper;

import com.hrm.hoso_chitiet.dto.request.ReqKyLuat;
import com.hrm.hoso_chitiet.enums.XacNhan;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.apache.kafka.connect.data.Schema;
import org.apache.kafka.connect.data.SchemaBuilder;
import org.apache.kafka.connect.data.Struct;
import org.apache.kafka.connect.data.Timestamp;
import org.springframework.context.annotation.Configuration;

import java.time.ZoneId;
import java.util.Date;
import java.util.UUID;

import static com.hrm.hoso_chitiet.kafka.ResKyLuatMapper.uuidToBytes;

@Configuration
@RequiredArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class MapperStructKyLuat {
    final String COQUAN_TOCHUC_DONVI = "coquan_tochuc_donvi_id";
    final String XAC_NHAN = "xac_nhan";
    final String BAT_DAU = "bat_dau";
    final String KET_THUC = "ket_thuc";
    final String HO_SO_ID = "ho_so_id";
    final String HANH_VI_VI_PHAM_CHINH = "hanh_vi_vi_pham_chinh";
    final String HINH_THUC = "hinh_thuc";

    final Schema schema = SchemaBuilder.struct()
            .field(COQUAN_TOCHUC_DONVI, Schema.OPTIONAL_INT32_SCHEMA)
            .field(XAC_NHAN, Schema.OPTIONAL_INT8_SCHEMA)
            .field(BAT_DAU, Timestamp.builder())
            .field(KET_THUC, Timestamp.builder())
            .field(HO_SO_ID, Schema.OPTIONAL_BYTES_SCHEMA)
            .field(HANH_VI_VI_PHAM_CHINH, Schema.OPTIONAL_STRING_SCHEMA)
            .field(HINH_THUC, Schema.OPTIONAL_STRING_SCHEMA)
            .build();

    Struct struct;

    public Struct formatStruct(UUID uuid, ReqKyLuat c) {
        // Create the struct with the actual message data
        this.struct = new Struct(schema)
                .put(COQUAN_TOCHUC_DONVI, c.coQuanQuyetDinhId())
                .put(XAC_NHAN, (byte) (XacNhan.DA_PHE_DUYET.getId()))
                .put(BAT_DAU, Date.from(c.batDau().atZone(ZoneId.systemDefault()).toInstant()))
                .put(KET_THUC, Date.from(c.ketThuc().atZone(ZoneId.systemDefault()).toInstant()))
                .put(HO_SO_ID, uuidToBytes(uuid))
                .put(HANH_VI_VI_PHAM_CHINH, c.hanhViViPhamChinh())
                .put(HINH_THUC, c.hinhThuc());
        return this.struct;
    }
}
