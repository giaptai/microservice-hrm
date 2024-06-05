package com.hrm.hoso.kafka;

import com.hrm.hoso.dto.request.ReqTaoHoSo;
import com.hrm.hoso.enums.PheDuyet;
import com.hrm.hoso.models.HoSo;
import com.hrm.hoso.repository.HoSoRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.TopicPartition;
import org.apache.kafka.common.errors.WakeupException;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.apache.kafka.connect.source.SourceConnector;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class KafkaService {
    final HoSoRepository hoSoRepository;
    final HoSoConsumer hoSoConsumer;

    @Async
    @EventListener(value = ApplicationReadyEvent.class)
    protected void HoSoListener() {
        System.out.println("crush em t");
        // create consumer
        KafkaConsumer<String, ReqTaoHoSo> consumer = new KafkaConsumer<>(hoSoConsumer.getProperties());
        // get a reference to the current thread
        final Thread mainThread = Thread.currentThread();
        // adding the shutdown hook
        Runtime.getRuntime().addShutdownHook(new Thread() {
            public void run() {
                System.err.println("Detected a shutdown, let's exit by calling consumer.wakeup()...");
                consumer.wakeup();
                // join the main thread to allow the execution of the code in the main thread
                try {
                    mainThread.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        try {
            // subscribe consumer to our topic(s)
            consumer.subscribe(List.of("hoso_create"));
//            Collection<TopicPartition> partitions = consumer.partitionsFor("hoso_create").stream();
            // poll for new data
//            boolean flag = true;
            while (true) {
                ConsumerRecords<String, ReqTaoHoSo> records = consumer.poll(Duration.ofMillis(100));
                for (ConsumerRecord<String, ReqTaoHoSo> record : records) {
                    System.out.printf("""
                                    Key: %s
                                    Value: %s
                                    Partition: %d
                                    Offset: %d
                                    Timestamp: %5$tD ,%5$tT
                                    """,
                            record.key(), record.value(), record.partition(), record.offset(), record.timestamp());
                    HoSo hoSo = HoSo.builder()
                            .hoVaTen(record.value().hoVaTen())
                            .soCCCD(record.value().soCCCD())
                            .taiKhoanId(record.value().taiKhoan())
                            .pheDuyet(PheDuyet.CHO_PHE_DUYET)
                            .createAt(LocalDateTime.now())
                            .build();
                    hoSoRepository.save(hoSo);
//                    if(record.offset() > 0){
//                        flag = false;
//                    }
                }
            }
        } catch (WakeupException e) {
            System.err.println(e);
            // we ignore this as this is an expected exception when closing a consumer
        } catch (Exception e) {
            System.err.printf("Unexpected exception: %s", e);
        } finally {
            consumer.close(); // this will also commit the offsets if need be.
            System.err.printf("%s", "The consumer is now gracefully closed.");
        }
    }
}
