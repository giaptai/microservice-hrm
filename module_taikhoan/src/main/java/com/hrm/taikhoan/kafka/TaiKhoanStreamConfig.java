package com.hrm.taikhoan.kafka;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hrm.taikhoan.dto.resopnse.QuenMatKhau;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.apache.kafka.clients.CommonClientConfigs;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.config.SaslConfigs;
import org.apache.kafka.common.errors.TimeoutException;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.Topology;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.Produced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

@Configuration
@Getter
@Setter
@RequiredArgsConstructor
public class TaiKhoanStreamConfig {
    private final String BOOTSTRAP_SERVER = "localhost:9092,localhost:9094,localhost:9096";
    //    StreamsBuilder builder = new StreamsBuilder();;
//    KStream<String, String> source;
    final ObjectMapper objectMapper = new ObjectMapper();
//    @Bean
//    public Properties taiKhoanStreamsConfig() {
//        Properties proTK = new Properties();
//        proTK.setProperty(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, BOOTSTRAP_SERVER);
//        proTK.setProperty(StreamsConfig.APPLICATION_ID_CONFIG, "tai_khoan_id");
//        proTK.setProperty(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.String().getClass().getName());
//        proTK.setProperty(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, Serdes.String().getClass().getName());
//        proTK.put(CommonClientConfigs.SECURITY_PROTOCOL_CONFIG, "SASL_PLAINTEXT");
//        proTK.put(SaslConfigs.SASL_MECHANISM, "PLAIN");
//        proTK.put(SaslConfigs.SASL_JAAS_CONFIG, "org.apache.kafka.common.security.plain.PlainLoginModule required username=\"admin\" password=\"admin-secret\";");
//        return proTK;
//    }

    //    @Async
    @Bean
    public KafkaStreams taiKhoanStreams() {
        Properties proTK = new Properties();
        proTK.setProperty(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, BOOTSTRAP_SERVER);
        proTK.setProperty(StreamsConfig.APPLICATION_ID_CONFIG, "tai_khoan_id");
        proTK.setProperty(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.String().getClass().getName());
        proTK.setProperty(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, Serdes.String().getClass().getName());
        proTK.setProperty(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "latest");
        proTK.setProperty(CommonClientConfigs.SECURITY_PROTOCOL_CONFIG, "SASL_PLAINTEXT");
        proTK.setProperty(SaslConfigs.SASL_MECHANISM, "PLAIN");
        proTK.setProperty(SaslConfigs.SASL_JAAS_CONFIG, "org.apache.kafka.common.security.plain.PlainLoginModule required username=\"admin\" password=\"admin-secret\";");
        StreamsBuilder builder = new StreamsBuilder();
        KStream<String, String> source = builder.stream("tai_khoan");
        KStream<String, String> processedStream = source.mapValues(value -> {
            try {
                JsonNode rootNode = objectMapper.readTree(value);
                JsonNode payload = rootNode.get("payload");
                JsonNode nodeEmail = payload.get("email");
                JsonNode nodeUsername = payload.get("username");
                JsonNode nodePass = payload.get("password");
                // Kiểm tra nếu nodeEmail không phải là null hoặc không rỗng
                if (!nodeEmail.asText().equals("null")) {
                    //return 3 properties: email, username, pass
                    QuenMatKhau matKhau = new QuenMatKhau(nodeEmail.asText(), nodeUsername.asText(), nodePass.asText());
                    return matKhau.toString();
                } else {
                    // Nếu nodeEmail là null hoặc rỗng, không xử lý và trả về null
                    return null;
                }
            } catch (Exception e) {
                System.err.println("Failed to process record: " + e.getMessage());
                return null;
            }
        });
        processedStream.filter((key, value) -> value != null).to("send_mail", Produced.with(Serdes.String(), Serdes.String()));
        Topology topology = builder.build();
        // cach thu 2 dung Thread hoac Runnable
        KafkaStreams streams = new KafkaStreams(topology, proTK);
        new Thread(() -> {
            try {
                streams.start();
                Runtime.getRuntime().addShutdownHook(new Thread(streams::close));
            } catch (TimeoutException e) {
                System.err.println("Timeout while starting Kafka Streams: " + e.getMessage());
                throw e;
            } catch (RuntimeException e) {
                System.err.println("Error while starting Kafka Streams: " + e.getMessage());
                throw e;
            }
        }).start();
//        RUNNABLE
//        Runnable kafkaStreamsTask = () -> {
//            try {
//                streams.start();
//                Runtime.getRuntime().addShutdownHook(new Thread(streams::close));
//            } catch (TimeoutException e) {
//                System.err.println("Timeout while starting Kafka Streams: " + e.getMessage());
//            } catch (RuntimeException e) {
//                System.err.println("Error while starting Kafka Streams: " + e.getMessage());
//            }
//        };
//        Thread kafkaStreamsThread = new Thread(kafkaStreamsTask);
//        kafkaStreamsThread.start();
//        Chung
        return streams;
        // cach thu 2

// Cách đầu tiên
//        try {
//            KafkaStreams streams = new KafkaStreams(topology, proTK);
//            streams.start();
//            Thread.sleep(15000); //thực chất không cần, nhưng cái dit con me no cai nay2 phai chay het thi moi bat dau gui email
//            Runtime.getRuntime().addShutdownHook(new Thread(streams::close));
//            return streams;
//        } catch (RuntimeException e) {
//            System.err.println(e.getMessage());
//            throw e;
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
    }
}
