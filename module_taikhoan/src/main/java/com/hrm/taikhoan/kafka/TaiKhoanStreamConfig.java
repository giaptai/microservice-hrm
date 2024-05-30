package com.hrm.taikhoan.kafka;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hrm.taikhoan.dto.mapper.MapperTaiKhoan;
import com.hrm.taikhoan.dto.resopnse.QuenMatKhau;
import com.hrm.taikhoan.dto.resopnse.ResTaiKhoan;
import com.hrm.taikhoan.models.TaiKhoan;
import com.hrm.taikhoan.repository.TaiKhoanRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.apache.kafka.clients.CommonClientConfigs;
import org.apache.kafka.common.config.SaslConfigs;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.Topology;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.Produced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Async;

import java.util.Properties;
import java.util.concurrent.CompletableFuture;

@Configuration
@Getter
@Setter
@RequiredArgsConstructor
public class TaiKhoanStreamConfig {
    private final String BOOTSTRAP_SERVER = "localhost:9092";
    //    StreamsBuilder builder = new StreamsBuilder();;
//    KStream<String, String> source;
    final ObjectMapper objectMapper = new ObjectMapper();
    final TaiKhoanRepository taiKhoanRepository;
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


    @Bean
//    @Async
    public KafkaStreams taiKhoanStreams() {
        Properties proTK = new Properties();
        proTK.setProperty(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, BOOTSTRAP_SERVER);
        proTK.setProperty(StreamsConfig.APPLICATION_ID_CONFIG, "tai_khoan_id");
        proTK.setProperty(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.String().getClass().getName());
        proTK.setProperty(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, Serdes.String().getClass().getName());
        proTK.put(CommonClientConfigs.SECURITY_PROTOCOL_CONFIG, "SASL_PLAINTEXT");
        proTK.put(SaslConfigs.SASL_MECHANISM, "PLAIN");
        proTK.put(SaslConfigs.SASL_JAAS_CONFIG, "org.apache.kafka.common.security.plain.PlainLoginModule required username=\"admin\" password=\"admin-secret\";");
        StreamsBuilder builder = new StreamsBuilder();
        KStream<String, String> source = builder.stream("tai_khoan");
        KStream<String, String> processedStream = source.mapValues(value -> {
            try {
                JsonNode rootNode = objectMapper.readTree(value);
                JsonNode payloadNode = rootNode.get("payload").get("email");
                System.err.println(payloadNode.asText());
                TaiKhoan taiKhoan = taiKhoanRepository.findByEmailContaining(payloadNode.asText());
                QuenMatKhau matKhau = new QuenMatKhau(taiKhoan.getEmail(), taiKhoan.getUsername(), taiKhoan.getPassword());
                return matKhau.toString();
            } catch (Exception e) {
                System.err.println("Failed to process record: " + e.getMessage());
                return null;
            }
        });
        processedStream.to("send_mail", Produced.with(Serdes.String(), Serdes.String()));
        Topology topology = builder.build();
        try {
            KafkaStreams streams = new KafkaStreams(topology, proTK);
            streams.start();
            Thread.sleep(15000); //thực chất không cần, nhưng cái dit con me no cai nay2 phai chay het thi moi bat dau gui email
            Runtime.getRuntime().addShutdownHook(new Thread(streams::close));
            return streams;
//            return CompletableFuture.completedFuture(streams);
        } catch (RuntimeException e) {
            System.err.println(e.getMessage());
            throw e;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
