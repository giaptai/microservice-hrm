package com.hrm.hoso_chitiet.kafka;

import com.hrm.hoso_chitiet.dto.response.ResKyLuat;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.apache.kafka.clients.CommonClientConfigs;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.config.SaslConfigs;
import org.apache.kafka.common.serialization.StringSerializer;
import org.apache.kafka.connect.data.Struct;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.Properties;

@Component
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class KafkaProducerConfig {
    final String BOOTSTRAP_SERVER = "localhost:9092";

    public KafkaProducerConfig() {
    }

    @Bean
    public KafkaProducer<String, Struct> kyLuatProducer() {
        Properties proKyLuat = new Properties();
        proKyLuat.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, BOOTSTRAP_SERVER);
        proKyLuat.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        proKyLuat.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, ResKyLuat.ResKyLuatChuanSerializer.class.getName());
        proKyLuat.put(CommonClientConfigs.SECURITY_PROTOCOL_CONFIG, "SASL_PLAINTEXT");
        proKyLuat.put(SaslConfigs.SASL_MECHANISM, "PLAIN");
        proKyLuat.put(SaslConfigs.SASL_JAAS_CONFIG, "org.apache.kafka.common.security.plain.PlainLoginModule required username=\"admin\" password=\"admin-secret\";");
        return new KafkaProducer<>(proKyLuat);
        //        proKyLuat.put(CommonClientConfigs.SECURITY_PROTOCOL_CONFIG, "SSL");
//        proKyLuat.put(SslConfigs.SSL_KEYSTORE_LOCATION_CONFIG, "\\\\wsl.localhost\\Ubuntu\\home\\macmkay\\kafka\\security\\tls\\server.keystore.jks");
//        proKyLuat.put(SslConfigs.SSL_KEYSTORE_PASSWORD_CONFIG, "test1234");
//        proKyLuat.put(SslConfigs.SSL_TRUSTSTORE_LOCATION_CONFIG, "\\\\wsl.localhost\\Ubuntu\\home\\macmkay\\kafka\\security\\tls\\server.truststore.jks");
//        proKyLuat.put(SslConfigs.SSL_TRUSTSTORE_PASSWORD_CONFIG, "test1234");
//        proKyLuat.put(SslConfigs.SSL_KEY_PASSWORD_CONFIG, "test1234");
//        proKyLuat.put(SslConfigs.SSL_ENDPOINT_IDENTIFICATION_ALGORITHM_CONFIG, "");

    }

    @Bean
    public Properties KyLuatProducerConfig() {
        Properties proKyLuat = new Properties();
        proKyLuat.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, BOOTSTRAP_SERVER);
        proKyLuat.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        proKyLuat.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, ResKyLuat.ResKyLuatChuanSerializer.class.getName());
        proKyLuat.put(CommonClientConfigs.SECURITY_PROTOCOL_CONFIG, "SASL_PLAINTEXT");
        proKyLuat.put(SaslConfigs.SASL_MECHANISM, "PLAIN");
        proKyLuat.put(SaslConfigs.SASL_JAAS_CONFIG, "org.apache.kafka.common.security.plain.PlainLoginModule required username=\"admin\" password=\"admin-secret\";");
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
    public Properties KhenThuongProducerConfig() {
        Properties proKhenThuong = new Properties();
        proKhenThuong.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, BOOTSTRAP_SERVER);
        proKhenThuong.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        proKhenThuong.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        proKhenThuong.put(CommonClientConfigs.SECURITY_PROTOCOL_CONFIG, "SASL_PLAINTEXT");
        proKhenThuong.put(SaslConfigs.SASL_MECHANISM, "PLAIN");
        proKhenThuong.put(SaslConfigs.SASL_JAAS_CONFIG, "org.apache.kafka.common.security.plain.PlainLoginModule required username=\"admin\" password=\"admin-secret\";");
        return proKhenThuong;
        //        proKhenThuong.put(CommonClientConfigs.SECURITY_PROTOCOL_CONFIG, "SSL");
//        proKhenThuong.put(SslConfigs.SSL_KEYSTORE_LOCATION_CONFIG, "\\\\wsl.localhost\\Ubuntu\\home\\macmkay\\kafka\\security\\tls\\server.keystore.jks");
//        proKhenThuong.put(SslConfigs.SSL_KEYSTORE_PASSWORD_CONFIG, "test1234");
//        proKhenThuong.put(SslConfigs.SSL_TRUSTSTORE_LOCATION_CONFIG, "\\\\wsl.localhost\\Ubuntu\\home\\macmkay\\kafka\\security\\tls\\server.truststore.jks");
//        proKhenThuong.put(SslConfigs.SSL_TRUSTSTORE_PASSWORD_CONFIG, "test1234");
//        proKhenThuong.put(SslConfigs.SSL_KEY_PASSWORD_CONFIG, "test1234");
//        proKhenThuong.put(SslConfigs.SSL_ENDPOINT_IDENTIFICATION_ALGORITHM_CONFIG, "");
    }
}
