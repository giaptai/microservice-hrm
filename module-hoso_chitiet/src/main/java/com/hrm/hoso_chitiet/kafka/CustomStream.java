//package com.hrm.hoso_chitiet.kafka;
//
//import com.fasterxml.jackson.databind.JsonNode;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.hrm.hoso_chitiet.repositories.KhenThuongRepository;
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//import org.apache.kafka.clients.CommonClientConfigs;
//import org.apache.kafka.clients.producer.ProducerConfig;
//import org.apache.kafka.common.config.SaslConfigs;
//import org.apache.kafka.common.serialization.Deserializer;
//import org.apache.kafka.common.serialization.Serdes;
//import org.apache.kafka.common.serialization.StringSerializer;
//import org.apache.kafka.streams.KafkaStreams;
//import org.apache.kafka.streams.StreamsBuilder;
//import org.apache.kafka.streams.StreamsConfig;
//import org.apache.kafka.streams.Topology;
//import org.apache.kafka.streams.kstream.KStream;
//import org.apache.kafka.streams.kstream.KTable;
//import org.apache.kafka.streams.kstream.Printed;
//import org.apache.kafka.streams.kstream.Produced;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import java.util.Properties;
//import java.util.UUID;
//
//@Configuration
//@AllArgsConstructor
//@NoArgsConstructor
//@Getter
//@Setter
//public class CustomStream {
//    private final String BOOTSTRAP_SERVER = "localhost:9092";
//    private StreamsBuilder builder = new StreamsBuilder();
//    private KStream<String, String> source;
//    private KTable<String, String> kTable;
//    private Properties props;
//    private final ObjectMapper objectMapper = new ObjectMapper();
//    private KhenThuongRepository khenThuongRepository;
//    public void KhenThuongStream() {
//        try {
//            Properties proKhenThuong = new Properties();
//            proKhenThuong.setProperty(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, BOOTSTRAP_SERVER);
//            proKhenThuong.setProperty(StreamsConfig.APPLICATION_ID_CONFIG, "khen_thuong_id");
//            proKhenThuong.setProperty(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.String().getClass().getName());
//            proKhenThuong.setProperty(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, Serdes.String().getClass().getName());
//            proKhenThuong.put(CommonClientConfigs.SECURITY_PROTOCOL_CONFIG, "SASL_PLAINTEXT");
//            proKhenThuong.put(SaslConfigs.SASL_MECHANISM, "PLAIN");
//            proKhenThuong.put(SaslConfigs.SASL_JAAS_CONFIG, "org.apache.kafka.common.security.plain.PlainLoginModule required username=\"admin\" password=\"admin-secret\";");
//            source = builder.stream("khen_thuong");
//            Topology topology = builder.build();
//            KafkaStreams streams = new KafkaStreams(topology, proKhenThuong);
//
//            streams.start();
//            // In ra dữ liệu theo định dạng đã được chỉ định
////            source.print(Printed.toSysOut());
//
////            source.foreach((key, value) -> {
////                try {
////                    JsonNode rootNode = objectMapper.readTree(value);
////                    JsonNode payloadNode = rootNode.get("payload");
////                    System.out.println("Key: " + key + ", Payload: " + payloadNode.toString());
////                } catch (Exception e) {
////                    System.err.println("Failed to process record: " + e.getMessage());
////                }
////            });
//
//            KStream<String, String> processedStream = source.mapValues(value -> {
//                try {
//                    JsonNode rootNode = objectMapper.readTree(value);
//                    JsonNode payloadNode = rootNode.get("payload").get("ho_so_id");
//                    UUID hosoId = UUID.nameUUIDFromBytes(payloadNode.binaryValue());
//                    return payloadNode.toString();
//                } catch (Exception e) {
//                    System.err.println("Failed to process record: " + e.getMessage());
//                    return null;
//                }
//            });
//
//            processedStream.to("send_mail", Produced.with(Serdes.String(), Serdes.String()));
//
//            Runtime.getRuntime().addShutdownHook(new Thread(streams::close));
//        } catch (RuntimeException e) {
//            System.err.println(e.getMessage());
//            throw e;
//        }
//    }
//
//    @Configuration
//    static class PayloadDeserializer implements Deserializer<JsonNode> {
//        private final ObjectMapper objectMapper = new ObjectMapper();
//        @Override
//        public JsonNode deserialize(String topic, byte[] data) {
//            try {
//                // Parse the JSON record
//                JsonNode rootNode = objectMapper.readTree(data);
//                // Extract the payload field
//                return rootNode.get("payload");
//            } catch (Exception e) {
//                throw new RuntimeException("Failed to deserialize record", e);
//            }
//        }
//    }
//}
