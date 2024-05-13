//package com.hrm.hoso_chitiet.kafka;
//
//import com.hrm.hoso_chitiet.dto.mapper.MapperKhenThuong;
//import com.hrm.hoso_chitiet.dto.response.ResKhenThuong;
//import com.hrm.hoso_chitiet.models.KhenThuong;
//import com.hrm.hoso_chitiet.repositories.KhenThuongRepository;
//import lombok.AccessLevel;
//import lombok.RequiredArgsConstructor;
//import lombok.experimental.FieldDefaults;
//import org.apache.kafka.clients.CommonClientConfigs;
//import org.apache.kafka.clients.producer.KafkaProducer;
//import org.apache.kafka.clients.producer.ProducerRecord;
//import org.apache.kafka.common.config.SaslConfigs;
//import org.apache.kafka.connect.data.Schema;
//import org.apache.kafka.connect.source.SourceRecord;
//import org.apache.kafka.connect.source.SourceTask;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.scheduling.annotation.Scheduled;
//import org.springframework.stereotype.Component;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//@Service
//@FieldDefaults(level = AccessLevel.PRIVATE)
//public class MySqlSourceTask extends SourceTask {
//    final KhenThuongRepository khenThuongRepository;
//    final MapperKhenThuong mapperKhenThuong;
//    public MySqlSourceTask(KhenThuongRepository khenThuongRepository, MapperKhenThuong mapperKhenThuong) {
//        this.khenThuongRepository = khenThuongRepository;
//        this.mapperKhenThuong = mapperKhenThuong;
//    }
//
//    @Override
//    public String version() {
//        return "1.0";
//    }
//
//    @Override
//    public void start(Map<String, String> props) {
//
//    }
//
//    @Override
//    public List<SourceRecord> poll() throws InterruptedException {
//        List<ResKhenThuong> khenThuongs = khenThuongRepository.getAllByHoSoInLast7Days().stream().map(mapperKhenThuong::maptoResKhenThuong).toList();
//        List<SourceRecord> records = new ArrayList<>();
//        try {
//            for (ResKhenThuong khenThuong : khenThuongs) {
//                Map<String, Object> sourcePartition = new HashMap<>();
//                Map<String, Object> sourceOffset = new HashMap<>();
//                // Tạo SourceRecord với dữ liệu từ khenThuong
//                SourceRecord record = new SourceRecord(sourcePartition, sourceOffset, "khen_thuong", Schema.STRING_SCHEMA, khenThuong.toString());
//                records.add(record);
//            }
//            return records;
//        }catch (Exception e){
//            e.printStackTrace();
//            throw new InterruptedException();
//        }
//    }
//
//    @Override
//    public void stop() {}
//}
