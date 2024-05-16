package com.hrm.hoso_chitiet.kafka;

import com.hrm.hoso_chitiet.dto.mapper.MapperStructKyLuat;
import com.hrm.hoso_chitiet.dto.request.ReqKyLuat;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.connect.data.Struct;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class KafkaProducerService {
    //producer kafka
    final KafkaProducerConfig kafkaProducerConfig;
    //mapper
    final MapperStructKyLuat structKyLuat;

    public void addKyLuatConnect(UUID uuid, ReqKyLuat c) {
        KafkaProducer<String, Struct> producer = new KafkaProducer<>(kafkaProducerConfig.KyLuatProducerConfig());
        Struct struct = structKyLuat.formatStruct(uuid, c);
        ProducerRecord<String, Struct> producerRecord = new ProducerRecord<>("ky_luat", uuid.toString(), struct);
        // send data - asynchronous
        producer.send(producerRecord, (metadata, e) -> {
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
                        1,
                        metadata.partition(),
                        metadata.offset(),
                        metadata.timestamp());
            }
        });
        // flush data - synchronous
        producer.flush();
        // flush and close producer
        producer.close();
    }

//    @Async
//    @Scheduled(fixedDelay = 3_000, initialDelay = 1_000)
//    protected void showKhenThuong() {
//        System.err.println("curhs em T ok em");
//        Map<String, String> pros = new HashMap<>();
//        connector.start(pros);
//        connector.taskClass();
//        connector.stop();
//        List<ResKhenThuong> khenThuongs = khenThuongRepository.getAllByHoSoInLast7Days().stream().map(mapperKhenThuong::maptoResKhenThuong).toList();
//        System.out.println(khenThuongs.size());
////        kafkaProducerConfig = new KafkaProducerConfig(StringSerializer.class.getName(), ResKhenThuong.ResKhenThuongSerializer.class.getName());
//        // create the producer
//        KafkaProducer<String, String> producer = new KafkaProducer<>(kafkaProducerConfig.KhenThuongProducerConfig());
//        // create a producer record
//        ProducerRecord<String, String> producerRecord = new ProducerRecord<>("khen_thuong", khenThuongs.toString());
//        // send data - asynchronous
//        producer.send(producerRecord, new Callback() {
//            @Override
//            public void onCompletion(RecordMetadata metadata, Exception e) {
//                if (e == null) {
//                    // Date and time formatting can be done very easily using the printf method. You use a two-letter format,
//                    // starting with t and ending in one of the letters of the table as shown in the following code.
//                    System.out.printf("""
//                                    Received new metadata
//                                    "Topic: %s
//                                    Size: %d
//                                    Partition: %s
//                                    Offset: %s
//                                    Timestamp: %5$td/%5$tm/%5$tY, %5$tH:%5$tM:%5$tS
//                                    """,
//                            metadata.topic(),
//                            khenThuongs.size(),
//                            metadata.partition(),
//                            metadata.offset(),
//                            metadata.timestamp());
//                }
//            }
//        });
//        // flush data - synchronous
//        producer.flush();
//        // flush and close producer
//        producer.close();
//    }
}
