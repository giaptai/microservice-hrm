package com.hrm.hoso_chitiet.kafka;

import com.hrm.hoso_chitiet.dto.mapper.MapperKhenThuong;
import com.hrm.hoso_chitiet.dto.mapper.MapperKyLuat;
import com.hrm.hoso_chitiet.dto.response.ResKhenThuong;
import com.hrm.hoso_chitiet.dto.response.ResKyLuat;
import com.hrm.hoso_chitiet.repositories.KhenThuongRepository;
import com.hrm.hoso_chitiet.repositories.KyLuatRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@EnableScheduling
public class KafkaProducerService {
    final KyLuatRepository kyLuatRepository;
    final KhenThuongRepository khenThuongRepository;
    //mapper
    final MapperKyLuat mapperKyLuat;
    final MapperKhenThuong mapperKhenThuong;
    //producer kafka
    private KafkaProducerConfig kafkaProducerConfig;

    @Async
    @Scheduled(fixedRate = 3_600_000)
    protected void showKyLuat() {
        List<ResKyLuat> kyLuats = kyLuatRepository.getAllByHoSoInLast7Days().stream().map(mapperKyLuat::mapToResKyLuat).toList();
        System.out.println(kyLuats.size());
        kafkaProducerConfig = new KafkaProducerConfig(StringSerializer.class.getName(), ResKyLuat.ResKyLuatSerializer.class.getName());
        // create the producer
        KafkaProducer<String, List<ResKyLuat>> producer = new KafkaProducer<>(kafkaProducerConfig.getProperties());
        // create a producer record
        ProducerRecord<String, List<ResKyLuat>> producerRecord = new ProducerRecord<>("ky_luat", kyLuats);
        // send data - asynchronous
        producer.send(producerRecord, new Callback() {
            @Override
            public void onCompletion(RecordMetadata metadata, Exception e) {
                if (e == null) {
                    System.out.printf("""
                                    Received new metadata
                                    "Topic: %s
                                    Size: %d
                                    Partition: %s
                                    Offset: %s
                                    Timestamp: %s
                                    """,
                            metadata.topic(),
                            kyLuats.size(),
                            metadata.partition(),
                            metadata.offset(),
                            metadata.timestamp());
                }
            }
        });
        // flush data - synchronous
        producer.flush();
        // flush and close producer
        producer.close();
    }
    @Async
    @Scheduled(fixedRate = 1_000)
    protected void showKhenThuong() {
        List<ResKhenThuong> khenThuongs = khenThuongRepository.getAllByHoSoInLast7Days().stream().map(mapperKhenThuong::maptoResKhenThuong).toList();
        System.out.println(khenThuongs.size());
//        kafkaProducerConfig = new KafkaProducerConfig(StringSerializer.class.getName(), ResKhenThuong.ResKhenThuongSerializer.class.getName());
        kafkaProducerConfig = new KafkaProducerConfig(StringSerializer.class.getName(), StringSerializer.class.getName());
        // create the producer
//        KafkaProducer<String, List<ResKhenThuong>> producer = new KafkaProducer<>(kafkaProducerConfig.getProperties());
        KafkaProducer<String, String> producer = new KafkaProducer<>(kafkaProducerConfig.getProperties());
        // create a producer record
        ProducerRecord<String, String> producerRecord = new ProducerRecord<>("khen_thuong", khenThuongs.toString());
        // send data - asynchronous
        producer.send(producerRecord, new Callback() {
            @Override
            public void onCompletion(RecordMetadata metadata, Exception e) {
                if (e == null) {
                    System.out.printf("""
                                    Received new metadata
                                    "Topic: %s
                                    Size: %d
                                    Partition: %s
                                    Offset: %s
                                    Timestamp: %s
                                    """,
                            metadata.topic(),
                            khenThuongs.size(),
                            metadata.partition(),
                            metadata.offset(),
                            metadata.timestamp());
                }
            }
        });
        // flush data - synchronous
        producer.flush();
        // flush and close producer
        producer.close();
    }
}
