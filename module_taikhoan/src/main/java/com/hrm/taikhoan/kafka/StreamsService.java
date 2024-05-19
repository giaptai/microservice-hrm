package com.hrm.taikhoan.kafka;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hrm.taikhoan.models.TaiKhoan;
import com.hrm.taikhoan.repository.TaiKhoanRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.Topology;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.KTable;
import org.apache.kafka.streams.kstream.Produced;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class StreamsService {
//    final TaiKhoanStreamConfig streamConfig;
//    final StreamsBuilder builder;
//    KStream<String, String> source;
//    final ObjectMapper objectMapper = new ObjectMapper();
//    @Bean
//    public KafkaStreams taiKhoanStreams() {
//        source = builder.stream("tai_khoan");
//        Topology topology = builder.build();
//        try {
//            KafkaStreams streams = new KafkaStreams(topology, streamConfig.taiKhoanStreamsConfig());
//            streams.start();
//            KStream<String, String> processedStream = source.mapValues(value -> {
//                try {
//                    JsonNode rootNode = objectMapper.readTree(value);
//                    JsonNode payloadNode = rootNode.get("payload").get("email");
//                    System.err.println(payloadNode.asText());
//                    return payloadNode.asText();
//                } catch (Exception e) {
//                    System.err.println("Failed to process record: " + e.getMessage());
//                    return null;
//                }
//            });
//            processedStream.to("send_mail", Produced.with(Serdes.String(), Serdes.String()));
//            Runtime.getRuntime().addShutdownHook(new Thread(streams::close));
//            return streams;
//        } catch (RuntimeException e) {
//            System.err.println(e.getMessage());
//            throw e;
//        }
//    }
}
