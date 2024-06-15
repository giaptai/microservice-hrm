package com.hrm.hoso_chitiet.kafka;

import com.hrm.hoso_chitiet.models.QuaTrinhCongTac;
import com.hrm.hoso_chitiet.repositories.QuaTrinhCongTacRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.errors.WakeupException;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class KafkaConsumerService {
    final QuaTrinhCongTacRepository quaTrinhCongTacRepository;
    final KafkaConsumerConfig consumerConfig;

    @Async
    @EventListener(value = ApplicationReadyEvent.class)
    public void QuaTrinhCongTacListener() {
//        KafkaConsumerConfig config = new KafkaConsumerConfig("my-quatrinhcongtac-app", StringDeserializer.class.getName(), ResChucVu.ResChucVuSoDeserializer.class.getName());
        System.out.println("crush em t");
        // create consumer
        KafkaConsumer<String, ResChucVu> consumer = new KafkaConsumer<>(consumerConfig.quaTrinhCongTacProducerConfig());
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
            consumer.subscribe(List.of("qua-trinh-cong-tac"));
            // poll for new data
            while (true) {
                ConsumerRecords<String, ResChucVu> records = consumer.poll(Duration.ofMillis(1000));
                for (ConsumerRecord<String, ResChucVu> record : records) {
                    System.out.printf("""
                                    Key: %1$s
                                    Value: %2$s
                                    Partition: %3$d
                                    Offset: %4$d
                                    Timestamp: %5$s
                                    """,
                            record.key(), record.value(), record.partition(), record.offset(), record.timestamp());
                    QuaTrinhCongTac tac = new QuaTrinhCongTac(
                            record.value().ngayBoNhiem(),
                            record.value().ngayBoNhiemLai(),
                            record.value().coQuanToChucDonViTuyenDungId(),
                            record.value().duocQuyHoachChucDanh(),
                            record.value().xacNhan(),
                            record.value().hoSoId());
                    quaTrinhCongTacRepository.save(tac);
                }
            }
        } catch (WakeupException e) {
            System.err.println(e);
            // we ignore this as this is an expected exception when closing a consumer
        } catch (Exception e) {
            System.err.printf("Unexpected exception: %s\n", e);
        } finally {
            consumer.close(); // this will also commit the offsets if need be.
            System.err.printf("%s", "The consumer is now gracefully closed.");
        }
    }
}
