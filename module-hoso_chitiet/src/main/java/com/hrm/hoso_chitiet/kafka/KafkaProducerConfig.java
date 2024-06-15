package com.hrm.hoso_chitiet.kafka;

import com.hrm.hoso_chitiet.dto.response.ResKyLuat;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import org.apache.kafka.clients.CommonClientConfigs;
import org.apache.kafka.clients.admin.AdminClient;
import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.ListTopicsResult;
import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.config.SaslConfigs;
import org.apache.kafka.common.serialization.StringSerializer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.Collections;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.ExecutionException;

@Configuration
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class KafkaProducerConfig {
    final String BOOTSTRAP_SERVER = "localhost:9092,localhost:9094,localhost:9096";
    Properties propTopics;
    public KafkaProducerConfig() {
    }

//    @Bean
//    public KafkaProducer<String, Struct> kyLuatProducer() {
//        Properties proKyLuat = new Properties();
//        proKyLuat.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, BOOTSTRAP_SERVER);
//        proKyLuat.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
//        proKyLuat.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, ResKyLuat.ResKyLuatChuanSerializer.class.getName());
//        proKyLuat.setProperty(CommonClientConfigs.SECURITY_PROTOCOL_CONFIG, "SASL_PLAINTEXT");
//        proKyLuat.setProperty(SaslConfigs.SASL_MECHANISM, "PLAIN");
//        proKyLuat.setProperty(SaslConfigs.SASL_JAAS_CONFIG, "org.apache.kafka.common.security.plain.PlainLoginModule required username=\"admin\" password=\"admin-secret\";");
//        return new KafkaProducer<>(proKyLuat);
//    }

    @Bean
    public Properties KyLuatProducerConfig() {
        Properties proKyLuat = new Properties();
        proKyLuat.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, BOOTSTRAP_SERVER);
        proKyLuat.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        proKyLuat.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, ResKyLuat.ResKyLuatChuanSerializer.class.getName());
//        proKyLuat.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        proKyLuat.setProperty(CommonClientConfigs.SECURITY_PROTOCOL_CONFIG, "SASL_PLAINTEXT");
        proKyLuat.setProperty(SaslConfigs.SASL_MECHANISM, "PLAIN");
        proKyLuat.setProperty(SaslConfigs.SASL_JAAS_CONFIG, "org.apache.kafka.common.security.plain.PlainLoginModule required username=\"admin\" password=\"admin-secret\";");
        return proKyLuat;
        //        proKyLuat.put(CommonClientConfigs.SECURITY_PROTOCOL_CONFIG, "SSL");
//        proKyLuat.put(SslConfigs.SSL_KEYSTORE_LOCATION_CONFIG, "\\\\wsl.localhost\\Ubuntu\\home\\macmkay\\kafka\\security\\tls\\server.keystore.jks");
//        proKyLuat.put(SslConfigs.SSL_KEYSTORE_PASSWORD_CONFIG, "test1234");
//        proKyLuat.put(SslConfigs.SSL_TRUSTSTORE_LOCATION_CONFIG, "\\\\wsl.localhost\\Ubuntu\\home\\macmkay\\kafka\\security\\tls\\server.truststore.jks");
//        proKyLuat.put(SslConfigs.SSL_TRUSTSTORE_PASSWORD_CONFIG, "test1234");
//        proKyLuat.put(SslConfigs.SSL_KEY_PASSWORD_CONFIG, "test1234");
//        proKyLuat.put(SslConfigs.SSL_ENDPOINT_IDENTIFICATION_ALGORITHM_CONFIG, "");
    }

    @Bean
    public boolean createTopics() {
        Properties propTopics = new Properties();
        propTopics.setProperty(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, BOOTSTRAP_SERVER);
        propTopics.setProperty(CommonClientConfigs.SECURITY_PROTOCOL_CONFIG, "SASL_PLAINTEXT");
        propTopics.setProperty(SaslConfigs.SASL_MECHANISM, "PLAIN");
        propTopics.setProperty(SaslConfigs.SASL_JAAS_CONFIG, "org.apache.kafka.common.security.plain.PlainLoginModule required username=\"admin\" password=\"admin-secret\";");
        try (AdminClient adminClient = AdminClient.create(propTopics)) {
            ListTopicsResult topics = adminClient.listTopics();
            Set<String> topicNames = topics.names().get();
            String topicName = "ky_luat";
            Set<String> setTopics = Set.of(topicName);
            if (!topicNames.containsAll(setTopics)) {
                int numPartitions = 3;
                short replicationFactor = 3;
                NewTopic ky_luat = new NewTopic(topicName, numPartitions, replicationFactor);
                // Tạo topic
                adminClient.createTopics(Collections.singleton(ky_luat));
                System.out.println("Topic create: " + Arrays.toString(setTopics.toArray()) + " đã được tạo thành công.");
                return true;
            } else {
                System.err.println("Topic exist: " + Arrays.toString(setTopics.toArray()) + " đã tồn tại.");
                return false;
            }
        } catch (ExecutionException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
